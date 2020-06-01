package com.aw.bracelet.entity;

public class RespGetInfo<T> extends BaseEntity {

	/* 返回状态 */
	private int code;
	/* 数据 */
	public T result;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
}
