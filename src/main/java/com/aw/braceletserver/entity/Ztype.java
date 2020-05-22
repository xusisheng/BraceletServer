package com.aw.braceletserver.entity;

import java.io.Serializable;

public class Ztype implements Serializable{
	/**
	 */
	private static final long serialVersionUID = 1L;

	private String typeName;
	
	private String typeCode;
	
	private int typeNum;

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getTypeNum() {
		return typeNum;
	}

	public void setTypeNum(int typeNum) {
		this.typeNum = typeNum;
	}
}
