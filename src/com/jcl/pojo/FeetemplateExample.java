package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FeetemplateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FeetemplateExample() {
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

        public Criteria andScIsNull() {
            addCriterion("sc is null");
            return (Criteria) this;
        }

        public Criteria andScIsNotNull() {
            addCriterion("sc is not null");
            return (Criteria) this;
        }

        public Criteria andScEqualTo(Integer value) {
            addCriterion("sc =", value, "sc");
            return (Criteria) this;
        }

        public Criteria andScNotEqualTo(Integer value) {
            addCriterion("sc <>", value, "sc");
            return (Criteria) this;
        }

        public Criteria andScGreaterThan(Integer value) {
            addCriterion("sc >", value, "sc");
            return (Criteria) this;
        }

        public Criteria andScGreaterThanOrEqualTo(Integer value) {
            addCriterion("sc >=", value, "sc");
            return (Criteria) this;
        }

        public Criteria andScLessThan(Integer value) {
            addCriterion("sc <", value, "sc");
            return (Criteria) this;
        }

        public Criteria andScLessThanOrEqualTo(Integer value) {
            addCriterion("sc <=", value, "sc");
            return (Criteria) this;
        }

        public Criteria andScIn(List<Integer> values) {
            addCriterion("sc in", values, "sc");
            return (Criteria) this;
        }

        public Criteria andScNotIn(List<Integer> values) {
            addCriterion("sc not in", values, "sc");
            return (Criteria) this;
        }

        public Criteria andScBetween(Integer value1, Integer value2) {
            addCriterion("sc between", value1, value2, "sc");
            return (Criteria) this;
        }

        public Criteria andScNotBetween(Integer value1, Integer value2) {
            addCriterion("sc not between", value1, value2, "sc");
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

        public Criteria andJgratioIsNull() {
            addCriterion("jgratio is null");
            return (Criteria) this;
        }

        public Criteria andJgratioIsNotNull() {
            addCriterion("jgratio is not null");
            return (Criteria) this;
        }

        public Criteria andJgratioEqualTo(BigDecimal value) {
            addCriterion("jgratio =", value, "jgratio");
            return (Criteria) this;
        }

        public Criteria andJgratioNotEqualTo(BigDecimal value) {
            addCriterion("jgratio <>", value, "jgratio");
            return (Criteria) this;
        }

        public Criteria andJgratioGreaterThan(BigDecimal value) {
            addCriterion("jgratio >", value, "jgratio");
            return (Criteria) this;
        }

        public Criteria andJgratioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("jgratio >=", value, "jgratio");
            return (Criteria) this;
        }

        public Criteria andJgratioLessThan(BigDecimal value) {
            addCriterion("jgratio <", value, "jgratio");
            return (Criteria) this;
        }

        public Criteria andJgratioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("jgratio <=", value, "jgratio");
            return (Criteria) this;
        }

        public Criteria andJgratioIn(List<BigDecimal> values) {
            addCriterion("jgratio in", values, "jgratio");
            return (Criteria) this;
        }

        public Criteria andJgratioNotIn(List<BigDecimal> values) {
            addCriterion("jgratio not in", values, "jgratio");
            return (Criteria) this;
        }

        public Criteria andJgratioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jgratio between", value1, value2, "jgratio");
            return (Criteria) this;
        }

        public Criteria andJgratioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jgratio not between", value1, value2, "jgratio");
            return (Criteria) this;
        }

        public Criteria andQdratioIsNull() {
            addCriterion("qdratio is null");
            return (Criteria) this;
        }

        public Criteria andQdratioIsNotNull() {
            addCriterion("qdratio is not null");
            return (Criteria) this;
        }

        public Criteria andQdratioEqualTo(BigDecimal value) {
            addCriterion("qdratio =", value, "qdratio");
            return (Criteria) this;
        }

        public Criteria andQdratioNotEqualTo(BigDecimal value) {
            addCriterion("qdratio <>", value, "qdratio");
            return (Criteria) this;
        }

        public Criteria andQdratioGreaterThan(BigDecimal value) {
            addCriterion("qdratio >", value, "qdratio");
            return (Criteria) this;
        }

        public Criteria andQdratioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("qdratio >=", value, "qdratio");
            return (Criteria) this;
        }

        public Criteria andQdratioLessThan(BigDecimal value) {
            addCriterion("qdratio <", value, "qdratio");
            return (Criteria) this;
        }

        public Criteria andQdratioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("qdratio <=", value, "qdratio");
            return (Criteria) this;
        }

        public Criteria andQdratioIn(List<BigDecimal> values) {
            addCriterion("qdratio in", values, "qdratio");
            return (Criteria) this;
        }

        public Criteria andQdratioNotIn(List<BigDecimal> values) {
            addCriterion("qdratio not in", values, "qdratio");
            return (Criteria) this;
        }

        public Criteria andQdratioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("qdratio between", value1, value2, "qdratio");
            return (Criteria) this;
        }

        public Criteria andQdratioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("qdratio not between", value1, value2, "qdratio");
            return (Criteria) this;
        }

        public Criteria andDlsratioIsNull() {
            addCriterion("dlsratio is null");
            return (Criteria) this;
        }

        public Criteria andDlsratioIsNotNull() {
            addCriterion("dlsratio is not null");
            return (Criteria) this;
        }

        public Criteria andDlsratioEqualTo(BigDecimal value) {
            addCriterion("dlsratio =", value, "dlsratio");
            return (Criteria) this;
        }

        public Criteria andDlsratioNotEqualTo(BigDecimal value) {
            addCriterion("dlsratio <>", value, "dlsratio");
            return (Criteria) this;
        }

        public Criteria andDlsratioGreaterThan(BigDecimal value) {
            addCriterion("dlsratio >", value, "dlsratio");
            return (Criteria) this;
        }

        public Criteria andDlsratioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dlsratio >=", value, "dlsratio");
            return (Criteria) this;
        }

        public Criteria andDlsratioLessThan(BigDecimal value) {
            addCriterion("dlsratio <", value, "dlsratio");
            return (Criteria) this;
        }

        public Criteria andDlsratioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dlsratio <=", value, "dlsratio");
            return (Criteria) this;
        }

        public Criteria andDlsratioIn(List<BigDecimal> values) {
            addCriterion("dlsratio in", values, "dlsratio");
            return (Criteria) this;
        }

        public Criteria andDlsratioNotIn(List<BigDecimal> values) {
            addCriterion("dlsratio not in", values, "dlsratio");
            return (Criteria) this;
        }

        public Criteria andDlsratioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dlsratio between", value1, value2, "dlsratio");
            return (Criteria) this;
        }

        public Criteria andDlsratioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dlsratio not between", value1, value2, "dlsratio");
            return (Criteria) this;
        }

        public Criteria andJjrratioIsNull() {
            addCriterion("jjrratio is null");
            return (Criteria) this;
        }

        public Criteria andJjrratioIsNotNull() {
            addCriterion("jjrratio is not null");
            return (Criteria) this;
        }

        public Criteria andJjrratioEqualTo(BigDecimal value) {
            addCriterion("jjrratio =", value, "jjrratio");
            return (Criteria) this;
        }

        public Criteria andJjrratioNotEqualTo(BigDecimal value) {
            addCriterion("jjrratio <>", value, "jjrratio");
            return (Criteria) this;
        }

        public Criteria andJjrratioGreaterThan(BigDecimal value) {
            addCriterion("jjrratio >", value, "jjrratio");
            return (Criteria) this;
        }

        public Criteria andJjrratioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("jjrratio >=", value, "jjrratio");
            return (Criteria) this;
        }

        public Criteria andJjrratioLessThan(BigDecimal value) {
            addCriterion("jjrratio <", value, "jjrratio");
            return (Criteria) this;
        }

        public Criteria andJjrratioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("jjrratio <=", value, "jjrratio");
            return (Criteria) this;
        }

        public Criteria andJjrratioIn(List<BigDecimal> values) {
            addCriterion("jjrratio in", values, "jjrratio");
            return (Criteria) this;
        }

        public Criteria andJjrratioNotIn(List<BigDecimal> values) {
            addCriterion("jjrratio not in", values, "jjrratio");
            return (Criteria) this;
        }

        public Criteria andJjrratioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jjrratio between", value1, value2, "jjrratio");
            return (Criteria) this;
        }

        public Criteria andJjrratioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jjrratio not between", value1, value2, "jjrratio");
            return (Criteria) this;
        }

        public Criteria andTldtbzj1IsNull() {
            addCriterion("tldtbzj1 is null");
            return (Criteria) this;
        }

        public Criteria andTldtbzj1IsNotNull() {
            addCriterion("tldtbzj1 is not null");
            return (Criteria) this;
        }

        public Criteria andTldtbzj1EqualTo(BigDecimal value) {
            addCriterion("tldtbzj1 =", value, "tldtbzj1");
            return (Criteria) this;
        }

        public Criteria andTldtbzj1NotEqualTo(BigDecimal value) {
            addCriterion("tldtbzj1 <>", value, "tldtbzj1");
            return (Criteria) this;
        }

        public Criteria andTldtbzj1GreaterThan(BigDecimal value) {
            addCriterion("tldtbzj1 >", value, "tldtbzj1");
            return (Criteria) this;
        }

        public Criteria andTldtbzj1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tldtbzj1 >=", value, "tldtbzj1");
            return (Criteria) this;
        }

        public Criteria andTldtbzj1LessThan(BigDecimal value) {
            addCriterion("tldtbzj1 <", value, "tldtbzj1");
            return (Criteria) this;
        }

        public Criteria andTldtbzj1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("tldtbzj1 <=", value, "tldtbzj1");
            return (Criteria) this;
        }

        public Criteria andTldtbzj1In(List<BigDecimal> values) {
            addCriterion("tldtbzj1 in", values, "tldtbzj1");
            return (Criteria) this;
        }

        public Criteria andTldtbzj1NotIn(List<BigDecimal> values) {
            addCriterion("tldtbzj1 not in", values, "tldtbzj1");
            return (Criteria) this;
        }

        public Criteria andTldtbzj1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("tldtbzj1 between", value1, value2, "tldtbzj1");
            return (Criteria) this;
        }

        public Criteria andTldtbzj1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tldtbzj1 not between", value1, value2, "tldtbzj1");
            return (Criteria) this;
        }

        public Criteria andTldtbzj2IsNull() {
            addCriterion("tldtbzj2 is null");
            return (Criteria) this;
        }

        public Criteria andTldtbzj2IsNotNull() {
            addCriterion("tldtbzj2 is not null");
            return (Criteria) this;
        }

        public Criteria andTldtbzj2EqualTo(BigDecimal value) {
            addCriterion("tldtbzj2 =", value, "tldtbzj2");
            return (Criteria) this;
        }

        public Criteria andTldtbzj2NotEqualTo(BigDecimal value) {
            addCriterion("tldtbzj2 <>", value, "tldtbzj2");
            return (Criteria) this;
        }

        public Criteria andTldtbzj2GreaterThan(BigDecimal value) {
            addCriterion("tldtbzj2 >", value, "tldtbzj2");
            return (Criteria) this;
        }

        public Criteria andTldtbzj2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tldtbzj2 >=", value, "tldtbzj2");
            return (Criteria) this;
        }

        public Criteria andTldtbzj2LessThan(BigDecimal value) {
            addCriterion("tldtbzj2 <", value, "tldtbzj2");
            return (Criteria) this;
        }

        public Criteria andTldtbzj2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("tldtbzj2 <=", value, "tldtbzj2");
            return (Criteria) this;
        }

        public Criteria andTldtbzj2In(List<BigDecimal> values) {
            addCriterion("tldtbzj2 in", values, "tldtbzj2");
            return (Criteria) this;
        }

        public Criteria andTldtbzj2NotIn(List<BigDecimal> values) {
            addCriterion("tldtbzj2 not in", values, "tldtbzj2");
            return (Criteria) this;
        }

        public Criteria andTldtbzj2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("tldtbzj2 between", value1, value2, "tldtbzj2");
            return (Criteria) this;
        }

        public Criteria andTldtbzj2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tldtbzj2 not between", value1, value2, "tldtbzj2");
            return (Criteria) this;
        }

        public Criteria andTlktbzj1IsNull() {
            addCriterion("tlktbzj1 is null");
            return (Criteria) this;
        }

        public Criteria andTlktbzj1IsNotNull() {
            addCriterion("tlktbzj1 is not null");
            return (Criteria) this;
        }

        public Criteria andTlktbzj1EqualTo(BigDecimal value) {
            addCriterion("tlktbzj1 =", value, "tlktbzj1");
            return (Criteria) this;
        }

        public Criteria andTlktbzj1NotEqualTo(BigDecimal value) {
            addCriterion("tlktbzj1 <>", value, "tlktbzj1");
            return (Criteria) this;
        }

        public Criteria andTlktbzj1GreaterThan(BigDecimal value) {
            addCriterion("tlktbzj1 >", value, "tlktbzj1");
            return (Criteria) this;
        }

        public Criteria andTlktbzj1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tlktbzj1 >=", value, "tlktbzj1");
            return (Criteria) this;
        }

        public Criteria andTlktbzj1LessThan(BigDecimal value) {
            addCriterion("tlktbzj1 <", value, "tlktbzj1");
            return (Criteria) this;
        }

        public Criteria andTlktbzj1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("tlktbzj1 <=", value, "tlktbzj1");
            return (Criteria) this;
        }

        public Criteria andTlktbzj1In(List<BigDecimal> values) {
            addCriterion("tlktbzj1 in", values, "tlktbzj1");
            return (Criteria) this;
        }

        public Criteria andTlktbzj1NotIn(List<BigDecimal> values) {
            addCriterion("tlktbzj1 not in", values, "tlktbzj1");
            return (Criteria) this;
        }

        public Criteria andTlktbzj1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("tlktbzj1 between", value1, value2, "tlktbzj1");
            return (Criteria) this;
        }

        public Criteria andTlktbzj1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tlktbzj1 not between", value1, value2, "tlktbzj1");
            return (Criteria) this;
        }

        public Criteria andTlktbzj2IsNull() {
            addCriterion("tlktbzj2 is null");
            return (Criteria) this;
        }

        public Criteria andTlktbzj2IsNotNull() {
            addCriterion("tlktbzj2 is not null");
            return (Criteria) this;
        }

        public Criteria andTlktbzj2EqualTo(BigDecimal value) {
            addCriterion("tlktbzj2 =", value, "tlktbzj2");
            return (Criteria) this;
        }

        public Criteria andTlktbzj2NotEqualTo(BigDecimal value) {
            addCriterion("tlktbzj2 <>", value, "tlktbzj2");
            return (Criteria) this;
        }

        public Criteria andTlktbzj2GreaterThan(BigDecimal value) {
            addCriterion("tlktbzj2 >", value, "tlktbzj2");
            return (Criteria) this;
        }

        public Criteria andTlktbzj2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tlktbzj2 >=", value, "tlktbzj2");
            return (Criteria) this;
        }

        public Criteria andTlktbzj2LessThan(BigDecimal value) {
            addCriterion("tlktbzj2 <", value, "tlktbzj2");
            return (Criteria) this;
        }

        public Criteria andTlktbzj2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("tlktbzj2 <=", value, "tlktbzj2");
            return (Criteria) this;
        }

        public Criteria andTlktbzj2In(List<BigDecimal> values) {
            addCriterion("tlktbzj2 in", values, "tlktbzj2");
            return (Criteria) this;
        }

        public Criteria andTlktbzj2NotIn(List<BigDecimal> values) {
            addCriterion("tlktbzj2 not in", values, "tlktbzj2");
            return (Criteria) this;
        }

        public Criteria andTlktbzj2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("tlktbzj2 between", value1, value2, "tlktbzj2");
            return (Criteria) this;
        }

        public Criteria andTlktbzj2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tlktbzj2 not between", value1, value2, "tlktbzj2");
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

        public Criteria andMonthIsNull() {
            addCriterion("month is null");
            return (Criteria) this;
        }

        public Criteria andMonthIsNotNull() {
            addCriterion("month is not null");
            return (Criteria) this;
        }

        public Criteria andMonthEqualTo(Integer value) {
            addCriterion("month =", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotEqualTo(Integer value) {
            addCriterion("month <>", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThan(Integer value) {
            addCriterion("month >", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("month >=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThan(Integer value) {
            addCriterion("month <", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThanOrEqualTo(Integer value) {
            addCriterion("month <=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthIn(List<Integer> values) {
            addCriterion("month in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotIn(List<Integer> values) {
            addCriterion("month not in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthBetween(Integer value1, Integer value2) {
            addCriterion("month between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("month not between", value1, value2, "month");
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