package com.jcl.pojo;

import java.util.ArrayList;
import java.util.List;

public class AppHelpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppHelpExample() {
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

        public Criteria andAboutusIsNull() {
            addCriterion("aboutus is null");
            return (Criteria) this;
        }

        public Criteria andAboutusIsNotNull() {
            addCriterion("aboutus is not null");
            return (Criteria) this;
        }

        public Criteria andAboutusEqualTo(String value) {
            addCriterion("aboutus =", value, "aboutus");
            return (Criteria) this;
        }

        public Criteria andAboutusNotEqualTo(String value) {
            addCriterion("aboutus <>", value, "aboutus");
            return (Criteria) this;
        }

        public Criteria andAboutusGreaterThan(String value) {
            addCriterion("aboutus >", value, "aboutus");
            return (Criteria) this;
        }

        public Criteria andAboutusGreaterThanOrEqualTo(String value) {
            addCriterion("aboutus >=", value, "aboutus");
            return (Criteria) this;
        }

        public Criteria andAboutusLessThan(String value) {
            addCriterion("aboutus <", value, "aboutus");
            return (Criteria) this;
        }

        public Criteria andAboutusLessThanOrEqualTo(String value) {
            addCriterion("aboutus <=", value, "aboutus");
            return (Criteria) this;
        }

        public Criteria andAboutusLike(String value) {
            addCriterion("aboutus like", value, "aboutus");
            return (Criteria) this;
        }

        public Criteria andAboutusNotLike(String value) {
            addCriterion("aboutus not like", value, "aboutus");
            return (Criteria) this;
        }

        public Criteria andAboutusIn(List<String> values) {
            addCriterion("aboutus in", values, "aboutus");
            return (Criteria) this;
        }

        public Criteria andAboutusNotIn(List<String> values) {
            addCriterion("aboutus not in", values, "aboutus");
            return (Criteria) this;
        }

        public Criteria andAboutusBetween(String value1, String value2) {
            addCriterion("aboutus between", value1, value2, "aboutus");
            return (Criteria) this;
        }

        public Criteria andAboutusNotBetween(String value1, String value2) {
            addCriterion("aboutus not between", value1, value2, "aboutus");
            return (Criteria) this;
        }

        public Criteria andJylcIsNull() {
            addCriterion("jylc is null");
            return (Criteria) this;
        }

        public Criteria andJylcIsNotNull() {
            addCriterion("jylc is not null");
            return (Criteria) this;
        }

        public Criteria andJylcEqualTo(String value) {
            addCriterion("jylc =", value, "jylc");
            return (Criteria) this;
        }

        public Criteria andJylcNotEqualTo(String value) {
            addCriterion("jylc <>", value, "jylc");
            return (Criteria) this;
        }

        public Criteria andJylcGreaterThan(String value) {
            addCriterion("jylc >", value, "jylc");
            return (Criteria) this;
        }

        public Criteria andJylcGreaterThanOrEqualTo(String value) {
            addCriterion("jylc >=", value, "jylc");
            return (Criteria) this;
        }

        public Criteria andJylcLessThan(String value) {
            addCriterion("jylc <", value, "jylc");
            return (Criteria) this;
        }

        public Criteria andJylcLessThanOrEqualTo(String value) {
            addCriterion("jylc <=", value, "jylc");
            return (Criteria) this;
        }

        public Criteria andJylcLike(String value) {
            addCriterion("jylc like", value, "jylc");
            return (Criteria) this;
        }

        public Criteria andJylcNotLike(String value) {
            addCriterion("jylc not like", value, "jylc");
            return (Criteria) this;
        }

        public Criteria andJylcIn(List<String> values) {
            addCriterion("jylc in", values, "jylc");
            return (Criteria) this;
        }

        public Criteria andJylcNotIn(List<String> values) {
            addCriterion("jylc not in", values, "jylc");
            return (Criteria) this;
        }

        public Criteria andJylcBetween(String value1, String value2) {
            addCriterion("jylc between", value1, value2, "jylc");
            return (Criteria) this;
        }

        public Criteria andJylcNotBetween(String value1, String value2) {
            addCriterion("jylc not between", value1, value2, "jylc");
            return (Criteria) this;
        }

        public Criteria andPttdIsNull() {
            addCriterion("pttd is null");
            return (Criteria) this;
        }

        public Criteria andPttdIsNotNull() {
            addCriterion("pttd is not null");
            return (Criteria) this;
        }

        public Criteria andPttdEqualTo(String value) {
            addCriterion("pttd =", value, "pttd");
            return (Criteria) this;
        }

