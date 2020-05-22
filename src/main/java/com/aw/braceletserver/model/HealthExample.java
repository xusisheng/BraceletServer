package com.aw.braceletserver.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HealthExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HealthExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumIsNull() {
            addCriterion("DEVICE_SERIAL_NUM is null");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumIsNotNull() {
            addCriterion("DEVICE_SERIAL_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumEqualTo(String value) {
            addCriterion("DEVICE_SERIAL_NUM =", value, "deviceSerialNum");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumNotEqualTo(String value) {
            addCriterion("DEVICE_SERIAL_NUM <>", value, "deviceSerialNum");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumGreaterThan(String value) {
            addCriterion("DEVICE_SERIAL_NUM >", value, "deviceSerialNum");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumGreaterThanOrEqualTo(String value) {
            addCriterion("DEVICE_SERIAL_NUM >=", value, "deviceSerialNum");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumLessThan(String value) {
            addCriterion("DEVICE_SERIAL_NUM <", value, "deviceSerialNum");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumLessThanOrEqualTo(String value) {
            addCriterion("DEVICE_SERIAL_NUM <=", value, "deviceSerialNum");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumLike(String value) {
            addCriterion("DEVICE_SERIAL_NUM like", value, "deviceSerialNum");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumNotLike(String value) {
            addCriterion("DEVICE_SERIAL_NUM not like", value, "deviceSerialNum");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumIn(List<String> values) {
            addCriterion("DEVICE_SERIAL_NUM in", values, "deviceSerialNum");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumNotIn(List<String> values) {
            addCriterion("DEVICE_SERIAL_NUM not in", values, "deviceSerialNum");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumBetween(String value1, String value2) {
            addCriterion("DEVICE_SERIAL_NUM between", value1, value2, "deviceSerialNum");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumNotBetween(String value1, String value2) {
            addCriterion("DEVICE_SERIAL_NUM not between", value1, value2, "deviceSerialNum");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andBloodSugarIsNull() {
            addCriterion("BLOOD_SUGAR is null");
            return (Criteria) this;
        }

        public Criteria andBloodSugarIsNotNull() {
            addCriterion("BLOOD_SUGAR is not null");
            return (Criteria) this;
        }

        public Criteria andBloodSugarEqualTo(Float value) {
            addCriterion("BLOOD_SUGAR =", value, "bloodSugar");
            return (Criteria) this;
        }

        public Criteria andBloodSugarNotEqualTo(Float value) {
            addCriterion("BLOOD_SUGAR <>", value, "bloodSugar");
            return (Criteria) this;
        }

        public Criteria andBloodSugarGreaterThan(Float value) {
            addCriterion("BLOOD_SUGAR >", value, "bloodSugar");
            return (Criteria) this;
        }

        public Criteria andBloodSugarGreaterThanOrEqualTo(Float value) {
            addCriterion("BLOOD_SUGAR >=", value, "bloodSugar");
            return (Criteria) this;
        }

        public Criteria andBloodSugarLessThan(Float value) {
            addCriterion("BLOOD_SUGAR <", value, "bloodSugar");
            return (Criteria) this;
        }

        public Criteria andBloodSugarLessThanOrEqualTo(Float value) {
            addCriterion("BLOOD_SUGAR <=", value, "bloodSugar");
            return (Criteria) this;
        }

        public Criteria andBloodSugarIn(List<Float> values) {
            addCriterion("BLOOD_SUGAR in", values, "bloodSugar");
            return (Criteria) this;
        }

        public Criteria andBloodSugarNotIn(List<Float> values) {
            addCriterion("BLOOD_SUGAR not in", values, "bloodSugar");
            return (Criteria) this;
        }

        public Criteria andBloodSugarBetween(Float value1, Float value2) {
            addCriterion("BLOOD_SUGAR between", value1, value2, "bloodSugar");
            return (Criteria) this;
        }

        public Criteria andBloodSugarNotBetween(Float value1, Float value2) {
            addCriterion("BLOOD_SUGAR not between", value1, value2, "bloodSugar");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andDisastolicIsNull() {
            addCriterion("DISASTOLIC is null");
            return (Criteria) this;
        }

        public Criteria andDisastolicIsNotNull() {
            addCriterion("DISASTOLIC is not null");
            return (Criteria) this;
        }

        public Criteria andDisastolicEqualTo(Float value) {
            addCriterion("DISASTOLIC =", value, "disastolic");
            return (Criteria) this;
        }

        public Criteria andDisastolicNotEqualTo(Float value) {
            addCriterion("DISASTOLIC <>", value, "disastolic");
            return (Criteria) this;
        }

        public Criteria andDisastolicGreaterThan(Float value) {
            addCriterion("DISASTOLIC >", value, "disastolic");
            return (Criteria) this;
        }

        public Criteria andDisastolicGreaterThanOrEqualTo(Float value) {
            addCriterion("DISASTOLIC >=", value, "disastolic");
            return (Criteria) this;
        }

        public Criteria andDisastolicLessThan(Float value) {
            addCriterion("DISASTOLIC <", value, "disastolic");
            return (Criteria) this;
        }

        public Criteria andDisastolicLessThanOrEqualTo(Float value) {
            addCriterion("DISASTOLIC <=", value, "disastolic");
            return (Criteria) this;
        }

        public Criteria andDisastolicIn(List<Float> values) {
            addCriterion("DISASTOLIC in", values, "disastolic");
            return (Criteria) this;
        }

        public Criteria andDisastolicNotIn(List<Float> values) {
            addCriterion("DISASTOLIC not in", values, "disastolic");
            return (Criteria) this;
        }

        public Criteria andDisastolicBetween(Float value1, Float value2) {
            addCriterion("DISASTOLIC between", value1, value2, "disastolic");
            return (Criteria) this;
        }

        public Criteria andDisastolicNotBetween(Float value1, Float value2) {
            addCriterion("DISASTOLIC not between", value1, value2, "disastolic");
            return (Criteria) this;
        }

        public Criteria andShrinkIsNull() {
            addCriterion("SHRINK is null");
            return (Criteria) this;
        }

        public Criteria andShrinkIsNotNull() {
            addCriterion("SHRINK is not null");
            return (Criteria) this;
        }

        public Criteria andShrinkEqualTo(Float value) {
            addCriterion("SHRINK =", value, "shrink");
            return (Criteria) this;
        }

        public Criteria andShrinkNotEqualTo(Float value) {
            addCriterion("SHRINK <>", value, "shrink");
            return (Criteria) this;
        }

        public Criteria andShrinkGreaterThan(Float value) {
            addCriterion("SHRINK >", value, "shrink");
            return (Criteria) this;
        }

        public Criteria andShrinkGreaterThanOrEqualTo(Float value) {
            addCriterion("SHRINK >=", value, "shrink");
            return (Criteria) this;
        }

        public Criteria andShrinkLessThan(Float value) {
            addCriterion("SHRINK <", value, "shrink");
            return (Criteria) this;
        }

        public Criteria andShrinkLessThanOrEqualTo(Float value) {
            addCriterion("SHRINK <=", value, "shrink");
            return (Criteria) this;
        }

        public Criteria andShrinkIn(List<Float> values) {
            addCriterion("SHRINK in", values, "shrink");
            return (Criteria) this;
        }

        public Criteria andShrinkNotIn(List<Float> values) {
            addCriterion("SHRINK not in", values, "shrink");
            return (Criteria) this;
        }

        public Criteria andShrinkBetween(Float value1, Float value2) {
            addCriterion("SHRINK between", value1, value2, "shrink");
            return (Criteria) this;
        }

        public Criteria andShrinkNotBetween(Float value1, Float value2) {
            addCriterion("SHRINK not between", value1, value2, "shrink");
            return (Criteria) this;
        }

        public Criteria andHeartBeatIsNull() {
            addCriterion("HEART_BEAT is null");
            return (Criteria) this;
        }

        public Criteria andHeartBeatIsNotNull() {
            addCriterion("HEART_BEAT is not null");
            return (Criteria) this;
        }

        public Criteria andHeartBeatEqualTo(Float value) {
            addCriterion("HEART_BEAT =", value, "heartBeat");
            return (Criteria) this;
        }

        public Criteria andHeartBeatNotEqualTo(Float value) {
            addCriterion("HEART_BEAT <>", value, "heartBeat");
            return (Criteria) this;
        }

        public Criteria andHeartBeatGreaterThan(Float value) {
            addCriterion("HEART_BEAT >", value, "heartBeat");
            return (Criteria) this;
        }

        public Criteria andHeartBeatGreaterThanOrEqualTo(Float value) {
            addCriterion("HEART_BEAT >=", value, "heartBeat");
            return (Criteria) this;
        }

        public Criteria andHeartBeatLessThan(Float value) {
            addCriterion("HEART_BEAT <", value, "heartBeat");
            return (Criteria) this;
        }

        public Criteria andHeartBeatLessThanOrEqualTo(Float value) {
            addCriterion("HEART_BEAT <=", value, "heartBeat");
            return (Criteria) this;
        }

        public Criteria andHeartBeatIn(List<Float> values) {
            addCriterion("HEART_BEAT in", values, "heartBeat");
            return (Criteria) this;
        }

        public Criteria andHeartBeatNotIn(List<Float> values) {
            addCriterion("HEART_BEAT not in", values, "heartBeat");
            return (Criteria) this;
        }

        public Criteria andHeartBeatBetween(Float value1, Float value2) {
            addCriterion("HEART_BEAT between", value1, value2, "heartBeat");
            return (Criteria) this;
        }

        public Criteria andHeartBeatNotBetween(Float value1, Float value2) {
            addCriterion("HEART_BEAT not between", value1, value2, "heartBeat");
            return (Criteria) this;
        }

        public Criteria andStepsIsNull() {
            addCriterion("STEPS is null");
            return (Criteria) this;
        }

        public Criteria andStepsIsNotNull() {
            addCriterion("STEPS is not null");
            return (Criteria) this;
        }

        public Criteria andStepsEqualTo(Integer value) {
            addCriterion("STEPS =", value, "steps");
            return (Criteria) this;
        }

        public Criteria andStepsNotEqualTo(Integer value) {
            addCriterion("STEPS <>", value, "steps");
            return (Criteria) this;
        }

        public Criteria andStepsGreaterThan(Integer value) {
            addCriterion("STEPS >", value, "steps");
            return (Criteria) this;
        }

        public Criteria andStepsGreaterThanOrEqualTo(Integer value) {
            addCriterion("STEPS >=", value, "steps");
            return (Criteria) this;
        }

        public Criteria andStepsLessThan(Integer value) {
            addCriterion("STEPS <", value, "steps");
            return (Criteria) this;
        }

        public Criteria andStepsLessThanOrEqualTo(Integer value) {
            addCriterion("STEPS <=", value, "steps");
            return (Criteria) this;
        }

        public Criteria andStepsIn(List<Integer> values) {
            addCriterion("STEPS in", values, "steps");
            return (Criteria) this;
        }

        public Criteria andStepsNotIn(List<Integer> values) {
            addCriterion("STEPS not in", values, "steps");
            return (Criteria) this;
        }

        public Criteria andStepsBetween(Integer value1, Integer value2) {
            addCriterion("STEPS between", value1, value2, "steps");
            return (Criteria) this;
        }

        public Criteria andStepsNotBetween(Integer value1, Integer value2) {
            addCriterion("STEPS not between", value1, value2, "steps");
            return (Criteria) this;
        }

        public Criteria andBloodPressureIsNull() {
            addCriterion("BLOOD_PRESSURE is null");
            return (Criteria) this;
        }

        public Criteria andBloodPressureIsNotNull() {
            addCriterion("BLOOD_PRESSURE is not null");
            return (Criteria) this;
        }

        public Criteria andBloodPressureEqualTo(Float value) {
            addCriterion("BLOOD_PRESSURE =", value, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodPressureNotEqualTo(Float value) {
            addCriterion("BLOOD_PRESSURE <>", value, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodPressureGreaterThan(Float value) {
            addCriterion("BLOOD_PRESSURE >", value, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodPressureGreaterThanOrEqualTo(Float value) {
            addCriterion("BLOOD_PRESSURE >=", value, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodPressureLessThan(Float value) {
            addCriterion("BLOOD_PRESSURE <", value, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodPressureLessThanOrEqualTo(Float value) {
            addCriterion("BLOOD_PRESSURE <=", value, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodPressureIn(List<Float> values) {
            addCriterion("BLOOD_PRESSURE in", values, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodPressureNotIn(List<Float> values) {
            addCriterion("BLOOD_PRESSURE not in", values, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodPressureBetween(Float value1, Float value2) {
            addCriterion("BLOOD_PRESSURE between", value1, value2, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodPressureNotBetween(Float value1, Float value2) {
            addCriterion("BLOOD_PRESSURE not between", value1, value2, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBodyTemperatureIsNull() {
            addCriterion("BODY_TEMPERATURE is null");
            return (Criteria) this;
        }

        public Criteria andBodyTemperatureIsNotNull() {
            addCriterion("BODY_TEMPERATURE is not null");
            return (Criteria) this;
        }

        public Criteria andBodyTemperatureEqualTo(Float value) {
            addCriterion("BODY_TEMPERATURE =", value, "bodyTemperature");
            return (Criteria) this;
        }

        public Criteria andBodyTemperatureNotEqualTo(Float value) {
            addCriterion("BODY_TEMPERATURE <>", value, "bodyTemperature");
            return (Criteria) this;
        }

        public Criteria andBodyTemperatureGreaterThan(Float value) {
            addCriterion("BODY_TEMPERATURE >", value, "bodyTemperature");
            return (Criteria) this;
        }

        public Criteria andBodyTemperatureGreaterThanOrEqualTo(Float value) {
            addCriterion("BODY_TEMPERATURE >=", value, "bodyTemperature");
            return (Criteria) this;
        }

        public Criteria andBodyTemperatureLessThan(Float value) {
            addCriterion("BODY_TEMPERATURE <", value, "bodyTemperature");
            return (Criteria) this;
        }

        public Criteria andBodyTemperatureLessThanOrEqualTo(Float value) {
            addCriterion("BODY_TEMPERATURE <=", value, "bodyTemperature");
            return (Criteria) this;
        }

        public Criteria andBodyTemperatureIn(List<Float> values) {
            addCriterion("BODY_TEMPERATURE in", values, "bodyTemperature");
            return (Criteria) this;
        }

        public Criteria andBodyTemperatureNotIn(List<Float> values) {
            addCriterion("BODY_TEMPERATURE not in", values, "bodyTemperature");
            return (Criteria) this;
        }

        public Criteria andBodyTemperatureBetween(Float value1, Float value2) {
            addCriterion("BODY_TEMPERATURE between", value1, value2, "bodyTemperature");
            return (Criteria) this;
        }

        public Criteria andBodyTemperatureNotBetween(Float value1, Float value2) {
            addCriterion("BODY_TEMPERATURE not between", value1, value2, "bodyTemperature");
            return (Criteria) this;
        }

        public Criteria andDeepSleepSecIsNull() {
            addCriterion("DEEP_SLEEP_SEC is null");
            return (Criteria) this;
        }

        public Criteria andDeepSleepSecIsNotNull() {
            addCriterion("DEEP_SLEEP_SEC is not null");
            return (Criteria) this;
        }

        public Criteria andDeepSleepSecEqualTo(Integer value) {
            addCriterion("DEEP_SLEEP_SEC =", value, "deepSleepSec");
            return (Criteria) this;
        }

        public Criteria andDeepSleepSecNotEqualTo(Integer value) {
            addCriterion("DEEP_SLEEP_SEC <>", value, "deepSleepSec");
            return (Criteria) this;
        }

        public Criteria andDeepSleepSecGreaterThan(Integer value) {
            addCriterion("DEEP_SLEEP_SEC >", value, "deepSleepSec");
            return (Criteria) this;
        }

        public Criteria andDeepSleepSecGreaterThanOrEqualTo(Integer value) {
            addCriterion("DEEP_SLEEP_SEC >=", value, "deepSleepSec");
            return (Criteria) this;
        }

        public Criteria andDeepSleepSecLessThan(Integer value) {
            addCriterion("DEEP_SLEEP_SEC <", value, "deepSleepSec");
            return (Criteria) this;
        }

        public Criteria andDeepSleepSecLessThanOrEqualTo(Integer value) {
            addCriterion("DEEP_SLEEP_SEC <=", value, "deepSleepSec");
            return (Criteria) this;
        }

        public Criteria andDeepSleepSecIn(List<Integer> values) {
            addCriterion("DEEP_SLEEP_SEC in", values, "deepSleepSec");
            return (Criteria) this;
        }

        public Criteria andDeepSleepSecNotIn(List<Integer> values) {
            addCriterion("DEEP_SLEEP_SEC not in", values, "deepSleepSec");
            return (Criteria) this;
        }

        public Criteria andDeepSleepSecBetween(Integer value1, Integer value2) {
            addCriterion("DEEP_SLEEP_SEC between", value1, value2, "deepSleepSec");
            return (Criteria) this;
        }

        public Criteria andDeepSleepSecNotBetween(Integer value1, Integer value2) {
            addCriterion("DEEP_SLEEP_SEC not between", value1, value2, "deepSleepSec");
            return (Criteria) this;
        }

        public Criteria andLightSleepSecIsNull() {
            addCriterion("LIGHT_SLEEP_SEC is null");
            return (Criteria) this;
        }

        public Criteria andLightSleepSecIsNotNull() {
            addCriterion("LIGHT_SLEEP_SEC is not null");
            return (Criteria) this;
        }

        public Criteria andLightSleepSecEqualTo(Integer value) {
            addCriterion("LIGHT_SLEEP_SEC =", value, "lightSleepSec");
            return (Criteria) this;
        }

        public Criteria andLightSleepSecNotEqualTo(Integer value) {
            addCriterion("LIGHT_SLEEP_SEC <>", value, "lightSleepSec");
            return (Criteria) this;
        }

        public Criteria andLightSleepSecGreaterThan(Integer value) {
            addCriterion("LIGHT_SLEEP_SEC >", value, "lightSleepSec");
            return (Criteria) this;
        }

        public Criteria andLightSleepSecGreaterThanOrEqualTo(Integer value) {
            addCriterion("LIGHT_SLEEP_SEC >=", value, "lightSleepSec");
            return (Criteria) this;
        }

        public Criteria andLightSleepSecLessThan(Integer value) {
            addCriterion("LIGHT_SLEEP_SEC <", value, "lightSleepSec");
            return (Criteria) this;
        }

        public Criteria andLightSleepSecLessThanOrEqualTo(Integer value) {
            addCriterion("LIGHT_SLEEP_SEC <=", value, "lightSleepSec");
            return (Criteria) this;
        }

        public Criteria andLightSleepSecIn(List<Integer> values) {
            addCriterion("LIGHT_SLEEP_SEC in", values, "lightSleepSec");
            return (Criteria) this;
        }

        public Criteria andLightSleepSecNotIn(List<Integer> values) {
            addCriterion("LIGHT_SLEEP_SEC not in", values, "lightSleepSec");
            return (Criteria) this;
        }

        public Criteria andLightSleepSecBetween(Integer value1, Integer value2) {
            addCriterion("LIGHT_SLEEP_SEC between", value1, value2, "lightSleepSec");
            return (Criteria) this;
        }

        public Criteria andLightSleepSecNotBetween(Integer value1, Integer value2) {
            addCriterion("LIGHT_SLEEP_SEC not between", value1, value2, "lightSleepSec");
            return (Criteria) this;
        }

        public Criteria andRollIsNull() {
            addCriterion("ROLL is null");
            return (Criteria) this;
        }

        public Criteria andRollIsNotNull() {
            addCriterion("ROLL is not null");
            return (Criteria) this;
        }

        public Criteria andRollEqualTo(Integer value) {
            addCriterion("ROLL =", value, "roll");
            return (Criteria) this;
        }

        public Criteria andRollNotEqualTo(Integer value) {
            addCriterion("ROLL <>", value, "roll");
            return (Criteria) this;
        }

        public Criteria andRollGreaterThan(Integer value) {
            addCriterion("ROLL >", value, "roll");
            return (Criteria) this;
        }

        public Criteria andRollGreaterThanOrEqualTo(Integer value) {
            addCriterion("ROLL >=", value, "roll");
            return (Criteria) this;
        }

        public Criteria andRollLessThan(Integer value) {
            addCriterion("ROLL <", value, "roll");
            return (Criteria) this;
        }

        public Criteria andRollLessThanOrEqualTo(Integer value) {
            addCriterion("ROLL <=", value, "roll");
            return (Criteria) this;
        }

        public Criteria andRollIn(List<Integer> values) {
            addCriterion("ROLL in", values, "roll");
            return (Criteria) this;
        }

        public Criteria andRollNotIn(List<Integer> values) {
            addCriterion("ROLL not in", values, "roll");
            return (Criteria) this;
        }

        public Criteria andRollBetween(Integer value1, Integer value2) {
            addCriterion("ROLL between", value1, value2, "roll");
            return (Criteria) this;
        }

        public Criteria andRollNotBetween(Integer value1, Integer value2) {
            addCriterion("ROLL not between", value1, value2, "roll");
            return (Criteria) this;
        }

        public Criteria andWakeIsNull() {
            addCriterion("WAKE is null");
            return (Criteria) this;
        }

        public Criteria andWakeIsNotNull() {
            addCriterion("WAKE is not null");
            return (Criteria) this;
        }

        public Criteria andWakeEqualTo(Integer value) {
            addCriterion("WAKE =", value, "wake");
            return (Criteria) this;
        }

        public Criteria andWakeNotEqualTo(Integer value) {
            addCriterion("WAKE <>", value, "wake");
            return (Criteria) this;
        }

        public Criteria andWakeGreaterThan(Integer value) {
            addCriterion("WAKE >", value, "wake");
            return (Criteria) this;
        }

        public Criteria andWakeGreaterThanOrEqualTo(Integer value) {
            addCriterion("WAKE >=", value, "wake");
            return (Criteria) this;
        }

        public Criteria andWakeLessThan(Integer value) {
            addCriterion("WAKE <", value, "wake");
            return (Criteria) this;
        }

        public Criteria andWakeLessThanOrEqualTo(Integer value) {
            addCriterion("WAKE <=", value, "wake");
            return (Criteria) this;
        }

        public Criteria andWakeIn(List<Integer> values) {
            addCriterion("WAKE in", values, "wake");
            return (Criteria) this;
        }

        public Criteria andWakeNotIn(List<Integer> values) {
            addCriterion("WAKE not in", values, "wake");
            return (Criteria) this;
        }

        public Criteria andWakeBetween(Integer value1, Integer value2) {
            addCriterion("WAKE between", value1, value2, "wake");
            return (Criteria) this;
        }

        public Criteria andWakeNotBetween(Integer value1, Integer value2) {
            addCriterion("WAKE not between", value1, value2, "wake");
            return (Criteria) this;
        }

        public Criteria andQualityIsNull() {
            addCriterion("QUALITY is null");
            return (Criteria) this;
        }

        public Criteria andQualityIsNotNull() {
            addCriterion("QUALITY is not null");
            return (Criteria) this;
        }

        public Criteria andQualityEqualTo(Integer value) {
            addCriterion("QUALITY =", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotEqualTo(Integer value) {
            addCriterion("QUALITY <>", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityGreaterThan(Integer value) {
            addCriterion("QUALITY >", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityGreaterThanOrEqualTo(Integer value) {
            addCriterion("QUALITY >=", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLessThan(Integer value) {
            addCriterion("QUALITY <", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLessThanOrEqualTo(Integer value) {
            addCriterion("QUALITY <=", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityIn(List<Integer> values) {
            addCriterion("QUALITY in", values, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotIn(List<Integer> values) {
            addCriterion("QUALITY not in", values, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityBetween(Integer value1, Integer value2) {
            addCriterion("QUALITY between", value1, value2, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotBetween(Integer value1, Integer value2) {
            addCriterion("QUALITY not between", value1, value2, "quality");
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