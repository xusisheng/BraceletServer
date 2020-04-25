package com.aw.braceletserver.entity;

public class UnifyRequest<T> extends BaseEntity {
	public T params;

	public T getParams() {
		return params;
	}

	public void setParams(T params) {
		this.params = params;
	}
}
