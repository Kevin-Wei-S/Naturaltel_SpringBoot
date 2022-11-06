package com.naturaltel.springboot.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.google.gson.Gson;
import com.naturaltel.springboot.pojo.DecodedTableData;
import com.naturaltel.springboot.pojo.TableData;
import com.naturaltel.springboot.repository.TableDataRepository;


@Controller
public class NaturalTel {

	@Autowired
	public TableDataRepository tableDataRepository;
	
	@GetMapping("/naturaltel")
	public String naturalTel(Model model) {
		model.addAttribute("info", "Hello NaturalTel!");
		return "naturaltel";
	}
	
	@GetMapping("/naturaltel/list")
	public String list(Model model) throws UnsupportedEncodingException {
		
		List<TableData> list = tableDataRepository.findAll();
		List<DecodedTableData> decodedList = new ArrayList<>();
		
		for(TableData data : list) {
			final Base64.Decoder decoder = Base64.getDecoder();
			Gson gson = new Gson();
			String str = data.getcBase64();
			String decodeStr = new String(decoder.decode(str), "UTF-8");
			Map jsonToMap = gson.fromJson(decodeStr, Map.class);
			decodedList.add(new DecodedTableData(data.getIdx(), (String)jsonToMap.get("key"),
								(String)jsonToMap.get("value")));
			
		}
		
		model.addAttribute("list", decodedList);
		return "naturaltel";
	}
	
	@PostMapping("/naturaltel/add")
	public String addData(DecodedTableData data) {
		Map<Object,Object> map = new LinkedHashMap<>();
		map.put("key", data.getKey());
		map.put("value", data.getValue());
		Gson gson = new Gson();
		String mapToJson = gson.toJson(map);
		final Base64.Encoder encoder = Base64.getEncoder();
		byte[] bytes = mapToJson.getBytes();
		String encodedJson = encoder.encodeToString(bytes);
		
		tableDataRepository.save(new TableData(null, null, encodedJson));
		
		return "redirect:/naturaltel/list";
	}
	
}