        public Criteria andPttdNotEqualTo(String value) {
            addCriterion("pttd <>", value, "pttd");
            return (Criteria) this;
        }

        public Criteria andPttdGreaterThan(String value) {
            addCriterion("pttd >", value, "pttd");
            return (Criteria) this;
        }

        public Criteria andPttdGreaterThanOrEqualTo(String value) {
            addCriterion("pttd >=", value, "pttd");
            return (Criteria) this;
        }

        public Criteria andPttdLessThan(String value) {
            addCriterion("pttd <", value, "pttd");
            return (Criteria) this;
        }

        public Criteria andPttdLessThanOrEqualTo(String value) {
            addCriterion("pttd <=", value, "pttd");
            return (Criteria) this;
        }

        public Criteria andPttdLike(String value) {
            addCriterion("pttd like", value, "pttd");
            return (Criteria) this;
        }

        public Criteria andPttdNotLike(String value) {
            addCriterion("pttd not like", value, "pttd");
            return (Criteria) this;
        }

        public Criteria andPttdIn(List<String> values) {
            addCriterion("pttd in", values, "pttd");
            return (Criteria) this;
        }

        public Criteria andPttdNotIn(List<String> values) {
            addCriterion("pttd not in", values, "pttd");
            return (Criteria) this;
        }

        public Criteria andPttdBetween(String value1, String value2) {
            addCriterion("pttd between", value1, value2, "pttd");
            return (Criteria) this;
        }

        public Criteria andPttdNotBetween(String value1, String value2) {
            addCriterion("pttd not between", value1, value2, "pttd");
            return (Criteria) this;
        }

        public Criteria andSfbzIsNull() {
            addCriterion("sfbz is null");
            return (Criteria) this;
        }

        public Criteria andSfbzIsNotNull() {
            addCriterion("sfbz is not null");
            return (Criteria) this;
        }

        public Criteria andSfbzEqualTo(String value) {
            addCriterion("sfbz =", value, "sfbz");
            return (Criteria) this;
        }

        public Criteria andSfbzNotEqualTo(String value) {
            addCriterion("sfbz <>", value, "sfbz");
            return (Criteria) this;
        }

        public Criteria andSfbzGreaterThan(String value) {
            addCriterion("sfbz >", value, "sfbz");
            return (Criteria) this;
        }

        public Criteria andSfbzGreaterThanOrEqualTo(String value) {
            addCriterion("sfbz >=", value, "sfbz");
            return (Criteria) this;
        }

        public Criteria andSfbzLessThan(String value) {
            addCriterion("sfbz <", value, "sfbz");
            return (Criteria) this;
        }

        public Criteria andSfbzLessThanOrEqualTo(String value) {
            addCriterion("sfbz <=", value, "sfbz");
            return (Criteria) this;
        }

        public Criteria andSfbzLike(String value) {
            addCriterion("sfbz like", value, "sfbz");
            return (Criteria) this;
        }

        public Criteria andSfbzNotLike(String value) {
            addCriterion("sfbz not like", value, "sfbz");
            return (Criteria) this;
        }

        public Criteria andSfbzIn(List<String> values) {
            addCriterion("sfbz in", values, "sfbz");
            return (Criteria) this;
        }

        public Criteria andSfbzNotIn(List<String> values) {
            addCriterion("sfbz not in", values, "sfbz");
            return (Criteria) this;
        }

        public Criteria andSfbzBetween(String value1, String value2) {
            addCriterion("sfbz between", value1, value2, "sfbz");
            return (Criteria) this;
        }

        public Criteria andSfbzNotBetween(String value1, String value2) {
            addCriterion("sfbz not between", value1, value2, "sfbz");
            return (Criteria) this;
        }

        public Criteria andLybzjIsNull() {
            addCriterion("lybzj is null");
            return (Criteria) this;
        }

        public Criteria andLybzjIsNotNull() {
            addCriterion("lybzj is not null");
            return (Criteria) this;
        }

        public Criteria andLybzjEqualTo(String value) {
            addCriterion("lybzj =", value, "lybzj");
            return (Criteria) this;
        }

        public Criteria andLybzjNotEqualTo(String value) {
            addCriterion("lybzj <>", value, "lybzj");
            return (Criteria) this;
        }

        public Criteria andLybzjGreaterThan(String value) {
            addCriterion("lybzj >", value, "lybzj");
            return (Criteria) this;
        }

        public Criteria andLybzjGreaterThanOrEqualTo(String value) {
            addCriterion("lybzj >=", value, "lybzj");
            return (Criteria) this;
        }

