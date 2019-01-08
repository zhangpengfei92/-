package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CodefeesetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CodefeesetExample() {
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

        public Criteria andMarketcodeIsNull() {
            addCriterion("marketcode is null");
            return (Criteria) this;
        }

        public Criteria andMarketcodeIsNotNull() {
            addCriterion("marketcode is not null");
            return (Criteria) this;
        }

        public Criteria andMarketcodeEqualTo(Integer value) {
            addCriterion("marketcode =", value, "marketcode");
            return (Criteria) this;
        }

        public Criteria andMarketcodeNotEqualTo(Integer value) {
            addCriterion("marketcode <>", value, "marketcode");
            return (Criteria) this;
        }

        public Criteria andMarketcodeGreaterThan(Integer value) {
            addCriterion("marketcode >", value, "marketcode");
            return (Criteria) this;
        }

        public Criteria andMarketcodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("marketcode >=", value, "marketcode");
            return (Criteria) this;
        }

        public Criteria andMarketcodeLessThan(Integer value) {
            addCriterion("marketcode <", value, "marketcode");
            return (Criteria) this;
        }

        public Criteria andMarketcodeLessThanOrEqualTo(Integer value) {
            addCriterion("marketcode <=", value, "marketcode");
            return (Criteria) this;
        }

        public Criteria andMarketcodeIn(List<Integer> values) {
            addCriterion("marketcode in", values, "marketcode");
            return (Criteria) this;
        }

        public Criteria andMarketcodeNotIn(List<Integer> values) {
            addCriterion("marketcode not in", values, "marketcode");
            return (Criteria) this;
        }

        public Criteria andMarketcodeBetween(Integer value1, Integer value2) {
            addCriterion("marketcode between", value1, value2, "marketcode");
            return (Criteria) this;
        }

        public Criteria andMarketcodeNotBetween(Integer value1, Integer value2) {
            addCriterion("marketcode not between", value1, value2, "marketcode");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andHynameIsNull() {
            addCriterion("hyname is null");
            return (Criteria) this;
        }

        public Criteria andHynameIsNotNull() {
            addCriterion("hyname is not null");
            return (Criteria) this;
        }

        public Criteria andHynameEqualTo(String value) {
            addCriterion("hyname =", value, "hyname");
            return (Criteria) this;
        }

        public Criteria andHynameNotEqualTo(String value) {
            addCriterion("hyname <>", value, "hyname");
            return (Criteria) this;
        }

        public Criteria andHynameGreaterThan(String value) {
            addCriterion("hyname >", value, "hyname");
            return (Criteria) this;
        }

        public Criteria andHynameGreaterThanOrEqualTo(String value) {
            addCriterion("hyname >=", value, "hyname");
            return (Criteria) this;
        }

        public Criteria andHynameLessThan(String value) {
            addCriterion("hyname <", value, "hyname");
            return (Criteria) this;
        }

        public Criteria andHynameLessThanOrEqualTo(String value) {
            addCriterion("hyname <=", value, "hyname");
            return (Criteria) this;
        }

        public Criteria andHynameLike(String value) {
            addCriterion("hyname like", value, "hyname");
            return (Criteria) this;
        }

        public Criteria andHynameNotLike(String value) {
            addCriterion("hyname not like", value, "hyname");
            return (Criteria) this;
        }

        public Criteria andHynameIn(List<String> values) {
            addCriterion("hyname in", values, "hyname");
            return (Criteria) this;
        }

        public Criteria andHynameNotIn(List<String> values) {
            addCriterion("hyname not in", values, "hyname");
            return (Criteria) this;
        }

        public Criteria andHynameBetween(String value1, String value2) {
            addCriterion("hyname between", value1, value2, "hyname");
            return (Criteria) this;
        }

        public Criteria andHynameNotBetween(String value1, String value2) {
            addCriterion("hyname not between", value1, value2, "hyname");
            return (Criteria) this;
        }

        public Criteria andBbbzIsNull() {
            addCriterion("bbbz is null");
            return (Criteria) this;
        }

        public Criteria andBbbzIsNotNull() {
            addCriterion("bbbz is not null");
            return (Criteria) this;
        }

        public Criteria andBbbzEqualTo(BigDecimal value) {
            addCriterion("bbbz =", value, "bbbz");
            return (Criteria) this;
        }

        public Criteria andBbbzNotEqualTo(BigDecimal value) {
            addCriterion("bbbz <>", value, "bbbz");
            return (Criteria) this;
        }

        public Criteria andBbbzGreaterThan(BigDecimal value) {
            addCriterion("bbbz >", value, "bbbz");
            return (Criteria) this;
        }

        public Criteria andBbbzGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bbbz >=", value, "bbbz");
            return (Criteria) this;
        }

        public Criteria andBbbzLessThan(BigDecimal value) {
            addCriterion("bbbz <", value, "bbbz");
            return (Criteria) this;
        }

        public Criteria andBbbzLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bbbz <=", value, "bbbz");
            return (Criteria) this;
        }

        public Criteria andBbbzIn(List<BigDecimal> values) {
            addCriterion("bbbz in", values, "bbbz");
            return (Criteria) this;
        }

        public Criteria andBbbzNotIn(List<BigDecimal> values) {
            addCriterion("bbbz not in", values, "bbbz");
            return (Criteria) this;
        }

        public Criteria andBbbzBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bbbz between", value1, value2, "bbbz");
            return (Criteria) this;
        }

        public Criteria andBbbzNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bbbz not between", value1, value2, "bbbz");
            return (Criteria) this;
        }

        public Criteria andCounterfee1IsNull() {
            addCriterion("counterfee1 is null");
            return (Criteria) this;
        }

        public Criteria andCounterfee1IsNotNull() {
            addCriterion("counterfee1 is not null");
            return (Criteria) this;
        }

        public Criteria andCounterfee1EqualTo(BigDecimal value) {
            addCriterion("counterfee1 =", value, "counterfee1");
            return (Criteria) this;
        }

        public Criteria andCounterfee1NotEqualTo(BigDecimal value) {
            addCriterion("counterfee1 <>", value, "counterfee1");
            return (Criteria) this;
        }

        public Criteria andCounterfee1GreaterThan(BigDecimal value) {
            addCriterion("counterfee1 >", value, "counterfee1");
            return (Criteria) this;
        }

        public Criteria andCounterfee1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("counterfee1 >=", value, "counterfee1");
            return (Criteria) this;
        }

        public Criteria andCounterfee1LessThan(BigDecimal value) {
            addCriterion("counterfee1 <", value, "counterfee1");
            return (Criteria) this;
        }

        public Criteria andCounterfee1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("counterfee1 <=", value, "counterfee1");
            return (Criteria) this;
        }

        public Criteria andCounterfee1In(List<BigDecimal> values) {
            addCriterion("counterfee1 in", values, "counterfee1");
            return (Criteria) this;
        }

        public Criteria andCounterfee1NotIn(List<BigDecimal> values) {
            addCriterion("counterfee1 not in", values, "counterfee1");
            return (Criteria) this;
        }

        public Criteria andCounterfee1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("counterfee1 between", value1, value2, "counterfee1");
            return (Criteria) this;
        }

        public Criteria andCounterfee1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("counterfee1 not between", value1, value2, "counterfee1");
            return (Criteria) this;
        }

        public Criteria andCounterfee2IsNull() {
            addCriterion("counterfee2 is null");
            return (Criteria) this;
        }

        public Criteria andCounterfee2IsNotNull() {
            addCriterion("counterfee2 is not null");
            return (Criteria) this;
        }

        public Criteria andCounterfee2EqualTo(BigDecimal value) {
            addCriterion("counterfee2 =", value, "counterfee2");
            return (Criteria) this;
        }

        public Criteria andCounterfee2NotEqualTo(BigDecimal value) {
            addCriterion("counterfee2 <>", value, "counterfee2");
            return (Criteria) this;
        }

        public Criteria andCounterfee2GreaterThan(BigDecimal value) {
            addCriterion("counterfee2 >", value, "counterfee2");
            return (Criteria) this;
        }

        public Criteria andCounterfee2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("counterfee2 >=", value, "counterfee2");
            return (Criteria) this;
        }

        public Criteria andCounterfee2LessThan(BigDecimal value) {
            addCriterion("counterfee2 <", value, "counterfee2");
            return (Criteria) this;
        }

        public Criteria andCounterfee2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("counterfee2 <=", value, "counterfee2");
            return (Criteria) this;
        }

        public Criteria andCounterfee2In(List<BigDecimal> values) {
            addCriterion("counterfee2 in", values, "counterfee2");
            return (Criteria) this;
        }

        public Criteria andCounterfee2NotIn(List<BigDecimal> values) {
            addCriterion("counterfee2 not in", values, "counterfee2");
            return (Criteria) this;
        }

        public Criteria andCounterfee2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("counterfee2 between", value1, value2, "counterfee2");
            return (Criteria) this;
        }

        public Criteria andCounterfee2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("counterfee2 not between", value1, value2, "counterfee2");
            return (Criteria) this;
        }

        public Criteria andPcfee1IsNull() {
            addCriterion("pcfee1 is null");
            return (Criteria) this;
        }

        public Criteria andPcfee1IsNotNull() {
            addCriterion("pcfee1 is not null");
            return (Criteria) this;
        }

        public Criteria andPcfee1EqualTo(BigDecimal value) {
            addCriterion("pcfee1 =", value, "pcfee1");
            return (Criteria) this;
        }

        public Criteria andPcfee1NotEqualTo(BigDecimal value) {
            addCriterion("pcfee1 <>", value, "pcfee1");
            return (Criteria) this;
        }

        public Criteria andPcfee1GreaterThan(BigDecimal value) {
            addCriterion("pcfee1 >", value, "pcfee1");
            return (Criteria) this;
        }

        public Criteria andPcfee1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pcfee1 >=", value, "pcfee1");
            return (Criteria) this;
        }

        public Criteria andPcfee1LessThan(BigDecimal value) {
            addCriterion("pcfee1 <", value, "pcfee1");
            return (Criteria) this;
        }

        public Criteria andPcfee1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("pcfee1 <=", value, "pcfee1");
            return (Criteria) this;
        }

        public Criteria andPcfee1In(List<BigDecimal> values) {
            addCriterion("pcfee1 in", values, "pcfee1");
            return (Criteria) this;
        }

        public Criteria andPcfee1NotIn(List<BigDecimal> values) {
            addCriterion("pcfee1 not in", values, "pcfee1");
            return (Criteria) this;
        }

        public Criteria andPcfee1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("pcfee1 between", value1, value2, "pcfee1");
            return (Criteria) this;
        }

        public Criteria andPcfee1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pcfee1 not between", value1, value2, "pcfee1");
            return (Criteria) this;
        }

        public Criteria andPcfee2IsNull() {
            addCriterion("pcfee2 is null");
            return (Criteria) this;
        }

        public Criteria andPcfee2IsNotNull() {
            addCriterion("pcfee2 is not null");
            return (Criteria) this;
        }

        public Criteria andPcfee2EqualTo(BigDecimal value) {
            addCriterion("pcfee2 =", value, "pcfee2");
            return (Criteria) this;
        }

        public Criteria andPcfee2NotEqualTo(BigDecimal value) {
            addCriterion("pcfee2 <>", value, "pcfee2");
            return (Criteria) this;
        }

        public Criteria andPcfee2GreaterThan(BigDecimal value) {
            addCriterion("pcfee2 >", value, "pcfee2");
            return (Criteria) this;
        }

        public Criteria andPcfee2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pcfee2 >=", value, "pcfee2");
            return (Criteria) this;
        }

        public Criteria andPcfee2LessThan(BigDecimal value) {
            addCriterion("pcfee2 <", value, "pcfee2");
            return (Criteria) this;
        }

        public Criteria andPcfee2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("pcfee2 <=", value, "pcfee2");
            return (Criteria) this;
        }

        public Criteria andPcfee2In(List<BigDecimal> values) {
            addCriterion("pcfee2 in", values, "pcfee2");
            return (Criteria) this;
        }

        public Criteria andPcfee2NotIn(List<BigDecimal> values) {
            addCriterion("pcfee2 not in", values, "pcfee2");
            return (Criteria) this;
        }

        public Criteria andPcfee2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("pcfee2 between", value1, value2, "pcfee2");
            return (Criteria) this;
        }

        public Criteria andPcfee2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pcfee2 not between", value1, value2, "pcfee2");
            return (Criteria) this;
        }

        public Criteria andSqfsIsNull() {
            addCriterion("sqfs is null");
            return (Criteria) this;
        }

        public Criteria andSqfsIsNotNull() {
            addCriterion("sqfs is not null");
            return (Criteria) this;
        }

        public Criteria andSqfsEqualTo(Integer value) {
            addCriterion("sqfs =", value, "sqfs");
            return (Criteria) this;
        }

        public Criteria andSqfsNotEqualTo(Integer value) {
            addCriterion("sqfs <>", value, "sqfs");
            return (Criteria) this;
        }

        public Criteria andSqfsGreaterThan(Integer value) {
            addCriterion("sqfs >", value, "sqfs");
            return (Criteria) this;
        }

        public Criteria andSqfsGreaterThanOrEqualTo(Integer value) {
            addCriterion("sqfs >=", value, "sqfs");
            return (Criteria) this;
        }

        public Criteria andSqfsLessThan(Integer value) {
            addCriterion("sqfs <", value, "sqfs");
            return (Criteria) this;
        }

        public Criteria andSqfsLessThanOrEqualTo(Integer value) {
            addCriterion("sqfs <=", value, "sqfs");
            return (Criteria) this;
        }

        public Criteria andSqfsIn(List<Integer> values) {
            addCriterion("sqfs in", values, "sqfs");
            return (Criteria) this;
        }

        public Criteria andSqfsNotIn(List<Integer> values) {
            addCriterion("sqfs not in", values, "sqfs");
            return (Criteria) this;
        }

        public Criteria andSqfsBetween(Integer value1, Integer value2) {
            addCriterion("sqfs between", value1, value2, "sqfs");
            return (Criteria) this;
        }

        public Criteria andSqfsNotBetween(Integer value1, Integer value2) {
            addCriterion("sqfs not between", value1, value2, "sqfs");
            return (Criteria) this;
        }

        public Criteria andServicefeeIsNull() {
            addCriterion("servicefee is null");
            return (Criteria) this;
        }

        public Criteria andServicefeeIsNotNull() {
            addCriterion("servicefee is not null");
            return (Criteria) this;
        }

        public Criteria andServicefeeEqualTo(BigDecimal value) {
            addCriterion("servicefee =", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeNotEqualTo(BigDecimal value) {
            addCriterion("servicefee <>", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeGreaterThan(BigDecimal value) {
            addCriterion("servicefee >", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("servicefee >=", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeLessThan(BigDecimal value) {
            addCriterion("servicefee <", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("servicefee <=", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeIn(List<BigDecimal> values) {
            addCriterion("servicefee in", values, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeNotIn(List<BigDecimal> values) {
            addCriterion("servicefee not in", values, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("servicefee between", value1, value2, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("servicefee not between", value1, value2, "servicefee");
            return (Criteria) this;
        }

        public Criteria andGjwhgylxIsNull() {
            addCriterion("gjwhgylx is null");
            return (Criteria) this;
        }

        public Criteria andGjwhgylxIsNotNull() {
            addCriterion("gjwhgylx is not null");
            return (Criteria) this;
        }

        public Criteria andGjwhgylxEqualTo(BigDecimal value) {
            addCriterion("gjwhgylx =", value, "gjwhgylx");
            return (Criteria) this;
        }

        public Criteria andGjwhgylxNotEqualTo(BigDecimal value) {
            addCriterion("gjwhgylx <>", value, "gjwhgylx");
            return (Criteria) this;
        }

        public Criteria andGjwhgylxGreaterThan(BigDecimal value) {
            addCriterion("gjwhgylx >", value, "gjwhgylx");
            return (Criteria) this;
        }

        public Criteria andGjwhgylxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gjwhgylx >=", value, "gjwhgylx");
            return (Criteria) this;
        }

        public Criteria andGjwhgylxLessThan(BigDecimal value) {
            addCriterion("gjwhgylx <", value, "gjwhgylx");
            return (Criteria) this;
        }

        public Criteria andGjwhgylxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gjwhgylx <=", value, "gjwhgylx");
            return (Criteria) this;
        }

        public Criteria andGjwhgylxIn(List<BigDecimal> values) {
            addCriterion("gjwhgylx in", values, "gjwhgylx");
            return (Criteria) this;
        }

        public Criteria andGjwhgylxNotIn(List<BigDecimal> values) {
            addCriterion("gjwhgylx not in", values, "gjwhgylx");
            return (Criteria) this;
        }

        public Criteria andGjwhgylxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gjwhgylx between", value1, value2, "gjwhgylx");
            return (Criteria) this;
        }

        public Criteria andGjwhgylxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gjwhgylx not between", value1, value2, "gjwhgylx");
            return (Criteria) this;
        }

        public Criteria andBzjIsNull() {
            addCriterion("bzj is null");
            return (Criteria) this;
        }

        public Criteria andBzjIsNotNull() {
            addCriterion("bzj is not null");
            return (Criteria) this;
        }

        public Criteria andBzjEqualTo(BigDecimal value) {
            addCriterion("bzj =", value, "bzj");
            return (Criteria) this;
        }

        public Criteria andBzjNotEqualTo(BigDecimal value) {
            addCriterion("bzj <>", value, "bzj");
            return (Criteria) this;
        }

        public Criteria andBzjGreaterThan(BigDecimal value) {
            addCriterion("bzj >", value, "bzj");
            return (Criteria) this;
        }

        public Criteria andBzjGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bzj >=", value, "bzj");
            return (Criteria) this;
        }

        public Criteria andBzjLessThan(BigDecimal value) {
            addCriterion("bzj <", value, "bzj");
            return (Criteria) this;
        }

        public Criteria andBzjLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bzj <=", value, "bzj");
            return (Criteria) this;
        }

        public Criteria andBzjIn(List<BigDecimal> values) {
            addCriterion("bzj in", values, "bzj");
            return (Criteria) this;
        }

        public Criteria andBzjNotIn(List<BigDecimal> values) {
            addCriterion("bzj not in", values, "bzj");
            return (Criteria) this;
        }

        public Criteria andBzjBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bzj between", value1, value2, "bzj");
            return (Criteria) this;
        }

        public Criteria andBzjNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bzj not between", value1, value2, "bzj");
            return (Criteria) this;
        }

        public Criteria andParentidIsNull() {
            addCriterion("parentId is null");
            return (Criteria) this;
        }

        public Criteria andParentidIsNotNull() {
            addCriterion("parentId is not null");
            return (Criteria) this;
        }

        public Criteria andParentidEqualTo(Integer value) {
            addCriterion("parentId =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(Integer value) {
            addCriterion("parentId <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(Integer value) {
            addCriterion("parentId >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("parentId >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(Integer value) {
            addCriterion("parentId <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(Integer value) {
            addCriterion("parentId <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<Integer> values) {
            addCriterion("parentId in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<Integer> values) {
            addCriterion("parentId not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(Integer value1, Integer value2) {
            addCriterion("parentId between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(Integer value1, Integer value2) {
            addCriterion("parentId not between", value1, value2, "parentid");
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

        public Criteria andBzEqualTo(String value) {
            addCriterion("bz =", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotEqualTo(String value) {
            addCriterion("bz <>", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThan(String value) {
            addCriterion("bz >", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThanOrEqualTo(String value) {
            addCriterion("bz >=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThan(String value) {
            addCriterion("bz <", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThanOrEqualTo(String value) {
            addCriterion("bz <=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLike(String value) {
            addCriterion("bz like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotLike(String value) {
            addCriterion("bz not like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzIn(List<String> values) {
            addCriterion("bz in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotIn(List<String> values) {
            addCriterion("bz not in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzBetween(String value1, String value2) {
            addCriterion("bz between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotBetween(String value1, String value2) {
            addCriterion("bz not between", value1, value2, "bz");
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

        public Criteria andPcamountfee1IsNull() {
            addCriterion("pcAmountfee1 is null");
            return (Criteria) this;
        }

        public Criteria andPcamountfee1IsNotNull() {
            addCriterion("pcAmountfee1 is not null");
            return (Criteria) this;
        }

        public Criteria andPcamountfee1EqualTo(BigDecimal value) {
            addCriterion("pcAmountfee1 =", value, "pcamountfee1");
            return (Criteria) this;
        }

        public Criteria andPcamountfee1NotEqualTo(BigDecimal value) {
            addCriterion("pcAmountfee1 <>", value, "pcamountfee1");
            return (Criteria) this;
        }

        public Criteria andPcamountfee1GreaterThan(BigDecimal value) {
            addCriterion("pcAmountfee1 >", value, "pcamountfee1");
            return (Criteria) this;
        }

        public Criteria andPcamountfee1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pcAmountfee1 >=", value, "pcamountfee1");
            return (Criteria) this;
        }

        public Criteria andPcamountfee1LessThan(BigDecimal value) {
            addCriterion("pcAmountfee1 <", value, "pcamountfee1");
            return (Criteria) this;
        }

        public Criteria andPcamountfee1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("pcAmountfee1 <=", value, "pcamountfee1");
            return (Criteria) this;
        }

        public Criteria andPcamountfee1In(List<BigDecimal> values) {
            addCriterion("pcAmountfee1 in", values, "pcamountfee1");
            return (Criteria) this;
        }

        public Criteria andPcamountfee1NotIn(List<BigDecimal> values) {
            addCriterion("pcAmountfee1 not in", values, "pcamountfee1");
            return (Criteria) this;
        }

        public Criteria andPcamountfee1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("pcAmountfee1 between", value1, value2, "pcamountfee1");
            return (Criteria) this;
        }

        public Criteria andPcamountfee1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pcAmountfee1 not between", value1, value2, "pcamountfee1");
            return (Criteria) this;
        }

        public Criteria andPcamountfee2IsNull() {
            addCriterion("pcAmountfee2 is null");
            return (Criteria) this;
        }

        public Criteria andPcamountfee2IsNotNull() {
            addCriterion("pcAmountfee2 is not null");
            return (Criteria) this;
        }

        public Criteria andPcamountfee2EqualTo(BigDecimal value) {
            addCriterion("pcAmountfee2 =", value, "pcamountfee2");
            return (Criteria) this;
        }

        public Criteria andPcamountfee2NotEqualTo(BigDecimal value) {
            addCriterion("pcAmountfee2 <>", value, "pcamountfee2");
            return (Criteria) this;
        }

        public Criteria andPcamountfee2GreaterThan(BigDecimal value) {
            addCriterion("pcAmountfee2 >", value, "pcamountfee2");
            return (Criteria) this;
        }

        public Criteria andPcamountfee2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pcAmountfee2 >=", value, "pcamountfee2");
            return (Criteria) this;
        }

        public Criteria andPcamountfee2LessThan(BigDecimal value) {
            addCriterion("pcAmountfee2 <", value, "pcamountfee2");
            return (Criteria) this;
        }

        public Criteria andPcamountfee2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("pcAmountfee2 <=", value, "pcamountfee2");
            return (Criteria) this;
        }

        public Criteria andPcamountfee2In(List<BigDecimal> values) {
            addCriterion("pcAmountfee2 in", values, "pcamountfee2");
            return (Criteria) this;
        }

        public Criteria andPcamountfee2NotIn(List<BigDecimal> values) {
            addCriterion("pcAmountfee2 not in", values, "pcamountfee2");
            return (Criteria) this;
        }

        public Criteria andPcamountfee2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("pcAmountfee2 between", value1, value2, "pcamountfee2");
            return (Criteria) this;
        }

        public Criteria andPcamountfee2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pcAmountfee2 not between", value1, value2, "pcamountfee2");
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