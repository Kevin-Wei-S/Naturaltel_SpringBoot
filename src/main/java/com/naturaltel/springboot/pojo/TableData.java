package com.naturaltel.springboot.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="table1")
public class TableData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idx;
	@Column(name = "c_aes256")
	private String cAes256;
	@Column(name = "c_base64")
	private String cBase64;
	
	public TableData() {
		
	}
	
	public TableData(Integer idx, String cAes256, String cBase64) {
		super();
		this.idx = idx;
		this.cAes256 = cAes256;
		this.cBase64 = cBase64;
	}

	public Integer getIdx() {
		return idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public String getcAes256() {
		return cAes256;
	}

	public void setcAes256(String cAes256) {
		this.cAes256 = cAes256;
	}

	public String getcBase64() {
		return cBase64;
	}

	public void setcBase64(String cBase64) {
		this.cBase64 = cBase64;
	}

	@Override
	public String toString() {
		return "TableData [idx=" + idx + ", cAes256=" + cAes256 + ", cBase64=" + cBase64 + "]";
	}

	
}
