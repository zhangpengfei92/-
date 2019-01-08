package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ContractExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContractExample() {
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

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andMarketIsNull() {
            addCriterion("market is null");
            return (Criteria) this;
        }

        public Criteria andMarketIsNotNull() {
            addCriterion("market is not null");
            return (Criteria) this;
        }

        public Criteria andMarketEqualTo(Integer value) {
            addCriterion("market =", value, "market");
            return (Criteria) this;
        }

        public Criteria andMarketNotEqualTo(Integer value) {
            addCriterion("market <>", value, "market");
            return (Criteria) this;
        }

        public Criteria andMarketGreaterThan(Integer value) {
            addCriterion("market >", value, "market");
            return (Criteria) this;
        }

        public Criteria andMarketGreaterThanOrEqualTo(Integer value) {
            addCriterion("market >=", value, "market");
            return (Criteria) this;
        }

        public Criteria andMarketLessThan(Integer value) {
            addCriterion("market <", value, "market");
            return (Criteria) this;
        }

        public Criteria andMarketLessThanOrEqualTo(Integer value) {
            addCriterion("market <=", value, "market");
            return (Criteria) this;
        }

        public Criteria andMarketIn(List<Integer> values) {
            addCriterion("market in", values, "market");
            return (Criteria) this;
        }

        public Criteria andMarketNotIn(List<Integer> values) {
            addCriterion("market not in", values, "market");
            return (Criteria) this;
        }

        public Criteria andMarketBetween(Integer value1, Integer value2) {
            addCriterion("market between", value1, value2, "market");
            return (Criteria) this;
        }

        public Criteria andMarketNotBetween(Integer value1, Integer value2) {
            addCriterion("market not between", value1, value2, "market");
            return (Criteria) this;
        }

        public Criteria andHycodeIsNull() {
            addCriterion("hycode is null");
            return (Criteria) this;
        }

        public Criteria andHycodeIsNotNull() {
            addCriterion("hycode is not null");
            return (Criteria) this;
        }

        public Criteria andHycodeEqualTo(String value) {
            addCriterion("hycode =", value, "hycode");
            return (Criteria) this;
        }

        public Criteria andHycodeNotEqualTo(String value) {
            addCriterion("hycode <>", value, "hycode");
            return (Criteria) this;
        }

        public Criteria andHycodeGreaterThan(String value) {
            addCriterion("hycode >", value, "hycode");
            return (Criteria) this;
        }

        public Criteria andHycodeGreaterThanOrEqualTo(String value) {
            addCriterion("hycode >=", value, "hycode");
            return (Criteria) this;
        }

        public Criteria andHycodeLessThan(String value) {
            addCriterion("hycode <", value, "hycode");
            return (Criteria) this;
        }

        public Criteria andHycodeLessThanOrEqualTo(String value) {
            addCriterion("hycode <=", value, "hycode");
            return (Criteria) this;
        }

        public Criteria andHycodeLike(String value) {
            addCriterion("hycode like", value, "hycode");
            return (Criteria) this;
        }

        public Criteria andHycodeNotLike(String value) {
            addCriterion("hycode not like", value, "hycode");
            return (Criteria) this;
        }

        public Criteria andHycodeIn(List<String> values) {
            addCriterion("hycode in", values, "hycode");
            return (Criteria) this;
        }

        public Criteria andHycodeNotIn(List<String> values) {
            addCriterion("hycode not in", values, "hycode");
            return (Criteria) this;
        }

        public Criteria andHycodeBetween(String value1, String value2) {
            addCriterion("hycode between", value1, value2, "hycode");
            return (Criteria) this;
        }

        public Criteria andHycodeNotBetween(String value1, String value2) {
            addCriterion("hycode not between", value1, value2, "hycode");
            return (Criteria) this;
        }

        public Criteria andHynameIsNull() {
            addCriterion("hyname is null");
            return (Criteria) this;
        }

        public Criteria andHynameIsNotNull() {
            addCriterion("hyname is not null");
            return (Criteria) this;
        }

        public Criteria andHynameEqualTo(String value) {
            addCriterion("hyname =", value, "hyname");
            return (Criteria) this;
        }

        public Criteria andHynameNotEqualTo(String value) {
            addCriterion("hyname <>", value, "hyname");
            return (Criteria) this;
        }

        public Criteria andHynameGreaterThan(String value) {
            addCriterion("hyname >", value, "hyname");
            return (Criteria) this;
        }

        public Criteria andHynameGreaterThanOrEqualTo(String value) {
            addCriterion("hyname >=", value, "hyname");
            return (Criteria) this;
        }

        public Criteria andHynameLessThan(String value) {
            addCriterion("hyname <", value, "hyname");
            return (Criteria) this;
        }

        public Criteria andHynameLessThanOrEqualTo(String value) {
            addCriterion("hyname <=", value, "hyname");
            return (Criteria) this;
        }

        public Criteria andHynameLike(String value) {
            addCriterion("hyname like", value, "hyname");
            return (Criteria) this;
        }

        public Criteria andHynameNotLike(String value) {
            addCriterion("hyname not like", value, "hyname");
            return (Criteria) this;
        }

        public Criteria andHynameIn(List<String> values) {
            addCriterion("hyname in", values, "hyname");
            return (Criteria) this;
        }

        public Criteria andHynameNotIn(List<String> values) {
            addCriterion("hyname not in", values, "hyname");
            return (Criteria) this;
        }

        public Criteria andHynameBetween(String value1, String value2) {
            addCriterion("hyname between", value1, value2, "hyname");
            return (Criteria) this;
        }

        public Criteria andHynameNotBetween(String value1, String value2) {
            addCriterion("hyname not between", value1, value2, "hyname");
            return (Criteria) this;
        }

        public Criteria andHynumIsNull() {
            addCriterion("hynum is null");
            return (Criteria) this;
        }

        public Criteria andHynumIsNotNull() {
            addCriterion("hynum is not null");
            return (Criteria) this;
        }

        public Criteria andHynumEqualTo(BigDecimal value) {
            addCriterion("hynum =", value, "hynum");
            return (Criteria) this;
        }

        public Criteria andHynumNotEqualTo(BigDecimal value) {
            addCriterion("hynum <>", value, "hynum");
            return (Criteria) this;
        }

        public Criteria andHynumGreaterThan(BigDecimal value) {
            addCriterion("hynum >", value, "hynum");
            return (Criteria) this;
        }

        public Criteria andHynumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hynum >=", value, "hynum");
            return (Criteria) this;
        }

        public Criteria andHynumLessThan(BigDecimal value) {
            addCriterion("hynum <", value, "hynum");
            return (Criteria) this;
        }

        public Criteria andHynumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hynum <=", value, "hynum");
            return (Criteria) this;
        }

        public Criteria andHynumIn(List<BigDecimal> values) {
            addCriterion("hynum in", values, "hynum");
            return (Criteria) this;
        }

        public Criteria andHynumNotIn(List<BigDecimal> values) {
            addCriterion("hynum not in", values, "hynum");
            return (Criteria) this;
        }

        public Criteria andHynumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hynum between", value1, value2, "hynum");
            return (Criteria) this;
        }

        public Criteria andHynumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hynum not between", value1, value2, "hynum");
            return (Criteria) this;
        }

        public Criteria andMinpriceIsNull() {
            addCriterion("minprice is null");
            return (Criteria) this;
        }

        public Criteria andMinpriceIsNotNull() {
            addCriterion("minprice is not null");
            return (Criteria) this;
        }

        public Criteria andMinpriceEqualTo(BigDecimal value) {
            addCriterion("minprice =", value, "minprice");
            return (Criteria) this;
        }

        public Criteria andMinpriceNotEqualTo(BigDecimal value) {
            addCriterion("minprice <>", value, "minprice");
            return (Criteria) this;
        }

        public Criteria andMinpriceGreaterThan(BigDecimal value) {
            addCriterion("minprice >", value, "minprice");
            return (Criteria) this;
        }

        public Criteria andMinpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("minprice >=", value, "minprice");
            return (Criteria) this;
        }

        public Criteria andMinpriceLessThan(BigDecimal value) {
            addCriterion("minprice <", value, "minprice");
            return (Criteria) this;
        }

        public Criteria andMinpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("minprice <=", value, "minprice");
            return (Criteria) this;
        }

        public Criteria andMinpriceIn(List<BigDecimal> values) {
            addCriterion("minprice in", values, "minprice");
            return (Criteria) this;
        }

        public Criteria andMinpriceNotIn(List<BigDecimal> values) {
            addCriterion("minprice not in", values, "minprice");
            return (Criteria) this;
        }

        public Criteria andMinpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("minprice between", value1, value2, "minprice");
            return (Criteria) this;
        }

        public Criteria andMinpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("minprice not between", value1, value2, "minprice");
            return (Criteria) this;
        }

        public Criteria andBzIsNull() {
            addCriterion("bz is null");
            return (Criteria) this;
        }

        public Criteria andBzIsNotNull() {
            addCriterion("bz is not null");
            return (Criteria) this;
        }

        public Criteria andBzEqualTo(String value) {
            addCriterion("bz =", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotEqualTo(String value) {
            addCriterion("bz <>", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThan(String value) {
            addCriterion("bz >", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThanOrEqualTo(String value) {
            addCriterion("bz >=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThan(String value) {
            addCriterion("bz <", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThanOrEqualTo(String value) {
            addCriterion("bz <=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLike(String value) {
            addCriterion("bz like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotLike(String value) {
            addCriterion("bz not like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzIn(List<String> values) {
            addCriterion("bz in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotIn(List<String> values) {
            addCriterion("bz not in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzBetween(String value1, String value2) {
            addCriterion("bz between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotBetween(String value1, String value2) {
            addCriterion("bz not between", value1, value2, "bz");
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