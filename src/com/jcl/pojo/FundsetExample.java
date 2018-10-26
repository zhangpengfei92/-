package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FundsetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FundsetExample() {
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
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

        public Criteria andPcswitchIsNull() {
            addCriterion("pcswitch is null");
            return (Criteria) this;
        }

        public Criteria andPcswitchIsNotNull() {
            addCriterion("pcswitch is not null");
            return (Criteria) this;
        }

        public Criteria andPcswitchEqualTo(Integer value) {
            addCriterion("pcswitch =", value, "pcswitch");
            return (Criteria) this;
        }

        public Criteria andPcswitchNotEqualTo(Integer value) {
            addCriterion("pcswitch <>", value, "pcswitch");
            return (Criteria) this;
        }

        public Criteria andPcswitchGreaterThan(Integer value) {
            addCriterion("pcswitch >", value, "pcswitch");
            return (Criteria) this;
        }

        public Criteria andPcswitchGreaterThanOrEqualTo(Integer value) {
            addCriterion("pcswitch >=", value, "pcswitch");
            return (Criteria) this;
        }

        public Criteria andPcswitchLessThan(Integer value) {
            addCriterion("pcswitch <", value, "pcswitch");
            return (Criteria) this;
        }

        public Criteria andPcswitchLessThanOrEqualTo(Integer value) {
            addCriterion("pcswitch <=", value, "pcswitch");
            return (Criteria) this;
        }

        public Criteria andPcswitchIn(List<Integer> values) {
            addCriterion("pcswitch in", values, "pcswitch");
            return (Criteria) this;
        }

        public Criteria andPcswitchNotIn(List<Integer> values) {
            addCriterion("pcswitch not in", values, "pcswitch");
            return (Criteria) this;
        }

        public Criteria andPcswitchBetween(Integer value1, Integer value2) {
            addCriterion("pcswitch between", value1, value2, "pcswitch");
            return (Criteria) this;
        }

        public Criteria andPcswitchNotBetween(Integer value1, Integer value2) {
            addCriterion("pcswitch not between", value1, value2, "pcswitch");
            return (Criteria) this;
        }

        public Criteria andAppswitchIsNull() {
            addCriterion("appswitch is null");
            return (Criteria) this;
        }

        public Criteria andAppswitchIsNotNull() {
            addCriterion("appswitch is not null");
            return (Criteria) this;
        }

        public Criteria andAppswitchEqualTo(Integer value) {
            addCriterion("appswitch =", value, "appswitch");
            return (Criteria) this;
        }

        public Criteria andAppswitchNotEqualTo(Integer value) {
            addCriterion("appswitch <>", value, "appswitch");
            return (Criteria) this;
        }

        public Criteria andAppswitchGreaterThan(Integer value) {
            addCriterion("appswitch >", value, "appswitch");
            return (Criteria) this;
        }

        public Criteria andAppswitchGreaterThanOrEqualTo(Integer value) {
            addCriterion("appswitch >=", value, "appswitch");
            return (Criteria) this;
        }

        public Criteria andAppswitchLessThan(Integer value) {
            addCriterion("appswitch <", value, "appswitch");
            return (Criteria) this;
        }

        public Criteria andAppswitchLessThanOrEqualTo(Integer value) {
            addCriterion("appswitch <=", value, "appswitch");
            return (Criteria) this;
        }

        public Criteria andAppswitchIn(List<Integer> values) {
            addCriterion("appswitch in", values, "appswitch");
            return (Criteria) this;
        }

        public Criteria andAppswitchNotIn(List<Integer> values) {
            addCriterion("appswitch not in", values, "appswitch");
            return (Criteria) this;
        }

        public Criteria andAppswitchBetween(Integer value1, Integer value2) {
            addCriterion("appswitch between", value1, value2, "appswitch");
            return (Criteria) this;
        }

        public Criteria andAppswitchNotBetween(Integer value1, Integer value2) {
            addCriterion("appswitch not between", value1, value2, "appswitch");
            return (Criteria) this;
        }

        public Criteria andCzcostIsNull() {
            addCriterion("czcost is null");
            return (Criteria) this;
        }

        public Criteria andCzcostIsNotNull() {
            addCriterion("czcost is not null");
            return (Criteria) this;
        }

        public Criteria andCzcostEqualTo(Long value) {
            addCriterion("czcost =", value, "czcost");
            return (Criteria) this;
        }

        public Criteria andCzcostNotEqualTo(Long value) {
            addCriterion("czcost <>", value, "czcost");
            return (Criteria) this;
        }

        public Criteria andCzcostGreaterThan(Long value) {
            addCriterion("czcost >", value, "czcost");
            return (Criteria) this;
        }

        public Criteria andCzcostGreaterThanOrEqualTo(Long value) {
            addCriterion("czcost >=", value, "czcost");
            return (Criteria) this;
        }

        public Criteria andCzcostLessThan(Long value) {
            addCriterion("czcost <", value, "czcost");
            return (Criteria) this;
        }

        public Criteria andCzcostLessThanOrEqualTo(Long value) {
            addCriterion("czcost <=", value, "czcost");
            return (Criteria) this;
        }

        public Criteria andCzcostIn(List<Long> values) {
            addCriterion("czcost in", values, "czcost");
            return (Criteria) this;
        }

        public Criteria andCzcostNotIn(List<Long> values) {
            addCriterion("czcost not in", values, "czcost");
            return (Criteria) this;
        }

        public Criteria andCzcostBetween(Long value1, Long value2) {
            addCriterion("czcost between", value1, value2, "czcost");
            return (Criteria) this;
        }

        public Criteria andCzcostNotBetween(Long value1, Long value2) {
            addCriterion("czcost not between", value1, value2, "czcost");
            return (Criteria) this;
        }

        public Criteria andTxcostIsNull() {
            addCriterion("txcost is null");
            return (Criteria) this;
        }

        public Criteria andTxcostIsNotNull() {
            addCriterion("txcost is not null");
            return (Criteria) this;
        }

        public Criteria andTxcostEqualTo(Long value) {
            addCriterion("txcost =", value, "txcost");
            return (Criteria) this;
        }

        public Criteria andTxcostNotEqualTo(Long value) {
            addCriterion("txcost <>", value, "txcost");
            return (Criteria) this;
        }

        public Criteria andTxcostGreaterThan(Long value) {
            addCriterion("txcost >", value, "txcost");
            return (Criteria) this;
        }

        public Criteria andTxcostGreaterThanOrEqualTo(Long value) {
            addCriterion("txcost >=", value, "txcost");
            return (Criteria) this;
        }

        public Criteria andTxcostLessThan(Long value) {
            addCriterion("txcost <", value, "txcost");
            return (Criteria) this;
        }

        public Criteria andTxcostLessThanOrEqualTo(Long value) {
            addCriterion("txcost <=", value, "txcost");
            return (Criteria) this;
        }

        public Criteria andTxcostIn(List<Long> values) {
            addCriterion("txcost in", values, "txcost");
            return (Criteria) this;
        }

        public Criteria andTxcostNotIn(List<Long> values) {
            addCriterion("txcost not in", values, "txcost");
            return (Criteria) this;
        }

        public Criteria andTxcostBetween(Long value1, Long value2) {
            addCriterion("txcost between", value1, value2, "txcost");
            return (Criteria) this;
        }

        public Criteria andTxcostNotBetween(Long value1, Long value2) {
            addCriterion("txcost not between", value1, value2, "txcost");
            return (Criteria) this;
        }

        public Criteria andMinmoneyIsNull() {
            addCriterion("minmoney is null");
            return (Criteria) this;
        }

        public Criteria andMinmoneyIsNotNull() {
            addCriterion("minmoney is not null");
            return (Criteria) this;
        }

        public Criteria andMinmoneyEqualTo(BigDecimal value) {
            addCriterion("minmoney =", value, "minmoney");
            return (Criteria) this;
        }

        public Criteria andMinmoneyNotEqualTo(BigDecimal value) {
            addCriterion("minmoney <>", value, "minmoney");
            return (Criteria) this;
        }

        public Criteria andMinmoneyGreaterThan(BigDecimal value) {
            addCriterion("minmoney >", value, "minmoney");
            return (Criteria) this;
        }

        public Criteria andMinmoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("minmoney >=", value, "minmoney");
            return (Criteria) this;
        }

        public Criteria andMinmoneyLessThan(BigDecimal value) {
            addCriterion("minmoney <", value, "minmoney");
            return (Criteria) this;
        }

        public Criteria andMinmoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("minmoney <=", value, "minmoney");
            return (Criteria) this;
        }

        public Criteria andMinmoneyIn(List<BigDecimal> values) {
            addCriterion("minmoney in", values, "minmoney");
            return (Criteria) this;
        }

        public Criteria andMinmoneyNotIn(List<BigDecimal> values) {
            addCriterion("minmoney not in", values, "minmoney");
            return (Criteria) this;
        }

        public Criteria andMinmoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("minmoney between", value1, value2, "minmoney");
            return (Criteria) this;
        }

        public Criteria andMinmoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("minmoney not between", value1, value2, "minmoney");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyIsNull() {
            addCriterion("maxmoney is null");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyIsNotNull() {
            addCriterion("maxmoney is not null");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyEqualTo(BigDecimal value) {
            addCriterion("maxmoney =", value, "maxmoney");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyNotEqualTo(BigDecimal value) {
            addCriterion("maxmoney <>", value, "maxmoney");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyGreaterThan(BigDecimal value) {
            addCriterion("maxmoney >", value, "maxmoney");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("maxmoney >=", value, "maxmoney");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyLessThan(BigDecimal value) {
            addCriterion("maxmoney <", value, "maxmoney");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("maxmoney <=", value, "maxmoney");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyIn(List<BigDecimal> values) {
            addCriterion("maxmoney in", values, "maxmoney");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyNotIn(List<BigDecimal> values) {
            addCriterion("maxmoney not in", values, "maxmoney");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("maxmoney between", value1, value2, "maxmoney");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("maxmoney not between", value1, value2, "maxmoney");
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
            addCriterionForJDBCTime("starttime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("starttime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterionForJDBCTime("starttime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("starttime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterionForJDBCTime("starttime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("starttime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterionForJDBCTime("starttime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("starttime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("starttime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("starttime not between", value1, value2, "starttime");
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
            addCriterionForJDBCTime("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterionForJDBCTime("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterionForJDBCTime("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterionForJDBCTime("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("endtime not between", value1, value2, "endtime");
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