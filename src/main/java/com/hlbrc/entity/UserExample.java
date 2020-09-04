package com.hlbrc.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNull() {
            addCriterion("store_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNotNull() {
            addCriterion("store_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreIdEqualTo(Integer value) {
            addCriterion("store_id =", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotEqualTo(Integer value) {
            addCriterion("store_id <>", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThan(Integer value) {
            addCriterion("store_id >", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_id >=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThan(Integer value) {
            addCriterion("store_id <", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThanOrEqualTo(Integer value) {
            addCriterion("store_id <=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIn(List<Integer> values) {
            addCriterion("store_id in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotIn(List<Integer> values) {
            addCriterion("store_id not in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdBetween(Integer value1, Integer value2) {
            addCriterion("store_id between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotBetween(Integer value1, Integer value2) {
            addCriterion("store_id not between", value1, value2, "storeId");
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNull() {
            addCriterion("user_sex is null");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNotNull() {
            addCriterion("user_sex is not null");
            return (Criteria) this;
        }

        public Criteria andUserSexEqualTo(String value) {
            addCriterion("user_sex =", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotEqualTo(String value) {
            addCriterion("user_sex <>", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThan(String value) {
            addCriterion("user_sex >", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThanOrEqualTo(String value) {
            addCriterion("user_sex >=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThan(String value) {
            addCriterion("user_sex <", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThanOrEqualTo(String value) {
            addCriterion("user_sex <=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLike(String value) {
            addCriterion("user_sex like", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotLike(String value) {
            addCriterion("user_sex not like", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexIn(List<String> values) {
            addCriterion("user_sex in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotIn(List<String> values) {
            addCriterion("user_sex not in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexBetween(String value1, String value2) {
            addCriterion("user_sex between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotBetween(String value1, String value2) {
            addCriterion("user_sex not between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserAgeIsNull() {
            addCriterion("user_age is null");
            return (Criteria) this;
        }

        public Criteria andUserAgeIsNotNull() {
            addCriterion("user_age is not null");
            return (Criteria) this;
        }

        public Criteria andUserAgeEqualTo(Integer value) {
            addCriterion("user_age =", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeNotEqualTo(Integer value) {
            addCriterion("user_age <>", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeGreaterThan(Integer value) {
            addCriterion("user_age >", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_age >=", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeLessThan(Integer value) {
            addCriterion("user_age <", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeLessThanOrEqualTo(Integer value) {
            addCriterion("user_age <=", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeIn(List<Integer> values) {
            addCriterion("user_age in", values, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeNotIn(List<Integer> values) {
            addCriterion("user_age not in", values, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeBetween(Integer value1, Integer value2) {
            addCriterion("user_age between", value1, value2, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("user_age not between", value1, value2, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserBirthTimeIsNull() {
            addCriterion("user_birth_time is null");
            return (Criteria) this;
        }

        public Criteria andUserBirthTimeIsNotNull() {
            addCriterion("user_birth_time is not null");
            return (Criteria) this;
        }

        public Criteria andUserBirthTimeEqualTo(String value) {
            addCriterion("user_birth_time =", value, "userBirthTime");
            return (Criteria) this;
        }

        public Criteria andUserBirthTimeNotEqualTo(String value) {
            addCriterion("user_birth_time <>", value, "userBirthTime");
            return (Criteria) this;
        }

        public Criteria andUserBirthTimeGreaterThan(String value) {
            addCriterion("user_birth_time >", value, "userBirthTime");
            return (Criteria) this;
        }

        public Criteria andUserBirthTimeGreaterThanOrEqualTo(String value) {
            addCriterion("user_birth_time >=", value, "userBirthTime");
            return (Criteria) this;
        }

        public Criteria andUserBirthTimeLessThan(String value) {
            addCriterion("user_birth_time <", value, "userBirthTime");
            return (Criteria) this;
        }

        public Criteria andUserBirthTimeLessThanOrEqualTo(String value) {
            addCriterion("user_birth_time <=", value, "userBirthTime");
            return (Criteria) this;
        }

        public Criteria andUserBirthTimeLike(String value) {
            addCriterion("user_birth_time like", value, "userBirthTime");
            return (Criteria) this;
        }

        public Criteria andUserBirthTimeNotLike(String value) {
            addCriterion("user_birth_time not like", value, "userBirthTime");
            return (Criteria) this;
        }

        public Criteria andUserBirthTimeIn(List<String> values) {
            addCriterion("user_birth_time in", values, "userBirthTime");
            return (Criteria) this;
        }

        public Criteria andUserBirthTimeNotIn(List<String> values) {
            addCriterion("user_birth_time not in", values, "userBirthTime");
            return (Criteria) this;
        }

        public Criteria andUserBirthTimeBetween(String value1, String value2) {
            addCriterion("user_birth_time between", value1, value2, "userBirthTime");
            return (Criteria) this;
        }

        public Criteria andUserBirthTimeNotBetween(String value1, String value2) {
            addCriterion("user_birth_time not between", value1, value2, "userBirthTime");
            return (Criteria) this;
        }

        public Criteria andUserTelIsNull() {
            addCriterion("user_tel is null");
            return (Criteria) this;
        }

        public Criteria andUserTelIsNotNull() {
            addCriterion("user_tel is not null");
            return (Criteria) this;
        }

        public Criteria andUserTelEqualTo(String value) {
            addCriterion("user_tel =", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelNotEqualTo(String value) {
            addCriterion("user_tel <>", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelGreaterThan(String value) {
            addCriterion("user_tel >", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelGreaterThanOrEqualTo(String value) {
            addCriterion("user_tel >=", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelLessThan(String value) {
            addCriterion("user_tel <", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelLessThanOrEqualTo(String value) {
            addCriterion("user_tel <=", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelLike(String value) {
            addCriterion("user_tel like", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelNotLike(String value) {
            addCriterion("user_tel not like", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelIn(List<String> values) {
            addCriterion("user_tel in", values, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelNotIn(List<String> values) {
            addCriterion("user_tel not in", values, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelBetween(String value1, String value2) {
            addCriterion("user_tel between", value1, value2, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelNotBetween(String value1, String value2) {
            addCriterion("user_tel not between", value1, value2, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNumIsNull() {
            addCriterion("user_idcard_num is null");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNumIsNotNull() {
            addCriterion("user_idcard_num is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNumEqualTo(String value) {
            addCriterion("user_idcard_num =", value, "userIdcardNum");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNumNotEqualTo(String value) {
            addCriterion("user_idcard_num <>", value, "userIdcardNum");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNumGreaterThan(String value) {
            addCriterion("user_idcard_num >", value, "userIdcardNum");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNumGreaterThanOrEqualTo(String value) {
            addCriterion("user_idcard_num >=", value, "userIdcardNum");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNumLessThan(String value) {
            addCriterion("user_idcard_num <", value, "userIdcardNum");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNumLessThanOrEqualTo(String value) {
            addCriterion("user_idcard_num <=", value, "userIdcardNum");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNumLike(String value) {
            addCriterion("user_idcard_num like", value, "userIdcardNum");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNumNotLike(String value) {
            addCriterion("user_idcard_num not like", value, "userIdcardNum");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNumIn(List<String> values) {
            addCriterion("user_idcard_num in", values, "userIdcardNum");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNumNotIn(List<String> values) {
            addCriterion("user_idcard_num not in", values, "userIdcardNum");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNumBetween(String value1, String value2) {
            addCriterion("user_idcard_num between", value1, value2, "userIdcardNum");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNumNotBetween(String value1, String value2) {
            addCriterion("user_idcard_num not between", value1, value2, "userIdcardNum");
            return (Criteria) this;
        }

        public Criteria andUserMoneyIsNull() {
            addCriterion("user_money is null");
            return (Criteria) this;
        }

        public Criteria andUserMoneyIsNotNull() {
            addCriterion("user_money is not null");
            return (Criteria) this;
        }

        public Criteria andUserMoneyEqualTo(Double value) {
            addCriterion("user_money =", value, "userMoney");
            return (Criteria) this;
        }

        public Criteria andUserMoneyNotEqualTo(Double value) {
            addCriterion("user_money <>", value, "userMoney");
            return (Criteria) this;
        }

        public Criteria andUserMoneyGreaterThan(Double value) {
            addCriterion("user_money >", value, "userMoney");
            return (Criteria) this;
        }

        public Criteria andUserMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("user_money >=", value, "userMoney");
            return (Criteria) this;
        }

        public Criteria andUserMoneyLessThan(Double value) {
            addCriterion("user_money <", value, "userMoney");
            return (Criteria) this;
        }

        public Criteria andUserMoneyLessThanOrEqualTo(Double value) {
            addCriterion("user_money <=", value, "userMoney");
            return (Criteria) this;
        }

        public Criteria andUserMoneyIn(List<Double> values) {
            addCriterion("user_money in", values, "userMoney");
            return (Criteria) this;
        }

        public Criteria andUserMoneyNotIn(List<Double> values) {
            addCriterion("user_money not in", values, "userMoney");
            return (Criteria) this;
        }

        public Criteria andUserMoneyBetween(Double value1, Double value2) {
            addCriterion("user_money between", value1, value2, "userMoney");
            return (Criteria) this;
        }

        public Criteria andUserMoneyNotBetween(Double value1, Double value2) {
            addCriterion("user_money not between", value1, value2, "userMoney");
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

        public Criteria andUserStateIsNull() {
            addCriterion("user_state is null");
            return (Criteria) this;
        }

        public Criteria andUserStateIsNotNull() {
            addCriterion("user_state is not null");
            return (Criteria) this;
        }

        public Criteria andUserStateEqualTo(Integer value) {
            addCriterion("user_state =", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateNotEqualTo(Integer value) {
            addCriterion("user_state <>", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateGreaterThan(Integer value) {
            addCriterion("user_state >", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_state >=", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateLessThan(Integer value) {
            addCriterion("user_state <", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateLessThanOrEqualTo(Integer value) {
            addCriterion("user_state <=", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateIn(List<Integer> values) {
            addCriterion("user_state in", values, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateNotIn(List<Integer> values) {
            addCriterion("user_state not in", values, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateBetween(Integer value1, Integer value2) {
            addCriterion("user_state between", value1, value2, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateNotBetween(Integer value1, Integer value2) {
            addCriterion("user_state not between", value1, value2, "userState");
            return (Criteria) this;
        }

        public Criteria andUserAddressIsNull() {
            addCriterion("user_address is null");
            return (Criteria) this;
        }

        public Criteria andUserAddressIsNotNull() {
            addCriterion("user_address is not null");
            return (Criteria) this;
        }

        public Criteria andUserAddressEqualTo(String value) {
            addCriterion("user_address =", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotEqualTo(String value) {
            addCriterion("user_address <>", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressGreaterThan(String value) {
            addCriterion("user_address >", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressGreaterThanOrEqualTo(String value) {
            addCriterion("user_address >=", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressLessThan(String value) {
            addCriterion("user_address <", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressLessThanOrEqualTo(String value) {
            addCriterion("user_address <=", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressLike(String value) {
            addCriterion("user_address like", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotLike(String value) {
            addCriterion("user_address not like", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressIn(List<String> values) {
            addCriterion("user_address in", values, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotIn(List<String> values) {
            addCriterion("user_address not in", values, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressBetween(String value1, String value2) {
            addCriterion("user_address between", value1, value2, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotBetween(String value1, String value2) {
            addCriterion("user_address not between", value1, value2, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserGradeIsNull() {
            addCriterion("user_grade is null");
            return (Criteria) this;
        }

        public Criteria andUserGradeIsNotNull() {
            addCriterion("user_grade is not null");
            return (Criteria) this;
        }

        public Criteria andUserGradeEqualTo(String value) {
            addCriterion("user_grade =", value, "userGrade");
            return (Criteria) this;
        }

        public Criteria andUserGradeNotEqualTo(String value) {
            addCriterion("user_grade <>", value, "userGrade");
            return (Criteria) this;
        }

        public Criteria andUserGradeGreaterThan(String value) {
            addCriterion("user_grade >", value, "userGrade");
            return (Criteria) this;
        }

        public Criteria andUserGradeGreaterThanOrEqualTo(String value) {
            addCriterion("user_grade >=", value, "userGrade");
            return (Criteria) this;
        }

        public Criteria andUserGradeLessThan(String value) {
            addCriterion("user_grade <", value, "userGrade");
            return (Criteria) this;
        }

        public Criteria andUserGradeLessThanOrEqualTo(String value) {
            addCriterion("user_grade <=", value, "userGrade");
            return (Criteria) this;
        }

        public Criteria andUserGradeLike(String value) {
            addCriterion("user_grade like", value, "userGrade");
            return (Criteria) this;
        }

        public Criteria andUserGradeNotLike(String value) {
            addCriterion("user_grade not like", value, "userGrade");
            return (Criteria) this;
        }

        public Criteria andUserGradeIn(List<String> values) {
            addCriterion("user_grade in", values, "userGrade");
            return (Criteria) this;
        }

        public Criteria andUserGradeNotIn(List<String> values) {
            addCriterion("user_grade not in", values, "userGrade");
            return (Criteria) this;
        }

        public Criteria andUserGradeBetween(String value1, String value2) {
            addCriterion("user_grade between", value1, value2, "userGrade");
            return (Criteria) this;
        }

        public Criteria andUserGradeNotBetween(String value1, String value2) {
            addCriterion("user_grade not between", value1, value2, "userGrade");
            return (Criteria) this;
        }

        public Criteria andUserConsumeIsNull() {
            addCriterion("user_consume is null");
            return (Criteria) this;
        }

        public Criteria andUserConsumeIsNotNull() {
            addCriterion("user_consume is not null");
            return (Criteria) this;
        }

        public Criteria andUserConsumeEqualTo(Double value) {
            addCriterion("user_consume =", value, "userConsume");
            return (Criteria) this;
        }

        public Criteria andUserConsumeNotEqualTo(Double value) {
            addCriterion("user_consume <>", value, "userConsume");
            return (Criteria) this;
        }

        public Criteria andUserConsumeGreaterThan(Double value) {
            addCriterion("user_consume >", value, "userConsume");
            return (Criteria) this;
        }

        public Criteria andUserConsumeGreaterThanOrEqualTo(Double value) {
            addCriterion("user_consume >=", value, "userConsume");
            return (Criteria) this;
        }

        public Criteria andUserConsumeLessThan(Double value) {
            addCriterion("user_consume <", value, "userConsume");
            return (Criteria) this;
        }

        public Criteria andUserConsumeLessThanOrEqualTo(Double value) {
            addCriterion("user_consume <=", value, "userConsume");
            return (Criteria) this;
        }

        public Criteria andUserConsumeIn(List<Double> values) {
            addCriterion("user_consume in", values, "userConsume");
            return (Criteria) this;
        }

        public Criteria andUserConsumeNotIn(List<Double> values) {
            addCriterion("user_consume not in", values, "userConsume");
            return (Criteria) this;
        }

        public Criteria andUserConsumeBetween(Double value1, Double value2) {
            addCriterion("user_consume between", value1, value2, "userConsume");
            return (Criteria) this;
        }

        public Criteria andUserConsumeNotBetween(Double value1, Double value2) {
            addCriterion("user_consume not between", value1, value2, "userConsume");
            return (Criteria) this;
        }

        public Criteria andUserIntegralIsNull() {
            addCriterion("user_integral is null");
            return (Criteria) this;
        }

        public Criteria andUserIntegralIsNotNull() {
            addCriterion("user_integral is not null");
            return (Criteria) this;
        }

        public Criteria andUserIntegralEqualTo(Double value) {
            addCriterion("user_integral =", value, "userIntegral");
            return (Criteria) this;
        }

        public Criteria andUserIntegralNotEqualTo(Double value) {
            addCriterion("user_integral <>", value, "userIntegral");
            return (Criteria) this;
        }

        public Criteria andUserIntegralGreaterThan(Double value) {
            addCriterion("user_integral >", value, "userIntegral");
            return (Criteria) this;
        }

        public Criteria andUserIntegralGreaterThanOrEqualTo(Double value) {
            addCriterion("user_integral >=", value, "userIntegral");
            return (Criteria) this;
        }

        public Criteria andUserIntegralLessThan(Double value) {
            addCriterion("user_integral <", value, "userIntegral");
            return (Criteria) this;
        }

        public Criteria andUserIntegralLessThanOrEqualTo(Double value) {
            addCriterion("user_integral <=", value, "userIntegral");
            return (Criteria) this;
        }

        public Criteria andUserIntegralIn(List<Double> values) {
            addCriterion("user_integral in", values, "userIntegral");
            return (Criteria) this;
        }

        public Criteria andUserIntegralNotIn(List<Double> values) {
            addCriterion("user_integral not in", values, "userIntegral");
            return (Criteria) this;
        }

        public Criteria andUserIntegralBetween(Double value1, Double value2) {
            addCriterion("user_integral between", value1, value2, "userIntegral");
            return (Criteria) this;
        }

        public Criteria andUserIntegralNotBetween(Double value1, Double value2) {
            addCriterion("user_integral not between", value1, value2, "userIntegral");
            return (Criteria) this;
        }

        public Criteria andUserConsumeNumberIsNull() {
            addCriterion("user_consume_number is null");
            return (Criteria) this;
        }

        public Criteria andUserConsumeNumberIsNotNull() {
            addCriterion("user_consume_number is not null");
            return (Criteria) this;
        }

        public Criteria andUserConsumeNumberEqualTo(Integer value) {
            addCriterion("user_consume_number =", value, "userConsumeNumber");
            return (Criteria) this;
        }

        public Criteria andUserConsumeNumberNotEqualTo(Integer value) {
            addCriterion("user_consume_number <>", value, "userConsumeNumber");
            return (Criteria) this;
        }

        public Criteria andUserConsumeNumberGreaterThan(Integer value) {
            addCriterion("user_consume_number >", value, "userConsumeNumber");
            return (Criteria) this;
        }

        public Criteria andUserConsumeNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_consume_number >=", value, "userConsumeNumber");
            return (Criteria) this;
        }

        public Criteria andUserConsumeNumberLessThan(Integer value) {
            addCriterion("user_consume_number <", value, "userConsumeNumber");
            return (Criteria) this;
        }

        public Criteria andUserConsumeNumberLessThanOrEqualTo(Integer value) {
            addCriterion("user_consume_number <=", value, "userConsumeNumber");
            return (Criteria) this;
        }

        public Criteria andUserConsumeNumberIn(List<Integer> values) {
            addCriterion("user_consume_number in", values, "userConsumeNumber");
            return (Criteria) this;
        }

        public Criteria andUserConsumeNumberNotIn(List<Integer> values) {
            addCriterion("user_consume_number not in", values, "userConsumeNumber");
            return (Criteria) this;
        }

        public Criteria andUserConsumeNumberBetween(Integer value1, Integer value2) {
            addCriterion("user_consume_number between", value1, value2, "userConsumeNumber");
            return (Criteria) this;
        }

        public Criteria andUserConsumeNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("user_consume_number not between", value1, value2, "userConsumeNumber");
            return (Criteria) this;
        }

        public Criteria andUserRegistTimeIsNull() {
            addCriterion("user_regist_time is null");
            return (Criteria) this;
        }

        public Criteria andUserRegistTimeIsNotNull() {
            addCriterion("user_regist_time is not null");
            return (Criteria) this;
        }

        public Criteria andUserRegistTimeEqualTo(Date value) {
            addCriterion("user_regist_time =", value, "userRegistTime");
            return (Criteria) this;
        }

        public Criteria andUserRegistTimeNotEqualTo(Date value) {
            addCriterion("user_regist_time <>", value, "userRegistTime");
            return (Criteria) this;
        }

        public Criteria andUserRegistTimeGreaterThan(Date value) {
            addCriterion("user_regist_time >", value, "userRegistTime");
            return (Criteria) this;
        }

        public Criteria andUserRegistTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("user_regist_time >=", value, "userRegistTime");
            return (Criteria) this;
        }

        public Criteria andUserRegistTimeLessThan(Date value) {
            addCriterion("user_regist_time <", value, "userRegistTime");
            return (Criteria) this;
        }

        public Criteria andUserRegistTimeLessThanOrEqualTo(Date value) {
            addCriterion("user_regist_time <=", value, "userRegistTime");
            return (Criteria) this;
        }

        public Criteria andUserRegistTimeIn(List<Date> values) {
            addCriterion("user_regist_time in", values, "userRegistTime");
            return (Criteria) this;
        }

        public Criteria andUserRegistTimeNotIn(List<Date> values) {
            addCriterion("user_regist_time not in", values, "userRegistTime");
            return (Criteria) this;
        }

        public Criteria andUserRegistTimeBetween(Date value1, Date value2) {
            addCriterion("user_regist_time between", value1, value2, "userRegistTime");
            return (Criteria) this;
        }

        public Criteria andUserRegistTimeNotBetween(Date value1, Date value2) {
            addCriterion("user_regist_time not between", value1, value2, "userRegistTime");
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

        public Criteria andUserNoIsNull() {
            addCriterion("user_no is null");
            return (Criteria) this;
        }

        public Criteria andUserNoIsNotNull() {
            addCriterion("user_no is not null");
            return (Criteria) this;
        }

        public Criteria andUserNoEqualTo(String value) {
            addCriterion("user_no =", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotEqualTo(String value) {
            addCriterion("user_no <>", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoGreaterThan(String value) {
            addCriterion("user_no >", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoGreaterThanOrEqualTo(String value) {
            addCriterion("user_no >=", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLessThan(String value) {
            addCriterion("user_no <", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLessThanOrEqualTo(String value) {
            addCriterion("user_no <=", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLike(String value) {
            addCriterion("user_no like", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotLike(String value) {
            addCriterion("user_no not like", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoIn(List<String> values) {
            addCriterion("user_no in", values, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotIn(List<String> values) {
            addCriterion("user_no not in", values, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoBetween(String value1, String value2) {
            addCriterion("user_no between", value1, value2, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotBetween(String value1, String value2) {
            addCriterion("user_no not between", value1, value2, "userNo");
            return (Criteria) this;
        }

        public Criteria andFixedLineTelephonneIsNull() {
            addCriterion("fixed_line_telephonne is null");
            return (Criteria) this;
        }

        public Criteria andFixedLineTelephonneIsNotNull() {
            addCriterion("fixed_line_telephonne is not null");
            return (Criteria) this;
        }

        public Criteria andFixedLineTelephonneEqualTo(String value) {
            addCriterion("fixed_line_telephonne =", value, "fixedLineTelephonne");
            return (Criteria) this;
        }

        public Criteria andFixedLineTelephonneNotEqualTo(String value) {
            addCriterion("fixed_line_telephonne <>", value, "fixedLineTelephonne");
            return (Criteria) this;
        }

        public Criteria andFixedLineTelephonneGreaterThan(String value) {
            addCriterion("fixed_line_telephonne >", value, "fixedLineTelephonne");
            return (Criteria) this;
        }

        public Criteria andFixedLineTelephonneGreaterThanOrEqualTo(String value) {
            addCriterion("fixed_line_telephonne >=", value, "fixedLineTelephonne");
            return (Criteria) this;
        }

        public Criteria andFixedLineTelephonneLessThan(String value) {
            addCriterion("fixed_line_telephonne <", value, "fixedLineTelephonne");
            return (Criteria) this;
        }

        public Criteria andFixedLineTelephonneLessThanOrEqualTo(String value) {
            addCriterion("fixed_line_telephonne <=", value, "fixedLineTelephonne");
            return (Criteria) this;
        }

        public Criteria andFixedLineTelephonneLike(String value) {
            addCriterion("fixed_line_telephonne like", value, "fixedLineTelephonne");
            return (Criteria) this;
        }

        public Criteria andFixedLineTelephonneNotLike(String value) {
            addCriterion("fixed_line_telephonne not like", value, "fixedLineTelephonne");
            return (Criteria) this;
        }

        public Criteria andFixedLineTelephonneIn(List<String> values) {
            addCriterion("fixed_line_telephonne in", values, "fixedLineTelephonne");
            return (Criteria) this;
        }

        public Criteria andFixedLineTelephonneNotIn(List<String> values) {
            addCriterion("fixed_line_telephonne not in", values, "fixedLineTelephonne");
            return (Criteria) this;
        }

        public Criteria andFixedLineTelephonneBetween(String value1, String value2) {
            addCriterion("fixed_line_telephonne between", value1, value2, "fixedLineTelephonne");
            return (Criteria) this;
        }

        public Criteria andFixedLineTelephonneNotBetween(String value1, String value2) {
            addCriterion("fixed_line_telephonne not between", value1, value2, "fixedLineTelephonne");
            return (Criteria) this;
        }

        public Criteria andFromEnterpriseIdIsNull() {
            addCriterion("from_enterprise_id is null");
            return (Criteria) this;
        }

        public Criteria andFromEnterpriseIdIsNotNull() {
            addCriterion("from_enterprise_id is not null");
            return (Criteria) this;
        }

        public Criteria andFromEnterpriseIdEqualTo(String value) {
            addCriterion("from_enterprise_id =", value, "fromEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andFromEnterpriseIdNotEqualTo(String value) {
            addCriterion("from_enterprise_id <>", value, "fromEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andFromEnterpriseIdGreaterThan(String value) {
            addCriterion("from_enterprise_id >", value, "fromEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andFromEnterpriseIdGreaterThanOrEqualTo(String value) {
            addCriterion("from_enterprise_id >=", value, "fromEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andFromEnterpriseIdLessThan(String value) {
            addCriterion("from_enterprise_id <", value, "fromEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andFromEnterpriseIdLessThanOrEqualTo(String value) {
            addCriterion("from_enterprise_id <=", value, "fromEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andFromEnterpriseIdLike(String value) {
            addCriterion("from_enterprise_id like", value, "fromEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andFromEnterpriseIdNotLike(String value) {
            addCriterion("from_enterprise_id not like", value, "fromEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andFromEnterpriseIdIn(List<String> values) {
            addCriterion("from_enterprise_id in", values, "fromEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andFromEnterpriseIdNotIn(List<String> values) {
            addCriterion("from_enterprise_id not in", values, "fromEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andFromEnterpriseIdBetween(String value1, String value2) {
            addCriterion("from_enterprise_id between", value1, value2, "fromEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andFromEnterpriseIdNotBetween(String value1, String value2) {
            addCriterion("from_enterprise_id not between", value1, value2, "fromEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andFirstLoginTimeIsNull() {
            addCriterion("first_login_time is null");
            return (Criteria) this;
        }

        public Criteria andFirstLoginTimeIsNotNull() {
            addCriterion("first_login_time is not null");
            return (Criteria) this;
        }

        public Criteria andFirstLoginTimeEqualTo(Date value) {
            addCriterion("first_login_time =", value, "firstLoginTime");
            return (Criteria) this;
        }

        public Criteria andFirstLoginTimeNotEqualTo(Date value) {
            addCriterion("first_login_time <>", value, "firstLoginTime");
            return (Criteria) this;
        }

        public Criteria andFirstLoginTimeGreaterThan(Date value) {
            addCriterion("first_login_time >", value, "firstLoginTime");
            return (Criteria) this;
        }

        public Criteria andFirstLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("first_login_time >=", value, "firstLoginTime");
            return (Criteria) this;
        }

        public Criteria andFirstLoginTimeLessThan(Date value) {
            addCriterion("first_login_time <", value, "firstLoginTime");
            return (Criteria) this;
        }

        public Criteria andFirstLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("first_login_time <=", value, "firstLoginTime");
            return (Criteria) this;
        }

        public Criteria andFirstLoginTimeIn(List<Date> values) {
            addCriterion("first_login_time in", values, "firstLoginTime");
            return (Criteria) this;
        }

        public Criteria andFirstLoginTimeNotIn(List<Date> values) {
            addCriterion("first_login_time not in", values, "firstLoginTime");
            return (Criteria) this;
        }

        public Criteria andFirstLoginTimeBetween(Date value1, Date value2) {
            addCriterion("first_login_time between", value1, value2, "firstLoginTime");
            return (Criteria) this;
        }

        public Criteria andFirstLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("first_login_time not between", value1, value2, "firstLoginTime");
            return (Criteria) this;
        }

        public Criteria andFirstLoginIpIsNull() {
            addCriterion("first_login_ip is null");
            return (Criteria) this;
        }

        public Criteria andFirstLoginIpIsNotNull() {
            addCriterion("first_login_ip is not null");
            return (Criteria) this;
        }

        public Criteria andFirstLoginIpEqualTo(String value) {
            addCriterion("first_login_ip =", value, "firstLoginIp");
            return (Criteria) this;
        }

        public Criteria andFirstLoginIpNotEqualTo(String value) {
            addCriterion("first_login_ip <>", value, "firstLoginIp");
            return (Criteria) this;
        }

        public Criteria andFirstLoginIpGreaterThan(String value) {
            addCriterion("first_login_ip >", value, "firstLoginIp");
            return (Criteria) this;
        }

        public Criteria andFirstLoginIpGreaterThanOrEqualTo(String value) {
            addCriterion("first_login_ip >=", value, "firstLoginIp");
            return (Criteria) this;
        }

        public Criteria andFirstLoginIpLessThan(String value) {
            addCriterion("first_login_ip <", value, "firstLoginIp");
            return (Criteria) this;
        }

        public Criteria andFirstLoginIpLessThanOrEqualTo(String value) {
            addCriterion("first_login_ip <=", value, "firstLoginIp");
            return (Criteria) this;
        }

        public Criteria andFirstLoginIpLike(String value) {
            addCriterion("first_login_ip like", value, "firstLoginIp");
            return (Criteria) this;
        }

        public Criteria andFirstLoginIpNotLike(String value) {
            addCriterion("first_login_ip not like", value, "firstLoginIp");
            return (Criteria) this;
        }

        public Criteria andFirstLoginIpIn(List<String> values) {
            addCriterion("first_login_ip in", values, "firstLoginIp");
            return (Criteria) this;
        }

        public Criteria andFirstLoginIpNotIn(List<String> values) {
            addCriterion("first_login_ip not in", values, "firstLoginIp");
            return (Criteria) this;
        }

        public Criteria andFirstLoginIpBetween(String value1, String value2) {
            addCriterion("first_login_ip between", value1, value2, "firstLoginIp");
            return (Criteria) this;
        }

        public Criteria andFirstLoginIpNotBetween(String value1, String value2) {
            addCriterion("first_login_ip not between", value1, value2, "firstLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNull() {
            addCriterion("last_login_time is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNotNull() {
            addCriterion("last_login_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeEqualTo(Date value) {
            addCriterion("last_login_time =", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotEqualTo(Date value) {
            addCriterion("last_login_time <>", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThan(Date value) {
            addCriterion("last_login_time >", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_login_time >=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThan(Date value) {
            addCriterion("last_login_time <", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_login_time <=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIn(List<Date> values) {
            addCriterion("last_login_time in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotIn(List<Date> values) {
            addCriterion("last_login_time not in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeBetween(Date value1, Date value2) {
            addCriterion("last_login_time between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_login_time not between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIsNull() {
            addCriterion("last_login_ip is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIsNotNull() {
            addCriterion("last_login_ip is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpEqualTo(String value) {
            addCriterion("last_login_ip =", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotEqualTo(String value) {
            addCriterion("last_login_ip <>", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpGreaterThan(String value) {
            addCriterion("last_login_ip >", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpGreaterThanOrEqualTo(String value) {
            addCriterion("last_login_ip >=", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLessThan(String value) {
            addCriterion("last_login_ip <", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLessThanOrEqualTo(String value) {
            addCriterion("last_login_ip <=", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLike(String value) {
            addCriterion("last_login_ip like", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotLike(String value) {
            addCriterion("last_login_ip not like", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIn(List<String> values) {
            addCriterion("last_login_ip in", values, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotIn(List<String> values) {
            addCriterion("last_login_ip not in", values, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpBetween(String value1, String value2) {
            addCriterion("last_login_ip between", value1, value2, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotBetween(String value1, String value2) {
            addCriterion("last_login_ip not between", value1, value2, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andIsTaxIsNull() {
            addCriterion("is_tax is null");
            return (Criteria) this;
        }

        public Criteria andIsTaxIsNotNull() {
            addCriterion("is_tax is not null");
            return (Criteria) this;
        }

        public Criteria andIsTaxEqualTo(Integer value) {
            addCriterion("is_tax =", value, "isTax");
            return (Criteria) this;
        }

        public Criteria andIsTaxNotEqualTo(Integer value) {
            addCriterion("is_tax <>", value, "isTax");
            return (Criteria) this;
        }

        public Criteria andIsTaxGreaterThan(Integer value) {
            addCriterion("is_tax >", value, "isTax");
            return (Criteria) this;
        }

        public Criteria andIsTaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_tax >=", value, "isTax");
            return (Criteria) this;
        }

        public Criteria andIsTaxLessThan(Integer value) {
            addCriterion("is_tax <", value, "isTax");
            return (Criteria) this;
        }

        public Criteria andIsTaxLessThanOrEqualTo(Integer value) {
            addCriterion("is_tax <=", value, "isTax");
            return (Criteria) this;
        }

        public Criteria andIsTaxIn(List<Integer> values) {
            addCriterion("is_tax in", values, "isTax");
            return (Criteria) this;
        }

        public Criteria andIsTaxNotIn(List<Integer> values) {
            addCriterion("is_tax not in", values, "isTax");
            return (Criteria) this;
        }

        public Criteria andIsTaxBetween(Integer value1, Integer value2) {
            addCriterion("is_tax between", value1, value2, "isTax");
            return (Criteria) this;
        }

        public Criteria andIsTaxNotBetween(Integer value1, Integer value2) {
            addCriterion("is_tax not between", value1, value2, "isTax");
            return (Criteria) this;
        }

        public Criteria andDisableIsNull() {
            addCriterion("disable is null");
            return (Criteria) this;
        }

        public Criteria andDisableIsNotNull() {
            addCriterion("disable is not null");
            return (Criteria) this;
        }

        public Criteria andDisableEqualTo(Integer value) {
            addCriterion("disable =", value, "disable");
            return (Criteria) this;
        }

        public Criteria andDisableNotEqualTo(Integer value) {
            addCriterion("disable <>", value, "disable");
            return (Criteria) this;
        }

        public Criteria andDisableGreaterThan(Integer value) {
            addCriterion("disable >", value, "disable");
            return (Criteria) this;
        }

        public Criteria andDisableGreaterThanOrEqualTo(Integer value) {
            addCriterion("disable >=", value, "disable");
            return (Criteria) this;
        }

        public Criteria andDisableLessThan(Integer value) {
            addCriterion("disable <", value, "disable");
            return (Criteria) this;
        }

        public Criteria andDisableLessThanOrEqualTo(Integer value) {
            addCriterion("disable <=", value, "disable");
            return (Criteria) this;
        }

        public Criteria andDisableIn(List<Integer> values) {
            addCriterion("disable in", values, "disable");
            return (Criteria) this;
        }

        public Criteria andDisableNotIn(List<Integer> values) {
            addCriterion("disable not in", values, "disable");
            return (Criteria) this;
        }

        public Criteria andDisableBetween(Integer value1, Integer value2) {
            addCriterion("disable between", value1, value2, "disable");
            return (Criteria) this;
        }

        public Criteria andDisableNotBetween(Integer value1, Integer value2) {
            addCriterion("disable not between", value1, value2, "disable");
            return (Criteria) this;
        }

        public Criteria andOrderRefundRateIsNull() {
            addCriterion("order_refund_rate is null");
            return (Criteria) this;
        }

        public Criteria andOrderRefundRateIsNotNull() {
            addCriterion("order_refund_rate is not null");
            return (Criteria) this;
        }

        public Criteria andOrderRefundRateEqualTo(Double value) {
            addCriterion("order_refund_rate =", value, "orderRefundRate");
            return (Criteria) this;
        }

        public Criteria andOrderRefundRateNotEqualTo(Double value) {
            addCriterion("order_refund_rate <>", value, "orderRefundRate");
            return (Criteria) this;
        }

        public Criteria andOrderRefundRateGreaterThan(Double value) {
            addCriterion("order_refund_rate >", value, "orderRefundRate");
            return (Criteria) this;
        }

        public Criteria andOrderRefundRateGreaterThanOrEqualTo(Double value) {
            addCriterion("order_refund_rate >=", value, "orderRefundRate");
            return (Criteria) this;
        }

        public Criteria andOrderRefundRateLessThan(Double value) {
            addCriterion("order_refund_rate <", value, "orderRefundRate");
            return (Criteria) this;
        }

        public Criteria andOrderRefundRateLessThanOrEqualTo(Double value) {
            addCriterion("order_refund_rate <=", value, "orderRefundRate");
            return (Criteria) this;
        }

        public Criteria andOrderRefundRateIn(List<Double> values) {
            addCriterion("order_refund_rate in", values, "orderRefundRate");
            return (Criteria) this;
        }

        public Criteria andOrderRefundRateNotIn(List<Double> values) {
            addCriterion("order_refund_rate not in", values, "orderRefundRate");
            return (Criteria) this;
        }

        public Criteria andOrderRefundRateBetween(Double value1, Double value2) {
            addCriterion("order_refund_rate between", value1, value2, "orderRefundRate");
            return (Criteria) this;
        }

        public Criteria andOrderRefundRateNotBetween(Double value1, Double value2) {
            addCriterion("order_refund_rate not between", value1, value2, "orderRefundRate");
            return (Criteria) this;
        }

        public Criteria andRewardAmountRateIsNull() {
            addCriterion("reward_amount_rate is null");
            return (Criteria) this;
        }

        public Criteria andRewardAmountRateIsNotNull() {
            addCriterion("reward_amount_rate is not null");
            return (Criteria) this;
        }

        public Criteria andRewardAmountRateEqualTo(Double value) {
            addCriterion("reward_amount_rate =", value, "rewardAmountRate");
            return (Criteria) this;
        }

        public Criteria andRewardAmountRateNotEqualTo(Double value) {
            addCriterion("reward_amount_rate <>", value, "rewardAmountRate");
            return (Criteria) this;
        }

        public Criteria andRewardAmountRateGreaterThan(Double value) {
            addCriterion("reward_amount_rate >", value, "rewardAmountRate");
            return (Criteria) this;
        }

        public Criteria andRewardAmountRateGreaterThanOrEqualTo(Double value) {
            addCriterion("reward_amount_rate >=", value, "rewardAmountRate");
            return (Criteria) this;
        }

        public Criteria andRewardAmountRateLessThan(Double value) {
            addCriterion("reward_amount_rate <", value, "rewardAmountRate");
            return (Criteria) this;
        }

        public Criteria andRewardAmountRateLessThanOrEqualTo(Double value) {
            addCriterion("reward_amount_rate <=", value, "rewardAmountRate");
            return (Criteria) this;
        }

        public Criteria andRewardAmountRateIn(List<Double> values) {
            addCriterion("reward_amount_rate in", values, "rewardAmountRate");
            return (Criteria) this;
        }

        public Criteria andRewardAmountRateNotIn(List<Double> values) {
            addCriterion("reward_amount_rate not in", values, "rewardAmountRate");
            return (Criteria) this;
        }

        public Criteria andRewardAmountRateBetween(Double value1, Double value2) {
            addCriterion("reward_amount_rate between", value1, value2, "rewardAmountRate");
            return (Criteria) this;
        }

        public Criteria andRewardAmountRateNotBetween(Double value1, Double value2) {
            addCriterion("reward_amount_rate not between", value1, value2, "rewardAmountRate");
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