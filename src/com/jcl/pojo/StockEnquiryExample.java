package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockEnquiryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StockEnquiryExample() {
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

        public Criteria andStockcodeIsNull() {
            addCriterion("stockcode is null");
            return (Criteria) this;
        }

        public Criteria andStockcodeIsNotNull() {
            addCriterion("stockcode is not null");
            return (Criteria) this;
        }

        public Criteria andStockcodeEqualTo(String value) {
            addCriterion("stockcode =", value, "stockcode");
            return (Criteria) this;
        }

        public Criteria andStockcodeNotEqualTo(String value) {
            addCriterion("stockcode <>", value, "stockcode");
            return (Criteria) this;
        }

        public Criteria andStockcodeGreaterThan(String value) {
            addCriterion("stockcode >", value, "stockcode");
            return (Criteria) this;
        }

        public Criteria andStockcodeGreaterThanOrEqualTo(String value) {
            addCriterion("stockcode >=", value, "stockcode");
            return (Criteria) this;
        }

        public Criteria andStockcodeLessThan(String value) {
            addCriterion("stockcode <", value, "stockcode");
            return (Criteria) this;
        }

        public Criteria andStockcodeLessThanOrEqualTo(String value) {
            addCriterion("stockcode <=", value, "stockcode");
            return (Criteria) this;
        }

        public Criteria andStockcodeLike(String value) {
            addCriterion("stockcode like", value, "stockcode");
            return (Criteria) this;
        }

        public Criteria andStockcodeNotLike(String value) {
            addCriterion("stockcode not like", value, "stockcode");
            return (Criteria) this;
        }

        public Criteria andStockcodeIn(List<String> values) {
            addCriterion("stockcode in", values, "stockcode");
            return (Criteria) this;
        }

        public Criteria andStockcodeNotIn(List<String> values) {
            addCriterion("stockcode not in", values, "stockcode");
            return (Criteria) this;
        }

        public Criteria andStockcodeBetween(String value1, String value2) {
            addCriterion("stockcode between", value1, value2, "stockcode");
            return (Criteria) this;
        }

        public Criteria andStockcodeNotBetween(String value1, String value2) {
            addCriterion("stockcode not between", value1, value2, "stockcode");
            return (Criteria) this;
        }

        public Criteria andStocknameIsNull() {
            addCriterion("stockname is null");
            return (Criteria) this;
        }

        public Criteria andStocknameIsNotNull() {
            addCriterion("stockname is not null");
            return (Criteria) this;
        }

        public Criteria andStocknameEqualTo(String value) {
            addCriterion("stockname =", value, "stockname");
            return (Criteria) this;
        }

        public Criteria andStocknameNotEqualTo(String value) {
            addCriterion("stockname <>", value, "stockname");
            return (Criteria) this;
        }

        public Criteria andStocknameGreaterThan(String value) {
            addCriterion("stockname >", value, "stockname");
            return (Criteria) this;
        }

        public Criteria andStocknameGreaterThanOrEqualTo(String value) {
            addCriterion("stockname >=", value, "stockname");
            return (Criteria) this;
        }

        public Criteria andStocknameLessThan(String value) {
            addCriterion("stockname <", value, "stockname");
            return (Criteria) this;
        }

        public Criteria andStocknameLessThanOrEqualTo(String value) {
            addCriterion("stockname <=", value, "stockname");
            return (Criteria) this;
        }

        public Criteria andStocknameLike(String value) {
            addCriterion("stockname like", value, "stockname");
            return (Criteria) this;
        }

        public Criteria andStocknameNotLike(String value) {
            addCriterion("stockname not like", value, "stockname");
            return (Criteria) this;
        }

        public Criteria andStocknameIn(List<String> values) {
            addCriterion("stockname in", values, "stockname");
            return (Criteria) this;
        }

        public Criteria andStocknameNotIn(List<String> values) {
            addCriterion("stockname not in", values, "stockname");
            return (Criteria) this;
        }

        public Criteria andStocknameBetween(String value1, String value2) {
            addCriterion("stockname between", value1, value2, "stockname");
            return (Criteria) this;
        }

        public Criteria andStocknameNotBetween(String value1, String value2) {
            addCriterion("stockname not between", value1, value2, "stockname");
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

        public Criteria andEnquirytimeIsNull() {
            addCriterion("enquirytime is null");
            return (Criteria) this;
        }

        public Criteria andEnquirytimeIsNotNull() {
            addCriterion("enquirytime is not null");
            return (Criteria) this;
        }

        public Criteria andEnquirytimeEqualTo(Integer value) {
            addCriterion("enquirytime =", value, "enquirytime");
            return (Criteria) this;
        }

        public Criteria andEnquirytimeNotEqualTo(Integer value) {
            addCriterion("enquirytime <>", value, "enquirytime");
            return (Criteria) this;
        }

        public Criteria andEnquirytimeGreaterThan(Integer value) {
            addCriterion("enquirytime >", value, "enquirytime");
            return (Criteria) this;
        }

        public Criteria andEnquirytimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("enquirytime >=", value, "enquirytime");
            return (Criteria) this;
        }

        public Criteria andEnquirytimeLessThan(Integer value) {
            addCriterion("enquirytime <", value, "enquirytime");
            return (Criteria) this;
        }

        public Criteria andEnquirytimeLessThanOrEqualTo(Integer value) {
            addCriterion("enquirytime <=", value, "enquirytime");
            return (Criteria) this;
        }

        public Criteria andEnquirytimeIn(List<Integer> values) {
            addCriterion("enquirytime in", values, "enquirytime");
            return (Criteria) this;
        }

        public Criteria andEnquirytimeNotIn(List<Integer> values) {
            addCriterion("enquirytime not in", values, "enquirytime");
            return (Criteria) this;
        }

        public Criteria andEnquirytimeBetween(Integer value1, Integer value2) {
            addCriterion("enquirytime between", value1, value2, "enquirytime");
            return (Criteria) this;
        }

        public Criteria andEnquirytimeNotBetween(Integer value1, Integer value2) {
            addCriterion("enquirytime not between", value1, value2, "enquirytime");
            return (Criteria) this;
        }

        public Criteria andPrincipalbalanceIsNull() {
            addCriterion("principalBalance is null");
            return (Criteria) this;
        }

        public Criteria andPrincipalbalanceIsNotNull() {
            addCriterion("principalBalance is not null");
            return (Criteria) this;
        }

        public Criteria andPrincipalbalanceEqualTo(BigDecimal value) {
            addCriterion("principalBalance =", value, "principalbalance");
            return (Criteria) this;
        }

        public Criteria andPrincipalbalanceNotEqualTo(BigDecimal value) {
            addCriterion("principalBalance <>", value, "principalbalance");
            return (Criteria) this;
        }

        public Criteria andPrincipalbalanceGreaterThan(BigDecimal value) {
            addCriterion("principalBalance >", value, "principalbalance");
            return (Criteria) this;
        }

        public Criteria andPrincipalbalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("principalBalance >=", value, "principalbalance");
            return (Criteria) this;
        }

        public Criteria andPrincipalbalanceLessThan(BigDecimal value) {
            addCriterion("principalBalance <", value, "principalbalance");
            return (Criteria) this;
        }

        public Criteria andPrincipalbalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("principalBalance <=", value, "principalbalance");
            return (Criteria) this;
        }

        public Criteria andPrincipalbalanceIn(List<BigDecimal> values) {
            addCriterion("principalBalance in", values, "principalbalance");
            return (Criteria) this;
        }

        public Criteria andPrincipalbalanceNotIn(List<BigDecimal> values) {
            addCriterion("principalBalance not in", values, "principalbalance");
            return (Criteria) this;
        }

        public Criteria andPrincipalbalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("principalBalance between", value1, value2, "principalbalance");
            return (Criteria) this;
        }

        public Criteria andPrincipalbalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("principalBalance not between", value1, value2, "principalbalance");
            return (Criteria) this;
        }

        public Criteria andPrincipalfloatIsNull() {
            addCriterion("principalFloat is null");
            return (Criteria) this;
        }

        public Criteria andPrincipalfloatIsNotNull() {
            addCriterion("principalFloat is not null");
            return (Criteria) this;
        }

        public Criteria andPrincipalfloatEqualTo(BigDecimal value) {
            addCriterion("principalFloat =", value, "principalfloat");
            return (Criteria) this;
        }

        public Criteria andPrincipalfloatNotEqualTo(BigDecimal value) {
            addCriterion("principalFloat <>", value, "principalfloat");
            return (Criteria) this;
        }

        public Criteria andPrincipalfloatGreaterThan(BigDecimal value) {
            addCriterion("principalFloat >", value, "principalfloat");
            return (Criteria) this;
        }

        public Criteria andPrincipalfloatGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("principalFloat >=", value, "principalfloat");
            return (Criteria) this;
        }

        public Criteria andPrincipalfloatLessThan(BigDecimal value) {
            addCriterion("principalFloat <", value, "principalfloat");
            return (Criteria) this;
        }

        public Criteria andPrincipalfloatLessThanOrEqualTo(BigDecimal value) {
            addCriterion("principalFloat <=", value, "principalfloat");
            return (Criteria) this;
        }

        public Criteria andPrincipalfloatIn(List<BigDecimal> values) {
            addCriterion("principalFloat in", values, "principalfloat");
            return (Criteria) this;
        }

        public Criteria andPrincipalfloatNotIn(List<BigDecimal> values) {
            addCriterion("principalFloat not in", values, "principalfloat");
            return (Criteria) this;
        }

        public Criteria andPrincipalfloatBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("principalFloat between", value1, value2, "principalfloat");
            return (Criteria) this;
        }

        public Criteria andPrincipalfloatNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("principalFloat not between", value1, value2, "principalfloat");
            return (Criteria) this;
        }

        public Criteria andRoyaltybalanceIsNull() {
            addCriterion("royaltyBalance is null");
            return (Criteria) this;
        }

        public Criteria andRoyaltybalanceIsNotNull() {
            addCriterion("royaltyBalance is not null");
            return (Criteria) this;
        }

        public Criteria andRoyaltybalanceEqualTo(BigDecimal value) {
            addCriterion("royaltyBalance =", value, "royaltybalance");
            return (Criteria) this;
        }

        public Criteria andRoyaltybalanceNotEqualTo(BigDecimal value) {
            addCriterion("royaltyBalance <>", value, "royaltybalance");
            return (Criteria) this;
        }

        public Criteria andRoyaltybalanceGreaterThan(BigDecimal value) {
            addCriterion("royaltyBalance >", value, "royaltybalance");
            return (Criteria) this;
        }

        public Criteria andRoyaltybalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("royaltyBalance >=", value, "royaltybalance");
            return (Criteria) this;
        }

        public Criteria andRoyaltybalanceLessThan(BigDecimal value) {
            addCriterion("royaltyBalance <", value, "royaltybalance");
            return (Criteria) this;
        }

        public Criteria andRoyaltybalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("royaltyBalance <=", value, "royaltybalance");
            return (Criteria) this;
        }

        public Criteria andRoyaltybalanceIn(List<BigDecimal> values) {
            addCriterion("royaltyBalance in", values, "royaltybalance");
            return (Criteria) this;
        }

        public Criteria andRoyaltybalanceNotIn(List<BigDecimal> values) {
            addCriterion("royaltyBalance not in", values, "royaltybalance");
            return (Criteria) this;
        }

        public Criteria andRoyaltybalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("royaltyBalance between", value1, value2, "royaltybalance");
            return (Criteria) this;
        }

        public Criteria andRoyaltybalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("royaltyBalance not between", value1, value2, "royaltybalance");
            return (Criteria) this;
        }

        public Criteria andEnquirypriceIsNull() {
            addCriterion("enquiryPrice is null");
            return (Criteria) this;
        }

        public Criteria andEnquirypriceIsNotNull() {
            addCriterion("enquiryPrice is not null");
            return (Criteria) this;
        }

        public Criteria andEnquirypriceEqualTo(BigDecimal value) {
            addCriterion("enquiryPrice =", value, "enquiryprice");
            return (Criteria) this;
        }

        public Criteria andEnquirypriceNotEqualTo(BigDecimal value) {
            addCriterion("enquiryPrice <>", value, "enquiryprice");
            return (Criteria) this;
        }

        public Criteria andEnquirypriceGreaterThan(BigDecimal value) {
            addCriterion("enquiryPrice >", value, "enquiryprice");
            return (Criteria) this;
        }

        public Criteria andEnquirypriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("enquiryPrice >=", value, "enquiryprice");
            return (Criteria) this;
        }

        public Criteria andEnquirypriceLessThan(BigDecimal value) {
            addCriterion("enquiryPrice <", value, "enquiryprice");
            return (Criteria) this;
        }

        public Criteria andEnquirypriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("enquiryPrice <=", value, "enquiryprice");
            return (Criteria) this;
        }

        public Criteria andEnquirypriceIn(List<BigDecimal> values) {
            addCriterion("enquiryPrice in", values, "enquiryprice");
            return (Criteria) this;
        }

        public Criteria andEnquirypriceNotIn(List<BigDecimal> values) {
            addCriterion("enquiryPrice not in", values, "enquiryprice");
            return (Criteria) this;
        }

        public Criteria andEnquirypriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("enquiryPrice between", value1, value2, "enquiryprice");
            return (Criteria) this;
        }

        public Criteria andEnquirypriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("enquiryPrice not between", value1, value2, "enquiryprice");
            return (Criteria) this;
        }

        public Criteria andSettlepriceIsNull() {
            addCriterion("settlePrice is null");
            return (Criteria) this;
        }

        public Criteria andSettlepriceIsNotNull() {
            addCriterion("settlePrice is not null");
            return (Criteria) this;
        }

        public Criteria andSettlepriceEqualTo(BigDecimal value) {
            addCriterion("settlePrice =", value, "settleprice");
            return (Criteria) this;
        }

        public Criteria andSettlepriceNotEqualTo(BigDecimal value) {
            addCriterion("settlePrice <>", value, "settleprice");
            return (Criteria) this;
        }

        public Criteria andSettlepriceGreaterThan(BigDecimal value) {
            addCriterion("settlePrice >", value, "settleprice");
            return (Criteria) this;
        }

        public Criteria andSettlepriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("settlePrice >=", value, "settleprice");
            return (Criteria) this;
        }

        public Criteria andSettlepriceLessThan(BigDecimal value) {
            addCriterion("settlePrice <", value, "settleprice");
            return (Criteria) this;
        }

        public Criteria andSettlepriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("settlePrice <=", value, "settleprice");
            return (Criteria) this;
        }

        public Criteria andSettlepriceIn(List<BigDecimal> values) {
            addCriterion("settlePrice in", values, "settleprice");
            return (Criteria) this;
        }

        public Criteria andSettlepriceNotIn(List<BigDecimal> values) {
            addCriterion("settlePrice not in", values, "settleprice");
            return (Criteria) this;
        }

        public Criteria andSettlepriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("settlePrice between", value1, value2, "settleprice");
            return (Criteria) this;
        }

        public Criteria andSettlepriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("settlePrice not between", value1, value2, "settleprice");
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

        public Criteria andStarttimeIsNull() {
            addCriterion("starttime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("starttime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterion("starttime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterion("starttime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterion("starttime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("starttime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterion("starttime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("starttime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterion("starttime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterion("starttime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterion("starttime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("starttime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endtime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endtime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterion("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterion("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterion("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterion("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterion("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterion("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterion("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("endtime not between", value1, value2, "endtime");
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

        public Criteria andBuytimeIsNull() {
            addCriterion("buytime is null");
            return (Criteria) this;
        }

        public Criteria andBuytimeIsNotNull() {
            addCriterion("buytime is not null");
            return (Criteria) this;
        }

        public Criteria andBuytimeEqualTo(Date value) {
            addCriterion("buytime =", value, "buytime");
            return (Criteria) this;
        }

        public Criteria andBuytimeNotEqualTo(Date value) {
            addCriterion("buytime <>", value, "buytime");
            return (Criteria) this;
        }

        public Criteria andBuytimeGreaterThan(Date value) {
            addCriterion("buytime >", value, "buytime");
            return (Criteria) this;
        }

        public Criteria andBuytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("buytime >=", value, "buytime");
            return (Criteria) this;
        }

        public Criteria andBuytimeLessThan(Date value) {
            addCriterion("buytime <", value, "buytime");
            return (Criteria) this;
        }

        public Criteria andBuytimeLessThanOrEqualTo(Date value) {
            addCriterion("buytime <=", value, "buytime");
            return (Criteria) this;
        }

        public Criteria andBuytimeIn(List<Date> values) {
            addCriterion("buytime in", values, "buytime");
            return (Criteria) this;
        }

        public Criteria andBuytimeNotIn(List<Date> values) {
            addCriterion("buytime not in", values, "buytime");
            return (Criteria) this;
        }

        public Criteria andBuytimeBetween(Date value1, Date value2) {
            addCriterion("buytime between", value1, value2, "buytime");
            return (Criteria) this;
        }

        public Criteria andBuytimeNotBetween(Date value1, Date value2) {
            addCriterion("buytime not between", value1, value2, "buytime");
            return (Criteria) this;
        }

        public Criteria andEnquirydescIsNull() {
            addCriterion("enquirydesc is null");
            return (Criteria) this;
        }

        public Criteria andEnquirydescIsNotNull() {
            addCriterion("enquirydesc is not null");
            return (Criteria) this;
        }

        public Criteria andEnquirydescEqualTo(String value) {
            addCriterion("enquirydesc =", value, "enquirydesc");
            return (Criteria) this;
        }

        public Criteria andEnquirydescNotEqualTo(String value) {
            addCriterion("enquirydesc <>", value, "enquirydesc");
            return (Criteria) this;
        }

        public Criteria andEnquirydescGreaterThan(String value) {
            addCriterion("enquirydesc >", value, "enquirydesc");
            return (Criteria) this;
        }

        public Criteria andEnquirydescGreaterThanOrEqualTo(String value) {
            addCriterion("enquirydesc >=", value, "enquirydesc");
            return (Criteria) this;
        }

        public Criteria andEnquirydescLessThan(String value) {
            addCriterion("enquirydesc <", value, "enquirydesc");
            return (Criteria) this;
        }

        public Criteria andEnquirydescLessThanOrEqualTo(String value) {
            addCriterion("enquirydesc <=", value, "enquirydesc");
            return (Criteria) this;
        }

        public Criteria andEnquirydescLike(String value) {
            addCriterion("enquirydesc like", value, "enquirydesc");
            return (Criteria) this;
        }

        public Criteria andEnquirydescNotLike(String value) {
            addCriterion("enquirydesc not like", value, "enquirydesc");
            return (Criteria) this;
        }

        public Criteria andEnquirydescIn(List<String> values) {
            addCriterion("enquirydesc in", values, "enquirydesc");
            return (Criteria) this;
        }

        public Criteria andEnquirydescNotIn(List<String> values) {
            addCriterion("enquirydesc not in", values, "enquirydesc");
            return (Criteria) this;
        }

        public Criteria andEnquirydescBetween(String value1, String value2) {
            addCriterion("enquirydesc between", value1, value2, "enquirydesc");
            return (Criteria) this;
        }

        public Criteria andEnquirydescNotBetween(String value1, String value2) {
            addCriterion("enquirydesc not between", value1, value2, "enquirydesc");
            return (Criteria) this;
        }

        public Criteria andSetfeeIsNull() {
            addCriterion("setFee is null");
            return (Criteria) this;
        }

        public Criteria andSetfeeIsNotNull() {
            addCriterion("setFee is not null");
            return (Criteria) this;
        }

        public Criteria andSetfeeEqualTo(Integer value) {
            addCriterion("setFee =", value, "setfee");
            return (Criteria) this;
        }

        public Criteria andSetfeeNotEqualTo(Integer value) {
            addCriterion("setFee <>", value, "setfee");
            return (Criteria) this;
        }

        public Criteria andSetfeeGreaterThan(Integer value) {
            addCriterion("setFee >", value, "setfee");
            return (Criteria) this;
        }

        public Criteria andSetfeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("setFee >=", value, "setfee");
            return (Criteria) this;
        }

        public Criteria andSetfeeLessThan(Integer value) {
            addCriterion("setFee <", value, "setfee");
            return (Criteria) this;
        }

        public Criteria andSetfeeLessThanOrEqualTo(Integer value) {
            addCriterion("setFee <=", value, "setfee");
            return (Criteria) this;
        }

        public Criteria andSetfeeIn(List<Integer> values) {
            addCriterion("setFee in", values, "setfee");
            return (Criteria) this;
        }

        public Criteria andSetfeeNotIn(List<Integer> values) {
            addCriterion("setFee not in", values, "setfee");
            return (Criteria) this;
        }

        public Criteria andSetfeeBetween(Integer value1, Integer value2) {
            addCriterion("setFee between", value1, value2, "setfee");
            return (Criteria) this;
        }

        public Criteria andSetfeeNotBetween(Integer value1, Integer value2) {
            addCriterion("setFee not between", value1, value2, "setfee");
            return (Criteria) this;
        }

        public Criteria andOrgincodeIsNull() {
            addCriterion("orgincode is null");
            return (Criteria) this;
        }

        public Criteria andOrgincodeIsNotNull() {
            addCriterion("orgincode is not null");
            return (Criteria) this;
        }

        public Criteria andOrgincodeEqualTo(String value) {
            addCriterion("orgincode =", value, "orgincode");
            return (Criteria) this;
        }

        public Criteria andOrgincodeNotEqualTo(String value) {
            addCriterion("orgincode <>", value, "orgincode");
            return (Criteria) this;
        }

        public Criteria andOrgincodeGreaterThan(String value) {
            addCriterion("orgincode >", value, "orgincode");
            return (Criteria) this;
        }

        public Criteria andOrgincodeGreaterThanOrEqualTo(String value) {
            addCriterion("orgincode >=", value, "orgincode");
            return (Criteria) this;
        }

        public Criteria andOrgincodeLessThan(String value) {
            addCriterion("orgincode <", value, "orgincode");
            return (Criteria) this;
        }

        public Criteria andOrgincodeLessThanOrEqualTo(String value) {
            addCriterion("orgincode <=", value, "orgincode");
            return (Criteria) this;
        }

        public Criteria andOrgincodeLike(String value) {
            addCriterion("orgincode like", value, "orgincode");
            return (Criteria) this;
        }

        public Criteria andOrgincodeNotLike(String value) {
            addCriterion("orgincode not like", value, "orgincode");
            return (Criteria) this;
        }

        public Criteria andOrgincodeIn(List<String> values) {
            addCriterion("orgincode in", values, "orgincode");
            return (Criteria) this;
        }

        public Criteria andOrgincodeNotIn(List<String> values) {
            addCriterion("orgincode not in", values, "orgincode");
            return (Criteria) this;
        }

        public Criteria andOrgincodeBetween(String value1, String value2) {
            addCriterion("orgincode between", value1, value2, "orgincode");
            return (Criteria) this;
        }

        public Criteria andOrgincodeNotBetween(String value1, String value2) {
            addCriterion("orgincode not between", value1, value2, "orgincode");
            return (Criteria) this;
        }

        public Criteria andOrginnameIsNull() {
            addCriterion("orginname is null");
            return (Criteria) this;
        }

        public Criteria andOrginnameIsNotNull() {
            addCriterion("orginname is not null");
            return (Criteria) this;
        }

        public Criteria andOrginnameEqualTo(String value) {
            addCriterion("orginname =", value, "orginname");
            return (Criteria) this;
        }

        public Criteria andOrginnameNotEqualTo(String value) {
            addCriterion("orginname <>", value, "orginname");
            return (Criteria) this;
        }

        public Criteria andOrginnameGreaterThan(String value) {
            addCriterion("orginname >", value, "orginname");
            return (Criteria) this;
        }

        public Criteria andOrginnameGreaterThanOrEqualTo(String value) {
            addCriterion("orginname >=", value, "orginname");
            return (Criteria) this;
        }

        public Criteria andOrginnameLessThan(String value) {
            addCriterion("orginname <", value, "orginname");
            return (Criteria) this;
        }

        public Criteria andOrginnameLessThanOrEqualTo(String value) {
            addCriterion("orginname <=", value, "orginname");
            return (Criteria) this;
        }

        public Criteria andOrginnameLike(String value) {
            addCriterion("orginname like", value, "orginname");
            return (Criteria) this;
        }

        public Criteria andOrginnameNotLike(String value) {
            addCriterion("orginname not like", value, "orginname");
            return (Criteria) this;
        }

        public Criteria andOrginnameIn(List<String> values) {
            addCriterion("orginname in", values, "orginname");
            return (Criteria) this;
        }

        public Criteria andOrginnameNotIn(List<String> values) {
            addCriterion("orginname not in", values, "orginname");
            return (Criteria) this;
        }

        public Criteria andOrginnameBetween(String value1, String value2) {
            addCriterion("orginname between", value1, value2, "orginname");
            return (Criteria) this;
        }

        public Criteria andOrginnameNotBetween(String value1, String value2) {
            addCriterion("orginname not between", value1, value2, "orginname");
            return (Criteria) this;
        }

        public Criteria andAgentIsNull() {
            addCriterion("agent is null");
            return (Criteria) this;
        }

        public Criteria andAgentIsNotNull() {
            addCriterion("agent is not null");
            return (Criteria) this;
        }

        public Criteria andAgentEqualTo(String value) {
            addCriterion("agent =", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentNotEqualTo(String value) {
            addCriterion("agent <>", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentGreaterThan(String value) {
            addCriterion("agent >", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentGreaterThanOrEqualTo(String value) {
            addCriterion("agent >=", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentLessThan(String value) {
            addCriterion("agent <", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentLessThanOrEqualTo(String value) {
            addCriterion("agent <=", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentLike(String value) {
            addCriterion("agent like", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentNotLike(String value) {
            addCriterion("agent not like", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentIn(List<String> values) {
            addCriterion("agent in", values, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentNotIn(List<String> values) {
            addCriterion("agent not in", values, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentBetween(String value1, String value2) {
            addCriterion("agent between", value1, value2, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentNotBetween(String value1, String value2) {
            addCriterion("agent not between", value1, value2, "agent");
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

        public Criteria andDitchIsNull() {
            addCriterion("ditch is null");
            return (Criteria) this;
        }

        public Criteria andDitchIsNotNull() {
            addCriterion("ditch is not null");
            return (Criteria) this;
        }

        public Criteria andDitchEqualTo(String value) {
            addCriterion("ditch =", value, "ditch");
            return (Criteria) this;
        }

        public Criteria andDitchNotEqualTo(String value) {
            addCriterion("ditch <>", value, "ditch");
            return (Criteria) this;
        }

        public Criteria andDitchGreaterThan(String value) {
            addCriterion("ditch >", value, "ditch");
            return (Criteria) this;
        }

        public Criteria andDitchGreaterThanOrEqualTo(String value) {
            addCriterion("ditch >=", value, "ditch");
            return (Criteria) this;
        }

        public Criteria andDitchLessThan(String value) {
            addCriterion("ditch <", value, "ditch");
            return (Criteria) this;
        }

        public Criteria andDitchLessThanOrEqualTo(String value) {
            addCriterion("ditch <=", value, "ditch");
            return (Criteria) this;
        }

        public Criteria andDitchLike(String value) {
            addCriterion("ditch like", value, "ditch");
            return (Criteria) this;
        }

        public Criteria andDitchNotLike(String value) {
            addCriterion("ditch not like", value, "ditch");
            return (Criteria) this;
        }

        public Criteria andDitchIn(List<String> values) {
            addCriterion("ditch in", values, "ditch");
            return (Criteria) this;
        }

        public Criteria andDitchNotIn(List<String> values) {
            addCriterion("ditch not in", values, "ditch");
            return (Criteria) this;
        }

        public Criteria andDitchBetween(String value1, String value2) {
            addCriterion("ditch between", value1, value2, "ditch");
            return (Criteria) this;
        }

        public Criteria andDitchNotBetween(String value1, String value2) {
            addCriterion("ditch not between", value1, value2, "ditch");
            return (Criteria) this;
        }

        public Criteria andAgentidIsNull() {
            addCriterion("agentid is null");
            return (Criteria) this;
        }

        public Criteria andAgentidIsNotNull() {
            addCriterion("agentid is not null");
            return (Criteria) this;
        }

        public Criteria andAgentidEqualTo(String value) {
            addCriterion("agentid =", value, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidNotEqualTo(String value) {
            addCriterion("agentid <>", value, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidGreaterThan(String value) {
            addCriterion("agentid >", value, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidGreaterThanOrEqualTo(String value) {
            addCriterion("agentid >=", value, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidLessThan(String value) {
            addCriterion("agentid <", value, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidLessThanOrEqualTo(String value) {
            addCriterion("agentid <=", value, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidLike(String value) {
            addCriterion("agentid like", value, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidNotLike(String value) {
            addCriterion("agentid not like", value, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidIn(List<String> values) {
            addCriterion("agentid in", values, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidNotIn(List<String> values) {
            addCriterion("agentid not in", values, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidBetween(String value1, String value2) {
            addCriterion("agentid between", value1, value2, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidNotBetween(String value1, String value2) {
            addCriterion("agentid not between", value1, value2, "agentid");
            return (Criteria) this;
        }

        public Criteria andDitchidIsNull() {
            addCriterion("ditchid is null");
            return (Criteria) this;
        }

        public Criteria andDitchidIsNotNull() {
            addCriterion("ditchid is not null");
            return (Criteria) this;
        }

        public Criteria andDitchidEqualTo(String value) {
            addCriterion("ditchid =", value, "ditchid");
            return (Criteria) this;
        }

        public Criteria andDitchidNotEqualTo(String value) {
            addCriterion("ditchid <>", value, "ditchid");
            return (Criteria) this;
        }

        public Criteria andDitchidGreaterThan(String value) {
            addCriterion("ditchid >", value, "ditchid");
            return (Criteria) this;
        }

        public Criteria andDitchidGreaterThanOrEqualTo(String value) {
            addCriterion("ditchid >=", value, "ditchid");
            return (Criteria) this;
        }

        public Criteria andDitchidLessThan(String value) {
            addCriterion("ditchid <", value, "ditchid");
            return (Criteria) this;
        }

        public Criteria andDitchidLessThanOrEqualTo(String value) {
            addCriterion("ditchid <=", value, "ditchid");
            return (Criteria) this;
        }

        public Criteria andDitchidLike(String value) {
            addCriterion("ditchid like", value, "ditchid");
            return (Criteria) this;
        }

        public Criteria andDitchidNotLike(String value) {
            addCriterion("ditchid not like", value, "ditchid");
            return (Criteria) this;
        }

        public Criteria andDitchidIn(List<String> values) {
            addCriterion("ditchid in", values, "ditchid");
            return (Criteria) this;
        }

        public Criteria andDitchidNotIn(List<String> values) {
            addCriterion("ditchid not in", values, "ditchid");
            return (Criteria) this;
        }

        public Criteria andDitchidBetween(String value1, String value2) {
            addCriterion("ditchid between", value1, value2, "ditchid");
            return (Criteria) this;
        }

        public Criteria andDitchidNotBetween(String value1, String value2) {
            addCriterion("ditchid not between", value1, value2, "ditchid");
            return (Criteria) this;
        }

        public Criteria andOrginfloatIsNull() {
            addCriterion("orginFloat is null");
            return (Criteria) this;
        }

        public Criteria andOrginfloatIsNotNull() {
            addCriterion("orginFloat is not null");
            return (Criteria) this;
        }

        public Criteria andOrginfloatEqualTo(BigDecimal value) {
            addCriterion("orginFloat =", value, "orginfloat");
            return (Criteria) this;
        }

        public Criteria andOrginfloatNotEqualTo(BigDecimal value) {
            addCriterion("orginFloat <>", value, "orginfloat");
            return (Criteria) this;
        }

        public Criteria andOrginfloatGreaterThan(BigDecimal value) {
            addCriterion("orginFloat >", value, "orginfloat");
            return (Criteria) this;
        }

        public Criteria andOrginfloatGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("orginFloat >=", value, "orginfloat");
            return (Criteria) this;
        }

        public Criteria andOrginfloatLessThan(BigDecimal value) {
            addCriterion("orginFloat <", value, "orginfloat");
            return (Criteria) this;
        }

        public Criteria andOrginfloatLessThanOrEqualTo(BigDecimal value) {
            addCriterion("orginFloat <=", value, "orginfloat");
            return (Criteria) this;
        }

        public Criteria andOrginfloatIn(List<BigDecimal> values) {
            addCriterion("orginFloat in", values, "orginfloat");
            return (Criteria) this;
        }

        public Criteria andOrginfloatNotIn(List<BigDecimal> values) {
            addCriterion("orginFloat not in", values, "orginfloat");
            return (Criteria) this;
        }

        public Criteria andOrginfloatBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("orginFloat between", value1, value2, "orginfloat");
            return (Criteria) this;
        }

        public Criteria andOrginfloatNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("orginFloat not between", value1, value2, "orginfloat");
            return (Criteria) this;
        }

        public Criteria andIssellIsNull() {
            addCriterion("isSell is null");
            return (Criteria) this;
        }

        public Criteria andIssellIsNotNull() {
            addCriterion("isSell is not null");
            return (Criteria) this;
        }

        public Criteria andIssellEqualTo(Integer value) {
            addCriterion("isSell =", value, "issell");
            return (Criteria) this;
        }

        public Criteria andIssellNotEqualTo(Integer value) {
            addCriterion("isSell <>", value, "issell");
            return (Criteria) this;
        }

        public Criteria andIssellGreaterThan(Integer value) {
            addCriterion("isSell >", value, "issell");
            return (Criteria) this;
        }

        public Criteria andIssellGreaterThanOrEqualTo(Integer value) {
            addCriterion("isSell >=", value, "issell");
            return (Criteria) this;
        }

        public Criteria andIssellLessThan(Integer value) {
            addCriterion("isSell <", value, "issell");
            return (Criteria) this;
        }

        public Criteria andIssellLessThanOrEqualTo(Integer value) {
            addCriterion("isSell <=", value, "issell");
            return (Criteria) this;
        }

        public Criteria andIssellIn(List<Integer> values) {
            addCriterion("isSell in", values, "issell");
            return (Criteria) this;
        }

        public Criteria andIssellNotIn(List<Integer> values) {
            addCriterion("isSell not in", values, "issell");
            return (Criteria) this;
        }

        public Criteria andIssellBetween(Integer value1, Integer value2) {
            addCriterion("isSell between", value1, value2, "issell");
            return (Criteria) this;
        }

        public Criteria andIssellNotBetween(Integer value1, Integer value2) {
            addCriterion("isSell not between", value1, value2, "issell");
            return (Criteria) this;
        }

        public Criteria andProfitIsNull() {
            addCriterion("profit is null");
            return (Criteria) this;
        }

        public Criteria andProfitIsNotNull() {
            addCriterion("profit is not null");
            return (Criteria) this;
        }

        public Criteria andProfitEqualTo(BigDecimal value) {
            addCriterion("profit =", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitNotEqualTo(BigDecimal value) {
            addCriterion("profit <>", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitGreaterThan(BigDecimal value) {
            addCriterion("profit >", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("profit >=", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitLessThan(BigDecimal value) {
            addCriterion("profit <", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("profit <=", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitIn(List<BigDecimal> values) {
            addCriterion("profit in", values, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitNotIn(List<BigDecimal> values) {
            addCriterion("profit not in", values, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("profit between", value1, value2, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("profit not between", value1, value2, "profit");
            return (Criteria) this;
        }

        public Criteria andFreepriceIsNull() {
            addCriterion("freePrice is null");
            return (Criteria) this;
        }

        public Criteria andFreepriceIsNotNull() {
            addCriterion("freePrice is not null");
            return (Criteria) this;
        }

        public Criteria andFreepriceEqualTo(BigDecimal value) {
            addCriterion("freePrice =", value, "freeprice");
            return (Criteria) this;
        }

        public Criteria andFreepriceNotEqualTo(BigDecimal value) {
            addCriterion("freePrice <>", value, "freeprice");
            return (Criteria) this;
        }

        public Criteria andFreepriceGreaterThan(BigDecimal value) {
            addCriterion("freePrice >", value, "freeprice");
            return (Criteria) this;
        }

        public Criteria andFreepriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("freePrice >=", value, "freeprice");
            return (Criteria) this;
        }

        public Criteria andFreepriceLessThan(BigDecimal value) {
            addCriterion("freePrice <", value, "freeprice");
            return (Criteria) this;
        }

        public Criteria andFreepriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("freePrice <=", value, "freeprice");
            return (Criteria) this;
        }

        public Criteria andFreepriceIn(List<BigDecimal> values) {
            addCriterion("freePrice in", values, "freeprice");
            return (Criteria) this;
        }

        public Criteria andFreepriceNotIn(List<BigDecimal> values) {
            addCriterion("freePrice not in", values, "freeprice");
            return (Criteria) this;
        }

        public Criteria andFreepriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freePrice between", value1, value2, "freeprice");
            return (Criteria) this;
        }

        public Criteria andFreepriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freePrice not between", value1, value2, "freeprice");
            return (Criteria) this;
        }

        public Criteria andTimeflyIsNull() {
            addCriterion("timeFly is null");
            return (Criteria) this;
        }

        public Criteria andTimeflyIsNotNull() {
            addCriterion("timeFly is not null");
            return (Criteria) this;
        }

        public Criteria andTimeflyEqualTo(Integer value) {
            addCriterion("timeFly =", value, "timefly");
            return (Criteria) this;
        }

        public Criteria andTimeflyNotEqualTo(Integer value) {
            addCriterion("timeFly <>", value, "timefly");
            return (Criteria) this;
        }

        public Criteria andTimeflyGreaterThan(Integer value) {
            addCriterion("timeFly >", value, "timefly");
            return (Criteria) this;
        }

        public Criteria andTimeflyGreaterThanOrEqualTo(Integer value) {
            addCriterion("timeFly >=", value, "timefly");
            return (Criteria) this;
        }

        public Criteria andTimeflyLessThan(Integer value) {
            addCriterion("timeFly <", value, "timefly");
            return (Criteria) this;
        }

        public Criteria andTimeflyLessThanOrEqualTo(Integer value) {
            addCriterion("timeFly <=", value, "timefly");
            return (Criteria) this;
        }

        public Criteria andTimeflyIn(List<Integer> values) {
            addCriterion("timeFly in", values, "timefly");
            return (Criteria) this;
        }

        public Criteria andTimeflyNotIn(List<Integer> values) {
            addCriterion("timeFly not in", values, "timefly");
            return (Criteria) this;
        }

        public Criteria andTimeflyBetween(Integer value1, Integer value2) {
            addCriterion("timeFly between", value1, value2, "timefly");
            return (Criteria) this;
        }

        public Criteria andTimeflyNotBetween(Integer value1, Integer value2) {
            addCriterion("timeFly not between", value1, value2, "timefly");
            return (Criteria) this;
        }

        public Criteria andCyclefloatIsNull() {
            addCriterion("cycleFloat is null");
            return (Criteria) this;
        }

        public Criteria andCyclefloatIsNotNull() {
            addCriterion("cycleFloat is not null");
            return (Criteria) this;
        }

        public Criteria andCyclefloatEqualTo(BigDecimal value) {
            addCriterion("cycleFloat =", value, "cyclefloat");
            return (Criteria) this;
        }

        public Criteria andCyclefloatNotEqualTo(BigDecimal value) {
            addCriterion("cycleFloat <>", value, "cyclefloat");
            return (Criteria) this;
        }

        public Criteria andCyclefloatGreaterThan(BigDecimal value) {
            addCriterion("cycleFloat >", value, "cyclefloat");
            return (Criteria) this;
        }

        public Criteria andCyclefloatGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cycleFloat >=", value, "cyclefloat");
            return (Criteria) this;
        }

        public Criteria andCyclefloatLessThan(BigDecimal value) {
            addCriterion("cycleFloat <", value, "cyclefloat");
            return (Criteria) this;
        }

        public Criteria andCyclefloatLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cycleFloat <=", value, "cyclefloat");
            return (Criteria) this;
        }

        public Criteria andCyclefloatIn(List<BigDecimal> values) {
            addCriterion("cycleFloat in", values, "cyclefloat");
            return (Criteria) this;
        }

        public Criteria andCyclefloatNotIn(List<BigDecimal> values) {
            addCriterion("cycleFloat not in", values, "cyclefloat");
            return (Criteria) this;
        }

        public Criteria andCyclefloatBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cycleFloat between", value1, value2, "cyclefloat");
            return (Criteria) this;
        }

        public Criteria andCyclefloatNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cycleFloat not between", value1, value2, "cyclefloat");
            return (Criteria) this;
        }

        public Criteria andMybjfloatIsNull() {
            addCriterion("mybjFloat is null");
            return (Criteria) this;
        }

        public Criteria andMybjfloatIsNotNull() {
            addCriterion("mybjFloat is not null");
            return (Criteria) this;
        }

        public Criteria andMybjfloatEqualTo(BigDecimal value) {
            addCriterion("mybjFloat =", value, "mybjfloat");
            return (Criteria) this;
        }

        public Criteria andMybjfloatNotEqualTo(BigDecimal value) {
            addCriterion("mybjFloat <>", value, "mybjfloat");
            return (Criteria) this;
        }

        public Criteria andMybjfloatGreaterThan(BigDecimal value) {
            addCriterion("mybjFloat >", value, "mybjfloat");
            return (Criteria) this;
        }

        public Criteria andMybjfloatGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("mybjFloat >=", value, "mybjfloat");
            return (Criteria) this;
        }

        public Criteria andMybjfloatLessThan(BigDecimal value) {
            addCriterion("mybjFloat <", value, "mybjfloat");
            return (Criteria) this;
        }

        public Criteria andMybjfloatLessThanOrEqualTo(BigDecimal value) {
            addCriterion("mybjFloat <=", value, "mybjfloat");
            return (Criteria) this;
        }

        public Criteria andMybjfloatIn(List<BigDecimal> values) {
            addCriterion("mybjFloat in", values, "mybjfloat");
            return (Criteria) this;
        }

        public Criteria andMybjfloatNotIn(List<BigDecimal> values) {
            addCriterion("mybjFloat not in", values, "mybjfloat");
            return (Criteria) this;
        }

        public Criteria andMybjfloatBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mybjFloat between", value1, value2, "mybjfloat");
            return (Criteria) this;
        }

        public Criteria andMybjfloatNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mybjFloat not between", value1, value2, "mybjfloat");
            return (Criteria) this;
        }

        public Criteria andAgentfIsNull() {
            addCriterion("agentf is null");
            return (Criteria) this;
        }

        public Criteria andAgentfIsNotNull() {
            addCriterion("agentf is not null");
            return (Criteria) this;
        }

        public Criteria andAgentfEqualTo(BigDecimal value) {
            addCriterion("agentf =", value, "agentf");
            return (Criteria) this;
        }

        public Criteria andAgentfNotEqualTo(BigDecimal value) {
            addCriterion("agentf <>", value, "agentf");
            return (Criteria) this;
        }

        public Criteria andAgentfGreaterThan(BigDecimal value) {
            addCriterion("agentf >", value, "agentf");
            return (Criteria) this;
        }

        public Criteria andAgentfGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("agentf >=", value, "agentf");
            return (Criteria) this;
        }

        public Criteria andAgentfLessThan(BigDecimal value) {
            addCriterion("agentf <", value, "agentf");
            return (Criteria) this;
        }

        public Criteria andAgentfLessThanOrEqualTo(BigDecimal value) {
            addCriterion("agentf <=", value, "agentf");
            return (Criteria) this;
        }

        public Criteria andAgentfIn(List<BigDecimal> values) {
            addCriterion("agentf in", values, "agentf");
            return (Criteria) this;
        }

        public Criteria andAgentfNotIn(List<BigDecimal> values) {
            addCriterion("agentf not in", values, "agentf");
            return (Criteria) this;
        }

        public Criteria andAgentfBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("agentf between", value1, value2, "agentf");
            return (Criteria) this;
        }

        public Criteria andAgentfNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("agentf not between", value1, value2, "agentf");
            return (Criteria) this;
        }

        public Criteria andOrginfIsNull() {
            addCriterion("orginf is null");
            return (Criteria) this;
        }

        public Criteria andOrginfIsNotNull() {
            addCriterion("orginf is not null");
            return (Criteria) this;
        }

        public Criteria andOrginfEqualTo(BigDecimal value) {
            addCriterion("orginf =", value, "orginf");
            return (Criteria) this;
        }

        public Criteria andOrginfNotEqualTo(BigDecimal value) {
            addCriterion("orginf <>", value, "orginf");
            return (Criteria) this;
        }

        public Criteria andOrginfGreaterThan(BigDecimal value) {
            addCriterion("orginf >", value, "orginf");
            return (Criteria) this;
        }

        public Criteria andOrginfGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("orginf >=", value, "orginf");
            return (Criteria) this;
        }

        public Criteria andOrginfLessThan(BigDecimal value) {
            addCriterion("orginf <", value, "orginf");
            return (Criteria) this;
        }

        public Criteria andOrginfLessThanOrEqualTo(BigDecimal value) {
            addCriterion("orginf <=", value, "orginf");
            return (Criteria) this;
        }

        public Criteria andOrginfIn(List<BigDecimal> values) {
            addCriterion("orginf in", values, "orginf");
            return (Criteria) this;
        }

        public Criteria andOrginfNotIn(List<BigDecimal> values) {
            addCriterion("orginf not in", values, "orginf");
            return (Criteria) this;
        }

        public Criteria andOrginfBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("orginf between", value1, value2, "orginf");
            return (Criteria) this;
        }

        public Criteria andOrginfNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("orginf not between", value1, value2, "orginf");
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