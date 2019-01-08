package com.jcl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RiskLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RiskLogExample() {
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

        public Criteria andWarnnoIsNull() {
            addCriterion("warnno is null");
            return (Criteria) this;
        }

        public Criteria andWarnnoIsNotNull() {
            addCriterion("warnno is not null");
            return (Criteria) this;
        }

        public Criteria andWarnnoEqualTo(String value) {
            addCriterion("warnno =", value, "warnno");
            return (Criteria) this;
        }

        public Criteria andWarnnoNotEqualTo(String value) {
            addCriterion("warnno <>", value, "warnno");
            return (Criteria) this;
        }

        public Criteria andWarnnoGreaterThan(String value) {
            addCriterion("warnno >", value, "warnno");
            return (Criteria) this;
        }

        public Criteria andWarnnoGreaterThanOrEqualTo(String value) {
            addCriterion("warnno >=", value, "warnno");
            return (Criteria) this;
        }

        public Criteria andWarnnoLessThan(String value) {
            addCriterion("warnno <", value, "warnno");
            return (Criteria) this;
        }

        public Criteria andWarnnoLessThanOrEqualTo(String value) {
            addCriterion("warnno <=", value, "warnno");
            return (Criteria) this;
        }

        public Criteria andWarnnoLike(String value) {
            addCriterion("warnno like", value, "warnno");
            return (Criteria) this;
        }

        public Criteria andWarnnoNotLike(String value) {
            addCriterion("warnno not like", value, "warnno");
            return (Criteria) this;
        }

        public Criteria andWarnnoIn(List<String> values) {
            addCriterion("warnno in", values, "warnno");
            return (Criteria) this;
        }

        public Criteria andWarnnoNotIn(List<String> values) {
            addCriterion("warnno not in", values, "warnno");
            return (Criteria) this;
        }

        public Criteria andWarnnoBetween(String value1, String value2) {
            addCriterion("warnno between", value1, value2, "warnno");
            return (Criteria) this;
        }

        public Criteria andWarnnoNotBetween(String value1, String value2) {
            addCriterion("warnno not between", value1, value2, "warnno");
            return (Criteria) this;
        }

        public Criteria andUsernoIsNull() {
            addCriterion("userno is null");
            return (Criteria) this;
        }

        public Criteria andUsernoIsNotNull() {
            addCriterion("userno is not null");
            return (Criteria) this;
        }

        public Criteria andUsernoEqualTo(String value) {
            addCriterion("userno =", value, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoNotEqualTo(String value) {
            addCriterion("userno <>", value, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoGreaterThan(String value) {
            addCriterion("userno >", value, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoGreaterThanOrEqualTo(String value) {
            addCriterion("userno >=", value, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoLessThan(String value) {
            addCriterion("userno <", value, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoLessThanOrEqualTo(String value) {
            addCriterion("userno <=", value, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoLike(String value) {
            addCriterion("userno like", value, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoNotLike(String value) {
            addCriterion("userno not like", value, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoIn(List<String> values) {
            addCriterion("userno in", values, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoNotIn(List<String> values) {
            addCriterion("userno not in", values, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoBetween(String value1, String value2) {
            addCriterion("userno between", value1, value2, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoNotBetween(String value1, String value2) {
            addCriterion("userno not between", value1, value2, "userno");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(String value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(String value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(String value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(String value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(String value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLike(String value) {
            addCriterion("user_type like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotLike(String value) {
            addCriterion("user_type not like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<String> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<String> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(String value1, String value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(String value1, String value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andDeclarationAccountIsNull() {
            addCriterion("declaration_account is null");
            return (Criteria) this;
        }

        public Criteria andDeclarationAccountIsNotNull() {
            addCriterion("declaration_account is not null");
            return (Criteria) this;
        }

        public Criteria andDeclarationAccountEqualTo(String value) {
            addCriterion("declaration_account =", value, "declarationAccount");
            return (Criteria) this;
        }

        public Criteria andDeclarationAccountNotEqualTo(String value) {
            addCriterion("declaration_account <>", value, "declarationAccount");
            return (Criteria) this;
        }

        public Criteria andDeclarationAccountGreaterThan(String value) {
            addCriterion("declaration_account >", value, "declarationAccount");
            return (Criteria) this;
        }

        public Criteria andDeclarationAccountGreaterThanOrEqualTo(String value) {
            addCriterion("declaration_account >=", value, "declarationAccount");
            return (Criteria) this;
        }

        public Criteria andDeclarationAccountLessThan(String value) {
            addCriterion("declaration_account <", value, "declarationAccount");
            return (Criteria) this;
        }

        public Criteria andDeclarationAccountLessThanOrEqualTo(String value) {
            addCriterion("declaration_account <=", value, "declarationAccount");
            return (Criteria) this;
        }

        public Criteria andDeclarationAccountLike(String value) {
            addCriterion("declaration_account like", value, "declarationAccount");
            return (Criteria) this;
        }

        public Criteria andDeclarationAccountNotLike(String value) {
            addCriterion("declaration_account not like", value, "declarationAccount");
            return (Criteria) this;
        }

        public Criteria andDeclarationAccountIn(List<String> values) {
            addCriterion("declaration_account in", values, "declarationAccount");
            return (Criteria) this;
        }

        public Criteria andDeclarationAccountNotIn(List<String> values) {
            addCriterion("declaration_account not in", values, "declarationAccount");
            return (Criteria) this;
        }

        public Criteria andDeclarationAccountBetween(String value1, String value2) {
            addCriterion("declaration_account between", value1, value2, "declarationAccount");
            return (Criteria) this;
        }

        public Criteria andDeclarationAccountNotBetween(String value1, String value2) {
            addCriterion("declaration_account not between", value1, value2, "declarationAccount");
            return (Criteria) this;
        }

        public Criteria andWarnTypeIsNull() {
            addCriterion("warn_type is null");
            return (Criteria) this;
        }

        public Criteria andWarnTypeIsNotNull() {
            addCriterion("warn_type is not null");
            return (Criteria) this;
        }

        public Criteria andWarnTypeEqualTo(String value) {
            addCriterion("warn_type =", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeNotEqualTo(String value) {
            addCriterion("warn_type <>", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeGreaterThan(String value) {
            addCriterion("warn_type >", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeGreaterThanOrEqualTo(String value) {
            addCriterion("warn_type >=", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeLessThan(String value) {
            addCriterion("warn_type <", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeLessThanOrEqualTo(String value) {
            addCriterion("warn_type <=", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeLike(String value) {
            addCriterion("warn_type like", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeNotLike(String value) {
            addCriterion("warn_type not like", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeIn(List<String> values) {
            addCriterion("warn_type in", values, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeNotIn(List<String> values) {
            addCriterion("warn_type not in", values, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeBetween(String value1, String value2) {
            addCriterion("warn_type between", value1, value2, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeNotBetween(String value1, String value2) {
            addCriterion("warn_type not between", value1, value2, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnDetailIsNull() {
            addCriterion("warn_detail is null");
            return (Criteria) this;
        }

        public Criteria andWarnDetailIsNotNull() {
            addCriterion("warn_detail is not null");
            return (Criteria) this;
        }

        public Criteria andWarnDetailEqualTo(String value) {
            addCriterion("warn_detail =", value, "warnDetail");
            return (Criteria) this;
        }

        public Criteria andWarnDetailNotEqualTo(String value) {
            addCriterion("warn_detail <>", value, "warnDetail");
            return (Criteria) this;
        }

        public Criteria andWarnDetailGreaterThan(String value) {
            addCriterion("warn_detail >", value, "warnDetail");
            return (Criteria) this;
        }

        public Criteria andWarnDetailGreaterThanOrEqualTo(String value) {
            addCriterion("warn_detail >=", value, "warnDetail");
            return (Criteria) this;
        }

        public Criteria andWarnDetailLessThan(String value) {
            addCriterion("warn_detail <", value, "warnDetail");
            return (Criteria) this;
        }

        public Criteria andWarnDetailLessThanOrEqualTo(String value) {
            addCriterion("warn_detail <=", value, "warnDetail");
            return (Criteria) this;
        }

        public Criteria andWarnDetailLike(String value) {
            addCriterion("warn_detail like", value, "warnDetail");
            return (Criteria) this;
        }

        public Criteria andWarnDetailNotLike(String value) {
            addCriterion("warn_detail not like", value, "warnDetail");
            return (Criteria) this;
        }

        public Criteria andWarnDetailIn(List<String> values) {
            addCriterion("warn_detail in", values, "warnDetail");
            return (Criteria) this;
        }

        public Criteria andWarnDetailNotIn(List<String> values) {
            addCriterion("warn_detail not in", values, "warnDetail");
            return (Criteria) this;
        }

        public Criteria andWarnDetailBetween(String value1, String value2) {
            addCriterion("warn_detail between", value1, value2, "warnDetail");
            return (Criteria) this;
        }

        public Criteria andWarnDetailNotBetween(String value1, String value2) {
            addCriterion("warn_detail not between", value1, value2, "warnDetail");
            return (Criteria) this;
        }

        public Criteria andWarnTimeIsNull() {
            addCriterion("warn_time is null");
            return (Criteria) this;
        }

        public Criteria andWarnTimeIsNotNull() {
            addCriterion("warn_time is not null");
            return (Criteria) this;
        }

        public Criteria andWarnTimeEqualTo(Date value) {
            addCriterion("warn_time =", value, "warnTime");
            return (Criteria) this;
        }

        public Criteria andWarnTimeNotEqualTo(Date value) {
            addCriterion("warn_time <>", value, "warnTime");
            return (Criteria) this;
        }

        public Criteria andWarnTimeGreaterThan(Date value) {
            addCriterion("warn_time >", value, "warnTime");
            return (Criteria) this;
        }

        public Criteria andWarnTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("warn_time >=", value, "warnTime");
            return (Criteria) this;
        }

        public Criteria andWarnTimeLessThan(Date value) {
            addCriterion("warn_time <", value, "warnTime");
            return (Criteria) this;
        }

        public Criteria andWarnTimeLessThanOrEqualTo(Date value) {
            addCriterion("warn_time <=", value, "warnTime");
            return (Criteria) this;
        }

        public Criteria andWarnTimeIn(List<Date> values) {
            addCriterion("warn_time in", values, "warnTime");
            return (Criteria) this;
        }

        public Criteria andWarnTimeNotIn(List<Date> values) {
            addCriterion("warn_time not in", values, "warnTime");
            return (Criteria) this;
        }

        public Criteria andWarnTimeBetween(Date value1, Date value2) {
            addCriterion("warn_time between", value1, value2, "warnTime");
            return (Criteria) this;
        }

        public Criteria andWarnTimeNotBetween(Date value1, Date value2) {
            addCriterion("warn_time not between", value1, value2, "warnTime");
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

        public Criteria andWarnDescIsNull() {
            addCriterion("warn_desc is null");
            return (Criteria) this;
        }

        public Criteria andWarnDescIsNotNull() {
            addCriterion("warn_desc is not null");
            return (Criteria) this;
        }

        public Criteria andWarnDescEqualTo(String value) {
            addCriterion("warn_desc =", value, "warnDesc");
            return (Criteria) this;
        }

        public Criteria andWarnDescNotEqualTo(String value) {
            addCriterion("warn_desc <>", value, "warnDesc");
            return (Criteria) this;
        }

        public Criteria andWarnDescGreaterThan(String value) {
            addCriterion("warn_desc >", value, "warnDesc");
            return (Criteria) this;
        }

        public Criteria andWarnDescGreaterThanOrEqualTo(String value) {
            addCriterion("warn_desc >=", value, "warnDesc");
            return (Criteria) this;
        }

        public Criteria andWarnDescLessThan(String value) {
            addCriterion("warn_desc <", value, "warnDesc");
            return (Criteria) this;
        }

        public Criteria andWarnDescLessThanOrEqualTo(String value) {
            addCriterion("warn_desc <=", value, "warnDesc");
            return (Criteria) this;
        }

        public Criteria andWarnDescLike(String value) {
            addCriterion("warn_desc like", value, "warnDesc");
            return (Criteria) this;
        }

        public Criteria andWarnDescNotLike(String value) {
            addCriterion("warn_desc not like", value, "warnDesc");
            return (Criteria) this;
        }

        public Criteria andWarnDescIn(List<String> values) {
            addCriterion("warn_desc in", values, "warnDesc");
            return (Criteria) this;
        }

        public Criteria andWarnDescNotIn(List<String> values) {
            addCriterion("warn_desc not in", values, "warnDesc");
            return (Criteria) this;
        }

        public Criteria andWarnDescBetween(String value1, String value2) {
            addCriterion("warn_desc between", value1, value2, "warnDesc");
            return (Criteria) this;
        }

        public Criteria andWarnDescNotBetween(String value1, String value2) {
            addCriterion("warn_desc not between", value1, value2, "warnDesc");
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