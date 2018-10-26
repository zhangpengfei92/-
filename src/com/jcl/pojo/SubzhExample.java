package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubzhExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubzhExample() {
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

        public Criteria andCookieIsNull() {
            addCriterion("cookie is null");
            return (Criteria) this;
        }

        public Criteria andCookieIsNotNull() {
            addCriterion("cookie is not null");
            return (Criteria) this;
        }

        public Criteria andCookieEqualTo(String value) {
            addCriterion("cookie =", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieNotEqualTo(String value) {
            addCriterion("cookie <>", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieGreaterThan(String value) {
            addCriterion("cookie >", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieGreaterThanOrEqualTo(String value) {
            addCriterion("cookie >=", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieLessThan(String value) {
            addCriterion("cookie <", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieLessThanOrEqualTo(String value) {
            addCriterion("cookie <=", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieLike(String value) {
            addCriterion("cookie like", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieNotLike(String value) {
            addCriterion("cookie not like", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieIn(List<String> values) {
            addCriterion("cookie in", values, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieNotIn(List<String> values) {
            addCriterion("cookie not in", values, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieBetween(String value1, String value2) {
            addCriterion("cookie between", value1, value2, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieNotBetween(String value1, String value2) {
            addCriterion("cookie not between", value1, value2, "cookie");
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

        public Criteria andMainzhIsNull() {
            addCriterion("mainzh is null");
            return (Criteria) this;
        }

        public Criteria andMainzhIsNotNull() {
            addCriterion("mainzh is not null");
            return (Criteria) this;
        }

        public Criteria andMainzhEqualTo(String value) {
            addCriterion("mainzh =", value, "mainzh");
            return (Criteria) this;
        }

        public Criteria andMainzhNotEqualTo(String value) {
            addCriterion("mainzh <>", value, "mainzh");
            return (Criteria) this;
        }

        public Criteria andMainzhGreaterThan(String value) {
            addCriterion("mainzh >", value, "mainzh");
            return (Criteria) this;
        }

        public Criteria andMainzhGreaterThanOrEqualTo(String value) {
            addCriterion("mainzh >=", value, "mainzh");
            return (Criteria) this;
        }

        public Criteria andMainzhLessThan(String value) {
            addCriterion("mainzh <", value, "mainzh");
            return (Criteria) this;
        }

        public Criteria andMainzhLessThanOrEqualTo(String value) {
            addCriterion("mainzh <=", value, "mainzh");
            return (Criteria) this;
        }

        public Criteria andMainzhLike(String value) {
            addCriterion("mainzh like", value, "mainzh");
            return (Criteria) this;
        }

        public Criteria andMainzhNotLike(String value) {
            addCriterion("mainzh not like", value, "mainzh");
            return (Criteria) this;
        }

        public Criteria andMainzhIn(List<String> values) {
            addCriterion("mainzh in", values, "mainzh");
            return (Criteria) this;
        }

        public Criteria andMainzhNotIn(List<String> values) {
            addCriterion("mainzh not in", values, "mainzh");
            return (Criteria) this;
        }

        public Criteria andMainzhBetween(String value1, String value2) {
            addCriterion("mainzh between", value1, value2, "mainzh");
            return (Criteria) this;
        }

        public Criteria andMainzhNotBetween(String value1, String value2) {
            addCriterion("mainzh not between", value1, value2, "mainzh");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
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

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
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

        public Criteria andKhdateIsNull() {
            addCriterion("khdate is null");
            return (Criteria) this;
        }

        public Criteria andKhdateIsNotNull() {
            addCriterion("khdate is not null");
            return (Criteria) this;
        }

        public Criteria andKhdateEqualTo(Date value) {
            addCriterion("khdate =", value, "khdate");
            return (Criteria) this;
        }

        public Criteria andKhdateNotEqualTo(Date value) {
            addCriterion("khdate <>", value, "khdate");
            return (Criteria) this;
        }

        public Criteria andKhdateGreaterThan(Date value) {
            addCriterion("khdate >", value, "khdate");
            return (Criteria) this;
        }

        public Criteria andKhdateGreaterThanOrEqualTo(Date value) {
            addCriterion("khdate >=", value, "khdate");
            return (Criteria) this;
        }

        public Criteria andKhdateLessThan(Date value) {
            addCriterion("khdate <", value, "khdate");
            return (Criteria) this;
        }

        public Criteria andKhdateLessThanOrEqualTo(Date value) {
            addCriterion("khdate <=", value, "khdate");
            return (Criteria) this;
        }

        public Criteria andKhdateIn(List<Date> values) {
            addCriterion("khdate in", values, "khdate");
            return (Criteria) this;
        }

        public Criteria andKhdateNotIn(List<Date> values) {
            addCriterion("khdate not in", values, "khdate");
            return (Criteria) this;
        }

        public Criteria andKhdateBetween(Date value1, Date value2) {
            addCriterion("khdate between", value1, value2, "khdate");
            return (Criteria) this;
        }

        public Criteria andKhdateNotBetween(Date value1, Date value2) {
            addCriterion("khdate not between", value1, value2, "khdate");
            return (Criteria) this;
        }

        public Criteria andWtzhIsNull() {
            addCriterion("wtzh is null");
            return (Criteria) this;
        }

        public Criteria andWtzhIsNotNull() {
            addCriterion("wtzh is not null");
            return (Criteria) this;
        }

        public Criteria andWtzhEqualTo(String value) {
            addCriterion("wtzh =", value, "wtzh");
            return (Criteria) this;
        }

        public Criteria andWtzhNotEqualTo(String value) {
            addCriterion("wtzh <>", value, "wtzh");
            return (Criteria) this;
        }

        public Criteria andWtzhGreaterThan(String value) {
            addCriterion("wtzh >", value, "wtzh");
            return (Criteria) this;
        }

        public Criteria andWtzhGreaterThanOrEqualTo(String value) {
            addCriterion("wtzh >=", value, "wtzh");
            return (Criteria) this;
        }

        public Criteria andWtzhLessThan(String value) {
            addCriterion("wtzh <", value, "wtzh");
            return (Criteria) this;
        }

        public Criteria andWtzhLessThanOrEqualTo(String value) {
            addCriterion("wtzh <=", value, "wtzh");
            return (Criteria) this;
        }

        public Criteria andWtzhLike(String value) {
            addCriterion("wtzh like", value, "wtzh");
            return (Criteria) this;
        }

        public Criteria andWtzhNotLike(String value) {
            addCriterion("wtzh not like", value, "wtzh");
            return (Criteria) this;
        }

        public Criteria andWtzhIn(List<String> values) {
            addCriterion("wtzh in", values, "wtzh");
            return (Criteria) this;
        }

        public Criteria andWtzhNotIn(List<String> values) {
            addCriterion("wtzh not in", values, "wtzh");
            return (Criteria) this;
        }

        public Criteria andWtzhBetween(String value1, String value2) {
            addCriterion("wtzh between", value1, value2, "wtzh");
            return (Criteria) this;
        }

        public Criteria andWtzhNotBetween(String value1, String value2) {
            addCriterion("wtzh not between", value1, value2, "wtzh");
            return (Criteria) this;
        }

        public Criteria andMarginsetIsNull() {
            addCriterion("marginset is null");
            return (Criteria) this;
        }

        public Criteria andMarginsetIsNotNull() {
            addCriterion("marginset is not null");
            return (Criteria) this;
        }

        public Criteria andMarginsetEqualTo(String value) {
            addCriterion("marginset =", value, "marginset");
            return (Criteria) this;
        }

        public Criteria andMarginsetNotEqualTo(String value) {
            addCriterion("marginset <>", value, "marginset");
            return (Criteria) this;
        }

        public Criteria andMarginsetGreaterThan(String value) {
            addCriterion("marginset >", value, "marginset");
            return (Criteria) this;
        }

        public Criteria andMarginsetGreaterThanOrEqualTo(String value) {
            addCriterion("marginset >=", value, "marginset");
            return (Criteria) this;
        }

        public Criteria andMarginsetLessThan(String value) {
            addCriterion("marginset <", value, "marginset");
            return (Criteria) this;
        }

        public Criteria andMarginsetLessThanOrEqualTo(String value) {
            addCriterion("marginset <=", value, "marginset");
            return (Criteria) this;
        }

        public Criteria andMarginsetLike(String value) {
            addCriterion("marginset like", value, "marginset");
            return (Criteria) this;
        }

        public Criteria andMarginsetNotLike(String value) {
            addCriterion("marginset not like", value, "marginset");
            return (Criteria) this;
        }

        public Criteria andMarginsetIn(List<String> values) {
            addCriterion("marginset in", values, "marginset");
            return (Criteria) this;
        }

        public Criteria andMarginsetNotIn(List<String> values) {
            addCriterion("marginset not in", values, "marginset");
            return (Criteria) this;
        }

        public Criteria andMarginsetBetween(String value1, String value2) {
            addCriterion("marginset between", value1, value2, "marginset");
            return (Criteria) this;
        }

        public Criteria andMarginsetNotBetween(String value1, String value2) {
            addCriterion("marginset not between", value1, value2, "marginset");
            return (Criteria) this;
        }

        public Criteria andFeesetIsNull() {
            addCriterion("feeset is null");
            return (Criteria) this;
        }

        public Criteria andFeesetIsNotNull() {
            addCriterion("feeset is not null");
            return (Criteria) this;
        }

        public Criteria andFeesetEqualTo(String value) {
            addCriterion("feeset =", value, "feeset");
            return (Criteria) this;
        }

        public Criteria andFeesetNotEqualTo(String value) {
            addCriterion("feeset <>", value, "feeset");
            return (Criteria) this;
        }

        public Criteria andFeesetGreaterThan(String value) {
            addCriterion("feeset >", value, "feeset");
            return (Criteria) this;
        }

        public Criteria andFeesetGreaterThanOrEqualTo(String value) {
            addCriterion("feeset >=", value, "feeset");
            return (Criteria) this;
        }

        public Criteria andFeesetLessThan(String value) {
            addCriterion("feeset <", value, "feeset");
            return (Criteria) this;
        }

        public Criteria andFeesetLessThanOrEqualTo(String value) {
            addCriterion("feeset <=", value, "feeset");
            return (Criteria) this;
        }

        public Criteria andFeesetLike(String value) {
            addCriterion("feeset like", value, "feeset");
            return (Criteria) this;
        }

        public Criteria andFeesetNotLike(String value) {
            addCriterion("feeset not like", value, "feeset");
            return (Criteria) this;
        }

        public Criteria andFeesetIn(List<String> values) {
            addCriterion("feeset in", values, "feeset");
            return (Criteria) this;
        }

        public Criteria andFeesetNotIn(List<String> values) {
            addCriterion("feeset not in", values, "feeset");
            return (Criteria) this;
        }

        public Criteria andFeesetBetween(String value1, String value2) {
            addCriterion("feeset between", value1, value2, "feeset");
            return (Criteria) this;
        }

        public Criteria andFeesetNotBetween(String value1, String value2) {
            addCriterion("feeset not between", value1, value2, "feeset");
            return (Criteria) this;
        }

        public Criteria andRisksetIsNull() {
            addCriterion("riskset is null");
            return (Criteria) this;
        }

        public Criteria andRisksetIsNotNull() {
            addCriterion("riskset is not null");
            return (Criteria) this;
        }

        public Criteria andRisksetEqualTo(Integer value) {
            addCriterion("riskset =", value, "riskset");
            return (Criteria) this;
        }

        public Criteria andRisksetNotEqualTo(Integer value) {
            addCriterion("riskset <>", value, "riskset");
            return (Criteria) this;
        }

        public Criteria andRisksetGreaterThan(Integer value) {
            addCriterion("riskset >", value, "riskset");
            return (Criteria) this;
        }

        public Criteria andRisksetGreaterThanOrEqualTo(Integer value) {
            addCriterion("riskset >=", value, "riskset");
            return (Criteria) this;
        }

        public Criteria andRisksetLessThan(Integer value) {
            addCriterion("riskset <", value, "riskset");
            return (Criteria) this;
        }

        public Criteria andRisksetLessThanOrEqualTo(Integer value) {
            addCriterion("riskset <=", value, "riskset");
            return (Criteria) this;
        }

        public Criteria andRisksetIn(List<Integer> values) {
            addCriterion("riskset in", values, "riskset");
            return (Criteria) this;
        }

        public Criteria andRisksetNotIn(List<Integer> values) {
            addCriterion("riskset not in", values, "riskset");
            return (Criteria) this;
        }

        public Criteria andRisksetBetween(Integer value1, Integer value2) {
            addCriterion("riskset between", value1, value2, "riskset");
            return (Criteria) this;
        }

        public Criteria andRisksetNotBetween(Integer value1, Integer value2) {
            addCriterion("riskset not between", value1, value2, "riskset");
            return (Criteria) this;
        }

        public Criteria andMidmanIsNull() {
            addCriterion("midman is null");
            return (Criteria) this;
        }

        public Criteria andMidmanIsNotNull() {
            addCriterion("midman is not null");
            return (Criteria) this;
        }

        public Criteria andMidmanEqualTo(String value) {
            addCriterion("midman =", value, "midman");
            return (Criteria) this;
        }

        public Criteria andMidmanNotEqualTo(String value) {
            addCriterion("midman <>", value, "midman");
            return (Criteria) this;
        }

        public Criteria andMidmanGreaterThan(String value) {
            addCriterion("midman >", value, "midman");
            return (Criteria) this;
        }

        public Criteria andMidmanGreaterThanOrEqualTo(String value) {
            addCriterion("midman >=", value, "midman");
            return (Criteria) this;
        }

        public Criteria andMidmanLessThan(String value) {
            addCriterion("midman <", value, "midman");
            return (Criteria) this;
        }

        public Criteria andMidmanLessThanOrEqualTo(String value) {
            addCriterion("midman <=", value, "midman");
            return (Criteria) this;
        }

        public Criteria andMidmanLike(String value) {
            addCriterion("midman like", value, "midman");
            return (Criteria) this;
        }

        public Criteria andMidmanNotLike(String value) {
            addCriterion("midman not like", value, "midman");
            return (Criteria) this;
        }

        public Criteria andMidmanIn(List<String> values) {
            addCriterion("midman in", values, "midman");
            return (Criteria) this;
        }

        public Criteria andMidmanNotIn(List<String> values) {
            addCriterion("midman not in", values, "midman");
            return (Criteria) this;
        }

        public Criteria andMidmanBetween(String value1, String value2) {
            addCriterion("midman between", value1, value2, "midman");
            return (Criteria) this;
        }

        public Criteria andMidmanNotBetween(String value1, String value2) {
            addCriterion("midman not between", value1, value2, "midman");
            return (Criteria) this;
        }

        public Criteria andOpenrightIsNull() {
            addCriterion("openright is null");
            return (Criteria) this;
        }

        public Criteria andOpenrightIsNotNull() {
            addCriterion("openright is not null");
            return (Criteria) this;
        }

        public Criteria andOpenrightEqualTo(Integer value) {
            addCriterion("openright =", value, "openright");
            return (Criteria) this;
        }

        public Criteria andOpenrightNotEqualTo(Integer value) {
            addCriterion("openright <>", value, "openright");
            return (Criteria) this;
        }

        public Criteria andOpenrightGreaterThan(Integer value) {
            addCriterion("openright >", value, "openright");
            return (Criteria) this;
        }

        public Criteria andOpenrightGreaterThanOrEqualTo(Integer value) {
            addCriterion("openright >=", value, "openright");
            return (Criteria) this;
        }

        public Criteria andOpenrightLessThan(Integer value) {
            addCriterion("openright <", value, "openright");
            return (Criteria) this;
        }

        public Criteria andOpenrightLessThanOrEqualTo(Integer value) {
            addCriterion("openright <=", value, "openright");
            return (Criteria) this;
        }

        public Criteria andOpenrightIn(List<Integer> values) {
            addCriterion("openright in", values, "openright");
            return (Criteria) this;
        }

        public Criteria andOpenrightNotIn(List<Integer> values) {
            addCriterion("openright not in", values, "openright");
            return (Criteria) this;
        }

        public Criteria andOpenrightBetween(Integer value1, Integer value2) {
            addCriterion("openright between", value1, value2, "openright");
            return (Criteria) this;
        }

        public Criteria andOpenrightNotBetween(Integer value1, Integer value2) {
            addCriterion("openright not between", value1, value2, "openright");
            return (Criteria) this;
        }

        public Criteria andAccounttypeIsNull() {
            addCriterion("accounttype is null");
            return (Criteria) this;
        }

        public Criteria andAccounttypeIsNotNull() {
            addCriterion("accounttype is not null");
            return (Criteria) this;
        }

        public Criteria andAccounttypeEqualTo(Integer value) {
            addCriterion("accounttype =", value, "accounttype");
            return (Criteria) this;
        }

        public Criteria andAccounttypeNotEqualTo(Integer value) {
            addCriterion("accounttype <>", value, "accounttype");
            return (Criteria) this;
        }

        public Criteria andAccounttypeGreaterThan(Integer value) {
            addCriterion("accounttype >", value, "accounttype");
            return (Criteria) this;
        }

        public Criteria andAccounttypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("accounttype >=", value, "accounttype");
            return (Criteria) this;
        }

        public Criteria andAccounttypeLessThan(Integer value) {
            addCriterion("accounttype <", value, "accounttype");
            return (Criteria) this;
        }

        public Criteria andAccounttypeLessThanOrEqualTo(Integer value) {
            addCriterion("accounttype <=", value, "accounttype");
            return (Criteria) this;
        }

        public Criteria andAccounttypeIn(List<Integer> values) {
            addCriterion("accounttype in", values, "accounttype");
            return (Criteria) this;
        }

        public Criteria andAccounttypeNotIn(List<Integer> values) {
            addCriterion("accounttype not in", values, "accounttype");
            return (Criteria) this;
        }

        public Criteria andAccounttypeBetween(Integer value1, Integer value2) {
            addCriterion("accounttype between", value1, value2, "accounttype");
            return (Criteria) this;
        }

        public Criteria andAccounttypeNotBetween(Integer value1, Integer value2) {
            addCriterion("accounttype not between", value1, value2, "accounttype");
            return (Criteria) this;
        }

        public Criteria andBrokerzhIsNull() {
            addCriterion("brokerzh is null");
            return (Criteria) this;
        }

        public Criteria andBrokerzhIsNotNull() {
            addCriterion("brokerzh is not null");
            return (Criteria) this;
        }

        public Criteria andBrokerzhEqualTo(String value) {
            addCriterion("brokerzh =", value, "brokerzh");
            return (Criteria) this;
        }

        public Criteria andBrokerzhNotEqualTo(String value) {
            addCriterion("brokerzh <>", value, "brokerzh");
            return (Criteria) this;
        }

        public Criteria andBrokerzhGreaterThan(String value) {
            addCriterion("brokerzh >", value, "brokerzh");
            return (Criteria) this;
        }

        public Criteria andBrokerzhGreaterThanOrEqualTo(String value) {
            addCriterion("brokerzh >=", value, "brokerzh");
            return (Criteria) this;
        }

        public Criteria andBrokerzhLessThan(String value) {
            addCriterion("brokerzh <", value, "brokerzh");
            return (Criteria) this;
        }

        public Criteria andBrokerzhLessThanOrEqualTo(String value) {
            addCriterion("brokerzh <=", value, "brokerzh");
            return (Criteria) this;
        }

        public Criteria andBrokerzhLike(String value) {
            addCriterion("brokerzh like", value, "brokerzh");
            return (Criteria) this;
        }

        public Criteria andBrokerzhNotLike(String value) {
            addCriterion("brokerzh not like", value, "brokerzh");
            return (Criteria) this;
        }

        public Criteria andBrokerzhIn(List<String> values) {
            addCriterion("brokerzh in", values, "brokerzh");
            return (Criteria) this;
        }

        public Criteria andBrokerzhNotIn(List<String> values) {
            addCriterion("brokerzh not in", values, "brokerzh");
            return (Criteria) this;
        }

        public Criteria andBrokerzhBetween(String value1, String value2) {
            addCriterion("brokerzh between", value1, value2, "brokerzh");
            return (Criteria) this;
        }

        public Criteria andBrokerzhNotBetween(String value1, String value2) {
            addCriterion("brokerzh not between", value1, value2, "brokerzh");
            return (Criteria) this;
        }

        public Criteria andIsagentIsNull() {
            addCriterion("isagent is null");
            return (Criteria) this;
        }

        public Criteria andIsagentIsNotNull() {
            addCriterion("isagent is not null");
            return (Criteria) this;
        }

        public Criteria andIsagentEqualTo(Integer value) {
            addCriterion("isagent =", value, "isagent");
            return (Criteria) this;
        }

        public Criteria andIsagentNotEqualTo(Integer value) {
            addCriterion("isagent <>", value, "isagent");
            return (Criteria) this;
        }

        public Criteria andIsagentGreaterThan(Integer value) {
            addCriterion("isagent >", value, "isagent");
            return (Criteria) this;
        }

        public Criteria andIsagentGreaterThanOrEqualTo(Integer value) {
            addCriterion("isagent >=", value, "isagent");
            return (Criteria) this;
        }

        public Criteria andIsagentLessThan(Integer value) {
            addCriterion("isagent <", value, "isagent");
            return (Criteria) this;
        }

        public Criteria andIsagentLessThanOrEqualTo(Integer value) {
            addCriterion("isagent <=", value, "isagent");
            return (Criteria) this;
        }

        public Criteria andIsagentIn(List<Integer> values) {
            addCriterion("isagent in", values, "isagent");
            return (Criteria) this;
        }

        public Criteria andIsagentNotIn(List<Integer> values) {
            addCriterion("isagent not in", values, "isagent");
            return (Criteria) this;
        }

        public Criteria andIsagentBetween(Integer value1, Integer value2) {
            addCriterion("isagent between", value1, value2, "isagent");
            return (Criteria) this;
        }

        public Criteria andIsagentNotBetween(Integer value1, Integer value2) {
            addCriterion("isagent not between", value1, value2, "isagent");
            return (Criteria) this;
        }

        public Criteria andQqIsNull() {
            addCriterion("qq is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("qq is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("qq =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("qq <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("qq >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("qq >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("qq <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("qq <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("qq like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("qq not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("qq in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("qq not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("qq between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("qq not between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andMailIsNull() {
            addCriterion("mail is null");
            return (Criteria) this;
        }

        public Criteria andMailIsNotNull() {
            addCriterion("mail is not null");
            return (Criteria) this;
        }

        public Criteria andMailEqualTo(String value) {
            addCriterion("mail =", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotEqualTo(String value) {
            addCriterion("mail <>", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailGreaterThan(String value) {
            addCriterion("mail >", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailGreaterThanOrEqualTo(String value) {
            addCriterion("mail >=", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLessThan(String value) {
            addCriterion("mail <", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLessThanOrEqualTo(String value) {
            addCriterion("mail <=", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLike(String value) {
            addCriterion("mail like", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotLike(String value) {
            addCriterion("mail not like", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailIn(List<String> values) {
            addCriterion("mail in", values, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotIn(List<String> values) {
            addCriterion("mail not in", values, "mail");
            return (Criteria) this;
        }

        public Criteria andMailBetween(String value1, String value2) {
            addCriterion("mail between", value1, value2, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotBetween(String value1, String value2) {
            addCriterion("mail not between", value1, value2, "mail");
            return (Criteria) this;
        }

        public Criteria andInitmoneyIsNull() {
            addCriterion("initmoney is null");
            return (Criteria) this;
        }

        public Criteria andInitmoneyIsNotNull() {
            addCriterion("initmoney is not null");
            return (Criteria) this;
        }

        public Criteria andInitmoneyEqualTo(BigDecimal value) {
            addCriterion("initmoney =", value, "initmoney");
            return (Criteria) this;
        }

        public Criteria andInitmoneyNotEqualTo(BigDecimal value) {
            addCriterion("initmoney <>", value, "initmoney");
            return (Criteria) this;
        }

        public Criteria andInitmoneyGreaterThan(BigDecimal value) {
            addCriterion("initmoney >", value, "initmoney");
            return (Criteria) this;
        }

        public Criteria andInitmoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("initmoney >=", value, "initmoney");
            return (Criteria) this;
        }

        public Criteria andInitmoneyLessThan(BigDecimal value) {
            addCriterion("initmoney <", value, "initmoney");
            return (Criteria) this;
        }

        public Criteria andInitmoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("initmoney <=", value, "initmoney");
            return (Criteria) this;
        }

        public Criteria andInitmoneyIn(List<BigDecimal> values) {
            addCriterion("initmoney in", values, "initmoney");
            return (Criteria) this;
        }

        public Criteria andInitmoneyNotIn(List<BigDecimal> values) {
            addCriterion("initmoney not in", values, "initmoney");
            return (Criteria) this;
        }

        public Criteria andInitmoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("initmoney between", value1, value2, "initmoney");
            return (Criteria) this;
        }

        public Criteria andInitmoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("initmoney not between", value1, value2, "initmoney");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andFirstjjsIsNull() {
            addCriterion("firstjjs is null");
            return (Criteria) this;
        }

        public Criteria andFirstjjsIsNotNull() {
            addCriterion("firstjjs is not null");
            return (Criteria) this;
        }

        public Criteria andFirstjjsEqualTo(String value) {
            addCriterion("firstjjs =", value, "firstjjs");
            return (Criteria) this;
        }

        public Criteria andFirstjjsNotEqualTo(String value) {
            addCriterion("firstjjs <>", value, "firstjjs");
            return (Criteria) this;
        }

        public Criteria andFirstjjsGreaterThan(String value) {
            addCriterion("firstjjs >", value, "firstjjs");
            return (Criteria) this;
        }

        public Criteria andFirstjjsGreaterThanOrEqualTo(String value) {
            addCriterion("firstjjs >=", value, "firstjjs");
            return (Criteria) this;
        }

        public Criteria andFirstjjsLessThan(String value) {
            addCriterion("firstjjs <", value, "firstjjs");
            return (Criteria) this;
        }

        public Criteria andFirstjjsLessThanOrEqualTo(String value) {
            addCriterion("firstjjs <=", value, "firstjjs");
            return (Criteria) this;
        }

        public Criteria andFirstjjsLike(String value) {
            addCriterion("firstjjs like", value, "firstjjs");
            return (Criteria) this;
        }

        public Criteria andFirstjjsNotLike(String value) {
            addCriterion("firstjjs not like", value, "firstjjs");
            return (Criteria) this;
        }

        public Criteria andFirstjjsIn(List<String> values) {
            addCriterion("firstjjs in", values, "firstjjs");
            return (Criteria) this;
        }

        public Criteria andFirstjjsNotIn(List<String> values) {
            addCriterion("firstjjs not in", values, "firstjjs");
            return (Criteria) this;
        }

        public Criteria andFirstjjsBetween(String value1, String value2) {
            addCriterion("firstjjs between", value1, value2, "firstjjs");
            return (Criteria) this;
        }

        public Criteria andFirstjjsNotBetween(String value1, String value2) {
            addCriterion("firstjjs not between", value1, value2, "firstjjs");
            return (Criteria) this;
        }

        public Criteria andSecendjjsIsNull() {
            addCriterion("secendjjs is null");
            return (Criteria) this;
        }

        public Criteria andSecendjjsIsNotNull() {
            addCriterion("secendjjs is not null");
            return (Criteria) this;
        }

        public Criteria andSecendjjsEqualTo(String value) {
            addCriterion("secendjjs =", value, "secendjjs");
            return (Criteria) this;
        }

        public Criteria andSecendjjsNotEqualTo(String value) {
            addCriterion("secendjjs <>", value, "secendjjs");
            return (Criteria) this;
        }

        public Criteria andSecendjjsGreaterThan(String value) {
            addCriterion("secendjjs >", value, "secendjjs");
            return (Criteria) this;
        }

        public Criteria andSecendjjsGreaterThanOrEqualTo(String value) {
            addCriterion("secendjjs >=", value, "secendjjs");
            return (Criteria) this;
        }

        public Criteria andSecendjjsLessThan(String value) {
            addCriterion("secendjjs <", value, "secendjjs");
            return (Criteria) this;
        }

        public Criteria andSecendjjsLessThanOrEqualTo(String value) {
            addCriterion("secendjjs <=", value, "secendjjs");
            return (Criteria) this;
        }

        public Criteria andSecendjjsLike(String value) {
            addCriterion("secendjjs like", value, "secendjjs");
            return (Criteria) this;
        }

        public Criteria andSecendjjsNotLike(String value) {
            addCriterion("secendjjs not like", value, "secendjjs");
            return (Criteria) this;
        }

        public Criteria andSecendjjsIn(List<String> values) {
            addCriterion("secendjjs in", values, "secendjjs");
            return (Criteria) this;
        }

        public Criteria andSecendjjsNotIn(List<String> values) {
            addCriterion("secendjjs not in", values, "secendjjs");
            return (Criteria) this;
        }

        public Criteria andSecendjjsBetween(String value1, String value2) {
            addCriterion("secendjjs between", value1, value2, "secendjjs");
            return (Criteria) this;
        }

        public Criteria andSecendjjsNotBetween(String value1, String value2) {
            addCriterion("secendjjs not between", value1, value2, "secendjjs");
            return (Criteria) this;
        }

        public Criteria andThirdjjsIsNull() {
            addCriterion("thirdjjs is null");
            return (Criteria) this;
        }

        public Criteria andThirdjjsIsNotNull() {
            addCriterion("thirdjjs is not null");
            return (Criteria) this;
        }

        public Criteria andThirdjjsEqualTo(String value) {
            addCriterion("thirdjjs =", value, "thirdjjs");
            return (Criteria) this;
        }

        public Criteria andThirdjjsNotEqualTo(String value) {
            addCriterion("thirdjjs <>", value, "thirdjjs");
            return (Criteria) this;
        }

        public Criteria andThirdjjsGreaterThan(String value) {
            addCriterion("thirdjjs >", value, "thirdjjs");
            return (Criteria) this;
        }

        public Criteria andThirdjjsGreaterThanOrEqualTo(String value) {
            addCriterion("thirdjjs >=", value, "thirdjjs");
            return (Criteria) this;
        }

        public Criteria andThirdjjsLessThan(String value) {
            addCriterion("thirdjjs <", value, "thirdjjs");
            return (Criteria) this;
        }

        public Criteria andThirdjjsLessThanOrEqualTo(String value) {
            addCriterion("thirdjjs <=", value, "thirdjjs");
            return (Criteria) this;
        }

        public Criteria andThirdjjsLike(String value) {
            addCriterion("thirdjjs like", value, "thirdjjs");
            return (Criteria) this;
        }

        public Criteria andThirdjjsNotLike(String value) {
            addCriterion("thirdjjs not like", value, "thirdjjs");
            return (Criteria) this;
        }

        public Criteria andThirdjjsIn(List<String> values) {
            addCriterion("thirdjjs in", values, "thirdjjs");
            return (Criteria) this;
        }

        public Criteria andThirdjjsNotIn(List<String> values) {
            addCriterion("thirdjjs not in", values, "thirdjjs");
            return (Criteria) this;
        }

        public Criteria andThirdjjsBetween(String value1, String value2) {
            addCriterion("thirdjjs between", value1, value2, "thirdjjs");
            return (Criteria) this;
        }

        public Criteria andThirdjjsNotBetween(String value1, String value2) {
            addCriterion("thirdjjs not between", value1, value2, "thirdjjs");
            return (Criteria) this;
        }

        public Criteria andMacIsNull() {
            addCriterion("mac is null");
            return (Criteria) this;
        }

        public Criteria andMacIsNotNull() {
            addCriterion("mac is not null");
            return (Criteria) this;
        }

        public Criteria andMacEqualTo(String value) {
            addCriterion("mac =", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotEqualTo(String value) {
            addCriterion("mac <>", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacGreaterThan(String value) {
            addCriterion("mac >", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacGreaterThanOrEqualTo(String value) {
            addCriterion("mac >=", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLessThan(String value) {
            addCriterion("mac <", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLessThanOrEqualTo(String value) {
            addCriterion("mac <=", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLike(String value) {
            addCriterion("mac like", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotLike(String value) {
            addCriterion("mac not like", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacIn(List<String> values) {
            addCriterion("mac in", values, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotIn(List<String> values) {
            addCriterion("mac not in", values, "mac");
            return (Criteria) this;
        }

        public Criteria andMacBetween(String value1, String value2) {
            addCriterion("mac between", value1, value2, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotBetween(String value1, String value2) {
            addCriterion("mac not between", value1, value2, "mac");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andGroupidIsNull() {
            addCriterion("groupid is null");
            return (Criteria) this;
        }

        public Criteria andGroupidIsNotNull() {
            addCriterion("groupid is not null");
            return (Criteria) this;
        }

        public Criteria andGroupidEqualTo(String value) {
            addCriterion("groupid =", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotEqualTo(String value) {
            addCriterion("groupid <>", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidGreaterThan(String value) {
            addCriterion("groupid >", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidGreaterThanOrEqualTo(String value) {
            addCriterion("groupid >=", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidLessThan(String value) {
            addCriterion("groupid <", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidLessThanOrEqualTo(String value) {
            addCriterion("groupid <=", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidLike(String value) {
            addCriterion("groupid like", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotLike(String value) {
            addCriterion("groupid not like", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidIn(List<String> values) {
            addCriterion("groupid in", values, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotIn(List<String> values) {
            addCriterion("groupid not in", values, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidBetween(String value1, String value2) {
            addCriterion("groupid between", value1, value2, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotBetween(String value1, String value2) {
            addCriterion("groupid not between", value1, value2, "groupid");
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

        public Criteria andHeadpictureIsNull() {
            addCriterion("headPicture is null");
            return (Criteria) this;
        }

        public Criteria andHeadpictureIsNotNull() {
            addCriterion("headPicture is not null");
            return (Criteria) this;
        }

        public Criteria andHeadpictureEqualTo(String value) {
            addCriterion("headPicture =", value, "headpicture");
            return (Criteria) this;
        }

        public Criteria andHeadpictureNotEqualTo(String value) {
            addCriterion("headPicture <>", value, "headpicture");
            return (Criteria) this;
        }

        public Criteria andHeadpictureGreaterThan(String value) {
            addCriterion("headPicture >", value, "headpicture");
            return (Criteria) this;
        }

        public Criteria andHeadpictureGreaterThanOrEqualTo(String value) {
            addCriterion("headPicture >=", value, "headpicture");
            return (Criteria) this;
        }

        public Criteria andHeadpictureLessThan(String value) {
            addCriterion("headPicture <", value, "headpicture");
            return (Criteria) this;
        }

        public Criteria andHeadpictureLessThanOrEqualTo(String value) {
            addCriterion("headPicture <=", value, "headpicture");
            return (Criteria) this;
        }

        public Criteria andHeadpictureLike(String value) {
            addCriterion("headPicture like", value, "headpicture");
            return (Criteria) this;
        }

        public Criteria andHeadpictureNotLike(String value) {
            addCriterion("headPicture not like", value, "headpicture");
            return (Criteria) this;
        }

        public Criteria andHeadpictureIn(List<String> values) {
            addCriterion("headPicture in", values, "headpicture");
            return (Criteria) this;
        }

        public Criteria andHeadpictureNotIn(List<String> values) {
            addCriterion("headPicture not in", values, "headpicture");
            return (Criteria) this;
        }

        public Criteria andHeadpictureBetween(String value1, String value2) {
            addCriterion("headPicture between", value1, value2, "headpicture");
            return (Criteria) this;
        }

        public Criteria andHeadpictureNotBetween(String value1, String value2) {
            addCriterion("headPicture not between", value1, value2, "headpicture");
            return (Criteria) this;
        }

        public Criteria andLoginnameIsNull() {
            addCriterion("loginname is null");
            return (Criteria) this;
        }

        public Criteria andLoginnameIsNotNull() {
            addCriterion("loginname is not null");
            return (Criteria) this;
        }

        public Criteria andLoginnameEqualTo(String value) {
            addCriterion("loginname =", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotEqualTo(String value) {
            addCriterion("loginname <>", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameGreaterThan(String value) {
            addCriterion("loginname >", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameGreaterThanOrEqualTo(String value) {
            addCriterion("loginname >=", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameLessThan(String value) {
            addCriterion("loginname <", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameLessThanOrEqualTo(String value) {
            addCriterion("loginname <=", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameLike(String value) {
            addCriterion("loginname like", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotLike(String value) {
            addCriterion("loginname not like", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameIn(List<String> values) {
            addCriterion("loginname in", values, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotIn(List<String> values) {
            addCriterion("loginname not in", values, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameBetween(String value1, String value2) {
            addCriterion("loginname between", value1, value2, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotBetween(String value1, String value2) {
            addCriterion("loginname not between", value1, value2, "loginname");
            return (Criteria) this;
        }

        public Criteria andNotenameIsNull() {
            addCriterion("notename is null");
            return (Criteria) this;
        }

        public Criteria andNotenameIsNotNull() {
            addCriterion("notename is not null");
            return (Criteria) this;
        }

        public Criteria andNotenameEqualTo(String value) {
            addCriterion("notename =", value, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameNotEqualTo(String value) {
            addCriterion("notename <>", value, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameGreaterThan(String value) {
            addCriterion("notename >", value, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameGreaterThanOrEqualTo(String value) {
            addCriterion("notename >=", value, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameLessThan(String value) {
            addCriterion("notename <", value, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameLessThanOrEqualTo(String value) {
            addCriterion("notename <=", value, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameLike(String value) {
            addCriterion("notename like", value, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameNotLike(String value) {
            addCriterion("notename not like", value, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameIn(List<String> values) {
            addCriterion("notename in", values, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameNotIn(List<String> values) {
            addCriterion("notename not in", values, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameBetween(String value1, String value2) {
            addCriterion("notename between", value1, value2, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameNotBetween(String value1, String value2) {
            addCriterion("notename not between", value1, value2, "notename");
            return (Criteria) this;
        }

        public Criteria andNotetelIsNull() {
            addCriterion("notetel is null");
            return (Criteria) this;
        }

        public Criteria andNotetelIsNotNull() {
            addCriterion("notetel is not null");
            return (Criteria) this;
        }

        public Criteria andNotetelEqualTo(String value) {
            addCriterion("notetel =", value, "notetel");
            return (Criteria) this;
        }

        public Criteria andNotetelNotEqualTo(String value) {
            addCriterion("notetel <>", value, "notetel");
            return (Criteria) this;
        }

        public Criteria andNotetelGreaterThan(String value) {
            addCriterion("notetel >", value, "notetel");
            return (Criteria) this;
        }

        public Criteria andNotetelGreaterThanOrEqualTo(String value) {
            addCriterion("notetel >=", value, "notetel");
            return (Criteria) this;
        }

        public Criteria andNotetelLessThan(String value) {
            addCriterion("notetel <", value, "notetel");
            return (Criteria) this;
        }

        public Criteria andNotetelLessThanOrEqualTo(String value) {
            addCriterion("notetel <=", value, "notetel");
            return (Criteria) this;
        }

        public Criteria andNotetelLike(String value) {
            addCriterion("notetel like", value, "notetel");
            return (Criteria) this;
        }

        public Criteria andNotetelNotLike(String value) {
            addCriterion("notetel not like", value, "notetel");
            return (Criteria) this;
        }

        public Criteria andNotetelIn(List<String> values) {
            addCriterion("notetel in", values, "notetel");
            return (Criteria) this;
        }

        public Criteria andNotetelNotIn(List<String> values) {
            addCriterion("notetel not in", values, "notetel");
            return (Criteria) this;
        }

        public Criteria andNotetelBetween(String value1, String value2) {
            addCriterion("notetel between", value1, value2, "notetel");
            return (Criteria) this;
        }

        public Criteria andNotetelNotBetween(String value1, String value2) {
            addCriterion("notetel not between", value1, value2, "notetel");
            return (Criteria) this;
        }

        public Criteria andRisktypeIsNull() {
            addCriterion("risktype is null");
            return (Criteria) this;
        }

        public Criteria andRisktypeIsNotNull() {
            addCriterion("risktype is not null");
            return (Criteria) this;
        }

        public Criteria andRisktypeEqualTo(Integer value) {
            addCriterion("risktype =", value, "risktype");
            return (Criteria) this;
        }

        public Criteria andRisktypeNotEqualTo(Integer value) {
            addCriterion("risktype <>", value, "risktype");
            return (Criteria) this;
        }

        public Criteria andRisktypeGreaterThan(Integer value) {
            addCriterion("risktype >", value, "risktype");
            return (Criteria) this;
        }

        public Criteria andRisktypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("risktype >=", value, "risktype");
            return (Criteria) this;
        }

        public Criteria andRisktypeLessThan(Integer value) {
            addCriterion("risktype <", value, "risktype");
            return (Criteria) this;
        }

        public Criteria andRisktypeLessThanOrEqualTo(Integer value) {
            addCriterion("risktype <=", value, "risktype");
            return (Criteria) this;
        }

        public Criteria andRisktypeIn(List<Integer> values) {
            addCriterion("risktype in", values, "risktype");
            return (Criteria) this;
        }

        public Criteria andRisktypeNotIn(List<Integer> values) {
            addCriterion("risktype not in", values, "risktype");
            return (Criteria) this;
        }

        public Criteria andRisktypeBetween(Integer value1, Integer value2) {
            addCriterion("risktype between", value1, value2, "risktype");
            return (Criteria) this;
        }

        public Criteria andRisktypeNotBetween(Integer value1, Integer value2) {
            addCriterion("risktype not between", value1, value2, "risktype");
            return (Criteria) this;
        }

        public Criteria andAccountpatternIsNull() {
            addCriterion("accountpattern is null");
            return (Criteria) this;
        }

        public Criteria andAccountpatternIsNotNull() {
            addCriterion("accountpattern is not null");
            return (Criteria) this;
        }

        public Criteria andAccountpatternEqualTo(Integer value) {
            addCriterion("accountpattern =", value, "accountpattern");
            return (Criteria) this;
        }

        public Criteria andAccountpatternNotEqualTo(Integer value) {
            addCriterion("accountpattern <>", value, "accountpattern");
            return (Criteria) this;
        }

        public Criteria andAccountpatternGreaterThan(Integer value) {
            addCriterion("accountpattern >", value, "accountpattern");
            return (Criteria) this;
        }

        public Criteria andAccountpatternGreaterThanOrEqualTo(Integer value) {
            addCriterion("accountpattern >=", value, "accountpattern");
            return (Criteria) this;
        }

        public Criteria andAccountpatternLessThan(Integer value) {
            addCriterion("accountpattern <", value, "accountpattern");
            return (Criteria) this;
        }

        public Criteria andAccountpatternLessThanOrEqualTo(Integer value) {
            addCriterion("accountpattern <=", value, "accountpattern");
            return (Criteria) this;
        }

        public Criteria andAccountpatternIn(List<Integer> values) {
            addCriterion("accountpattern in", values, "accountpattern");
            return (Criteria) this;
        }

        public Criteria andAccountpatternNotIn(List<Integer> values) {
            addCriterion("accountpattern not in", values, "accountpattern");
            return (Criteria) this;
        }

        public Criteria andAccountpatternBetween(Integer value1, Integer value2) {
            addCriterion("accountpattern between", value1, value2, "accountpattern");
            return (Criteria) this;
        }

        public Criteria andAccountpatternNotBetween(Integer value1, Integer value2) {
            addCriterion("accountpattern not between", value1, value2, "accountpattern");
            return (Criteria) this;
        }

        public Criteria andZijinaccountIsNull() {
            addCriterion("zijinaccount is null");
            return (Criteria) this;
        }

        public Criteria andZijinaccountIsNotNull() {
            addCriterion("zijinaccount is not null");
            return (Criteria) this;
        }

        public Criteria andZijinaccountEqualTo(Integer value) {
            addCriterion("zijinaccount =", value, "zijinaccount");
            return (Criteria) this;
        }

        public Criteria andZijinaccountNotEqualTo(Integer value) {
            addCriterion("zijinaccount <>", value, "zijinaccount");
            return (Criteria) this;
        }

        public Criteria andZijinaccountGreaterThan(Integer value) {
            addCriterion("zijinaccount >", value, "zijinaccount");
            return (Criteria) this;
        }

        public Criteria andZijinaccountGreaterThanOrEqualTo(Integer value) {
            addCriterion("zijinaccount >=", value, "zijinaccount");
            return (Criteria) this;
        }

        public Criteria andZijinaccountLessThan(Integer value) {
            addCriterion("zijinaccount <", value, "zijinaccount");
            return (Criteria) this;
        }

        public Criteria andZijinaccountLessThanOrEqualTo(Integer value) {
            addCriterion("zijinaccount <=", value, "zijinaccount");
            return (Criteria) this;
        }

        public Criteria andZijinaccountIn(List<Integer> values) {
            addCriterion("zijinaccount in", values, "zijinaccount");
            return (Criteria) this;
        }

        public Criteria andZijinaccountNotIn(List<Integer> values) {
            addCriterion("zijinaccount not in", values, "zijinaccount");
            return (Criteria) this;
        }

        public Criteria andZijinaccountBetween(Integer value1, Integer value2) {
            addCriterion("zijinaccount between", value1, value2, "zijinaccount");
            return (Criteria) this;
        }

        public Criteria andZijinaccountNotBetween(Integer value1, Integer value2) {
            addCriterion("zijinaccount not between", value1, value2, "zijinaccount");
            return (Criteria) this;
        }

        public Criteria andJypzIsNull() {
            addCriterion("jypz is null");
            return (Criteria) this;
        }

        public Criteria andJypzIsNotNull() {
            addCriterion("jypz is not null");
            return (Criteria) this;
        }

        public Criteria andJypzEqualTo(Integer value) {
            addCriterion("jypz =", value, "jypz");
            return (Criteria) this;
        }

        public Criteria andJypzNotEqualTo(Integer value) {
            addCriterion("jypz <>", value, "jypz");
            return (Criteria) this;
        }

        public Criteria andJypzGreaterThan(Integer value) {
            addCriterion("jypz >", value, "jypz");
            return (Criteria) this;
        }

        public Criteria andJypzGreaterThanOrEqualTo(Integer value) {
            addCriterion("jypz >=", value, "jypz");
            return (Criteria) this;
        }

        public Criteria andJypzLessThan(Integer value) {
            addCriterion("jypz <", value, "jypz");
            return (Criteria) this;
        }

        public Criteria andJypzLessThanOrEqualTo(Integer value) {
            addCriterion("jypz <=", value, "jypz");
            return (Criteria) this;
        }

        public Criteria andJypzIn(List<Integer> values) {
            addCriterion("jypz in", values, "jypz");
            return (Criteria) this;
        }

        public Criteria andJypzNotIn(List<Integer> values) {
            addCriterion("jypz not in", values, "jypz");
            return (Criteria) this;
        }

        public Criteria andJypzBetween(Integer value1, Integer value2) {
            addCriterion("jypz between", value1, value2, "jypz");
            return (Criteria) this;
        }

        public Criteria andJypzNotBetween(Integer value1, Integer value2) {
            addCriterion("jypz not between", value1, value2, "jypz");
            return (Criteria) this;
        }

        public Criteria andBdtdIsNull() {
            addCriterion("bdtd is null");
            return (Criteria) this;
        }

        public Criteria andBdtdIsNotNull() {
            addCriterion("bdtd is not null");
            return (Criteria) this;
        }

        public Criteria andBdtdEqualTo(String value) {
            addCriterion("bdtd =", value, "bdtd");
            return (Criteria) this;
        }

        public Criteria andBdtdNotEqualTo(String value) {
            addCriterion("bdtd <>", value, "bdtd");
            return (Criteria) this;
        }

        public Criteria andBdtdGreaterThan(String value) {
            addCriterion("bdtd >", value, "bdtd");
            return (Criteria) this;
        }

        public Criteria andBdtdGreaterThanOrEqualTo(String value) {
            addCriterion("bdtd >=", value, "bdtd");
            return (Criteria) this;
        }

        public Criteria andBdtdLessThan(String value) {
            addCriterion("bdtd <", value, "bdtd");
            return (Criteria) this;
        }

        public Criteria andBdtdLessThanOrEqualTo(String value) {
            addCriterion("bdtd <=", value, "bdtd");
            return (Criteria) this;
        }

        public Criteria andBdtdLike(String value) {
            addCriterion("bdtd like", value, "bdtd");
            return (Criteria) this;
        }

        public Criteria andBdtdNotLike(String value) {
            addCriterion("bdtd not like", value, "bdtd");
            return (Criteria) this;
        }

        public Criteria andBdtdIn(List<String> values) {
            addCriterion("bdtd in", values, "bdtd");
            return (Criteria) this;
        }

        public Criteria andBdtdNotIn(List<String> values) {
            addCriterion("bdtd not in", values, "bdtd");
            return (Criteria) this;
        }

        public Criteria andBdtdBetween(String value1, String value2) {
            addCriterion("bdtd between", value1, value2, "bdtd");
            return (Criteria) this;
        }

        public Criteria andBdtdNotBetween(String value1, String value2) {
            addCriterion("bdtd not between", value1, value2, "bdtd");
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

        public Criteria andRzjIsNull() {
            addCriterion("rzj is null");
            return (Criteria) this;
        }

        public Criteria andRzjIsNotNull() {
            addCriterion("rzj is not null");
            return (Criteria) this;
        }

        public Criteria andRzjEqualTo(BigDecimal value) {
            addCriterion("rzj =", value, "rzj");
            return (Criteria) this;
        }

        public Criteria andRzjNotEqualTo(BigDecimal value) {
            addCriterion("rzj <>", value, "rzj");
            return (Criteria) this;
        }

        public Criteria andRzjGreaterThan(BigDecimal value) {
            addCriterion("rzj >", value, "rzj");
            return (Criteria) this;
        }

        public Criteria andRzjGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rzj >=", value, "rzj");
            return (Criteria) this;
        }

        public Criteria andRzjLessThan(BigDecimal value) {
            addCriterion("rzj <", value, "rzj");
            return (Criteria) this;
        }

        public Criteria andRzjLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rzj <=", value, "rzj");
            return (Criteria) this;
        }

        public Criteria andRzjIn(List<BigDecimal> values) {
            addCriterion("rzj in", values, "rzj");
            return (Criteria) this;
        }

        public Criteria andRzjNotIn(List<BigDecimal> values) {
            addCriterion("rzj not in", values, "rzj");
            return (Criteria) this;
        }

        public Criteria andRzjBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rzj between", value1, value2, "rzj");
            return (Criteria) this;
        }

        public Criteria andRzjNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rzj not between", value1, value2, "rzj");
            return (Criteria) this;
        }

        public Criteria andYjxIsNull() {
            addCriterion("yjx is null");
            return (Criteria) this;
        }

        public Criteria andYjxIsNotNull() {
            addCriterion("yjx is not null");
            return (Criteria) this;
        }

        public Criteria andYjxEqualTo(BigDecimal value) {
            addCriterion("yjx =", value, "yjx");
            return (Criteria) this;
        }

        public Criteria andYjxNotEqualTo(BigDecimal value) {
            addCriterion("yjx <>", value, "yjx");
            return (Criteria) this;
        }

        public Criteria andYjxGreaterThan(BigDecimal value) {
            addCriterion("yjx >", value, "yjx");
            return (Criteria) this;
        }

        public Criteria andYjxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("yjx >=", value, "yjx");
            return (Criteria) this;
        }

        public Criteria andYjxLessThan(BigDecimal value) {
            addCriterion("yjx <", value, "yjx");
            return (Criteria) this;
        }

        public Criteria andYjxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("yjx <=", value, "yjx");
            return (Criteria) this;
        }

        public Criteria andYjxIn(List<BigDecimal> values) {
            addCriterion("yjx in", values, "yjx");
            return (Criteria) this;
        }

        public Criteria andYjxNotIn(List<BigDecimal> values) {
            addCriterion("yjx not in", values, "yjx");
            return (Criteria) this;
        }

        public Criteria andYjxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("yjx between", value1, value2, "yjx");
            return (Criteria) this;
        }

        public Criteria andYjxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("yjx not between", value1, value2, "yjx");
            return (Criteria) this;
        }

        public Criteria andPcxIsNull() {
            addCriterion("pcx is null");
            return (Criteria) this;
        }

        public Criteria andPcxIsNotNull() {
            addCriterion("pcx is not null");
            return (Criteria) this;
        }

        public Criteria andPcxEqualTo(BigDecimal value) {
            addCriterion("pcx =", value, "pcx");
            return (Criteria) this;
        }

        public Criteria andPcxNotEqualTo(BigDecimal value) {
            addCriterion("pcx <>", value, "pcx");
            return (Criteria) this;
        }

        public Criteria andPcxGreaterThan(BigDecimal value) {
            addCriterion("pcx >", value, "pcx");
            return (Criteria) this;
        }

        public Criteria andPcxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pcx >=", value, "pcx");
            return (Criteria) this;
        }

        public Criteria andPcxLessThan(BigDecimal value) {
            addCriterion("pcx <", value, "pcx");
            return (Criteria) this;
        }

        public Criteria andPcxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pcx <=", value, "pcx");
            return (Criteria) this;
        }

        public Criteria andPcxIn(List<BigDecimal> values) {
            addCriterion("pcx in", values, "pcx");
            return (Criteria) this;
        }

        public Criteria andPcxNotIn(List<BigDecimal> values) {
            addCriterion("pcx not in", values, "pcx");
            return (Criteria) this;
        }

        public Criteria andPcxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pcx between", value1, value2, "pcx");
            return (Criteria) this;
        }

        public Criteria andPcxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pcx not between", value1, value2, "pcx");
            return (Criteria) this;
        }

        public Criteria andXzjIsNull() {
            addCriterion("xzj is null");
            return (Criteria) this;
        }

        public Criteria andXzjIsNotNull() {
            addCriterion("xzj is not null");
            return (Criteria) this;
        }

        public Criteria andXzjEqualTo(BigDecimal value) {
            addCriterion("xzj =", value, "xzj");
            return (Criteria) this;
        }

        public Criteria andXzjNotEqualTo(BigDecimal value) {
            addCriterion("xzj <>", value, "xzj");
            return (Criteria) this;
        }

        public Criteria andXzjGreaterThan(BigDecimal value) {
            addCriterion("xzj >", value, "xzj");
            return (Criteria) this;
        }

        public Criteria andXzjGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("xzj >=", value, "xzj");
            return (Criteria) this;
        }

        public Criteria andXzjLessThan(BigDecimal value) {
            addCriterion("xzj <", value, "xzj");
            return (Criteria) this;
        }

        public Criteria andXzjLessThanOrEqualTo(BigDecimal value) {
            addCriterion("xzj <=", value, "xzj");
            return (Criteria) this;
        }

        public Criteria andXzjIn(List<BigDecimal> values) {
            addCriterion("xzj in", values, "xzj");
            return (Criteria) this;
        }

        public Criteria andXzjNotIn(List<BigDecimal> values) {
            addCriterion("xzj not in", values, "xzj");
            return (Criteria) this;
        }

        public Criteria andXzjBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("xzj between", value1, value2, "xzj");
            return (Criteria) this;
        }

        public Criteria andXzjNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("xzj not between", value1, value2, "xzj");
            return (Criteria) this;
        }

        public Criteria andCcblIsNull() {
            addCriterion("ccbl is null");
            return (Criteria) this;
        }

        public Criteria andCcblIsNotNull() {
            addCriterion("ccbl is not null");
            return (Criteria) this;
        }

        public Criteria andCcblEqualTo(Integer value) {
            addCriterion("ccbl =", value, "ccbl");
            return (Criteria) this;
        }

        public Criteria andCcblNotEqualTo(Integer value) {
            addCriterion("ccbl <>", value, "ccbl");
            return (Criteria) this;
        }

        public Criteria andCcblGreaterThan(Integer value) {
            addCriterion("ccbl >", value, "ccbl");
            return (Criteria) this;
        }

        public Criteria andCcblGreaterThanOrEqualTo(Integer value) {
            addCriterion("ccbl >=", value, "ccbl");
            return (Criteria) this;
        }

        public Criteria andCcblLessThan(Integer value) {
            addCriterion("ccbl <", value, "ccbl");
            return (Criteria) this;
        }

        public Criteria andCcblLessThanOrEqualTo(Integer value) {
            addCriterion("ccbl <=", value, "ccbl");
            return (Criteria) this;
        }

        public Criteria andCcblIn(List<Integer> values) {
            addCriterion("ccbl in", values, "ccbl");
            return (Criteria) this;
        }

        public Criteria andCcblNotIn(List<Integer> values) {
            addCriterion("ccbl not in", values, "ccbl");
            return (Criteria) this;
        }

        public Criteria andCcblBetween(Integer value1, Integer value2) {
            addCriterion("ccbl between", value1, value2, "ccbl");
            return (Criteria) this;
        }

        public Criteria andCcblNotBetween(Integer value1, Integer value2) {
            addCriterion("ccbl not between", value1, value2, "ccbl");
            return (Criteria) this;
        }

        public Criteria andIsadminIsNull() {
            addCriterion("isadmin is null");
            return (Criteria) this;
        }

        public Criteria andIsadminIsNotNull() {
            addCriterion("isadmin is not null");
            return (Criteria) this;
        }

        public Criteria andIsadminEqualTo(Integer value) {
            addCriterion("isadmin =", value, "isadmin");
            return (Criteria) this;
        }

        public Criteria andIsadminNotEqualTo(Integer value) {
            addCriterion("isadmin <>", value, "isadmin");
            return (Criteria) this;
        }

        public Criteria andIsadminGreaterThan(Integer value) {
            addCriterion("isadmin >", value, "isadmin");
            return (Criteria) this;
        }

        public Criteria andIsadminGreaterThanOrEqualTo(Integer value) {
            addCriterion("isadmin >=", value, "isadmin");
            return (Criteria) this;
        }

        public Criteria andIsadminLessThan(Integer value) {
            addCriterion("isadmin <", value, "isadmin");
            return (Criteria) this;
        }

        public Criteria andIsadminLessThanOrEqualTo(Integer value) {
            addCriterion("isadmin <=", value, "isadmin");
            return (Criteria) this;
        }

        public Criteria andIsadminIn(List<Integer> values) {
            addCriterion("isadmin in", values, "isadmin");
            return (Criteria) this;
        }

        public Criteria andIsadminNotIn(List<Integer> values) {
            addCriterion("isadmin not in", values, "isadmin");
            return (Criteria) this;
        }

        public Criteria andIsadminBetween(Integer value1, Integer value2) {
            addCriterion("isadmin between", value1, value2, "isadmin");
            return (Criteria) this;
        }

        public Criteria andIsadminNotBetween(Integer value1, Integer value2) {
            addCriterion("isadmin not between", value1, value2, "isadmin");
            return (Criteria) this;
        }

        public Criteria andJyrightIsNull() {
            addCriterion("jyright is null");
            return (Criteria) this;
        }

        public Criteria andJyrightIsNotNull() {
            addCriterion("jyright is not null");
            return (Criteria) this;
        }

        public Criteria andJyrightEqualTo(String value) {
            addCriterion("jyright =", value, "jyright");
            return (Criteria) this;
        }

        public Criteria andJyrightNotEqualTo(String value) {
            addCriterion("jyright <>", value, "jyright");
            return (Criteria) this;
        }

        public Criteria andJyrightGreaterThan(String value) {
            addCriterion("jyright >", value, "jyright");
            return (Criteria) this;
        }

        public Criteria andJyrightGreaterThanOrEqualTo(String value) {
            addCriterion("jyright >=", value, "jyright");
            return (Criteria) this;
        }

        public Criteria andJyrightLessThan(String value) {
            addCriterion("jyright <", value, "jyright");
            return (Criteria) this;
        }

        public Criteria andJyrightLessThanOrEqualTo(String value) {
            addCriterion("jyright <=", value, "jyright");
            return (Criteria) this;
        }

        public Criteria andJyrightLike(String value) {
            addCriterion("jyright like", value, "jyright");
            return (Criteria) this;
        }

        public Criteria andJyrightNotLike(String value) {
            addCriterion("jyright not like", value, "jyright");
            return (Criteria) this;
        }

        public Criteria andJyrightIn(List<String> values) {
            addCriterion("jyright in", values, "jyright");
            return (Criteria) this;
        }

        public Criteria andJyrightNotIn(List<String> values) {
            addCriterion("jyright not in", values, "jyright");
            return (Criteria) this;
        }

        public Criteria andJyrightBetween(String value1, String value2) {
            addCriterion("jyright between", value1, value2, "jyright");
            return (Criteria) this;
        }

        public Criteria andJyrightNotBetween(String value1, String value2) {
            addCriterion("jyright not between", value1, value2, "jyright");
            return (Criteria) this;
        }

        public Criteria andRiskstateIsNull() {
            addCriterion("riskstate is null");
            return (Criteria) this;
        }

        public Criteria andRiskstateIsNotNull() {
            addCriterion("riskstate is not null");
            return (Criteria) this;
        }

        public Criteria andRiskstateEqualTo(Integer value) {
            addCriterion("riskstate =", value, "riskstate");
            return (Criteria) this;
        }

        public Criteria andRiskstateNotEqualTo(Integer value) {
            addCriterion("riskstate <>", value, "riskstate");
            return (Criteria) this;
        }

        public Criteria andRiskstateGreaterThan(Integer value) {
            addCriterion("riskstate >", value, "riskstate");
            return (Criteria) this;
        }

        public Criteria andRiskstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("riskstate >=", value, "riskstate");
            return (Criteria) this;
        }

        public Criteria andRiskstateLessThan(Integer value) {
            addCriterion("riskstate <", value, "riskstate");
            return (Criteria) this;
        }

        public Criteria andRiskstateLessThanOrEqualTo(Integer value) {
            addCriterion("riskstate <=", value, "riskstate");
            return (Criteria) this;
        }

        public Criteria andRiskstateIn(List<Integer> values) {
            addCriterion("riskstate in", values, "riskstate");
            return (Criteria) this;
        }

        public Criteria andRiskstateNotIn(List<Integer> values) {
            addCriterion("riskstate not in", values, "riskstate");
            return (Criteria) this;
        }

        public Criteria andRiskstateBetween(Integer value1, Integer value2) {
            addCriterion("riskstate between", value1, value2, "riskstate");
            return (Criteria) this;
        }

        public Criteria andRiskstateNotBetween(Integer value1, Integer value2) {
            addCriterion("riskstate not between", value1, value2, "riskstate");
            return (Criteria) this;
        }

        public Criteria andMncjIsNull() {
            addCriterion("mncj is null");
            return (Criteria) this;
        }

        public Criteria andMncjIsNotNull() {
            addCriterion("mncj is not null");
            return (Criteria) this;
        }

        public Criteria andMncjEqualTo(Integer value) {
            addCriterion("mncj =", value, "mncj");
            return (Criteria) this;
        }

        public Criteria andMncjNotEqualTo(Integer value) {
            addCriterion("mncj <>", value, "mncj");
            return (Criteria) this;
        }

        public Criteria andMncjGreaterThan(Integer value) {
            addCriterion("mncj >", value, "mncj");
            return (Criteria) this;
        }

        public Criteria andMncjGreaterThanOrEqualTo(Integer value) {
            addCriterion("mncj >=", value, "mncj");
            return (Criteria) this;
        }

        public Criteria andMncjLessThan(Integer value) {
            addCriterion("mncj <", value, "mncj");
            return (Criteria) this;
        }

        public Criteria andMncjLessThanOrEqualTo(Integer value) {
            addCriterion("mncj <=", value, "mncj");
            return (Criteria) this;
        }

        public Criteria andMncjIn(List<Integer> values) {
            addCriterion("mncj in", values, "mncj");
            return (Criteria) this;
        }

        public Criteria andMncjNotIn(List<Integer> values) {
            addCriterion("mncj not in", values, "mncj");
            return (Criteria) this;
        }

        public Criteria andMncjBetween(Integer value1, Integer value2) {
            addCriterion("mncj between", value1, value2, "mncj");
            return (Criteria) this;
        }

        public Criteria andMncjNotBetween(Integer value1, Integer value2) {
            addCriterion("mncj not between", value1, value2, "mncj");
            return (Criteria) this;
        }

        public Criteria andRiskholderidIsNull() {
            addCriterion("riskHolderId is null");
            return (Criteria) this;
        }

        public Criteria andRiskholderidIsNotNull() {
            addCriterion("riskHolderId is not null");
            return (Criteria) this;
        }

        public Criteria andRiskholderidEqualTo(String value) {
            addCriterion("riskHolderId =", value, "riskholderid");
            return (Criteria) this;
        }

        public Criteria andRiskholderidNotEqualTo(String value) {
            addCriterion("riskHolderId <>", value, "riskholderid");
            return (Criteria) this;
        }

        public Criteria andRiskholderidGreaterThan(String value) {
            addCriterion("riskHolderId >", value, "riskholderid");
            return (Criteria) this;
        }

        public Criteria andRiskholderidGreaterThanOrEqualTo(String value) {
            addCriterion("riskHolderId >=", value, "riskholderid");
            return (Criteria) this;
        }

        public Criteria andRiskholderidLessThan(String value) {
            addCriterion("riskHolderId <", value, "riskholderid");
            return (Criteria) this;
        }

        public Criteria andRiskholderidLessThanOrEqualTo(String value) {
            addCriterion("riskHolderId <=", value, "riskholderid");
            return (Criteria) this;
        }

        public Criteria andRiskholderidLike(String value) {
            addCriterion("riskHolderId like", value, "riskholderid");
            return (Criteria) this;
        }

        public Criteria andRiskholderidNotLike(String value) {
            addCriterion("riskHolderId not like", value, "riskholderid");
            return (Criteria) this;
        }

        public Criteria andRiskholderidIn(List<String> values) {
            addCriterion("riskHolderId in", values, "riskholderid");
            return (Criteria) this;
        }

        public Criteria andRiskholderidNotIn(List<String> values) {
            addCriterion("riskHolderId not in", values, "riskholderid");
            return (Criteria) this;
        }

        public Criteria andRiskholderidBetween(String value1, String value2) {
            addCriterion("riskHolderId between", value1, value2, "riskholderid");
            return (Criteria) this;
        }

        public Criteria andRiskholderidNotBetween(String value1, String value2) {
            addCriterion("riskHolderId not between", value1, value2, "riskholderid");
            return (Criteria) this;
        }

        public Criteria andFundbalanceIsNull() {
            addCriterion("fundBalance is null");
            return (Criteria) this;
        }

        public Criteria andFundbalanceIsNotNull() {
            addCriterion("fundBalance is not null");
            return (Criteria) this;
        }

        public Criteria andFundbalanceEqualTo(BigDecimal value) {
            addCriterion("fundBalance =", value, "fundbalance");
            return (Criteria) this;
        }

        public Criteria andFundbalanceNotEqualTo(BigDecimal value) {
            addCriterion("fundBalance <>", value, "fundbalance");
            return (Criteria) this;
        }

        public Criteria andFundbalanceGreaterThan(BigDecimal value) {
            addCriterion("fundBalance >", value, "fundbalance");
            return (Criteria) this;
        }

        public Criteria andFundbalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fundBalance >=", value, "fundbalance");
            return (Criteria) this;
        }

        public Criteria andFundbalanceLessThan(BigDecimal value) {
            addCriterion("fundBalance <", value, "fundbalance");
            return (Criteria) this;
        }

        public Criteria andFundbalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fundBalance <=", value, "fundbalance");
            return (Criteria) this;
        }

        public Criteria andFundbalanceIn(List<BigDecimal> values) {
            addCriterion("fundBalance in", values, "fundbalance");
            return (Criteria) this;
        }

        public Criteria andFundbalanceNotIn(List<BigDecimal> values) {
            addCriterion("fundBalance not in", values, "fundbalance");
            return (Criteria) this;
        }

        public Criteria andFundbalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fundBalance between", value1, value2, "fundbalance");
            return (Criteria) this;
        }

        public Criteria andFundbalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fundBalance not between", value1, value2, "fundbalance");
            return (Criteria) this;
        }

        public Criteria andMunbernoIsNull() {
            addCriterion("munberno is null");
            return (Criteria) this;
        }

        public Criteria andMunbernoIsNotNull() {
            addCriterion("munberno is not null");
            return (Criteria) this;
        }

        public Criteria andMunbernoEqualTo(String value) {
            addCriterion("munberno =", value, "munberno");
            return (Criteria) this;
        }

        public Criteria andMunbernoNotEqualTo(String value) {
            addCriterion("munberno <>", value, "munberno");
            return (Criteria) this;
        }

        public Criteria andMunbernoGreaterThan(String value) {
            addCriterion("munberno >", value, "munberno");
            return (Criteria) this;
        }

        public Criteria andMunbernoGreaterThanOrEqualTo(String value) {
            addCriterion("munberno >=", value, "munberno");
            return (Criteria) this;
        }

        public Criteria andMunbernoLessThan(String value) {
            addCriterion("munberno <", value, "munberno");
            return (Criteria) this;
        }

        public Criteria andMunbernoLessThanOrEqualTo(String value) {
            addCriterion("munberno <=", value, "munberno");
            return (Criteria) this;
        }

        public Criteria andMunbernoLike(String value) {
            addCriterion("munberno like", value, "munberno");
            return (Criteria) this;
        }

        public Criteria andMunbernoNotLike(String value) {
            addCriterion("munberno not like", value, "munberno");
            return (Criteria) this;
        }

        public Criteria andMunbernoIn(List<String> values) {
            addCriterion("munberno in", values, "munberno");
            return (Criteria) this;
        }

        public Criteria andMunbernoNotIn(List<String> values) {
            addCriterion("munberno not in", values, "munberno");
            return (Criteria) this;
        }

        public Criteria andMunbernoBetween(String value1, String value2) {
            addCriterion("munberno between", value1, value2, "munberno");
            return (Criteria) this;
        }

        public Criteria andMunbernoNotBetween(String value1, String value2) {
            addCriterion("munberno not between", value1, value2, "munberno");
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

        public Criteria andProportionIsNull() {
            addCriterion("proportion is null");
            return (Criteria) this;
        }

        public Criteria andProportionIsNotNull() {
            addCriterion("proportion is not null");
            return (Criteria) this;
        }

        public Criteria andProportionEqualTo(Double value) {
            addCriterion("proportion =", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionNotEqualTo(Double value) {
            addCriterion("proportion <>", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionGreaterThan(Double value) {
            addCriterion("proportion >", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionGreaterThanOrEqualTo(Double value) {
            addCriterion("proportion >=", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionLessThan(Double value) {
            addCriterion("proportion <", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionLessThanOrEqualTo(Double value) {
            addCriterion("proportion <=", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionIn(List<Double> values) {
            addCriterion("proportion in", values, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionNotIn(List<Double> values) {
            addCriterion("proportion not in", values, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionBetween(Double value1, Double value2) {
            addCriterion("proportion between", value1, value2, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionNotBetween(Double value1, Double value2) {
            addCriterion("proportion not between", value1, value2, "proportion");
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