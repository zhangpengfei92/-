package com.jcl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andExpiredateIsNull() {
            addCriterion("expiredate is null");
            return (Criteria) this;
        }

        public Criteria andExpiredateIsNotNull() {
            addCriterion("expiredate is not null");
            return (Criteria) this;
        }

        public Criteria andExpiredateEqualTo(Date value) {
            addCriterion("expiredate =", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateNotEqualTo(Date value) {
            addCriterion("expiredate <>", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateGreaterThan(Date value) {
            addCriterion("expiredate >", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateGreaterThanOrEqualTo(Date value) {
            addCriterion("expiredate >=", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateLessThan(Date value) {
            addCriterion("expiredate <", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateLessThanOrEqualTo(Date value) {
            addCriterion("expiredate <=", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateIn(List<Date> values) {
            addCriterion("expiredate in", values, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateNotIn(List<Date> values) {
            addCriterion("expiredate not in", values, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateBetween(Date value1, Date value2) {
            addCriterion("expiredate between", value1, value2, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateNotBetween(Date value1, Date value2) {
            addCriterion("expiredate not between", value1, value2, "expiredate");
            return (Criteria) this;
        }

        public Criteria andAdminIsNull() {
            addCriterion("admin is null");
            return (Criteria) this;
        }

        public Criteria andAdminIsNotNull() {
            addCriterion("admin is not null");
            return (Criteria) this;
        }

        public Criteria andAdminEqualTo(Integer value) {
            addCriterion("admin =", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminNotEqualTo(Integer value) {
            addCriterion("admin <>", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminGreaterThan(Integer value) {
            addCriterion("admin >", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin >=", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminLessThan(Integer value) {
            addCriterion("admin <", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminLessThanOrEqualTo(Integer value) {
            addCriterion("admin <=", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminIn(List<Integer> values) {
            addCriterion("admin in", values, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminNotIn(List<Integer> values) {
            addCriterion("admin not in", values, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminBetween(Integer value1, Integer value2) {
            addCriterion("admin between", value1, value2, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminNotBetween(Integer value1, Integer value2) {
            addCriterion("admin not between", value1, value2, "admin");
            return (Criteria) this;
        }

        public Criteria andMinverIsNull() {
            addCriterion("minver is null");
            return (Criteria) this;
        }

        public Criteria andMinverIsNotNull() {
            addCriterion("minver is not null");
            return (Criteria) this;
        }

        public Criteria andMinverEqualTo(Integer value) {
            addCriterion("minver =", value, "minver");
            return (Criteria) this;
        }

        public Criteria andMinverNotEqualTo(Integer value) {
            addCriterion("minver <>", value, "minver");
            return (Criteria) this;
        }

        public Criteria andMinverGreaterThan(Integer value) {
            addCriterion("minver >", value, "minver");
            return (Criteria) this;
        }

        public Criteria andMinverGreaterThanOrEqualTo(Integer value) {
            addCriterion("minver >=", value, "minver");
            return (Criteria) this;
        }

        public Criteria andMinverLessThan(Integer value) {
            addCriterion("minver <", value, "minver");
            return (Criteria) this;
        }

        public Criteria andMinverLessThanOrEqualTo(Integer value) {
            addCriterion("minver <=", value, "minver");
            return (Criteria) this;
        }

        public Criteria andMinverIn(List<Integer> values) {
            addCriterion("minver in", values, "minver");
            return (Criteria) this;
        }

        public Criteria andMinverNotIn(List<Integer> values) {
            addCriterion("minver not in", values, "minver");
            return (Criteria) this;
        }

        public Criteria andMinverBetween(Integer value1, Integer value2) {
            addCriterion("minver between", value1, value2, "minver");
            return (Criteria) this;
        }

        public Criteria andMinverNotBetween(Integer value1, Integer value2) {
            addCriterion("minver not between", value1, value2, "minver");
            return (Criteria) this;
        }

        public Criteria andLasttimeIsNull() {
            addCriterion("lasttime is null");
            return (Criteria) this;
        }

        public Criteria andLasttimeIsNotNull() {
            addCriterion("lasttime is not null");
            return (Criteria) this;
        }

        public Criteria andLasttimeEqualTo(Date value) {
            addCriterion("lasttime =", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeNotEqualTo(Date value) {
            addCriterion("lasttime <>", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeGreaterThan(Date value) {
            addCriterion("lasttime >", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lasttime >=", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeLessThan(Date value) {
            addCriterion("lasttime <", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeLessThanOrEqualTo(Date value) {
            addCriterion("lasttime <=", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeIn(List<Date> values) {
            addCriterion("lasttime in", values, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeNotIn(List<Date> values) {
            addCriterion("lasttime not in", values, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeBetween(Date value1, Date value2) {
            addCriterion("lasttime between", value1, value2, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeNotBetween(Date value1, Date value2) {
            addCriterion("lasttime not between", value1, value2, "lasttime");
            return (Criteria) this;
        }

        public Criteria andInfoIsNull() {
            addCriterion("info is null");
            return (Criteria) this;
        }

        public Criteria andInfoIsNotNull() {
            addCriterion("info is not null");
            return (Criteria) this;
        }

        public Criteria andInfoEqualTo(String value) {
            addCriterion("info =", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotEqualTo(String value) {
            addCriterion("info <>", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoGreaterThan(String value) {
            addCriterion("info >", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoGreaterThanOrEqualTo(String value) {
            addCriterion("info >=", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLessThan(String value) {
            addCriterion("info <", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLessThanOrEqualTo(String value) {
            addCriterion("info <=", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLike(String value) {
            addCriterion("info like", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotLike(String value) {
            addCriterion("info not like", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoIn(List<String> values) {
            addCriterion("info in", values, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotIn(List<String> values) {
            addCriterion("info not in", values, "info");
            return (Criteria) this;
        }

        public Criteria andInfoBetween(String value1, String value2) {
            addCriterion("info between", value1, value2, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotBetween(String value1, String value2) {
            addCriterion("info not between", value1, value2, "info");
            return (Criteria) this;
        }

        public Criteria andOnlineIsNull() {
            addCriterion("online is null");
            return (Criteria) this;
        }

        public Criteria andOnlineIsNotNull() {
            addCriterion("online is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineEqualTo(String value) {
            addCriterion("online =", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotEqualTo(String value) {
            addCriterion("online <>", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineGreaterThan(String value) {
            addCriterion("online >", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineGreaterThanOrEqualTo(String value) {
            addCriterion("online >=", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineLessThan(String value) {
            addCriterion("online <", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineLessThanOrEqualTo(String value) {
            addCriterion("online <=", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineLike(String value) {
            addCriterion("online like", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotLike(String value) {
            addCriterion("online not like", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineIn(List<String> values) {
            addCriterion("online in", values, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotIn(List<String> values) {
            addCriterion("online not in", values, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineBetween(String value1, String value2) {
            addCriterion("online between", value1, value2, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotBetween(String value1, String value2) {
            addCriterion("online not between", value1, value2, "online");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andNetcardIsNull() {
            addCriterion("netcard is null");
            return (Criteria) this;
        }

        public Criteria andNetcardIsNotNull() {
            addCriterion("netcard is not null");
            return (Criteria) this;
        }

        public Criteria andNetcardEqualTo(String value) {
            addCriterion("netcard =", value, "netcard");
            return (Criteria) this;
        }

        public Criteria andNetcardNotEqualTo(String value) {
            addCriterion("netcard <>", value, "netcard");
            return (Criteria) this;
        }

        public Criteria andNetcardGreaterThan(String value) {
            addCriterion("netcard >", value, "netcard");
            return (Criteria) this;
        }

        public Criteria andNetcardGreaterThanOrEqualTo(String value) {
            addCriterion("netcard >=", value, "netcard");
            return (Criteria) this;
        }

        public Criteria andNetcardLessThan(String value) {
            addCriterion("netcard <", value, "netcard");
            return (Criteria) this;
        }

        public Criteria andNetcardLessThanOrEqualTo(String value) {
            addCriterion("netcard <=", value, "netcard");
            return (Criteria) this;
        }

        public Criteria andNetcardLike(String value) {
            addCriterion("netcard like", value, "netcard");
            return (Criteria) this;
        }

        public Criteria andNetcardNotLike(String value) {
            addCriterion("netcard not like", value, "netcard");
            return (Criteria) this;
        }

        public Criteria andNetcardIn(List<String> values) {
            addCriterion("netcard in", values, "netcard");
            return (Criteria) this;
        }

        public Criteria andNetcardNotIn(List<String> values) {
            addCriterion("netcard not in", values, "netcard");
            return (Criteria) this;
        }

        public Criteria andNetcardBetween(String value1, String value2) {
            addCriterion("netcard between", value1, value2, "netcard");
            return (Criteria) this;
        }

        public Criteria andNetcardNotBetween(String value1, String value2) {
            addCriterion("netcard not between", value1, value2, "netcard");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("starttime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("starttime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterion("starttime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterion("starttime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterion("starttime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("starttime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterion("starttime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("starttime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterion("starttime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterion("starttime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterion("starttime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("starttime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endtime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endtime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterion("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterion("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterion("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterion("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterion("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterion("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterion("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("endtime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andLastmonthIsNull() {
            addCriterion("lastmonth is null");
            return (Criteria) this;
        }

        public Criteria andLastmonthIsNotNull() {
            addCriterion("lastmonth is not null");
            return (Criteria) this;
        }

        public Criteria andLastmonthEqualTo(Integer value) {
            addCriterion("lastmonth =", value, "lastmonth");
            return (Criteria) this;
        }

        public Criteria andLastmonthNotEqualTo(Integer value) {
            addCriterion("lastmonth <>", value, "lastmonth");
            return (Criteria) this;
        }

        public Criteria andLastmonthGreaterThan(Integer value) {
            addCriterion("lastmonth >", value, "lastmonth");
            return (Criteria) this;
        }

        public Criteria andLastmonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("lastmonth >=", value, "lastmonth");
            return (Criteria) this;
        }

        public Criteria andLastmonthLessThan(Integer value) {
            addCriterion("lastmonth <", value, "lastmonth");
            return (Criteria) this;
        }

        public Criteria andLastmonthLessThanOrEqualTo(Integer value) {
            addCriterion("lastmonth <=", value, "lastmonth");
            return (Criteria) this;
        }

        public Criteria andLastmonthIn(List<Integer> values) {
            addCriterion("lastmonth in", values, "lastmonth");
            return (Criteria) this;
        }

        public Criteria andLastmonthNotIn(List<Integer> values) {
            addCriterion("lastmonth not in", values, "lastmonth");
            return (Criteria) this;
        }

        public Criteria andLastmonthBetween(Integer value1, Integer value2) {
            addCriterion("lastmonth between", value1, value2, "lastmonth");
            return (Criteria) this;
        }

        public Criteria andLastmonthNotBetween(Integer value1, Integer value2) {
            addCriterion("lastmonth not between", value1, value2, "lastmonth");
            return (Criteria) this;
        }

        public Criteria andHumingIsNull() {
            addCriterion("huming is null");
            return (Criteria) this;
        }

        public Criteria andHumingIsNotNull() {
            addCriterion("huming is not null");
            return (Criteria) this;
        }

        public Criteria andHumingEqualTo(Integer value) {
            addCriterion("huming =", value, "huming");
            return (Criteria) this;
        }

        public Criteria andHumingNotEqualTo(Integer value) {
            addCriterion("huming <>", value, "huming");
            return (Criteria) this;
        }

        public Criteria andHumingGreaterThan(Integer value) {
            addCriterion("huming >", value, "huming");
            return (Criteria) this;
        }

        public Criteria andHumingGreaterThanOrEqualTo(Integer value) {
            addCriterion("huming >=", value, "huming");
            return (Criteria) this;
        }

        public Criteria andHumingLessThan(Integer value) {
            addCriterion("huming <", value, "huming");
            return (Criteria) this;
        }

        public Criteria andHumingLessThanOrEqualTo(Integer value) {
            addCriterion("huming <=", value, "huming");
            return (Criteria) this;
        }

        public Criteria andHumingIn(List<Integer> values) {
            addCriterion("huming in", values, "huming");
            return (Criteria) this;
        }

        public Criteria andHumingNotIn(List<Integer> values) {
            addCriterion("huming not in", values, "huming");
            return (Criteria) this;
        }

        public Criteria andHumingBetween(Integer value1, Integer value2) {
            addCriterion("huming between", value1, value2, "huming");
            return (Criteria) this;
        }

        public Criteria andHumingNotBetween(Integer value1, Integer value2) {
            addCriterion("huming not between", value1, value2, "huming");
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

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andPaymoneyIsNull() {
            addCriterion("paymoney is null");
            return (Criteria) this;
        }

        public Criteria andPaymoneyIsNotNull() {
            addCriterion("paymoney is not null");
            return (Criteria) this;
        }

        public Criteria andPaymoneyEqualTo(Double value) {
            addCriterion("paymoney =", value, "paymoney");
            return (Criteria) this;
        }

        public Criteria andPaymoneyNotEqualTo(Double value) {
            addCriterion("paymoney <>", value, "paymoney");
            return (Criteria) this;
        }

        public Criteria andPaymoneyGreaterThan(Double value) {
            addCriterion("paymoney >", value, "paymoney");
            return (Criteria) this;
        }

        public Criteria andPaymoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("paymoney >=", value, "paymoney");
            return (Criteria) this;
        }

        public Criteria andPaymoneyLessThan(Double value) {
            addCriterion("paymoney <", value, "paymoney");
            return (Criteria) this;
        }

        public Criteria andPaymoneyLessThanOrEqualTo(Double value) {
            addCriterion("paymoney <=", value, "paymoney");
            return (Criteria) this;
        }

        public Criteria andPaymoneyIn(List<Double> values) {
            addCriterion("paymoney in", values, "paymoney");
            return (Criteria) this;
        }

        public Criteria andPaymoneyNotIn(List<Double> values) {
            addCriterion("paymoney not in", values, "paymoney");
            return (Criteria) this;
        }

        public Criteria andPaymoneyBetween(Double value1, Double value2) {
            addCriterion("paymoney between", value1, value2, "paymoney");
            return (Criteria) this;
        }

        public Criteria andPaymoneyNotBetween(Double value1, Double value2) {
            addCriterion("paymoney not between", value1, value2, "paymoney");
            return (Criteria) this;
        }

        public Criteria andUcnameIsNull() {
            addCriterion("ucname is null");
            return (Criteria) this;
        }

        public Criteria andUcnameIsNotNull() {
            addCriterion("ucname is not null");
            return (Criteria) this;
        }

        public Criteria andUcnameEqualTo(String value) {
            addCriterion("ucname =", value, "ucname");
            return (Criteria) this;
        }

        public Criteria andUcnameNotEqualTo(String value) {
            addCriterion("ucname <>", value, "ucname");
            return (Criteria) this;
        }

        public Criteria andUcnameGreaterThan(String value) {
            addCriterion("ucname >", value, "ucname");
            return (Criteria) this;
        }

        public Criteria andUcnameGreaterThanOrEqualTo(String value) {
            addCriterion("ucname >=", value, "ucname");
            return (Criteria) this;
        }

        public Criteria andUcnameLessThan(String value) {
            addCriterion("ucname <", value, "ucname");
            return (Criteria) this;
        }

        public Criteria andUcnameLessThanOrEqualTo(String value) {
            addCriterion("ucname <=", value, "ucname");
            return (Criteria) this;
        }

        public Criteria andUcnameLike(String value) {
            addCriterion("ucname like", value, "ucname");
            return (Criteria) this;
        }

        public Criteria andUcnameNotLike(String value) {
            addCriterion("ucname not like", value, "ucname");
            return (Criteria) this;
        }

        public Criteria andUcnameIn(List<String> values) {
            addCriterion("ucname in", values, "ucname");
            return (Criteria) this;
        }

        public Criteria andUcnameNotIn(List<String> values) {
            addCriterion("ucname not in", values, "ucname");
            return (Criteria) this;
        }

        public Criteria andUcnameBetween(String value1, String value2) {
            addCriterion("ucname between", value1, value2, "ucname");
            return (Criteria) this;
        }

        public Criteria andUcnameNotBetween(String value1, String value2) {
            addCriterion("ucname not between", value1, value2, "ucname");
            return (Criteria) this;
        }

        public Criteria andPaytimeIsNull() {
            addCriterion("paytime is null");
            return (Criteria) this;
        }

        public Criteria andPaytimeIsNotNull() {
            addCriterion("paytime is not null");
            return (Criteria) this;
        }

        public Criteria andPaytimeEqualTo(Date value) {
            addCriterion("paytime =", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotEqualTo(Date value) {
            addCriterion("paytime <>", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeGreaterThan(Date value) {
            addCriterion("paytime >", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("paytime >=", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeLessThan(Date value) {
            addCriterion("paytime <", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeLessThanOrEqualTo(Date value) {
            addCriterion("paytime <=", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeIn(List<Date> values) {
            addCriterion("paytime in", values, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotIn(List<Date> values) {
            addCriterion("paytime not in", values, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeBetween(Date value1, Date value2) {
            addCriterion("paytime between", value1, value2, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotBetween(Date value1, Date value2) {
            addCriterion("paytime not between", value1, value2, "paytime");
            return (Criteria) this;
        }

        public Criteria andSellerIsNull() {
            addCriterion("seller is null");
            return (Criteria) this;
        }

        public Criteria andSellerIsNotNull() {
            addCriterion("seller is not null");
            return (Criteria) this;
        }

        public Criteria andSellerEqualTo(String value) {
            addCriterion("seller =", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerNotEqualTo(String value) {
            addCriterion("seller <>", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerGreaterThan(String value) {
            addCriterion("seller >", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerGreaterThanOrEqualTo(String value) {
            addCriterion("seller >=", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerLessThan(String value) {
            addCriterion("seller <", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerLessThanOrEqualTo(String value) {
            addCriterion("seller <=", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerLike(String value) {
            addCriterion("seller like", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerNotLike(String value) {
            addCriterion("seller not like", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerIn(List<String> values) {
            addCriterion("seller in", values, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerNotIn(List<String> values) {
            addCriterion("seller not in", values, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerBetween(String value1, String value2) {
            addCriterion("seller between", value1, value2, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerNotBetween(String value1, String value2) {
            addCriterion("seller not between", value1, value2, "seller");
            return (Criteria) this;
        }

        public Criteria andFuncinfoIsNull() {
            addCriterion("funcinfo is null");
            return (Criteria) this;
        }

        public Criteria andFuncinfoIsNotNull() {
            addCriterion("funcinfo is not null");
            return (Criteria) this;
        }

        public Criteria andFuncinfoEqualTo(String value) {
            addCriterion("funcinfo =", value, "funcinfo");
            return (Criteria) this;
        }

        public Criteria andFuncinfoNotEqualTo(String value) {
            addCriterion("funcinfo <>", value, "funcinfo");
            return (Criteria) this;
        }

        public Criteria andFuncinfoGreaterThan(String value) {
            addCriterion("funcinfo >", value, "funcinfo");
            return (Criteria) this;
        }

        public Criteria andFuncinfoGreaterThanOrEqualTo(String value) {
            addCriterion("funcinfo >=", value, "funcinfo");
            return (Criteria) this;
        }

        public Criteria andFuncinfoLessThan(String value) {
            addCriterion("funcinfo <", value, "funcinfo");
            return (Criteria) this;
        }

        public Criteria andFuncinfoLessThanOrEqualTo(String value) {
            addCriterion("funcinfo <=", value, "funcinfo");
            return (Criteria) this;
        }

        public Criteria andFuncinfoLike(String value) {
            addCriterion("funcinfo like", value, "funcinfo");
            return (Criteria) this;
        }

        public Criteria andFuncinfoNotLike(String value) {
            addCriterion("funcinfo not like", value, "funcinfo");
            return (Criteria) this;
        }

        public Criteria andFuncinfoIn(List<String> values) {
            addCriterion("funcinfo in", values, "funcinfo");
            return (Criteria) this;
        }

        public Criteria andFuncinfoNotIn(List<String> values) {
            addCriterion("funcinfo not in", values, "funcinfo");
            return (Criteria) this;
        }

        public Criteria andFuncinfoBetween(String value1, String value2) {
            addCriterion("funcinfo between", value1, value2, "funcinfo");
            return (Criteria) this;
        }

        public Criteria andFuncinfoNotBetween(String value1, String value2) {
            addCriterion("funcinfo not between", value1, value2, "funcinfo");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNull() {
            addCriterion("usertype is null");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNotNull() {
            addCriterion("usertype is not null");
            return (Criteria) this;
        }

        public Criteria andUsertypeEqualTo(Integer value) {
            addCriterion("usertype =", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotEqualTo(Integer value) {
            addCriterion("usertype <>", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThan(Integer value) {
            addCriterion("usertype >", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("usertype >=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThan(Integer value) {
            addCriterion("usertype <", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThanOrEqualTo(Integer value) {
            addCriterion("usertype <=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeIn(List<Integer> values) {
            addCriterion("usertype in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotIn(List<Integer> values) {
            addCriterion("usertype not in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeBetween(Integer value1, Integer value2) {
            addCriterion("usertype between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotBetween(Integer value1, Integer value2) {
            addCriterion("usertype not between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andUpdatedatIsNull() {
            addCriterion("updatedAt is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedatIsNotNull() {
            addCriterion("updatedAt is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedatEqualTo(Date value) {
            addCriterion("updatedAt =", value, "updatedat");
            return (Criteria) this;
        }

        public Criteria andUpdatedatNotEqualTo(Date value) {
            addCriterion("updatedAt <>", value, "updatedat");
            return (Criteria) this;
        }

        public Criteria andUpdatedatGreaterThan(Date value) {
            addCriterion("updatedAt >", value, "updatedat");
            return (Criteria) this;
        }

        public Criteria andUpdatedatGreaterThanOrEqualTo(Date value) {
            addCriterion("updatedAt >=", value, "updatedat");
            return (Criteria) this;
        }

        public Criteria andUpdatedatLessThan(Date value) {
            addCriterion("updatedAt <", value, "updatedat");
            return (Criteria) this;
        }

        public Criteria andUpdatedatLessThanOrEqualTo(Date value) {
            addCriterion("updatedAt <=", value, "updatedat");
            return (Criteria) this;
        }

        public Criteria andUpdatedatIn(List<Date> values) {
            addCriterion("updatedAt in", values, "updatedat");
            return (Criteria) this;
        }

        public Criteria andUpdatedatNotIn(List<Date> values) {
            addCriterion("updatedAt not in", values, "updatedat");
            return (Criteria) this;
        }

        public Criteria andUpdatedatBetween(Date value1, Date value2) {
            addCriterion("updatedAt between", value1, value2, "updatedat");
            return (Criteria) this;
        }

        public Criteria andUpdatedatNotBetween(Date value1, Date value2) {
            addCriterion("updatedAt not between", value1, value2, "updatedat");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(String value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(String value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(String value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(String value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(String value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(String value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLike(String value) {
            addCriterion("flag like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotLike(String value) {
            addCriterion("flag not like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<String> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<String> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(String value1, String value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(String value1, String value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andSyncinfoIsNull() {
            addCriterion("syncinfo is null");
            return (Criteria) this;
        }

        public Criteria andSyncinfoIsNotNull() {
            addCriterion("syncinfo is not null");
            return (Criteria) this;
        }

        public Criteria andSyncinfoEqualTo(String value) {
            addCriterion("syncinfo =", value, "syncinfo");
            return (Criteria) this;
        }

        public Criteria andSyncinfoNotEqualTo(String value) {
            addCriterion("syncinfo <>", value, "syncinfo");
            return (Criteria) this;
        }

        public Criteria andSyncinfoGreaterThan(String value) {
            addCriterion("syncinfo >", value, "syncinfo");
            return (Criteria) this;
        }

        public Criteria andSyncinfoGreaterThanOrEqualTo(String value) {
            addCriterion("syncinfo >=", value, "syncinfo");
            return (Criteria) this;
        }

        public Criteria andSyncinfoLessThan(String value) {
            addCriterion("syncinfo <", value, "syncinfo");
            return (Criteria) this;
        }

        public Criteria andSyncinfoLessThanOrEqualTo(String value) {
            addCriterion("syncinfo <=", value, "syncinfo");
            return (Criteria) this;
        }

        public Criteria andSyncinfoLike(String value) {
            addCriterion("syncinfo like", value, "syncinfo");
            return (Criteria) this;
        }

        public Criteria andSyncinfoNotLike(String value) {
            addCriterion("syncinfo not like", value, "syncinfo");
            return (Criteria) this;
        }

        public Criteria andSyncinfoIn(List<String> values) {
            addCriterion("syncinfo in", values, "syncinfo");
            return (Criteria) this;
        }

        public Criteria andSyncinfoNotIn(List<String> values) {
            addCriterion("syncinfo not in", values, "syncinfo");
            return (Criteria) this;
        }

        public Criteria andSyncinfoBetween(String value1, String value2) {
            addCriterion("syncinfo between", value1, value2, "syncinfo");
            return (Criteria) this;
        }

        public Criteria andSyncinfoNotBetween(String value1, String value2) {
            addCriterion("syncinfo not between", value1, value2, "syncinfo");
            return (Criteria) this;
        }

        public Criteria andClientfromIsNull() {
            addCriterion("clientFrom is null");
            return (Criteria) this;
        }

        public Criteria andClientfromIsNotNull() {
            addCriterion("clientFrom is not null");
            return (Criteria) this;
        }

        public Criteria andClientfromEqualTo(String value) {
            addCriterion("clientFrom =", value, "clientfrom");
            return (Criteria) this;
        }

        public Criteria andClientfromNotEqualTo(String value) {
            addCriterion("clientFrom <>", value, "clientfrom");
            return (Criteria) this;
        }

        public Criteria andClientfromGreaterThan(String value) {
            addCriterion("clientFrom >", value, "clientfrom");
            return (Criteria) this;
        }

        public Criteria andClientfromGreaterThanOrEqualTo(String value) {
            addCriterion("clientFrom >=", value, "clientfrom");
            return (Criteria) this;
        }

        public Criteria andClientfromLessThan(String value) {
            addCriterion("clientFrom <", value, "clientfrom");
            return (Criteria) this;
        }

        public Criteria andClientfromLessThanOrEqualTo(String value) {
            addCriterion("clientFrom <=", value, "clientfrom");
            return (Criteria) this;
        }

        public Criteria andClientfromLike(String value) {
            addCriterion("clientFrom like", value, "clientfrom");
            return (Criteria) this;
        }

        public Criteria andClientfromNotLike(String value) {
            addCriterion("clientFrom not like", value, "clientfrom");
            return (Criteria) this;
        }

        public Criteria andClientfromIn(List<String> values) {
            addCriterion("clientFrom in", values, "clientfrom");
            return (Criteria) this;
        }

        public Criteria andClientfromNotIn(List<String> values) {
            addCriterion("clientFrom not in", values, "clientfrom");
            return (Criteria) this;
        }

        public Criteria andClientfromBetween(String value1, String value2) {
            addCriterion("clientFrom between", value1, value2, "clientfrom");
            return (Criteria) this;
        }

        public Criteria andClientfromNotBetween(String value1, String value2) {
            addCriterion("clientFrom not between", value1, value2, "clientfrom");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNull() {
            addCriterion("openid is null");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNotNull() {
            addCriterion("openid is not null");
            return (Criteria) this;
        }

        public Criteria andOpenidEqualTo(String value) {
            addCriterion("openid =", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotEqualTo(String value) {
            addCriterion("openid <>", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThan(String value) {
            addCriterion("openid >", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("openid >=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThan(String value) {
            addCriterion("openid <", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThanOrEqualTo(String value) {
            addCriterion("openid <=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLike(String value) {
            addCriterion("openid like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotLike(String value) {
            addCriterion("openid not like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidIn(List<String> values) {
            addCriterion("openid in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotIn(List<String> values) {
            addCriterion("openid not in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidBetween(String value1, String value2) {
            addCriterion("openid between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotBetween(String value1, String value2) {
            addCriterion("openid not between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andRegistfromIsNull() {
            addCriterion("registfrom is null");
            return (Criteria) this;
        }

        public Criteria andRegistfromIsNotNull() {
            addCriterion("registfrom is not null");
            return (Criteria) this;
        }

        public Criteria andRegistfromEqualTo(String value) {
            addCriterion("registfrom =", value, "registfrom");
            return (Criteria) this;
        }

        public Criteria andRegistfromNotEqualTo(String value) {
            addCriterion("registfrom <>", value, "registfrom");
            return (Criteria) this;
        }

        public Criteria andRegistfromGreaterThan(String value) {
            addCriterion("registfrom >", value, "registfrom");
            return (Criteria) this;
        }

        public Criteria andRegistfromGreaterThanOrEqualTo(String value) {
            addCriterion("registfrom >=", value, "registfrom");
            return (Criteria) this;
        }

        public Criteria andRegistfromLessThan(String value) {
            addCriterion("registfrom <", value, "registfrom");
            return (Criteria) this;
        }

        public Criteria andRegistfromLessThanOrEqualTo(String value) {
            addCriterion("registfrom <=", value, "registfrom");
            return (Criteria) this;
        }

        public Criteria andRegistfromLike(String value) {
            addCriterion("registfrom like", value, "registfrom");
            return (Criteria) this;
        }

        public Criteria andRegistfromNotLike(String value) {
            addCriterion("registfrom not like", value, "registfrom");
            return (Criteria) this;
        }

        public Criteria andRegistfromIn(List<String> values) {
            addCriterion("registfrom in", values, "registfrom");
            return (Criteria) this;
        }

        public Criteria andRegistfromNotIn(List<String> values) {
            addCriterion("registfrom not in", values, "registfrom");
            return (Criteria) this;
        }

        public Criteria andRegistfromBetween(String value1, String value2) {
            addCriterion("registfrom between", value1, value2, "registfrom");
            return (Criteria) this;
        }

        public Criteria andRegistfromNotBetween(String value1, String value2) {
            addCriterion("registfrom not between", value1, value2, "registfrom");
            return (Criteria) this;
        }

        public Criteria andHasmobileIsNull() {
            addCriterion("hasmobile is null");
            return (Criteria) this;
        }

        public Criteria andHasmobileIsNotNull() {
            addCriterion("hasmobile is not null");
            return (Criteria) this;
        }

        public Criteria andHasmobileEqualTo(Integer value) {
            addCriterion("hasmobile =", value, "hasmobile");
            return (Criteria) this;
        }

        public Criteria andHasmobileNotEqualTo(Integer value) {
            addCriterion("hasmobile <>", value, "hasmobile");
            return (Criteria) this;
        }

        public Criteria andHasmobileGreaterThan(Integer value) {
            addCriterion("hasmobile >", value, "hasmobile");
            return (Criteria) this;
        }

        public Criteria andHasmobileGreaterThanOrEqualTo(Integer value) {
            addCriterion("hasmobile >=", value, "hasmobile");
            return (Criteria) this;
        }

        public Criteria andHasmobileLessThan(Integer value) {
            addCriterion("hasmobile <", value, "hasmobile");
            return (Criteria) this;
        }

        public Criteria andHasmobileLessThanOrEqualTo(Integer value) {
            addCriterion("hasmobile <=", value, "hasmobile");
            return (Criteria) this;
        }

        public Criteria andHasmobileIn(List<Integer> values) {
            addCriterion("hasmobile in", values, "hasmobile");
            return (Criteria) this;
        }

        public Criteria andHasmobileNotIn(List<Integer> values) {
            addCriterion("hasmobile not in", values, "hasmobile");
            return (Criteria) this;
        }

        public Criteria andHasmobileBetween(Integer value1, Integer value2) {
            addCriterion("hasmobile between", value1, value2, "hasmobile");
            return (Criteria) this;
        }

        public Criteria andHasmobileNotBetween(Integer value1, Integer value2) {
            addCriterion("hasmobile not between", value1, value2, "hasmobile");
            return (Criteria) this;
        }

        public Criteria andPushtagIsNull() {
            addCriterion("pushTag is null");
            return (Criteria) this;
        }

        public Criteria andPushtagIsNotNull() {
            addCriterion("pushTag is not null");
            return (Criteria) this;
        }

        public Criteria andPushtagEqualTo(String value) {
            addCriterion("pushTag =", value, "pushtag");
            return (Criteria) this;
        }

        public Criteria andPushtagNotEqualTo(String value) {
            addCriterion("pushTag <>", value, "pushtag");
            return (Criteria) this;
        }

        public Criteria andPushtagGreaterThan(String value) {
            addCriterion("pushTag >", value, "pushtag");
            return (Criteria) this;
        }

        public Criteria andPushtagGreaterThanOrEqualTo(String value) {
            addCriterion("pushTag >=", value, "pushtag");
            return (Criteria) this;
        }

        public Criteria andPushtagLessThan(String value) {
            addCriterion("pushTag <", value, "pushtag");
            return (Criteria) this;
        }

        public Criteria andPushtagLessThanOrEqualTo(String value) {
            addCriterion("pushTag <=", value, "pushtag");
            return (Criteria) this;
        }

        public Criteria andPushtagLike(String value) {
            addCriterion("pushTag like", value, "pushtag");
            return (Criteria) this;
        }

        public Criteria andPushtagNotLike(String value) {
            addCriterion("pushTag not like", value, "pushtag");
            return (Criteria) this;
        }

        public Criteria andPushtagIn(List<String> values) {
            addCriterion("pushTag in", values, "pushtag");
            return (Criteria) this;
        }

        public Criteria andPushtagNotIn(List<String> values) {
            addCriterion("pushTag not in", values, "pushtag");
            return (Criteria) this;
        }

        public Criteria andPushtagBetween(String value1, String value2) {
            addCriterion("pushTag between", value1, value2, "pushtag");
            return (Criteria) this;
        }

        public Criteria andPushtagNotBetween(String value1, String value2) {
            addCriterion("pushTag not between", value1, value2, "pushtag");
            return (Criteria) this;
        }

        public Criteria andSysrightsIsNull() {
            addCriterion("sysrights is null");
            return (Criteria) this;
        }

        public Criteria andSysrightsIsNotNull() {
            addCriterion("sysrights is not null");
            return (Criteria) this;
        }

        public Criteria andSysrightsEqualTo(String value) {
            addCriterion("sysrights =", value, "sysrights");
            return (Criteria) this;
        }

        public Criteria andSysrightsNotEqualTo(String value) {
            addCriterion("sysrights <>", value, "sysrights");
            return (Criteria) this;
        }

        public Criteria andSysrightsGreaterThan(String value) {
            addCriterion("sysrights >", value, "sysrights");
            return (Criteria) this;
        }

        public Criteria andSysrightsGreaterThanOrEqualTo(String value) {
            addCriterion("sysrights >=", value, "sysrights");
            return (Criteria) this;
        }

        public Criteria andSysrightsLessThan(String value) {
            addCriterion("sysrights <", value, "sysrights");
            return (Criteria) this;
        }

        public Criteria andSysrightsLessThanOrEqualTo(String value) {
            addCriterion("sysrights <=", value, "sysrights");
            return (Criteria) this;
        }

        public Criteria andSysrightsLike(String value) {
            addCriterion("sysrights like", value, "sysrights");
            return (Criteria) this;
        }

        public Criteria andSysrightsNotLike(String value) {
            addCriterion("sysrights not like", value, "sysrights");
            return (Criteria) this;
        }

        public Criteria andSysrightsIn(List<String> values) {
            addCriterion("sysrights in", values, "sysrights");
            return (Criteria) this;
        }

        public Criteria andSysrightsNotIn(List<String> values) {
            addCriterion("sysrights not in", values, "sysrights");
            return (Criteria) this;
        }

        public Criteria andSysrightsBetween(String value1, String value2) {
            addCriterion("sysrights between", value1, value2, "sysrights");
            return (Criteria) this;
        }

        public Criteria andSysrightsNotBetween(String value1, String value2) {
            addCriterion("sysrights not between", value1, value2, "sysrights");
            return (Criteria) this;
        }

        public Criteria andLocalsourceIsNull() {
            addCriterion("localsource is null");
            return (Criteria) this;
        }

        public Criteria andLocalsourceIsNotNull() {
            addCriterion("localsource is not null");
            return (Criteria) this;
        }

        public Criteria andLocalsourceEqualTo(String value) {
            addCriterion("localsource =", value, "localsource");
            return (Criteria) this;
        }

        public Criteria andLocalsourceNotEqualTo(String value) {
            addCriterion("localsource <>", value, "localsource");
            return (Criteria) this;
        }

        public Criteria andLocalsourceGreaterThan(String value) {
            addCriterion("localsource >", value, "localsource");
            return (Criteria) this;
        }

        public Criteria andLocalsourceGreaterThanOrEqualTo(String value) {
            addCriterion("localsource >=", value, "localsource");
            return (Criteria) this;
        }

        public Criteria andLocalsourceLessThan(String value) {
            addCriterion("localsource <", value, "localsource");
            return (Criteria) this;
        }

        public Criteria andLocalsourceLessThanOrEqualTo(String value) {
            addCriterion("localsource <=", value, "localsource");
            return (Criteria) this;
        }

        public Criteria andLocalsourceLike(String value) {
            addCriterion("localsource like", value, "localsource");
            return (Criteria) this;
        }

        public Criteria andLocalsourceNotLike(String value) {
            addCriterion("localsource not like", value, "localsource");
            return (Criteria) this;
        }

        public Criteria andLocalsourceIn(List<String> values) {
            addCriterion("localsource in", values, "localsource");
            return (Criteria) this;
        }

        public Criteria andLocalsourceNotIn(List<String> values) {
            addCriterion("localsource not in", values, "localsource");
            return (Criteria) this;
        }

        public Criteria andLocalsourceBetween(String value1, String value2) {
            addCriterion("localsource between", value1, value2, "localsource");
            return (Criteria) this;
        }

        public Criteria andLocalsourceNotBetween(String value1, String value2) {
            addCriterion("localsource not between", value1, value2, "localsource");
            return (Criteria) this;
        }

        public Criteria andPhonetypeIsNull() {
            addCriterion("phoneType is null");
            return (Criteria) this;
        }

        public Criteria andPhonetypeIsNotNull() {
            addCriterion("phoneType is not null");
            return (Criteria) this;
        }

        public Criteria andPhonetypeEqualTo(String value) {
            addCriterion("phoneType =", value, "phonetype");
            return (Criteria) this;
        }

        public Criteria andPhonetypeNotEqualTo(String value) {
            addCriterion("phoneType <>", value, "phonetype");
            return (Criteria) this;
        }

        public Criteria andPhonetypeGreaterThan(String value) {
            addCriterion("phoneType >", value, "phonetype");
            return (Criteria) this;
        }

        public Criteria andPhonetypeGreaterThanOrEqualTo(String value) {
            addCriterion("phoneType >=", value, "phonetype");
            return (Criteria) this;
        }

        public Criteria andPhonetypeLessThan(String value) {
            addCriterion("phoneType <", value, "phonetype");
            return (Criteria) this;
        }

        public Criteria andPhonetypeLessThanOrEqualTo(String value) {
            addCriterion("phoneType <=", value, "phonetype");
            return (Criteria) this;
        }

        public Criteria andPhonetypeLike(String value) {
            addCriterion("phoneType like", value, "phonetype");
            return (Criteria) this;
        }

        public Criteria andPhonetypeNotLike(String value) {
            addCriterion("phoneType not like", value, "phonetype");
            return (Criteria) this;
        }

        public Criteria andPhonetypeIn(List<String> values) {
            addCriterion("phoneType in", values, "phonetype");
            return (Criteria) this;
        }

        public Criteria andPhonetypeNotIn(List<String> values) {
            addCriterion("phoneType not in", values, "phonetype");
            return (Criteria) this;
        }

        public Criteria andPhonetypeBetween(String value1, String value2) {
            addCriterion("phoneType between", value1, value2, "phonetype");
            return (Criteria) this;
        }

        public Criteria andPhonetypeNotBetween(String value1, String value2) {
            addCriterion("phoneType not between", value1, value2, "phonetype");
            return (Criteria) this;
        }

        public Criteria andPhoneuseridIsNull() {
            addCriterion("phoneUserId is null");
            return (Criteria) this;
        }

        public Criteria andPhoneuseridIsNotNull() {
            addCriterion("phoneUserId is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneuseridEqualTo(String value) {
            addCriterion("phoneUserId =", value, "phoneuserid");
            return (Criteria) this;
        }

        public Criteria andPhoneuseridNotEqualTo(String value) {
            addCriterion("phoneUserId <>", value, "phoneuserid");
            return (Criteria) this;
        }

        public Criteria andPhoneuseridGreaterThan(String value) {
            addCriterion("phoneUserId >", value, "phoneuserid");
            return (Criteria) this;
        }

        public Criteria andPhoneuseridGreaterThanOrEqualTo(String value) {
            addCriterion("phoneUserId >=", value, "phoneuserid");
            return (Criteria) this;
        }

        public Criteria andPhoneuseridLessThan(String value) {
            addCriterion("phoneUserId <", value, "phoneuserid");
            return (Criteria) this;
        }

        public Criteria andPhoneuseridLessThanOrEqualTo(String value) {
            addCriterion("phoneUserId <=", value, "phoneuserid");
            return (Criteria) this;
        }

        public Criteria andPhoneuseridLike(String value) {
            addCriterion("phoneUserId like", value, "phoneuserid");
            return (Criteria) this;
        }

        public Criteria andPhoneuseridNotLike(String value) {
            addCriterion("phoneUserId not like", value, "phoneuserid");
            return (Criteria) this;
        }

        public Criteria andPhoneuseridIn(List<String> values) {
            addCriterion("phoneUserId in", values, "phoneuserid");
            return (Criteria) this;
        }

        public Criteria andPhoneuseridNotIn(List<String> values) {
            addCriterion("phoneUserId not in", values, "phoneuserid");
            return (Criteria) this;
        }

        public Criteria andPhoneuseridBetween(String value1, String value2) {
            addCriterion("phoneUserId between", value1, value2, "phoneuserid");
            return (Criteria) this;
        }

        public Criteria andPhoneuseridNotBetween(String value1, String value2) {
            addCriterion("phoneUserId not between", value1, value2, "phoneuserid");
            return (Criteria) this;
        }

        public Criteria andPhonechannelidIsNull() {
            addCriterion("phoneChannelId is null");
            return (Criteria) this;
        }

        public Criteria andPhonechannelidIsNotNull() {
            addCriterion("phoneChannelId is not null");
            return (Criteria) this;
        }

        public Criteria andPhonechannelidEqualTo(String value) {
            addCriterion("phoneChannelId =", value, "phonechannelid");
            return (Criteria) this;
        }

        public Criteria andPhonechannelidNotEqualTo(String value) {
            addCriterion("phoneChannelId <>", value, "phonechannelid");
            return (Criteria) this;
        }

        public Criteria andPhonechannelidGreaterThan(String value) {
            addCriterion("phoneChannelId >", value, "phonechannelid");
            return (Criteria) this;
        }

        public Criteria andPhonechannelidGreaterThanOrEqualTo(String value) {
            addCriterion("phoneChannelId >=", value, "phonechannelid");
            return (Criteria) this;
        }

        public Criteria andPhonechannelidLessThan(String value) {
            addCriterion("phoneChannelId <", value, "phonechannelid");
            return (Criteria) this;
        }

        public Criteria andPhonechannelidLessThanOrEqualTo(String value) {
            addCriterion("phoneChannelId <=", value, "phonechannelid");
            return (Criteria) this;
        }

        public Criteria andPhonechannelidLike(String value) {
            addCriterion("phoneChannelId like", value, "phonechannelid");
            return (Criteria) this;
        }

        public Criteria andPhonechannelidNotLike(String value) {
            addCriterion("phoneChannelId not like", value, "phonechannelid");
            return (Criteria) this;
        }

        public Criteria andPhonechannelidIn(List<String> values) {
            addCriterion("phoneChannelId in", values, "phonechannelid");
            return (Criteria) this;
        }

        public Criteria andPhonechannelidNotIn(List<String> values) {
            addCriterion("phoneChannelId not in", values, "phonechannelid");
            return (Criteria) this;
        }

        public Criteria andPhonechannelidBetween(String value1, String value2) {
            addCriterion("phoneChannelId between", value1, value2, "phonechannelid");
            return (Criteria) this;
        }

        public Criteria andPhonechannelidNotBetween(String value1, String value2) {
            addCriterion("phoneChannelId not between", value1, value2, "phonechannelid");
            return (Criteria) this;
        }

        public Criteria andImuseridIsNull() {
            addCriterion("imUserId is null");
            return (Criteria) this;
        }

        public Criteria andImuseridIsNotNull() {
            addCriterion("imUserId is not null");
            return (Criteria) this;
        }

        public Criteria andImuseridEqualTo(String value) {
            addCriterion("imUserId =", value, "imuserid");
            return (Criteria) this;
        }

        public Criteria andImuseridNotEqualTo(String value) {
            addCriterion("imUserId <>", value, "imuserid");
            return (Criteria) this;
        }

        public Criteria andImuseridGreaterThan(String value) {
            addCriterion("imUserId >", value, "imuserid");
            return (Criteria) this;
        }

        public Criteria andImuseridGreaterThanOrEqualTo(String value) {
            addCriterion("imUserId >=", value, "imuserid");
            return (Criteria) this;
        }

        public Criteria andImuseridLessThan(String value) {
            addCriterion("imUserId <", value, "imuserid");
            return (Criteria) this;
        }

        public Criteria andImuseridLessThanOrEqualTo(String value) {
            addCriterion("imUserId <=", value, "imuserid");
            return (Criteria) this;
        }

        public Criteria andImuseridLike(String value) {
            addCriterion("imUserId like", value, "imuserid");
            return (Criteria) this;
        }

        public Criteria andImuseridNotLike(String value) {
            addCriterion("imUserId not like", value, "imuserid");
            return (Criteria) this;
        }

        public Criteria andImuseridIn(List<String> values) {
            addCriterion("imUserId in", values, "imuserid");
            return (Criteria) this;
        }

        public Criteria andImuseridNotIn(List<String> values) {
            addCriterion("imUserId not in", values, "imuserid");
            return (Criteria) this;
        }

        public Criteria andImuseridBetween(String value1, String value2) {
            addCriterion("imUserId between", value1, value2, "imuserid");
            return (Criteria) this;
        }

        public Criteria andImuseridNotBetween(String value1, String value2) {
            addCriterion("imUserId not between", value1, value2, "imuserid");
            return (Criteria) this;
        }

        public Criteria andImuseridserviceIsNull() {
            addCriterion("imUserIdService is null");
            return (Criteria) this;
        }

        public Criteria andImuseridserviceIsNotNull() {
            addCriterion("imUserIdService is not null");
            return (Criteria) this;
        }

        public Criteria andImuseridserviceEqualTo(String value) {
            addCriterion("imUserIdService =", value, "imuseridservice");
            return (Criteria) this;
        }

        public Criteria andImuseridserviceNotEqualTo(String value) {
            addCriterion("imUserIdService <>", value, "imuseridservice");
            return (Criteria) this;
        }

        public Criteria andImuseridserviceGreaterThan(String value) {
            addCriterion("imUserIdService >", value, "imuseridservice");
            return (Criteria) this;
        }

        public Criteria andImuseridserviceGreaterThanOrEqualTo(String value) {
            addCriterion("imUserIdService >=", value, "imuseridservice");
            return (Criteria) this;
        }

        public Criteria andImuseridserviceLessThan(String value) {
            addCriterion("imUserIdService <", value, "imuseridservice");
            return (Criteria) this;
        }

        public Criteria andImuseridserviceLessThanOrEqualTo(String value) {
            addCriterion("imUserIdService <=", value, "imuseridservice");
            return (Criteria) this;
        }

        public Criteria andImuseridserviceLike(String value) {
            addCriterion("imUserIdService like", value, "imuseridservice");
            return (Criteria) this;
        }

        public Criteria andImuseridserviceNotLike(String value) {
            addCriterion("imUserIdService not like", value, "imuseridservice");
            return (Criteria) this;
        }

        public Criteria andImuseridserviceIn(List<String> values) {
            addCriterion("imUserIdService in", values, "imuseridservice");
            return (Criteria) this;
        }

        public Criteria andImuseridserviceNotIn(List<String> values) {
            addCriterion("imUserIdService not in", values, "imuseridservice");
            return (Criteria) this;
        }

        public Criteria andImuseridserviceBetween(String value1, String value2) {
            addCriterion("imUserIdService between", value1, value2, "imuseridservice");
            return (Criteria) this;
        }

        public Criteria andImuseridserviceNotBetween(String value1, String value2) {
            addCriterion("imUserIdService not between", value1, value2, "imuseridservice");
            return (Criteria) this;
        }

        public Criteria andPauseIsNull() {
            addCriterion("Pause is null");
            return (Criteria) this;
        }

        public Criteria andPauseIsNotNull() {
            addCriterion("Pause is not null");
            return (Criteria) this;
        }

        public Criteria andPauseEqualTo(Integer value) {
            addCriterion("Pause =", value, "pause");
            return (Criteria) this;
        }

        public Criteria andPauseNotEqualTo(Integer value) {
            addCriterion("Pause <>", value, "pause");
            return (Criteria) this;
        }

        public Criteria andPauseGreaterThan(Integer value) {
            addCriterion("Pause >", value, "pause");
            return (Criteria) this;
        }

        public Criteria andPauseGreaterThanOrEqualTo(Integer value) {
            addCriterion("Pause >=", value, "pause");
            return (Criteria) this;
        }

        public Criteria andPauseLessThan(Integer value) {
            addCriterion("Pause <", value, "pause");
            return (Criteria) this;
        }

        public Criteria andPauseLessThanOrEqualTo(Integer value) {
            addCriterion("Pause <=", value, "pause");
            return (Criteria) this;
        }

        public Criteria andPauseIn(List<Integer> values) {
            addCriterion("Pause in", values, "pause");
            return (Criteria) this;
        }

        public Criteria andPauseNotIn(List<Integer> values) {
            addCriterion("Pause not in", values, "pause");
            return (Criteria) this;
        }

        public Criteria andPauseBetween(Integer value1, Integer value2) {
            addCriterion("Pause between", value1, value2, "pause");
            return (Criteria) this;
        }

        public Criteria andPauseNotBetween(Integer value1, Integer value2) {
            addCriterion("Pause not between", value1, value2, "pause");
            return (Criteria) this;
        }

        public Criteria andCrmvalueIsNull() {
            addCriterion("CRMvalue is null");
            return (Criteria) this;
        }

        public Criteria andCrmvalueIsNotNull() {
            addCriterion("CRMvalue is not null");
            return (Criteria) this;
        }

        public Criteria andCrmvalueEqualTo(String value) {
            addCriterion("CRMvalue =", value, "crmvalue");
            return (Criteria) this;
        }

        public Criteria andCrmvalueNotEqualTo(String value) {
            addCriterion("CRMvalue <>", value, "crmvalue");
            return (Criteria) this;
        }

        public Criteria andCrmvalueGreaterThan(String value) {
            addCriterion("CRMvalue >", value, "crmvalue");
            return (Criteria) this;
        }

        public Criteria andCrmvalueGreaterThanOrEqualTo(String value) {
            addCriterion("CRMvalue >=", value, "crmvalue");
            return (Criteria) this;
        }

        public Criteria andCrmvalueLessThan(String value) {
            addCriterion("CRMvalue <", value, "crmvalue");
            return (Criteria) this;
        }

        public Criteria andCrmvalueLessThanOrEqualTo(String value) {
            addCriterion("CRMvalue <=", value, "crmvalue");
            return (Criteria) this;
        }

        public Criteria andCrmvalueLike(String value) {
            addCriterion("CRMvalue like", value, "crmvalue");
            return (Criteria) this;
        }

        public Criteria andCrmvalueNotLike(String value) {
            addCriterion("CRMvalue not like", value, "crmvalue");
            return (Criteria) this;
        }

        public Criteria andCrmvalueIn(List<String> values) {
            addCriterion("CRMvalue in", values, "crmvalue");
            return (Criteria) this;
        }

        public Criteria andCrmvalueNotIn(List<String> values) {
            addCriterion("CRMvalue not in", values, "crmvalue");
            return (Criteria) this;
        }

        public Criteria andCrmvalueBetween(String value1, String value2) {
            addCriterion("CRMvalue between", value1, value2, "crmvalue");
            return (Criteria) this;
        }

        public Criteria andCrmvalueNotBetween(String value1, String value2) {
            addCriterion("CRMvalue not between", value1, value2, "crmvalue");
            return (Criteria) this;
        }

        public Criteria andLogincountIsNull() {
            addCriterion("LoginCount is null");
            return (Criteria) this;
        }

        public Criteria andLogincountIsNotNull() {
            addCriterion("LoginCount is not null");
            return (Criteria) this;
        }

        public Criteria andLogincountEqualTo(Integer value) {
            addCriterion("LoginCount =", value, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountNotEqualTo(Integer value) {
            addCriterion("LoginCount <>", value, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountGreaterThan(Integer value) {
            addCriterion("LoginCount >", value, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountGreaterThanOrEqualTo(Integer value) {
            addCriterion("LoginCount >=", value, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountLessThan(Integer value) {
            addCriterion("LoginCount <", value, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountLessThanOrEqualTo(Integer value) {
            addCriterion("LoginCount <=", value, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountIn(List<Integer> values) {
            addCriterion("LoginCount in", values, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountNotIn(List<Integer> values) {
            addCriterion("LoginCount not in", values, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountBetween(Integer value1, Integer value2) {
            addCriterion("LoginCount between", value1, value2, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountNotBetween(Integer value1, Integer value2) {
            addCriterion("LoginCount not between", value1, value2, "logincount");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeIsNull() {
            addCriterion("LastLoginTime is null");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeIsNotNull() {
            addCriterion("LastLoginTime is not null");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeEqualTo(Date value) {
            addCriterion("LastLoginTime =", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeNotEqualTo(Date value) {
            addCriterion("LastLoginTime <>", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeGreaterThan(Date value) {
            addCriterion("LastLoginTime >", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LastLoginTime >=", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeLessThan(Date value) {
            addCriterion("LastLoginTime <", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeLessThanOrEqualTo(Date value) {
            addCriterion("LastLoginTime <=", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeIn(List<Date> values) {
            addCriterion("LastLoginTime in", values, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeNotIn(List<Date> values) {
            addCriterion("LastLoginTime not in", values, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeBetween(Date value1, Date value2) {
            addCriterion("LastLoginTime between", value1, value2, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeNotBetween(Date value1, Date value2) {
            addCriterion("LastLoginTime not between", value1, value2, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andIsreceiveIsNull() {
            addCriterion("IsReceive is null");
            return (Criteria) this;
        }

        public Criteria andIsreceiveIsNotNull() {
            addCriterion("IsReceive is not null");
            return (Criteria) this;
        }

        public Criteria andIsreceiveEqualTo(Integer value) {
            addCriterion("IsReceive =", value, "isreceive");
            return (Criteria) this;
        }

        public Criteria andIsreceiveNotEqualTo(Integer value) {
            addCriterion("IsReceive <>", value, "isreceive");
            return (Criteria) this;
        }

        public Criteria andIsreceiveGreaterThan(Integer value) {
            addCriterion("IsReceive >", value, "isreceive");
            return (Criteria) this;
        }

        public Criteria andIsreceiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("IsReceive >=", value, "isreceive");
            return (Criteria) this;
        }

        public Criteria andIsreceiveLessThan(Integer value) {
            addCriterion("IsReceive <", value, "isreceive");
            return (Criteria) this;
        }

        public Criteria andIsreceiveLessThanOrEqualTo(Integer value) {
            addCriterion("IsReceive <=", value, "isreceive");
            return (Criteria) this;
        }

        public Criteria andIsreceiveIn(List<Integer> values) {
            addCriterion("IsReceive in", values, "isreceive");
            return (Criteria) this;
        }

        public Criteria andIsreceiveNotIn(List<Integer> values) {
            addCriterion("IsReceive not in", values, "isreceive");
            return (Criteria) this;
        }

        public Criteria andIsreceiveBetween(Integer value1, Integer value2) {
            addCriterion("IsReceive between", value1, value2, "isreceive");
            return (Criteria) this;
        }

        public Criteria andIsreceiveNotBetween(Integer value1, Integer value2) {
            addCriterion("IsReceive not between", value1, value2, "isreceive");
            return (Criteria) this;
        }

        public Criteria andIntegrationIsNull() {
            addCriterion("Integration is null");
            return (Criteria) this;
        }

        public Criteria andIntegrationIsNotNull() {
            addCriterion("Integration is not null");
            return (Criteria) this;
        }

        public Criteria andIntegrationEqualTo(Integer value) {
            addCriterion("Integration =", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationNotEqualTo(Integer value) {
            addCriterion("Integration <>", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationGreaterThan(Integer value) {
            addCriterion("Integration >", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationGreaterThanOrEqualTo(Integer value) {
            addCriterion("Integration >=", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationLessThan(Integer value) {
            addCriterion("Integration <", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationLessThanOrEqualTo(Integer value) {
            addCriterion("Integration <=", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationIn(List<Integer> values) {
            addCriterion("Integration in", values, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationNotIn(List<Integer> values) {
            addCriterion("Integration not in", values, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationBetween(Integer value1, Integer value2) {
            addCriterion("Integration between", value1, value2, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationNotBetween(Integer value1, Integer value2) {
            addCriterion("Integration not between", value1, value2, "integration");
            return (Criteria) this;
        }

        public Criteria andLevelsIsNull() {
            addCriterion("Levels is null");
            return (Criteria) this;
        }

        public Criteria andLevelsIsNotNull() {
            addCriterion("Levels is not null");
            return (Criteria) this;
        }

        public Criteria andLevelsEqualTo(Integer value) {
            addCriterion("Levels =", value, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsNotEqualTo(Integer value) {
            addCriterion("Levels <>", value, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsGreaterThan(Integer value) {
            addCriterion("Levels >", value, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsGreaterThanOrEqualTo(Integer value) {
            addCriterion("Levels >=", value, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsLessThan(Integer value) {
            addCriterion("Levels <", value, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsLessThanOrEqualTo(Integer value) {
            addCriterion("Levels <=", value, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsIn(List<Integer> values) {
            addCriterion("Levels in", values, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsNotIn(List<Integer> values) {
            addCriterion("Levels not in", values, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsBetween(Integer value1, Integer value2) {
            addCriterion("Levels between", value1, value2, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsNotBetween(Integer value1, Integer value2) {
            addCriterion("Levels not between", value1, value2, "levels");
            return (Criteria) this;
        }

        public Criteria andHeadpictureIsNull() {
            addCriterion("HeadPicture is null");
            return (Criteria) this;
        }

        public Criteria andHeadpictureIsNotNull() {
            addCriterion("HeadPicture is not null");
            return (Criteria) this;
        }

        public Criteria andHeadpictureEqualTo(String value) {
            addCriterion("HeadPicture =", value, "headpicture");
            return (Criteria) this;
        }

        public Criteria andHeadpictureNotEqualTo(String value) {
            addCriterion("HeadPicture <>", value, "headpicture");
            return (Criteria) this;
        }

        public Criteria andHeadpictureGreaterThan(String value) {
            addCriterion("HeadPicture >", value, "headpicture");
            return (Criteria) this;
        }

        public Criteria andHeadpictureGreaterThanOrEqualTo(String value) {
            addCriterion("HeadPicture >=", value, "headpicture");
            return (Criteria) this;
        }

        public Criteria andHeadpictureLessThan(String value) {
            addCriterion("HeadPicture <", value, "headpicture");
            return (Criteria) this;
        }

        public Criteria andHeadpictureLessThanOrEqualTo(String value) {
            addCriterion("HeadPicture <=", value, "headpicture");
            return (Criteria) this;
        }

        public Criteria andHeadpictureLike(String value) {
            addCriterion("HeadPicture like", value, "headpicture");
            return (Criteria) this;
        }

        public Criteria andHeadpictureNotLike(String value) {
            addCriterion("HeadPicture not like", value, "headpicture");
            return (Criteria) this;
        }

        public Criteria andHeadpictureIn(List<String> values) {
            addCriterion("HeadPicture in", values, "headpicture");
            return (Criteria) this;
        }

        public Criteria andHeadpictureNotIn(List<String> values) {
            addCriterion("HeadPicture not in", values, "headpicture");
            return (Criteria) this;
        }

        public Criteria andHeadpictureBetween(String value1, String value2) {
            addCriterion("HeadPicture between", value1, value2, "headpicture");
            return (Criteria) this;
        }

        public Criteria andHeadpictureNotBetween(String value1, String value2) {
            addCriterion("HeadPicture not between", value1, value2, "headpicture");
            return (Criteria) this;
        }

        public Criteria andTruenameIsNull() {
            addCriterion("TrueName is null");
            return (Criteria) this;
        }

        public Criteria andTruenameIsNotNull() {
            addCriterion("TrueName is not null");
            return (Criteria) this;
        }

        public Criteria andTruenameEqualTo(String value) {
            addCriterion("TrueName =", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameNotEqualTo(String value) {
            addCriterion("TrueName <>", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameGreaterThan(String value) {
            addCriterion("TrueName >", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameGreaterThanOrEqualTo(String value) {
            addCriterion("TrueName >=", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameLessThan(String value) {
            addCriterion("TrueName <", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameLessThanOrEqualTo(String value) {
            addCriterion("TrueName <=", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameLike(String value) {
            addCriterion("TrueName like", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameNotLike(String value) {
            addCriterion("TrueName not like", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameIn(List<String> values) {
            addCriterion("TrueName in", values, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameNotIn(List<String> values) {
            addCriterion("TrueName not in", values, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameBetween(String value1, String value2) {
            addCriterion("TrueName between", value1, value2, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameNotBetween(String value1, String value2) {
            addCriterion("TrueName not between", value1, value2, "truename");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("Year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("Year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Integer value) {
            addCriterion("Year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Integer value) {
            addCriterion("Year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Integer value) {
            addCriterion("Year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("Year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Integer value) {
            addCriterion("Year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Integer value) {
            addCriterion("Year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Integer> values) {
            addCriterion("Year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Integer> values) {
            addCriterion("Year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Integer value1, Integer value2) {
            addCriterion("Year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Integer value1, Integer value2) {
            addCriterion("Year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andMonthIsNull() {
            addCriterion("Month is null");
            return (Criteria) this;
        }

        public Criteria andMonthIsNotNull() {
            addCriterion("Month is not null");
            return (Criteria) this;
        }

        public Criteria andMonthEqualTo(Integer value) {
            addCriterion("Month =", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotEqualTo(Integer value) {
            addCriterion("Month <>", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThan(Integer value) {
            addCriterion("Month >", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("Month >=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThan(Integer value) {
            addCriterion("Month <", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThanOrEqualTo(Integer value) {
            addCriterion("Month <=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthIn(List<Integer> values) {
            addCriterion("Month in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotIn(List<Integer> values) {
            addCriterion("Month not in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthBetween(Integer value1, Integer value2) {
            addCriterion("Month between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("Month not between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andDayIsNull() {
            addCriterion("Day is null");
            return (Criteria) this;
        }

        public Criteria andDayIsNotNull() {
            addCriterion("Day is not null");
            return (Criteria) this;
        }

        public Criteria andDayEqualTo(Integer value) {
            addCriterion("Day =", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotEqualTo(Integer value) {
            addCriterion("Day <>", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThan(Integer value) {
            addCriterion("Day >", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("Day >=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThan(Integer value) {
            addCriterion("Day <", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThanOrEqualTo(Integer value) {
            addCriterion("Day <=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayIn(List<Integer> values) {
            addCriterion("Day in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotIn(List<Integer> values) {
            addCriterion("Day not in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayBetween(Integer value1, Integer value2) {
            addCriterion("Day between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotBetween(Integer value1, Integer value2) {
            addCriterion("Day not between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("City is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("City is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("City =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("City <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("City >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("City >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("City <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("City <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("City like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("City not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("City in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("City not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("City between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("City not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andTownIsNull() {
            addCriterion("Town is null");
            return (Criteria) this;
        }

        public Criteria andTownIsNotNull() {
            addCriterion("Town is not null");
            return (Criteria) this;
        }

        public Criteria andTownEqualTo(String value) {
            addCriterion("Town =", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotEqualTo(String value) {
            addCriterion("Town <>", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownGreaterThan(String value) {
            addCriterion("Town >", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownGreaterThanOrEqualTo(String value) {
            addCriterion("Town >=", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownLessThan(String value) {
            addCriterion("Town <", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownLessThanOrEqualTo(String value) {
            addCriterion("Town <=", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownLike(String value) {
            addCriterion("Town like", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotLike(String value) {
            addCriterion("Town not like", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownIn(List<String> values) {
            addCriterion("Town in", values, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotIn(List<String> values) {
            addCriterion("Town not in", values, "town");
            return (Criteria) this;
        }

        public Criteria andTownBetween(String value1, String value2) {
            addCriterion("Town between", value1, value2, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotBetween(String value1, String value2) {
            addCriterion("Town not between", value1, value2, "town");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("Email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("Email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("Email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("Email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("Email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("Email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("Email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("Email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("Email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("Email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("Email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("Email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("Email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("Email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("Phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("Phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("Phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("Phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("Phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("Phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("Phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("Phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("Phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("Phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("Phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("Phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("Phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("Phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andQqIsNull() {
            addCriterion("QQ is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("QQ is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("QQ =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("QQ <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("QQ >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("QQ >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("QQ <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("QQ <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("QQ like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("QQ not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("QQ in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("QQ not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("QQ between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("QQ not between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andEducationIsNull() {
            addCriterion("Education is null");
            return (Criteria) this;
        }

        public Criteria andEducationIsNotNull() {
            addCriterion("Education is not null");
            return (Criteria) this;
        }

        public Criteria andEducationEqualTo(String value) {
            addCriterion("Education =", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotEqualTo(String value) {
            addCriterion("Education <>", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThan(String value) {
            addCriterion("Education >", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThanOrEqualTo(String value) {
            addCriterion("Education >=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThan(String value) {
            addCriterion("Education <", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThanOrEqualTo(String value) {
            addCriterion("Education <=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLike(String value) {
            addCriterion("Education like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotLike(String value) {
            addCriterion("Education not like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationIn(List<String> values) {
            addCriterion("Education in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotIn(List<String> values) {
            addCriterion("Education not in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationBetween(String value1, String value2) {
            addCriterion("Education between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotBetween(String value1, String value2) {
            addCriterion("Education not between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andProfessionIsNull() {
            addCriterion("Profession is null");
            return (Criteria) this;
        }

        public Criteria andProfessionIsNotNull() {
            addCriterion("Profession is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionEqualTo(String value) {
            addCriterion("Profession =", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotEqualTo(String value) {
            addCriterion("Profession <>", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionGreaterThan(String value) {
            addCriterion("Profession >", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionGreaterThanOrEqualTo(String value) {
            addCriterion("Profession >=", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionLessThan(String value) {
            addCriterion("Profession <", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionLessThanOrEqualTo(String value) {
            addCriterion("Profession <=", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionLike(String value) {
            addCriterion("Profession like", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotLike(String value) {
            addCriterion("Profession not like", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionIn(List<String> values) {
            addCriterion("Profession in", values, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotIn(List<String> values) {
            addCriterion("Profession not in", values, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionBetween(String value1, String value2) {
            addCriterion("Profession between", value1, value2, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotBetween(String value1, String value2) {
            addCriterion("Profession not between", value1, value2, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessioninfoIsNull() {
            addCriterion("ProfessionInfo is null");
            return (Criteria) this;
        }

        public Criteria andProfessioninfoIsNotNull() {
            addCriterion("ProfessionInfo is not null");
            return (Criteria) this;
        }

        public Criteria andProfessioninfoEqualTo(String value) {
            addCriterion("ProfessionInfo =", value, "professioninfo");
            return (Criteria) this;
        }

        public Criteria andProfessioninfoNotEqualTo(String value) {
            addCriterion("ProfessionInfo <>", value, "professioninfo");
            return (Criteria) this;
        }

        public Criteria andProfessioninfoGreaterThan(String value) {
            addCriterion("ProfessionInfo >", value, "professioninfo");
            return (Criteria) this;
        }

        public Criteria andProfessioninfoGreaterThanOrEqualTo(String value) {
            addCriterion("ProfessionInfo >=", value, "professioninfo");
            return (Criteria) this;
        }

        public Criteria andProfessioninfoLessThan(String value) {
            addCriterion("ProfessionInfo <", value, "professioninfo");
            return (Criteria) this;
        }

        public Criteria andProfessioninfoLessThanOrEqualTo(String value) {
            addCriterion("ProfessionInfo <=", value, "professioninfo");
            return (Criteria) this;
        }

        public Criteria andProfessioninfoLike(String value) {
            addCriterion("ProfessionInfo like", value, "professioninfo");
            return (Criteria) this;
        }

        public Criteria andProfessioninfoNotLike(String value) {
            addCriterion("ProfessionInfo not like", value, "professioninfo");
            return (Criteria) this;
        }

        public Criteria andProfessioninfoIn(List<String> values) {
            addCriterion("ProfessionInfo in", values, "professioninfo");
            return (Criteria) this;
        }

        public Criteria andProfessioninfoNotIn(List<String> values) {
            addCriterion("ProfessionInfo not in", values, "professioninfo");
            return (Criteria) this;
        }

        public Criteria andProfessioninfoBetween(String value1, String value2) {
            addCriterion("ProfessionInfo between", value1, value2, "professioninfo");
            return (Criteria) this;
        }

        public Criteria andProfessioninfoNotBetween(String value1, String value2) {
            addCriterion("ProfessionInfo not between", value1, value2, "professioninfo");
            return (Criteria) this;
        }

        public Criteria andCapitalpositionIsNull() {
            addCriterion("CapitalPosition is null");
            return (Criteria) this;
        }

        public Criteria andCapitalpositionIsNotNull() {
            addCriterion("CapitalPosition is not null");
            return (Criteria) this;
        }

        public Criteria andCapitalpositionEqualTo(String value) {
            addCriterion("CapitalPosition =", value, "capitalposition");
            return (Criteria) this;
        }

        public Criteria andCapitalpositionNotEqualTo(String value) {
            addCriterion("CapitalPosition <>", value, "capitalposition");
            return (Criteria) this;
        }

        public Criteria andCapitalpositionGreaterThan(String value) {
            addCriterion("CapitalPosition >", value, "capitalposition");
            return (Criteria) this;
        }

        public Criteria andCapitalpositionGreaterThanOrEqualTo(String value) {
            addCriterion("CapitalPosition >=", value, "capitalposition");
            return (Criteria) this;
        }

        public Criteria andCapitalpositionLessThan(String value) {
            addCriterion("CapitalPosition <", value, "capitalposition");
            return (Criteria) this;
        }

        public Criteria andCapitalpositionLessThanOrEqualTo(String value) {
            addCriterion("CapitalPosition <=", value, "capitalposition");
            return (Criteria) this;
        }

        public Criteria andCapitalpositionLike(String value) {
            addCriterion("CapitalPosition like", value, "capitalposition");
            return (Criteria) this;
        }

        public Criteria andCapitalpositionNotLike(String value) {
            addCriterion("CapitalPosition not like", value, "capitalposition");
            return (Criteria) this;
        }

        public Criteria andCapitalpositionIn(List<String> values) {
            addCriterion("CapitalPosition in", values, "capitalposition");
            return (Criteria) this;
        }

        public Criteria andCapitalpositionNotIn(List<String> values) {
            addCriterion("CapitalPosition not in", values, "capitalposition");
            return (Criteria) this;
        }

        public Criteria andCapitalpositionBetween(String value1, String value2) {
            addCriterion("CapitalPosition between", value1, value2, "capitalposition");
            return (Criteria) this;
        }

        public Criteria andCapitalpositionNotBetween(String value1, String value2) {
            addCriterion("CapitalPosition not between", value1, value2, "capitalposition");
            return (Criteria) this;
        }

        public Criteria andOperatingstyleIsNull() {
            addCriterion("OperatingStyle is null");
            return (Criteria) this;
        }

        public Criteria andOperatingstyleIsNotNull() {
            addCriterion("OperatingStyle is not null");
            return (Criteria) this;
        }

        public Criteria andOperatingstyleEqualTo(String value) {
            addCriterion("OperatingStyle =", value, "operatingstyle");
            return (Criteria) this;
        }

        public Criteria andOperatingstyleNotEqualTo(String value) {
            addCriterion("OperatingStyle <>", value, "operatingstyle");
            return (Criteria) this;
        }

        public Criteria andOperatingstyleGreaterThan(String value) {
            addCriterion("OperatingStyle >", value, "operatingstyle");
            return (Criteria) this;
        }

        public Criteria andOperatingstyleGreaterThanOrEqualTo(String value) {
            addCriterion("OperatingStyle >=", value, "operatingstyle");
            return (Criteria) this;
        }

        public Criteria andOperatingstyleLessThan(String value) {
            addCriterion("OperatingStyle <", value, "operatingstyle");
            return (Criteria) this;
        }

        public Criteria andOperatingstyleLessThanOrEqualTo(String value) {
            addCriterion("OperatingStyle <=", value, "operatingstyle");
            return (Criteria) this;
        }

        public Criteria andOperatingstyleLike(String value) {
            addCriterion("OperatingStyle like", value, "operatingstyle");
            return (Criteria) this;
        }

        public Criteria andOperatingstyleNotLike(String value) {
            addCriterion("OperatingStyle not like", value, "operatingstyle");
            return (Criteria) this;
        }

        public Criteria andOperatingstyleIn(List<String> values) {
            addCriterion("OperatingStyle in", values, "operatingstyle");
            return (Criteria) this;
        }

        public Criteria andOperatingstyleNotIn(List<String> values) {
            addCriterion("OperatingStyle not in", values, "operatingstyle");
            return (Criteria) this;
        }

        public Criteria andOperatingstyleBetween(String value1, String value2) {
            addCriterion("OperatingStyle between", value1, value2, "operatingstyle");
            return (Criteria) this;
        }

        public Criteria andOperatingstyleNotBetween(String value1, String value2) {
            addCriterion("OperatingStyle not between", value1, value2, "operatingstyle");
            return (Criteria) this;
        }

        public Criteria andPickingstyleIsNull() {
            addCriterion("PickingStyle is null");
            return (Criteria) this;
        }

        public Criteria andPickingstyleIsNotNull() {
            addCriterion("PickingStyle is not null");
            return (Criteria) this;
        }

        public Criteria andPickingstyleEqualTo(String value) {
            addCriterion("PickingStyle =", value, "pickingstyle");
            return (Criteria) this;
        }

        public Criteria andPickingstyleNotEqualTo(String value) {
            addCriterion("PickingStyle <>", value, "pickingstyle");
            return (Criteria) this;
        }

        public Criteria andPickingstyleGreaterThan(String value) {
            addCriterion("PickingStyle >", value, "pickingstyle");
            return (Criteria) this;
        }

        public Criteria andPickingstyleGreaterThanOrEqualTo(String value) {
            addCriterion("PickingStyle >=", value, "pickingstyle");
            return (Criteria) this;
        }

        public Criteria andPickingstyleLessThan(String value) {
            addCriterion("PickingStyle <", value, "pickingstyle");
            return (Criteria) this;
        }

        public Criteria andPickingstyleLessThanOrEqualTo(String value) {
            addCriterion("PickingStyle <=", value, "pickingstyle");
            return (Criteria) this;
        }

        public Criteria andPickingstyleLike(String value) {
            addCriterion("PickingStyle like", value, "pickingstyle");
            return (Criteria) this;
        }

        public Criteria andPickingstyleNotLike(String value) {
            addCriterion("PickingStyle not like", value, "pickingstyle");
            return (Criteria) this;
        }

        public Criteria andPickingstyleIn(List<String> values) {
            addCriterion("PickingStyle in", values, "pickingstyle");
            return (Criteria) this;
        }

        public Criteria andPickingstyleNotIn(List<String> values) {
            addCriterion("PickingStyle not in", values, "pickingstyle");
            return (Criteria) this;
        }

        public Criteria andPickingstyleBetween(String value1, String value2) {
            addCriterion("PickingStyle between", value1, value2, "pickingstyle");
            return (Criteria) this;
        }

        public Criteria andPickingstyleNotBetween(String value1, String value2) {
            addCriterion("PickingStyle not between", value1, value2, "pickingstyle");
            return (Criteria) this;
        }

        public Criteria andInvestingexperienceIsNull() {
            addCriterion("InvestingExperience is null");
            return (Criteria) this;
        }

        public Criteria andInvestingexperienceIsNotNull() {
            addCriterion("InvestingExperience is not null");
            return (Criteria) this;
        }

        public Criteria andInvestingexperienceEqualTo(String value) {
            addCriterion("InvestingExperience =", value, "investingexperience");
            return (Criteria) this;
        }

        public Criteria andInvestingexperienceNotEqualTo(String value) {
            addCriterion("InvestingExperience <>", value, "investingexperience");
            return (Criteria) this;
        }

        public Criteria andInvestingexperienceGreaterThan(String value) {
            addCriterion("InvestingExperience >", value, "investingexperience");
            return (Criteria) this;
        }

        public Criteria andInvestingexperienceGreaterThanOrEqualTo(String value) {
            addCriterion("InvestingExperience >=", value, "investingexperience");
            return (Criteria) this;
        }

        public Criteria andInvestingexperienceLessThan(String value) {
            addCriterion("InvestingExperience <", value, "investingexperience");
            return (Criteria) this;
        }

        public Criteria andInvestingexperienceLessThanOrEqualTo(String value) {
            addCriterion("InvestingExperience <=", value, "investingexperience");
            return (Criteria) this;
        }

        public Criteria andInvestingexperienceLike(String value) {
            addCriterion("InvestingExperience like", value, "investingexperience");
            return (Criteria) this;
        }

        public Criteria andInvestingexperienceNotLike(String value) {
            addCriterion("InvestingExperience not like", value, "investingexperience");
            return (Criteria) this;
        }

        public Criteria andInvestingexperienceIn(List<String> values) {
            addCriterion("InvestingExperience in", values, "investingexperience");
            return (Criteria) this;
        }

        public Criteria andInvestingexperienceNotIn(List<String> values) {
            addCriterion("InvestingExperience not in", values, "investingexperience");
            return (Criteria) this;
        }

        public Criteria andInvestingexperienceBetween(String value1, String value2) {
            addCriterion("InvestingExperience between", value1, value2, "investingexperience");
            return (Criteria) this;
        }

        public Criteria andInvestingexperienceNotBetween(String value1, String value2) {
            addCriterion("InvestingExperience not between", value1, value2, "investingexperience");
            return (Criteria) this;
        }

        public Criteria andInvestingproductsIsNull() {
            addCriterion("InvestingProducts is null");
            return (Criteria) this;
        }

        public Criteria andInvestingproductsIsNotNull() {
            addCriterion("InvestingProducts is not null");
            return (Criteria) this;
        }

        public Criteria andInvestingproductsEqualTo(String value) {
            addCriterion("InvestingProducts =", value, "investingproducts");
            return (Criteria) this;
        }

        public Criteria andInvestingproductsNotEqualTo(String value) {
            addCriterion("InvestingProducts <>", value, "investingproducts");
            return (Criteria) this;
        }

        public Criteria andInvestingproductsGreaterThan(String value) {
            addCriterion("InvestingProducts >", value, "investingproducts");
            return (Criteria) this;
        }

        public Criteria andInvestingproductsGreaterThanOrEqualTo(String value) {
            addCriterion("InvestingProducts >=", value, "investingproducts");
            return (Criteria) this;
        }

        public Criteria andInvestingproductsLessThan(String value) {
            addCriterion("InvestingProducts <", value, "investingproducts");
            return (Criteria) this;
        }

        public Criteria andInvestingproductsLessThanOrEqualTo(String value) {
            addCriterion("InvestingProducts <=", value, "investingproducts");
            return (Criteria) this;
        }

        public Criteria andInvestingproductsLike(String value) {
            addCriterion("InvestingProducts like", value, "investingproducts");
            return (Criteria) this;
        }

        public Criteria andInvestingproductsNotLike(String value) {
            addCriterion("InvestingProducts not like", value, "investingproducts");
            return (Criteria) this;
        }

        public Criteria andInvestingproductsIn(List<String> values) {
            addCriterion("InvestingProducts in", values, "investingproducts");
            return (Criteria) this;
        }

        public Criteria andInvestingproductsNotIn(List<String> values) {
            addCriterion("InvestingProducts not in", values, "investingproducts");
            return (Criteria) this;
        }

        public Criteria andInvestingproductsBetween(String value1, String value2) {
            addCriterion("InvestingProducts between", value1, value2, "investingproducts");
            return (Criteria) this;
        }

        public Criteria andInvestingproductsNotBetween(String value1, String value2) {
            addCriterion("InvestingProducts not between", value1, value2, "investingproducts");
            return (Criteria) this;
        }

        public Criteria andProfileIsNull() {
            addCriterion("Profile is null");
            return (Criteria) this;
        }

        public Criteria andProfileIsNotNull() {
            addCriterion("Profile is not null");
            return (Criteria) this;
        }

        public Criteria andProfileEqualTo(String value) {
            addCriterion("Profile =", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileNotEqualTo(String value) {
            addCriterion("Profile <>", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileGreaterThan(String value) {
            addCriterion("Profile >", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileGreaterThanOrEqualTo(String value) {
            addCriterion("Profile >=", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileLessThan(String value) {
            addCriterion("Profile <", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileLessThanOrEqualTo(String value) {
            addCriterion("Profile <=", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileLike(String value) {
            addCriterion("Profile like", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileNotLike(String value) {
            addCriterion("Profile not like", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileIn(List<String> values) {
            addCriterion("Profile in", values, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileNotIn(List<String> values) {
            addCriterion("Profile not in", values, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileBetween(String value1, String value2) {
            addCriterion("Profile between", value1, value2, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileNotBetween(String value1, String value2) {
            addCriterion("Profile not between", value1, value2, "profile");
            return (Criteria) this;
        }

        public Criteria andPicupdtimeIsNull() {
            addCriterion("PicUpdTime is null");
            return (Criteria) this;
        }

        public Criteria andPicupdtimeIsNotNull() {
            addCriterion("PicUpdTime is not null");
            return (Criteria) this;
        }

        public Criteria andPicupdtimeEqualTo(Date value) {
            addCriterion("PicUpdTime =", value, "picupdtime");
            return (Criteria) this;
        }

        public Criteria andPicupdtimeNotEqualTo(Date value) {
            addCriterion("PicUpdTime <>", value, "picupdtime");
            return (Criteria) this;
        }

        public Criteria andPicupdtimeGreaterThan(Date value) {
            addCriterion("PicUpdTime >", value, "picupdtime");
            return (Criteria) this;
        }

        public Criteria andPicupdtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PicUpdTime >=", value, "picupdtime");
            return (Criteria) this;
        }

        public Criteria andPicupdtimeLessThan(Date value) {
            addCriterion("PicUpdTime <", value, "picupdtime");
            return (Criteria) this;
        }

        public Criteria andPicupdtimeLessThanOrEqualTo(Date value) {
            addCriterion("PicUpdTime <=", value, "picupdtime");
            return (Criteria) this;
        }

        public Criteria andPicupdtimeIn(List<Date> values) {
            addCriterion("PicUpdTime in", values, "picupdtime");
            return (Criteria) this;
        }

        public Criteria andPicupdtimeNotIn(List<Date> values) {
            addCriterion("PicUpdTime not in", values, "picupdtime");
            return (Criteria) this;
        }

        public Criteria andPicupdtimeBetween(Date value1, Date value2) {
            addCriterion("PicUpdTime between", value1, value2, "picupdtime");
            return (Criteria) this;
        }

        public Criteria andPicupdtimeNotBetween(Date value1, Date value2) {
            addCriterion("PicUpdTime not between", value1, value2, "picupdtime");
            return (Criteria) this;
        }

        public Criteria andIsmobileattestIsNull() {
            addCriterion("IsMobileAttest is null");
            return (Criteria) this;
        }

        public Criteria andIsmobileattestIsNotNull() {
            addCriterion("IsMobileAttest is not null");
            return (Criteria) this;
        }

        public Criteria andIsmobileattestEqualTo(Integer value) {
            addCriterion("IsMobileAttest =", value, "ismobileattest");
            return (Criteria) this;
        }

        public Criteria andIsmobileattestNotEqualTo(Integer value) {
            addCriterion("IsMobileAttest <>", value, "ismobileattest");
            return (Criteria) this;
        }

        public Criteria andIsmobileattestGreaterThan(Integer value) {
            addCriterion("IsMobileAttest >", value, "ismobileattest");
            return (Criteria) this;
        }

        public Criteria andIsmobileattestGreaterThanOrEqualTo(Integer value) {
            addCriterion("IsMobileAttest >=", value, "ismobileattest");
            return (Criteria) this;
        }

        public Criteria andIsmobileattestLessThan(Integer value) {
            addCriterion("IsMobileAttest <", value, "ismobileattest");
            return (Criteria) this;
        }

        public Criteria andIsmobileattestLessThanOrEqualTo(Integer value) {
            addCriterion("IsMobileAttest <=", value, "ismobileattest");
            return (Criteria) this;
        }

        public Criteria andIsmobileattestIn(List<Integer> values) {
            addCriterion("IsMobileAttest in", values, "ismobileattest");
            return (Criteria) this;
        }

        public Criteria andIsmobileattestNotIn(List<Integer> values) {
            addCriterion("IsMobileAttest not in", values, "ismobileattest");
            return (Criteria) this;
        }

        public Criteria andIsmobileattestBetween(Integer value1, Integer value2) {
            addCriterion("IsMobileAttest between", value1, value2, "ismobileattest");
            return (Criteria) this;
        }

        public Criteria andIsmobileattestNotBetween(Integer value1, Integer value2) {
            addCriterion("IsMobileAttest not between", value1, value2, "ismobileattest");
            return (Criteria) this;
        }

        public Criteria andIsemailattestIsNull() {
            addCriterion("IsEmailAttest is null");
            return (Criteria) this;
        }

        public Criteria andIsemailattestIsNotNull() {
            addCriterion("IsEmailAttest is not null");
            return (Criteria) this;
        }

        public Criteria andIsemailattestEqualTo(Integer value) {
            addCriterion("IsEmailAttest =", value, "isemailattest");
            return (Criteria) this;
        }

        public Criteria andIsemailattestNotEqualTo(Integer value) {
            addCriterion("IsEmailAttest <>", value, "isemailattest");
            return (Criteria) this;
        }

        public Criteria andIsemailattestGreaterThan(Integer value) {
            addCriterion("IsEmailAttest >", value, "isemailattest");
            return (Criteria) this;
        }

        public Criteria andIsemailattestGreaterThanOrEqualTo(Integer value) {
            addCriterion("IsEmailAttest >=", value, "isemailattest");
            return (Criteria) this;
        }

        public Criteria andIsemailattestLessThan(Integer value) {
            addCriterion("IsEmailAttest <", value, "isemailattest");
            return (Criteria) this;
        }

        public Criteria andIsemailattestLessThanOrEqualTo(Integer value) {
            addCriterion("IsEmailAttest <=", value, "isemailattest");
            return (Criteria) this;
        }

        public Criteria andIsemailattestIn(List<Integer> values) {
            addCriterion("IsEmailAttest in", values, "isemailattest");
            return (Criteria) this;
        }

        public Criteria andIsemailattestNotIn(List<Integer> values) {
            addCriterion("IsEmailAttest not in", values, "isemailattest");
            return (Criteria) this;
        }

        public Criteria andIsemailattestBetween(Integer value1, Integer value2) {
            addCriterion("IsEmailAttest between", value1, value2, "isemailattest");
            return (Criteria) this;
        }

        public Criteria andIsemailattestNotBetween(Integer value1, Integer value2) {
            addCriterion("IsEmailAttest not between", value1, value2, "isemailattest");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CreateTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CreateTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CreateTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CreateTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CreateTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CreateTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CreateTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CreateTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CreateTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CreateTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andDelflagIsNull() {
            addCriterion("DelFlag is null");
            return (Criteria) this;
        }

        public Criteria andDelflagIsNotNull() {
            addCriterion("DelFlag is not null");
            return (Criteria) this;
        }

        public Criteria andDelflagEqualTo(Integer value) {
            addCriterion("DelFlag =", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagNotEqualTo(Integer value) {
            addCriterion("DelFlag <>", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagGreaterThan(Integer value) {
            addCriterion("DelFlag >", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagGreaterThanOrEqualTo(Integer value) {
            addCriterion("DelFlag >=", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagLessThan(Integer value) {
            addCriterion("DelFlag <", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagLessThanOrEqualTo(Integer value) {
            addCriterion("DelFlag <=", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagIn(List<Integer> values) {
            addCriterion("DelFlag in", values, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagNotIn(List<Integer> values) {
            addCriterion("DelFlag not in", values, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagBetween(Integer value1, Integer value2) {
            addCriterion("DelFlag between", value1, value2, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagNotBetween(Integer value1, Integer value2) {
            addCriterion("DelFlag not between", value1, value2, "delflag");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("Pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("Pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("Pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("Pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("Pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("Pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("Pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("Pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("Pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("Pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("Pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andIsupgradeIsNull() {
            addCriterion("IsUpgrade is null");
            return (Criteria) this;
        }

        public Criteria andIsupgradeIsNotNull() {
            addCriterion("IsUpgrade is not null");
            return (Criteria) this;
        }

        public Criteria andIsupgradeEqualTo(Integer value) {
            addCriterion("IsUpgrade =", value, "isupgrade");
            return (Criteria) this;
        }

        public Criteria andIsupgradeNotEqualTo(Integer value) {
            addCriterion("IsUpgrade <>", value, "isupgrade");
            return (Criteria) this;
        }

        public Criteria andIsupgradeGreaterThan(Integer value) {
            addCriterion("IsUpgrade >", value, "isupgrade");
            return (Criteria) this;
        }

        public Criteria andIsupgradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("IsUpgrade >=", value, "isupgrade");
            return (Criteria) this;
        }

        public Criteria andIsupgradeLessThan(Integer value) {
            addCriterion("IsUpgrade <", value, "isupgrade");
            return (Criteria) this;
        }

        public Criteria andIsupgradeLessThanOrEqualTo(Integer value) {
            addCriterion("IsUpgrade <=", value, "isupgrade");
            return (Criteria) this;
        }

        public Criteria andIsupgradeIn(List<Integer> values) {
            addCriterion("IsUpgrade in", values, "isupgrade");
            return (Criteria) this;
        }

        public Criteria andIsupgradeNotIn(List<Integer> values) {
            addCriterion("IsUpgrade not in", values, "isupgrade");
            return (Criteria) this;
        }

        public Criteria andIsupgradeBetween(Integer value1, Integer value2) {
            addCriterion("IsUpgrade between", value1, value2, "isupgrade");
            return (Criteria) this;
        }

        public Criteria andIsupgradeNotBetween(Integer value1, Integer value2) {
            addCriterion("IsUpgrade not between", value1, value2, "isupgrade");
            return (Criteria) this;
        }

        public Criteria andOnlineMobileIsNull() {
            addCriterion("online_mobile is null");
            return (Criteria) this;
        }

        public Criteria andOnlineMobileIsNotNull() {
            addCriterion("online_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineMobileEqualTo(String value) {
            addCriterion("online_mobile =", value, "onlineMobile");
            return (Criteria) this;
        }

        public Criteria andOnlineMobileNotEqualTo(String value) {
            addCriterion("online_mobile <>", value, "onlineMobile");
            return (Criteria) this;
        }

        public Criteria andOnlineMobileGreaterThan(String value) {
            addCriterion("online_mobile >", value, "onlineMobile");
            return (Criteria) this;
        }

        public Criteria andOnlineMobileGreaterThanOrEqualTo(String value) {
            addCriterion("online_mobile >=", value, "onlineMobile");
            return (Criteria) this;
        }

        public Criteria andOnlineMobileLessThan(String value) {
            addCriterion("online_mobile <", value, "onlineMobile");
            return (Criteria) this;
        }

        public Criteria andOnlineMobileLessThanOrEqualTo(String value) {
            addCriterion("online_mobile <=", value, "onlineMobile");
            return (Criteria) this;
        }

        public Criteria andOnlineMobileLike(String value) {
            addCriterion("online_mobile like", value, "onlineMobile");
            return (Criteria) this;
        }

        public Criteria andOnlineMobileNotLike(String value) {
            addCriterion("online_mobile not like", value, "onlineMobile");
            return (Criteria) this;
        }

        public Criteria andOnlineMobileIn(List<String> values) {
            addCriterion("online_mobile in", values, "onlineMobile");
            return (Criteria) this;
        }

        public Criteria andOnlineMobileNotIn(List<String> values) {
            addCriterion("online_mobile not in", values, "onlineMobile");
            return (Criteria) this;
        }

        public Criteria andOnlineMobileBetween(String value1, String value2) {
            addCriterion("online_mobile between", value1, value2, "onlineMobile");
            return (Criteria) this;
        }

        public Criteria andOnlineMobileNotBetween(String value1, String value2) {
            addCriterion("online_mobile not between", value1, value2, "onlineMobile");
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