package com.aw.braceletserver.entity;

import com.aw.braceletserver.constants.ResultInfoType;

public class UnifyResponse<T> extends BaseEntity {

	/* 返回状态 */
	private int errorcode;
	/* 返回信息 */
	public String description;
	/* 数据 */
	public T result;

	public UnifyResponse() {
		ResultInfoType res = ResultInfoType.RESULT_SUCCESS;
		errorcode = res.getResultcode();
		description = res.getResultInfo();
		result = null;
	}

	public int getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}

	/**
	 * 设置返回值
	 *
	 * @param res 返回信息数组
	 */
//	public void setResult(ResultInfoType res) {
//		errorcode = res.getResultcode();
//		description = res.getResultInfo();
//	}

	/**
	 * 设置返回状态及信息
	 * @param status 返回状态
	 * @param msg 返回信息
	 */
//	public void setResult(int status, String msg) {
//		this.errorcode = status;
//		this.description = msg;
//	}

}
