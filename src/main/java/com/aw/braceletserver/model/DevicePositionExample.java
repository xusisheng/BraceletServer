package com.aw.braceletserver.model;

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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
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

        public Criteria andDeviceIdEqualTo(Integer value) {
            addCriterion("device_id =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(Integer value) {
            addCriterion("device_id <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(Integer value) {
            addCriterion("device_id >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_id >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(Integer value) {
            addCriterion("device_id <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(Integer value) {
            addCriterion("device_id <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<Integer> values) {
            addCriterion("device_id in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<Integer> values) {
            addCriterion("device_id not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(Integer value1, Integer value2) {
            addCriterion("device_id between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("device_id not between", value1, value2, "deviceId");
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

        public Criteria andOLatitudeIsNull() {
            addCriterion("o_latitude is null");
            return (Criteria) this;
        }

        public Criteria andOLatitudeIsNotNull() {
            addCriterion("o_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andOLatitudeEqualTo(BigDecimal value) {
            addCriterion("o_latitude =", value, "oLatitude");
            return (Criteria) this;
        }

        public Criteria andOLatitudeNotEqualTo(BigDecimal value) {
            addCriterion("o_latitude <>", value, "oLatitude");
            return (Criteria) this;
        }

        public Criteria andOLatitudeGreaterThan(BigDecimal value) {
            addCriterion("o_latitude >", value, "oLatitude");
            return (Criteria) this;
        }

        public Criteria andOLatitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("o_latitude >=", value, "oLatitude");
            return (Criteria) this;
        }

        public Criteria andOLatitudeLessThan(BigDecimal value) {
            addCriterion("o_latitude <", value, "oLatitude");
            return (Criteria) this;
        }

        public Criteria andOLatitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("o_latitude <=", value, "oLatitude");
            return (Criteria) this;
        }

        public Criteria andOLatitudeIn(List<BigDecimal> values) {
            addCriterion("o_latitude in", values, "oLatitude");
            return (Criteria) this;
        }

        public Criteria andOLatitudeNotIn(List<BigDecimal> values) {
            addCriterion("o_latitude not in", values, "oLatitude");
            return (Criteria) this;
        }

        public Criteria andOLatitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("o_latitude between", value1, value2, "oLatitude");
            return (Criteria) this;
        }

        public Criteria andOLatitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("o_latitude not between", value1, value2, "oLatitude");
            return (Criteria) this;
        }

        public Criteria andOLongitudeIsNull() {
            addCriterion("o_longitude is null");
            return (Criteria) this;
        }

        public Criteria andOLongitudeIsNotNull() {
            addCriterion("o_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andOLongitudeEqualTo(BigDecimal value) {
            addCriterion("o_longitude =", value, "oLongitude");
            return (Criteria) this;
        }

        public Criteria andOLongitudeNotEqualTo(BigDecimal value) {
            addCriterion("o_longitude <>", value, "oLongitude");
            return (Criteria) this;
        }

        public Criteria andOLongitudeGreaterThan(BigDecimal value) {
            addCriterion("o_longitude >", value, "oLongitude");
            return (Criteria) this;
        }

        public Criteria andOLongitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("o_longitude >=", value, "oLongitude");
            return (Criteria) this;
        }

        public Criteria andOLongitudeLessThan(BigDecimal value) {
            addCriterion("o_longitude <", value, "oLongitude");
            return (Criteria) this;
        }

        public Criteria andOLongitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("o_longitude <=", value, "oLongitude");
            return (Criteria) this;
        }

        public Criteria andOLongitudeIn(List<BigDecimal> values) {
            addCriterion("o_longitude in", values, "oLongitude");
            return (Criteria) this;
        }

        public Criteria andOLongitudeNotIn(List<BigDecimal> values) {
            addCriterion("o_longitude not in", values, "oLongitude");
            return (Criteria) this;
        }

        public Criteria andOLongitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("o_longitude between", value1, value2, "oLongitude");
            return (Criteria) this;
        }

        public Criteria andOLongitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("o_longitude not between", value1, value2, "oLongitude");
            return (Criteria) this;
        }

        public Criteria andDeviceUtcTimeIsNull() {
            addCriterion("device_utc_time is null");
            return (Criteria) this;
        }

        public Criteria andDeviceUtcTimeIsNotNull() {
            addCriterion("device_utc_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceUtcTimeEqualTo(Date value) {
            addCriterion("device_utc_time =", value, "deviceUtcTime");
            return (Criteria) this;
        }

        public Criteria andDeviceUtcTimeNotEqualTo(Date value) {
            addCriterion("device_utc_time <>", value, "deviceUtcTime");
            return (Criteria) this;
        }

        public Criteria andDeviceUtcTimeGreaterThan(Date value) {
            addCriterion("device_utc_time >", value, "deviceUtcTime");
            return (Criteria) this;
        }

        public Criteria andDeviceUtcTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("device_utc_time >=", value, "deviceUtcTime");
            return (Criteria) this;
        }

        public Criteria andDeviceUtcTimeLessThan(Date value) {
            addCriterion("device_utc_time <", value, "deviceUtcTime");
            return (Criteria) this;
        }

        public Criteria andDeviceUtcTimeLessThanOrEqualTo(Date value) {
            addCriterion("device_utc_time <=", value, "deviceUtcTime");
            return (Criteria) this;
        }

        public Criteria andDeviceUtcTimeIn(List<Date> values) {
            addCriterion("device_utc_time in", values, "deviceUtcTime");
            return (Criteria) this;
        }

        public Criteria andDeviceUtcTimeNotIn(List<Date> values) {
            addCriterion("device_utc_time not in", values, "deviceUtcTime");
            return (Criteria) this;
        }

        public Criteria andDeviceUtcTimeBetween(Date value1, Date value2) {
            addCriterion("device_utc_time between", value1, value2, "deviceUtcTime");
            return (Criteria) this;
        }

        public Criteria andDeviceUtcTimeNotBetween(Date value1, Date value2) {
            addCriterion("device_utc_time not between", value1, value2, "deviceUtcTime");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIsNull() {
            addCriterion("position_type is null");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIsNotNull() {
            addCriterion("position_type is not null");
            return (Criteria) this;
        }

        public Criteria andPositionTypeEqualTo(Integer value) {
            addCriterion("position_type =", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNotEqualTo(Integer value) {
            addCriterion("position_type <>", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeGreaterThan(Integer value) {
            addCriterion("position_type >", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("position_type >=", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeLessThan(Integer value) {
            addCriterion("position_type <", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeLessThanOrEqualTo(Integer value) {
            addCriterion("position_type <=", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIn(List<Integer> values) {
            addCriterion("position_type in", values, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNotIn(List<Integer> values) {
            addCriterion("position_type not in", values, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeBetween(Integer value1, Integer value2) {
            addCriterion("position_type between", value1, value2, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("position_type not between", value1, value2, "positionType");
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

        public Criteria andAltitudeEqualTo(Float value) {
            addCriterion("altitude =", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeNotEqualTo(Float value) {
            addCriterion("altitude <>", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeGreaterThan(Float value) {
            addCriterion("altitude >", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeGreaterThanOrEqualTo(Float value) {
            addCriterion("altitude >=", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeLessThan(Float value) {
            addCriterion("altitude <", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeLessThanOrEqualTo(Float value) {
            addCriterion("altitude <=", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeIn(List<Float> values) {
            addCriterion("altitude in", values, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeNotIn(List<Float> values) {
            addCriterion("altitude not in", values, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeBetween(Float value1, Float value2) {
            addCriterion("altitude between", value1, value2, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeNotBetween(Float value1, Float value2) {
            addCriterion("altitude not between", value1, value2, "altitude");
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

        public Criteria andOnlineStatusEqualTo(Integer value) {
            addCriterion("online_status =", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusNotEqualTo(Integer value) {
            addCriterion("online_status <>", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusGreaterThan(Integer value) {
            addCriterion("online_status >", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("online_status >=", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusLessThan(Integer value) {
            addCriterion("online_status <", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusLessThanOrEqualTo(Integer value) {
            addCriterion("online_status <=", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusIn(List<Integer> values) {
            addCriterion("online_status in", values, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusNotIn(List<Integer> values) {
            addCriterion("online_status not in", values, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusBetween(Integer value1, Integer value2) {
            addCriterion("online_status between", value1, value2, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("online_status not between", value1, value2, "onlineStatus");
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