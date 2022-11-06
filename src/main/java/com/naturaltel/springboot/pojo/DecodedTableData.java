package com.naturaltel.springboot.pojo;

public class DecodedTableData {

	private Integer idx;
	private String key;
	private String value;
	
	public DecodedTableData() {
		super();
	}

	public DecodedTableData(Integer idx, String key, String value) {
		super();
		this.idx = idx;
		this.key = key;
		this.value = value;
	}



	public Integer getIdx() {
		return idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "DecodedTableData [idx=" + idx + ", key=" + key + ", value=" + value + "]";
	}
	
	
	
}
