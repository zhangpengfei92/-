package com.jcl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DocumentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DocumentExample() {
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

        public Criteria andDidIsNull() {
            addCriterion("did is null");
            return (Criteria) this;
        }

        public Criteria andDidIsNotNull() {
            addCriterion("did is not null");
            return (Criteria) this;
        }

        public Criteria andDidEqualTo(Integer value) {
            addCriterion("did =", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotEqualTo(Integer value) {
            addCriterion("did <>", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidGreaterThan(Integer value) {
            addCriterion("did >", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidGreaterThanOrEqualTo(Integer value) {
            addCriterion("did >=", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidLessThan(Integer value) {
            addCriterion("did <", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidLessThanOrEqualTo(Integer value) {
            addCriterion("did <=", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidIn(List<Integer> values) {
            addCriterion("did in", values, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotIn(List<Integer> values) {
            addCriterion("did not in", values, "did");
            return (Criteria) this;
        }

        public Criteria andDidBetween(Integer value1, Integer value2) {
            addCriterion("did between", value1, value2, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotBetween(Integer value1, Integer value2) {
            addCriterion("did not between", value1, value2, "did");
            return (Criteria) this;
        }

        public Criteria andDocnameIsNull() {
            addCriterion("docname is null");
            return (Criteria) this;
        }

        public Criteria andDocnameIsNotNull() {
            addCriterion("docname is not null");
            return (Criteria) this;
        }

        public Criteria andDocnameEqualTo(String value) {
            addCriterion("docname =", value, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameNotEqualTo(String value) {
            addCriterion("docname <>", value, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameGreaterThan(String value) {
            addCriterion("docname >", value, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameGreaterThanOrEqualTo(String value) {
            addCriterion("docname >=", value, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameLessThan(String value) {
            addCriterion("docname <", value, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameLessThanOrEqualTo(String value) {
            addCriterion("docname <=", value, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameLike(String value) {
            addCriterion("docname like", value, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameNotLike(String value) {
            addCriterion("docname not like", value, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameIn(List<String> values) {
            addCriterion("docname in", values, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameNotIn(List<String> values) {
            addCriterion("docname not in", values, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameBetween(String value1, String value2) {
            addCriterion("docname between", value1, value2, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameNotBetween(String value1, String value2) {
            addCriterion("docname not between", value1, value2, "docname");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andDoctimeIsNull() {
            addCriterion("doctime is null");
            return (Criteria) this;
        }

        public Criteria andDoctimeIsNotNull() {
            addCriterion("doctime is not null");
            return (Criteria) this;
        }

        public Criteria andDoctimeEqualTo(Date value) {
            addCriterion("doctime =", value, "doctime");
            return (Criteria) this;
        }

        public Criteria andDoctimeNotEqualTo(Date value) {
            addCriterion("doctime <>", value, "doctime");
            return (Criteria) this;
        }

        public Criteria andDoctimeGreaterThan(Date value) {
            addCriterion("doctime >", value, "doctime");
            return (Criteria) this;
        }

        public Criteria andDoctimeGreaterThanOrEqualTo(Date value) {
            addCriterion("doctime >=", value, "doctime");
            return (Criteria) this;
        }

        public Criteria andDoctimeLessThan(Date value) {
            addCriterion("doctime <", value, "doctime");
            return (Criteria) this;
        }

        public Criteria andDoctimeLessThanOrEqualTo(Date value) {
            addCriterion("doctime <=", value, "doctime");
            return (Criteria) this;
        }

        public Criteria andDoctimeIn(List<Date> values) {
            addCriterion("doctime in", values, "doctime");
            return (Criteria) this;
        }

        public Criteria andDoctimeNotIn(List<Date> values) {
            addCriterion("doctime not in", values, "doctime");
            return (Criteria) this;
        }

        public Criteria andDoctimeBetween(Date value1, Date value2) {
            addCriterion("doctime between", value1, value2, "doctime");
            return (Criteria) this;
        }

        public Criteria andDoctimeNotBetween(Date value1, Date value2) {
            addCriterion("doctime not between", value1, value2, "doctime");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andDocstateIsNull() {
            addCriterion("docstate is null");
            return (Criteria) this;
        }

        public Criteria andDocstateIsNotNull() {
            addCriterion("docstate is not null");
            return (Criteria) this;
        }

        public Criteria andDocstateEqualTo(Integer value) {
            addCriterion("docstate =", value, "docstate");
            return (Criteria) this;
        }

        public Criteria andDocstateNotEqualTo(Integer value) {
            addCriterion("docstate <>", value, "docstate");
            return (Criteria) this;
        }

        public Criteria andDocstateGreaterThan(Integer value) {
            addCriterion("docstate >", value, "docstate");
            return (Criteria) this;
        }

        public Criteria andDocstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("docstate >=", value, "docstate");
            return (Criteria) this;
        }

        public Criteria andDocstateLessThan(Integer value) {
            addCriterion("docstate <", value, "docstate");
            return (Criteria) this;
        }

        public Criteria andDocstateLessThanOrEqualTo(Integer value) {
            addCriterion("docstate <=", value, "docstate");
            return (Criteria) this;
        }

        public Criteria andDocstateIn(List<Integer> values) {
            addCriterion("docstate in", values, "docstate");
            return (Criteria) this;
        }

        public Criteria andDocstateNotIn(List<Integer> values) {
            addCriterion("docstate not in", values, "docstate");
            return (Criteria) this;
        }

        public Criteria andDocstateBetween(Integer value1, Integer value2) {
            addCriterion("docstate between", value1, value2, "docstate");
            return (Criteria) this;
        }

        public Criteria andDocstateNotBetween(Integer value1, Integer value2) {
            addCriterion("docstate not between", value1, value2, "docstate");
            return (Criteria) this;
        }

        public Criteria andDocurlIsNull() {
            addCriterion("docurl is null");
            return (Criteria) this;
        }

        public Criteria andDocurlIsNotNull() {
            addCriterion("docurl is not null");
            return (Criteria) this;
        }

        public Criteria andDocurlEqualTo(String value) {
            addCriterion("docurl =", value, "docurl");
            return (Criteria) this;
        }

        public Criteria andDocurlNotEqualTo(String value) {
            addCriterion("docurl <>", value, "docurl");
            return (Criteria) this;
        }

        public Criteria andDocurlGreaterThan(String value) {
            addCriterion("docurl >", value, "docurl");
            return (Criteria) this;
        }

        public Criteria andDocurlGreaterThanOrEqualTo(String value) {
            addCriterion("docurl >=", value, "docurl");
            return (Criteria) this;
        }

        public Criteria andDocurlLessThan(String value) {
            addCriterion("docurl <", value, "docurl");
            return (Criteria) this;
        }

        public Criteria andDocurlLessThanOrEqualTo(String value) {
            addCriterion("docurl <=", value, "docurl");
            return (Criteria) this;
        }

        public Criteria andDocurlLike(String value) {
            addCriterion("docurl like", value, "docurl");
            return (Criteria) this;
        }

        public Criteria andDocurlNotLike(String value) {
            addCriterion("docurl not like", value, "docurl");
            return (Criteria) this;
        }

        public Criteria andDocurlIn(List<String> values) {
            addCriterion("docurl in", values, "docurl");
            return (Criteria) this;
        }

        public Criteria andDocurlNotIn(List<String> values) {
            addCriterion("docurl not in", values, "docurl");
            return (Criteria) this;
        }

        public Criteria andDocurlBetween(String value1, String value2) {
            addCriterion("docurl between", value1, value2, "docurl");
            return (Criteria) this;
        }

        public Criteria andDocurlNotBetween(String value1, String value2) {
            addCriterion("docurl not between", value1, value2, "docurl");
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