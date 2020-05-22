package com.aw.braceletserver.entity;

import java.io.Serializable;

/**
 * 缓存基础对象
 * @date 2019年4月1日
 */
@SuppressWarnings("serial")
public class CacheVo implements Serializable {

	/** KEY */
	private String key;

	/** 值 */
	private Object value;

	/** 有效期(秒) */
	private Long timeout;

	/** 描述信息 */
	private String des;

	public CacheVo() {
		super();
	}

	public CacheVo(String key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}

	public CacheVo(String key, Object value, Long timeout) {
		super();
		this.key = key;
		this.value = value;
		this.timeout = timeout;
	}

	public CacheVo(String key, Object value, Long timeout, String des) {
		super();
		this.key = key;
		this.value = value;
		this.timeout = timeout;
		this.des = des;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Long getTimeout() {
		return timeout;
	}

	public void setTimeout(Long timeout) {
		this.timeout = timeout;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	@Override
	public String toString() {
		return "CacheVo [key=" + key + ", timeout="
				+ timeout + ", des=" + des + "]";
	}
}
