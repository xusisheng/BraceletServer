package com.aw.bracelet.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DevicePositionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DevicePositionExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNull() {
            addCriterion("device_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("device_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(Long value) {
            addCriterion("device_id =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(Long value) {
            addCriterion("device_id <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(Long value) {
            addCriterion("device_id >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("device_id >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(Long value) {
            addCriterion("device_id <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(Long value) {
            addCriterion("device_id <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<Long> values) {
            addCriterion("device_id in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<Long> values) {
            addCriterion("device_id not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(Long value1, Long value2) {
            addCriterion("device_id between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(Long value1, Long value2) {
            addCriterion("device_id not between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andIdcodeIsNull() {
            addCriterion("idcode is null");
            return (Criteria) this;
        }

        public Criteria andIdcodeIsNotNull() {
            addCriterion("idcode is not null");
            return (Criteria) this;
        }

        public Criteria andIdcodeEqualTo(String value) {
            addCriterion("idcode =", value, "idcode");
            return (Criteria) this;
        }

        public Criteria andIdcodeNotEqualTo(String value) {
            addCriterion("idcode <>", value, "idcode");
            return (Criteria) this;
        }

        public Criteria andIdcodeGreaterThan(String value) {
            addCriterion("idcode >", value, "idcode");
            return (Criteria) this;
        }

        public Criteria andIdcodeGreaterThanOrEqualTo(String value) {
            addCriterion("idcode >=", value, "idcode");
            return (Criteria) this;
        }

        public Criteria andIdcodeLessThan(String value) {
            addCriterion("idcode <", value, "idcode");
            return (Criteria) this;
        }

        public Criteria andIdcodeLessThanOrEqualTo(String value) {
            addCriterion("idcode <=", value, "idcode");
            return (Criteria) this;
        }

        public Criteria andIdcodeLike(String value) {
            addCriterion("idcode like", value, "idcode");
            return (Criteria) this;
        }

        public Criteria andIdcodeNotLike(String value) {
            addCriterion("idcode not like", value, "idcode");
            return (Criteria) this;
        }

        public Criteria andIdcodeIn(List<String> values) {
            addCriterion("idcode in", values, "idcode");
            return (Criteria) this;
        }

        public Criteria andIdcodeNotIn(List<String> values) {
            addCriterion("idcode not in", values, "idcode");
            return (Criteria) this;
        }

        public Criteria andIdcodeBetween(String value1, String value2) {
            addCriterion("idcode between", value1, value2, "idcode");
            return (Criteria) this;
        }

        public Criteria andIdcodeNotBetween(String value1, String value2) {
            addCriterion("idcode not between", value1, value2, "idcode");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUptimeIsNull() {
            addCriterion("uptime is null");
            return (Criteria) this;
        }

        public Criteria andUptimeIsNotNull() {
            addCriterion("uptime is not null");
            return (Criteria) this;
        }

        public Criteria andUptimeEqualTo(Date value) {
            addCriterion("uptime =", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeNotEqualTo(Date value) {
            addCriterion("uptime <>", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeGreaterThan(Date value) {
            addCriterion("uptime >", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeGreaterThanOrEqualTo(Date value) {
            addCriterion("uptime >=", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeLessThan(Date value) {
            addCriterion("uptime <", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeLessThanOrEqualTo(Date value) {
            addCriterion("uptime <=", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeIn(List<Date> values) {
            addCriterion("uptime in", values, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeNotIn(List<Date> values) {
            addCriterion("uptime not in", values, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeBetween(Date value1, Date value2) {
            addCriterion("uptime between", value1, value2, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeNotBetween(Date value1, Date value2) {
            addCriterion("uptime not between", value1, value2, "uptime");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIsNull() {
            addCriterion("message_type is null");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIsNotNull() {
            addCriterion("message_type is not null");
            return (Criteria) this;
        }

        public Criteria andMessageTypeEqualTo(String value) {
            addCriterion("message_type =", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNotEqualTo(String value) {
            addCriterion("message_type <>", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeGreaterThan(String value) {
            addCriterion("message_type >", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeGreaterThanOrEqualTo(String value) {
            addCriterion("message_type >=", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeLessThan(String value) {
            addCriterion("message_type <", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeLessThanOrEqualTo(String value) {
            addCriterion("message_type <=", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeLike(String value) {
            addCriterion("message_type like", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNotLike(String value) {
            addCriterion("message_type not like", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIn(List<String> values) {
            addCriterion("message_type in", values, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNotIn(List<String> values) {
            addCriterion("message_type not in", values, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeBetween(String value1, String value2) {
            addCriterion("message_type between", value1, value2, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNotBetween(String value1, String value2) {
            addCriterion("message_type not between", value1, value2, "messageType");
            return (Criteria) this;
        }

        public Criteria andLocateModeIsNull() {
            addCriterion("locate_mode is null");
            return (Criteria) this;
        }

        public Criteria andLocateModeIsNotNull() {
            addCriterion("locate_mode is not null");
            return (Criteria) this;
        }

        public Criteria andLocateModeEqualTo(Integer value) {
            addCriterion("locate_mode =", value, "locateMode");
            return (Criteria) this;
        }

        public Criteria andLocateModeNotEqualTo(Integer value) {
            addCriterion("locate_mode <>", value, "locateMode");
            return (Criteria) this;
        }

        public Criteria andLocateModeGreaterThan(Integer value) {
            addCriterion("locate_mode >", value, "locateMode");
            return (Criteria) this;
        }

        public Criteria andLocateModeGreaterThanOrEqualTo(Integer value) {
            addCriterion("locate_mode >=", value, "locateMode");
            return (Criteria) this;
        }

        public Criteria andLocateModeLessThan(Integer value) {
            addCriterion("locate_mode <", value, "locateMode");
            return (Criteria) this;
        }

        public Criteria andLocateModeLessThanOrEqualTo(Integer value) {
            addCriterion("locate_mode <=", value, "locateMode");
            return (Criteria) this;
        }

        public Criteria andLocateModeIn(List<Integer> values) {
            addCriterion("locate_mode in", values, "locateMode");
            return (Criteria) this;
        }

        public Criteria andLocateModeNotIn(List<Integer> values) {
            addCriterion("locate_mode not in", values, "locateMode");
            return (Criteria) this;
        }

        public Criteria andLocateModeBetween(Integer value1, Integer value2) {
            addCriterion("locate_mode between", value1, value2, "locateMode");
            return (Criteria) this;
        }

        public Criteria andLocateModeNotBetween(Integer value1, Integer value2) {
            addCriterion("locate_mode not between", value1, value2, "locateMode");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(BigDecimal value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(BigDecimal value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(BigDecimal value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(BigDecimal value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<BigDecimal> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<BigDecimal> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(BigDecimal value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(BigDecimal value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(BigDecimal value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(BigDecimal value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<BigDecimal> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<BigDecimal> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeIsNull() {
            addCriterion("altitude is null");
            return (Criteria) this;
        }

        public Criteria andAltitudeIsNotNull() {
            addCriterion("altitude is not null");
            return (Criteria) this;
        }

        public Criteria andAltitudeEqualTo(BigDecimal value) {
            addCriterion("altitude =", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeNotEqualTo(BigDecimal value) {
            addCriterion("altitude <>", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeGreaterThan(BigDecimal value) {
            addCriterion("altitude >", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("altitude >=", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeLessThan(BigDecimal value) {
            addCriterion("altitude <", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("altitude <=", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeIn(List<BigDecimal> values) {
            addCriterion("altitude in", values, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeNotIn(List<BigDecimal> values) {
            addCriterion("altitude not in", values, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("altitude between", value1, value2, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("altitude not between", value1, value2, "altitude");
            return (Criteria) this;
        }

        public Criteria andAtmosphereIsNull() {
            addCriterion("atmosphere is null");
            return (Criteria) this;
        }

        public Criteria andAtmosphereIsNotNull() {
            addCriterion("atmosphere is not null");
            return (Criteria) this;
        }

        public Criteria andAtmosphereEqualTo(BigDecimal value) {
            addCriterion("atmosphere =", value, "atmosphere");
            return (Criteria) this;
        }

        public Criteria andAtmosphereNotEqualTo(BigDecimal value) {
            addCriterion("atmosphere <>", value, "atmosphere");
            return (Criteria) this;
        }

        public Criteria andAtmosphereGreaterThan(BigDecimal value) {
            addCriterion("atmosphere >", value, "atmosphere");
            return (Criteria) this;
        }

        public Criteria andAtmosphereGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("atmosphere >=", value, "atmosphere");
            return (Criteria) this;
        }

        public Criteria andAtmosphereLessThan(BigDecimal value) {
            addCriterion("atmosphere <", value, "atmosphere");
            return (Criteria) this;
        }

        public Criteria andAtmosphereLessThanOrEqualTo(BigDecimal value) {
            addCriterion("atmosphere <=", value, "atmosphere");
            return (Criteria) this;
        }

        public Criteria andAtmosphereIn(List<BigDecimal> values) {
            addCriterion("atmosphere in", values, "atmosphere");
            return (Criteria) this;
        }

        public Criteria andAtmosphereNotIn(List<BigDecimal> values) {
            addCriterion("atmosphere not in", values, "atmosphere");
            return (Criteria) this;
        }

        public Criteria andAtmosphereBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("atmosphere between", value1, value2, "atmosphere");
            return (Criteria) this;
        }

        public Criteria andAtmosphereNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("atmosphere not between", value1, value2, "atmosphere");
            return (Criteria) this;
        }

        public Criteria andBatteryIsNull() {
            addCriterion("battery is null");
            return (Criteria) this;
        }

        public Criteria andBatteryIsNotNull() {
            addCriterion("battery is not null");
            return (Criteria) this;
        }

        public Criteria andBatteryEqualTo(Integer value) {
            addCriterion("battery =", value, "battery");
            return (Criteria) this;
        }

        public Criteria andBatteryNotEqualTo(Integer value) {
            addCriterion("battery <>", value, "battery");
            return (Criteria) this;
        }

        public Criteria andBatteryGreaterThan(Integer value) {
            addCriterion("battery >", value, "battery");
            return (Criteria) this;
        }

        public Criteria andBatteryGreaterThanOrEqualTo(Integer value) {
            addCriterion("battery >=", value, "battery");
            return (Criteria) this;
        }

        public Criteria andBatteryLessThan(Integer value) {
            addCriterion("battery <", value, "battery");
            return (Criteria) this;
        }

        public Criteria andBatteryLessThanOrEqualTo(Integer value) {
            addCriterion("battery <=", value, "battery");
            return (Criteria) this;
        }

        public Criteria andBatteryIn(List<Integer> values) {
            addCriterion("battery in", values, "battery");
            return (Criteria) this;
        }

        public Criteria andBatteryNotIn(List<Integer> values) {
            addCriterion("battery not in", values, "battery");
            return (Criteria) this;
        }

        public Criteria andBatteryBetween(Integer value1, Integer value2) {
            addCriterion("battery between", value1, value2, "battery");
            return (Criteria) this;
        }

        public Criteria andBatteryNotBetween(Integer value1, Integer value2) {
            addCriterion("battery not between", value1, value2, "battery");
            return (Criteria) this;
        }

        public Criteria andHeartBeatIsNull() {
            addCriterion("heart_beat is null");
            return (Criteria) this;
        }

        public Criteria andHeartBeatIsNotNull() {
            addCriterion("heart_beat is not null");
            return (Criteria) this;
        }

        public Criteria andHeartBeatEqualTo(Integer value) {
            addCriterion("heart_beat =", value, "heartBeat");
            return (Criteria) this;
        }

        public Criteria andHeartBeatNotEqualTo(Integer value) {
            addCriterion("heart_beat <>", value, "heartBeat");
            return (Criteria) this;
        }

        public Criteria andHeartBeatGreaterThan(Integer value) {
            addCriterion("heart_beat >", value, "heartBeat");
            return (Criteria) this;
        }

        public Criteria andHeartBeatGreaterThanOrEqualTo(Integer value) {
            addCriterion("heart_beat >=", value, "heartBeat");
            return (Criteria) this;
        }

        public Criteria andHeartBeatLessThan(Integer value) {
            addCriterion("heart_beat <", value, "heartBeat");
            return (Criteria) this;
        }

        public Criteria andHeartBeatLessThanOrEqualTo(Integer value) {
            addCriterion("heart_beat <=", value, "heartBeat");
            return (Criteria) this;
        }

        public Criteria andHeartBeatIn(List<Integer> values) {
            addCriterion("heart_beat in", values, "heartBeat");
            return (Criteria) this;
        }

        public Criteria andHeartBeatNotIn(List<Integer> values) {
            addCriterion("heart_beat not in", values, "heartBeat");
            return (Criteria) this;
        }

        public Criteria andHeartBeatBetween(Integer value1, Integer value2) {
            addCriterion("heart_beat between", value1, value2, "heartBeat");
            return (Criteria) this;
        }

        public Criteria andHeartBeatNotBetween(Integer value1, Integer value2) {
            addCriterion("heart_beat not between", value1, value2, "heartBeat");
            return (Criteria) this;
        }

        public Criteria andDisastolicIsNull() {
            addCriterion("disastolic is null");
            return (Criteria) this;
        }

        public Criteria andDisastolicIsNotNull() {
            addCriterion("disastolic is not null");
            return (Criteria) this;
        }

        public Criteria andDisastolicEqualTo(Double value) {
            addCriterion("disastolic =", value, "disastolic");
            return (Criteria) this;
        }

        public Criteria andDisastolicNotEqualTo(Double value) {
            addCriterion("disastolic <>", value, "disastolic");
            return (Criteria) this;
        }

        public Criteria andDisastolicGreaterThan(Double value) {
            addCriterion("disastolic >", value, "disastolic");
            return (Criteria) this;
        }

        public Criteria andDisastolicGreaterThanOrEqualTo(Double value) {
            addCriterion("disastolic >=", value, "disastolic");
            return (Criteria) this;
        }

        public Criteria andDisastolicLessThan(Double value) {
            addCriterion("disastolic <", value, "disastolic");
            return (Criteria) this;
        }

        public Criteria andDisastolicLessThanOrEqualTo(Double value) {
            addCriterion("disastolic <=", value, "disastolic");
            return (Criteria) this;
        }

        public Criteria andDisastolicIn(List<Double> values) {
            addCriterion("disastolic in", values, "disastolic");
            return (Criteria) this;
        }

        public Criteria andDisastolicNotIn(List<Double> values) {
            addCriterion("disastolic not in", values, "disastolic");
            return (Criteria) this;
        }

        public Criteria andDisastolicBetween(Double value1, Double value2) {
            addCriterion("disastolic between", value1, value2, "disastolic");
            return (Criteria) this;
        }

        public Criteria andDisastolicNotBetween(Double value1, Double value2) {
            addCriterion("disastolic not between", value1, value2, "disastolic");
            return (Criteria) this;
        }

        public Criteria andShrinkIsNull() {
            addCriterion("shrink is null");
            return (Criteria) this;
        }

        public Criteria andShrinkIsNotNull() {
            addCriterion("shrink is not null");
            return (Criteria) this;
        }

        public Criteria andShrinkEqualTo(Double value) {
            addCriterion("shrink =", value, "shrink");
            return (Criteria) this;
        }

        public Criteria andShrinkNotEqualTo(Double value) {
            addCriterion("shrink <>", value, "shrink");
            return (Criteria) this;
        }

        public Criteria andShrinkGreaterThan(Double value) {
            addCriterion("shrink >", value, "shrink");
            return (Criteria) this;
        }

        public Criteria andShrinkGreaterThanOrEqualTo(Double value) {
            addCriterion("shrink >=", value, "shrink");
            return (Criteria) this;
        }

        public Criteria andShrinkLessThan(Double value) {
            addCriterion("shrink <", value, "shrink");
            return (Criteria) this;
        }

        public Criteria andShrinkLessThanOrEqualTo(Double value) {
            addCriterion("shrink <=", value, "shrink");
            return (Criteria) this;
        }

        public Criteria andShrinkIn(List<Double> values) {
            addCriterion("shrink in", values, "shrink");
            return (Criteria) this;
        }

        public Criteria andShrinkNotIn(List<Double> values) {
            addCriterion("shrink not in", values, "shrink");
            return (Criteria) this;
        }

        public Criteria andShrinkBetween(Double value1, Double value2) {
            addCriterion("shrink between", value1, value2, "shrink");
            return (Criteria) this;
        }

        public Criteria andShrinkNotBetween(Double value1, Double value2) {
            addCriterion("shrink not between", value1, value2, "shrink");
            return (Criteria) this;
        }

        public Criteria andBloodPressureIsNull() {
            addCriterion("blood_pressure is null");
            return (Criteria) this;
        }

        public Criteria andBloodPressureIsNotNull() {
            addCriterion("blood_pressure is not null");
            return (Criteria) this;
        }

        public Criteria andBloodPressureEqualTo(Double value) {
            addCriterion("blood_pressure =", value, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodPressureNotEqualTo(Double value) {
            addCriterion("blood_pressure <>", value, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodPressureGreaterThan(Double value) {
            addCriterion("blood_pressure >", value, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodPressureGreaterThanOrEqualTo(Double value) {
            addCriterion("blood_pressure >=", value, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodPressureLessThan(Double value) {
            addCriterion("blood_pressure <", value, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodPressureLessThanOrEqualTo(Double value) {
            addCriterion("blood_pressure <=", value, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodPressureIn(List<Double> values) {
            addCriterion("blood_pressure in", values, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodPressureNotIn(List<Double> values) {
            addCriterion("blood_pressure not in", values, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodPressureBetween(Double value1, Double value2) {
            addCriterion("blood_pressure between", value1, value2, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodPressureNotBetween(Double value1, Double value2) {
            addCriterion("blood_pressure not between", value1, value2, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodSugarIsNull() {
            addCriterion("blood_sugar is null");
            return (Criteria) this;
        }

        public Criteria andBloodSugarIsNotNull() {
            addCriterion("blood_sugar is not null");
            return (Criteria) this;
        }

        public Criteria andBloodSugarEqualTo(Double value) {
            addCriterion("blood_sugar =", value, "bloodSugar");
            return (Criteria) this;
        }

        public Criteria andBloodSugarNotEqualTo(Double value) {
            addCriterion("blood_sugar <>", value, "bloodSugar");
            return (Criteria) this;
        }

        public Criteria andBloodSugarGreaterThan(Double value) {
            addCriterion("blood_sugar >", value, "bloodSugar");
            return (Criteria) this;
        }

        public Criteria andBloodSugarGreaterThanOrEqualTo(Double value) {
            addCriterion("blood_sugar >=", value, "bloodSugar");
            return (Criteria) this;
        }

        public Criteria andBloodSugarLessThan(Double value) {
            addCriterion("blood_sugar <", value, "bloodSugar");
            return (Criteria) this;
        }

        public Criteria andBloodSugarLessThanOrEqualTo(Double value) {
            addCriterion("blood_sugar <=", value, "bloodSugar");
            return (Criteria) this;
        }

        public Criteria andBloodSugarIn(List<Double> values) {
            addCriterion("blood_sugar in", values, "bloodSugar");
            return (Criteria) this;
        }

        public Criteria andBloodSugarNotIn(List<Double> values) {
            addCriterion("blood_sugar not in", values, "bloodSugar");
            return (Criteria) this;
        }

        public Criteria andBloodSugarBetween(Double value1, Double value2) {
            addCriterion("blood_sugar between", value1, value2, "bloodSugar");
            return (Criteria) this;
        }

        public Criteria andBloodSugarNotBetween(Double value1, Double value2) {
            addCriterion("blood_sugar not between", value1, value2, "bloodSugar");
            return (Criteria) this;
        }

        public Criteria andTemperatureIsNull() {
            addCriterion("temperature is null");
            return (Criteria) this;
        }

        public Criteria andTemperatureIsNotNull() {
            addCriterion("temperature is not null");
            return (Criteria) this;
        }

        public Criteria andTemperatureEqualTo(Double value) {
            addCriterion("temperature =", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotEqualTo(Double value) {
            addCriterion("temperature <>", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThan(Double value) {
            addCriterion("temperature >", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThanOrEqualTo(Double value) {
            addCriterion("temperature >=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThan(Double value) {
            addCriterion("temperature <", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThanOrEqualTo(Double value) {
            addCriterion("temperature <=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureIn(List<Double> values) {
            addCriterion("temperature in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotIn(List<Double> values) {
            addCriterion("temperature not in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureBetween(Double value1, Double value2) {
            addCriterion("temperature between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotBetween(Double value1, Double value2) {
            addCriterion("temperature not between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andStepsIsNull() {
            addCriterion("steps is null");
            return (Criteria) this;
        }

        public Criteria andStepsIsNotNull() {
            addCriterion("steps is not null");
            return (Criteria) this;
        }

        public Criteria andStepsEqualTo(Integer value) {
            addCriterion("steps =", value, "steps");
            return (Criteria) this;
        }

        public Criteria andStepsNotEqualTo(Integer value) {
            addCriterion("steps <>", value, "steps");
            return (Criteria) this;
        }

        public Criteria andStepsGreaterThan(Integer value) {
            addCriterion("steps >", value, "steps");
            return (Criteria) this;
        }

        public Criteria andStepsGreaterThanOrEqualTo(Integer value) {
            addCriterion("steps >=", value, "steps");
            return (Criteria) this;
        }

        public Criteria andStepsLessThan(Integer value) {
            addCriterion("steps <", value, "steps");
            return (Criteria) this;
        }

        public Criteria andStepsLessThanOrEqualTo(Integer value) {
            addCriterion("steps <=", value, "steps");
            return (Criteria) this;
        }

        public Criteria andStepsIn(List<Integer> values) {
            addCriterion("steps in", values, "steps");
            return (Criteria) this;
        }

        public Criteria andStepsNotIn(List<Integer> values) {
            addCriterion("steps not in", values, "steps");
            return (Criteria) this;
        }

        public Criteria andStepsBetween(Integer value1, Integer value2) {
            addCriterion("steps between", value1, value2, "steps");
            return (Criteria) this;
        }

        public Criteria andStepsNotBetween(Integer value1, Integer value2) {
            addCriterion("steps not between", value1, value2, "steps");
            return (Criteria) this;
        }

        public Criteria andDeepSleepIsNull() {
            addCriterion("deep_sleep is null");
            return (Criteria) this;
        }

        public Criteria andDeepSleepIsNotNull() {
            addCriterion("deep_sleep is not null");
            return (Criteria) this;
        }

        public Criteria andDeepSleepEqualTo(Integer value) {
            addCriterion("deep_sleep =", value, "deepSleep");
            return (Criteria) this;
        }

        public Criteria andDeepSleepNotEqualTo(Integer value) {
            addCriterion("deep_sleep <>", value, "deepSleep");
            return (Criteria) this;
        }

        public Criteria andDeepSleepGreaterThan(Integer value) {
            addCriterion("deep_sleep >", value, "deepSleep");
            return (Criteria) this;
        }

        public Criteria andDeepSleepGreaterThanOrEqualTo(Integer value) {
            addCriterion("deep_sleep >=", value, "deepSleep");
            return (Criteria) this;
        }

        public Criteria andDeepSleepLessThan(Integer value) {
            addCriterion("deep_sleep <", value, "deepSleep");
            return (Criteria) this;
        }

        public Criteria andDeepSleepLessThanOrEqualTo(Integer value) {
            addCriterion("deep_sleep <=", value, "deepSleep");
            return (Criteria) this;
        }

        public Criteria andDeepSleepIn(List<Integer> values) {
            addCriterion("deep_sleep in", values, "deepSleep");
            return (Criteria) this;
        }

        public Criteria andDeepSleepNotIn(List<Integer> values) {
            addCriterion("deep_sleep not in", values, "deepSleep");
            return (Criteria) this;
        }

        public Criteria andDeepSleepBetween(Integer value1, Integer value2) {
            addCriterion("deep_sleep between", value1, value2, "deepSleep");
            return (Criteria) this;
        }

        public Criteria andDeepSleepNotBetween(Integer value1, Integer value2) {
            addCriterion("deep_sleep not between", value1, value2, "deepSleep");
            return (Criteria) this;
        }

        public Criteria andLightSleepIsNull() {
            addCriterion("light_sleep is null");
            return (Criteria) this;
        }

        public Criteria andLightSleepIsNotNull() {
            addCriterion("light_sleep is not null");
            return (Criteria) this;
        }

        public Criteria andLightSleepEqualTo(Integer value) {
            addCriterion("light_sleep =", value, "lightSleep");
            return (Criteria) this;
        }

        public Criteria andLightSleepNotEqualTo(Integer value) {
            addCriterion("light_sleep <>", value, "lightSleep");
            return (Criteria) this;
        }

        public Criteria andLightSleepGreaterThan(Integer value) {
            addCriterion("light_sleep >", value, "lightSleep");
            return (Criteria) this;
        }

        public Criteria andLightSleepGreaterThanOrEqualTo(Integer value) {
            addCriterion("light_sleep >=", value, "lightSleep");
            return (Criteria) this;
        }

        public Criteria andLightSleepLessThan(Integer value) {
            addCriterion("light_sleep <", value, "lightSleep");
            return (Criteria) this;
        }

        public Criteria andLightSleepLessThanOrEqualTo(Integer value) {
            addCriterion("light_sleep <=", value, "lightSleep");
            return (Criteria) this;
        }

        public Criteria andLightSleepIn(List<Integer> values) {
            addCriterion("light_sleep in", values, "lightSleep");
            return (Criteria) this;
        }

        public Criteria andLightSleepNotIn(List<Integer> values) {
            addCriterion("light_sleep not in", values, "lightSleep");
            return (Criteria) this;
        }

        public Criteria andLightSleepBetween(Integer value1, Integer value2) {
            addCriterion("light_sleep between", value1, value2, "lightSleep");
            return (Criteria) this;
        }

        public Criteria andLightSleepNotBetween(Integer value1, Integer value2) {
            addCriterion("light_sleep not between", value1, value2, "lightSleep");
            return (Criteria) this;
        }

        public Criteria andRollIsNull() {
            addCriterion("roll is null");
            return (Criteria) this;
        }

        public Criteria andRollIsNotNull() {
            addCriterion("roll is not null");
            return (Criteria) this;
        }

        public Criteria andRollEqualTo(Integer value) {
            addCriterion("roll =", value, "roll");
            return (Criteria) this;
        }

        public Criteria andRollNotEqualTo(Integer value) {
            addCriterion("roll <>", value, "roll");
            return (Criteria) this;
        }

        public Criteria andRollGreaterThan(Integer value) {
            addCriterion("roll >", value, "roll");
            return (Criteria) this;
        }

        public Criteria andRollGreaterThanOrEqualTo(Integer value) {
            addCriterion("roll >=", value, "roll");
            return (Criteria) this;
        }

        public Criteria andRollLessThan(Integer value) {
            addCriterion("roll <", value, "roll");
            return (Criteria) this;
        }

        public Criteria andRollLessThanOrEqualTo(Integer value) {
            addCriterion("roll <=", value, "roll");
            return (Criteria) this;
        }

        public Criteria andRollIn(List<Integer> values) {
            addCriterion("roll in", values, "roll");
            return (Criteria) this;
        }

        public Criteria andRollNotIn(List<Integer> values) {
            addCriterion("roll not in", values, "roll");
            return (Criteria) this;
        }

        public Criteria andRollBetween(Integer value1, Integer value2) {
            addCriterion("roll between", value1, value2, "roll");
            return (Criteria) this;
        }

        public Criteria andRollNotBetween(Integer value1, Integer value2) {
            addCriterion("roll not between", value1, value2, "roll");
            return (Criteria) this;
        }

        public Criteria andWakeIsNull() {
            addCriterion("wake is null");
            return (Criteria) this;
        }

        public Criteria andWakeIsNotNull() {
            addCriterion("wake is not null");
            return (Criteria) this;
        }

        public Criteria andWakeEqualTo(Integer value) {
            addCriterion("wake =", value, "wake");
            return (Criteria) this;
        }

        public Criteria andWakeNotEqualTo(Integer value) {
            addCriterion("wake <>", value, "wake");
            return (Criteria) this;
        }

        public Criteria andWakeGreaterThan(Integer value) {
            addCriterion("wake >", value, "wake");
            return (Criteria) this;
        }

        public Criteria andWakeGreaterThanOrEqualTo(Integer value) {
            addCriterion("wake >=", value, "wake");
            return (Criteria) this;
        }

        public Criteria andWakeLessThan(Integer value) {
            addCriterion("wake <", value, "wake");
            return (Criteria) this;
        }

        public Criteria andWakeLessThanOrEqualTo(Integer value) {
            addCriterion("wake <=", value, "wake");
            return (Criteria) this;
        }

        public Criteria andWakeIn(List<Integer> values) {
            addCriterion("wake in", values, "wake");
            return (Criteria) this;
        }

        public Criteria andWakeNotIn(List<Integer> values) {
            addCriterion("wake not in", values, "wake");
            return (Criteria) this;
        }

        public Criteria andWakeBetween(Integer value1, Integer value2) {
            addCriterion("wake between", value1, value2, "wake");
            return (Criteria) this;
        }

        public Criteria andWakeNotBetween(Integer value1, Integer value2) {
            addCriterion("wake not between", value1, value2, "wake");
            return (Criteria) this;
        }

        public Criteria andQualityIsNull() {
            addCriterion("quality is null");
            return (Criteria) this;
        }

        public Criteria andQualityIsNotNull() {
            addCriterion("quality is not null");
            return (Criteria) this;
        }

        public Criteria andQualityEqualTo(Integer value) {
            addCriterion("quality =", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotEqualTo(Integer value) {
            addCriterion("quality <>", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityGreaterThan(Integer value) {
            addCriterion("quality >", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityGreaterThanOrEqualTo(Integer value) {
            addCriterion("quality >=", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLessThan(Integer value) {
            addCriterion("quality <", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLessThanOrEqualTo(Integer value) {
            addCriterion("quality <=", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityIn(List<Integer> values) {
            addCriterion("quality in", values, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotIn(List<Integer> values) {
            addCriterion("quality not in", values, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityBetween(Integer value1, Integer value2) {
            addCriterion("quality between", value1, value2, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotBetween(Integer value1, Integer value2) {
            addCriterion("quality not between", value1, value2, "quality");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusIsNull() {
            addCriterion("online_status is null");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusIsNotNull() {
            addCriterion("online_status is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusEqualTo(Boolean value) {
            addCriterion("online_status =", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusNotEqualTo(Boolean value) {
            addCriterion("online_status <>", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusGreaterThan(Boolean value) {
            addCriterion("online_status >", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("online_status >=", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusLessThan(Boolean value) {
            addCriterion("online_status <", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("online_status <=", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusIn(List<Boolean> values) {
            addCriterion("online_status in", values, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusNotIn(List<Boolean> values) {
            addCriterion("online_status not in", values, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("online_status between", value1, value2, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("online_status not between", value1, value2, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}