package com.jcl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExceptOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExceptOrderExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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

        public Criteria andMarketIsNull() {
            addCriterion("market is null");
            return (Criteria) this;
        }

        public Criteria andMarketIsNotNull() {
            addCriterion("market is not null");
            return (Criteria) this;
        }

        public Criteria andMarketEqualTo(Byte value) {
            addCriterion("market =", value, "market");
            return (Criteria) this;
        }

        public Criteria andMarketNotEqualTo(Byte value) {
            addCriterion("market <>", value, "market");
            return (Criteria) this;
        }

        public Criteria andMarketGreaterThan(Byte value) {
            addCriterion("market >", value, "market");
            return (Criteria) this;
        }

        public Criteria andMarketGreaterThanOrEqualTo(Byte value) {
            addCriterion("market >=", value, "market");
            return (Criteria) this;
        }

        public Criteria andMarketLessThan(Byte value) {
            addCriterion("market <", value, "market");
            return (Criteria) this;
        }

        public Criteria andMarketLessThanOrEqualTo(Byte value) {
            addCriterion("market <=", value, "market");
            return (Criteria) this;
        }

        public Criteria andMarketIn(List<Byte> values) {
            addCriterion("market in", values, "market");
            return (Criteria) this;
        }

        public Criteria andMarketNotIn(List<Byte> values) {
            addCriterion("market not in", values, "market");
            return (Criteria) this;
        }

        public Criteria andMarketBetween(Byte value1, Byte value2) {
            addCriterion("market between", value1, value2, "market");
            return (Criteria) this;
        }

        public Criteria andMarketNotBetween(Byte value1, Byte value2) {
            addCriterion("market not between", value1, value2, "market");
            return (Criteria) this;
        }

        public Criteria andHycodeIsNull() {
            addCriterion("hycode is null");
            return (Criteria) this;
        }

        public Criteria andHycodeIsNotNull() {
            addCriterion("hycode is not null");
            return (Criteria) this;
        }

        public Criteria andHycodeEqualTo(String value) {
            addCriterion("hycode =", value, "hycode");
            return (Criteria) this;
        }

        public Criteria andHycodeNotEqualTo(String value) {
            addCriterion("hycode <>", value, "hycode");
            return (Criteria) this;
        }

        public Criteria andHycodeGreaterThan(String value) {
            addCriterion("hycode >", value, "hycode");
            return (Criteria) this;
        }

        public Criteria andHycodeGreaterThanOrEqualTo(String value) {
            addCriterion("hycode >=", value, "hycode");
            return (Criteria) this;
        }

        public Criteria andHycodeLessThan(String value) {
            addCriterion("hycode <", value, "hycode");
            return (Criteria) this;
        }

        public Criteria andHycodeLessThanOrEqualTo(String value) {
            addCriterion("hycode <=", value, "hycode");
            return (Criteria) this;
        }

        public Criteria andHycodeLike(String value) {
            addCriterion("hycode like", value, "hycode");
            return (Criteria) this;
        }

        public Criteria andHycodeNotLike(String value) {
            addCriterion("hycode not like", value, "hycode");
            return (Criteria) this;
        }

        public Criteria andHycodeIn(List<String> values) {
            addCriterion("hycode in", values, "hycode");
            return (Criteria) this;
        }

        public Criteria andHycodeNotIn(List<String> values) {
            addCriterion("hycode not in", values, "hycode");
            return (Criteria) this;
        }

        public Criteria andHycodeBetween(String value1, String value2) {
            addCriterion("hycode between", value1, value2, "hycode");
            return (Criteria) this;
        }

        public Criteria andHycodeNotBetween(String value1, String value2) {
            addCriterion("hycode not between", value1, value2, "hycode");
            return (Criteria) this;
        }

        public Criteria andHypzIsNull() {
            addCriterion("hypz is null");
            return (Criteria) this;
        }

        public Criteria andHypzIsNotNull() {
            addCriterion("hypz is not null");
            return (Criteria) this;
        }

        public Criteria andHypzEqualTo(String value) {
            addCriterion("hypz =", value, "hypz");
            return (Criteria) this;
        }

        public Criteria andHypzNotEqualTo(String value) {
            addCriterion("hypz <>", value, "hypz");
            return (Criteria) this;
        }

        public Criteria andHypzGreaterThan(String value) {
            addCriterion("hypz >", value, "hypz");
            return (Criteria) this;
        }

        public Criteria andHypzGreaterThanOrEqualTo(String value) {
            addCriterion("hypz >=", value, "hypz");
            return (Criteria) this;
        }

        public Criteria andHypzLessThan(String value) {
            addCriterion("hypz <", value, "hypz");
            return (Criteria) this;
        }

        public Criteria andHypzLessThanOrEqualTo(String value) {
            addCriterion("hypz <=", value, "hypz");
            return (Criteria) this;
        }

        public Criteria andHypzLike(String value) {
            addCriterion("hypz like", value, "hypz");
            return (Criteria) this;
        }

        public Criteria andHypzNotLike(String value) {
            addCriterion("hypz not like", value, "hypz");
            return (Criteria) this;
        }

        public Criteria andHypzIn(List<String> values) {
            addCriterion("hypz in", values, "hypz");
            return (Criteria) this;
        }

        public Criteria andHypzNotIn(List<String> values) {
            addCriterion("hypz not in", values, "hypz");
            return (Criteria) this;
        }

        public Criteria andHypzBetween(String value1, String value2) {
            addCriterion("hypz between", value1, value2, "hypz");
            return (Criteria) this;
        }

        public Criteria andHypzNotBetween(String value1, String value2) {
            addCriterion("hypz not between", value1, value2, "hypz");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNull() {
            addCriterion("direction is null");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNotNull() {
            addCriterion("direction is not null");
            return (Criteria) this;
        }

        public Criteria andDirectionEqualTo(Byte value) {
            addCriterion("direction =", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotEqualTo(Byte value) {
            addCriterion("direction <>", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThan(Byte value) {
            addCriterion("direction >", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThanOrEqualTo(Byte value) {
            addCriterion("direction >=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThan(Byte value) {
            addCriterion("direction <", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThanOrEqualTo(Byte value) {
            addCriterion("direction <=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionIn(List<Byte> values) {
            addCriterion("direction in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotIn(List<Byte> values) {
            addCriterion("direction not in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionBetween(Byte value1, Byte value2) {
            addCriterion("direction between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotBetween(Byte value1, Byte value2) {
            addCriterion("direction not between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andVolIsNull() {
            addCriterion("vol is null");
            return (Criteria) this;
        }

        public Criteria andVolIsNotNull() {
            addCriterion("vol is not null");
            return (Criteria) this;
        }

        public Criteria andVolEqualTo(Integer value) {
            addCriterion("vol =", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolNotEqualTo(Integer value) {
            addCriterion("vol <>", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolGreaterThan(Integer value) {
            addCriterion("vol >", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolGreaterThanOrEqualTo(Integer value) {
            addCriterion("vol >=", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolLessThan(Integer value) {
            addCriterion("vol <", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolLessThanOrEqualTo(Integer value) {
            addCriterion("vol <=", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolIn(List<Integer> values) {
            addCriterion("vol in", values, "vol");
            return (Criteria) this;
        }

        public Criteria andVolNotIn(List<Integer> values) {
            addCriterion("vol not in", values, "vol");
            return (Criteria) this;
        }

        public Criteria andVolBetween(Integer value1, Integer value2) {
            addCriterion("vol between", value1, value2, "vol");
            return (Criteria) this;
        }

        public Criteria andVolNotBetween(Integer value1, Integer value2) {
            addCriterion("vol not between", value1, value2, "vol");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNull() {
            addCriterion("order_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("order_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(Date value) {
            addCriterion("order_time =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(Date value) {
            addCriterion("order_time <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(Date value) {
            addCriterion("order_time >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_time >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(Date value) {
            addCriterion("order_time <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_time <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<Date> values) {
            addCriterion("order_time in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<Date> values) {
            addCriterion("order_time not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(Date value1, Date value2) {
            addCriterion("order_time between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_time not between", value1, value2, "orderTime");
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