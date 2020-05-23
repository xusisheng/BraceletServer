package com.aw.braceletserver.entity;

public class UnifyResponse<T> extends BaseEntity {
	private static final int CODE_SUCCESS = 0;
	private static final String MSG_SUCCESS = "Success";
	private static final int CODE_FAIL = -1;
	private static final String MSG_FAIL = "Failed";

	public static UnifyResponse success() {
		return new UnifyResponse(CODE_SUCCESS, MSG_SUCCESS);
	}

	public static <T> UnifyResponse<T> success(T data) {
		return new UnifyResponse<T>(CODE_SUCCESS, MSG_SUCCESS, data);
	}

	public static <T> UnifyResponse<T> success(String message) {
		return new UnifyResponse<T>(CODE_SUCCESS, MSG_SUCCESS, message);
	}

	public static UnifyResponse failed() {
		return new UnifyResponse(CODE_FAIL, MSG_FAIL);
	}

	public static <T> UnifyResponse<T> failed(String message) {
		return new UnifyResponse<T>(CODE_FAIL, MSG_FAIL, message);
	}

	/* 返回状态 */
	private int errorcode;
	/* 返回信息 */
	public String description;
	/* 错误消息 */
	public String message;
	/* 数据 */
	public T result;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	public UnifyResponse() {}

	public UnifyResponse(int errorcode, String description) {
		this.errorcode = errorcode;
		this.description = description;
	}

	public UnifyResponse(int errorcode, String description, T result) {
		this.errorcode = errorcode;
		this.description = description;
		this.result = result;
	}

	public UnifyResponse(int errorcode, String description, String message) {
		this.errorcode = errorcode;
		this.description = description;
		this.message = message;
	}
}
