package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FeeSchemeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FeeSchemeExample() {
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

        public Criteria andLshIsNull() {
            addCriterion("lsh is null");
            return (Criteria) this;
        }

        public Criteria andLshIsNotNull() {
            addCriterion("lsh is not null");
            return (Criteria) this;
        }

        public Criteria andLshEqualTo(Integer value) {
            addCriterion("lsh =", value, "lsh");
            return (Criteria) this;
        }

        public Criteria andLshNotEqualTo(Integer value) {
            addCriterion("lsh <>", value, "lsh");
            return (Criteria) this;
        }

        public Criteria andLshGreaterThan(Integer value) {
            addCriterion("lsh >", value, "lsh");
            return (Criteria) this;
        }

        public Criteria andLshGreaterThanOrEqualTo(Integer value) {
            addCriterion("lsh >=", value, "lsh");
            return (Criteria) this;
        }

        public Criteria andLshLessThan(Integer value) {
            addCriterion("lsh <", value, "lsh");
            return (Criteria) this;
        }

        public Criteria andLshLessThanOrEqualTo(Integer value) {
            addCriterion("lsh <=", value, "lsh");
            return (Criteria) this;
        }

        public Criteria andLshIn(List<Integer> values) {
            addCriterion("lsh in", values, "lsh");
            return (Criteria) this;
        }

        public Criteria andLshNotIn(List<Integer> values) {
            addCriterion("lsh not in", values, "lsh");
            return (Criteria) this;
        }

        public Criteria andLshBetween(Integer value1, Integer value2) {
            addCriterion("lsh between", value1, value2, "lsh");
            return (Criteria) this;
        }

        public Criteria andLshNotBetween(Integer value1, Integer value2) {
            addCriterion("lsh not between", value1, value2, "lsh");
            return (Criteria) this;
        }

        public Criteria andSchemetypeIsNull() {
            addCriterion("schemeType is null");
            return (Criteria) this;
        }

        public Criteria andSchemetypeIsNotNull() {
            addCriterion("schemeType is not null");
            return (Criteria) this;
        }

        public Criteria andSchemetypeEqualTo(Byte value) {
            addCriterion("schemeType =", value, "schemetype");
            return (Criteria) this;
        }

        public Criteria andSchemetypeNotEqualTo(Byte value) {
            addCriterion("schemeType <>", value, "schemetype");
            return (Criteria) this;
        }

        public Criteria andSchemetypeGreaterThan(Byte value) {
            addCriterion("schemeType >", value, "schemetype");
            return (Criteria) this;
        }

        public Criteria andSchemetypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("schemeType >=", value, "schemetype");
            return (Criteria) this;
        }

        public Criteria andSchemetypeLessThan(Byte value) {
            addCriterion("schemeType <", value, "schemetype");
            return (Criteria) this;
        }

        public Criteria andSchemetypeLessThanOrEqualTo(Byte value) {
            addCriterion("schemeType <=", value, "schemetype");
            return (Criteria) this;
        }

        public Criteria andSchemetypeIn(List<Byte> values) {
            addCriterion("schemeType in", values, "schemetype");
            return (Criteria) this;
        }

        public Criteria andSchemetypeNotIn(List<Byte> values) {
            addCriterion("schemeType not in", values, "schemetype");
            return (Criteria) this;
        }

        public Criteria andSchemetypeBetween(Byte value1, Byte value2) {
            addCriterion("schemeType between", value1, value2, "schemetype");
            return (Criteria) this;
        }

        public Criteria andSchemetypeNotBetween(Byte value1, Byte value2) {
            addCriterion("schemeType not between", value1, value2, "schemetype");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNull() {
            addCriterion("direction is null");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNotNull() {
            addCriterion("direction is not null");
            return (Criteria) this;
        }

        public Criteria andDirectionEqualTo(String value) {
            addCriterion("direction =", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotEqualTo(String value) {
            addCriterion("direction <>", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThan(String value) {
            addCriterion("direction >", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThanOrEqualTo(String value) {
            addCriterion("direction >=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThan(String value) {
            addCriterion("direction <", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThanOrEqualTo(String value) {
            addCriterion("direction <=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLike(String value) {
            addCriterion("direction like", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotLike(String value) {
            addCriterion("direction not like", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionIn(List<String> values) {
            addCriterion("direction in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotIn(List<String> values) {
            addCriterion("direction not in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionBetween(String value1, String value2) {
            addCriterion("direction between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotBetween(String value1, String value2) {
            addCriterion("direction not between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andPercentageIsNull() {
            addCriterion("percentage is null");
            return (Criteria) this;
        }

        public Criteria andPercentageIsNotNull() {
            addCriterion("percentage is not null");
            return (Criteria) this;
        }

        public Criteria andPercentageEqualTo(BigDecimal value) {
            addCriterion("percentage =", value, "percentage");
            return (Criteria) this;
        }

        public Criteria andPercentageNotEqualTo(BigDecimal value) {
            addCriterion("percentage <>", value, "percentage");
            return (Criteria) this;
        }

        public Criteria andPercentageGreaterThan(BigDecimal value) {
            addCriterion("percentage >", value, "percentage");
            return (Criteria) this;
        }

        public Criteria andPercentageGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("percentage >=", value, "percentage");
            return (Criteria) this;
        }

        public Criteria andPercentageLessThan(BigDecimal value) {
            addCriterion("percentage <", value, "percentage");
            return (Criteria) this;
        }

        public Criteria andPercentageLessThanOrEqualTo(BigDecimal value) {
            addCriterion("percentage <=", value, "percentage");
            return (Criteria) this;
        }

        public Criteria andPercentageIn(List<BigDecimal> values) {
            addCriterion("percentage in", values, "percentage");
            return (Criteria) this;
        }

        public Criteria andPercentageNotIn(List<BigDecimal> values) {
            addCriterion("percentage not in", values, "percentage");
            return (Criteria) this;
        }

        public Criteria andPercentageBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("percentage between", value1, value2, "percentage");
            return (Criteria) this;
        }

        public Criteria andPercentageNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("percentage not between", value1, value2, "percentage");
            return (Criteria) this;
        }

        public Criteria andLowfeeIsNull() {
            addCriterion("lowfee is null");
            return (Criteria) this;
        }

        public Criteria andLowfeeIsNotNull() {
            addCriterion("lowfee is not null");
            return (Criteria) this;
        }

        public Criteria andLowfeeEqualTo(BigDecimal value) {
            addCriterion("lowfee =", value, "lowfee");
            return (Criteria) this;
        }

        public Criteria andLowfeeNotEqualTo(BigDecimal value) {
            addCriterion("lowfee <>", value, "lowfee");
            return (Criteria) this;
        }

        public Criteria andLowfeeGreaterThan(BigDecimal value) {
            addCriterion("lowfee >", value, "lowfee");
            return (Criteria) this;
        }

        public Criteria andLowfeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lowfee >=", value, "lowfee");
            return (Criteria) this;
        }

        public Criteria andLowfeeLessThan(BigDecimal value) {
            addCriterion("lowfee <", value, "lowfee");
            return (Criteria) this;
        }

        public Criteria andLowfeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lowfee <=", value, "lowfee");
            return (Criteria) this;
        }

        public Criteria andLowfeeIn(List<BigDecimal> values) {
            addCriterion("lowfee in", values, "lowfee");
            return (Criteria) this;
        }

        public Criteria andLowfeeNotIn(List<BigDecimal> values) {
            addCriterion("lowfee not in", values, "lowfee");
            return (Criteria) this;
        }

        public Criteria andLowfeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lowfee between", value1, value2, "lowfee");
            return (Criteria) this;
        }

        public Criteria andLowfeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lowfee not between", value1, value2, "lowfee");
            return (Criteria) this;
        }

        public Criteria andSchemenameIsNull() {
            addCriterion("schemeName is null");
            return (Criteria) this;
        }

        public Criteria andSchemenameIsNotNull() {
            addCriterion("schemeName is not null");
            return (Criteria) this;
        }

        public Criteria andSchemenameEqualTo(String value) {
            addCriterion("schemeName =", value, "schemename");
            return (Criteria) this;
        }

        public Criteria andSchemenameNotEqualTo(String value) {
            addCriterion("schemeName <>", value, "schemename");
            return (Criteria) this;
        }

        public Criteria andSchemenameGreaterThan(String value) {
            addCriterion("schemeName >", value, "schemename");
            return (Criteria) this;
        }

        public Criteria andSchemenameGreaterThanOrEqualTo(String value) {
            addCriterion("schemeName >=", value, "schemename");
            return (Criteria) this;
        }

        public Criteria andSchemenameLessThan(String value) {
            addCriterion("schemeName <", value, "schemename");
            return (Criteria) this;
        }

        public Criteria andSchemenameLessThanOrEqualTo(String value) {
            addCriterion("schemeName <=", value, "schemename");
            return (Criteria) this;
        }

        public Criteria andSchemenameLike(String value) {
            addCriterion("schemeName like", value, "schemename");
            return (Criteria) this;
        }

        public Criteria andSchemenameNotLike(String value) {
            addCriterion("schemeName not like", value, "schemename");
            return (Criteria) this;
        }

        public Criteria andSchemenameIn(List<String> values) {
            addCriterion("schemeName in", values, "schemename");
            return (Criteria) this;
        }

        public Criteria andSchemenameNotIn(List<String> values) {
            addCriterion("schemeName not in", values, "schemename");
            return (Criteria) this;
        }

        public Criteria andSchemenameBetween(String value1, String value2) {
            addCriterion("schemeName between", value1, value2, "schemename");
            return (Criteria) this;
        }

        public Criteria andSchemenameNotBetween(String value1, String value2) {
            addCriterion("schemeName not between", value1, value2, "schemename");
            return (Criteria) this;
        }

        public Criteria andShowstatusIsNull() {
            addCriterion("showStatus is null");
            return (Criteria) this;
        }

        public Criteria andShowstatusIsNotNull() {
            addCriterion("showStatus is not null");
            return (Criteria) this;
        }

        public Criteria andShowstatusEqualTo(Byte value) {
            addCriterion("showStatus =", value, "showstatus");
            return (Criteria) this;
        }

        public Criteria andShowstatusNotEqualTo(Byte value) {
            addCriterion("showStatus <>", value, "showstatus");
            return (Criteria) this;
        }

        public Criteria andShowstatusGreaterThan(Byte value) {
            addCriterion("showStatus >", value, "showstatus");
            return (Criteria) this;
        }

        public Criteria andShowstatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("showStatus >=", value, "showstatus");
            return (Criteria) this;
        }

        public Criteria andShowstatusLessThan(Byte value) {
            addCriterion("showStatus <", value, "showstatus");
            return (Criteria) this;
        }

        public Criteria andShowstatusLessThanOrEqualTo(Byte value) {
            addCriterion("showStatus <=", value, "showstatus");
            return (Criteria) this;
        }

        public Criteria andShowstatusIn(List<Byte> values) {
            addCriterion("showStatus in", values, "showstatus");
            return (Criteria) this;
        }

        public Criteria andShowstatusNotIn(List<Byte> values) {
            addCriterion("showStatus not in", values, "showstatus");
            return (Criteria) this;
        }

        public Criteria andShowstatusBetween(Byte value1, Byte value2) {
            addCriterion("showStatus between", value1, value2, "showstatus");
            return (Criteria) this;
        }

        public Criteria andShowstatusNotBetween(Byte value1, Byte value2) {
            addCriterion("showStatus not between", value1, value2, "showstatus");
            return (Criteria) this;
        }

        public Criteria andFeeschemeidIsNull() {
            addCriterion("feeSchemeId is null");
            return (Criteria) this;
        }

        public Criteria andFeeschemeidIsNotNull() {
            addCriterion("feeSchemeId is not null");
            return (Criteria) this;
        }

        public Criteria andFeeschemeidEqualTo(Integer value) {
            addCriterion("feeSchemeId =", value, "feeschemeid");
            return (Criteria) this;
        }

        public Criteria andFeeschemeidNotEqualTo(Integer value) {
            addCriterion("feeSchemeId <>", value, "feeschemeid");
            return (Criteria) this;
        }

        public Criteria andFeeschemeidGreaterThan(Integer value) {
            addCriterion("feeSchemeId >", value, "feeschemeid");
            return (Criteria) this;
        }

        public Criteria andFeeschemeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("feeSchemeId >=", value, "feeschemeid");
            return (Criteria) this;
        }

        public Criteria andFeeschemeidLessThan(Integer value) {
            addCriterion("feeSchemeId <", value, "feeschemeid");
            return (Criteria) this;
        }

        public Criteria andFeeschemeidLessThanOrEqualTo(Integer value) {
            addCriterion("feeSchemeId <=", value, "feeschemeid");
            return (Criteria) this;
        }

        public Criteria andFeeschemeidIn(List<Integer> values) {
            addCriterion("feeSchemeId in", values, "feeschemeid");
            return (Criteria) this;
        }

        public Criteria andFeeschemeidNotIn(List<Integer> values) {
            addCriterion("feeSchemeId not in", values, "feeschemeid");
            return (Criteria) this;
        }

        public Criteria andFeeschemeidBetween(Integer value1, Integer value2) {
            addCriterion("feeSchemeId between", value1, value2, "feeschemeid");
            return (Criteria) this;
        }

        public Criteria andFeeschemeidNotBetween(Integer value1, Integer value2) {
            addCriterion("feeSchemeId not between", value1, value2, "feeschemeid");
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