        public Criteria andLybzjLessThan(String value) {
            addCriterion("lybzj <", value, "lybzj");
            return (Criteria) this;
        }

        public Criteria andLybzjLessThanOrEqualTo(String value) {
            addCriterion("lybzj <=", value, "lybzj");
            return (Criteria) this;
        }

        public Criteria andLybzjLike(String value) {
            addCriterion("lybzj like", value, "lybzj");
            return (Criteria) this;
        }

        public Criteria andLybzjNotLike(String value) {
            addCriterion("lybzj not like", value, "lybzj");
            return (Criteria) this;
        }

        public Criteria andLybzjIn(List<String> values) {
            addCriterion("lybzj in", values, "lybzj");
            return (Criteria) this;
        }

        public Criteria andLybzjNotIn(List<String> values) {
            addCriterion("lybzj not in", values, "lybzj");
            return (Criteria) this;
        }

        public Criteria andLybzjBetween(String value1, String value2) {
            addCriterion("lybzj between", value1, value2, "lybzj");
            return (Criteria) this;
        }

        public Criteria andLybzjNotBetween(String value1, String value2) {
            addCriterion("lybzj not between", value1, value2, "lybzj");
            return (Criteria) this;
        }

        public Criteria andYlfpIsNull() {
            addCriterion("ylfp is null");
            return (Criteria) this;
        }

        public Criteria andYlfpIsNotNull() {
            addCriterion("ylfp is not null");
            return (Criteria) this;
        }

        public Criteria andYlfpEqualTo(String value) {
            addCriterion("ylfp =", value, "ylfp");
            return (Criteria) this;
        }

        public Criteria andYlfpNotEqualTo(String value) {
            addCriterion("ylfp <>", value, "ylfp");
            return (Criteria) this;
        }

        public Criteria andYlfpGreaterThan(String value) {
            addCriterion("ylfp >", value, "ylfp");
            return (Criteria) this;
        }

        public Criteria andYlfpGreaterThanOrEqualTo(String value) {
            addCriterion("ylfp >=", value, "ylfp");
            return (Criteria) this;
        }

        public Criteria andYlfpLessThan(String value) {
            addCriterion("ylfp <", value, "ylfp");
            return (Criteria) this;
        }

        public Criteria andYlfpLessThanOrEqualTo(String value) {
            addCriterion("ylfp <=", value, "ylfp");
            return (Criteria) this;
        }

        public Criteria andYlfpLike(String value) {
            addCriterion("ylfp like", value, "ylfp");
            return (Criteria) this;
        }

        public Criteria andYlfpNotLike(String value) {
            addCriterion("ylfp not like", value, "ylfp");
            return (Criteria) this;
        }

        public Criteria andYlfpIn(List<String> values) {
            addCriterion("ylfp in", values, "ylfp");
            return (Criteria) this;
        }

        public Criteria andYlfpNotIn(List<String> values) {
            addCriterion("ylfp not in", values, "ylfp");
            return (Criteria) this;
        }

        public Criteria andYlfpBetween(String value1, String value2) {
            addCriterion("ylfp between", value1, value2, "ylfp");
            return (Criteria) this;
        }

        public Criteria andYlfpNotBetween(String value1, String value2) {
            addCriterion("ylfp not between", value1, value2, "ylfp");
            return (Criteria) this;
        }

        public Criteria andMrfwIsNull() {
            addCriterion("mrfw is null");
            return (Criteria) this;
        }

        public Criteria andMrfwIsNotNull() {
            addCriterion("mrfw is not null");
            return (Criteria) this;
        }

        public Criteria andMrfwEqualTo(String value) {
            addCriterion("mrfw =", value, "mrfw");
            return (Criteria) this;
        }

        public Criteria andMrfwNotEqualTo(String value) {
            addCriterion("mrfw <>", value, "mrfw");
            return (Criteria) this;
        }

        public Criteria andMrfwGreaterThan(String value) {
            addCriterion("mrfw >", value, "mrfw");
            return (Criteria) this;
        }

        public Criteria andMrfwGreaterThanOrEqualTo(String value) {
            addCriterion("mrfw >=", value, "mrfw");
            return (Criteria) this;
        }

        public Criteria andMrfwLessThan(String value) {
            addCriterion("mrfw <", value, "mrfw");
            return (Criteria) this;
        }

        public Criteria andMrfwLessThanOrEqualTo(String value) {
            addCriterion("mrfw <=", value, "mrfw");
            return (Criteria) this;
        }

        public Criteria andMrfwLike(String value) {
            addCriterion("mrfw like", value, "mrfw");
            return (Criteria) this;
        }

