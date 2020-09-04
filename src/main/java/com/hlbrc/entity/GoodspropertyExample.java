package com.hlbrc.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodspropertyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodspropertyExample() {
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

        public Criteria andGoodsPropertyIdIsNull() {
            addCriterion("goods_property_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPropertyIdIsNotNull() {
            addCriterion("goods_property_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPropertyIdEqualTo(Integer value) {
            addCriterion("goods_property_id =", value, "goodsPropertyId");
            return (Criteria) this;
        }

        public Criteria andGoodsPropertyIdNotEqualTo(Integer value) {
            addCriterion("goods_property_id <>", value, "goodsPropertyId");
            return (Criteria) this;
        }

        public Criteria andGoodsPropertyIdGreaterThan(Integer value) {
            addCriterion("goods_property_id >", value, "goodsPropertyId");
            return (Criteria) this;
        }

        public Criteria andGoodsPropertyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_property_id >=", value, "goodsPropertyId");
            return (Criteria) this;
        }

        public Criteria andGoodsPropertyIdLessThan(Integer value) {
            addCriterion("goods_property_id <", value, "goodsPropertyId");
            return (Criteria) this;
        }

        public Criteria andGoodsPropertyIdLessThanOrEqualTo(Integer value) {
            addCriterion("goods_property_id <=", value, "goodsPropertyId");
            return (Criteria) this;
        }

        public Criteria andGoodsPropertyIdIn(List<Integer> values) {
            addCriterion("goods_property_id in", values, "goodsPropertyId");
            return (Criteria) this;
        }

        public Criteria andGoodsPropertyIdNotIn(List<Integer> values) {
            addCriterion("goods_property_id not in", values, "goodsPropertyId");
            return (Criteria) this;
        }

        public Criteria andGoodsPropertyIdBetween(Integer value1, Integer value2) {
            addCriterion("goods_property_id between", value1, value2, "goodsPropertyId");
            return (Criteria) this;
        }

        public Criteria andGoodsPropertyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_property_id not between", value1, value2, "goodsPropertyId");
            return (Criteria) this;
        }

        public Criteria andProductidIsNull() {
            addCriterion("productId is null");
            return (Criteria) this;
        }

        public Criteria andProductidIsNotNull() {
            addCriterion("productId is not null");
            return (Criteria) this;
        }

        public Criteria andProductidEqualTo(Integer value) {
            addCriterion("productId =", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotEqualTo(Integer value) {
            addCriterion("productId <>", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidGreaterThan(Integer value) {
            addCriterion("productId >", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidGreaterThanOrEqualTo(Integer value) {
            addCriterion("productId >=", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLessThan(Integer value) {
            addCriterion("productId <", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLessThanOrEqualTo(Integer value) {
            addCriterion("productId <=", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidIn(List<Integer> values) {
            addCriterion("productId in", values, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotIn(List<Integer> values) {
            addCriterion("productId not in", values, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidBetween(Integer value1, Integer value2) {
            addCriterion("productId between", value1, value2, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotBetween(Integer value1, Integer value2) {
            addCriterion("productId not between", value1, value2, "productid");
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreManagerIdIsNull() {
            addCriterion("cre_manager_id is null");
            return (Criteria) this;
        }

        public Criteria andCreManagerIdIsNotNull() {
            addCriterion("cre_manager_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreManagerIdEqualTo(Integer value) {
            addCriterion("cre_manager_id =", value, "creManagerId");
            return (Criteria) this;
        }

        public Criteria andCreManagerIdNotEqualTo(Integer value) {
            addCriterion("cre_manager_id <>", value, "creManagerId");
            return (Criteria) this;
        }

        public Criteria andCreManagerIdGreaterThan(Integer value) {
            addCriterion("cre_manager_id >", value, "creManagerId");
            return (Criteria) this;
        }

        public Criteria andCreManagerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cre_manager_id >=", value, "creManagerId");
            return (Criteria) this;
        }

        public Criteria andCreManagerIdLessThan(Integer value) {
            addCriterion("cre_manager_id <", value, "creManagerId");
            return (Criteria) this;
        }

        public Criteria andCreManagerIdLessThanOrEqualTo(Integer value) {
            addCriterion("cre_manager_id <=", value, "creManagerId");
            return (Criteria) this;
        }

        public Criteria andCreManagerIdIn(List<Integer> values) {
            addCriterion("cre_manager_id in", values, "creManagerId");
            return (Criteria) this;
        }

        public Criteria andCreManagerIdNotIn(List<Integer> values) {
            addCriterion("cre_manager_id not in", values, "creManagerId");
            return (Criteria) this;
        }

        public Criteria andCreManagerIdBetween(Integer value1, Integer value2) {
            addCriterion("cre_manager_id between", value1, value2, "creManagerId");
            return (Criteria) this;
        }

        public Criteria andCreManagerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cre_manager_id not between", value1, value2, "creManagerId");
            return (Criteria) this;
        }

        public Criteria andUpdManagerIdIsNull() {
            addCriterion("upd_manager_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdManagerIdIsNotNull() {
            addCriterion("upd_manager_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdManagerIdEqualTo(Integer value) {
            addCriterion("upd_manager_id =", value, "updManagerId");
            return (Criteria) this;
        }

        public Criteria andUpdManagerIdNotEqualTo(Integer value) {
            addCriterion("upd_manager_id <>", value, "updManagerId");
            return (Criteria) this;
        }

        public Criteria andUpdManagerIdGreaterThan(Integer value) {
            addCriterion("upd_manager_id >", value, "updManagerId");
            return (Criteria) this;
        }

        public Criteria andUpdManagerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("upd_manager_id >=", value, "updManagerId");
            return (Criteria) this;
        }

        public Criteria andUpdManagerIdLessThan(Integer value) {
            addCriterion("upd_manager_id <", value, "updManagerId");
            return (Criteria) this;
        }

        public Criteria andUpdManagerIdLessThanOrEqualTo(Integer value) {
            addCriterion("upd_manager_id <=", value, "updManagerId");
            return (Criteria) this;
        }

        public Criteria andUpdManagerIdIn(List<Integer> values) {
            addCriterion("upd_manager_id in", values, "updManagerId");
            return (Criteria) this;
        }

        public Criteria andUpdManagerIdNotIn(List<Integer> values) {
            addCriterion("upd_manager_id not in", values, "updManagerId");
            return (Criteria) this;
        }

        public Criteria andUpdManagerIdBetween(Integer value1, Integer value2) {
            addCriterion("upd_manager_id between", value1, value2, "updManagerId");
            return (Criteria) this;
        }

        public Criteria andUpdManagerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("upd_manager_id not between", value1, value2, "updManagerId");
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