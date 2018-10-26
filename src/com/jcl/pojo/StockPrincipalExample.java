package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockPrincipalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StockPrincipalExample() {
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

        public Criteria andRightstypeIsNull() {
            addCriterion("rightstype is null");
            return (Criteria) this;
        }

        public Criteria andRightstypeIsNotNull() {
            addCriterion("rightstype is not null");
            return (Criteria) this;
        }

        public Criteria andRightstypeEqualTo(String value) {
            addCriterion("rightstype =", value, "rightstype");
            return (Criteria) this;
        }

        public Criteria andRightstypeNotEqualTo(String value) {
            addCriterion("rightstype <>", value, "rightstype");
            return (Criteria) this;
        }

        public Criteria andRightstypeGreaterThan(String value) {
            addCriterion("rightstype >", value, "rightstype");
            return (Criteria) this;
        }

        public Criteria andRightstypeGreaterThanOrEqualTo(String value) {
            addCriterion("rightstype >=", value, "rightstype");
            return (Criteria) this;
        }

        public Criteria andRightstypeLessThan(String value) {
            addCriterion("rightstype <", value, "rightstype");
            return (Criteria) this;
        }

        public Criteria andRightstypeLessThanOrEqualTo(String value) {
            addCriterion("rightstype <=", value, "rightstype");
            return (Criteria) this;
        }

        public Criteria andRightstypeLike(String value) {
            addCriterion("rightstype like", value, "rightstype");
            return (Criteria) this;
        }

        public Criteria andRightstypeNotLike(String value) {
            addCriterion("rightstype not like", value, "rightstype");
            return (Criteria) this;
        }

        public Criteria andRightstypeIn(List<String> values) {
            addCriterion("rightstype in", values, "rightstype");
            return (Criteria) this;
        }

        public Criteria andRightstypeNotIn(List<String> values) {
            addCriterion("rightstype not in", values, "rightstype");
            return (Criteria) this;
        }

        public Criteria andRightstypeBetween(String value1, String value2) {
            addCriterion("rightstype between", value1, value2, "rightstype");
            return (Criteria) this;
        }

        public Criteria andRightstypeNotBetween(String value1, String value2) {
            addCriterion("rightstype not between", value1, value2, "rightstype");
            return (Criteria) this;
        }

        public Criteria andDealwayIsNull() {
            addCriterion("dealway is null");
            return (Criteria) this;
        }

        public Criteria andDealwayIsNotNull() {
            addCriterion("dealway is not null");
            return (Criteria) this;
        }

        public Criteria andDealwayEqualTo(String value) {
            addCriterion("dealway =", value, "dealway");
            return (Criteria) this;
        }

        public Criteria andDealwayNotEqualTo(String value) {
            addCriterion("dealway <>", value, "dealway");
            return (Criteria) this;
        }

        public Criteria andDealwayGreaterThan(String value) {
            addCriterion("dealway >", value, "dealway");
            return (Criteria) this;
        }

        public Criteria andDealwayGreaterThanOrEqualTo(String value) {
            addCriterion("dealway >=", value, "dealway");
            return (Criteria) this;
        }

        public Criteria andDealwayLessThan(String value) {
            addCriterion("dealway <", value, "dealway");
            return (Criteria) this;
        }

        public Criteria andDealwayLessThanOrEqualTo(String value) {
            addCriterion("dealway <=", value, "dealway");
            return (Criteria) this;
        }

        public Criteria andDealwayLike(String value) {
            addCriterion("dealway like", value, "dealway");
            return (Criteria) this;
        }

        public Criteria andDealwayNotLike(String value) {
            addCriterion("dealway not like", value, "dealway");
            return (Criteria) this;
        }

        public Criteria andDealwayIn(List<String> values) {
            addCriterion("dealway in", values, "dealway");
            return (Criteria) this;
        }

        public Criteria andDealwayNotIn(List<String> values) {
            addCriterion("dealway not in", values, "dealway");
            return (Criteria) this;
        }

        public Criteria andDealwayBetween(String value1, String value2) {
            addCriterion("dealway between", value1, value2, "dealway");
            return (Criteria) this;
        }

        public Criteria andDealwayNotBetween(String value1, String value2) {
            addCriterion("dealway not between", value1, value2, "dealway");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNull() {
            addCriterion("addtime is null");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNotNull() {
            addCriterion("addtime is not null");
            return (Criteria) this;
        }

        public Criteria andAddtimeEqualTo(Date value) {
            addCriterion("addtime =", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotEqualTo(Date value) {
            addCriterion("addtime <>", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThan(Date value) {
            addCriterion("addtime >", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("addtime >=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThan(Date value) {
            addCriterion("addtime <", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThanOrEqualTo(Date value) {
            addCriterion("addtime <=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeIn(List<Date> values) {
            addCriterion("addtime in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotIn(List<Date> values) {
            addCriterion("addtime not in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeBetween(Date value1, Date value2) {
            addCriterion("addtime between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotBetween(Date value1, Date value2) {
            addCriterion("addtime not between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andValidtimeIsNull() {
            addCriterion("validtime is null");
            return (Criteria) this;
        }

        public Criteria andValidtimeIsNotNull() {
            addCriterion("validtime is not null");
            return (Criteria) this;
        }

        public Criteria andValidtimeEqualTo(Date value) {
            addCriterion("validtime =", value, "validtime");
            return (Criteria) this;
        }

        public Criteria andValidtimeNotEqualTo(Date value) {
            addCriterion("validtime <>", value, "validtime");
            return (Criteria) this;
        }

        public Criteria andValidtimeGreaterThan(Date value) {
            addCriterion("validtime >", value, "validtime");
            return (Criteria) this;
        }

        public Criteria andValidtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("validtime >=", value, "validtime");
            return (Criteria) this;
        }

        public Criteria andValidtimeLessThan(Date value) {
            addCriterion("validtime <", value, "validtime");
            return (Criteria) this;
        }

        public Criteria andValidtimeLessThanOrEqualTo(Date value) {
            addCriterion("validtime <=", value, "validtime");
            return (Criteria) this;
        }

        public Criteria andValidtimeIn(List<Date> values) {
            addCriterion("validtime in", values, "validtime");
            return (Criteria) this;
        }

        public Criteria andValidtimeNotIn(List<Date> values) {
            addCriterion("validtime not in", values, "validtime");
            return (Criteria) this;
        }

        public Criteria andValidtimeBetween(Date value1, Date value2) {
            addCriterion("validtime between", value1, value2, "validtime");
            return (Criteria) this;
        }

        public Criteria andValidtimeNotBetween(Date value1, Date value2) {
            addCriterion("validtime not between", value1, value2, "validtime");
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

        public Criteria andRealpriceIsNull() {
            addCriterion("realPrice is null");
            return (Criteria) this;
        }

        public Criteria andRealpriceIsNotNull() {
            addCriterion("realPrice is not null");
            return (Criteria) this;
        }

        public Criteria andRealpriceEqualTo(BigDecimal value) {
            addCriterion("realPrice =", value, "realprice");
            return (Criteria) this;
        }

        public Criteria andRealpriceNotEqualTo(BigDecimal value) {
            addCriterion("realPrice <>", value, "realprice");
            return (Criteria) this;
        }

        public Criteria andRealpriceGreaterThan(BigDecimal value) {
            addCriterion("realPrice >", value, "realprice");
            return (Criteria) this;
        }

        public Criteria andRealpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("realPrice >=", value, "realprice");
            return (Criteria) this;
        }

        public Criteria andRealpriceLessThan(BigDecimal value) {
            addCriterion("realPrice <", value, "realprice");
            return (Criteria) this;
        }

        public Criteria andRealpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("realPrice <=", value, "realprice");
            return (Criteria) this;
        }

        public Criteria andRealpriceIn(List<BigDecimal> values) {
            addCriterion("realPrice in", values, "realprice");
            return (Criteria) this;
        }

        public Criteria andRealpriceNotIn(List<BigDecimal> values) {
            addCriterion("realPrice not in", values, "realprice");
            return (Criteria) this;
        }

        public Criteria andRealpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("realPrice between", value1, value2, "realprice");
            return (Criteria) this;
        }

        public Criteria andRealpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("realPrice not between", value1, value2, "realprice");
            return (Criteria) this;
        }

        public Criteria andExchangetypeIsNull() {
            addCriterion("exchangetype is null");
            return (Criteria) this;
        }

        public Criteria andExchangetypeIsNotNull() {
            addCriterion("exchangetype is not null");
            return (Criteria) this;
        }

        public Criteria andExchangetypeEqualTo(String value) {
            addCriterion("exchangetype =", value, "exchangetype");
            return (Criteria) this;
        }

        public Criteria andExchangetypeNotEqualTo(String value) {
            addCriterion("exchangetype <>", value, "exchangetype");
            return (Criteria) this;
        }

        public Criteria andExchangetypeGreaterThan(String value) {
            addCriterion("exchangetype >", value, "exchangetype");
            return (Criteria) this;
        }

        public Criteria andExchangetypeGreaterThanOrEqualTo(String value) {
            addCriterion("exchangetype >=", value, "exchangetype");
            return (Criteria) this;
        }

        public Criteria andExchangetypeLessThan(String value) {
            addCriterion("exchangetype <", value, "exchangetype");
            return (Criteria) this;
        }

        public Criteria andExchangetypeLessThanOrEqualTo(String value) {
            addCriterion("exchangetype <=", value, "exchangetype");
            return (Criteria) this;
        }

        public Criteria andExchangetypeLike(String value) {
            addCriterion("exchangetype like", value, "exchangetype");
            return (Criteria) this;
        }

        public Criteria andExchangetypeNotLike(String value) {
            addCriterion("exchangetype not like", value, "exchangetype");
            return (Criteria) this;
        }

        public Criteria andExchangetypeIn(List<String> values) {
            addCriterion("exchangetype in", values, "exchangetype");
            return (Criteria) this;
        }

        public Criteria andExchangetypeNotIn(List<String> values) {
            addCriterion("exchangetype not in", values, "exchangetype");
            return (Criteria) this;
        }

        public Criteria andExchangetypeBetween(String value1, String value2) {
            addCriterion("exchangetype between", value1, value2, "exchangetype");
            return (Criteria) this;
        }

        public Criteria andExchangetypeNotBetween(String value1, String value2) {
            addCriterion("exchangetype not between", value1, value2, "exchangetype");
            return (Criteria) this;
        }

        public Criteria andEnquirytypeIsNull() {
            addCriterion("enquirytype is null");
            return (Criteria) this;
        }

        public Criteria andEnquirytypeIsNotNull() {
            addCriterion("enquirytype is not null");
            return (Criteria) this;
        }

        public Criteria andEnquirytypeEqualTo(String value) {
            addCriterion("enquirytype =", value, "enquirytype");
            return (Criteria) this;
        }

        public Criteria andEnquirytypeNotEqualTo(String value) {
            addCriterion("enquirytype <>", value, "enquirytype");
            return (Criteria) this;
        }

        public Criteria andEnquirytypeGreaterThan(String value) {
            addCriterion("enquirytype >", value, "enquirytype");
            return (Criteria) this;
        }

        public Criteria andEnquirytypeGreaterThanOrEqualTo(String value) {
            addCriterion("enquirytype >=", value, "enquirytype");
            return (Criteria) this;
        }

        public Criteria andEnquirytypeLessThan(String value) {
            addCriterion("enquirytype <", value, "enquirytype");
            return (Criteria) this;
        }

        public Criteria andEnquirytypeLessThanOrEqualTo(String value) {
            addCriterion("enquirytype <=", value, "enquirytype");
            return (Criteria) this;
        }

        public Criteria andEnquirytypeLike(String value) {
            addCriterion("enquirytype like", value, "enquirytype");
            return (Criteria) this;
        }

        public Criteria andEnquirytypeNotLike(String value) {
            addCriterion("enquirytype not like", value, "enquirytype");
            return (Criteria) this;
        }

        public Criteria andEnquirytypeIn(List<String> values) {
            addCriterion("enquirytype in", values, "enquirytype");
            return (Criteria) this;
        }

        public Criteria andEnquirytypeNotIn(List<String> values) {
            addCriterion("enquirytype not in", values, "enquirytype");
            return (Criteria) this;
        }

        public Criteria andEnquirytypeBetween(String value1, String value2) {
            addCriterion("enquirytype between", value1, value2, "enquirytype");
            return (Criteria) this;
        }

        public Criteria andEnquirytypeNotBetween(String value1, String value2) {
            addCriterion("enquirytype not between", value1, value2, "enquirytype");
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

        public Criteria andOidIsNull() {
            addCriterion("oid is null");
            return (Criteria) this;
        }

        public Criteria andOidIsNotNull() {
            addCriterion("oid is not null");
            return (Criteria) this;
        }

        public Criteria andOidEqualTo(String value) {
            addCriterion("oid =", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotEqualTo(String value) {
            addCriterion("oid <>", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThan(String value) {
            addCriterion("oid >", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThanOrEqualTo(String value) {
            addCriterion("oid >=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThan(String value) {
            addCriterion("oid <", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThanOrEqualTo(String value) {
            addCriterion("oid <=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLike(String value) {
            addCriterion("oid like", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotLike(String value) {
            addCriterion("oid not like", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidIn(List<String> values) {
            addCriterion("oid in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotIn(List<String> values) {
            addCriterion("oid not in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidBetween(String value1, String value2) {
            addCriterion("oid between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotBetween(String value1, String value2) {
            addCriterion("oid not between", value1, value2, "oid");
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