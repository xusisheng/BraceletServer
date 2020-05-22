package com.aw.braceletserver.service;

import com.aw.braceletserver.entity.CacheVo;

import java.util.List;

/**
 * 缓存接口
 * 2019年4月1
 */
public interface CacheService {

	/**
	 * 保存数据到缓存中
	 * @param cacheVo
	 */
	public void add(CacheVo cacheVo);

	/**
	 * 根据KEY获取缓存数据
	 * @param key
	 * @return
	 */
	public CacheVo get(String key);
	
	
	public void set(String key, String value, int seconds);
	
	public String getValue(String key);

	/**
	 * 删除缓存数据
	 * @param key
	 */
	public void delete(String key);
	
	/**
	 * 按缓存KEY值前缀删除
	 */
	public void deleteByKeyPrefix(String keyPrefix);

	/**
	 * 清除缓存中所有数据
	 */
	public void clear();

	/**
	 * 按缓存KEY值前缀查询
	 */
	public List<CacheVo> query(String keyPrefix);

}
