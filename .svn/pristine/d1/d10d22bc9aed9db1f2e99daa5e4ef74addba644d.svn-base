package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SptExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SptExample() {
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

        public Criteria andMerchIsNull() {
            addCriterion("merch is null");
            return (Criteria) this;
        }

        public Criteria andMerchIsNotNull() {
            addCriterion("merch is not null");
            return (Criteria) this;
        }

        public Criteria andMerchEqualTo(String value) {
            addCriterion("merch =", value, "merch");
            return (Criteria) this;
        }

        public Criteria andMerchNotEqualTo(String value) {
            addCriterion("merch <>", value, "merch");
            return (Criteria) this;
        }

        public Criteria andMerchGreaterThan(String value) {
            addCriterion("merch >", value, "merch");
            return (Criteria) this;
        }

        public Criteria andMerchGreaterThanOrEqualTo(String value) {
            addCriterion("merch >=", value, "merch");
            return (Criteria) this;
        }

        public Criteria andMerchLessThan(String value) {
            addCriterion("merch <", value, "merch");
            return (Criteria) this;
        }

        public Criteria andMerchLessThanOrEqualTo(String value) {
            addCriterion("merch <=", value, "merch");
            return (Criteria) this;
        }

        public Criteria andMerchLike(String value) {
            addCriterion("merch like", value, "merch");
            return (Criteria) this;
        }

        public Criteria andMerchNotLike(String value) {
            addCriterion("merch not like", value, "merch");
            return (Criteria) this;
        }

        public Criteria andMerchIn(List<String> values) {
            addCriterion("merch in", values, "merch");
            return (Criteria) this;
        }

        public Criteria andMerchNotIn(List<String> values) {
            addCriterion("merch not in", values, "merch");
            return (Criteria) this;
        }

        public Criteria andMerchBetween(String value1, String value2) {
            addCriterion("merch between", value1, value2, "merch");
            return (Criteria) this;
        }

        public Criteria andMerchNotBetween(String value1, String value2) {
            addCriterion("merch not between", value1, value2, "merch");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
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

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andCoinIsNull() {
            addCriterion("coin is null");
            return (Criteria) this;
        }

        public Criteria andCoinIsNotNull() {
            addCriterion("coin is not null");
            return (Criteria) this;
        }

        public Criteria andCoinEqualTo(BigDecimal value) {
            addCriterion("coin =", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinNotEqualTo(BigDecimal value) {
            addCriterion("coin <>", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinGreaterThan(BigDecimal value) {
            addCriterion("coin >", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("coin >=", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinLessThan(BigDecimal value) {
            addCriterion("coin <", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinLessThanOrEqualTo(BigDecimal value) {
            addCriterion("coin <=", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinIn(List<BigDecimal> values) {
            addCriterion("coin in", values, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinNotIn(List<BigDecimal> values) {
            addCriterion("coin not in", values, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coin between", value1, value2, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coin not between", value1, value2, "coin");
            return (Criteria) this;
        }

        public Criteria andSettlenoIsNull() {
            addCriterion("settleno is null");
            return (Criteria) this;
        }

        public Criteria andSettlenoIsNotNull() {
            addCriterion("settleno is not null");
            return (Criteria) this;
        }

        public Criteria andSettlenoEqualTo(String value) {
            addCriterion("settleno =", value, "settleno");
            return (Criteria) this;
        }

        public Criteria andSettlenoNotEqualTo(String value) {
            addCriterion("settleno <>", value, "settleno");
            return (Criteria) this;
        }

        public Criteria andSettlenoGreaterThan(String value) {
            addCriterion("settleno >", value, "settleno");
            return (Criteria) this;
        }

        public Criteria andSettlenoGreaterThanOrEqualTo(String value) {
            addCriterion("settleno >=", value, "settleno");
            return (Criteria) this;
        }

        public Criteria andSettlenoLessThan(String value) {
            addCriterion("settleno <", value, "settleno");
            return (Criteria) this;
        }

        public Criteria andSettlenoLessThanOrEqualTo(String value) {
            addCriterion("settleno <=", value, "settleno");
            return (Criteria) this;
        }

        public Criteria andSettlenoLike(String value) {
            addCriterion("settleno like", value, "settleno");
            return (Criteria) this;
        }

        public Criteria andSettlenoNotLike(String value) {
            addCriterion("settleno not like", value, "settleno");
            return (Criteria) this;
        }

        public Criteria andSettlenoIn(List<String> values) {
            addCriterion("settleno in", values, "settleno");
            return (Criteria) this;
        }

        public Criteria andSettlenoNotIn(List<String> values) {
            addCriterion("settleno not in", values, "settleno");
            return (Criteria) this;
        }

        public Criteria andSettlenoBetween(String value1, String value2) {
            addCriterion("settleno between", value1, value2, "settleno");
            return (Criteria) this;
        }

        public Criteria andSettlenoNotBetween(String value1, String value2) {
            addCriterion("settleno not between", value1, value2, "settleno");
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