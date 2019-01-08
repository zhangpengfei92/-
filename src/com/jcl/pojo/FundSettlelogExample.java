package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FundSettlelogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FundSettlelogExample() {
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

        public Criteria andAllocbrokerIsNull() {
            addCriterion("allocbroker is null");
            return (Criteria) this;
        }

        public Criteria andAllocbrokerIsNotNull() {
            addCriterion("allocbroker is not null");
            return (Criteria) this;
        }

        public Criteria andAllocbrokerEqualTo(String value) {
            addCriterion("allocbroker =", value, "allocbroker");
            return (Criteria) this;
        }

        public Criteria andAllocbrokerNotEqualTo(String value) {
            addCriterion("allocbroker <>", value, "allocbroker");
            return (Criteria) this;
        }

        public Criteria andAllocbrokerGreaterThan(String value) {
            addCriterion("allocbroker >", value, "allocbroker");
            return (Criteria) this;
        }

        public Criteria andAllocbrokerGreaterThanOrEqualTo(String value) {
            addCriterion("allocbroker >=", value, "allocbroker");
            return (Criteria) this;
        }

        public Criteria andAllocbrokerLessThan(String value) {
            addCriterion("allocbroker <", value, "allocbroker");
            return (Criteria) this;
        }

        public Criteria andAllocbrokerLessThanOrEqualTo(String value) {
            addCriterion("allocbroker <=", value, "allocbroker");
            return (Criteria) this;
        }

        public Criteria andAllocbrokerLike(String value) {
            addCriterion("allocbroker like", value, "allocbroker");
            return (Criteria) this;
        }

        public Criteria andAllocbrokerNotLike(String value) {
            addCriterion("allocbroker not like", value, "allocbroker");
            return (Criteria) this;
        }

        public Criteria andAllocbrokerIn(List<String> values) {
            addCriterion("allocbroker in", values, "allocbroker");
            return (Criteria) this;
        }

        public Criteria andAllocbrokerNotIn(List<String> values) {
            addCriterion("allocbroker not in", values, "allocbroker");
            return (Criteria) this;
        }

        public Criteria andAllocbrokerBetween(String value1, String value2) {
            addCriterion("allocbroker between", value1, value2, "allocbroker");
            return (Criteria) this;
        }

        public Criteria andAllocbrokerNotBetween(String value1, String value2) {
            addCriterion("allocbroker not between", value1, value2, "allocbroker");
            return (Criteria) this;
        }

        public Criteria andAllocchannelIsNull() {
            addCriterion("allocchannel is null");
            return (Criteria) this;
        }

        public Criteria andAllocchannelIsNotNull() {
            addCriterion("allocchannel is not null");
            return (Criteria) this;
        }

        public Criteria andAllocchannelEqualTo(String value) {
            addCriterion("allocchannel =", value, "allocchannel");
            return (Criteria) this;
        }

        public Criteria andAllocchannelNotEqualTo(String value) {
            addCriterion("allocchannel <>", value, "allocchannel");
            return (Criteria) this;
        }

        public Criteria andAllocchannelGreaterThan(String value) {
            addCriterion("allocchannel >", value, "allocchannel");
            return (Criteria) this;
        }

        public Criteria andAllocchannelGreaterThanOrEqualTo(String value) {
            addCriterion("allocchannel >=", value, "allocchannel");
            return (Criteria) this;
        }

        public Criteria andAllocchannelLessThan(String value) {
            addCriterion("allocchannel <", value, "allocchannel");
            return (Criteria) this;
        }

        public Criteria andAllocchannelLessThanOrEqualTo(String value) {
            addCriterion("allocchannel <=", value, "allocchannel");
            return (Criteria) this;
        }

        public Criteria andAllocchannelLike(String value) {
            addCriterion("allocchannel like", value, "allocchannel");
            return (Criteria) this;
        }

        public Criteria andAllocchannelNotLike(String value) {
            addCriterion("allocchannel not like", value, "allocchannel");
            return (Criteria) this;
        }

        public Criteria andAllocchannelIn(List<String> values) {
            addCriterion("allocchannel in", values, "allocchannel");
            return (Criteria) this;
        }

        public Criteria andAllocchannelNotIn(List<String> values) {
            addCriterion("allocchannel not in", values, "allocchannel");
            return (Criteria) this;
        }

        public Criteria andAllocchannelBetween(String value1, String value2) {
            addCriterion("allocchannel between", value1, value2, "allocchannel");
            return (Criteria) this;
        }

        public Criteria andAllocchannelNotBetween(String value1, String value2) {
            addCriterion("allocchannel not between", value1, value2, "allocchannel");
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

        public Criteria andRegistnumIsNull() {
            addCriterion("registnum is null");
            return (Criteria) this;
        }

        public Criteria andRegistnumIsNotNull() {
            addCriterion("registnum is not null");
            return (Criteria) this;
        }

        public Criteria andRegistnumEqualTo(Integer value) {
            addCriterion("registnum =", value, "registnum");
            return (Criteria) this;
        }

        public Criteria andRegistnumNotEqualTo(Integer value) {
            addCriterion("registnum <>", value, "registnum");
            return (Criteria) this;
        }

        public Criteria andRegistnumGreaterThan(Integer value) {
            addCriterion("registnum >", value, "registnum");
            return (Criteria) this;
        }

        public Criteria andRegistnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("registnum >=", value, "registnum");
            return (Criteria) this;
        }

        public Criteria andRegistnumLessThan(Integer value) {
            addCriterion("registnum <", value, "registnum");
            return (Criteria) this;
        }

        public Criteria andRegistnumLessThanOrEqualTo(Integer value) {
            addCriterion("registnum <=", value, "registnum");
            return (Criteria) this;
        }

        public Criteria andRegistnumIn(List<Integer> values) {
            addCriterion("registnum in", values, "registnum");
            return (Criteria) this;
        }

        public Criteria andRegistnumNotIn(List<Integer> values) {
            addCriterion("registnum not in", values, "registnum");
            return (Criteria) this;
        }

        public Criteria andRegistnumBetween(Integer value1, Integer value2) {
            addCriterion("registnum between", value1, value2, "registnum");
            return (Criteria) this;
        }

        public Criteria andRegistnumNotBetween(Integer value1, Integer value2) {
            addCriterion("registnum not between", value1, value2, "registnum");
            return (Criteria) this;
        }

        public Criteria andAddfundIsNull() {
            addCriterion("addfund is null");
            return (Criteria) this;
        }

        public Criteria andAddfundIsNotNull() {
            addCriterion("addfund is not null");
            return (Criteria) this;
        }

        public Criteria andAddfundEqualTo(Integer value) {
            addCriterion("addfund =", value, "addfund");
            return (Criteria) this;
        }

        public Criteria andAddfundNotEqualTo(Integer value) {
            addCriterion("addfund <>", value, "addfund");
            return (Criteria) this;
        }

        public Criteria andAddfundGreaterThan(Integer value) {
            addCriterion("addfund >", value, "addfund");
            return (Criteria) this;
        }

        public Criteria andAddfundGreaterThanOrEqualTo(Integer value) {
            addCriterion("addfund >=", value, "addfund");
            return (Criteria) this;
        }

        public Criteria andAddfundLessThan(Integer value) {
            addCriterion("addfund <", value, "addfund");
            return (Criteria) this;
        }

        public Criteria andAddfundLessThanOrEqualTo(Integer value) {
            addCriterion("addfund <=", value, "addfund");
            return (Criteria) this;
        }

        public Criteria andAddfundIn(List<Integer> values) {
            addCriterion("addfund in", values, "addfund");
            return (Criteria) this;
        }

        public Criteria andAddfundNotIn(List<Integer> values) {
            addCriterion("addfund not in", values, "addfund");
            return (Criteria) this;
        }

        public Criteria andAddfundBetween(Integer value1, Integer value2) {
            addCriterion("addfund between", value1, value2, "addfund");
            return (Criteria) this;
        }

        public Criteria andAddfundNotBetween(Integer value1, Integer value2) {
            addCriterion("addfund not between", value1, value2, "addfund");
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

        public Criteria andStockfundIsNull() {
            addCriterion("stockfund is null");
            return (Criteria) this;
        }

        public Criteria andStockfundIsNotNull() {
            addCriterion("stockfund is not null");
            return (Criteria) this;
        }

        public Criteria andStockfundEqualTo(Integer value) {
            addCriterion("stockfund =", value, "stockfund");
            return (Criteria) this;
        }

        public Criteria andStockfundNotEqualTo(Integer value) {
            addCriterion("stockfund <>", value, "stockfund");
            return (Criteria) this;
        }

        public Criteria andStockfundGreaterThan(Integer value) {
            addCriterion("stockfund >", value, "stockfund");
            return (Criteria) this;
        }

        public Criteria andStockfundGreaterThanOrEqualTo(Integer value) {
            addCriterion("stockfund >=", value, "stockfund");
            return (Criteria) this;
        }

        public Criteria andStockfundLessThan(Integer value) {
            addCriterion("stockfund <", value, "stockfund");
            return (Criteria) this;
        }

        public Criteria andStockfundLessThanOrEqualTo(Integer value) {
            addCriterion("stockfund <=", value, "stockfund");
            return (Criteria) this;
        }

        public Criteria andStockfundIn(List<Integer> values) {
            addCriterion("stockfund in", values, "stockfund");
            return (Criteria) this;
        }

        public Criteria andStockfundNotIn(List<Integer> values) {
            addCriterion("stockfund not in", values, "stockfund");
            return (Criteria) this;
        }

        public Criteria andStockfundBetween(Integer value1, Integer value2) {
            addCriterion("stockfund between", value1, value2, "stockfund");
            return (Criteria) this;
        }

        public Criteria andStockfundNotBetween(Integer value1, Integer value2) {
            addCriterion("stockfund not between", value1, value2, "stockfund");
            return (Criteria) this;
        }

        public Criteria andStockbalanceIsNull() {
            addCriterion("stockBalance is null");
            return (Criteria) this;
        }

        public Criteria andStockbalanceIsNotNull() {
            addCriterion("stockBalance is not null");
            return (Criteria) this;
        }

        public Criteria andStockbalanceEqualTo(BigDecimal value) {
            addCriterion("stockBalance =", value, "stockbalance");
            return (Criteria) this;
        }

        public Criteria andStockbalanceNotEqualTo(BigDecimal value) {
            addCriterion("stockBalance <>", value, "stockbalance");
            return (Criteria) this;
        }

        public Criteria andStockbalanceGreaterThan(BigDecimal value) {
            addCriterion("stockBalance >", value, "stockbalance");
            return (Criteria) this;
        }

        public Criteria andStockbalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("stockBalance >=", value, "stockbalance");
            return (Criteria) this;
        }

        public Criteria andStockbalanceLessThan(BigDecimal value) {
            addCriterion("stockBalance <", value, "stockbalance");
            return (Criteria) this;
        }

        public Criteria andStockbalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("stockBalance <=", value, "stockbalance");
            return (Criteria) this;
        }

        public Criteria andStockbalanceIn(List<BigDecimal> values) {
            addCriterion("stockBalance in", values, "stockbalance");
            return (Criteria) this;
        }

        public Criteria andStockbalanceNotIn(List<BigDecimal> values) {
            addCriterion("stockBalance not in", values, "stockbalance");
            return (Criteria) this;
        }

        public Criteria andStockbalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stockBalance between", value1, value2, "stockbalance");
            return (Criteria) this;
        }

        public Criteria andStockbalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stockBalance not between", value1, value2, "stockbalance");
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

        public Criteria andDeferredbalanceIsNull() {
            addCriterion("deferredBalance is null");
            return (Criteria) this;
        }

        public Criteria andDeferredbalanceIsNotNull() {
            addCriterion("deferredBalance is not null");
            return (Criteria) this;
        }

        public Criteria andDeferredbalanceEqualTo(BigDecimal value) {
            addCriterion("deferredBalance =", value, "deferredbalance");
            return (Criteria) this;
        }

        public Criteria andDeferredbalanceNotEqualTo(BigDecimal value) {
            addCriterion("deferredBalance <>", value, "deferredbalance");
            return (Criteria) this;
        }

        public Criteria andDeferredbalanceGreaterThan(BigDecimal value) {
            addCriterion("deferredBalance >", value, "deferredbalance");
            return (Criteria) this;
        }

        public Criteria andDeferredbalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deferredBalance >=", value, "deferredbalance");
            return (Criteria) this;
        }

        public Criteria andDeferredbalanceLessThan(BigDecimal value) {
            addCriterion("deferredBalance <", value, "deferredbalance");
            return (Criteria) this;
        }

        public Criteria andDeferredbalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deferredBalance <=", value, "deferredbalance");
            return (Criteria) this;
        }

        public Criteria andDeferredbalanceIn(List<BigDecimal> values) {
            addCriterion("deferredBalance in", values, "deferredbalance");
            return (Criteria) this;
        }

        public Criteria andDeferredbalanceNotIn(List<BigDecimal> values) {
            addCriterion("deferredBalance not in", values, "deferredbalance");
            return (Criteria) this;
        }

        public Criteria andDeferredbalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deferredBalance between", value1, value2, "deferredbalance");
            return (Criteria) this;
        }

        public Criteria andDeferredbalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deferredBalance not between", value1, value2, "deferredbalance");
            return (Criteria) this;
        }

        public Criteria andFeenextbalanceIsNull() {
            addCriterion("feenextBalance is null");
            return (Criteria) this;
        }

        public Criteria andFeenextbalanceIsNotNull() {
            addCriterion("feenextBalance is not null");
            return (Criteria) this;
        }

        public Criteria andFeenextbalanceEqualTo(BigDecimal value) {
            addCriterion("feenextBalance =", value, "feenextbalance");
            return (Criteria) this;
        }

        public Criteria andFeenextbalanceNotEqualTo(BigDecimal value) {
            addCriterion("feenextBalance <>", value, "feenextbalance");
            return (Criteria) this;
        }

        public Criteria andFeenextbalanceGreaterThan(BigDecimal value) {
            addCriterion("feenextBalance >", value, "feenextbalance");
            return (Criteria) this;
        }

        public Criteria andFeenextbalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("feenextBalance >=", value, "feenextbalance");
            return (Criteria) this;
        }

        public Criteria andFeenextbalanceLessThan(BigDecimal value) {
            addCriterion("feenextBalance <", value, "feenextbalance");
            return (Criteria) this;
        }

        public Criteria andFeenextbalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("feenextBalance <=", value, "feenextbalance");
            return (Criteria) this;
        }

        public Criteria andFeenextbalanceIn(List<BigDecimal> values) {
            addCriterion("feenextBalance in", values, "feenextbalance");
            return (Criteria) this;
        }

        public Criteria andFeenextbalanceNotIn(List<BigDecimal> values) {
            addCriterion("feenextBalance not in", values, "feenextbalance");
            return (Criteria) this;
        }

        public Criteria andFeenextbalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("feenextBalance between", value1, value2, "feenextbalance");
            return (Criteria) this;
        }

        public Criteria andFeenextbalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("feenextBalance not between", value1, value2, "feenextbalance");
            return (Criteria) this;
        }

        public Criteria andOverbalanceIsNull() {
            addCriterion("overBalance is null");
            return (Criteria) this;
        }

        public Criteria andOverbalanceIsNotNull() {
            addCriterion("overBalance is not null");
            return (Criteria) this;
        }

        public Criteria andOverbalanceEqualTo(BigDecimal value) {
            addCriterion("overBalance =", value, "overbalance");
            return (Criteria) this;
        }

        public Criteria andOverbalanceNotEqualTo(BigDecimal value) {
            addCriterion("overBalance <>", value, "overbalance");
            return (Criteria) this;
        }

        public Criteria andOverbalanceGreaterThan(BigDecimal value) {
            addCriterion("overBalance >", value, "overbalance");
            return (Criteria) this;
        }

        public Criteria andOverbalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("overBalance >=", value, "overbalance");
            return (Criteria) this;
        }

        public Criteria andOverbalanceLessThan(BigDecimal value) {
            addCriterion("overBalance <", value, "overbalance");
            return (Criteria) this;
        }

        public Criteria andOverbalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("overBalance <=", value, "overbalance");
            return (Criteria) this;
        }

        public Criteria andOverbalanceIn(List<BigDecimal> values) {
            addCriterion("overBalance in", values, "overbalance");
            return (Criteria) this;
        }

        public Criteria andOverbalanceNotIn(List<BigDecimal> values) {
            addCriterion("overBalance not in", values, "overbalance");
            return (Criteria) this;
        }

        public Criteria andOverbalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("overBalance between", value1, value2, "overbalance");
            return (Criteria) this;
        }

        public Criteria andOverbalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("overBalance not between", value1, value2, "overbalance");
            return (Criteria) this;
        }

        public Criteria andSumbalanceIsNull() {
            addCriterion("sumBalance is null");
            return (Criteria) this;
        }

        public Criteria andSumbalanceIsNotNull() {
            addCriterion("sumBalance is not null");
            return (Criteria) this;
        }

        public Criteria andSumbalanceEqualTo(BigDecimal value) {
            addCriterion("sumBalance =", value, "sumbalance");
            return (Criteria) this;
        }

        public Criteria andSumbalanceNotEqualTo(BigDecimal value) {
            addCriterion("sumBalance <>", value, "sumbalance");
            return (Criteria) this;
        }

        public Criteria andSumbalanceGreaterThan(BigDecimal value) {
            addCriterion("sumBalance >", value, "sumbalance");
            return (Criteria) this;
        }

        public Criteria andSumbalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sumBalance >=", value, "sumbalance");
            return (Criteria) this;
        }

        public Criteria andSumbalanceLessThan(BigDecimal value) {
            addCriterion("sumBalance <", value, "sumbalance");
            return (Criteria) this;
        }

        public Criteria andSumbalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sumBalance <=", value, "sumbalance");
            return (Criteria) this;
        }

        public Criteria andSumbalanceIn(List<BigDecimal> values) {
            addCriterion("sumBalance in", values, "sumbalance");
            return (Criteria) this;
        }

        public Criteria andSumbalanceNotIn(List<BigDecimal> values) {
            addCriterion("sumBalance not in", values, "sumbalance");
            return (Criteria) this;
        }

        public Criteria andSumbalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sumBalance between", value1, value2, "sumbalance");
            return (Criteria) this;
        }

        public Criteria andSumbalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sumBalance not between", value1, value2, "sumbalance");
            return (Criteria) this;
        }

        public Criteria andSettledescIsNull() {
            addCriterion("settledesc is null");
            return (Criteria) this;
        }

        public Criteria andSettledescIsNotNull() {
            addCriterion("settledesc is not null");
            return (Criteria) this;
        }

        public Criteria andSettledescEqualTo(String value) {
            addCriterion("settledesc =", value, "settledesc");
            return (Criteria) this;
        }

        public Criteria andSettledescNotEqualTo(String value) {
            addCriterion("settledesc <>", value, "settledesc");
            return (Criteria) this;
        }

        public Criteria andSettledescGreaterThan(String value) {
            addCriterion("settledesc >", value, "settledesc");
            return (Criteria) this;
        }

        public Criteria andSettledescGreaterThanOrEqualTo(String value) {
            addCriterion("settledesc >=", value, "settledesc");
            return (Criteria) this;
        }

        public Criteria andSettledescLessThan(String value) {
            addCriterion("settledesc <", value, "settledesc");
            return (Criteria) this;
        }

        public Criteria andSettledescLessThanOrEqualTo(String value) {
            addCriterion("settledesc <=", value, "settledesc");
            return (Criteria) this;
        }

        public Criteria andSettledescLike(String value) {
            addCriterion("settledesc like", value, "settledesc");
            return (Criteria) this;
        }

        public Criteria andSettledescNotLike(String value) {
            addCriterion("settledesc not like", value, "settledesc");
            return (Criteria) this;
        }

        public Criteria andSettledescIn(List<String> values) {
            addCriterion("settledesc in", values, "settledesc");
            return (Criteria) this;
        }

        public Criteria andSettledescNotIn(List<String> values) {
            addCriterion("settledesc not in", values, "settledesc");
            return (Criteria) this;
        }

        public Criteria andSettledescBetween(String value1, String value2) {
            addCriterion("settledesc between", value1, value2, "settledesc");
            return (Criteria) this;
        }

        public Criteria andSettledescNotBetween(String value1, String value2) {
            addCriterion("settledesc not between", value1, value2, "settledesc");
            return (Criteria) this;
        }

        public Criteria andSettletimeIsNull() {
            addCriterion("settletime is null");
            return (Criteria) this;
        }

        public Criteria andSettletimeIsNotNull() {
            addCriterion("settletime is not null");
            return (Criteria) this;
        }

        public Criteria andSettletimeEqualTo(Date value) {
            addCriterion("settletime =", value, "settletime");
            return (Criteria) this;
        }

        public Criteria andSettletimeNotEqualTo(Date value) {
            addCriterion("settletime <>", value, "settletime");
            return (Criteria) this;
        }

        public Criteria andSettletimeGreaterThan(Date value) {
            addCriterion("settletime >", value, "settletime");
            return (Criteria) this;
        }

        public Criteria andSettletimeGreaterThanOrEqualTo(Date value) {
            addCriterion("settletime >=", value, "settletime");
            return (Criteria) this;
        }

        public Criteria andSettletimeLessThan(Date value) {
            addCriterion("settletime <", value, "settletime");
            return (Criteria) this;
        }

        public Criteria andSettletimeLessThanOrEqualTo(Date value) {
            addCriterion("settletime <=", value, "settletime");
            return (Criteria) this;
        }

        public Criteria andSettletimeIn(List<Date> values) {
            addCriterion("settletime in", values, "settletime");
            return (Criteria) this;
        }

        public Criteria andSettletimeNotIn(List<Date> values) {
            addCriterion("settletime not in", values, "settletime");
            return (Criteria) this;
        }

        public Criteria andSettletimeBetween(Date value1, Date value2) {
            addCriterion("settletime between", value1, value2, "settletime");
            return (Criteria) this;
        }

        public Criteria andSettletimeNotBetween(Date value1, Date value2) {
            addCriterion("settletime not between", value1, value2, "settletime");
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

        public Criteria andFundtypeIsNull() {
            addCriterion("fundtype is null");
            return (Criteria) this;
        }

        public Criteria andFundtypeIsNotNull() {
            addCriterion("fundtype is not null");
            return (Criteria) this;
        }

        public Criteria andFundtypeEqualTo(Integer value) {
            addCriterion("fundtype =", value, "fundtype");
            return (Criteria) this;
        }

        public Criteria andFundtypeNotEqualTo(Integer value) {
            addCriterion("fundtype <>", value, "fundtype");
            return (Criteria) this;
        }

        public Criteria andFundtypeGreaterThan(Integer value) {
            addCriterion("fundtype >", value, "fundtype");
            return (Criteria) this;
        }

        public Criteria andFundtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("fundtype >=", value, "fundtype");
            return (Criteria) this;
        }

        public Criteria andFundtypeLessThan(Integer value) {
            addCriterion("fundtype <", value, "fundtype");
            return (Criteria) this;
        }

        public Criteria andFundtypeLessThanOrEqualTo(Integer value) {
            addCriterion("fundtype <=", value, "fundtype");
            return (Criteria) this;
        }

        public Criteria andFundtypeIn(List<Integer> values) {
            addCriterion("fundtype in", values, "fundtype");
            return (Criteria) this;
        }

        public Criteria andFundtypeNotIn(List<Integer> values) {
            addCriterion("fundtype not in", values, "fundtype");
            return (Criteria) this;
        }

        public Criteria andFundtypeBetween(Integer value1, Integer value2) {
            addCriterion("fundtype between", value1, value2, "fundtype");
            return (Criteria) this;
        }

        public Criteria andFundtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("fundtype not between", value1, value2, "fundtype");
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