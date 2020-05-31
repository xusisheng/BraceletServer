package com.aw.braceletserver.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceExample() {
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

        public Criteria andIotDeviceidIsNull() {
            addCriterion("iot_deviceid is null");
            return (Criteria) this;
        }

        public Criteria andIotDeviceidIsNotNull() {
            addCriterion("iot_deviceid is not null");
            return (Criteria) this;
        }

        public Criteria andIotDeviceidEqualTo(String value) {
            addCriterion("iot_deviceid =", value, "iotDeviceid");
            return (Criteria) this;
        }

        public Criteria andIotDeviceidNotEqualTo(String value) {
            addCriterion("iot_deviceid <>", value, "iotDeviceid");
            return (Criteria) this;
        }

        public Criteria andIotDeviceidGreaterThan(String value) {
            addCriterion("iot_deviceid >", value, "iotDeviceid");
            return (Criteria) this;
        }

        public Criteria andIotDeviceidGreaterThanOrEqualTo(String value) {
            addCriterion("iot_deviceid >=", value, "iotDeviceid");
            return (Criteria) this;
        }

        public Criteria andIotDeviceidLessThan(String value) {
            addCriterion("iot_deviceid <", value, "iotDeviceid");
            return (Criteria) this;
        }

        public Criteria andIotDeviceidLessThanOrEqualTo(String value) {
            addCriterion("iot_deviceid <=", value, "iotDeviceid");
            return (Criteria) this;
        }

        public Criteria andIotDeviceidLike(String value) {
            addCriterion("iot_deviceid like", value, "iotDeviceid");
            return (Criteria) this;
        }

        public Criteria andIotDeviceidNotLike(String value) {
            addCriterion("iot_deviceid not like", value, "iotDeviceid");
            return (Criteria) this;
        }

        public Criteria andIotDeviceidIn(List<String> values) {
            addCriterion("iot_deviceid in", values, "iotDeviceid");
            return (Criteria) this;
        }

        public Criteria andIotDeviceidNotIn(List<String> values) {
            addCriterion("iot_deviceid not in", values, "iotDeviceid");
            return (Criteria) this;
        }

        public Criteria andIotDeviceidBetween(String value1, String value2) {
            addCriterion("iot_deviceid between", value1, value2, "iotDeviceid");
            return (Criteria) this;
        }

        public Criteria andIotDeviceidNotBetween(String value1, String value2) {
            addCriterion("iot_deviceid not between", value1, value2, "iotDeviceid");
            return (Criteria) this;
        }

        public Criteria andSnIsNull() {
            addCriterion("sn is null");
            return (Criteria) this;
        }

        public Criteria andSnIsNotNull() {
            addCriterion("sn is not null");
            return (Criteria) this;
        }

        public Criteria andSnEqualTo(String value) {
            addCriterion("sn =", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotEqualTo(String value) {
            addCriterion("sn <>", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThan(String value) {
            addCriterion("sn >", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThanOrEqualTo(String value) {
            addCriterion("sn >=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThan(String value) {
            addCriterion("sn <", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThanOrEqualTo(String value) {
            addCriterion("sn <=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLike(String value) {
            addCriterion("sn like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotLike(String value) {
            addCriterion("sn not like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnIn(List<String> values) {
            addCriterion("sn in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotIn(List<String> values) {
            addCriterion("sn not in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnBetween(String value1, String value2) {
            addCriterion("sn between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotBetween(String value1, String value2) {
            addCriterion("sn not between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andImeiIsNull() {
            addCriterion("imei is null");
            return (Criteria) this;
        }

        public Criteria andImeiIsNotNull() {
            addCriterion("imei is not null");
            return (Criteria) this;
        }

        public Criteria andImeiEqualTo(String value) {
            addCriterion("imei =", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiNotEqualTo(String value) {
            addCriterion("imei <>", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiGreaterThan(String value) {
            addCriterion("imei >", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiGreaterThanOrEqualTo(String value) {
            addCriterion("imei >=", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiLessThan(String value) {
            addCriterion("imei <", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiLessThanOrEqualTo(String value) {
            addCriterion("imei <=", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiLike(String value) {
            addCriterion("imei like", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiNotLike(String value) {
            addCriterion("imei not like", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiIn(List<String> values) {
            addCriterion("imei in", values, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiNotIn(List<String> values) {
            addCriterion("imei not in", values, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiBetween(String value1, String value2) {
            addCriterion("imei between", value1, value2, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiNotBetween(String value1, String value2) {
            addCriterion("imei not between", value1, value2, "imei");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andSwVersionIsNull() {
            addCriterion("sw_version is null");
            return (Criteria) this;
        }

        public Criteria andSwVersionIsNotNull() {
            addCriterion("sw_version is not null");
            return (Criteria) this;
        }

        public Criteria andSwVersionEqualTo(String value) {
            addCriterion("sw_version =", value, "swVersion");
            return (Criteria) this;
        }

        public Criteria andSwVersionNotEqualTo(String value) {
            addCriterion("sw_version <>", value, "swVersion");
            return (Criteria) this;
        }

        public Criteria andSwVersionGreaterThan(String value) {
            addCriterion("sw_version >", value, "swVersion");
            return (Criteria) this;
        }

        public Criteria andSwVersionGreaterThanOrEqualTo(String value) {
            addCriterion("sw_version >=", value, "swVersion");
            return (Criteria) this;
        }

        public Criteria andSwVersionLessThan(String value) {
            addCriterion("sw_version <", value, "swVersion");
            return (Criteria) this;
        }

        public Criteria andSwVersionLessThanOrEqualTo(String value) {
            addCriterion("sw_version <=", value, "swVersion");
            return (Criteria) this;
        }

        public Criteria andSwVersionLike(String value) {
            addCriterion("sw_version like", value, "swVersion");
            return (Criteria) this;
        }

        public Criteria andSwVersionNotLike(String value) {
            addCriterion("sw_version not like", value, "swVersion");
            return (Criteria) this;
        }

        public Criteria andSwVersionIn(List<String> values) {
            addCriterion("sw_version in", values, "swVersion");
            return (Criteria) this;
        }

        public Criteria andSwVersionNotIn(List<String> values) {
            addCriterion("sw_version not in", values, "swVersion");
            return (Criteria) this;
        }

        public Criteria andSwVersionBetween(String value1, String value2) {
            addCriterion("sw_version between", value1, value2, "swVersion");
            return (Criteria) this;
        }

        public Criteria andSwVersionNotBetween(String value1, String value2) {
            addCriterion("sw_version not between", value1, value2, "swVersion");
            return (Criteria) this;
        }

        public Criteria andFwVersionIsNull() {
            addCriterion("fw_version is null");
            return (Criteria) this;
        }

        public Criteria andFwVersionIsNotNull() {
            addCriterion("fw_version is not null");
            return (Criteria) this;
        }

        public Criteria andFwVersionEqualTo(String value) {
            addCriterion("fw_version =", value, "fwVersion");
            return (Criteria) this;
        }

        public Criteria andFwVersionNotEqualTo(String value) {
            addCriterion("fw_version <>", value, "fwVersion");
            return (Criteria) this;
        }

        public Criteria andFwVersionGreaterThan(String value) {
            addCriterion("fw_version >", value, "fwVersion");
            return (Criteria) this;
        }

        public Criteria andFwVersionGreaterThanOrEqualTo(String value) {
            addCriterion("fw_version >=", value, "fwVersion");
            return (Criteria) this;
        }

        public Criteria andFwVersionLessThan(String value) {
            addCriterion("fw_version <", value, "fwVersion");
            return (Criteria) this;
        }

        public Criteria andFwVersionLessThanOrEqualTo(String value) {
            addCriterion("fw_version <=", value, "fwVersion");
            return (Criteria) this;
        }

        public Criteria andFwVersionLike(String value) {
            addCriterion("fw_version like", value, "fwVersion");
            return (Criteria) this;
        }

        public Criteria andFwVersionNotLike(String value) {
            addCriterion("fw_version not like", value, "fwVersion");
            return (Criteria) this;
        }

        public Criteria andFwVersionIn(List<String> values) {
            addCriterion("fw_version in", values, "fwVersion");
            return (Criteria) this;
        }

        public Criteria andFwVersionNotIn(List<String> values) {
            addCriterion("fw_version not in", values, "fwVersion");
            return (Criteria) this;
        }

        public Criteria andFwVersionBetween(String value1, String value2) {
            addCriterion("fw_version between", value1, value2, "fwVersion");
            return (Criteria) this;
        }

        public Criteria andFwVersionNotBetween(String value1, String value2) {
            addCriterion("fw_version not between", value1, value2, "fwVersion");
            return (Criteria) this;
        }

        public Criteria andHwVersionIsNull() {
            addCriterion("hw_version is null");
            return (Criteria) this;
        }

        public Criteria andHwVersionIsNotNull() {
            addCriterion("hw_version is not null");
            return (Criteria) this;
        }

        public Criteria andHwVersionEqualTo(String value) {
            addCriterion("hw_version =", value, "hwVersion");
            return (Criteria) this;
        }

        public Criteria andHwVersionNotEqualTo(String value) {
            addCriterion("hw_version <>", value, "hwVersion");
            return (Criteria) this;
        }

        public Criteria andHwVersionGreaterThan(String value) {
            addCriterion("hw_version >", value, "hwVersion");
            return (Criteria) this;
        }

        public Criteria andHwVersionGreaterThanOrEqualTo(String value) {
            addCriterion("hw_version >=", value, "hwVersion");
            return (Criteria) this;
        }

        public Criteria andHwVersionLessThan(String value) {
            addCriterion("hw_version <", value, "hwVersion");
            return (Criteria) this;
        }

        public Criteria andHwVersionLessThanOrEqualTo(String value) {
            addCriterion("hw_version <=", value, "hwVersion");
            return (Criteria) this;
        }

        public Criteria andHwVersionLike(String value) {
            addCriterion("hw_version like", value, "hwVersion");
            return (Criteria) this;
        }

        public Criteria andHwVersionNotLike(String value) {
            addCriterion("hw_version not like", value, "hwVersion");
            return (Criteria) this;
        }

        public Criteria andHwVersionIn(List<String> values) {
            addCriterion("hw_version in", values, "hwVersion");
            return (Criteria) this;
        }

        public Criteria andHwVersionNotIn(List<String> values) {
            addCriterion("hw_version not in", values, "hwVersion");
            return (Criteria) this;
        }

        public Criteria andHwVersionBetween(String value1, String value2) {
            addCriterion("hw_version between", value1, value2, "hwVersion");
            return (Criteria) this;
        }

        public Criteria andHwVersionNotBetween(String value1, String value2) {
            addCriterion("hw_version not between", value1, value2, "hwVersion");
            return (Criteria) this;
        }

        public Criteria andSigVersionIsNull() {
            addCriterion("sig_version is null");
            return (Criteria) this;
        }

        public Criteria andSigVersionIsNotNull() {
            addCriterion("sig_version is not null");
            return (Criteria) this;
        }

        public Criteria andSigVersionEqualTo(String value) {
            addCriterion("sig_version =", value, "sigVersion");
            return (Criteria) this;
        }

        public Criteria andSigVersionNotEqualTo(String value) {
            addCriterion("sig_version <>", value, "sigVersion");
            return (Criteria) this;
        }

        public Criteria andSigVersionGreaterThan(String value) {
            addCriterion("sig_version >", value, "sigVersion");
            return (Criteria) this;
        }

        public Criteria andSigVersionGreaterThanOrEqualTo(String value) {
            addCriterion("sig_version >=", value, "sigVersion");
            return (Criteria) this;
        }

        public Criteria andSigVersionLessThan(String value) {
            addCriterion("sig_version <", value, "sigVersion");
            return (Criteria) this;
        }

        public Criteria andSigVersionLessThanOrEqualTo(String value) {
            addCriterion("sig_version <=", value, "sigVersion");
            return (Criteria) this;
        }

        public Criteria andSigVersionLike(String value) {
            addCriterion("sig_version like", value, "sigVersion");
            return (Criteria) this;
        }

        public Criteria andSigVersionNotLike(String value) {
            addCriterion("sig_version not like", value, "sigVersion");
            return (Criteria) this;
        }

        public Criteria andSigVersionIn(List<String> values) {
            addCriterion("sig_version in", values, "sigVersion");
            return (Criteria) this;
        }

        public Criteria andSigVersionNotIn(List<String> values) {
            addCriterion("sig_version not in", values, "sigVersion");
            return (Criteria) this;
        }

        public Criteria andSigVersionBetween(String value1, String value2) {
            addCriterion("sig_version between", value1, value2, "sigVersion");
            return (Criteria) this;
        }

        public Criteria andSigVersionNotBetween(String value1, String value2) {
            addCriterion("sig_version not between", value1, value2, "sigVersion");
            return (Criteria) this;
        }

        public Criteria andMacIsNull() {
            addCriterion("mac is null");
            return (Criteria) this;
        }

        public Criteria andMacIsNotNull() {
            addCriterion("mac is not null");
            return (Criteria) this;
        }

        public Criteria andMacEqualTo(String value) {
            addCriterion("mac =", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotEqualTo(String value) {
            addCriterion("mac <>", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacGreaterThan(String value) {
            addCriterion("mac >", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacGreaterThanOrEqualTo(String value) {
            addCriterion("mac >=", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLessThan(String value) {
            addCriterion("mac <", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLessThanOrEqualTo(String value) {
            addCriterion("mac <=", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLike(String value) {
            addCriterion("mac like", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotLike(String value) {
            addCriterion("mac not like", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacIn(List<String> values) {
            addCriterion("mac in", values, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotIn(List<String> values) {
            addCriterion("mac not in", values, "mac");
            return (Criteria) this;
        }

        public Criteria andMacBetween(String value1, String value2) {
            addCriterion("mac between", value1, value2, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotBetween(String value1, String value2) {
            addCriterion("mac not between", value1, value2, "mac");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdIsNull() {
            addCriterion("manufacturer_id is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdIsNotNull() {
            addCriterion("manufacturer_id is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdEqualTo(String value) {
            addCriterion("manufacturer_id =", value, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdNotEqualTo(String value) {
            addCriterion("manufacturer_id <>", value, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdGreaterThan(String value) {
            addCriterion("manufacturer_id >", value, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdGreaterThanOrEqualTo(String value) {
            addCriterion("manufacturer_id >=", value, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdLessThan(String value) {
            addCriterion("manufacturer_id <", value, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdLessThanOrEqualTo(String value) {
            addCriterion("manufacturer_id <=", value, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdLike(String value) {
            addCriterion("manufacturer_id like", value, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdNotLike(String value) {
            addCriterion("manufacturer_id not like", value, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdIn(List<String> values) {
            addCriterion("manufacturer_id in", values, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdNotIn(List<String> values) {
            addCriterion("manufacturer_id not in", values, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdBetween(String value1, String value2) {
            addCriterion("manufacturer_id between", value1, value2, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdNotBetween(String value1, String value2) {
            addCriterion("manufacturer_id not between", value1, value2, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameIsNull() {
            addCriterion("manufacturer_name is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameIsNotNull() {
            addCriterion("manufacturer_name is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameEqualTo(String value) {
            addCriterion("manufacturer_name =", value, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameNotEqualTo(String value) {
            addCriterion("manufacturer_name <>", value, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameGreaterThan(String value) {
            addCriterion("manufacturer_name >", value, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameGreaterThanOrEqualTo(String value) {
            addCriterion("manufacturer_name >=", value, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameLessThan(String value) {
            addCriterion("manufacturer_name <", value, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameLessThanOrEqualTo(String value) {
            addCriterion("manufacturer_name <=", value, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameLike(String value) {
            addCriterion("manufacturer_name like", value, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameNotLike(String value) {
            addCriterion("manufacturer_name not like", value, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameIn(List<String> values) {
            addCriterion("manufacturer_name in", values, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameNotIn(List<String> values) {
            addCriterion("manufacturer_name not in", values, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameBetween(String value1, String value2) {
            addCriterion("manufacturer_name between", value1, value2, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameNotBetween(String value1, String value2) {
            addCriterion("manufacturer_name not between", value1, value2, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("model like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("model not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("model not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeIsNull() {
            addCriterion("protocol_type is null");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeIsNotNull() {
            addCriterion("protocol_type is not null");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeEqualTo(String value) {
            addCriterion("protocol_type =", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeNotEqualTo(String value) {
            addCriterion("protocol_type <>", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeGreaterThan(String value) {
            addCriterion("protocol_type >", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeGreaterThanOrEqualTo(String value) {
            addCriterion("protocol_type >=", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeLessThan(String value) {
            addCriterion("protocol_type <", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeLessThanOrEqualTo(String value) {
            addCriterion("protocol_type <=", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeLike(String value) {
            addCriterion("protocol_type like", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeNotLike(String value) {
            addCriterion("protocol_type not like", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeIn(List<String> values) {
            addCriterion("protocol_type in", values, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeNotIn(List<String> values) {
            addCriterion("protocol_type not in", values, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeBetween(String value1, String value2) {
            addCriterion("protocol_type between", value1, value2, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeNotBetween(String value1, String value2) {
            addCriterion("protocol_type not between", value1, value2, "protocolType");
            return (Criteria) this;
        }

        public Criteria andStatusDetailIsNull() {
            addCriterion("status_detail is null");
            return (Criteria) this;
        }

        public Criteria andStatusDetailIsNotNull() {
            addCriterion("status_detail is not null");
            return (Criteria) this;
        }

        public Criteria andStatusDetailEqualTo(String value) {
            addCriterion("status_detail =", value, "statusDetail");
            return (Criteria) this;
        }

        public Criteria andStatusDetailNotEqualTo(String value) {
            addCriterion("status_detail <>", value, "statusDetail");
            return (Criteria) this;
        }

        public Criteria andStatusDetailGreaterThan(String value) {
            addCriterion("status_detail >", value, "statusDetail");
            return (Criteria) this;
        }

        public Criteria andStatusDetailGreaterThanOrEqualTo(String value) {
            addCriterion("status_detail >=", value, "statusDetail");
            return (Criteria) this;
        }

        public Criteria andStatusDetailLessThan(String value) {
            addCriterion("status_detail <", value, "statusDetail");
            return (Criteria) this;
        }

        public Criteria andStatusDetailLessThanOrEqualTo(String value) {
            addCriterion("status_detail <=", value, "statusDetail");
            return (Criteria) this;
        }

        public Criteria andStatusDetailLike(String value) {
            addCriterion("status_detail like", value, "statusDetail");
            return (Criteria) this;
        }

        public Criteria andStatusDetailNotLike(String value) {
            addCriterion("status_detail not like", value, "statusDetail");
            return (Criteria) this;
        }

        public Criteria andStatusDetailIn(List<String> values) {
            addCriterion("status_detail in", values, "statusDetail");
            return (Criteria) this;
        }

        public Criteria andStatusDetailNotIn(List<String> values) {
            addCriterion("status_detail not in", values, "statusDetail");
            return (Criteria) this;
        }

        public Criteria andStatusDetailBetween(String value1, String value2) {
            addCriterion("status_detail between", value1, value2, "statusDetail");
            return (Criteria) this;
        }

        public Criteria andStatusDetailNotBetween(String value1, String value2) {
            addCriterion("status_detail not between", value1, value2, "statusDetail");
            return (Criteria) this;
        }

        public Criteria andMuteIsNull() {
            addCriterion("mute is null");
            return (Criteria) this;
        }

        public Criteria andMuteIsNotNull() {
            addCriterion("mute is not null");
            return (Criteria) this;
        }

        public Criteria andMuteEqualTo(String value) {
            addCriterion("mute =", value, "mute");
            return (Criteria) this;
        }

        public Criteria andMuteNotEqualTo(String value) {
            addCriterion("mute <>", value, "mute");
            return (Criteria) this;
        }

        public Criteria andMuteGreaterThan(String value) {
            addCriterion("mute >", value, "mute");
            return (Criteria) this;
        }

        public Criteria andMuteGreaterThanOrEqualTo(String value) {
            addCriterion("mute >=", value, "mute");
            return (Criteria) this;
        }

        public Criteria andMuteLessThan(String value) {
            addCriterion("mute <", value, "mute");
            return (Criteria) this;
        }

        public Criteria andMuteLessThanOrEqualTo(String value) {
            addCriterion("mute <=", value, "mute");
            return (Criteria) this;
        }

        public Criteria andMuteLike(String value) {
            addCriterion("mute like", value, "mute");
            return (Criteria) this;
        }

        public Criteria andMuteNotLike(String value) {
            addCriterion("mute not like", value, "mute");
            return (Criteria) this;
        }

        public Criteria andMuteIn(List<String> values) {
            addCriterion("mute in", values, "mute");
            return (Criteria) this;
        }

        public Criteria andMuteNotIn(List<String> values) {
            addCriterion("mute not in", values, "mute");
            return (Criteria) this;
        }

        public Criteria andMuteBetween(String value1, String value2) {
            addCriterion("mute between", value1, value2, "mute");
            return (Criteria) this;
        }

        public Criteria andMuteNotBetween(String value1, String value2) {
            addCriterion("mute not between", value1, value2, "mute");
            return (Criteria) this;
        }

        public Criteria andSupportedSecurityIsNull() {
            addCriterion("supported_security is null");
            return (Criteria) this;
        }

        public Criteria andSupportedSecurityIsNotNull() {
            addCriterion("supported_security is not null");
            return (Criteria) this;
        }

        public Criteria andSupportedSecurityEqualTo(String value) {
            addCriterion("supported_security =", value, "supportedSecurity");
            return (Criteria) this;
        }

        public Criteria andSupportedSecurityNotEqualTo(String value) {
            addCriterion("supported_security <>", value, "supportedSecurity");
            return (Criteria) this;
        }

        public Criteria andSupportedSecurityGreaterThan(String value) {
            addCriterion("supported_security >", value, "supportedSecurity");
            return (Criteria) this;
        }

        public Criteria andSupportedSecurityGreaterThanOrEqualTo(String value) {
            addCriterion("supported_security >=", value, "supportedSecurity");
            return (Criteria) this;
        }

        public Criteria andSupportedSecurityLessThan(String value) {
            addCriterion("supported_security <", value, "supportedSecurity");
            return (Criteria) this;
        }

        public Criteria andSupportedSecurityLessThanOrEqualTo(String value) {
            addCriterion("supported_security <=", value, "supportedSecurity");
            return (Criteria) this;
        }

        public Criteria andSupportedSecurityLike(String value) {
            addCriterion("supported_security like", value, "supportedSecurity");
            return (Criteria) this;
        }

        public Criteria andSupportedSecurityNotLike(String value) {
            addCriterion("supported_security not like", value, "supportedSecurity");
            return (Criteria) this;
        }

        public Criteria andSupportedSecurityIn(List<String> values) {
            addCriterion("supported_security in", values, "supportedSecurity");
            return (Criteria) this;
        }

        public Criteria andSupportedSecurityNotIn(List<String> values) {
            addCriterion("supported_security not in", values, "supportedSecurity");
            return (Criteria) this;
        }

        public Criteria andSupportedSecurityBetween(String value1, String value2) {
            addCriterion("supported_security between", value1, value2, "supportedSecurity");
            return (Criteria) this;
        }

        public Criteria andSupportedSecurityNotBetween(String value1, String value2) {
            addCriterion("supported_security not between", value1, value2, "supportedSecurity");
            return (Criteria) this;
        }

        public Criteria andIsSecurityIsNull() {
            addCriterion("is_security is null");
            return (Criteria) this;
        }

        public Criteria andIsSecurityIsNotNull() {
            addCriterion("is_security is not null");
            return (Criteria) this;
        }

        public Criteria andIsSecurityEqualTo(String value) {
            addCriterion("is_security =", value, "isSecurity");
            return (Criteria) this;
        }

        public Criteria andIsSecurityNotEqualTo(String value) {
            addCriterion("is_security <>", value, "isSecurity");
            return (Criteria) this;
        }

        public Criteria andIsSecurityGreaterThan(String value) {
            addCriterion("is_security >", value, "isSecurity");
            return (Criteria) this;
        }

        public Criteria andIsSecurityGreaterThanOrEqualTo(String value) {
            addCriterion("is_security >=", value, "isSecurity");
            return (Criteria) this;
        }

        public Criteria andIsSecurityLessThan(String value) {
            addCriterion("is_security <", value, "isSecurity");
            return (Criteria) this;
        }

        public Criteria andIsSecurityLessThanOrEqualTo(String value) {
            addCriterion("is_security <=", value, "isSecurity");
            return (Criteria) this;
        }

        public Criteria andIsSecurityLike(String value) {
            addCriterion("is_security like", value, "isSecurity");
            return (Criteria) this;
        }

        public Criteria andIsSecurityNotLike(String value) {
            addCriterion("is_security not like", value, "isSecurity");
            return (Criteria) this;
        }

        public Criteria andIsSecurityIn(List<String> values) {
            addCriterion("is_security in", values, "isSecurity");
            return (Criteria) this;
        }

        public Criteria andIsSecurityNotIn(List<String> values) {
            addCriterion("is_security not in", values, "isSecurity");
            return (Criteria) this;
        }

        public Criteria andIsSecurityBetween(String value1, String value2) {
            addCriterion("is_security between", value1, value2, "isSecurity");
            return (Criteria) this;
        }

        public Criteria andIsSecurityNotBetween(String value1, String value2) {
            addCriterion("is_security not between", value1, value2, "isSecurity");
            return (Criteria) this;
        }

        public Criteria andSignalStrengthIsNull() {
            addCriterion("signal_strength is null");
            return (Criteria) this;
        }

        public Criteria andSignalStrengthIsNotNull() {
            addCriterion("signal_strength is not null");
            return (Criteria) this;
        }

        public Criteria andSignalStrengthEqualTo(String value) {
            addCriterion("signal_strength =", value, "signalStrength");
            return (Criteria) this;
        }

        public Criteria andSignalStrengthNotEqualTo(String value) {
            addCriterion("signal_strength <>", value, "signalStrength");
            return (Criteria) this;
        }

        public Criteria andSignalStrengthGreaterThan(String value) {
            addCriterion("signal_strength >", value, "signalStrength");
            return (Criteria) this;
        }

        public Criteria andSignalStrengthGreaterThanOrEqualTo(String value) {
            addCriterion("signal_strength >=", value, "signalStrength");
            return (Criteria) this;
        }

        public Criteria andSignalStrengthLessThan(String value) {
            addCriterion("signal_strength <", value, "signalStrength");
            return (Criteria) this;
        }

        public Criteria andSignalStrengthLessThanOrEqualTo(String value) {
            addCriterion("signal_strength <=", value, "signalStrength");
            return (Criteria) this;
        }

        public Criteria andSignalStrengthLike(String value) {
            addCriterion("signal_strength like", value, "signalStrength");
            return (Criteria) this;
        }

        public Criteria andSignalStrengthNotLike(String value) {
            addCriterion("signal_strength not like", value, "signalStrength");
            return (Criteria) this;
        }

        public Criteria andSignalStrengthIn(List<String> values) {
            addCriterion("signal_strength in", values, "signalStrength");
            return (Criteria) this;
        }

        public Criteria andSignalStrengthNotIn(List<String> values) {
            addCriterion("signal_strength not in", values, "signalStrength");
            return (Criteria) this;
        }

        public Criteria andSignalStrengthBetween(String value1, String value2) {
            addCriterion("signal_strength between", value1, value2, "signalStrength");
            return (Criteria) this;
        }

        public Criteria andSignalStrengthNotBetween(String value1, String value2) {
            addCriterion("signal_strength not between", value1, value2, "signalStrength");
            return (Criteria) this;
        }

        public Criteria andBatteryLevelIsNull() {
            addCriterion("battery_level is null");
            return (Criteria) this;
        }

        public Criteria andBatteryLevelIsNotNull() {
            addCriterion("battery_level is not null");
            return (Criteria) this;
        }

        public Criteria andBatteryLevelEqualTo(String value) {
            addCriterion("battery_level =", value, "batteryLevel");
            return (Criteria) this;
        }

        public Criteria andBatteryLevelNotEqualTo(String value) {
            addCriterion("battery_level <>", value, "batteryLevel");
            return (Criteria) this;
        }

        public Criteria andBatteryLevelGreaterThan(String value) {
            addCriterion("battery_level >", value, "batteryLevel");
            return (Criteria) this;
        }

        public Criteria andBatteryLevelGreaterThanOrEqualTo(String value) {
            addCriterion("battery_level >=", value, "batteryLevel");
            return (Criteria) this;
        }

        public Criteria andBatteryLevelLessThan(String value) {
            addCriterion("battery_level <", value, "batteryLevel");
            return (Criteria) this;
        }

        public Criteria andBatteryLevelLessThanOrEqualTo(String value) {
            addCriterion("battery_level <=", value, "batteryLevel");
            return (Criteria) this;
        }

        public Criteria andBatteryLevelLike(String value) {
            addCriterion("battery_level like", value, "batteryLevel");
            return (Criteria) this;
        }

        public Criteria andBatteryLevelNotLike(String value) {
            addCriterion("battery_level not like", value, "batteryLevel");
            return (Criteria) this;
        }

        public Criteria andBatteryLevelIn(List<String> values) {
            addCriterion("battery_level in", values, "batteryLevel");
            return (Criteria) this;
        }

        public Criteria andBatteryLevelNotIn(List<String> values) {
            addCriterion("battery_level not in", values, "batteryLevel");
            return (Criteria) this;
        }

        public Criteria andBatteryLevelBetween(String value1, String value2) {
            addCriterion("battery_level between", value1, value2, "batteryLevel");
            return (Criteria) this;
        }

        public Criteria andBatteryLevelNotBetween(String value1, String value2) {
            addCriterion("battery_level not between", value1, value2, "batteryLevel");
            return (Criteria) this;
        }

        public Criteria andIsHdIsNull() {
            addCriterion("is_hd is null");
            return (Criteria) this;
        }

        public Criteria andIsHdIsNotNull() {
            addCriterion("is_hd is not null");
            return (Criteria) this;
        }

        public Criteria andIsHdEqualTo(String value) {
            addCriterion("is_hd =", value, "isHd");
            return (Criteria) this;
        }

        public Criteria andIsHdNotEqualTo(String value) {
            addCriterion("is_hd <>", value, "isHd");
            return (Criteria) this;
        }

        public Criteria andIsHdGreaterThan(String value) {
            addCriterion("is_hd >", value, "isHd");
            return (Criteria) this;
        }

        public Criteria andIsHdGreaterThanOrEqualTo(String value) {
            addCriterion("is_hd >=", value, "isHd");
            return (Criteria) this;
        }

        public Criteria andIsHdLessThan(String value) {
            addCriterion("is_hd <", value, "isHd");
            return (Criteria) this;
        }

        public Criteria andIsHdLessThanOrEqualTo(String value) {
            addCriterion("is_hd <=", value, "isHd");
            return (Criteria) this;
        }

        public Criteria andIsHdLike(String value) {
            addCriterion("is_hd like", value, "isHd");
            return (Criteria) this;
        }

        public Criteria andIsHdNotLike(String value) {
            addCriterion("is_hd not like", value, "isHd");
            return (Criteria) this;
        }

        public Criteria andIsHdIn(List<String> values) {
            addCriterion("is_hd in", values, "isHd");
            return (Criteria) this;
        }

        public Criteria andIsHdNotIn(List<String> values) {
            addCriterion("is_hd not in", values, "isHd");
            return (Criteria) this;
        }

        public Criteria andIsHdBetween(String value1, String value2) {
            addCriterion("is_hd between", value1, value2, "isHd");
            return (Criteria) this;
        }

        public Criteria andIsHdNotBetween(String value1, String value2) {
            addCriterion("is_hd not between", value1, value2, "isHd");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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