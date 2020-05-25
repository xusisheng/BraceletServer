package com.aw.braceletserver.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class JsonMapper {
	private static final Logger logger = LoggerFactory.getLogger(JsonMapper.class);
	private static ObjectMapper mapper;
	static {
		mapper = new ObjectMapper();
		mapper.getSerializationConfig().setSerializationInclusion(Inclusion.NON_NULL);
		mapper.getSerializationConfig().disable(Feature.WRITE_NULL_MAP_VALUES);
		//mapper.enableDefaultTyping(DefaultTyping.NON_FINAL);
	}

	/**
	 * 从任意java对象转换到json字符串
	 *
	 * @param object
	 *            待转换的java对象
	 * @return json字符串
	 */
	public static String toJson(Object object) {
		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(object);
		} catch (Exception ex) {
			logger.error("from object to JSON error", ex);
		}
		return jsonString;
	}

	/**
	 * 将json字符串转换为指定的java对象，不包括泛型的集合类
	 *
	 * @param json
	 *            json字符串
	 * @param clazz
	 *            转换java目标类
	 * @return
	 */
	public static <T> T toObject(String json, Class<T> clazz) {
		T object = null;
		try {
			object = mapper.readValue(json, clazz);
			return object;
		} catch (Exception ex) {
			logger.error("from json to Object error", ex);
		}
		return object;
	}

	@SuppressWarnings("unchecked")
	public static <T> T toObject(String json, TypeReference<T> typeReference) {
		T object = null;
		try {
			object = (T) mapper.readValue(json, typeReference);
		} catch (Exception ex) {
			logger.error("from json to Object error", ex);
		}
		return object;
	}

	/**
	 * Method that will convert from given value into instance of given value
	 * type.
	 *
	 * @param fromValue
	 * @param toValueType
	 * @return
	 * @throws
	 */
	private static <T> T convertValue(Object fromValue, Class<T> toValueType)
			throws Exception {
		try {
			return mapper.convertValue(fromValue, toValueType);
		} catch (IllegalArgumentException e) {
			throw new Exception(e);
		}
	}

	/**
	 * Method that will convert object to the ObjectNode.
	 *
	 * @param object
	 *            the source data; if null, will return null.
	 * @return the ObjectNode data after converted.
	 * @throws
	 */
	public static <T> ObjectNode convertObject2ObjectNode(T object)
			throws Exception {
		if (null == object) {
			return null;
		}

		ObjectNode objectNode = null;

		if (object instanceof String) {
			objectNode = toObject((String) object,
					ObjectNode.class);
		} else {
			objectNode = convertValue(object, ObjectNode.class);
		}

		return objectNode;
	}


	/**
	 * 将json字符串转换为java.util.Map,键值类型都为java.lang.String
	 *
	 * @param json
	 * @return
	 */
	public static Map<String, String> toMap(String json) {
		return toObject(json, new TypeReference<Map<String, String>>() {
		});
	}

	/**
	 * 将json字符串转换为java.util.Map实例，键为java.lang.String,值为java.lang.Object
	 *
	 * @param json
	 *            json字符串
	 * @return
	 */
	public static Map<String, Object> toObjectMap(String json) {
		return toObject(json, new TypeReference<Map<String, Object>>() {
		});
	}

	/**
	 * 转换为指定键值类型的泛型java.util.Map实例
	 *
	 * @param json
	 *            json字符串
	 * @param k
	 *            键目标类
	 * @param v
	 *            值目标类
	 * @return
	 */
	public static <K, V> Map<K, V> toGenericMap(String json, Class<K> k, Class<V> v) {
		return toObject(json, new TypeReference<Map<K, V>>() {
		});
	}

	@SuppressWarnings("rawtypes")
	public static <T> Collection<T> toCollection(String json, Class<? extends Collection> collectionType,
			Class<T> elementType) {
		try {
			return mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(collectionType, elementType));
		} catch (Exception ex) {
			logger.error("from json to collection error", ex);
		}
		return null;
	}

	public static <T> List<T> toList(String json, Class<T> t) {
		return (List<T>) toCollection(json, ArrayList.class, t);
	}

	public static ObjectMapper getMapper() {
		return mapper;
	}
}
