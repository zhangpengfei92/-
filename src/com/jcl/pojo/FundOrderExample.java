package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FundOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FundOrderExample() {
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

        public Criteria andOrderidIsNull() {
            addCriterion("orderid is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(Integer value) {
            addCriterion("orderid =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(Integer value) {
            addCriterion("orderid <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(Integer value) {
            addCriterion("orderid >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderid >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(Integer value) {
            addCriterion("orderid <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(Integer value) {
            addCriterion("orderid <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<Integer> values) {
            addCriterion("orderid in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<Integer> values) {
            addCriterion("orderid not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(Integer value1, Integer value2) {
            addCriterion("orderid between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(Integer value1, Integer value2) {
            addCriterion("orderid not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andSubzhIsNull() {
            addCriterion("subzh is null");
            return (Criteria) this;
        }

        public Criteria andSubzhIsNotNull() {
            addCriterion("subzh is not null");
            return (Criteria) this;
        }

        public Criteria andSubzhEqualTo(String value) {
            addCriterion("subzh =", value, "subzh");
            return (Criteria) this;
        }

        public Criteria andSubzhNotEqualTo(String value) {
            addCriterion("subzh <>", value, "subzh");
            return (Criteria) this;
        }

        public Criteria andSubzhGreaterThan(String value) {
            addCriterion("subzh >", value, "subzh");
            return (Criteria) this;
        }

        public Criteria andSubzhGreaterThanOrEqualTo(String value) {
            addCriterion("subzh >=", value, "subzh");
            return (Criteria) this;
        }

        public Criteria andSubzhLessThan(String value) {
            addCriterion("subzh <", value, "subzh");
            return (Criteria) this;
        }

        public Criteria andSubzhLessThanOrEqualTo(String value) {
            addCriterion("subzh <=", value, "subzh");
            return (Criteria) this;
        }

        public Criteria andSubzhLike(String value) {
            addCriterion("subzh like", value, "subzh");
            return (Criteria) this;
        }

        public Criteria andSubzhNotLike(String value) {
            addCriterion("subzh not like", value, "subzh");
            return (Criteria) this;
        }

        public Criteria andSubzhIn(List<String> values) {
            addCriterion("subzh in", values, "subzh");
            return (Criteria) this;
        }

        public Criteria andSubzhNotIn(List<String> values) {
            addCriterion("subzh not in", values, "subzh");
            return (Criteria) this;
        }

        public Criteria andSubzhBetween(String value1, String value2) {
            addCriterion("subzh between", value1, value2, "subzh");
            return (Criteria) this;
        }

        public Criteria andSubzhNotBetween(String value1, String value2) {
            addCriterion("subzh not between", value1, value2, "subzh");
            return (Criteria) this;
        }

        public Criteria andZjUseIsNull() {
            addCriterion("zj_use is null");
            return (Criteria) this;
        }

        public Criteria andZjUseIsNotNull() {
            addCriterion("zj_use is not null");
            return (Criteria) this;
        }

        public Criteria andZjUseEqualTo(String value) {
            addCriterion("zj_use =", value, "zjUse");
            return (Criteria) this;
        }

        public Criteria andZjUseNotEqualTo(String value) {
            addCriterion("zj_use <>", value, "zjUse");
            return (Criteria) this;
        }

        public Criteria andZjUseGreaterThan(String value) {
            addCriterion("zj_use >", value, "zjUse");
            return (Criteria) this;
        }

        public Criteria andZjUseGreaterThanOrEqualTo(String value) {
            addCriterion("zj_use >=", value, "zjUse");
            return (Criteria) this;
        }

        public Criteria andZjUseLessThan(String value) {
            addCriterion("zj_use <", value, "zjUse");
            return (Criteria) this;
        }

        public Criteria andZjUseLessThanOrEqualTo(String value) {
            addCriterion("zj_use <=", value, "zjUse");
            return (Criteria) this;
        }

        public Criteria andZjUseLike(String value) {
            addCriterion("zj_use like", value, "zjUse");
            return (Criteria) this;
        }

        public Criteria andZjUseNotLike(String value) {
            addCriterion("zj_use not like", value, "zjUse");
            return (Criteria) this;
        }

        public Criteria andZjUseIn(List<String> values) {
            addCriterion("zj_use in", values, "zjUse");
            return (Criteria) this;
        }

        public Criteria andZjUseNotIn(List<String> values) {
            addCriterion("zj_use not in", values, "zjUse");
            return (Criteria) this;
        }

        public Criteria andZjUseBetween(String value1, String value2) {
            addCriterion("zj_use between", value1, value2, "zjUse");
            return (Criteria) this;
        }

        public Criteria andZjUseNotBetween(String value1, String value2) {
            addCriterion("zj_use not between", value1, value2, "zjUse");
            return (Criteria) this;
        }

        public Criteria andZjTypeIsNull() {
            addCriterion("zj_type is null");
            return (Criteria) this;
        }

        public Criteria andZjTypeIsNotNull() {
            addCriterion("zj_type is not null");
            return (Criteria) this;
        }

        public Criteria andZjTypeEqualTo(String value) {
            addCriterion("zj_type =", value, "zjType");
            return (Criteria) this;
        }

        public Criteria andZjTypeNotEqualTo(String value) {
            addCriterion("zj_type <>", value, "zjType");
            return (Criteria) this;
        }

        public Criteria andZjTypeGreaterThan(String value) {
            addCriterion("zj_type >", value, "zjType");
            return (Criteria) this;
        }

        public Criteria andZjTypeGreaterThanOrEqualTo(String value) {
            addCriterion("zj_type >=", value, "zjType");
            return (Criteria) this;
        }

        public Criteria andZjTypeLessThan(String value) {
            addCriterion("zj_type <", value, "zjType");
            return (Criteria) this;
        }

        public Criteria andZjTypeLessThanOrEqualTo(String value) {
            addCriterion("zj_type <=", value, "zjType");
            return (Criteria) this;
        }

        public Criteria andZjTypeLike(String value) {
            addCriterion("zj_type like", value, "zjType");
            return (Criteria) this;
        }

        public Criteria andZjTypeNotLike(String value) {
            addCriterion("zj_type not like", value, "zjType");
            return (Criteria) this;
        }

        public Criteria andZjTypeIn(List<String> values) {
            addCriterion("zj_type in", values, "zjType");
            return (Criteria) this;
        }

        public Criteria andZjTypeNotIn(List<String> values) {
            addCriterion("zj_type not in", values, "zjType");
            return (Criteria) this;
        }

        public Criteria andZjTypeBetween(String value1, String value2) {
            addCriterion("zj_type between", value1, value2, "zjType");
            return (Criteria) this;
        }

        public Criteria andZjTypeNotBetween(String value1, String value2) {
            addCriterion("zj_type not between", value1, value2, "zjType");
            return (Criteria) this;
        }

        public Criteria andPaymentzhIsNull() {
            addCriterion("paymentzh is null");
            return (Criteria) this;
        }

        public Criteria andPaymentzhIsNotNull() {
            addCriterion("paymentzh is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentzhEqualTo(String value) {
            addCriterion("paymentzh =", value, "paymentzh");
            return (Criteria) this;
        }

        public Criteria andPaymentzhNotEqualTo(String value) {
            addCriterion("paymentzh <>", value, "paymentzh");
            return (Criteria) this;
        }

        public Criteria andPaymentzhGreaterThan(String value) {
            addCriterion("paymentzh >", value, "paymentzh");
            return (Criteria) this;
        }

        public Criteria andPaymentzhGreaterThanOrEqualTo(String value) {
            addCriterion("paymentzh >=", value, "paymentzh");
            return (Criteria) this;
        }

        public Criteria andPaymentzhLessThan(String value) {
            addCriterion("paymentzh <", value, "paymentzh");
            return (Criteria) this;
        }

        public Criteria andPaymentzhLessThanOrEqualTo(String value) {
            addCriterion("paymentzh <=", value, "paymentzh");
            return (Criteria) this;
        }

        public Criteria andPaymentzhLike(String value) {
            addCriterion("paymentzh like", value, "paymentzh");
            return (Criteria) this;
        }

        public Criteria andPaymentzhNotLike(String value) {
            addCriterion("paymentzh not like", value, "paymentzh");
            return (Criteria) this;
        }

        public Criteria andPaymentzhIn(List<String> values) {
            addCriterion("paymentzh in", values, "paymentzh");
            return (Criteria) this;
        }

        public Criteria andPaymentzhNotIn(List<String> values) {
            addCriterion("paymentzh not in", values, "paymentzh");
            return (Criteria) this;
        }

        public Criteria andPaymentzhBetween(String value1, String value2) {
            addCriterion("paymentzh between", value1, value2, "paymentzh");
            return (Criteria) this;
        }

        public Criteria andPaymentzhNotBetween(String value1, String value2) {
            addCriterion("paymentzh not between", value1, value2, "paymentzh");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andKhNameIsNull() {
            addCriterion("kh_name is null");
            return (Criteria) this;
        }

        public Criteria andKhNameIsNotNull() {
            addCriterion("kh_name is not null");
            return (Criteria) this;
        }

        public Criteria andKhNameEqualTo(String value) {
            addCriterion("kh_name =", value, "khName");
            return (Criteria) this;
        }

        public Criteria andKhNameNotEqualTo(String value) {
            addCriterion("kh_name <>", value, "khName");
            return (Criteria) this;
        }

        public Criteria andKhNameGreaterThan(String value) {
            addCriterion("kh_name >", value, "khName");
            return (Criteria) this;
        }

        public Criteria andKhNameGreaterThanOrEqualTo(String value) {
            addCriterion("kh_name >=", value, "khName");
            return (Criteria) this;
        }

        public Criteria andKhNameLessThan(String value) {
            addCriterion("kh_name <", value, "khName");
            return (Criteria) this;
        }

        public Criteria andKhNameLessThanOrEqualTo(String value) {
            addCriterion("kh_name <=", value, "khName");
            return (Criteria) this;
        }

        public Criteria andKhNameLike(String value) {
            addCriterion("kh_name like", value, "khName");
            return (Criteria) this;
        }

        public Criteria andKhNameNotLike(String value) {
            addCriterion("kh_name not like", value, "khName");
            return (Criteria) this;
        }

        public Criteria andKhNameIn(List<String> values) {
            addCriterion("kh_name in", values, "khName");
            return (Criteria) this;
        }

        public Criteria andKhNameNotIn(List<String> values) {
            addCriterion("kh_name not in", values, "khName");
            return (Criteria) this;
        }

        public Criteria andKhNameBetween(String value1, String value2) {
            addCriterion("kh_name between", value1, value2, "khName");
            return (Criteria) this;
        }

        public Criteria andKhNameNotBetween(String value1, String value2) {
            addCriterion("kh_name not between", value1, value2, "khName");
            return (Criteria) this;
        }

        public Criteria andFundIsNull() {
            addCriterion("fund is null");
            return (Criteria) this;
        }

        public Criteria andFundIsNotNull() {
            addCriterion("fund is not null");
            return (Criteria) this;
        }

        public Criteria andFundEqualTo(BigDecimal value) {
            addCriterion("fund =", value, "fund");
            return (Criteria) this;
        }

        public Criteria andFundNotEqualTo(BigDecimal value) {
            addCriterion("fund <>", value, "fund");
            return (Criteria) this;
        }

        public Criteria andFundGreaterThan(BigDecimal value) {
            addCriterion("fund >", value, "fund");
            return (Criteria) this;
        }

        public Criteria andFundGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fund >=", value, "fund");
            return (Criteria) this;
        }

        public Criteria andFundLessThan(BigDecimal value) {
            addCriterion("fund <", value, "fund");
            return (Criteria) this;
        }

        public Criteria andFundLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fund <=", value, "fund");
            return (Criteria) this;
        }

        public Criteria andFundIn(List<BigDecimal> values) {
            addCriterion("fund in", values, "fund");
            return (Criteria) this;
        }

        public Criteria andFundNotIn(List<BigDecimal> values) {
            addCriterion("fund not in", values, "fund");
            return (Criteria) this;
        }

        public Criteria andFundBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fund between", value1, value2, "fund");
            return (Criteria) this;
        }

        public Criteria andFundNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fund not between", value1, value2, "fund");
            return (Criteria) this;
        }

        public Criteria andRemarkNameIsNull() {
            addCriterion("remark_name is null");
            return (Criteria) this;
        }

        public Criteria andRemarkNameIsNotNull() {
            addCriterion("remark_name is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkNameEqualTo(String value) {
            addCriterion("remark_name =", value, "remarkName");
            return (Criteria) this;
        }

        public Criteria andRemarkNameNotEqualTo(String value) {
            addCriterion("remark_name <>", value, "remarkName");
            return (Criteria) this;
        }

        public Criteria andRemarkNameGreaterThan(String value) {
            addCriterion("remark_name >", value, "remarkName");
            return (Criteria) this;
        }

        public Criteria andRemarkNameGreaterThanOrEqualTo(String value) {
            addCriterion("remark_name >=", value, "remarkName");
            return (Criteria) this;
        }

        public Criteria andRemarkNameLessThan(String value) {
            addCriterion("remark_name <", value, "remarkName");
            return (Criteria) this;
        }

        public Criteria andRemarkNameLessThanOrEqualTo(String value) {
            addCriterion("remark_name <=", value, "remarkName");
            return (Criteria) this;
        }

        public Criteria andRemarkNameLike(String value) {
            addCriterion("remark_name like", value, "remarkName");
            return (Criteria) this;
        }

        public Criteria andRemarkNameNotLike(String value) {
            addCriterion("remark_name not like", value, "remarkName");
            return (Criteria) this;
        }

        public Criteria andRemarkNameIn(List<String> values) {
            addCriterion("remark_name in", values, "remarkName");
            return (Criteria) this;
        }

        public Criteria andRemarkNameNotIn(List<String> values) {
            addCriterion("remark_name not in", values, "remarkName");
            return (Criteria) this;
        }

        public Criteria andRemarkNameBetween(String value1, String value2) {
            addCriterion("remark_name between", value1, value2, "remarkName");
            return (Criteria) this;
        }

        public Criteria andRemarkNameNotBetween(String value1, String value2) {
            addCriterion("remark_name not between", value1, value2, "remarkName");
            return (Criteria) this;
        }

        public Criteria andRemarkPhoneIsNull() {
            addCriterion("remark_phone is null");
            return (Criteria) this;
        }

        public Criteria andRemarkPhoneIsNotNull() {
            addCriterion("remark_phone is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkPhoneEqualTo(String value) {
            addCriterion("remark_phone =", value, "remarkPhone");
            return (Criteria) this;
        }

        public Criteria andRemarkPhoneNotEqualTo(String value) {
            addCriterion("remark_phone <>", value, "remarkPhone");
            return (Criteria) this;
        }

        public Criteria andRemarkPhoneGreaterThan(String value) {
            addCriterion("remark_phone >", value, "remarkPhone");
            return (Criteria) this;
        }

        public Criteria andRemarkPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("remark_phone >=", value, "remarkPhone");
            return (Criteria) this;
        }

        public Criteria andRemarkPhoneLessThan(String value) {
            addCriterion("remark_phone <", value, "remarkPhone");
            return (Criteria) this;
        }

        public Criteria andRemarkPhoneLessThanOrEqualTo(String value) {
            addCriterion("remark_phone <=", value, "remarkPhone");
            return (Criteria) this;
        }

        public Criteria andRemarkPhoneLike(String value) {
            addCriterion("remark_phone like", value, "remarkPhone");
            return (Criteria) this;
        }

        public Criteria andRemarkPhoneNotLike(String value) {
            addCriterion("remark_phone not like", value, "remarkPhone");
            return (Criteria) this;
        }

        public Criteria andRemarkPhoneIn(List<String> values) {
            addCriterion("remark_phone in", values, "remarkPhone");
            return (Criteria) this;
        }

        public Criteria andRemarkPhoneNotIn(List<String> values) {
            addCriterion("remark_phone not in", values, "remarkPhone");
            return (Criteria) this;
        }

        public Criteria andRemarkPhoneBetween(String value1, String value2) {
            addCriterion("remark_phone between", value1, value2, "remarkPhone");
            return (Criteria) this;
        }

        public Criteria andRemarkPhoneNotBetween(String value1, String value2) {
            addCriterion("remark_phone not between", value1, value2, "remarkPhone");
            return (Criteria) this;
        }

        public Criteria andOverTimeIsNull() {
            addCriterion("over_time is null");
            return (Criteria) this;
        }

        public Criteria andOverTimeIsNotNull() {
            addCriterion("over_time is not null");
            return (Criteria) this;
        }

        public Criteria andOverTimeEqualTo(Date value) {
            addCriterion("over_time =", value, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeNotEqualTo(Date value) {
            addCriterion("over_time <>", value, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeGreaterThan(Date value) {
            addCriterion("over_time >", value, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("over_time >=", value, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeLessThan(Date value) {
            addCriterion("over_time <", value, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeLessThanOrEqualTo(Date value) {
            addCriterion("over_time <=", value, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeIn(List<Date> values) {
            addCriterion("over_time in", values, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeNotIn(List<Date> values) {
            addCriterion("over_time not in", values, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeBetween(Date value1, Date value2) {
            addCriterion("over_time between", value1, value2, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeNotBetween(Date value1, Date value2) {
            addCriterion("over_time not between", value1, value2, "overTime");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSysUseridIsNull() {
            addCriterion("sys_userid is null");
            return (Criteria) this;
        }

        public Criteria andSysUseridIsNotNull() {
            addCriterion("sys_userid is not null");
            return (Criteria) this;
        }

        public Criteria andSysUseridEqualTo(Integer value) {
            addCriterion("sys_userid =", value, "sysUserid");
            return (Criteria) this;
        }

        public Criteria andSysUseridNotEqualTo(Integer value) {
            addCriterion("sys_userid <>", value, "sysUserid");
            return (Criteria) this;
        }

        public Criteria andSysUseridGreaterThan(Integer value) {
            addCriterion("sys_userid >", value, "sysUserid");
            return (Criteria) this;
        }

        public Criteria andSysUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("sys_userid >=", value, "sysUserid");
            return (Criteria) this;
        }

        public Criteria andSysUseridLessThan(Integer value) {
            addCriterion("sys_userid <", value, "sysUserid");
            return (Criteria) this;
        }

        public Criteria andSysUseridLessThanOrEqualTo(Integer value) {
            addCriterion("sys_userid <=", value, "sysUserid");
            return (Criteria) this;
        }

        public Criteria andSysUseridIn(List<Integer> values) {
            addCriterion("sys_userid in", values, "sysUserid");
            return (Criteria) this;
        }

        public Criteria andSysUseridNotIn(List<Integer> values) {
            addCriterion("sys_userid not in", values, "sysUserid");
            return (Criteria) this;
        }

        public Criteria andSysUseridBetween(Integer value1, Integer value2) {
            addCriterion("sys_userid between", value1, value2, "sysUserid");
            return (Criteria) this;
        }

        public Criteria andSysUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("sys_userid not between", value1, value2, "sysUserid");
            return (Criteria) this;
        }

        public Criteria andSysUserNameIsNull() {
            addCriterion("sys_user_name is null");
            return (Criteria) this;
        }

        public Criteria andSysUserNameIsNotNull() {
            addCriterion("sys_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andSysUserNameEqualTo(String value) {
            addCriterion("sys_user_name =", value, "sysUserName");
            return (Criteria) this;
        }

        public Criteria andSysUserNameNotEqualTo(String value) {
            addCriterion("sys_user_name <>", value, "sysUserName");
            return (Criteria) this;
        }

        public Criteria andSysUserNameGreaterThan(String value) {
            addCriterion("sys_user_name >", value, "sysUserName");
            return (Criteria) this;
        }

        public Criteria andSysUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("sys_user_name >=", value, "sysUserName");
            return (Criteria) this;
        }

        public Criteria andSysUserNameLessThan(String value) {
            addCriterion("sys_user_name <", value, "sysUserName");
            return (Criteria) this;
        }

        public Criteria andSysUserNameLessThanOrEqualTo(String value) {
            addCriterion("sys_user_name <=", value, "sysUserName");
            return (Criteria) this;
        }

        public Criteria andSysUserNameLike(String value) {
            addCriterion("sys_user_name like", value, "sysUserName");
            return (Criteria) this;
        }

        public Criteria andSysUserNameNotLike(String value) {
            addCriterion("sys_user_name not like", value, "sysUserName");
            return (Criteria) this;
        }

        public Criteria andSysUserNameIn(List<String> values) {
            addCriterion("sys_user_name in", values, "sysUserName");
            return (Criteria) this;
        }

        public Criteria andSysUserNameNotIn(List<String> values) {
            addCriterion("sys_user_name not in", values, "sysUserName");
            return (Criteria) this;
        }

        public Criteria andSysUserNameBetween(String value1, String value2) {
            addCriterion("sys_user_name between", value1, value2, "sysUserName");
            return (Criteria) this;
        }

        public Criteria andSysUserNameNotBetween(String value1, String value2) {
            addCriterion("sys_user_name not between", value1, value2, "sysUserName");
            return (Criteria) this;
        }

        public Criteria andSkNameIsNull() {
            addCriterion("sk_name is null");
            return (Criteria) this;
        }

        public Criteria andSkNameIsNotNull() {
            addCriterion("sk_name is not null");
            return (Criteria) this;
        }

        public Criteria andSkNameEqualTo(String value) {
            addCriterion("sk_name =", value, "skName");
            return (Criteria) this;
        }

        public Criteria andSkNameNotEqualTo(String value) {
            addCriterion("sk_name <>", value, "skName");
            return (Criteria) this;
        }

        public Criteria andSkNameGreaterThan(String value) {
            addCriterion("sk_name >", value, "skName");
            return (Criteria) this;
        }

        public Criteria andSkNameGreaterThanOrEqualTo(String value) {
            addCriterion("sk_name >=", value, "skName");
            return (Criteria) this;
        }

        public Criteria andSkNameLessThan(String value) {
            addCriterion("sk_name <", value, "skName");
            return (Criteria) this;
        }

        public Criteria andSkNameLessThanOrEqualTo(String value) {
            addCriterion("sk_name <=", value, "skName");
            return (Criteria) this;
        }

        public Criteria andSkNameLike(String value) {
            addCriterion("sk_name like", value, "skName");
            return (Criteria) this;
        }

        public Criteria andSkNameNotLike(String value) {
            addCriterion("sk_name not like", value, "skName");
            return (Criteria) this;
        }

        public Criteria andSkNameIn(List<String> values) {
            addCriterion("sk_name in", values, "skName");
            return (Criteria) this;
        }

        public Criteria andSkNameNotIn(List<String> values) {
            addCriterion("sk_name not in", values, "skName");
            return (Criteria) this;
        }

        public Criteria andSkNameBetween(String value1, String value2) {
            addCriterion("sk_name between", value1, value2, "skName");
            return (Criteria) this;
        }

        public Criteria andSkNameNotBetween(String value1, String value2) {
            addCriterion("sk_name not between", value1, value2, "skName");
            return (Criteria) this;
        }

        public Criteria andSkBankIsNull() {
            addCriterion("sk_bank is null");
            return (Criteria) this;
        }

        public Criteria andSkBankIsNotNull() {
            addCriterion("sk_bank is not null");
            return (Criteria) this;
        }

        public Criteria andSkBankEqualTo(String value) {
            addCriterion("sk_bank =", value, "skBank");
            return (Criteria) this;
        }

        public Criteria andSkBankNotEqualTo(String value) {
            addCriterion("sk_bank <>", value, "skBank");
            return (Criteria) this;
        }

        public Criteria andSkBankGreaterThan(String value) {
            addCriterion("sk_bank >", value, "skBank");
            return (Criteria) this;
        }

        public Criteria andSkBankGreaterThanOrEqualTo(String value) {
            addCriterion("sk_bank >=", value, "skBank");
            return (Criteria) this;
        }

        public Criteria andSkBankLessThan(String value) {
            addCriterion("sk_bank <", value, "skBank");
            return (Criteria) this;
        }

        public Criteria andSkBankLessThanOrEqualTo(String value) {
            addCriterion("sk_bank <=", value, "skBank");
            return (Criteria) this;
        }

        public Criteria andSkBankLike(String value) {
            addCriterion("sk_bank like", value, "skBank");
            return (Criteria) this;
        }

        public Criteria andSkBankNotLike(String value) {
            addCriterion("sk_bank not like", value, "skBank");
            return (Criteria) this;
        }

        public Criteria andSkBankIn(List<String> values) {
            addCriterion("sk_bank in", values, "skBank");
            return (Criteria) this;
        }

        public Criteria andSkBankNotIn(List<String> values) {
            addCriterion("sk_bank not in", values, "skBank");
            return (Criteria) this;
        }

        public Criteria andSkBankBetween(String value1, String value2) {
            addCriterion("sk_bank between", value1, value2, "skBank");
            return (Criteria) this;
        }

        public Criteria andSkBankNotBetween(String value1, String value2) {
            addCriterion("sk_bank not between", value1, value2, "skBank");
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

        public Criteria andModifiedTimeIsNull() {
            addCriterion("modified_time is null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNotNull() {
            addCriterion("modified_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeEqualTo(Date value) {
            addCriterion("modified_time =", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotEqualTo(Date value) {
            addCriterion("modified_time <>", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThan(Date value) {
            addCriterion("modified_time >", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modified_time >=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThan(Date value) {
            addCriterion("modified_time <", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThanOrEqualTo(Date value) {
            addCriterion("modified_time <=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIn(List<Date> values) {
            addCriterion("modified_time in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotIn(List<Date> values) {
            addCriterion("modified_time not in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeBetween(Date value1, Date value2) {
            addCriterion("modified_time between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotBetween(Date value1, Date value2) {
            addCriterion("modified_time not between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andSkBankNameIsNull() {
            addCriterion("sk_bank_name is null");
            return (Criteria) this;
        }

        public Criteria andSkBankNameIsNotNull() {
            addCriterion("sk_bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andSkBankNameEqualTo(String value) {
            addCriterion("sk_bank_name =", value, "skBankName");
            return (Criteria) this;
        }

        public Criteria andSkBankNameNotEqualTo(String value) {
            addCriterion("sk_bank_name <>", value, "skBankName");
            return (Criteria) this;
        }

        public Criteria andSkBankNameGreaterThan(String value) {
            addCriterion("sk_bank_name >", value, "skBankName");
            return (Criteria) this;
        }

        public Criteria andSkBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("sk_bank_name >=", value, "skBankName");
            return (Criteria) this;
        }

        public Criteria andSkBankNameLessThan(String value) {
            addCriterion("sk_bank_name <", value, "skBankName");
            return (Criteria) this;
        }

        public Criteria andSkBankNameLessThanOrEqualTo(String value) {
            addCriterion("sk_bank_name <=", value, "skBankName");
            return (Criteria) this;
        }

        public Criteria andSkBankNameLike(String value) {
            addCriterion("sk_bank_name like", value, "skBankName");
            return (Criteria) this;
        }

        public Criteria andSkBankNameNotLike(String value) {
            addCriterion("sk_bank_name not like", value, "skBankName");
            return (Criteria) this;
        }

        public Criteria andSkBankNameIn(List<String> values) {
            addCriterion("sk_bank_name in", values, "skBankName");
            return (Criteria) this;
        }

        public Criteria andSkBankNameNotIn(List<String> values) {
            addCriterion("sk_bank_name not in", values, "skBankName");
            return (Criteria) this;
        }

        public Criteria andSkBankNameBetween(String value1, String value2) {
            addCriterion("sk_bank_name between", value1, value2, "skBankName");
            return (Criteria) this;
        }

        public Criteria andSkBankNameNotBetween(String value1, String value2) {
            addCriterion("sk_bank_name not between", value1, value2, "skBankName");
            return (Criteria) this;
        }

        public Criteria andCzTypeIsNull() {
            addCriterion("cz_type is null");
            return (Criteria) this;
        }

        public Criteria andCzTypeIsNotNull() {
            addCriterion("cz_type is not null");
            return (Criteria) this;
        }

        public Criteria andCzTypeEqualTo(String value) {
            addCriterion("cz_type =", value, "czType");
            return (Criteria) this;
        }

        public Criteria andCzTypeNotEqualTo(String value) {
            addCriterion("cz_type <>", value, "czType");
            return (Criteria) this;
        }

        public Criteria andCzTypeGreaterThan(String value) {
            addCriterion("cz_type >", value, "czType");
            return (Criteria) this;
        }

        public Criteria andCzTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cz_type >=", value, "czType");
            return (Criteria) this;
        }

        public Criteria andCzTypeLessThan(String value) {
            addCriterion("cz_type <", value, "czType");
            return (Criteria) this;
        }

        public Criteria andCzTypeLessThanOrEqualTo(String value) {
            addCriterion("cz_type <=", value, "czType");
            return (Criteria) this;
        }

        public Criteria andCzTypeLike(String value) {
            addCriterion("cz_type like", value, "czType");
            return (Criteria) this;
        }

        public Criteria andCzTypeNotLike(String value) {
            addCriterion("cz_type not like", value, "czType");
            return (Criteria) this;
        }

        public Criteria andCzTypeIn(List<String> values) {
            addCriterion("cz_type in", values, "czType");
            return (Criteria) this;
        }

        public Criteria andCzTypeNotIn(List<String> values) {
            addCriterion("cz_type not in", values, "czType");
            return (Criteria) this;
        }

        public Criteria andCzTypeBetween(String value1, String value2) {
            addCriterion("cz_type between", value1, value2, "czType");
            return (Criteria) this;
        }

        public Criteria andCzTypeNotBetween(String value1, String value2) {
            addCriterion("cz_type not between", value1, value2, "czType");
            return (Criteria) this;
        }

        public Criteria andCkBankIsNull() {
            addCriterion("ck_bank is null");
            return (Criteria) this;
        }

        public Criteria andCkBankIsNotNull() {
            addCriterion("ck_bank is not null");
            return (Criteria) this;
        }

        public Criteria andCkBankEqualTo(String value) {
            addCriterion("ck_bank =", value, "ckBank");
            return (Criteria) this;
        }

        public Criteria andCkBankNotEqualTo(String value) {
            addCriterion("ck_bank <>", value, "ckBank");
            return (Criteria) this;
        }

        public Criteria andCkBankGreaterThan(String value) {
            addCriterion("ck_bank >", value, "ckBank");
            return (Criteria) this;
        }

        public Criteria andCkBankGreaterThanOrEqualTo(String value) {
            addCriterion("ck_bank >=", value, "ckBank");
            return (Criteria) this;
        }

        public Criteria andCkBankLessThan(String value) {
            addCriterion("ck_bank <", value, "ckBank");
            return (Criteria) this;
        }

        public Criteria andCkBankLessThanOrEqualTo(String value) {
            addCriterion("ck_bank <=", value, "ckBank");
            return (Criteria) this;
        }

        public Criteria andCkBankLike(String value) {
            addCriterion("ck_bank like", value, "ckBank");
            return (Criteria) this;
        }

        public Criteria andCkBankNotLike(String value) {
            addCriterion("ck_bank not like", value, "ckBank");
            return (Criteria) this;
        }

        public Criteria andCkBankIn(List<String> values) {
            addCriterion("ck_bank in", values, "ckBank");
            return (Criteria) this;
        }

        public Criteria andCkBankNotIn(List<String> values) {
            addCriterion("ck_bank not in", values, "ckBank");
            return (Criteria) this;
        }

        public Criteria andCkBankBetween(String value1, String value2) {
            addCriterion("ck_bank between", value1, value2, "ckBank");
            return (Criteria) this;
        }

        public Criteria andCkBankNotBetween(String value1, String value2) {
            addCriterion("ck_bank not between", value1, value2, "ckBank");
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