package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubFeelogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubFeelogExample() {
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

        public Criteria andNowbalanceIsNull() {
            addCriterion("nowBalance is null");
            return (Criteria) this;
        }

        public Criteria andNowbalanceIsNotNull() {
            addCriterion("nowBalance is not null");
            return (Criteria) this;
        }

        public Criteria andNowbalanceEqualTo(BigDecimal value) {
            addCriterion("nowBalance =", value, "nowbalance");
            return (Criteria) this;
        }

        public Criteria andNowbalanceNotEqualTo(BigDecimal value) {
            addCriterion("nowBalance <>", value, "nowbalance");
            return (Criteria) this;
        }

        public Criteria andNowbalanceGreaterThan(BigDecimal value) {
            addCriterion("nowBalance >", value, "nowbalance");
            return (Criteria) this;
        }

        public Criteria andNowbalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("nowBalance >=", value, "nowbalance");
            return (Criteria) this;
        }

        public Criteria andNowbalanceLessThan(BigDecimal value) {
            addCriterion("nowBalance <", value, "nowbalance");
            return (Criteria) this;
        }

        public Criteria andNowbalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("nowBalance <=", value, "nowbalance");
            return (Criteria) this;
        }

        public Criteria andNowbalanceIn(List<BigDecimal> values) {
            addCriterion("nowBalance in", values, "nowbalance");
            return (Criteria) this;
        }

        public Criteria andNowbalanceNotIn(List<BigDecimal> values) {
            addCriterion("nowBalance not in", values, "nowbalance");
            return (Criteria) this;
        }

        public Criteria andNowbalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("nowBalance between", value1, value2, "nowbalance");
            return (Criteria) this;
        }

        public Criteria andNowbalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("nowBalance not between", value1, value2, "nowbalance");
            return (Criteria) this;
        }

        public Criteria andAddbalanceIsNull() {
            addCriterion("addBalance is null");
            return (Criteria) this;
        }

        public Criteria andAddbalanceIsNotNull() {
            addCriterion("addBalance is not null");
            return (Criteria) this;
        }

        public Criteria andAddbalanceEqualTo(BigDecimal value) {
            addCriterion("addBalance =", value, "addbalance");
            return (Criteria) this;
        }

        public Criteria andAddbalanceNotEqualTo(BigDecimal value) {
            addCriterion("addBalance <>", value, "addbalance");
            return (Criteria) this;
        }

        public Criteria andAddbalanceGreaterThan(BigDecimal value) {
            addCriterion("addBalance >", value, "addbalance");
            return (Criteria) this;
        }

        public Criteria andAddbalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("addBalance >=", value, "addbalance");
            return (Criteria) this;
        }

        public Criteria andAddbalanceLessThan(BigDecimal value) {
            addCriterion("addBalance <", value, "addbalance");
            return (Criteria) this;
        }

        public Criteria andAddbalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("addBalance <=", value, "addbalance");
            return (Criteria) this;
        }

        public Criteria andAddbalanceIn(List<BigDecimal> values) {
            addCriterion("addBalance in", values, "addbalance");
            return (Criteria) this;
        }

        public Criteria andAddbalanceNotIn(List<BigDecimal> values) {
            addCriterion("addBalance not in", values, "addbalance");
            return (Criteria) this;
        }

        public Criteria andAddbalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("addBalance between", value1, value2, "addbalance");
            return (Criteria) this;
        }

        public Criteria andAddbalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("addBalance not between", value1, value2, "addbalance");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andFeetypeIsNull() {
            addCriterion("feetype is null");
            return (Criteria) this;
        }

        public Criteria andFeetypeIsNotNull() {
            addCriterion("feetype is not null");
            return (Criteria) this;
        }

        public Criteria andFeetypeEqualTo(Integer value) {
            addCriterion("feetype =", value, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeNotEqualTo(Integer value) {
            addCriterion("feetype <>", value, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeGreaterThan(Integer value) {
            addCriterion("feetype >", value, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("feetype >=", value, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeLessThan(Integer value) {
            addCriterion("feetype <", value, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeLessThanOrEqualTo(Integer value) {
            addCriterion("feetype <=", value, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeIn(List<Integer> values) {
            addCriterion("feetype in", values, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeNotIn(List<Integer> values) {
            addCriterion("feetype not in", values, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeBetween(Integer value1, Integer value2) {
            addCriterion("feetype between", value1, value2, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("feetype not between", value1, value2, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeedescIsNull() {
            addCriterion("feedesc is null");
            return (Criteria) this;
        }

        public Criteria andFeedescIsNotNull() {
            addCriterion("feedesc is not null");
            return (Criteria) this;
        }

        public Criteria andFeedescEqualTo(String value) {
            addCriterion("feedesc =", value, "feedesc");
            return (Criteria) this;
        }

        public Criteria andFeedescNotEqualTo(String value) {
            addCriterion("feedesc <>", value, "feedesc");
            return (Criteria) this;
        }

        public Criteria andFeedescGreaterThan(String value) {
            addCriterion("feedesc >", value, "feedesc");
            return (Criteria) this;
        }

        public Criteria andFeedescGreaterThanOrEqualTo(String value) {
            addCriterion("feedesc >=", value, "feedesc");
            return (Criteria) this;
        }

        public Criteria andFeedescLessThan(String value) {
            addCriterion("feedesc <", value, "feedesc");
            return (Criteria) this;
        }

        public Criteria andFeedescLessThanOrEqualTo(String value) {
            addCriterion("feedesc <=", value, "feedesc");
            return (Criteria) this;
        }

        public Criteria andFeedescLike(String value) {
            addCriterion("feedesc like", value, "feedesc");
            return (Criteria) this;
        }

        public Criteria andFeedescNotLike(String value) {
            addCriterion("feedesc not like", value, "feedesc");
            return (Criteria) this;
        }

        public Criteria andFeedescIn(List<String> values) {
            addCriterion("feedesc in", values, "feedesc");
            return (Criteria) this;
        }

        public Criteria andFeedescNotIn(List<String> values) {
            addCriterion("feedesc not in", values, "feedesc");
            return (Criteria) this;
        }

        public Criteria andFeedescBetween(String value1, String value2) {
            addCriterion("feedesc between", value1, value2, "feedesc");
            return (Criteria) this;
        }

        public Criteria andFeedescNotBetween(String value1, String value2) {
            addCriterion("feedesc not between", value1, value2, "feedesc");
            return (Criteria) this;
        }

        public Criteria andEnquiryidIsNull() {
            addCriterion("enquiryId is null");
            return (Criteria) this;
        }

        public Criteria andEnquiryidIsNotNull() {
            addCriterion("enquiryId is not null");
            return (Criteria) this;
        }

        public Criteria andEnquiryidEqualTo(Integer value) {
            addCriterion("enquiryId =", value, "enquiryid");
            return (Criteria) this;
        }

        public Criteria andEnquiryidNotEqualTo(Integer value) {
            addCriterion("enquiryId <>", value, "enquiryid");
            return (Criteria) this;
        }

        public Criteria andEnquiryidGreaterThan(Integer value) {
            addCriterion("enquiryId >", value, "enquiryid");
            return (Criteria) this;
        }

        public Criteria andEnquiryidGreaterThanOrEqualTo(Integer value) {
            addCriterion("enquiryId >=", value, "enquiryid");
            return (Criteria) this;
        }

        public Criteria andEnquiryidLessThan(Integer value) {
            addCriterion("enquiryId <", value, "enquiryid");
            return (Criteria) this;
        }

        public Criteria andEnquiryidLessThanOrEqualTo(Integer value) {
            addCriterion("enquiryId <=", value, "enquiryid");
            return (Criteria) this;
        }

        public Criteria andEnquiryidIn(List<Integer> values) {
            addCriterion("enquiryId in", values, "enquiryid");
            return (Criteria) this;
        }

        public Criteria andEnquiryidNotIn(List<Integer> values) {
            addCriterion("enquiryId not in", values, "enquiryid");
            return (Criteria) this;
        }

        public Criteria andEnquiryidBetween(Integer value1, Integer value2) {
            addCriterion("enquiryId between", value1, value2, "enquiryid");
            return (Criteria) this;
        }

        public Criteria andEnquiryidNotBetween(Integer value1, Integer value2) {
            addCriterion("enquiryId not between", value1, value2, "enquiryid");
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