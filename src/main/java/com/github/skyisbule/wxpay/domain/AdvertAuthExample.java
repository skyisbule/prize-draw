package com.github.skyisbule.wxpay.domain;

import java.util.ArrayList;
import java.util.List;

public class AdvertAuthExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public AdvertAuthExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
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

        public Criteria andAuthidIsNull() {
            addCriterion("authId is null");
            return (Criteria) this;
        }

        public Criteria andAuthidIsNotNull() {
            addCriterion("authId is not null");
            return (Criteria) this;
        }

        public Criteria andAuthidEqualTo(Integer value) {
            addCriterion("authId =", value, "authid");
            return (Criteria) this;
        }

        public Criteria andAuthidNotEqualTo(Integer value) {
            addCriterion("authId <>", value, "authid");
            return (Criteria) this;
        }

        public Criteria andAuthidGreaterThan(Integer value) {
            addCriterion("authId >", value, "authid");
            return (Criteria) this;
        }

        public Criteria andAuthidGreaterThanOrEqualTo(Integer value) {
            addCriterion("authId >=", value, "authid");
            return (Criteria) this;
        }

        public Criteria andAuthidLessThan(Integer value) {
            addCriterion("authId <", value, "authid");
            return (Criteria) this;
        }

        public Criteria andAuthidLessThanOrEqualTo(Integer value) {
            addCriterion("authId <=", value, "authid");
            return (Criteria) this;
        }

        public Criteria andAuthidIn(List<Integer> values) {
            addCriterion("authId in", values, "authid");
            return (Criteria) this;
        }

        public Criteria andAuthidNotIn(List<Integer> values) {
            addCriterion("authId not in", values, "authid");
            return (Criteria) this;
        }

        public Criteria andAuthidBetween(Integer value1, Integer value2) {
            addCriterion("authId between", value1, value2, "authid");
            return (Criteria) this;
        }

        public Criteria andAuthidNotBetween(Integer value1, Integer value2) {
            addCriterion("authId not between", value1, value2, "authid");
            return (Criteria) this;
        }

        public Criteria andPrizeIdIsNull() {
            addCriterion("prize_id is null");
            return (Criteria) this;
        }

        public Criteria andPrizeIdIsNotNull() {
            addCriterion("prize_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeIdEqualTo(Integer value) {
            addCriterion("prize_id =", value, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdNotEqualTo(Integer value) {
            addCriterion("prize_id <>", value, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdGreaterThan(Integer value) {
            addCriterion("prize_id >", value, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("prize_id >=", value, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdLessThan(Integer value) {
            addCriterion("prize_id <", value, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdLessThanOrEqualTo(Integer value) {
            addCriterion("prize_id <=", value, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdIn(List<Integer> values) {
            addCriterion("prize_id in", values, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdNotIn(List<Integer> values) {
            addCriterion("prize_id not in", values, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdBetween(Integer value1, Integer value2) {
            addCriterion("prize_id between", value1, value2, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("prize_id not between", value1, value2, "prizeId");
            return (Criteria) this;
        }

        public Criteria andReceiveKeyIsNull() {
            addCriterion("receive_key is null");
            return (Criteria) this;
        }

        public Criteria andReceiveKeyIsNotNull() {
            addCriterion("receive_key is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveKeyEqualTo(String value) {
            addCriterion("receive_key =", value, "receiveKey");
            return (Criteria) this;
        }

        public Criteria andReceiveKeyNotEqualTo(String value) {
            addCriterion("receive_key <>", value, "receiveKey");
            return (Criteria) this;
        }

        public Criteria andReceiveKeyGreaterThan(String value) {
            addCriterion("receive_key >", value, "receiveKey");
            return (Criteria) this;
        }

        public Criteria andReceiveKeyGreaterThanOrEqualTo(String value) {
            addCriterion("receive_key >=", value, "receiveKey");
            return (Criteria) this;
        }

        public Criteria andReceiveKeyLessThan(String value) {
            addCriterion("receive_key <", value, "receiveKey");
            return (Criteria) this;
        }

        public Criteria andReceiveKeyLessThanOrEqualTo(String value) {
            addCriterion("receive_key <=", value, "receiveKey");
            return (Criteria) this;
        }

        public Criteria andReceiveKeyLike(String value) {
            addCriterion("receive_key like", value, "receiveKey");
            return (Criteria) this;
        }

        public Criteria andReceiveKeyNotLike(String value) {
            addCriterion("receive_key not like", value, "receiveKey");
            return (Criteria) this;
        }

        public Criteria andReceiveKeyIn(List<String> values) {
            addCriterion("receive_key in", values, "receiveKey");
            return (Criteria) this;
        }

        public Criteria andReceiveKeyNotIn(List<String> values) {
            addCriterion("receive_key not in", values, "receiveKey");
            return (Criteria) this;
        }

        public Criteria andReceiveKeyBetween(String value1, String value2) {
            addCriterion("receive_key between", value1, value2, "receiveKey");
            return (Criteria) this;
        }

        public Criteria andReceiveKeyNotBetween(String value1, String value2) {
            addCriterion("receive_key not between", value1, value2, "receiveKey");
            return (Criteria) this;
        }

        public Criteria andIsCloseIsNull() {
            addCriterion("is_close is null");
            return (Criteria) this;
        }

        public Criteria andIsCloseIsNotNull() {
            addCriterion("is_close is not null");
            return (Criteria) this;
        }

        public Criteria andIsCloseEqualTo(Integer value) {
            addCriterion("is_close =", value, "isClose");
            return (Criteria) this;
        }

        public Criteria andIsCloseNotEqualTo(Integer value) {
            addCriterion("is_close <>", value, "isClose");
            return (Criteria) this;
        }

        public Criteria andIsCloseGreaterThan(Integer value) {
            addCriterion("is_close >", value, "isClose");
            return (Criteria) this;
        }

        public Criteria andIsCloseGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_close >=", value, "isClose");
            return (Criteria) this;
        }

        public Criteria andIsCloseLessThan(Integer value) {
            addCriterion("is_close <", value, "isClose");
            return (Criteria) this;
        }

        public Criteria andIsCloseLessThanOrEqualTo(Integer value) {
            addCriterion("is_close <=", value, "isClose");
            return (Criteria) this;
        }

        public Criteria andIsCloseIn(List<Integer> values) {
            addCriterion("is_close in", values, "isClose");
            return (Criteria) this;
        }

        public Criteria andIsCloseNotIn(List<Integer> values) {
            addCriterion("is_close not in", values, "isClose");
            return (Criteria) this;
        }

        public Criteria andIsCloseBetween(Integer value1, Integer value2) {
            addCriterion("is_close between", value1, value2, "isClose");
            return (Criteria) this;
        }

        public Criteria andIsCloseNotBetween(Integer value1, Integer value2) {
            addCriterion("is_close not between", value1, value2, "isClose");
            return (Criteria) this;
        }
    }

    /**
     */
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