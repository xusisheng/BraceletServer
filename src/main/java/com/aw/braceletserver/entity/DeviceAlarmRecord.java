package com.aw.braceletserver.entity;

import java.math.BigDecimal;
import java.util.Date;

public class DeviceAlarmRecord {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column device_alarm_record.id
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column device_alarm_record.user_id
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	private Integer userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column device_alarm_record.device_id
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	private Integer deviceId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column device_alarm_record.serial_number
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	private String serialNumber;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column device_alarm_record.alarm_name
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	private String alarmName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column device_alarm_record.alarm_content
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	private String alarmContent;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column device_alarm_record.alarm_type
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	private Integer alarmType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column device_alarm_record.create_time
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	private Date createTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column device_alarm_record.is_delete
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	private Integer isDelete;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column device_alarm_record.latitude
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	private BigDecimal latitude;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column device_alarm_record.longitude
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	private BigDecimal longitude;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column device_alarm_record.address
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	private String address;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column device_alarm_record.device_name
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	private String deviceName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column device_alarm_record.model_name
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	private String modelName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column device_alarm_record.nickname
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	private String nickname;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column device_alarm_record.avatar
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	private String avatar;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column device_alarm_record.geo_fence_id
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	private Integer geoFenceId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column device_alarm_record.geo_name
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	private String geoName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column device_alarm_record.fence_no
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	private Integer fenceNo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column device_alarm_record.olat
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	private BigDecimal olat;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column device_alarm_record.olng
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	private BigDecimal olng;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column device_alarm_record.altitude
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	private Float altitude;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column device_alarm_record.battery
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	private Integer battery;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column device_alarm_record.id
	 * @return  the value of device_alarm_record.id
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column device_alarm_record.id
	 * @param id  the value for device_alarm_record.id
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column device_alarm_record.user_id
	 * @return  the value of device_alarm_record.user_id
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column device_alarm_record.user_id
	 * @param userId  the value for device_alarm_record.user_id
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column device_alarm_record.device_id
	 * @return  the value of device_alarm_record.device_id
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public Integer getDeviceId() {
		return deviceId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column device_alarm_record.device_id
	 * @param deviceId  the value for device_alarm_record.device_id
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column device_alarm_record.serial_number
	 * @return  the value of device_alarm_record.serial_number
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column device_alarm_record.serial_number
	 * @param serialNumber  the value for device_alarm_record.serial_number
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column device_alarm_record.alarm_name
	 * @return  the value of device_alarm_record.alarm_name
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public String getAlarmName() {
		return alarmName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column device_alarm_record.alarm_name
	 * @param alarmName  the value for device_alarm_record.alarm_name
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public void setAlarmName(String alarmName) {
		this.alarmName = alarmName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column device_alarm_record.alarm_content
	 * @return  the value of device_alarm_record.alarm_content
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public String getAlarmContent() {
		return alarmContent;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column device_alarm_record.alarm_content
	 * @param alarmContent  the value for device_alarm_record.alarm_content
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public void setAlarmContent(String alarmContent) {
		this.alarmContent = alarmContent;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column device_alarm_record.alarm_type
	 * @return  the value of device_alarm_record.alarm_type
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public Integer getAlarmType() {
		return alarmType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column device_alarm_record.alarm_type
	 * @param alarmType  the value for device_alarm_record.alarm_type
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public void setAlarmType(Integer alarmType) {
		this.alarmType = alarmType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column device_alarm_record.create_time
	 * @return  the value of device_alarm_record.create_time
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column device_alarm_record.create_time
	 * @param createTime  the value for device_alarm_record.create_time
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column device_alarm_record.is_delete
	 * @return  the value of device_alarm_record.is_delete
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public Integer getIsDelete() {
		return isDelete;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column device_alarm_record.is_delete
	 * @param isDelete  the value for device_alarm_record.is_delete
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column device_alarm_record.latitude
	 * @return  the value of device_alarm_record.latitude
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public BigDecimal getLatitude() {
		return latitude;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column device_alarm_record.latitude
	 * @param latitude  the value for device_alarm_record.latitude
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column device_alarm_record.longitude
	 * @return  the value of device_alarm_record.longitude
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public BigDecimal getLongitude() {
		return longitude;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column device_alarm_record.longitude
	 * @param longitude  the value for device_alarm_record.longitude
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column device_alarm_record.address
	 * @return  the value of device_alarm_record.address
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column device_alarm_record.address
	 * @param address  the value for device_alarm_record.address
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column device_alarm_record.device_name
	 * @return  the value of device_alarm_record.device_name
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public String getDeviceName() {
		return deviceName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column device_alarm_record.device_name
	 * @param deviceName  the value for device_alarm_record.device_name
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column device_alarm_record.model_name
	 * @return  the value of device_alarm_record.model_name
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column device_alarm_record.model_name
	 * @param modelName  the value for device_alarm_record.model_name
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column device_alarm_record.nickname
	 * @return  the value of device_alarm_record.nickname
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column device_alarm_record.nickname
	 * @param nickname  the value for device_alarm_record.nickname
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column device_alarm_record.avatar
	 * @return  the value of device_alarm_record.avatar
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column device_alarm_record.avatar
	 * @param avatar  the value for device_alarm_record.avatar
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column device_alarm_record.geo_fence_id
	 * @return  the value of device_alarm_record.geo_fence_id
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public Integer getGeoFenceId() {
		return geoFenceId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column device_alarm_record.geo_fence_id
	 * @param geoFenceId  the value for device_alarm_record.geo_fence_id
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public void setGeoFenceId(Integer geoFenceId) {
		this.geoFenceId = geoFenceId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column device_alarm_record.geo_name
	 * @return  the value of device_alarm_record.geo_name
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public String getGeoName() {
		return geoName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column device_alarm_record.geo_name
	 * @param geoName  the value for device_alarm_record.geo_name
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public void setGeoName(String geoName) {
		this.geoName = geoName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column device_alarm_record.fence_no
	 * @return  the value of device_alarm_record.fence_no
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public Integer getFenceNo() {
		return fenceNo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column device_alarm_record.fence_no
	 * @param fenceNo  the value for device_alarm_record.fence_no
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public void setFenceNo(Integer fenceNo) {
		this.fenceNo = fenceNo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column device_alarm_record.olat
	 * @return  the value of device_alarm_record.olat
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public BigDecimal getOlat() {
		return olat;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column device_alarm_record.olat
	 * @param olat  the value for device_alarm_record.olat
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public void setOlat(BigDecimal olat) {
		this.olat = olat;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column device_alarm_record.olng
	 * @return  the value of device_alarm_record.olng
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public BigDecimal getOlng() {
		return olng;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column device_alarm_record.olng
	 * @param olng  the value for device_alarm_record.olng
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public void setOlng(BigDecimal olng) {
		this.olng = olng;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column device_alarm_record.altitude
	 * @return  the value of device_alarm_record.altitude
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public Float getAltitude() {
		return altitude;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column device_alarm_record.altitude
	 * @param altitude  the value for device_alarm_record.altitude
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public void setAltitude(Float altitude) {
		this.altitude = altitude;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column device_alarm_record.battery
	 * @return  the value of device_alarm_record.battery
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public Integer getBattery() {
		return battery;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column device_alarm_record.battery
	 * @param battery  the value for device_alarm_record.battery
	 * @mbg.generated  Thu Dec 12 08:51:35 CST 2019
	 */
	public void setBattery(Integer battery) {
		this.battery = battery;
	}
}