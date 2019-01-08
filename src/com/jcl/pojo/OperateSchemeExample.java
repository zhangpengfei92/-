package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OperateSchemeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OperateSchemeExample() {
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

        public Criteria andOsidIsNull() {
            addCriterion("osid is null");
            return (Criteria) this;
        }

        public Criteria andOsidIsNotNull() {
            addCriterion("osid is not null");
            return (Criteria) this;
        }

        public Criteria andOsidEqualTo(Integer value) {
            addCriterion("osid =", value, "osid");
            return (Criteria) this;
        }

        public Criteria andOsidNotEqualTo(Integer value) {
            addCriterion("osid <>", value, "osid");
            return (Criteria) this;
        }

        public Criteria andOsidGreaterThan(Integer value) {
            addCriterion("osid >", value, "osid");
            return (Criteria) this;
        }

        public Criteria andOsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("osid >=", value, "osid");
            return (Criteria) this;
        }

        public Criteria andOsidLessThan(Integer value) {
            addCriterion("osid <", value, "osid");
            return (Criteria) this;
        }

        public Criteria andOsidLessThanOrEqualTo(Integer value) {
            addCriterion("osid <=", value, "osid");
            return (Criteria) this;
        }

        public Criteria andOsidIn(List<Integer> values) {
            addCriterion("osid in", values, "osid");
            return (Criteria) this;
        }

        public Criteria andOsidNotIn(List<Integer> values) {
            addCriterion("osid not in", values, "osid");
            return (Criteria) this;
        }

        public Criteria andOsidBetween(Integer value1, Integer value2) {
            addCriterion("osid between", value1, value2, "osid");
            return (Criteria) this;
        }

        public Criteria andOsidNotBetween(Integer value1, Integer value2) {
            addCriterion("osid not between", value1, value2, "osid");
            return (Criteria) this;
        }

        public Criteria andSchemenameIsNull() {
            addCriterion("schemename is null");
            return (Criteria) this;
        }

        public Criteria andSchemenameIsNotNull() {
            addCriterion("schemename is not null");
            return (Criteria) this;
        }

        public Criteria andSchemenameEqualTo(String value) {
            addCriterion("schemename =", value, "schemename");
            return (Criteria) this;
        }

        public Criteria andSchemenameNotEqualTo(String value) {
            addCriterion("schemename <>", value, "schemename");
            return (Criteria) this;
        }

        public Criteria andSchemenameGreaterThan(String value) {
            addCriterion("schemename >", value, "schemename");
            return (Criteria) this;
        }

        public Criteria andSchemenameGreaterThanOrEqualTo(String value) {
            addCriterion("schemename >=", value, "schemename");
            return (Criteria) this;
        }

        public Criteria andSchemenameLessThan(String value) {
            addCriterion("schemename <", value, "schemename");
            return (Criteria) this;
        }

        public Criteria andSchemenameLessThanOrEqualTo(String value) {
            addCriterion("schemename <=", value, "schemename");
            return (Criteria) this;
        }

        public Criteria andSchemenameLike(String value) {
            addCriterion("schemename like", value, "schemename");
            return (Criteria) this;
        }

        public Criteria andSchemenameNotLike(String value) {
            addCriterion("schemename not like", value, "schemename");
            return (Criteria) this;
        }

        public Criteria andSchemenameIn(List<String> values) {
            addCriterion("schemename in", values, "schemename");
            return (Criteria) this;
        }

        public Criteria andSchemenameNotIn(List<String> values) {
            addCriterion("schemename not in", values, "schemename");
            return (Criteria) this;
        }

        public Criteria andSchemenameBetween(String value1, String value2) {
            addCriterion("schemename between", value1, value2, "schemename");
            return (Criteria) this;
        }

        public Criteria andSchemenameNotBetween(String value1, String value2) {
            addCriterion("schemename not between", value1, value2, "schemename");
            return (Criteria) this;
        }

        public Criteria andOperatermoneyIsNull() {
            addCriterion("operatermoney is null");
            return (Criteria) this;
        }

        public Criteria andOperatermoneyIsNotNull() {
            addCriterion("operatermoney is not null");
            return (Criteria) this;
        }

        public Criteria andOperatermoneyEqualTo(BigDecimal value) {
            addCriterion("operatermoney =", value, "operatermoney");
            return (Criteria) this;
        }

        public Criteria andOperatermoneyNotEqualTo(BigDecimal value) {
            addCriterion("operatermoney <>", value, "operatermoney");
            return (Criteria) this;
        }

        public Criteria andOperatermoneyGreaterThan(BigDecimal value) {
            addCriterion("operatermoney >", value, "operatermoney");
            return (Criteria) this;
        }

        public Criteria andOperatermoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("operatermoney >=", value, "operatermoney");
            return (Criteria) this;
        }

        public Criteria andOperatermoneyLessThan(BigDecimal value) {
            addCriterion("operatermoney <", value, "operatermoney");
            return (Criteria) this;
        }

        public Criteria andOperatermoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("operatermoney <=", value, "operatermoney");
            return (Criteria) this;
        }

        public Criteria andOperatermoneyIn(List<BigDecimal> values) {
            addCriterion("operatermoney in", values, "operatermoney");
            return (Criteria) this;
        }

        public Criteria andOperatermoneyNotIn(List<BigDecimal> values) {
            addCriterion("operatermoney not in", values, "operatermoney");
            return (Criteria) this;
        }

        public Criteria andOperatermoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("operatermoney between", value1, value2, "operatermoney");
            return (Criteria) this;
        }

        public Criteria andOperatermoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("operatermoney not between", value1, value2, "operatermoney");
            return (Criteria) this;
        }

        public Criteria andOperaterbzmoneyIsNull() {
            addCriterion("operaterbzmoney is null");
            return (Criteria) this;
        }

        public Criteria andOperaterbzmoneyIsNotNull() {
            addCriterion("operaterbzmoney is not null");
            return (Criteria) this;
        }

        public Criteria andOperaterbzmoneyEqualTo(BigDecimal value) {
            addCriterion("operaterbzmoney =", value, "operaterbzmoney");
            return (Criteria) this;
        }

        public Criteria andOperaterbzmoneyNotEqualTo(BigDecimal value) {
            addCriterion("operaterbzmoney <>", value, "operaterbzmoney");
            return (Criteria) this;
        }

        public Criteria andOperaterbzmoneyGreaterThan(BigDecimal value) {
            addCriterion("operaterbzmoney >", value, "operaterbzmoney");
            return (Criteria) this;
        }

        public Criteria andOperaterbzmoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("operaterbzmoney >=", value, "operaterbzmoney");
            return (Criteria) this;
        }

        public Criteria andOperaterbzmoneyLessThan(BigDecimal value) {
            addCriterion("operaterbzmoney <", value, "operaterbzmoney");
            return (Criteria) this;
        }

        public Criteria andOperaterbzmoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("operaterbzmoney <=", value, "operaterbzmoney");
            return (Criteria) this;
        }

        public Criteria andOperaterbzmoneyIn(List<BigDecimal> values) {
            addCriterion("operaterbzmoney in", values, "operaterbzmoney");
            return (Criteria) this;
        }

        public Criteria andOperaterbzmoneyNotIn(List<BigDecimal> values) {
            addCriterion("operaterbzmoney not in", values, "operaterbzmoney");
            return (Criteria) this;
        }

        public Criteria andOperaterbzmoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("operaterbzmoney between", value1, value2, "operaterbzmoney");
            return (Criteria) this;
        }

        public Criteria andOperaterbzmoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("operaterbzmoney not between", value1, value2, "operaterbzmoney");
            return (Criteria) this;
        }

        public Criteria andSxmoneyIsNull() {
            addCriterion("sxmoney is null");
            return (Criteria) this;
        }

        public Criteria andSxmoneyIsNotNull() {
            addCriterion("sxmoney is not null");
            return (Criteria) this;
        }

        public Criteria andSxmoneyEqualTo(BigDecimal value) {
            addCriterion("sxmoney =", value, "sxmoney");
            return (Criteria) this;
        }

        public Criteria andSxmoneyNotEqualTo(BigDecimal value) {
            addCriterion("sxmoney <>", value, "sxmoney");
            return (Criteria) this;
        }

        public Criteria andSxmoneyGreaterThan(BigDecimal value) {
            addCriterion("sxmoney >", value, "sxmoney");
            return (Criteria) this;
        }

        public Criteria andSxmoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sxmoney >=", value, "sxmoney");
            return (Criteria) this;
        }

        public Criteria andSxmoneyLessThan(BigDecimal value) {
            addCriterion("sxmoney <", value, "sxmoney");
            return (Criteria) this;
        }

        public Criteria andSxmoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sxmoney <=", value, "sxmoney");
            return (Criteria) this;
        }

        public Criteria andSxmoneyIn(List<BigDecimal> values) {
            addCriterion("sxmoney in", values, "sxmoney");
            return (Criteria) this;
        }

        public Criteria andSxmoneyNotIn(List<BigDecimal> values) {
            addCriterion("sxmoney not in", values, "sxmoney");
            return (Criteria) this;
        }

        public Criteria andSxmoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sxmoney between", value1, value2, "sxmoney");
            return (Criteria) this;
        }

        public Criteria andSxmoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sxmoney not between", value1, value2, "sxmoney");
            return (Criteria) this;
        }

        public Criteria andKsyjxbalanceIsNull() {
            addCriterion("ksyjxbalance is null");
            return (Criteria) this;
        }

        public Criteria andKsyjxbalanceIsNotNull() {
            addCriterion("ksyjxbalance is not null");
            return (Criteria) this;
        }

        public Criteria andKsyjxbalanceEqualTo(BigDecimal value) {
            addCriterion("ksyjxbalance =", value, "ksyjxbalance");
            return (Criteria) this;
        }

        public Criteria andKsyjxbalanceNotEqualTo(BigDecimal value) {
            addCriterion("ksyjxbalance <>", value, "ksyjxbalance");
            return (Criteria) this;
        }

        public Criteria andKsyjxbalanceGreaterThan(BigDecimal value) {
            addCriterion("ksyjxbalance >", value, "ksyjxbalance");
            return (Criteria) this;
        }

        public Criteria andKsyjxbalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ksyjxbalance >=", value, "ksyjxbalance");
            return (Criteria) this;
        }

        public Criteria andKsyjxbalanceLessThan(BigDecimal value) {
            addCriterion("ksyjxbalance <", value, "ksyjxbalance");
            return (Criteria) this;
        }

        public Criteria andKsyjxbalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ksyjxbalance <=", value, "ksyjxbalance");
            return (Criteria) this;
        }

        public Criteria andKsyjxbalanceIn(List<BigDecimal> values) {
            addCriterion("ksyjxbalance in", values, "ksyjxbalance");
            return (Criteria) this;
        }

        public Criteria andKsyjxbalanceNotIn(List<BigDecimal> values) {
            addCriterion("ksyjxbalance not in", values, "ksyjxbalance");
            return (Criteria) this;
        }

        public Criteria andKsyjxbalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ksyjxbalance between", value1, value2, "ksyjxbalance");
            return (Criteria) this;
        }

        public Criteria andKsyjxbalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ksyjxbalance not between", value1, value2, "ksyjxbalance");
            return (Criteria) this;
        }

        public Criteria andKspcxbalanceIsNull() {
            addCriterion("kspcxBalance is null");
            return (Criteria) this;
        }

        public Criteria andKspcxbalanceIsNotNull() {
            addCriterion("kspcxBalance is not null");
            return (Criteria) this;
        }

        public Criteria andKspcxbalanceEqualTo(BigDecimal value) {
            addCriterion("kspcxBalance =", value, "kspcxbalance");
            return (Criteria) this;
        }

        public Criteria andKspcxbalanceNotEqualTo(BigDecimal value) {
            addCriterion("kspcxBalance <>", value, "kspcxbalance");
            return (Criteria) this;
        }

        public Criteria andKspcxbalanceGreaterThan(BigDecimal value) {
            addCriterion("kspcxBalance >", value, "kspcxbalance");
            return (Criteria) this;
        }

        public Criteria andKspcxbalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("kspcxBalance >=", value, "kspcxbalance");
            return (Criteria) this;
        }

        public Criteria andKspcxbalanceLessThan(BigDecimal value) {
            addCriterion("kspcxBalance <", value, "kspcxbalance");
            return (Criteria) this;
        }

        public Criteria andKspcxbalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("kspcxBalance <=", value, "kspcxbalance");
            return (Criteria) this;
        }

        public Criteria andKspcxbalanceIn(List<BigDecimal> values) {
            addCriterion("kspcxBalance in", values, "kspcxbalance");
            return (Criteria) this;
        }

        public Criteria andKspcxbalanceNotIn(List<BigDecimal> values) {
            addCriterion("kspcxBalance not in", values, "kspcxbalance");
            return (Criteria) this;
        }

        public Criteria andKspcxbalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kspcxBalance between", value1, value2, "kspcxbalance");
            return (Criteria) this;
        }

        public Criteria andKspcxbalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kspcxBalance not between", value1, value2, "kspcxbalance");
            return (Criteria) this;
        }

        public Criteria andRiskTemplateIdIsNull() {
            addCriterion("risk_template_id is null");
            return (Criteria) this;
        }

        public Criteria andRiskTemplateIdIsNotNull() {
            addCriterion("risk_template_id is not null");
            return (Criteria) this;
        }

        public Criteria andRiskTemplateIdEqualTo(Integer value) {
            addCriterion("risk_template_id =", value, "riskTemplateId");
            return (Criteria) this;
        }

        public Criteria andRiskTemplateIdNotEqualTo(Integer value) {
            addCriterion("risk_template_id <>", value, "riskTemplateId");
            return (Criteria) this;
        }

        public Criteria andRiskTemplateIdGreaterThan(Integer value) {
            addCriterion("risk_template_id >", value, "riskTemplateId");
            return (Criteria) this;
        }

        public Criteria andRiskTemplateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("risk_template_id >=", value, "riskTemplateId");
            return (Criteria) this;
        }

        public Criteria andRiskTemplateIdLessThan(Integer value) {
            addCriterion("risk_template_id <", value, "riskTemplateId");
            return (Criteria) this;
        }

        public Criteria andRiskTemplateIdLessThanOrEqualTo(Integer value) {
            addCriterion("risk_template_id <=", value, "riskTemplateId");
            return (Criteria) this;
        }

        public Criteria andRiskTemplateIdIn(List<Integer> values) {
            addCriterion("risk_template_id in", values, "riskTemplateId");
            return (Criteria) this;
        }

        public Criteria andRiskTemplateIdNotIn(List<Integer> values) {
            addCriterion("risk_template_id not in", values, "riskTemplateId");
            return (Criteria) this;
        }

        public Criteria andRiskTemplateIdBetween(Integer value1, Integer value2) {
            addCriterion("risk_template_id between", value1, value2, "riskTemplateId");
            return (Criteria) this;
        }

        public Criteria andRiskTemplateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("risk_template_id not between", value1, value2, "riskTemplateId");
            return (Criteria) this;
        }

        public Criteria andZhglmoneyIsNull() {
            addCriterion("zhglmoney is null");
            return (Criteria) this;
        }

        public Criteria andZhglmoneyIsNotNull() {
            addCriterion("zhglmoney is not null");
            return (Criteria) this;
        }

        public Criteria andZhglmoneyEqualTo(BigDecimal value) {
            addCriterion("zhglmoney =", value, "zhglmoney");
            return (Criteria) this;
        }

        public Criteria andZhglmoneyNotEqualTo(BigDecimal value) {
            addCriterion("zhglmoney <>", value, "zhglmoney");
            return (Criteria) this;
        }

        public Criteria andZhglmoneyGreaterThan(BigDecimal value) {
            addCriterion("zhglmoney >", value, "zhglmoney");
            return (Criteria) this;
        }

        public Criteria andZhglmoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("zhglmoney >=", value, "zhglmoney");
            return (Criteria) this;
        }

        public Criteria andZhglmoneyLessThan(BigDecimal value) {
            addCriterion("zhglmoney <", value, "zhglmoney");
            return (Criteria) this;
        }

        public Criteria andZhglmoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("zhglmoney <=", value, "zhglmoney");
            return (Criteria) this;
        }

        public Criteria andZhglmoneyIn(List<BigDecimal> values) {
            addCriterion("zhglmoney in", values, "zhglmoney");
            return (Criteria) this;
        }

        public Criteria andZhglmoneyNotIn(List<BigDecimal> values) {
            addCriterion("zhglmoney not in", values, "zhglmoney");
            return (Criteria) this;
        }

        public Criteria andZhglmoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("zhglmoney between", value1, value2, "zhglmoney");
            return (Criteria) this;
        }

        public Criteria andZhglmoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("zhglmoney not between", value1, value2, "zhglmoney");
            return (Criteria) this;
        }

        public Criteria andOsremarkIsNull() {
            addCriterion("osremark is null");
            return (Criteria) this;
        }

        public Criteria andOsremarkIsNotNull() {
            addCriterion("osremark is not null");
            return (Criteria) this;
        }

        public Criteria andOsremarkEqualTo(String value) {
            addCriterion("osremark =", value, "osremark");
            return (Criteria) this;
        }

        public Criteria andOsremarkNotEqualTo(String value) {
            addCriterion("osremark <>", value, "osremark");
            return (Criteria) this;
        }

        public Criteria andOsremarkGreaterThan(String value) {
            addCriterion("osremark >", value, "osremark");
            return (Criteria) this;
        }

        public Criteria andOsremarkGreaterThanOrEqualTo(String value) {
            addCriterion("osremark >=", value, "osremark");
            return (Criteria) this;
        }

        public Criteria andOsremarkLessThan(String value) {
            addCriterion("osremark <", value, "osremark");
            return (Criteria) this;
        }

        public Criteria andOsremarkLessThanOrEqualTo(String value) {
            addCriterion("osremark <=", value, "osremark");
            return (Criteria) this;
        }

        public Criteria andOsremarkLike(String value) {
            addCriterion("osremark like", value, "osremark");
            return (Criteria) this;
        }

        public Criteria andOsremarkNotLike(String value) {
            addCriterion("osremark not like", value, "osremark");
            return (Criteria) this;
        }

        public Criteria andOsremarkIn(List<String> values) {
            addCriterion("osremark in", values, "osremark");
            return (Criteria) this;
        }

        public Criteria andOsremarkNotIn(List<String> values) {
            addCriterion("osremark not in", values, "osremark");
            return (Criteria) this;
        }

        public Criteria andOsremarkBetween(String value1, String value2) {
            addCriterion("osremark between", value1, value2, "osremark");
            return (Criteria) this;
        }

        public Criteria andOsremarkNotBetween(String value1, String value2) {
            addCriterion("osremark not between", value1, value2, "osremark");
            return (Criteria) this;
        }

        public Criteria andOsstateIsNull() {
            addCriterion("osstate is null");
            return (Criteria) this;
        }

        public Criteria andOsstateIsNotNull() {
            addCriterion("osstate is not null");
            return (Criteria) this;
        }

        public Criteria andOsstateEqualTo(Integer value) {
            addCriterion("osstate =", value, "osstate");
            return (Criteria) this;
        }

        public Criteria andOsstateNotEqualTo(Integer value) {
            addCriterion("osstate <>", value, "osstate");
            return (Criteria) this;
        }

        public Criteria andOsstateGreaterThan(Integer value) {
            addCriterion("osstate >", value, "osstate");
            return (Criteria) this;
        }

        public Criteria andOsstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("osstate >=", value, "osstate");
            return (Criteria) this;
        }

        public Criteria andOsstateLessThan(Integer value) {
            addCriterion("osstate <", value, "osstate");
            return (Criteria) this;
        }

        public Criteria andOsstateLessThanOrEqualTo(Integer value) {
            addCriterion("osstate <=", value, "osstate");
            return (Criteria) this;
        }

        public Criteria andOsstateIn(List<Integer> values) {
            addCriterion("osstate in", values, "osstate");
            return (Criteria) this;
        }

        public Criteria andOsstateNotIn(List<Integer> values) {
            addCriterion("osstate not in", values, "osstate");
            return (Criteria) this;
        }

        public Criteria andOsstateBetween(Integer value1, Integer value2) {
            addCriterion("osstate between", value1, value2, "osstate");
            return (Criteria) this;
        }

        public Criteria andOsstateNotBetween(Integer value1, Integer value2) {
            addCriterion("osstate not between", value1, value2, "osstate");
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