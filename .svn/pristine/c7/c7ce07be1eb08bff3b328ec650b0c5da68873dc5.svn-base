package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RiskContractExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RiskContractExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andContractCodeIsNull() {
            addCriterion("contract_code is null");
            return (Criteria) this;
        }

        public Criteria andContractCodeIsNotNull() {
            addCriterion("contract_code is not null");
            return (Criteria) this;
        }

        public Criteria andContractCodeEqualTo(String value) {
            addCriterion("contract_code =", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeNotEqualTo(String value) {
            addCriterion("contract_code <>", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeGreaterThan(String value) {
            addCriterion("contract_code >", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeGreaterThanOrEqualTo(String value) {
            addCriterion("contract_code >=", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeLessThan(String value) {
            addCriterion("contract_code <", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeLessThanOrEqualTo(String value) {
            addCriterion("contract_code <=", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeLike(String value) {
            addCriterion("contract_code like", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeNotLike(String value) {
            addCriterion("contract_code not like", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeIn(List<String> values) {
            addCriterion("contract_code in", values, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeNotIn(List<String> values) {
            addCriterion("contract_code not in", values, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeBetween(String value1, String value2) {
            addCriterion("contract_code between", value1, value2, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeNotBetween(String value1, String value2) {
            addCriterion("contract_code not between", value1, value2, "contractCode");
            return (Criteria) this;
        }

        public Criteria andVarietyCodeIsNull() {
            addCriterion("variety_code is null");
            return (Criteria) this;
        }

        public Criteria andVarietyCodeIsNotNull() {
            addCriterion("variety_code is not null");
            return (Criteria) this;
        }

        public Criteria andVarietyCodeEqualTo(String value) {
            addCriterion("variety_code =", value, "varietyCode");
            return (Criteria) this;
        }

        public Criteria andVarietyCodeNotEqualTo(String value) {
            addCriterion("variety_code <>", value, "varietyCode");
            return (Criteria) this;
        }

        public Criteria andVarietyCodeGreaterThan(String value) {
            addCriterion("variety_code >", value, "varietyCode");
            return (Criteria) this;
        }

        public Criteria andVarietyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("variety_code >=", value, "varietyCode");
            return (Criteria) this;
        }

        public Criteria andVarietyCodeLessThan(String value) {
            addCriterion("variety_code <", value, "varietyCode");
            return (Criteria) this;
        }

        public Criteria andVarietyCodeLessThanOrEqualTo(String value) {
            addCriterion("variety_code <=", value, "varietyCode");
            return (Criteria) this;
        }

        public Criteria andVarietyCodeLike(String value) {
            addCriterion("variety_code like", value, "varietyCode");
            return (Criteria) this;
        }

        public Criteria andVarietyCodeNotLike(String value) {
            addCriterion("variety_code not like", value, "varietyCode");
            return (Criteria) this;
        }

        public Criteria andVarietyCodeIn(List<String> values) {
            addCriterion("variety_code in", values, "varietyCode");
            return (Criteria) this;
        }

        public Criteria andVarietyCodeNotIn(List<String> values) {
            addCriterion("variety_code not in", values, "varietyCode");
            return (Criteria) this;
        }

        public Criteria andVarietyCodeBetween(String value1, String value2) {
            addCriterion("variety_code between", value1, value2, "varietyCode");
            return (Criteria) this;
        }

        public Criteria andVarietyCodeNotBetween(String value1, String value2) {
            addCriterion("variety_code not between", value1, value2, "varietyCode");
            return (Criteria) this;
        }

        public Criteria andContractNameIsNull() {
            addCriterion("contract_name is null");
            return (Criteria) this;
        }

        public Criteria andContractNameIsNotNull() {
            addCriterion("contract_name is not null");
            return (Criteria) this;
        }

        public Criteria andContractNameEqualTo(String value) {
            addCriterion("contract_name =", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotEqualTo(String value) {
            addCriterion("contract_name <>", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameGreaterThan(String value) {
            addCriterion("contract_name >", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameGreaterThanOrEqualTo(String value) {
            addCriterion("contract_name >=", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLessThan(String value) {
            addCriterion("contract_name <", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLessThanOrEqualTo(String value) {
            addCriterion("contract_name <=", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLike(String value) {
            addCriterion("contract_name like", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotLike(String value) {
            addCriterion("contract_name not like", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameIn(List<String> values) {
            addCriterion("contract_name in", values, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotIn(List<String> values) {
            addCriterion("contract_name not in", values, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameBetween(String value1, String value2) {
            addCriterion("contract_name between", value1, value2, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotBetween(String value1, String value2) {
            addCriterion("contract_name not between", value1, value2, "contractName");
            return (Criteria) this;
        }

        public Criteria andMinchangepriceIsNull() {
            addCriterion("minchangeprice is null");
            return (Criteria) this;
        }

        public Criteria andMinchangepriceIsNotNull() {
            addCriterion("minchangeprice is not null");
            return (Criteria) this;
        }

        public Criteria andMinchangepriceEqualTo(BigDecimal value) {
            addCriterion("minchangeprice =", value, "minchangeprice");
            return (Criteria) this;
        }

        public Criteria andMinchangepriceNotEqualTo(BigDecimal value) {
            addCriterion("minchangeprice <>", value, "minchangeprice");
            return (Criteria) this;
        }

        public Criteria andMinchangepriceGreaterThan(BigDecimal value) {
            addCriterion("minchangeprice >", value, "minchangeprice");
            return (Criteria) this;
        }

        public Criteria andMinchangepriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("minchangeprice >=", value, "minchangeprice");
            return (Criteria) this;
        }

        public Criteria andMinchangepriceLessThan(BigDecimal value) {
            addCriterion("minchangeprice <", value, "minchangeprice");
            return (Criteria) this;
        }

        public Criteria andMinchangepriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("minchangeprice <=", value, "minchangeprice");
            return (Criteria) this;
        }

        public Criteria andMinchangepriceIn(List<BigDecimal> values) {
            addCriterion("minchangeprice in", values, "minchangeprice");
            return (Criteria) this;
        }

        public Criteria andMinchangepriceNotIn(List<BigDecimal> values) {
            addCriterion("minchangeprice not in", values, "minchangeprice");
            return (Criteria) this;
        }

        public Criteria andMinchangepriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("minchangeprice between", value1, value2, "minchangeprice");
            return (Criteria) this;
        }

        public Criteria andMinchangepriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("minchangeprice not between", value1, value2, "minchangeprice");
            return (Criteria) this;
        }

        public Criteria andPublicDayIsNull() {
            addCriterion("public_day is null");
            return (Criteria) this;
        }

        public Criteria andPublicDayIsNotNull() {
            addCriterion("public_day is not null");
            return (Criteria) this;
        }

        public Criteria andPublicDayEqualTo(Date value) {
            addCriterionForJDBCDate("public_day =", value, "publicDay");
            return (Criteria) this;
        }

        public Criteria andPublicDayNotEqualTo(Date value) {
            addCriterionForJDBCDate("public_day <>", value, "publicDay");
            return (Criteria) this;
        }

        public Criteria andPublicDayGreaterThan(Date value) {
            addCriterionForJDBCDate("public_day >", value, "publicDay");
            return (Criteria) this;
        }

        public Criteria andPublicDayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("public_day >=", value, "publicDay");
            return (Criteria) this;
        }

        public Criteria andPublicDayLessThan(Date value) {
            addCriterionForJDBCDate("public_day <", value, "publicDay");
            return (Criteria) this;
        }

        public Criteria andPublicDayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("public_day <=", value, "publicDay");
            return (Criteria) this;
        }

        public Criteria andPublicDayIn(List<Date> values) {
            addCriterionForJDBCDate("public_day in", values, "publicDay");
            return (Criteria) this;
        }

        public Criteria andPublicDayNotIn(List<Date> values) {
            addCriterionForJDBCDate("public_day not in", values, "publicDay");
            return (Criteria) this;
        }

        public Criteria andPublicDayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("public_day between", value1, value2, "publicDay");
            return (Criteria) this;
        }

        public Criteria andPublicDayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("public_day not between", value1, value2, "publicDay");
            return (Criteria) this;
        }

        public Criteria andPromptDayIsNull() {
            addCriterion("prompt_day is null");
            return (Criteria) this;
        }

        public Criteria andPromptDayIsNotNull() {
            addCriterion("prompt_day is not null");
            return (Criteria) this;
        }

        public Criteria andPromptDayEqualTo(Date value) {
            addCriterionForJDBCDate("prompt_day =", value, "promptDay");
            return (Criteria) this;
        }

        public Criteria andPromptDayNotEqualTo(Date value) {
            addCriterionForJDBCDate("prompt_day <>", value, "promptDay");
            return (Criteria) this;
        }

        public Criteria andPromptDayGreaterThan(Date value) {
            addCriterionForJDBCDate("prompt_day >", value, "promptDay");
            return (Criteria) this;
        }

        public Criteria andPromptDayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("prompt_day >=", value, "promptDay");
            return (Criteria) this;
        }

        public Criteria andPromptDayLessThan(Date value) {
            addCriterionForJDBCDate("prompt_day <", value, "promptDay");
            return (Criteria) this;
        }

        public Criteria andPromptDayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("prompt_day <=", value, "promptDay");
            return (Criteria) this;
        }

        public Criteria andPromptDayIn(List<Date> values) {
            addCriterionForJDBCDate("prompt_day in", values, "promptDay");
            return (Criteria) this;
        }

        public Criteria andPromptDayNotIn(List<Date> values) {
            addCriterionForJDBCDate("prompt_day not in", values, "promptDay");
            return (Criteria) this;
        }

        public Criteria andPromptDayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("prompt_day between", value1, value2, "promptDay");
            return (Criteria) this;
        }

        public Criteria andPromptDayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("prompt_day not between", value1, value2, "promptDay");
            return (Criteria) this;
        }

        public Criteria andExchangeNameIsNull() {
            addCriterion("exchange_name is null");
            return (Criteria) this;
        }

        public Criteria andExchangeNameIsNotNull() {
            addCriterion("exchange_name is not null");
            return (Criteria) this;
        }

        public Criteria andExchangeNameEqualTo(String value) {
            addCriterion("exchange_name =", value, "exchangeName");
            return (Criteria) this;
        }

        public Criteria andExchangeNameNotEqualTo(String value) {
            addCriterion("exchange_name <>", value, "exchangeName");
            return (Criteria) this;
        }

        public Criteria andExchangeNameGreaterThan(String value) {
            addCriterion("exchange_name >", value, "exchangeName");
            return (Criteria) this;
        }

        public Criteria andExchangeNameGreaterThanOrEqualTo(String value) {
            addCriterion("exchange_name >=", value, "exchangeName");
            return (Criteria) this;
        }

        public Criteria andExchangeNameLessThan(String value) {
            addCriterion("exchange_name <", value, "exchangeName");
            return (Criteria) this;
        }

        public Criteria andExchangeNameLessThanOrEqualTo(String value) {
            addCriterion("exchange_name <=", value, "exchangeName");
            return (Criteria) this;
        }

        public Criteria andExchangeNameLike(String value) {
            addCriterion("exchange_name like", value, "exchangeName");
            return (Criteria) this;
        }

        public Criteria andExchangeNameNotLike(String value) {
            addCriterion("exchange_name not like", value, "exchangeName");
            return (Criteria) this;
        }

        public Criteria andExchangeNameIn(List<String> values) {
            addCriterion("exchange_name in", values, "exchangeName");
            return (Criteria) this;
        }

        public Criteria andExchangeNameNotIn(List<String> values) {
            addCriterion("exchange_name not in", values, "exchangeName");
            return (Criteria) this;
        }

        public Criteria andExchangeNameBetween(String value1, String value2) {
            addCriterion("exchange_name between", value1, value2, "exchangeName");
            return (Criteria) this;
        }

        public Criteria andExchangeNameNotBetween(String value1, String value2) {
            addCriterion("exchange_name not between", value1, value2, "exchangeName");
            return (Criteria) this;
        }

        public Criteria andContractdetailIsNull() {
            addCriterion("contractdetail is null");
            return (Criteria) this;
        }

        public Criteria andContractdetailIsNotNull() {
            addCriterion("contractdetail is not null");
            return (Criteria) this;
        }

        public Criteria andContractdetailEqualTo(BigDecimal value) {
            addCriterion("contractdetail =", value, "contractdetail");
            return (Criteria) this;
        }

        public Criteria andContractdetailNotEqualTo(BigDecimal value) {
            addCriterion("contractdetail <>", value, "contractdetail");
            return (Criteria) this;
        }

        public Criteria andContractdetailGreaterThan(BigDecimal value) {
            addCriterion("contractdetail >", value, "contractdetail");
            return (Criteria) this;
        }

        public Criteria andContractdetailGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("contractdetail >=", value, "contractdetail");
            return (Criteria) this;
        }

        public Criteria andContractdetailLessThan(BigDecimal value) {
            addCriterion("contractdetail <", value, "contractdetail");
            return (Criteria) this;
        }

        public Criteria andContractdetailLessThanOrEqualTo(BigDecimal value) {
            addCriterion("contractdetail <=", value, "contractdetail");
            return (Criteria) this;
        }

        public Criteria andContractdetailIn(List<BigDecimal> values) {
            addCriterion("contractdetail in", values, "contractdetail");
            return (Criteria) this;
        }

        public Criteria andContractdetailNotIn(List<BigDecimal> values) {
            addCriterion("contractdetail not in", values, "contractdetail");
            return (Criteria) this;
        }

        public Criteria andContractdetailBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contractdetail between", value1, value2, "contractdetail");
            return (Criteria) this;
        }

        public Criteria andContractdetailNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contractdetail not between", value1, value2, "contractdetail");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
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