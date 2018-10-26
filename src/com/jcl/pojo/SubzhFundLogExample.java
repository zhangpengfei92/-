package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubzhFundLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubzhFundLogExample() {
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andBzEqualTo(Byte value) {
            addCriterion("bz =", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotEqualTo(Byte value) {
            addCriterion("bz <>", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThan(Byte value) {
            addCriterion("bz >", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThanOrEqualTo(Byte value) {
            addCriterion("bz >=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThan(Byte value) {
            addCriterion("bz <", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThanOrEqualTo(Byte value) {
            addCriterion("bz <=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzIn(List<Byte> values) {
            addCriterion("bz in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotIn(List<Byte> values) {
            addCriterion("bz not in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzBetween(Byte value1, Byte value2) {
            addCriterion("bz between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotBetween(Byte value1, Byte value2) {
            addCriterion("bz not between", value1, value2, "bz");
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

        public Criteria andAfterfundIsNull() {
            addCriterion("afterfund is null");
            return (Criteria) this;
        }

        public Criteria andAfterfundIsNotNull() {
            addCriterion("afterfund is not null");
            return (Criteria) this;
        }

        public Criteria andAfterfundEqualTo(BigDecimal value) {
            addCriterion("afterfund =", value, "afterfund");
            return (Criteria) this;
        }

        public Criteria andAfterfundNotEqualTo(BigDecimal value) {
            addCriterion("afterfund <>", value, "afterfund");
            return (Criteria) this;
        }

        public Criteria andAfterfundGreaterThan(BigDecimal value) {
            addCriterion("afterfund >", value, "afterfund");
            return (Criteria) this;
        }

        public Criteria andAfterfundGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("afterfund >=", value, "afterfund");
            return (Criteria) this;
        }

        public Criteria andAfterfundLessThan(BigDecimal value) {
            addCriterion("afterfund <", value, "afterfund");
            return (Criteria) this;
        }

        public Criteria andAfterfundLessThanOrEqualTo(BigDecimal value) {
            addCriterion("afterfund <=", value, "afterfund");
            return (Criteria) this;
        }

        public Criteria andAfterfundIn(List<BigDecimal> values) {
            addCriterion("afterfund in", values, "afterfund");
            return (Criteria) this;
        }

        public Criteria andAfterfundNotIn(List<BigDecimal> values) {
            addCriterion("afterfund not in", values, "afterfund");
            return (Criteria) this;
        }

        public Criteria andAfterfundBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("afterfund between", value1, value2, "afterfund");
            return (Criteria) this;
        }

        public Criteria andAfterfundNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("afterfund not between", value1, value2, "afterfund");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Long value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Long value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Long value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Long value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Long value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Long> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Long> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Long value1, Long value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Long value1, Long value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andAgentzhIsNull() {
            addCriterion("agentzh is null");
            return (Criteria) this;
        }

        public Criteria andAgentzhIsNotNull() {
            addCriterion("agentzh is not null");
            return (Criteria) this;
        }

        public Criteria andAgentzhEqualTo(String value) {
            addCriterion("agentzh =", value, "agentzh");
            return (Criteria) this;
        }

        public Criteria andAgentzhNotEqualTo(String value) {
            addCriterion("agentzh <>", value, "agentzh");
            return (Criteria) this;
        }

        public Criteria andAgentzhGreaterThan(String value) {
            addCriterion("agentzh >", value, "agentzh");
            return (Criteria) this;
        }

        public Criteria andAgentzhGreaterThanOrEqualTo(String value) {
            addCriterion("agentzh >=", value, "agentzh");
            return (Criteria) this;
        }

        public Criteria andAgentzhLessThan(String value) {
            addCriterion("agentzh <", value, "agentzh");
            return (Criteria) this;
        }

        public Criteria andAgentzhLessThanOrEqualTo(String value) {
            addCriterion("agentzh <=", value, "agentzh");
            return (Criteria) this;
        }

        public Criteria andAgentzhLike(String value) {
            addCriterion("agentzh like", value, "agentzh");
            return (Criteria) this;
        }

        public Criteria andAgentzhNotLike(String value) {
            addCriterion("agentzh not like", value, "agentzh");
            return (Criteria) this;
        }

        public Criteria andAgentzhIn(List<String> values) {
            addCriterion("agentzh in", values, "agentzh");
            return (Criteria) this;
        }

        public Criteria andAgentzhNotIn(List<String> values) {
            addCriterion("agentzh not in", values, "agentzh");
            return (Criteria) this;
        }

        public Criteria andAgentzhBetween(String value1, String value2) {
            addCriterion("agentzh between", value1, value2, "agentzh");
            return (Criteria) this;
        }

        public Criteria andAgentzhNotBetween(String value1, String value2) {
            addCriterion("agentzh not between", value1, value2, "agentzh");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andBankaccnameIsNull() {
            addCriterion("bankaccname is null");
            return (Criteria) this;
        }

        public Criteria andBankaccnameIsNotNull() {
            addCriterion("bankaccname is not null");
            return (Criteria) this;
        }

        public Criteria andBankaccnameEqualTo(String value) {
            addCriterion("bankaccname =", value, "bankaccname");
            return (Criteria) this;
        }

        public Criteria andBankaccnameNotEqualTo(String value) {
            addCriterion("bankaccname <>", value, "bankaccname");
            return (Criteria) this;
        }

        public Criteria andBankaccnameGreaterThan(String value) {
            addCriterion("bankaccname >", value, "bankaccname");
            return (Criteria) this;
        }

        public Criteria andBankaccnameGreaterThanOrEqualTo(String value) {
            addCriterion("bankaccname >=", value, "bankaccname");
            return (Criteria) this;
        }

        public Criteria andBankaccnameLessThan(String value) {
            addCriterion("bankaccname <", value, "bankaccname");
            return (Criteria) this;
        }

        public Criteria andBankaccnameLessThanOrEqualTo(String value) {
            addCriterion("bankaccname <=", value, "bankaccname");
            return (Criteria) this;
        }

        public Criteria andBankaccnameLike(String value) {
            addCriterion("bankaccname like", value, "bankaccname");
            return (Criteria) this;
        }

        public Criteria andBankaccnameNotLike(String value) {
            addCriterion("bankaccname not like", value, "bankaccname");
            return (Criteria) this;
        }

        public Criteria andBankaccnameIn(List<String> values) {
            addCriterion("bankaccname in", values, "bankaccname");
            return (Criteria) this;
        }

        public Criteria andBankaccnameNotIn(List<String> values) {
            addCriterion("bankaccname not in", values, "bankaccname");
            return (Criteria) this;
        }

        public Criteria andBankaccnameBetween(String value1, String value2) {
            addCriterion("bankaccname between", value1, value2, "bankaccname");
            return (Criteria) this;
        }

        public Criteria andBankaccnameNotBetween(String value1, String value2) {
            addCriterion("bankaccname not between", value1, value2, "bankaccname");
            return (Criteria) this;
        }

        public Criteria andBankcardnumIsNull() {
            addCriterion("bankcardNum is null");
            return (Criteria) this;
        }

        public Criteria andBankcardnumIsNotNull() {
            addCriterion("bankcardNum is not null");
            return (Criteria) this;
        }

        public Criteria andBankcardnumEqualTo(String value) {
            addCriterion("bankcardNum =", value, "bankcardnum");
            return (Criteria) this;
        }

        public Criteria andBankcardnumNotEqualTo(String value) {
            addCriterion("bankcardNum <>", value, "bankcardnum");
            return (Criteria) this;
        }

        public Criteria andBankcardnumGreaterThan(String value) {
            addCriterion("bankcardNum >", value, "bankcardnum");
            return (Criteria) this;
        }

        public Criteria andBankcardnumGreaterThanOrEqualTo(String value) {
            addCriterion("bankcardNum >=", value, "bankcardnum");
            return (Criteria) this;
        }

        public Criteria andBankcardnumLessThan(String value) {
            addCriterion("bankcardNum <", value, "bankcardnum");
            return (Criteria) this;
        }

        public Criteria andBankcardnumLessThanOrEqualTo(String value) {
            addCriterion("bankcardNum <=", value, "bankcardnum");
            return (Criteria) this;
        }

        public Criteria andBankcardnumLike(String value) {
            addCriterion("bankcardNum like", value, "bankcardnum");
            return (Criteria) this;
        }

        public Criteria andBankcardnumNotLike(String value) {
            addCriterion("bankcardNum not like", value, "bankcardnum");
            return (Criteria) this;
        }

        public Criteria andBankcardnumIn(List<String> values) {
            addCriterion("bankcardNum in", values, "bankcardnum");
            return (Criteria) this;
        }

        public Criteria andBankcardnumNotIn(List<String> values) {
            addCriterion("bankcardNum not in", values, "bankcardnum");
            return (Criteria) this;
        }

        public Criteria andBankcardnumBetween(String value1, String value2) {
            addCriterion("bankcardNum between", value1, value2, "bankcardnum");
            return (Criteria) this;
        }

        public Criteria andBankcardnumNotBetween(String value1, String value2) {
            addCriterion("bankcardNum not between", value1, value2, "bankcardnum");
            return (Criteria) this;
        }

        public Criteria andOpenbanknameIsNull() {
            addCriterion("openbankname is null");
            return (Criteria) this;
        }

        public Criteria andOpenbanknameIsNotNull() {
            addCriterion("openbankname is not null");
            return (Criteria) this;
        }

        public Criteria andOpenbanknameEqualTo(String value) {
            addCriterion("openbankname =", value, "openbankname");
            return (Criteria) this;
        }

        public Criteria andOpenbanknameNotEqualTo(String value) {
            addCriterion("openbankname <>", value, "openbankname");
            return (Criteria) this;
        }

        public Criteria andOpenbanknameGreaterThan(String value) {
            addCriterion("openbankname >", value, "openbankname");
            return (Criteria) this;
        }

        public Criteria andOpenbanknameGreaterThanOrEqualTo(String value) {
            addCriterion("openbankname >=", value, "openbankname");
            return (Criteria) this;
        }

        public Criteria andOpenbanknameLessThan(String value) {
            addCriterion("openbankname <", value, "openbankname");
            return (Criteria) this;
        }

        public Criteria andOpenbanknameLessThanOrEqualTo(String value) {
            addCriterion("openbankname <=", value, "openbankname");
            return (Criteria) this;
        }

        public Criteria andOpenbanknameLike(String value) {
            addCriterion("openbankname like", value, "openbankname");
            return (Criteria) this;
        }

        public Criteria andOpenbanknameNotLike(String value) {
            addCriterion("openbankname not like", value, "openbankname");
            return (Criteria) this;
        }

        public Criteria andOpenbanknameIn(List<String> values) {
            addCriterion("openbankname in", values, "openbankname");
            return (Criteria) this;
        }

        public Criteria andOpenbanknameNotIn(List<String> values) {
            addCriterion("openbankname not in", values, "openbankname");
            return (Criteria) this;
        }

        public Criteria andOpenbanknameBetween(String value1, String value2) {
            addCriterion("openbankname between", value1, value2, "openbankname");
            return (Criteria) this;
        }

        public Criteria andOpenbanknameNotBetween(String value1, String value2) {
            addCriterion("openbankname not between", value1, value2, "openbankname");
            return (Criteria) this;
        }

        public Criteria andBankflownumIsNull() {
            addCriterion("bankflownum is null");
            return (Criteria) this;
        }

        public Criteria andBankflownumIsNotNull() {
            addCriterion("bankflownum is not null");
            return (Criteria) this;
        }

        public Criteria andBankflownumEqualTo(String value) {
            addCriterion("bankflownum =", value, "bankflownum");
            return (Criteria) this;
        }

        public Criteria andBankflownumNotEqualTo(String value) {
            addCriterion("bankflownum <>", value, "bankflownum");
            return (Criteria) this;
        }

        public Criteria andBankflownumGreaterThan(String value) {
            addCriterion("bankflownum >", value, "bankflownum");
            return (Criteria) this;
        }

        public Criteria andBankflownumGreaterThanOrEqualTo(String value) {
            addCriterion("bankflownum >=", value, "bankflownum");
            return (Criteria) this;
        }

        public Criteria andBankflownumLessThan(String value) {
            addCriterion("bankflownum <", value, "bankflownum");
            return (Criteria) this;
        }

        public Criteria andBankflownumLessThanOrEqualTo(String value) {
            addCriterion("bankflownum <=", value, "bankflownum");
            return (Criteria) this;
        }

        public Criteria andBankflownumLike(String value) {
            addCriterion("bankflownum like", value, "bankflownum");
            return (Criteria) this;
        }

        public Criteria andBankflownumNotLike(String value) {
            addCriterion("bankflownum not like", value, "bankflownum");
            return (Criteria) this;
        }

        public Criteria andBankflownumIn(List<String> values) {
            addCriterion("bankflownum in", values, "bankflownum");
            return (Criteria) this;
        }

        public Criteria andBankflownumNotIn(List<String> values) {
            addCriterion("bankflownum not in", values, "bankflownum");
            return (Criteria) this;
        }

        public Criteria andBankflownumBetween(String value1, String value2) {
            addCriterion("bankflownum between", value1, value2, "bankflownum");
            return (Criteria) this;
        }

        public Criteria andBankflownumNotBetween(String value1, String value2) {
            addCriterion("bankflownum not between", value1, value2, "bankflownum");
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