package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RiskSettingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RiskSettingExample() {
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

        public Criteria andRidIsNull() {
            addCriterion("rid is null");
            return (Criteria) this;
        }

        public Criteria andRidIsNotNull() {
            addCriterion("rid is not null");
            return (Criteria) this;
        }

        public Criteria andRidEqualTo(Integer value) {
            addCriterion("rid =", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotEqualTo(Integer value) {
            addCriterion("rid <>", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThan(Integer value) {
            addCriterion("rid >", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rid >=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThan(Integer value) {
            addCriterion("rid <", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThanOrEqualTo(Integer value) {
            addCriterion("rid <=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidIn(List<Integer> values) {
            addCriterion("rid in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotIn(List<Integer> values) {
            addCriterion("rid not in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidBetween(Integer value1, Integer value2) {
            addCriterion("rid between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotBetween(Integer value1, Integer value2) {
            addCriterion("rid not between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andPrincipalMinIsNull() {
            addCriterion("principal_min is null");
            return (Criteria) this;
        }

        public Criteria andPrincipalMinIsNotNull() {
            addCriterion("principal_min is not null");
            return (Criteria) this;
        }

        public Criteria andPrincipalMinEqualTo(BigDecimal value) {
            addCriterion("principal_min =", value, "principalMin");
            return (Criteria) this;
        }

        public Criteria andPrincipalMinNotEqualTo(BigDecimal value) {
            addCriterion("principal_min <>", value, "principalMin");
            return (Criteria) this;
        }

        public Criteria andPrincipalMinGreaterThan(BigDecimal value) {
            addCriterion("principal_min >", value, "principalMin");
            return (Criteria) this;
        }

        public Criteria andPrincipalMinGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("principal_min >=", value, "principalMin");
            return (Criteria) this;
        }

        public Criteria andPrincipalMinLessThan(BigDecimal value) {
            addCriterion("principal_min <", value, "principalMin");
            return (Criteria) this;
        }

        public Criteria andPrincipalMinLessThanOrEqualTo(BigDecimal value) {
            addCriterion("principal_min <=", value, "principalMin");
            return (Criteria) this;
        }

        public Criteria andPrincipalMinIn(List<BigDecimal> values) {
            addCriterion("principal_min in", values, "principalMin");
            return (Criteria) this;
        }

        public Criteria andPrincipalMinNotIn(List<BigDecimal> values) {
            addCriterion("principal_min not in", values, "principalMin");
            return (Criteria) this;
        }

        public Criteria andPrincipalMinBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("principal_min between", value1, value2, "principalMin");
            return (Criteria) this;
        }

        public Criteria andPrincipalMinNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("principal_min not between", value1, value2, "principalMin");
            return (Criteria) this;
        }

        public Criteria andPrincipalMaxIsNull() {
            addCriterion("principal_max is null");
            return (Criteria) this;
        }

        public Criteria andPrincipalMaxIsNotNull() {
            addCriterion("principal_max is not null");
            return (Criteria) this;
        }

        public Criteria andPrincipalMaxEqualTo(BigDecimal value) {
            addCriterion("principal_max =", value, "principalMax");
            return (Criteria) this;
        }

        public Criteria andPrincipalMaxNotEqualTo(BigDecimal value) {
            addCriterion("principal_max <>", value, "principalMax");
            return (Criteria) this;
        }

        public Criteria andPrincipalMaxGreaterThan(BigDecimal value) {
            addCriterion("principal_max >", value, "principalMax");
            return (Criteria) this;
        }

        public Criteria andPrincipalMaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("principal_max >=", value, "principalMax");
            return (Criteria) this;
        }

        public Criteria andPrincipalMaxLessThan(BigDecimal value) {
            addCriterion("principal_max <", value, "principalMax");
            return (Criteria) this;
        }

        public Criteria andPrincipalMaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("principal_max <=", value, "principalMax");
            return (Criteria) this;
        }

        public Criteria andPrincipalMaxIn(List<BigDecimal> values) {
            addCriterion("principal_max in", values, "principalMax");
            return (Criteria) this;
        }

        public Criteria andPrincipalMaxNotIn(List<BigDecimal> values) {
            addCriterion("principal_max not in", values, "principalMax");
            return (Criteria) this;
        }

        public Criteria andPrincipalMaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("principal_max between", value1, value2, "principalMax");
            return (Criteria) this;
        }

        public Criteria andPrincipalMaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("principal_max not between", value1, value2, "principalMax");
            return (Criteria) this;
        }

        public Criteria andLimitscopeIsNull() {
            addCriterion("limitscope is null");
            return (Criteria) this;
        }

        public Criteria andLimitscopeIsNotNull() {
            addCriterion("limitscope is not null");
            return (Criteria) this;
        }

        public Criteria andLimitscopeEqualTo(Double value) {
            addCriterion("limitscope =", value, "limitscope");
            return (Criteria) this;
        }

        public Criteria andLimitscopeNotEqualTo(Double value) {
            addCriterion("limitscope <>", value, "limitscope");
            return (Criteria) this;
        }

        public Criteria andLimitscopeGreaterThan(Double value) {
            addCriterion("limitscope >", value, "limitscope");
            return (Criteria) this;
        }

        public Criteria andLimitscopeGreaterThanOrEqualTo(Double value) {
            addCriterion("limitscope >=", value, "limitscope");
            return (Criteria) this;
        }

        public Criteria andLimitscopeLessThan(Double value) {
            addCriterion("limitscope <", value, "limitscope");
            return (Criteria) this;
        }

        public Criteria andLimitscopeLessThanOrEqualTo(Double value) {
            addCriterion("limitscope <=", value, "limitscope");
            return (Criteria) this;
        }

        public Criteria andLimitscopeIn(List<Double> values) {
            addCriterion("limitscope in", values, "limitscope");
            return (Criteria) this;
        }

        public Criteria andLimitscopeNotIn(List<Double> values) {
            addCriterion("limitscope not in", values, "limitscope");
            return (Criteria) this;
        }

        public Criteria andLimitscopeBetween(Double value1, Double value2) {
            addCriterion("limitscope between", value1, value2, "limitscope");
            return (Criteria) this;
        }

        public Criteria andLimitscopeNotBetween(Double value1, Double value2) {
            addCriterion("limitscope not between", value1, value2, "limitscope");
            return (Criteria) this;
        }

        public Criteria andUpScopeMaxIsNull() {
            addCriterion("up_scope_max is null");
            return (Criteria) this;
        }

        public Criteria andUpScopeMaxIsNotNull() {
            addCriterion("up_scope_max is not null");
            return (Criteria) this;
        }

        public Criteria andUpScopeMaxEqualTo(Double value) {
            addCriterion("up_scope_max =", value, "upScopeMax");
            return (Criteria) this;
        }

        public Criteria andUpScopeMaxNotEqualTo(Double value) {
            addCriterion("up_scope_max <>", value, "upScopeMax");
            return (Criteria) this;
        }

        public Criteria andUpScopeMaxGreaterThan(Double value) {
            addCriterion("up_scope_max >", value, "upScopeMax");
            return (Criteria) this;
        }

        public Criteria andUpScopeMaxGreaterThanOrEqualTo(Double value) {
            addCriterion("up_scope_max >=", value, "upScopeMax");
            return (Criteria) this;
        }

        public Criteria andUpScopeMaxLessThan(Double value) {
            addCriterion("up_scope_max <", value, "upScopeMax");
            return (Criteria) this;
        }

        public Criteria andUpScopeMaxLessThanOrEqualTo(Double value) {
            addCriterion("up_scope_max <=", value, "upScopeMax");
            return (Criteria) this;
        }

        public Criteria andUpScopeMaxIn(List<Double> values) {
            addCriterion("up_scope_max in", values, "upScopeMax");
            return (Criteria) this;
        }

        public Criteria andUpScopeMaxNotIn(List<Double> values) {
            addCriterion("up_scope_max not in", values, "upScopeMax");
            return (Criteria) this;
        }

        public Criteria andUpScopeMaxBetween(Double value1, Double value2) {
            addCriterion("up_scope_max between", value1, value2, "upScopeMax");
            return (Criteria) this;
        }

        public Criteria andUpScopeMaxNotBetween(Double value1, Double value2) {
            addCriterion("up_scope_max not between", value1, value2, "upScopeMax");
            return (Criteria) this;
        }

        public Criteria andDownScopeMaxIsNull() {
            addCriterion("down_scope_max is null");
            return (Criteria) this;
        }

        public Criteria andDownScopeMaxIsNotNull() {
            addCriterion("down_scope_max is not null");
            return (Criteria) this;
        }

        public Criteria andDownScopeMaxEqualTo(Double value) {
            addCriterion("down_scope_max =", value, "downScopeMax");
            return (Criteria) this;
        }

        public Criteria andDownScopeMaxNotEqualTo(Double value) {
            addCriterion("down_scope_max <>", value, "downScopeMax");
            return (Criteria) this;
        }

        public Criteria andDownScopeMaxGreaterThan(Double value) {
            addCriterion("down_scope_max >", value, "downScopeMax");
            return (Criteria) this;
        }

        public Criteria andDownScopeMaxGreaterThanOrEqualTo(Double value) {
            addCriterion("down_scope_max >=", value, "downScopeMax");
            return (Criteria) this;
        }

        public Criteria andDownScopeMaxLessThan(Double value) {
            addCriterion("down_scope_max <", value, "downScopeMax");
            return (Criteria) this;
        }

        public Criteria andDownScopeMaxLessThanOrEqualTo(Double value) {
            addCriterion("down_scope_max <=", value, "downScopeMax");
            return (Criteria) this;
        }

        public Criteria andDownScopeMaxIn(List<Double> values) {
            addCriterion("down_scope_max in", values, "downScopeMax");
            return (Criteria) this;
        }

        public Criteria andDownScopeMaxNotIn(List<Double> values) {
            addCriterion("down_scope_max not in", values, "downScopeMax");
            return (Criteria) this;
        }

        public Criteria andDownScopeMaxBetween(Double value1, Double value2) {
            addCriterion("down_scope_max between", value1, value2, "downScopeMax");
            return (Criteria) this;
        }

        public Criteria andDownScopeMaxNotBetween(Double value1, Double value2) {
            addCriterion("down_scope_max not between", value1, value2, "downScopeMax");
            return (Criteria) this;
        }

        public Criteria andTotalMaxIsNull() {
            addCriterion("total_max is null");
            return (Criteria) this;
        }

        public Criteria andTotalMaxIsNotNull() {
            addCriterion("total_max is not null");
            return (Criteria) this;
        }

        public Criteria andTotalMaxEqualTo(BigDecimal value) {
            addCriterion("total_max =", value, "totalMax");
            return (Criteria) this;
        }

        public Criteria andTotalMaxNotEqualTo(BigDecimal value) {
            addCriterion("total_max <>", value, "totalMax");
            return (Criteria) this;
        }

        public Criteria andTotalMaxGreaterThan(BigDecimal value) {
            addCriterion("total_max >", value, "totalMax");
            return (Criteria) this;
        }

        public Criteria andTotalMaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_max >=", value, "totalMax");
            return (Criteria) this;
        }

        public Criteria andTotalMaxLessThan(BigDecimal value) {
            addCriterion("total_max <", value, "totalMax");
            return (Criteria) this;
        }

        public Criteria andTotalMaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_max <=", value, "totalMax");
            return (Criteria) this;
        }

        public Criteria andTotalMaxIn(List<BigDecimal> values) {
            addCriterion("total_max in", values, "totalMax");
            return (Criteria) this;
        }

        public Criteria andTotalMaxNotIn(List<BigDecimal> values) {
            addCriterion("total_max not in", values, "totalMax");
            return (Criteria) this;
        }

        public Criteria andTotalMaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_max between", value1, value2, "totalMax");
            return (Criteria) this;
        }

        public Criteria andTotalMaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_max not between", value1, value2, "totalMax");
            return (Criteria) this;
        }

        public Criteria andDoubboIsNull() {
            addCriterion("doubbo is null");
            return (Criteria) this;
        }

        public Criteria andDoubboIsNotNull() {
            addCriterion("doubbo is not null");
            return (Criteria) this;
        }

        public Criteria andDoubboEqualTo(Integer value) {
            addCriterion("doubbo =", value, "doubbo");
            return (Criteria) this;
        }

        public Criteria andDoubboNotEqualTo(Integer value) {
            addCriterion("doubbo <>", value, "doubbo");
            return (Criteria) this;
        }

        public Criteria andDoubboGreaterThan(Integer value) {
            addCriterion("doubbo >", value, "doubbo");
            return (Criteria) this;
        }

        public Criteria andDoubboGreaterThanOrEqualTo(Integer value) {
            addCriterion("doubbo >=", value, "doubbo");
            return (Criteria) this;
        }

        public Criteria andDoubboLessThan(Integer value) {
            addCriterion("doubbo <", value, "doubbo");
            return (Criteria) this;
        }

        public Criteria andDoubboLessThanOrEqualTo(Integer value) {
            addCriterion("doubbo <=", value, "doubbo");
            return (Criteria) this;
        }

        public Criteria andDoubboIn(List<Integer> values) {
            addCriterion("doubbo in", values, "doubbo");
            return (Criteria) this;
        }

        public Criteria andDoubboNotIn(List<Integer> values) {
            addCriterion("doubbo not in", values, "doubbo");
            return (Criteria) this;
        }

        public Criteria andDoubboBetween(Integer value1, Integer value2) {
            addCriterion("doubbo between", value1, value2, "doubbo");
            return (Criteria) this;
        }

        public Criteria andDoubboNotBetween(Integer value1, Integer value2) {
            addCriterion("doubbo not between", value1, value2, "doubbo");
            return (Criteria) this;
        }

        public Criteria andLessdayIsNull() {
            addCriterion("lessday is null");
            return (Criteria) this;
        }

        public Criteria andLessdayIsNotNull() {
            addCriterion("lessday is not null");
            return (Criteria) this;
        }

        public Criteria andLessdayEqualTo(Integer value) {
            addCriterion("lessday =", value, "lessday");
            return (Criteria) this;
        }

        public Criteria andLessdayNotEqualTo(Integer value) {
            addCriterion("lessday <>", value, "lessday");
            return (Criteria) this;
        }

        public Criteria andLessdayGreaterThan(Integer value) {
            addCriterion("lessday >", value, "lessday");
            return (Criteria) this;
        }

        public Criteria andLessdayGreaterThanOrEqualTo(Integer value) {
            addCriterion("lessday >=", value, "lessday");
            return (Criteria) this;
        }

        public Criteria andLessdayLessThan(Integer value) {
            addCriterion("lessday <", value, "lessday");
            return (Criteria) this;
        }

        public Criteria andLessdayLessThanOrEqualTo(Integer value) {
            addCriterion("lessday <=", value, "lessday");
            return (Criteria) this;
        }

        public Criteria andLessdayIn(List<Integer> values) {
            addCriterion("lessday in", values, "lessday");
            return (Criteria) this;
        }

        public Criteria andLessdayNotIn(List<Integer> values) {
            addCriterion("lessday not in", values, "lessday");
            return (Criteria) this;
        }

        public Criteria andLessdayBetween(Integer value1, Integer value2) {
            addCriterion("lessday between", value1, value2, "lessday");
            return (Criteria) this;
        }

        public Criteria andLessdayNotBetween(Integer value1, Integer value2) {
            addCriterion("lessday not between", value1, value2, "lessday");
            return (Criteria) this;
        }

        public Criteria andSingleTotalMaxIsNull() {
            addCriterion("single_total_max is null");
            return (Criteria) this;
        }

        public Criteria andSingleTotalMaxIsNotNull() {
            addCriterion("single_total_max is not null");
            return (Criteria) this;
        }

        public Criteria andSingleTotalMaxEqualTo(BigDecimal value) {
            addCriterion("single_total_max =", value, "singleTotalMax");
            return (Criteria) this;
        }

        public Criteria andSingleTotalMaxNotEqualTo(BigDecimal value) {
            addCriterion("single_total_max <>", value, "singleTotalMax");
            return (Criteria) this;
        }

        public Criteria andSingleTotalMaxGreaterThan(BigDecimal value) {
            addCriterion("single_total_max >", value, "singleTotalMax");
            return (Criteria) this;
        }

        public Criteria andSingleTotalMaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("single_total_max >=", value, "singleTotalMax");
            return (Criteria) this;
        }

        public Criteria andSingleTotalMaxLessThan(BigDecimal value) {
            addCriterion("single_total_max <", value, "singleTotalMax");
            return (Criteria) this;
        }

        public Criteria andSingleTotalMaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("single_total_max <=", value, "singleTotalMax");
            return (Criteria) this;
        }

        public Criteria andSingleTotalMaxIn(List<BigDecimal> values) {
            addCriterion("single_total_max in", values, "singleTotalMax");
            return (Criteria) this;
        }

        public Criteria andSingleTotalMaxNotIn(List<BigDecimal> values) {
            addCriterion("single_total_max not in", values, "singleTotalMax");
            return (Criteria) this;
        }

        public Criteria andSingleTotalMaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("single_total_max between", value1, value2, "singleTotalMax");
            return (Criteria) this;
        }

        public Criteria andSingleTotalMaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("single_total_max not between", value1, value2, "singleTotalMax");
            return (Criteria) this;
        }

        public Criteria andDefaultPrincipalIsNull() {
            addCriterion("default_principal is null");
            return (Criteria) this;
        }

        public Criteria andDefaultPrincipalIsNotNull() {
            addCriterion("default_principal is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultPrincipalEqualTo(String value) {
            addCriterion("default_principal =", value, "defaultPrincipal");
            return (Criteria) this;
        }

        public Criteria andDefaultPrincipalNotEqualTo(String value) {
            addCriterion("default_principal <>", value, "defaultPrincipal");
            return (Criteria) this;
        }

        public Criteria andDefaultPrincipalGreaterThan(String value) {
            addCriterion("default_principal >", value, "defaultPrincipal");
            return (Criteria) this;
        }

        public Criteria andDefaultPrincipalGreaterThanOrEqualTo(String value) {
            addCriterion("default_principal >=", value, "defaultPrincipal");
            return (Criteria) this;
        }

        public Criteria andDefaultPrincipalLessThan(String value) {
            addCriterion("default_principal <", value, "defaultPrincipal");
            return (Criteria) this;
        }

        public Criteria andDefaultPrincipalLessThanOrEqualTo(String value) {
            addCriterion("default_principal <=", value, "defaultPrincipal");
            return (Criteria) this;
        }

        public Criteria andDefaultPrincipalLike(String value) {
            addCriterion("default_principal like", value, "defaultPrincipal");
            return (Criteria) this;
        }

        public Criteria andDefaultPrincipalNotLike(String value) {
            addCriterion("default_principal not like", value, "defaultPrincipal");
            return (Criteria) this;
        }

        public Criteria andDefaultPrincipalIn(List<String> values) {
            addCriterion("default_principal in", values, "defaultPrincipal");
            return (Criteria) this;
        }

        public Criteria andDefaultPrincipalNotIn(List<String> values) {
            addCriterion("default_principal not in", values, "defaultPrincipal");
            return (Criteria) this;
        }

        public Criteria andDefaultPrincipalBetween(String value1, String value2) {
            addCriterion("default_principal between", value1, value2, "defaultPrincipal");
            return (Criteria) this;
        }

        public Criteria andDefaultPrincipalNotBetween(String value1, String value2) {
            addCriterion("default_principal not between", value1, value2, "defaultPrincipal");
            return (Criteria) this;
        }

        public Criteria andMonIsNull() {
            addCriterion("mon is null");
            return (Criteria) this;
        }

        public Criteria andMonIsNotNull() {
            addCriterion("mon is not null");
            return (Criteria) this;
        }

        public Criteria andMonEqualTo(Integer value) {
            addCriterion("mon =", value, "mon");
            return (Criteria) this;
        }

        public Criteria andMonNotEqualTo(Integer value) {
            addCriterion("mon <>", value, "mon");
            return (Criteria) this;
        }

        public Criteria andMonGreaterThan(Integer value) {
            addCriterion("mon >", value, "mon");
            return (Criteria) this;
        }

        public Criteria andMonGreaterThanOrEqualTo(Integer value) {
            addCriterion("mon >=", value, "mon");
            return (Criteria) this;
        }

        public Criteria andMonLessThan(Integer value) {
            addCriterion("mon <", value, "mon");
            return (Criteria) this;
        }

        public Criteria andMonLessThanOrEqualTo(Integer value) {
            addCriterion("mon <=", value, "mon");
            return (Criteria) this;
        }

        public Criteria andMonIn(List<Integer> values) {
            addCriterion("mon in", values, "mon");
            return (Criteria) this;
        }

        public Criteria andMonNotIn(List<Integer> values) {
            addCriterion("mon not in", values, "mon");
            return (Criteria) this;
        }

        public Criteria andMonBetween(Integer value1, Integer value2) {
            addCriterion("mon between", value1, value2, "mon");
            return (Criteria) this;
        }

        public Criteria andMonNotBetween(Integer value1, Integer value2) {
            addCriterion("mon not between", value1, value2, "mon");
            return (Criteria) this;
        }

        public Criteria andTueIsNull() {
            addCriterion("tue is null");
            return (Criteria) this;
        }

        public Criteria andTueIsNotNull() {
            addCriterion("tue is not null");
            return (Criteria) this;
        }

        public Criteria andTueEqualTo(Integer value) {
            addCriterion("tue =", value, "tue");
            return (Criteria) this;
        }

        public Criteria andTueNotEqualTo(Integer value) {
            addCriterion("tue <>", value, "tue");
            return (Criteria) this;
        }

        public Criteria andTueGreaterThan(Integer value) {
            addCriterion("tue >", value, "tue");
            return (Criteria) this;
        }

        public Criteria andTueGreaterThanOrEqualTo(Integer value) {
            addCriterion("tue >=", value, "tue");
            return (Criteria) this;
        }

        public Criteria andTueLessThan(Integer value) {
            addCriterion("tue <", value, "tue");
            return (Criteria) this;
        }

        public Criteria andTueLessThanOrEqualTo(Integer value) {
            addCriterion("tue <=", value, "tue");
            return (Criteria) this;
        }

        public Criteria andTueIn(List<Integer> values) {
            addCriterion("tue in", values, "tue");
            return (Criteria) this;
        }

        public Criteria andTueNotIn(List<Integer> values) {
            addCriterion("tue not in", values, "tue");
            return (Criteria) this;
        }

        public Criteria andTueBetween(Integer value1, Integer value2) {
            addCriterion("tue between", value1, value2, "tue");
            return (Criteria) this;
        }

        public Criteria andTueNotBetween(Integer value1, Integer value2) {
            addCriterion("tue not between", value1, value2, "tue");
            return (Criteria) this;
        }

        public Criteria andWedIsNull() {
            addCriterion("wed is null");
            return (Criteria) this;
        }

        public Criteria andWedIsNotNull() {
            addCriterion("wed is not null");
            return (Criteria) this;
        }

        public Criteria andWedEqualTo(Integer value) {
            addCriterion("wed =", value, "wed");
            return (Criteria) this;
        }

        public Criteria andWedNotEqualTo(Integer value) {
            addCriterion("wed <>", value, "wed");
            return (Criteria) this;
        }

        public Criteria andWedGreaterThan(Integer value) {
            addCriterion("wed >", value, "wed");
            return (Criteria) this;
        }

        public Criteria andWedGreaterThanOrEqualTo(Integer value) {
            addCriterion("wed >=", value, "wed");
            return (Criteria) this;
        }

        public Criteria andWedLessThan(Integer value) {
            addCriterion("wed <", value, "wed");
            return (Criteria) this;
        }

        public Criteria andWedLessThanOrEqualTo(Integer value) {
            addCriterion("wed <=", value, "wed");
            return (Criteria) this;
        }

        public Criteria andWedIn(List<Integer> values) {
            addCriterion("wed in", values, "wed");
            return (Criteria) this;
        }

        public Criteria andWedNotIn(List<Integer> values) {
            addCriterion("wed not in", values, "wed");
            return (Criteria) this;
        }

        public Criteria andWedBetween(Integer value1, Integer value2) {
            addCriterion("wed between", value1, value2, "wed");
            return (Criteria) this;
        }

        public Criteria andWedNotBetween(Integer value1, Integer value2) {
            addCriterion("wed not between", value1, value2, "wed");
            return (Criteria) this;
        }

        public Criteria andThursdayIsNull() {
            addCriterion("thursday is null");
            return (Criteria) this;
        }

        public Criteria andThursdayIsNotNull() {
            addCriterion("thursday is not null");
            return (Criteria) this;
        }

        public Criteria andThursdayEqualTo(Integer value) {
            addCriterion("thursday =", value, "thursday");
            return (Criteria) this;
        }

        public Criteria andThursdayNotEqualTo(Integer value) {
            addCriterion("thursday <>", value, "thursday");
            return (Criteria) this;
        }

        public Criteria andThursdayGreaterThan(Integer value) {
            addCriterion("thursday >", value, "thursday");
            return (Criteria) this;
        }

        public Criteria andThursdayGreaterThanOrEqualTo(Integer value) {
            addCriterion("thursday >=", value, "thursday");
            return (Criteria) this;
        }

        public Criteria andThursdayLessThan(Integer value) {
            addCriterion("thursday <", value, "thursday");
            return (Criteria) this;
        }

        public Criteria andThursdayLessThanOrEqualTo(Integer value) {
            addCriterion("thursday <=", value, "thursday");
            return (Criteria) this;
        }

        public Criteria andThursdayIn(List<Integer> values) {
            addCriterion("thursday in", values, "thursday");
            return (Criteria) this;
        }

        public Criteria andThursdayNotIn(List<Integer> values) {
            addCriterion("thursday not in", values, "thursday");
            return (Criteria) this;
        }

        public Criteria andThursdayBetween(Integer value1, Integer value2) {
            addCriterion("thursday between", value1, value2, "thursday");
            return (Criteria) this;
        }

        public Criteria andThursdayNotBetween(Integer value1, Integer value2) {
            addCriterion("thursday not between", value1, value2, "thursday");
            return (Criteria) this;
        }

        public Criteria andFriIsNull() {
            addCriterion("fri is null");
            return (Criteria) this;
        }

        public Criteria andFriIsNotNull() {
            addCriterion("fri is not null");
            return (Criteria) this;
        }

        public Criteria andFriEqualTo(Integer value) {
            addCriterion("fri =", value, "fri");
            return (Criteria) this;
        }

        public Criteria andFriNotEqualTo(Integer value) {
            addCriterion("fri <>", value, "fri");
            return (Criteria) this;
        }

        public Criteria andFriGreaterThan(Integer value) {
            addCriterion("fri >", value, "fri");
            return (Criteria) this;
        }

        public Criteria andFriGreaterThanOrEqualTo(Integer value) {
            addCriterion("fri >=", value, "fri");
            return (Criteria) this;
        }

        public Criteria andFriLessThan(Integer value) {
            addCriterion("fri <", value, "fri");
            return (Criteria) this;
        }

        public Criteria andFriLessThanOrEqualTo(Integer value) {
            addCriterion("fri <=", value, "fri");
            return (Criteria) this;
        }

        public Criteria andFriIn(List<Integer> values) {
            addCriterion("fri in", values, "fri");
            return (Criteria) this;
        }

        public Criteria andFriNotIn(List<Integer> values) {
            addCriterion("fri not in", values, "fri");
            return (Criteria) this;
        }

        public Criteria andFriBetween(Integer value1, Integer value2) {
            addCriterion("fri between", value1, value2, "fri");
            return (Criteria) this;
        }

        public Criteria andFriNotBetween(Integer value1, Integer value2) {
            addCriterion("fri not between", value1, value2, "fri");
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

        public Criteria andCycleMinIsNull() {
            addCriterion("cycle_min is null");
            return (Criteria) this;
        }

        public Criteria andCycleMinIsNotNull() {
            addCriterion("cycle_min is not null");
            return (Criteria) this;
        }

        public Criteria andCycleMinEqualTo(String value) {
            addCriterion("cycle_min =", value, "cycleMin");
            return (Criteria) this;
        }

        public Criteria andCycleMinNotEqualTo(String value) {
            addCriterion("cycle_min <>", value, "cycleMin");
            return (Criteria) this;
        }

        public Criteria andCycleMinGreaterThan(String value) {
            addCriterion("cycle_min >", value, "cycleMin");
            return (Criteria) this;
        }

        public Criteria andCycleMinGreaterThanOrEqualTo(String value) {
            addCriterion("cycle_min >=", value, "cycleMin");
            return (Criteria) this;
        }

        public Criteria andCycleMinLessThan(String value) {
            addCriterion("cycle_min <", value, "cycleMin");
            return (Criteria) this;
        }

        public Criteria andCycleMinLessThanOrEqualTo(String value) {
            addCriterion("cycle_min <=", value, "cycleMin");
            return (Criteria) this;
        }

        public Criteria andCycleMinLike(String value) {
            addCriterion("cycle_min like", value, "cycleMin");
            return (Criteria) this;
        }

        public Criteria andCycleMinNotLike(String value) {
            addCriterion("cycle_min not like", value, "cycleMin");
            return (Criteria) this;
        }

        public Criteria andCycleMinIn(List<String> values) {
            addCriterion("cycle_min in", values, "cycleMin");
            return (Criteria) this;
        }

        public Criteria andCycleMinNotIn(List<String> values) {
            addCriterion("cycle_min not in", values, "cycleMin");
            return (Criteria) this;
        }

        public Criteria andCycleMinBetween(String value1, String value2) {
            addCriterion("cycle_min between", value1, value2, "cycleMin");
            return (Criteria) this;
        }

        public Criteria andCycleMinNotBetween(String value1, String value2) {
            addCriterion("cycle_min not between", value1, value2, "cycleMin");
            return (Criteria) this;
        }

        public Criteria andCycleMinTypeIsNull() {
            addCriterion("cycle_min_type is null");
            return (Criteria) this;
        }

        public Criteria andCycleMinTypeIsNotNull() {
            addCriterion("cycle_min_type is not null");
            return (Criteria) this;
        }

        public Criteria andCycleMinTypeEqualTo(String value) {
            addCriterion("cycle_min_type =", value, "cycleMinType");
            return (Criteria) this;
        }

        public Criteria andCycleMinTypeNotEqualTo(String value) {
            addCriterion("cycle_min_type <>", value, "cycleMinType");
            return (Criteria) this;
        }

        public Criteria andCycleMinTypeGreaterThan(String value) {
            addCriterion("cycle_min_type >", value, "cycleMinType");
            return (Criteria) this;
        }

        public Criteria andCycleMinTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cycle_min_type >=", value, "cycleMinType");
            return (Criteria) this;
        }

        public Criteria andCycleMinTypeLessThan(String value) {
            addCriterion("cycle_min_type <", value, "cycleMinType");
            return (Criteria) this;
        }

        public Criteria andCycleMinTypeLessThanOrEqualTo(String value) {
            addCriterion("cycle_min_type <=", value, "cycleMinType");
            return (Criteria) this;
        }

        public Criteria andCycleMinTypeLike(String value) {
            addCriterion("cycle_min_type like", value, "cycleMinType");
            return (Criteria) this;
        }

        public Criteria andCycleMinTypeNotLike(String value) {
            addCriterion("cycle_min_type not like", value, "cycleMinType");
            return (Criteria) this;
        }

        public Criteria andCycleMinTypeIn(List<String> values) {
            addCriterion("cycle_min_type in", values, "cycleMinType");
            return (Criteria) this;
        }

        public Criteria andCycleMinTypeNotIn(List<String> values) {
            addCriterion("cycle_min_type not in", values, "cycleMinType");
            return (Criteria) this;
        }

        public Criteria andCycleMinTypeBetween(String value1, String value2) {
            addCriterion("cycle_min_type between", value1, value2, "cycleMinType");
            return (Criteria) this;
        }

        public Criteria andCycleMinTypeNotBetween(String value1, String value2) {
            addCriterion("cycle_min_type not between", value1, value2, "cycleMinType");
            return (Criteria) this;
        }

        public Criteria andCycleMaxIsNull() {
            addCriterion("cycle_max is null");
            return (Criteria) this;
        }

        public Criteria andCycleMaxIsNotNull() {
            addCriterion("cycle_max is not null");
            return (Criteria) this;
        }

        public Criteria andCycleMaxEqualTo(String value) {
            addCriterion("cycle_max =", value, "cycleMax");
            return (Criteria) this;
        }

        public Criteria andCycleMaxNotEqualTo(String value) {
            addCriterion("cycle_max <>", value, "cycleMax");
            return (Criteria) this;
        }

        public Criteria andCycleMaxGreaterThan(String value) {
            addCriterion("cycle_max >", value, "cycleMax");
            return (Criteria) this;
        }

        public Criteria andCycleMaxGreaterThanOrEqualTo(String value) {
            addCriterion("cycle_max >=", value, "cycleMax");
            return (Criteria) this;
        }

        public Criteria andCycleMaxLessThan(String value) {
            addCriterion("cycle_max <", value, "cycleMax");
            return (Criteria) this;
        }

        public Criteria andCycleMaxLessThanOrEqualTo(String value) {
            addCriterion("cycle_max <=", value, "cycleMax");
            return (Criteria) this;
        }

        public Criteria andCycleMaxLike(String value) {
            addCriterion("cycle_max like", value, "cycleMax");
            return (Criteria) this;
        }

        public Criteria andCycleMaxNotLike(String value) {
            addCriterion("cycle_max not like", value, "cycleMax");
            return (Criteria) this;
        }

        public Criteria andCycleMaxIn(List<String> values) {
            addCriterion("cycle_max in", values, "cycleMax");
            return (Criteria) this;
        }

        public Criteria andCycleMaxNotIn(List<String> values) {
            addCriterion("cycle_max not in", values, "cycleMax");
            return (Criteria) this;
        }

        public Criteria andCycleMaxBetween(String value1, String value2) {
            addCriterion("cycle_max between", value1, value2, "cycleMax");
            return (Criteria) this;
        }

        public Criteria andCycleMaxNotBetween(String value1, String value2) {
            addCriterion("cycle_max not between", value1, value2, "cycleMax");
            return (Criteria) this;
        }

        public Criteria andCycleMaxTypeIsNull() {
            addCriterion("cycle_max_type is null");
            return (Criteria) this;
        }

        public Criteria andCycleMaxTypeIsNotNull() {
            addCriterion("cycle_max_type is not null");
            return (Criteria) this;
        }

        public Criteria andCycleMaxTypeEqualTo(String value) {
            addCriterion("cycle_max_type =", value, "cycleMaxType");
            return (Criteria) this;
        }

        public Criteria andCycleMaxTypeNotEqualTo(String value) {
            addCriterion("cycle_max_type <>", value, "cycleMaxType");
            return (Criteria) this;
        }

        public Criteria andCycleMaxTypeGreaterThan(String value) {
            addCriterion("cycle_max_type >", value, "cycleMaxType");
            return (Criteria) this;
        }

        public Criteria andCycleMaxTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cycle_max_type >=", value, "cycleMaxType");
            return (Criteria) this;
        }

        public Criteria andCycleMaxTypeLessThan(String value) {
            addCriterion("cycle_max_type <", value, "cycleMaxType");
            return (Criteria) this;
        }

        public Criteria andCycleMaxTypeLessThanOrEqualTo(String value) {
            addCriterion("cycle_max_type <=", value, "cycleMaxType");
            return (Criteria) this;
        }

        public Criteria andCycleMaxTypeLike(String value) {
            addCriterion("cycle_max_type like", value, "cycleMaxType");
            return (Criteria) this;
        }

        public Criteria andCycleMaxTypeNotLike(String value) {
            addCriterion("cycle_max_type not like", value, "cycleMaxType");
            return (Criteria) this;
        }

        public Criteria andCycleMaxTypeIn(List<String> values) {
            addCriterion("cycle_max_type in", values, "cycleMaxType");
            return (Criteria) this;
        }

        public Criteria andCycleMaxTypeNotIn(List<String> values) {
            addCriterion("cycle_max_type not in", values, "cycleMaxType");
            return (Criteria) this;
        }

        public Criteria andCycleMaxTypeBetween(String value1, String value2) {
            addCriterion("cycle_max_type between", value1, value2, "cycleMaxType");
            return (Criteria) this;
        }

        public Criteria andCycleMaxTypeNotBetween(String value1, String value2) {
            addCriterion("cycle_max_type not between", value1, value2, "cycleMaxType");
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