        public Criteria andMrfwNotLike(String value) {
            addCriterion("mrfw not like", value, "mrfw");
            return (Criteria) this;
        }

        public Criteria andMrfwIn(List<String> values) {
            addCriterion("mrfw in", values, "mrfw");
            return (Criteria) this;
        }

        public Criteria andMrfwNotIn(List<String> values) {
            addCriterion("mrfw not in", values, "mrfw");
            return (Criteria) this;
        }

        public Criteria andMrfwBetween(String value1, String value2) {
            addCriterion("mrfw between", value1, value2, "mrfw");
            return (Criteria) this;
        }

        public Criteria andMrfwNotBetween(String value1, String value2) {
            addCriterion("mrfw not between", value1, value2, "mrfw");
            return (Criteria) this;
        }

        public Criteria andJysjIsNull() {
            addCriterion("jysj is null");
            return (Criteria) this;
        }

        public Criteria andJysjIsNotNull() {
            addCriterion("jysj is not null");
            return (Criteria) this;
        }

        public Criteria andJysjEqualTo(String value) {
            addCriterion("jysj =", value, "jysj");
            return (Criteria) this;
        }

        public Criteria andJysjNotEqualTo(String value) {
            addCriterion("jysj <>", value, "jysj");
            return (Criteria) this;
        }

        public Criteria andJysjGreaterThan(String value) {
            addCriterion("jysj >", value, "jysj");
            return (Criteria) this;
        }

        public Criteria andJysjGreaterThanOrEqualTo(String value) {
            addCriterion("jysj >=", value, "jysj");
            return (Criteria) this;
        }

        public Criteria andJysjLessThan(String value) {
            addCriterion("jysj <", value, "jysj");
            return (Criteria) this;
        }

        public Criteria andJysjLessThanOrEqualTo(String value) {
            addCriterion("jysj <=", value, "jysj");
            return (Criteria) this;
        }

        public Criteria andJysjLike(String value) {
            addCriterion("jysj like", value, "jysj");
            return (Criteria) this;
        }

        public Criteria andJysjNotLike(String value) {
            addCriterion("jysj not like", value, "jysj");
            return (Criteria) this;
        }

        public Criteria andJysjIn(List<String> values) {
            addCriterion("jysj in", values, "jysj");
            return (Criteria) this;
        }

        public Criteria andJysjNotIn(List<String> values) {
            addCriterion("jysj not in", values, "jysj");
            return (Criteria) this;
        }

        public Criteria andJysjBetween(String value1, String value2) {
            addCriterion("jysj between", value1, value2, "jysj");
            return (Criteria) this;
        }

        public Criteria andJysjNotBetween(String value1, String value2) {
            addCriterion("jysj not between", value1, value2, "jysj");
            return (Criteria) this;
        }

        public Criteria andGyyjpcIsNull() {
            addCriterion("gyyjpc is null");
            return (Criteria) this;
        }

        public Criteria andGyyjpcIsNotNull() {
            addCriterion("gyyjpc is not null");
            return (Criteria) this;
        }

        public Criteria andGyyjpcEqualTo(String value) {
            addCriterion("gyyjpc =", value, "gyyjpc");
            return (Criteria) this;
        }

        public Criteria andGyyjpcNotEqualTo(String value) {
            addCriterion("gyyjpc <>", value, "gyyjpc");
            return (Criteria) this;
        }

        public Criteria andGyyjpcGreaterThan(String value) {
            addCriterion("gyyjpc >", value, "gyyjpc");
            return (Criteria) this;
        }

        public Criteria andGyyjpcGreaterThanOrEqualTo(String value) {
            addCriterion("gyyjpc >=", value, "gyyjpc");
            return (Criteria) this;
        }

        public Criteria andGyyjpcLessThan(String value) {
            addCriterion("gyyjpc <", value, "gyyjpc");
            return (Criteria) this;
        }

        public Criteria andGyyjpcLessThanOrEqualTo(String value) {
            addCriterion("gyyjpc <=", value, "gyyjpc");
            return (Criteria) this;
        }

        public Criteria andGyyjpcLike(String value) {
            addCriterion("gyyjpc like", value, "gyyjpc");
            return (Criteria) this;
        }

        public Criteria andGyyjpcNotLike(String value) {
            addCriterion("gyyjpc not like", value, "gyyjpc");
            return (Criteria) this;
        }

        public Criteria andGyyjpcIn(List<String> values) {
            addCriterion("gyyjpc in", values, "gyyjpc");
            return (Criteria) this;
        }

