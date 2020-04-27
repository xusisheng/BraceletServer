package com.aw.braceletserver.entity;

public class UnifyResponse<T> extends BaseEntity {
	private static final int CODE_SUCCESS = 0;
	private static final String MSG_SUCCESS = "Success";
	private static final int CODE_FAIL = -1;
	private static final String MSG_FAIL = "Failed";
	private static final int CODE_ERROR = 500;
	private static final String MSG_ERROR = "Error";

	/* 返回状态 */
	private int errorcode;
	/* 返回信息 */
	public String description;
	/* 数据 */
	public T result;

	public UnifyResponse() {}

	public UnifyResponse(int errorcode, String description, T result) {
		this.errorcode = errorcode;
		this.description = description;
		this.result = result;
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

	public static <T> UnifyResponse<T> success() {
		return new UnifyResponse<T>(CODE_SUCCESS, MSG_SUCCESS, null);
	}

	public static <T> UnifyResponse<T> success(T data) {
		return new UnifyResponse<T>(CODE_SUCCESS, MSG_SUCCESS, data);
	}

	public static <T> UnifyResponse<T> failed() {
		return new UnifyResponse<T>(CODE_FAIL, MSG_FAIL, null);
	}
}
