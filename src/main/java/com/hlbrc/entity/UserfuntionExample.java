package com.hlbrc.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserfuntionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserfuntionExample() {
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

        public Criteria andUserFuntionIdIsNull() {
            addCriterion("user_funtion_id is null");
            return (Criteria) this;
        }

        public Criteria andUserFuntionIdIsNotNull() {
            addCriterion("user_funtion_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserFuntionIdEqualTo(Integer value) {
            addCriterion("user_funtion_id =", value, "userFuntionId");
            return (Criteria) this;
        }

        public Criteria andUserFuntionIdNotEqualTo(Integer value) {
            addCriterion("user_funtion_id <>", value, "userFuntionId");
            return (Criteria) this;
        }

        public Criteria andUserFuntionIdGreaterThan(Integer value) {
            addCriterion("user_funtion_id >", value, "userFuntionId");
            return (Criteria) this;
        }

        public Criteria andUserFuntionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_funtion_id >=", value, "userFuntionId");
            return (Criteria) this;
        }

        public Criteria andUserFuntionIdLessThan(Integer value) {
            addCriterion("user_funtion_id <", value, "userFuntionId");
            return (Criteria) this;
        }

        public Criteria andUserFuntionIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_funtion_id <=", value, "userFuntionId");
            return (Criteria) this;
        }

        public Criteria andUserFuntionIdIn(List<Integer> values) {
            addCriterion("user_funtion_id in", values, "userFuntionId");
            return (Criteria) this;
        }

        public Criteria andUserFuntionIdNotIn(List<Integer> values) {
            addCriterion("user_funtion_id not in", values, "userFuntionId");
            return (Criteria) this;
        }

        public Criteria andUserFuntionIdBetween(Integer value1, Integer value2) {
            addCriterion("user_funtion_id between", value1, value2, "userFuntionId");
            return (Criteria) this;
        }

        public Criteria andUserFuntionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_funtion_id not between", value1, value2, "userFuntionId");
            return (Criteria) this;
        }

        public Criteria andAccountGroupIdIsNull() {
            addCriterion("account_group_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountGroupIdIsNotNull() {
            addCriterion("account_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountGroupIdEqualTo(Integer value) {
            addCriterion("account_group_id =", value, "accountGroupId");
            return (Criteria) this;
        }

        public Criteria andAccountGroupIdNotEqualTo(Integer value) {
            addCriterion("account_group_id <>", value, "accountGroupId");
            return (Criteria) this;
        }

        public Criteria andAccountGroupIdGreaterThan(Integer value) {
            addCriterion("account_group_id >", value, "accountGroupId");
            return (Criteria) this;
        }

        public Criteria andAccountGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_group_id >=", value, "accountGroupId");
            return (Criteria) this;
        }

        public Criteria andAccountGroupIdLessThan(Integer value) {
            addCriterion("account_group_id <", value, "accountGroupId");
            return (Criteria) this;
        }

        public Criteria andAccountGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("account_group_id <=", value, "accountGroupId");
            return (Criteria) this;
        }

        public Criteria andAccountGroupIdIn(List<Integer> values) {
            addCriterion("account_group_id in", values, "accountGroupId");
            return (Criteria) this;
        }

        public Criteria andAccountGroupIdNotIn(List<Integer> values) {
            addCriterion("account_group_id not in", values, "accountGroupId");
            return (Criteria) this;
        }

        public Criteria andAccountGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("account_group_id between", value1, value2, "accountGroupId");
            return (Criteria) this;
        }

        public Criteria andAccountGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("account_group_id not between", value1, value2, "accountGroupId");
            return (Criteria) this;
        }

        public Criteria andUserFuntionNoIsNull() {
            addCriterion("user_funtion_no is null");
            return (Criteria) this;
        }

        public Criteria andUserFuntionNoIsNotNull() {
            addCriterion("user_funtion_no is not null");
            return (Criteria) this;
        }

        public Criteria andUserFuntionNoEqualTo(String value) {
            addCriterion("user_funtion_no =", value, "userFuntionNo");
            return (Criteria) this;
        }

        public Criteria andUserFuntionNoNotEqualTo(String value) {
            addCriterion("user_funtion_no <>", value, "userFuntionNo");
            return (Criteria) this;
        }

        public Criteria andUserFuntionNoGreaterThan(String value) {
            addCriterion("user_funtion_no >", value, "userFuntionNo");
            return (Criteria) this;
        }

        public Criteria andUserFuntionNoGreaterThanOrEqualTo(String value) {
            addCriterion("user_funtion_no >=", value, "userFuntionNo");
            return (Criteria) this;
        }

        public Criteria andUserFuntionNoLessThan(String value) {
            addCriterion("user_funtion_no <", value, "userFuntionNo");
            return (Criteria) this;
        }

        public Criteria andUserFuntionNoLessThanOrEqualTo(String value) {
            addCriterion("user_funtion_no <=", value, "userFuntionNo");
            return (Criteria) this;
        }

        public Criteria andUserFuntionNoLike(String value) {
            addCriterion("user_funtion_no like", value, "userFuntionNo");
            return (Criteria) this;
        }

        public Criteria andUserFuntionNoNotLike(String value) {
            addCriterion("user_funtion_no not like", value, "userFuntionNo");
            return (Criteria) this;
        }

        public Criteria andUserFuntionNoIn(List<String> values) {
            addCriterion("user_funtion_no in", values, "userFuntionNo");
            return (Criteria) this;
        }

        public Criteria andUserFuntionNoNotIn(List<String> values) {
            addCriterion("user_funtion_no not in", values, "userFuntionNo");
            return (Criteria) this;
        }

        public Criteria andUserFuntionNoBetween(String value1, String value2) {
            addCriterion("user_funtion_no between", value1, value2, "userFuntionNo");
            return (Criteria) this;
        }

        public Criteria andUserFuntionNoNotBetween(String value1, String value2) {
            addCriterion("user_funtion_no not between", value1, value2, "userFuntionNo");
            return (Criteria) this;
        }

        public Criteria andUserFuntionNameIsNull() {
            addCriterion("user_funtion_name is null");
            return (Criteria) this;
        }

        public Criteria andUserFuntionNameIsNotNull() {
            addCriterion("user_funtion_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserFuntionNameEqualTo(String value) {
            addCriterion("user_funtion_name =", value, "userFuntionName");
            return (Criteria) this;
        }

        public Criteria andUserFuntionNameNotEqualTo(String value) {
            addCriterion("user_funtion_name <>", value, "userFuntionName");
            return (Criteria) this;
        }

        public Criteria andUserFuntionNameGreaterThan(String value) {
            addCriterion("user_funtion_name >", value, "userFuntionName");
            return (Criteria) this;
        }

        public Criteria andUserFuntionNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_funtion_name >=", value, "userFuntionName");
            return (Criteria) this;
        }

        public Criteria andUserFuntionNameLessThan(String value) {
            addCriterion("user_funtion_name <", value, "userFuntionName");
            return (Criteria) this;
        }

        public Criteria andUserFuntionNameLessThanOrEqualTo(String value) {
            addCriterion("user_funtion_name <=", value, "userFuntionName");
            return (Criteria) this;
        }

        public Criteria andUserFuntionNameLike(String value) {
            addCriterion("user_funtion_name like", value, "userFuntionName");
            return (Criteria) this;
        }

        public Criteria andUserFuntionNameNotLike(String value) {
            addCriterion("user_funtion_name not like", value, "userFuntionName");
            return (Criteria) this;
        }

        public Criteria andUserFuntionNameIn(List<String> values) {
            addCriterion("user_funtion_name in", values, "userFuntionName");
            return (Criteria) this;
        }

        public Criteria andUserFuntionNameNotIn(List<String> values) {
            addCriterion("user_funtion_name not in", values, "userFuntionName");
            return (Criteria) this;
        }

        public Criteria andUserFuntionNameBetween(String value1, String value2) {
            addCriterion("user_funtion_name between", value1, value2, "userFuntionName");
            return (Criteria) this;
        }

        public Criteria andUserFuntionNameNotBetween(String value1, String value2) {
            addCriterion("user_funtion_name not between", value1, value2, "userFuntionName");
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

        public Criteria andCreatTimeIsNull() {
            addCriterion("creat_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNotNull() {
            addCriterion("creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeEqualTo(Date value) {
            addCriterion("creat_time =", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotEqualTo(Date value) {
            addCriterion("creat_time <>", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThan(Date value) {
            addCriterion("creat_time >", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creat_time >=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThan(Date value) {
            addCriterion("creat_time <", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("creat_time <=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIn(List<Date> values) {
            addCriterion("creat_time in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotIn(List<Date> values) {
            addCriterion("creat_time not in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeBetween(Date value1, Date value2) {
            addCriterion("creat_time between", value1, value2, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("creat_time not between", value1, value2, "creatTime");
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