        public Criteria andGyyjpcNotIn(List<String> values) {
            addCriterion("gyyjpc not in", values, "gyyjpc");
            return (Criteria) this;
        }

        public Criteria andGyyjpcBetween(String value1, String value2) {
            addCriterion("gyyjpc between", value1, value2, "gyyjpc");
            return (Criteria) this;
        }

        public Criteria andGyyjpcNotBetween(String value1, String value2) {
            addCriterion("gyyjpc not between", value1, value2, "gyyjpc");
            return (Criteria) this;
        }

        public Criteria andGytpIsNull() {
            addCriterion("gytp is null");
            return (Criteria) this;
        }

        public Criteria andGytpIsNotNull() {
            addCriterion("gytp is not null");
            return (Criteria) this;
        }

        public Criteria andGytpEqualTo(String value) {
            addCriterion("gytp =", value, "gytp");
            return (Criteria) this;
        }

        public Criteria andGytpNotEqualTo(String value) {
            addCriterion("gytp <>", value, "gytp");
            return (Criteria) this;
        }

        public Criteria andGytpGreaterThan(String value) {
            addCriterion("gytp >", value, "gytp");
            return (Criteria) this;
        }

        public Criteria andGytpGreaterThanOrEqualTo(String value) {
            addCriterion("gytp >=", value, "gytp");
            return (Criteria) this;
        }

        public Criteria andGytpLessThan(String value) {
            addCriterion("gytp <", value, "gytp");
            return (Criteria) this;
        }

        public Criteria andGytpLessThanOrEqualTo(String value) {
            addCriterion("gytp <=", value, "gytp");
            return (Criteria) this;
        }

        public Criteria andGytpLike(String value) {
            addCriterion("gytp like", value, "gytp");
            return (Criteria) this;
        }

        public Criteria andGytpNotLike(String value) {
            addCriterion("gytp not like", value, "gytp");
            return (Criteria) this;
        }

        public Criteria andGytpIn(List<String> values) {
            addCriterion("gytp in", values, "gytp");
            return (Criteria) this;
        }

        public Criteria andGytpNotIn(List<String> values) {
            addCriterion("gytp not in", values, "gytp");
            return (Criteria) this;
        }

        public Criteria andGytpBetween(String value1, String value2) {
            addCriterion("gytp between", value1, value2, "gytp");
            return (Criteria) this;
        }

        public Criteria andGytpNotBetween(String value1, String value2) {
            addCriterion("gytp not between", value1, value2, "gytp");
            return (Criteria) this;
        }

        public Criteria andLxkfIsNull() {
            addCriterion("lxkf is null");
            return (Criteria) this;
        }

        public Criteria andLxkfIsNotNull() {
            addCriterion("lxkf is not null");
            return (Criteria) this;
        }

        public Criteria andLxkfEqualTo(String value) {
            addCriterion("lxkf =", value, "lxkf");
            return (Criteria) this;
        }

        public Criteria andLxkfNotEqualTo(String value) {
            addCriterion("lxkf <>", value, "lxkf");
            return (Criteria) this;
        }

        public Criteria andLxkfGreaterThan(String value) {
            addCriterion("lxkf >", value, "lxkf");
            return (Criteria) this;
        }

        public Criteria andLxkfGreaterThanOrEqualTo(String value) {
            addCriterion("lxkf >=", value, "lxkf");
            return (Criteria) this;
        }

        public Criteria andLxkfLessThan(String value) {
            addCriterion("lxkf <", value, "lxkf");
            return (Criteria) this;
        }

        public Criteria andLxkfLessThanOrEqualTo(String value) {
            addCriterion("lxkf <=", value, "lxkf");
            return (Criteria) this;
        }

        public Criteria andLxkfLike(String value) {
            addCriterion("lxkf like", value, "lxkf");
            return (Criteria) this;
        }

        public Criteria andLxkfNotLike(String value) {
            addCriterion("lxkf not like", value, "lxkf");
            return (Criteria) this;
        }

        public Criteria andLxkfIn(List<String> values) {
            addCriterion("lxkf in", values, "lxkf");
            return (Criteria) this;
        }

        public Criteria andLxkfNotIn(List<String> values) {
            addCriterion("lxkf not in", values, "lxkf");
            return (Criteria) this;
        }

        public Criteria andLxkfBetween(String value1, String value2) {
            addCriterion("lxkf between", value1, value2, "lxkf");
            return (Criteria) this;
        }

        public Criteria andLxkfNotBetween(String value1, String value2) {
            addCriterion("lxkf not between", value1, value2, "lxkf");
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