package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubServiceFeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubServiceFeeExample() {
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

        public Criteria andAgentphoneIsNull() {
            addCriterion("agentPhone is null");
            return (Criteria) this;
        }

        public Criteria andAgentphoneIsNotNull() {
            addCriterion("agentPhone is not null");
            return (Criteria) this;
        }

        public Criteria andAgentphoneEqualTo(String value) {
            addCriterion("agentPhone =", value, "agentphone");
            return (Criteria) this;
        }

        public Criteria andAgentphoneNotEqualTo(String value) {
            addCriterion("agentPhone <>", value, "agentphone");
            return (Criteria) this;
        }

        public Criteria andAgentphoneGreaterThan(String value) {
            addCriterion("agentPhone >", value, "agentphone");
            return (Criteria) this;
        }

        public Criteria andAgentphoneGreaterThanOrEqualTo(String value) {
            addCriterion("agentPhone >=", value, "agentphone");
            return (Criteria) this;
        }

        public Criteria andAgentphoneLessThan(String value) {
            addCriterion("agentPhone <", value, "agentphone");
            return (Criteria) this;
        }

        public Criteria andAgentphoneLessThanOrEqualTo(String value) {
            addCriterion("agentPhone <=", value, "agentphone");
            return (Criteria) this;
        }

        public Criteria andAgentphoneLike(String value) {
            addCriterion("agentPhone like", value, "agentphone");
            return (Criteria) this;
        }

        public Criteria andAgentphoneNotLike(String value) {
            addCriterion("agentPhone not like", value, "agentphone");
            return (Criteria) this;
        }

        public Criteria andAgentphoneIn(List<String> values) {
            addCriterion("agentPhone in", values, "agentphone");
            return (Criteria) this;
        }

        public Criteria andAgentphoneNotIn(List<String> values) {
            addCriterion("agentPhone not in", values, "agentphone");
            return (Criteria) this;
        }

        public Criteria andAgentphoneBetween(String value1, String value2) {
            addCriterion("agentPhone between", value1, value2, "agentphone");
            return (Criteria) this;
        }

        public Criteria andAgentphoneNotBetween(String value1, String value2) {
            addCriterion("agentPhone not between", value1, value2, "agentphone");
            return (Criteria) this;
        }

        public Criteria andFeepointIsNull() {
            addCriterion("feePoint is null");
            return (Criteria) this;
        }

        public Criteria andFeepointIsNotNull() {
            addCriterion("feePoint is not null");
            return (Criteria) this;
        }

        public Criteria andFeepointEqualTo(BigDecimal value) {
            addCriterion("feePoint =", value, "feepoint");
            return (Criteria) this;
        }

        public Criteria andFeepointNotEqualTo(BigDecimal value) {
            addCriterion("feePoint <>", value, "feepoint");
            return (Criteria) this;
        }

        public Criteria andFeepointGreaterThan(BigDecimal value) {
            addCriterion("feePoint >", value, "feepoint");
            return (Criteria) this;
        }

        public Criteria andFeepointGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("feePoint >=", value, "feepoint");
            return (Criteria) this;
        }

        public Criteria andFeepointLessThan(BigDecimal value) {
            addCriterion("feePoint <", value, "feepoint");
            return (Criteria) this;
        }

        public Criteria andFeepointLessThanOrEqualTo(BigDecimal value) {
            addCriterion("feePoint <=", value, "feepoint");
            return (Criteria) this;
        }

        public Criteria andFeepointIn(List<BigDecimal> values) {
            addCriterion("feePoint in", values, "feepoint");
            return (Criteria) this;
        }

        public Criteria andFeepointNotIn(List<BigDecimal> values) {
            addCriterion("feePoint not in", values, "feepoint");
            return (Criteria) this;
        }

        public Criteria andFeepointBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("feePoint between", value1, value2, "feepoint");
            return (Criteria) this;
        }

        public Criteria andFeepointNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("feePoint not between", value1, value2, "feepoint");
            return (Criteria) this;
        }

        public Criteria andFeebalanceIsNull() {
            addCriterion("feeBalance is null");
            return (Criteria) this;
        }

        public Criteria andFeebalanceIsNotNull() {
            addCriterion("feeBalance is not null");
            return (Criteria) this;
        }

        public Criteria andFeebalanceEqualTo(BigDecimal value) {
            addCriterion("feeBalance =", value, "feebalance");
            return (Criteria) this;
        }

        public Criteria andFeebalanceNotEqualTo(BigDecimal value) {
            addCriterion("feeBalance <>", value, "feebalance");
            return (Criteria) this;
        }

        public Criteria andFeebalanceGreaterThan(BigDecimal value) {
            addCriterion("feeBalance >", value, "feebalance");
            return (Criteria) this;
        }

        public Criteria andFeebalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("feeBalance >=", value, "feebalance");
            return (Criteria) this;
        }

        public Criteria andFeebalanceLessThan(BigDecimal value) {
            addCriterion("feeBalance <", value, "feebalance");
            return (Criteria) this;
        }

        public Criteria andFeebalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("feeBalance <=", value, "feebalance");
            return (Criteria) this;
        }

        public Criteria andFeebalanceIn(List<BigDecimal> values) {
            addCriterion("feeBalance in", values, "feebalance");
            return (Criteria) this;
        }

        public Criteria andFeebalanceNotIn(List<BigDecimal> values) {
            addCriterion("feeBalance not in", values, "feebalance");
            return (Criteria) this;
        }

        public Criteria andFeebalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("feeBalance between", value1, value2, "feebalance");
            return (Criteria) this;
        }

        public Criteria andFeebalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("feeBalance not between", value1, value2, "feebalance");
            return (Criteria) this;
        }

        public Criteria andWarnbalanceIsNull() {
            addCriterion("warnBalance is null");
            return (Criteria) this;
        }

        public Criteria andWarnbalanceIsNotNull() {
            addCriterion("warnBalance is not null");
            return (Criteria) this;
        }

        public Criteria andWarnbalanceEqualTo(BigDecimal value) {
            addCriterion("warnBalance =", value, "warnbalance");
            return (Criteria) this;
        }

        public Criteria andWarnbalanceNotEqualTo(BigDecimal value) {
            addCriterion("warnBalance <>", value, "warnbalance");
            return (Criteria) this;
        }

        public Criteria andWarnbalanceGreaterThan(BigDecimal value) {
            addCriterion("warnBalance >", value, "warnbalance");
            return (Criteria) this;
        }

        public Criteria andWarnbalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("warnBalance >=", value, "warnbalance");
            return (Criteria) this;
        }

        public Criteria andWarnbalanceLessThan(BigDecimal value) {
            addCriterion("warnBalance <", value, "warnbalance");
            return (Criteria) this;
        }

        public Criteria andWarnbalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("warnBalance <=", value, "warnbalance");
            return (Criteria) this;
        }

        public Criteria andWarnbalanceIn(List<BigDecimal> values) {
            addCriterion("warnBalance in", values, "warnbalance");
            return (Criteria) this;
        }

        public Criteria andWarnbalanceNotIn(List<BigDecimal> values) {
            addCriterion("warnBalance not in", values, "warnbalance");
            return (Criteria) this;
        }

        public Criteria andWarnbalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("warnBalance between", value1, value2, "warnbalance");
            return (Criteria) this;
        }

        public Criteria andWarnbalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("warnBalance not between", value1, value2, "warnbalance");
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

        public Criteria andModifytimeIsNull() {
            addCriterion("modifytime is null");
            return (Criteria) this;
        }

        public Criteria andModifytimeIsNotNull() {
            addCriterion("modifytime is not null");
            return (Criteria) this;
        }

        public Criteria andModifytimeEqualTo(Date value) {
            addCriterion("modifytime =", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotEqualTo(Date value) {
            addCriterion("modifytime <>", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeGreaterThan(Date value) {
            addCriterion("modifytime >", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modifytime >=", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeLessThan(Date value) {
            addCriterion("modifytime <", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeLessThanOrEqualTo(Date value) {
            addCriterion("modifytime <=", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeIn(List<Date> values) {
            addCriterion("modifytime in", values, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotIn(List<Date> values) {
            addCriterion("modifytime not in", values, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeBetween(Date value1, Date value2) {
            addCriterion("modifytime between", value1, value2, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotBetween(Date value1, Date value2) {
            addCriterion("modifytime not between", value1, value2, "modifytime");
            return (Criteria) this;
        }

        public Criteria andPagentzhIsNull() {
            addCriterion("pagentzh is null");
            return (Criteria) this;
        }

        public Criteria andPagentzhIsNotNull() {
            addCriterion("pagentzh is not null");
            return (Criteria) this;
        }

        public Criteria andPagentzhEqualTo(String value) {
            addCriterion("pagentzh =", value, "pagentzh");
            return (Criteria) this;
        }

        public Criteria andPagentzhNotEqualTo(String value) {
            addCriterion("pagentzh <>", value, "pagentzh");
            return (Criteria) this;
        }

        public Criteria andPagentzhGreaterThan(String value) {
            addCriterion("pagentzh >", value, "pagentzh");
            return (Criteria) this;
        }

        public Criteria andPagentzhGreaterThanOrEqualTo(String value) {
            addCriterion("pagentzh >=", value, "pagentzh");
            return (Criteria) this;
        }

        public Criteria andPagentzhLessThan(String value) {
            addCriterion("pagentzh <", value, "pagentzh");
            return (Criteria) this;
        }

        public Criteria andPagentzhLessThanOrEqualTo(String value) {
            addCriterion("pagentzh <=", value, "pagentzh");
            return (Criteria) this;
        }

        public Criteria andPagentzhLike(String value) {
            addCriterion("pagentzh like", value, "pagentzh");
            return (Criteria) this;
        }

        public Criteria andPagentzhNotLike(String value) {
            addCriterion("pagentzh not like", value, "pagentzh");
            return (Criteria) this;
        }

        public Criteria andPagentzhIn(List<String> values) {
            addCriterion("pagentzh in", values, "pagentzh");
            return (Criteria) this;
        }

        public Criteria andPagentzhNotIn(List<String> values) {
            addCriterion("pagentzh not in", values, "pagentzh");
            return (Criteria) this;
        }

        public Criteria andPagentzhBetween(String value1, String value2) {
            addCriterion("pagentzh between", value1, value2, "pagentzh");
            return (Criteria) this;
        }

        public Criteria andPagentzhNotBetween(String value1, String value2) {
            addCriterion("pagentzh not between", value1, value2, "pagentzh");
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