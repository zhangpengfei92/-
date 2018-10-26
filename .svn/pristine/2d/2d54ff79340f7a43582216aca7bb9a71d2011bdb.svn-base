package com.jcl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserInfoDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserInfoDataExample() {
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

        public Criteria andProfileIsNull() {
            addCriterion("profile is null");
            return (Criteria) this;
        }

        public Criteria andProfileIsNotNull() {
            addCriterion("profile is not null");
            return (Criteria) this;
        }

        public Criteria andProfileEqualTo(String value) {
            addCriterion("profile =", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileNotEqualTo(String value) {
            addCriterion("profile <>", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileGreaterThan(String value) {
            addCriterion("profile >", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileGreaterThanOrEqualTo(String value) {
            addCriterion("profile >=", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileLessThan(String value) {
            addCriterion("profile <", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileLessThanOrEqualTo(String value) {
            addCriterion("profile <=", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileLike(String value) {
            addCriterion("profile like", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileNotLike(String value) {
            addCriterion("profile not like", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileIn(List<String> values) {
            addCriterion("profile in", values, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileNotIn(List<String> values) {
            addCriterion("profile not in", values, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileBetween(String value1, String value2) {
            addCriterion("profile between", value1, value2, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileNotBetween(String value1, String value2) {
            addCriterion("profile not between", value1, value2, "profile");
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

        public Criteria andPhoneuseridIsNull() {
            addCriterion("phoneUserid is null");
            return (Criteria) this;
        }

        public Criteria andPhoneuseridIsNotNull() {
            addCriterion("phoneUserid is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneuseridEqualTo(String value) {
            addCriterion("phoneUserid =", value, "phoneuserid");
            return (Criteria) this;
        }

        public Criteria andPhoneuseridNotEqualTo(String value) {
            addCriterion("phoneUserid <>", value, "phoneuserid");
            return (Criteria) this;
        }

        public Criteria andPhoneuseridGreaterThan(String value) {
            addCriterion("phoneUserid >", value, "phoneuserid");
            return (Criteria) this;
        }

        public Criteria andPhoneuseridGreaterThanOrEqualTo(String value) {
            addCriterion("phoneUserid >=", value, "phoneuserid");
            return (Criteria) this;
        }

        public Criteria andPhoneuseridLessThan(String value) {
            addCriterion("phoneUserid <", value, "phoneuserid");
            return (Criteria) this;
        }

        public Criteria andPhoneuseridLessThanOrEqualTo(String value) {
            addCriterion("phoneUserid <=", value, "phoneuserid");
            return (Criteria) this;
        }

        public Criteria andPhoneuseridLike(String value) {
            addCriterion("phoneUserid like", value, "phoneuserid");
            return (Criteria) this;
        }

        public Criteria andPhoneuseridNotLike(String value) {
            addCriterion("phoneUserid not like", value, "phoneuserid");
            return (Criteria) this;
        }

        public Criteria andPhoneuseridIn(List<String> values) {
            addCriterion("phoneUserid in", values, "phoneuserid");
            return (Criteria) this;
        }

        public Criteria andPhoneuseridNotIn(List<String> values) {
            addCriterion("phoneUserid not in", values, "phoneuserid");
            return (Criteria) this;
        }

        public Criteria andPhoneuseridBetween(String value1, String value2) {
            addCriterion("phoneUserid between", value1, value2, "phoneuserid");
            return (Criteria) this;
        }

        public Criteria andPhoneuseridNotBetween(String value1, String value2) {
            addCriterion("phoneUserid not between", value1, value2, "phoneuserid");
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

        public Criteria andTradetimeIsNull() {
            addCriterion("tradeTime is null");
            return (Criteria) this;
        }

        public Criteria andTradetimeIsNotNull() {
            addCriterion("tradeTime is not null");
            return (Criteria) this;
        }

        public Criteria andTradetimeEqualTo(Date value) {
            addCriterion("tradeTime =", value, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeNotEqualTo(Date value) {
            addCriterion("tradeTime <>", value, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeGreaterThan(Date value) {
            addCriterion("tradeTime >", value, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("tradeTime >=", value, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeLessThan(Date value) {
            addCriterion("tradeTime <", value, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeLessThanOrEqualTo(Date value) {
            addCriterion("tradeTime <=", value, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeIn(List<Date> values) {
            addCriterion("tradeTime in", values, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeNotIn(List<Date> values) {
            addCriterion("tradeTime not in", values, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeBetween(Date value1, Date value2) {
            addCriterion("tradeTime between", value1, value2, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeNotBetween(Date value1, Date value2) {
            addCriterion("tradeTime not between", value1, value2, "tradetime");
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

        public Criteria andUserstatusIsNull() {
            addCriterion("userStatus is null");
            return (Criteria) this;
        }

        public Criteria andUserstatusIsNotNull() {
            addCriterion("userStatus is not null");
            return (Criteria) this;
        }

        public Criteria andUserstatusEqualTo(Integer value) {
            addCriterion("userStatus =", value, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusNotEqualTo(Integer value) {
            addCriterion("userStatus <>", value, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusGreaterThan(Integer value) {
            addCriterion("userStatus >", value, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("userStatus >=", value, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusLessThan(Integer value) {
            addCriterion("userStatus <", value, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusLessThanOrEqualTo(Integer value) {
            addCriterion("userStatus <=", value, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusIn(List<Integer> values) {
            addCriterion("userStatus in", values, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusNotIn(List<Integer> values) {
            addCriterion("userStatus not in", values, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusBetween(Integer value1, Integer value2) {
            addCriterion("userStatus between", value1, value2, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("userStatus not between", value1, value2, "userstatus");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(String value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(String value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(String value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(String value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(String value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLike(String value) {
            addCriterion("birthday like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotLike(String value) {
            addCriterion("birthday not like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<String> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<String> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(String value1, String value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(String value1, String value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
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

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andHomephoneIsNull() {
            addCriterion("homePhone is null");
            return (Criteria) this;
        }

        public Criteria andHomephoneIsNotNull() {
            addCriterion("homePhone is not null");
            return (Criteria) this;
        }

        public Criteria andHomephoneEqualTo(String value) {
            addCriterion("homePhone =", value, "homephone");
            return (Criteria) this;
        }

        public Criteria andHomephoneNotEqualTo(String value) {
            addCriterion("homePhone <>", value, "homephone");
            return (Criteria) this;
        }

        public Criteria andHomephoneGreaterThan(String value) {
            addCriterion("homePhone >", value, "homephone");
            return (Criteria) this;
        }

        public Criteria andHomephoneGreaterThanOrEqualTo(String value) {
            addCriterion("homePhone >=", value, "homephone");
            return (Criteria) this;
        }

        public Criteria andHomephoneLessThan(String value) {
            addCriterion("homePhone <", value, "homephone");
            return (Criteria) this;
        }

        public Criteria andHomephoneLessThanOrEqualTo(String value) {
            addCriterion("homePhone <=", value, "homephone");
            return (Criteria) this;
        }

        public Criteria andHomephoneLike(String value) {
            addCriterion("homePhone like", value, "homephone");
            return (Criteria) this;
        }

        public Criteria andHomephoneNotLike(String value) {
            addCriterion("homePhone not like", value, "homephone");
            return (Criteria) this;
        }

        public Criteria andHomephoneIn(List<String> values) {
            addCriterion("homePhone in", values, "homephone");
            return (Criteria) this;
        }

        public Criteria andHomephoneNotIn(List<String> values) {
            addCriterion("homePhone not in", values, "homephone");
            return (Criteria) this;
        }

        public Criteria andHomephoneBetween(String value1, String value2) {
            addCriterion("homePhone between", value1, value2, "homephone");
            return (Criteria) this;
        }

        public Criteria andHomephoneNotBetween(String value1, String value2) {
            addCriterion("homePhone not between", value1, value2, "homephone");
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

        public Criteria andTelephoneIsNull() {
            addCriterion("telePhone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telePhone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telePhone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telePhone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telePhone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telePhone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telePhone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telePhone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telePhone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telePhone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telePhone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telePhone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telePhone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telePhone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andTownIsNull() {
            addCriterion("town is null");
            return (Criteria) this;
        }

        public Criteria andTownIsNotNull() {
            addCriterion("town is not null");
            return (Criteria) this;
        }

        public Criteria andTownEqualTo(String value) {
            addCriterion("town =", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotEqualTo(String value) {
            addCriterion("town <>", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownGreaterThan(String value) {
            addCriterion("town >", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownGreaterThanOrEqualTo(String value) {
            addCriterion("town >=", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownLessThan(String value) {
            addCriterion("town <", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownLessThanOrEqualTo(String value) {
            addCriterion("town <=", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownLike(String value) {
            addCriterion("town like", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotLike(String value) {
            addCriterion("town not like", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownIn(List<String> values) {
            addCriterion("town in", values, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotIn(List<String> values) {
            addCriterion("town not in", values, "town");
            return (Criteria) this;
        }

        public Criteria andTownBetween(String value1, String value2) {
            addCriterion("town between", value1, value2, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotBetween(String value1, String value2) {
            addCriterion("town not between", value1, value2, "town");
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

        public Criteria andHometownIsNull() {
            addCriterion("hometown is null");
            return (Criteria) this;
        }

        public Criteria andHometownIsNotNull() {
            addCriterion("hometown is not null");
            return (Criteria) this;
        }

        public Criteria andHometownEqualTo(String value) {
            addCriterion("hometown =", value, "hometown");
            return (Criteria) this;
        }

        public Criteria andHometownNotEqualTo(String value) {
            addCriterion("hometown <>", value, "hometown");
            return (Criteria) this;
        }

        public Criteria andHometownGreaterThan(String value) {
            addCriterion("hometown >", value, "hometown");
            return (Criteria) this;
        }

        public Criteria andHometownGreaterThanOrEqualTo(String value) {
            addCriterion("hometown >=", value, "hometown");
            return (Criteria) this;
        }

        public Criteria andHometownLessThan(String value) {
            addCriterion("hometown <", value, "hometown");
            return (Criteria) this;
        }

        public Criteria andHometownLessThanOrEqualTo(String value) {
            addCriterion("hometown <=", value, "hometown");
            return (Criteria) this;
        }

        public Criteria andHometownLike(String value) {
            addCriterion("hometown like", value, "hometown");
            return (Criteria) this;
        }

        public Criteria andHometownNotLike(String value) {
            addCriterion("hometown not like", value, "hometown");
            return (Criteria) this;
        }

        public Criteria andHometownIn(List<String> values) {
            addCriterion("hometown in", values, "hometown");
            return (Criteria) this;
        }

        public Criteria andHometownNotIn(List<String> values) {
            addCriterion("hometown not in", values, "hometown");
            return (Criteria) this;
        }

        public Criteria andHometownBetween(String value1, String value2) {
            addCriterion("hometown between", value1, value2, "hometown");
            return (Criteria) this;
        }

        public Criteria andHometownNotBetween(String value1, String value2) {
            addCriterion("hometown not between", value1, value2, "hometown");
            return (Criteria) this;
        }

        public Criteria andHomestyleIsNull() {
            addCriterion("homeStyle is null");
            return (Criteria) this;
        }

        public Criteria andHomestyleIsNotNull() {
            addCriterion("homeStyle is not null");
            return (Criteria) this;
        }

        public Criteria andHomestyleEqualTo(String value) {
            addCriterion("homeStyle =", value, "homestyle");
            return (Criteria) this;
        }

        public Criteria andHomestyleNotEqualTo(String value) {
            addCriterion("homeStyle <>", value, "homestyle");
            return (Criteria) this;
        }

        public Criteria andHomestyleGreaterThan(String value) {
            addCriterion("homeStyle >", value, "homestyle");
            return (Criteria) this;
        }

        public Criteria andHomestyleGreaterThanOrEqualTo(String value) {
            addCriterion("homeStyle >=", value, "homestyle");
            return (Criteria) this;
        }

        public Criteria andHomestyleLessThan(String value) {
            addCriterion("homeStyle <", value, "homestyle");
            return (Criteria) this;
        }

        public Criteria andHomestyleLessThanOrEqualTo(String value) {
            addCriterion("homeStyle <=", value, "homestyle");
            return (Criteria) this;
        }

        public Criteria andHomestyleLike(String value) {
            addCriterion("homeStyle like", value, "homestyle");
            return (Criteria) this;
        }

        public Criteria andHomestyleNotLike(String value) {
            addCriterion("homeStyle not like", value, "homestyle");
            return (Criteria) this;
        }

        public Criteria andHomestyleIn(List<String> values) {
            addCriterion("homeStyle in", values, "homestyle");
            return (Criteria) this;
        }

        public Criteria andHomestyleNotIn(List<String> values) {
            addCriterion("homeStyle not in", values, "homestyle");
            return (Criteria) this;
        }

        public Criteria andHomestyleBetween(String value1, String value2) {
            addCriterion("homeStyle between", value1, value2, "homestyle");
            return (Criteria) this;
        }

        public Criteria andHomestyleNotBetween(String value1, String value2) {
            addCriterion("homeStyle not between", value1, value2, "homestyle");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNull() {
            addCriterion("postcode is null");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNotNull() {
            addCriterion("postcode is not null");
            return (Criteria) this;
        }

        public Criteria andPostcodeEqualTo(String value) {
            addCriterion("postcode =", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotEqualTo(String value) {
            addCriterion("postcode <>", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThan(String value) {
            addCriterion("postcode >", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThanOrEqualTo(String value) {
            addCriterion("postcode >=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThan(String value) {
            addCriterion("postcode <", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThanOrEqualTo(String value) {
            addCriterion("postcode <=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLike(String value) {
            addCriterion("postcode like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotLike(String value) {
            addCriterion("postcode not like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeIn(List<String> values) {
            addCriterion("postcode in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotIn(List<String> values) {
            addCriterion("postcode not in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeBetween(String value1, String value2) {
            addCriterion("postcode between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotBetween(String value1, String value2) {
            addCriterion("postcode not between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andNationalityIsNull() {
            addCriterion("nationality is null");
            return (Criteria) this;
        }

        public Criteria andNationalityIsNotNull() {
            addCriterion("nationality is not null");
            return (Criteria) this;
        }

        public Criteria andNationalityEqualTo(String value) {
            addCriterion("nationality =", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityNotEqualTo(String value) {
            addCriterion("nationality <>", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityGreaterThan(String value) {
            addCriterion("nationality >", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityGreaterThanOrEqualTo(String value) {
            addCriterion("nationality >=", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityLessThan(String value) {
            addCriterion("nationality <", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityLessThanOrEqualTo(String value) {
            addCriterion("nationality <=", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityLike(String value) {
            addCriterion("nationality like", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityNotLike(String value) {
            addCriterion("nationality not like", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityIn(List<String> values) {
            addCriterion("nationality in", values, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityNotIn(List<String> values) {
            addCriterion("nationality not in", values, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityBetween(String value1, String value2) {
            addCriterion("nationality between", value1, value2, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityNotBetween(String value1, String value2) {
            addCriterion("nationality not between", value1, value2, "nationality");
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

        public Criteria andEnameIsNull() {
            addCriterion("ename is null");
            return (Criteria) this;
        }

        public Criteria andEnameIsNotNull() {
            addCriterion("ename is not null");
            return (Criteria) this;
        }

        public Criteria andEnameEqualTo(String value) {
            addCriterion("ename =", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotEqualTo(String value) {
            addCriterion("ename <>", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameGreaterThan(String value) {
            addCriterion("ename >", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameGreaterThanOrEqualTo(String value) {
            addCriterion("ename >=", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLessThan(String value) {
            addCriterion("ename <", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLessThanOrEqualTo(String value) {
            addCriterion("ename <=", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLike(String value) {
            addCriterion("ename like", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotLike(String value) {
            addCriterion("ename not like", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameIn(List<String> values) {
            addCriterion("ename in", values, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotIn(List<String> values) {
            addCriterion("ename not in", values, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameBetween(String value1, String value2) {
            addCriterion("ename between", value1, value2, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotBetween(String value1, String value2) {
            addCriterion("ename not between", value1, value2, "ename");
            return (Criteria) this;
        }

        public Criteria andCardimage1IsNull() {
            addCriterion("cardImage1 is null");
            return (Criteria) this;
        }

        public Criteria andCardimage1IsNotNull() {
            addCriterion("cardImage1 is not null");
            return (Criteria) this;
        }

        public Criteria andCardimage1EqualTo(String value) {
            addCriterion("cardImage1 =", value, "cardimage1");
            return (Criteria) this;
        }

        public Criteria andCardimage1NotEqualTo(String value) {
            addCriterion("cardImage1 <>", value, "cardimage1");
            return (Criteria) this;
        }

        public Criteria andCardimage1GreaterThan(String value) {
            addCriterion("cardImage1 >", value, "cardimage1");
            return (Criteria) this;
        }

        public Criteria andCardimage1GreaterThanOrEqualTo(String value) {
            addCriterion("cardImage1 >=", value, "cardimage1");
            return (Criteria) this;
        }

        public Criteria andCardimage1LessThan(String value) {
            addCriterion("cardImage1 <", value, "cardimage1");
            return (Criteria) this;
        }

        public Criteria andCardimage1LessThanOrEqualTo(String value) {
            addCriterion("cardImage1 <=", value, "cardimage1");
            return (Criteria) this;
        }

        public Criteria andCardimage1Like(String value) {
            addCriterion("cardImage1 like", value, "cardimage1");
            return (Criteria) this;
        }

        public Criteria andCardimage1NotLike(String value) {
            addCriterion("cardImage1 not like", value, "cardimage1");
            return (Criteria) this;
        }

        public Criteria andCardimage1In(List<String> values) {
            addCriterion("cardImage1 in", values, "cardimage1");
            return (Criteria) this;
        }

        public Criteria andCardimage1NotIn(List<String> values) {
            addCriterion("cardImage1 not in", values, "cardimage1");
            return (Criteria) this;
        }

        public Criteria andCardimage1Between(String value1, String value2) {
            addCriterion("cardImage1 between", value1, value2, "cardimage1");
            return (Criteria) this;
        }

        public Criteria andCardimage1NotBetween(String value1, String value2) {
            addCriterion("cardImage1 not between", value1, value2, "cardimage1");
            return (Criteria) this;
        }

        public Criteria andCardimage2IsNull() {
            addCriterion("cardImage2 is null");
            return (Criteria) this;
        }

        public Criteria andCardimage2IsNotNull() {
            addCriterion("cardImage2 is not null");
            return (Criteria) this;
        }

        public Criteria andCardimage2EqualTo(String value) {
            addCriterion("cardImage2 =", value, "cardimage2");
            return (Criteria) this;
        }

        public Criteria andCardimage2NotEqualTo(String value) {
            addCriterion("cardImage2 <>", value, "cardimage2");
            return (Criteria) this;
        }

        public Criteria andCardimage2GreaterThan(String value) {
            addCriterion("cardImage2 >", value, "cardimage2");
            return (Criteria) this;
        }

        public Criteria andCardimage2GreaterThanOrEqualTo(String value) {
            addCriterion("cardImage2 >=", value, "cardimage2");
            return (Criteria) this;
        }

        public Criteria andCardimage2LessThan(String value) {
            addCriterion("cardImage2 <", value, "cardimage2");
            return (Criteria) this;
        }

        public Criteria andCardimage2LessThanOrEqualTo(String value) {
            addCriterion("cardImage2 <=", value, "cardimage2");
            return (Criteria) this;
        }

        public Criteria andCardimage2Like(String value) {
            addCriterion("cardImage2 like", value, "cardimage2");
            return (Criteria) this;
        }

        public Criteria andCardimage2NotLike(String value) {
            addCriterion("cardImage2 not like", value, "cardimage2");
            return (Criteria) this;
        }

        public Criteria andCardimage2In(List<String> values) {
            addCriterion("cardImage2 in", values, "cardimage2");
            return (Criteria) this;
        }

        public Criteria andCardimage2NotIn(List<String> values) {
            addCriterion("cardImage2 not in", values, "cardimage2");
            return (Criteria) this;
        }

        public Criteria andCardimage2Between(String value1, String value2) {
            addCriterion("cardImage2 between", value1, value2, "cardimage2");
            return (Criteria) this;
        }

        public Criteria andCardimage2NotBetween(String value1, String value2) {
            addCriterion("cardImage2 not between", value1, value2, "cardimage2");
            return (Criteria) this;
        }

        public Criteria andCardimage3IsNull() {
            addCriterion("cardImage3 is null");
            return (Criteria) this;
        }

        public Criteria andCardimage3IsNotNull() {
            addCriterion("cardImage3 is not null");
            return (Criteria) this;
        }

        public Criteria andCardimage3EqualTo(String value) {
            addCriterion("cardImage3 =", value, "cardimage3");
            return (Criteria) this;
        }

        public Criteria andCardimage3NotEqualTo(String value) {
            addCriterion("cardImage3 <>", value, "cardimage3");
            return (Criteria) this;
        }

        public Criteria andCardimage3GreaterThan(String value) {
            addCriterion("cardImage3 >", value, "cardimage3");
            return (Criteria) this;
        }

        public Criteria andCardimage3GreaterThanOrEqualTo(String value) {
            addCriterion("cardImage3 >=", value, "cardimage3");
            return (Criteria) this;
        }

        public Criteria andCardimage3LessThan(String value) {
            addCriterion("cardImage3 <", value, "cardimage3");
            return (Criteria) this;
        }

        public Criteria andCardimage3LessThanOrEqualTo(String value) {
            addCriterion("cardImage3 <=", value, "cardimage3");
            return (Criteria) this;
        }

        public Criteria andCardimage3Like(String value) {
            addCriterion("cardImage3 like", value, "cardimage3");
            return (Criteria) this;
        }

        public Criteria andCardimage3NotLike(String value) {
            addCriterion("cardImage3 not like", value, "cardimage3");
            return (Criteria) this;
        }

        public Criteria andCardimage3In(List<String> values) {
            addCriterion("cardImage3 in", values, "cardimage3");
            return (Criteria) this;
        }

        public Criteria andCardimage3NotIn(List<String> values) {
            addCriterion("cardImage3 not in", values, "cardimage3");
            return (Criteria) this;
        }

        public Criteria andCardimage3Between(String value1, String value2) {
            addCriterion("cardImage3 between", value1, value2, "cardimage3");
            return (Criteria) this;
        }

        public Criteria andCardimage3NotBetween(String value1, String value2) {
            addCriterion("cardImage3 not between", value1, value2, "cardimage3");
            return (Criteria) this;
        }

        public Criteria andCardnumberIsNull() {
            addCriterion("cardNumber is null");
            return (Criteria) this;
        }

        public Criteria andCardnumberIsNotNull() {
            addCriterion("cardNumber is not null");
            return (Criteria) this;
        }

        public Criteria andCardnumberEqualTo(String value) {
            addCriterion("cardNumber =", value, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberNotEqualTo(String value) {
            addCriterion("cardNumber <>", value, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberGreaterThan(String value) {
            addCriterion("cardNumber >", value, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberGreaterThanOrEqualTo(String value) {
            addCriterion("cardNumber >=", value, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberLessThan(String value) {
            addCriterion("cardNumber <", value, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberLessThanOrEqualTo(String value) {
            addCriterion("cardNumber <=", value, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberLike(String value) {
            addCriterion("cardNumber like", value, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberNotLike(String value) {
            addCriterion("cardNumber not like", value, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberIn(List<String> values) {
            addCriterion("cardNumber in", values, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberNotIn(List<String> values) {
            addCriterion("cardNumber not in", values, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberBetween(String value1, String value2) {
            addCriterion("cardNumber between", value1, value2, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberNotBetween(String value1, String value2) {
            addCriterion("cardNumber not between", value1, value2, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
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

        public Criteria andCardstarttimeIsNull() {
            addCriterion("cardStarttime is null");
            return (Criteria) this;
        }

        public Criteria andCardstarttimeIsNotNull() {
            addCriterion("cardStarttime is not null");
            return (Criteria) this;
        }

        public Criteria andCardstarttimeEqualTo(String value) {
            addCriterion("cardStarttime =", value, "cardstarttime");
            return (Criteria) this;
        }

        public Criteria andCardstarttimeNotEqualTo(String value) {
            addCriterion("cardStarttime <>", value, "cardstarttime");
            return (Criteria) this;
        }

        public Criteria andCardstarttimeGreaterThan(String value) {
            addCriterion("cardStarttime >", value, "cardstarttime");
            return (Criteria) this;
        }

        public Criteria andCardstarttimeGreaterThanOrEqualTo(String value) {
            addCriterion("cardStarttime >=", value, "cardstarttime");
            return (Criteria) this;
        }

        public Criteria andCardstarttimeLessThan(String value) {
            addCriterion("cardStarttime <", value, "cardstarttime");
            return (Criteria) this;
        }

        public Criteria andCardstarttimeLessThanOrEqualTo(String value) {
            addCriterion("cardStarttime <=", value, "cardstarttime");
            return (Criteria) this;
        }

        public Criteria andCardstarttimeLike(String value) {
            addCriterion("cardStarttime like", value, "cardstarttime");
            return (Criteria) this;
        }

        public Criteria andCardstarttimeNotLike(String value) {
            addCriterion("cardStarttime not like", value, "cardstarttime");
            return (Criteria) this;
        }

        public Criteria andCardstarttimeIn(List<String> values) {
            addCriterion("cardStarttime in", values, "cardstarttime");
            return (Criteria) this;
        }

        public Criteria andCardstarttimeNotIn(List<String> values) {
            addCriterion("cardStarttime not in", values, "cardstarttime");
            return (Criteria) this;
        }

        public Criteria andCardstarttimeBetween(String value1, String value2) {
            addCriterion("cardStarttime between", value1, value2, "cardstarttime");
            return (Criteria) this;
        }

        public Criteria andCardstarttimeNotBetween(String value1, String value2) {
            addCriterion("cardStarttime not between", value1, value2, "cardstarttime");
            return (Criteria) this;
        }

        public Criteria andCardendtimeIsNull() {
            addCriterion("cardEndtime is null");
            return (Criteria) this;
        }

        public Criteria andCardendtimeIsNotNull() {
            addCriterion("cardEndtime is not null");
            return (Criteria) this;
        }

        public Criteria andCardendtimeEqualTo(String value) {
            addCriterion("cardEndtime =", value, "cardendtime");
            return (Criteria) this;
        }

        public Criteria andCardendtimeNotEqualTo(String value) {
            addCriterion("cardEndtime <>", value, "cardendtime");
            return (Criteria) this;
        }

        public Criteria andCardendtimeGreaterThan(String value) {
            addCriterion("cardEndtime >", value, "cardendtime");
            return (Criteria) this;
        }

        public Criteria andCardendtimeGreaterThanOrEqualTo(String value) {
            addCriterion("cardEndtime >=", value, "cardendtime");
            return (Criteria) this;
        }

        public Criteria andCardendtimeLessThan(String value) {
            addCriterion("cardEndtime <", value, "cardendtime");
            return (Criteria) this;
        }

        public Criteria andCardendtimeLessThanOrEqualTo(String value) {
            addCriterion("cardEndtime <=", value, "cardendtime");
            return (Criteria) this;
        }

        public Criteria andCardendtimeLike(String value) {
            addCriterion("cardEndtime like", value, "cardendtime");
            return (Criteria) this;
        }

        public Criteria andCardendtimeNotLike(String value) {
            addCriterion("cardEndtime not like", value, "cardendtime");
            return (Criteria) this;
        }

        public Criteria andCardendtimeIn(List<String> values) {
            addCriterion("cardEndtime in", values, "cardendtime");
            return (Criteria) this;
        }

        public Criteria andCardendtimeNotIn(List<String> values) {
            addCriterion("cardEndtime not in", values, "cardendtime");
            return (Criteria) this;
        }

        public Criteria andCardendtimeBetween(String value1, String value2) {
            addCriterion("cardEndtime between", value1, value2, "cardendtime");
            return (Criteria) this;
        }

        public Criteria andCardendtimeNotBetween(String value1, String value2) {
            addCriterion("cardEndtime not between", value1, value2, "cardendtime");
            return (Criteria) this;
        }

        public Criteria andAccounttypeIsNull() {
            addCriterion("accountType is null");
            return (Criteria) this;
        }

        public Criteria andAccounttypeIsNotNull() {
            addCriterion("accountType is not null");
            return (Criteria) this;
        }

        public Criteria andAccounttypeEqualTo(String value) {
            addCriterion("accountType =", value, "accounttype");
            return (Criteria) this;
        }

        public Criteria andAccounttypeNotEqualTo(String value) {
            addCriterion("accountType <>", value, "accounttype");
            return (Criteria) this;
        }

        public Criteria andAccounttypeGreaterThan(String value) {
            addCriterion("accountType >", value, "accounttype");
            return (Criteria) this;
        }

        public Criteria andAccounttypeGreaterThanOrEqualTo(String value) {
            addCriterion("accountType >=", value, "accounttype");
            return (Criteria) this;
        }

        public Criteria andAccounttypeLessThan(String value) {
            addCriterion("accountType <", value, "accounttype");
            return (Criteria) this;
        }

        public Criteria andAccounttypeLessThanOrEqualTo(String value) {
            addCriterion("accountType <=", value, "accounttype");
            return (Criteria) this;
        }

        public Criteria andAccounttypeLike(String value) {
            addCriterion("accountType like", value, "accounttype");
            return (Criteria) this;
        }

        public Criteria andAccounttypeNotLike(String value) {
            addCriterion("accountType not like", value, "accounttype");
            return (Criteria) this;
        }

        public Criteria andAccounttypeIn(List<String> values) {
            addCriterion("accountType in", values, "accounttype");
            return (Criteria) this;
        }

        public Criteria andAccounttypeNotIn(List<String> values) {
            addCriterion("accountType not in", values, "accounttype");
            return (Criteria) this;
        }

        public Criteria andAccounttypeBetween(String value1, String value2) {
            addCriterion("accountType between", value1, value2, "accounttype");
            return (Criteria) this;
        }

        public Criteria andAccounttypeNotBetween(String value1, String value2) {
            addCriterion("accountType not between", value1, value2, "accounttype");
            return (Criteria) this;
        }

        public Criteria andTradetypeIsNull() {
            addCriterion("tradeType is null");
            return (Criteria) this;
        }

        public Criteria andTradetypeIsNotNull() {
            addCriterion("tradeType is not null");
            return (Criteria) this;
        }

        public Criteria andTradetypeEqualTo(String value) {
            addCriterion("tradeType =", value, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeNotEqualTo(String value) {
            addCriterion("tradeType <>", value, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeGreaterThan(String value) {
            addCriterion("tradeType >", value, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeGreaterThanOrEqualTo(String value) {
            addCriterion("tradeType >=", value, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeLessThan(String value) {
            addCriterion("tradeType <", value, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeLessThanOrEqualTo(String value) {
            addCriterion("tradeType <=", value, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeLike(String value) {
            addCriterion("tradeType like", value, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeNotLike(String value) {
            addCriterion("tradeType not like", value, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeIn(List<String> values) {
            addCriterion("tradeType in", values, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeNotIn(List<String> values) {
            addCriterion("tradeType not in", values, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeBetween(String value1, String value2) {
            addCriterion("tradeType between", value1, value2, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeNotBetween(String value1, String value2) {
            addCriterion("tradeType not between", value1, value2, "tradetype");
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

        public Criteria andQqOpenidIsNull() {
            addCriterion("qq_openid is null");
            return (Criteria) this;
        }

        public Criteria andQqOpenidIsNotNull() {
            addCriterion("qq_openid is not null");
            return (Criteria) this;
        }

        public Criteria andQqOpenidEqualTo(String value) {
            addCriterion("qq_openid =", value, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidNotEqualTo(String value) {
            addCriterion("qq_openid <>", value, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidGreaterThan(String value) {
            addCriterion("qq_openid >", value, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("qq_openid >=", value, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidLessThan(String value) {
            addCriterion("qq_openid <", value, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidLessThanOrEqualTo(String value) {
            addCriterion("qq_openid <=", value, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidLike(String value) {
            addCriterion("qq_openid like", value, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidNotLike(String value) {
            addCriterion("qq_openid not like", value, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidIn(List<String> values) {
            addCriterion("qq_openid in", values, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidNotIn(List<String> values) {
            addCriterion("qq_openid not in", values, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidBetween(String value1, String value2) {
            addCriterion("qq_openid between", value1, value2, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidNotBetween(String value1, String value2) {
            addCriterion("qq_openid not between", value1, value2, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIsNull() {
            addCriterion("login_type is null");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIsNotNull() {
            addCriterion("login_type is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTypeEqualTo(String value) {
            addCriterion("login_type =", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeNotEqualTo(String value) {
            addCriterion("login_type <>", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeGreaterThan(String value) {
            addCriterion("login_type >", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeGreaterThanOrEqualTo(String value) {
            addCriterion("login_type >=", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeLessThan(String value) {
            addCriterion("login_type <", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeLessThanOrEqualTo(String value) {
            addCriterion("login_type <=", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeLike(String value) {
            addCriterion("login_type like", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeNotLike(String value) {
            addCriterion("login_type not like", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIn(List<String> values) {
            addCriterion("login_type in", values, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeNotIn(List<String> values) {
            addCriterion("login_type not in", values, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeBetween(String value1, String value2) {
            addCriterion("login_type between", value1, value2, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeNotBetween(String value1, String value2) {
            addCriterion("login_type not between", value1, value2, "loginType");
            return (Criteria) this;
        }

        public Criteria andWeiboOpenidIsNull() {
            addCriterion("weibo_openid is null");
            return (Criteria) this;
        }

        public Criteria andWeiboOpenidIsNotNull() {
            addCriterion("weibo_openid is not null");
            return (Criteria) this;
        }

        public Criteria andWeiboOpenidEqualTo(String value) {
            addCriterion("weibo_openid =", value, "weiboOpenid");
            return (Criteria) this;
        }

        public Criteria andWeiboOpenidNotEqualTo(String value) {
            addCriterion("weibo_openid <>", value, "weiboOpenid");
            return (Criteria) this;
        }

        public Criteria andWeiboOpenidGreaterThan(String value) {
            addCriterion("weibo_openid >", value, "weiboOpenid");
            return (Criteria) this;
        }

        public Criteria andWeiboOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("weibo_openid >=", value, "weiboOpenid");
            return (Criteria) this;
        }

        public Criteria andWeiboOpenidLessThan(String value) {
            addCriterion("weibo_openid <", value, "weiboOpenid");
            return (Criteria) this;
        }

        public Criteria andWeiboOpenidLessThanOrEqualTo(String value) {
            addCriterion("weibo_openid <=", value, "weiboOpenid");
            return (Criteria) this;
        }

        public Criteria andWeiboOpenidLike(String value) {
            addCriterion("weibo_openid like", value, "weiboOpenid");
            return (Criteria) this;
        }

        public Criteria andWeiboOpenidNotLike(String value) {
            addCriterion("weibo_openid not like", value, "weiboOpenid");
            return (Criteria) this;
        }

        public Criteria andWeiboOpenidIn(List<String> values) {
            addCriterion("weibo_openid in", values, "weiboOpenid");
            return (Criteria) this;
        }

        public Criteria andWeiboOpenidNotIn(List<String> values) {
            addCriterion("weibo_openid not in", values, "weiboOpenid");
            return (Criteria) this;
        }

        public Criteria andWeiboOpenidBetween(String value1, String value2) {
            addCriterion("weibo_openid between", value1, value2, "weiboOpenid");
            return (Criteria) this;
        }

        public Criteria andWeiboOpenidNotBetween(String value1, String value2) {
            addCriterion("weibo_openid not between", value1, value2, "weiboOpenid");
            return (Criteria) this;
        }

        public Criteria andStrategyIdIsNull() {
            addCriterion("strategy_id is null");
            return (Criteria) this;
        }

        public Criteria andStrategyIdIsNotNull() {
            addCriterion("strategy_id is not null");
            return (Criteria) this;
        }

        public Criteria andStrategyIdEqualTo(Integer value) {
            addCriterion("strategy_id =", value, "strategyId");
            return (Criteria) this;
        }

        public Criteria andStrategyIdNotEqualTo(Integer value) {
            addCriterion("strategy_id <>", value, "strategyId");
            return (Criteria) this;
        }

        public Criteria andStrategyIdGreaterThan(Integer value) {
            addCriterion("strategy_id >", value, "strategyId");
            return (Criteria) this;
        }

        public Criteria andStrategyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("strategy_id >=", value, "strategyId");
            return (Criteria) this;
        }

        public Criteria andStrategyIdLessThan(Integer value) {
            addCriterion("strategy_id <", value, "strategyId");
            return (Criteria) this;
        }

        public Criteria andStrategyIdLessThanOrEqualTo(Integer value) {
            addCriterion("strategy_id <=", value, "strategyId");
            return (Criteria) this;
        }

        public Criteria andStrategyIdIn(List<Integer> values) {
            addCriterion("strategy_id in", values, "strategyId");
            return (Criteria) this;
        }

        public Criteria andStrategyIdNotIn(List<Integer> values) {
            addCriterion("strategy_id not in", values, "strategyId");
            return (Criteria) this;
        }

        public Criteria andStrategyIdBetween(Integer value1, Integer value2) {
            addCriterion("strategy_id between", value1, value2, "strategyId");
            return (Criteria) this;
        }

        public Criteria andStrategyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("strategy_id not between", value1, value2, "strategyId");
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