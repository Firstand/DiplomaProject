package com.hlbrc.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyorderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MyorderExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
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

        public Criteria andStoreNameIsNull() {
            addCriterion("store_name is null");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNotNull() {
            addCriterion("store_name is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNameEqualTo(String value) {
            addCriterion("store_name =", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotEqualTo(String value) {
            addCriterion("store_name <>", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThan(String value) {
            addCriterion("store_name >", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThanOrEqualTo(String value) {
            addCriterion("store_name >=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThan(String value) {
            addCriterion("store_name <", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThanOrEqualTo(String value) {
            addCriterion("store_name <=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLike(String value) {
            addCriterion("store_name like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotLike(String value) {
            addCriterion("store_name not like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameIn(List<String> values) {
            addCriterion("store_name in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotIn(List<String> values) {
            addCriterion("store_name not in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameBetween(String value1, String value2) {
            addCriterion("store_name between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotBetween(String value1, String value2) {
            addCriterion("store_name not between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNull() {
            addCriterion("total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(Double value) {
            addCriterion("total_amount =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(Double value) {
            addCriterion("total_amount <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(Double value) {
            addCriterion("total_amount >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("total_amount >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(Double value) {
            addCriterion("total_amount <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(Double value) {
            addCriterion("total_amount <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<Double> values) {
            addCriterion("total_amount in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<Double> values) {
            addCriterion("total_amount not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(Double value1, Double value2) {
            addCriterion("total_amount between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(Double value1, Double value2) {
            addCriterion("total_amount not between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andReceivablesAmountIsNull() {
            addCriterion("receivables_amount is null");
            return (Criteria) this;
        }

        public Criteria andReceivablesAmountIsNotNull() {
            addCriterion("receivables_amount is not null");
            return (Criteria) this;
        }

        public Criteria andReceivablesAmountEqualTo(Double value) {
            addCriterion("receivables_amount =", value, "receivablesAmount");
            return (Criteria) this;
        }

        public Criteria andReceivablesAmountNotEqualTo(Double value) {
            addCriterion("receivables_amount <>", value, "receivablesAmount");
            return (Criteria) this;
        }

        public Criteria andReceivablesAmountGreaterThan(Double value) {
            addCriterion("receivables_amount >", value, "receivablesAmount");
            return (Criteria) this;
        }

        public Criteria andReceivablesAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("receivables_amount >=", value, "receivablesAmount");
            return (Criteria) this;
        }

        public Criteria andReceivablesAmountLessThan(Double value) {
            addCriterion("receivables_amount <", value, "receivablesAmount");
            return (Criteria) this;
        }

        public Criteria andReceivablesAmountLessThanOrEqualTo(Double value) {
            addCriterion("receivables_amount <=", value, "receivablesAmount");
            return (Criteria) this;
        }

        public Criteria andReceivablesAmountIn(List<Double> values) {
            addCriterion("receivables_amount in", values, "receivablesAmount");
            return (Criteria) this;
        }

        public Criteria andReceivablesAmountNotIn(List<Double> values) {
            addCriterion("receivables_amount not in", values, "receivablesAmount");
            return (Criteria) this;
        }

        public Criteria andReceivablesAmountBetween(Double value1, Double value2) {
            addCriterion("receivables_amount between", value1, value2, "receivablesAmount");
            return (Criteria) this;
        }

        public Criteria andReceivablesAmountNotBetween(Double value1, Double value2) {
            addCriterion("receivables_amount not between", value1, value2, "receivablesAmount");
            return (Criteria) this;
        }

        public Criteria andTotalNumIsNull() {
            addCriterion("total_num is null");
            return (Criteria) this;
        }

        public Criteria andTotalNumIsNotNull() {
            addCriterion("total_num is not null");
            return (Criteria) this;
        }

        public Criteria andTotalNumEqualTo(Integer value) {
            addCriterion("total_num =", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumNotEqualTo(Integer value) {
            addCriterion("total_num <>", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumGreaterThan(Integer value) {
            addCriterion("total_num >", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_num >=", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumLessThan(Integer value) {
            addCriterion("total_num <", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumLessThanOrEqualTo(Integer value) {
            addCriterion("total_num <=", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumIn(List<Integer> values) {
            addCriterion("total_num in", values, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumNotIn(List<Integer> values) {
            addCriterion("total_num not in", values, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumBetween(Integer value1, Integer value2) {
            addCriterion("total_num between", value1, value2, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumNotBetween(Integer value1, Integer value2) {
            addCriterion("total_num not between", value1, value2, "totalNum");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(Integer value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(Integer value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(Integer value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(Integer value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<Integer> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<Integer> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(Integer value1, Integer value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("pay_status is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(Integer value) {
            addCriterion("pay_status =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(Integer value) {
            addCriterion("pay_status <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(Integer value) {
            addCriterion("pay_status >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_status >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(Integer value) {
            addCriterion("pay_status <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(Integer value) {
            addCriterion("pay_status <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<Integer> values) {
            addCriterion("pay_status in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<Integer> values) {
            addCriterion("pay_status not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(Integer value1, Integer value2) {
            addCriterion("pay_status between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_status not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(Integer value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(Integer value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(Integer value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(Integer value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<Integer> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<Integer> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNameIsNull() {
            addCriterion("order_type_name is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNameIsNotNull() {
            addCriterion("order_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNameEqualTo(String value) {
            addCriterion("order_type_name =", value, "orderTypeName");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNameNotEqualTo(String value) {
            addCriterion("order_type_name <>", value, "orderTypeName");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNameGreaterThan(String value) {
            addCriterion("order_type_name >", value, "orderTypeName");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("order_type_name >=", value, "orderTypeName");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNameLessThan(String value) {
            addCriterion("order_type_name <", value, "orderTypeName");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNameLessThanOrEqualTo(String value) {
            addCriterion("order_type_name <=", value, "orderTypeName");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNameLike(String value) {
            addCriterion("order_type_name like", value, "orderTypeName");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNameNotLike(String value) {
            addCriterion("order_type_name not like", value, "orderTypeName");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNameIn(List<String> values) {
            addCriterion("order_type_name in", values, "orderTypeName");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNameNotIn(List<String> values) {
            addCriterion("order_type_name not in", values, "orderTypeName");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNameBetween(String value1, String value2) {
            addCriterion("order_type_name between", value1, value2, "orderTypeName");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNameNotBetween(String value1, String value2) {
            addCriterion("order_type_name not between", value1, value2, "orderTypeName");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(Integer value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(Integer value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(Integer value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(Integer value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<Integer> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<Integer> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(Integer value1, Integer value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNameIsNull() {
            addCriterion("order_status_name is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNameIsNotNull() {
            addCriterion("order_status_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNameEqualTo(String value) {
            addCriterion("order_status_name =", value, "orderStatusName");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNameNotEqualTo(String value) {
            addCriterion("order_status_name <>", value, "orderStatusName");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNameGreaterThan(String value) {
            addCriterion("order_status_name >", value, "orderStatusName");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNameGreaterThanOrEqualTo(String value) {
            addCriterion("order_status_name >=", value, "orderStatusName");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNameLessThan(String value) {
            addCriterion("order_status_name <", value, "orderStatusName");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNameLessThanOrEqualTo(String value) {
            addCriterion("order_status_name <=", value, "orderStatusName");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNameLike(String value) {
            addCriterion("order_status_name like", value, "orderStatusName");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNameNotLike(String value) {
            addCriterion("order_status_name not like", value, "orderStatusName");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNameIn(List<String> values) {
            addCriterion("order_status_name in", values, "orderStatusName");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNameNotIn(List<String> values) {
            addCriterion("order_status_name not in", values, "orderStatusName");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNameBetween(String value1, String value2) {
            addCriterion("order_status_name between", value1, value2, "orderStatusName");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNameNotBetween(String value1, String value2) {
            addCriterion("order_status_name not between", value1, value2, "orderStatusName");
            return (Criteria) this;
        }

        public Criteria andCancelTypeIsNull() {
            addCriterion("cancel_type is null");
            return (Criteria) this;
        }

        public Criteria andCancelTypeIsNotNull() {
            addCriterion("cancel_type is not null");
            return (Criteria) this;
        }

        public Criteria andCancelTypeEqualTo(Integer value) {
            addCriterion("cancel_type =", value, "cancelType");
            return (Criteria) this;
        }

        public Criteria andCancelTypeNotEqualTo(Integer value) {
            addCriterion("cancel_type <>", value, "cancelType");
            return (Criteria) this;
        }

        public Criteria andCancelTypeGreaterThan(Integer value) {
            addCriterion("cancel_type >", value, "cancelType");
            return (Criteria) this;
        }

        public Criteria andCancelTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("cancel_type >=", value, "cancelType");
            return (Criteria) this;
        }

        public Criteria andCancelTypeLessThan(Integer value) {
            addCriterion("cancel_type <", value, "cancelType");
            return (Criteria) this;
        }

        public Criteria andCancelTypeLessThanOrEqualTo(Integer value) {
            addCriterion("cancel_type <=", value, "cancelType");
            return (Criteria) this;
        }

        public Criteria andCancelTypeIn(List<Integer> values) {
            addCriterion("cancel_type in", values, "cancelType");
            return (Criteria) this;
        }

        public Criteria andCancelTypeNotIn(List<Integer> values) {
            addCriterion("cancel_type not in", values, "cancelType");
            return (Criteria) this;
        }

        public Criteria andCancelTypeBetween(Integer value1, Integer value2) {
            addCriterion("cancel_type between", value1, value2, "cancelType");
            return (Criteria) this;
        }

        public Criteria andCancelTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("cancel_type not between", value1, value2, "cancelType");
            return (Criteria) this;
        }

        public Criteria andCancelTypeNameIsNull() {
            addCriterion("cancel_type_name is null");
            return (Criteria) this;
        }

        public Criteria andCancelTypeNameIsNotNull() {
            addCriterion("cancel_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andCancelTypeNameEqualTo(String value) {
            addCriterion("cancel_type_name =", value, "cancelTypeName");
            return (Criteria) this;
        }

        public Criteria andCancelTypeNameNotEqualTo(String value) {
            addCriterion("cancel_type_name <>", value, "cancelTypeName");
            return (Criteria) this;
        }

        public Criteria andCancelTypeNameGreaterThan(String value) {
            addCriterion("cancel_type_name >", value, "cancelTypeName");
            return (Criteria) this;
        }

        public Criteria andCancelTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_type_name >=", value, "cancelTypeName");
            return (Criteria) this;
        }

        public Criteria andCancelTypeNameLessThan(String value) {
            addCriterion("cancel_type_name <", value, "cancelTypeName");
            return (Criteria) this;
        }

        public Criteria andCancelTypeNameLessThanOrEqualTo(String value) {
            addCriterion("cancel_type_name <=", value, "cancelTypeName");
            return (Criteria) this;
        }

        public Criteria andCancelTypeNameLike(String value) {
            addCriterion("cancel_type_name like", value, "cancelTypeName");
            return (Criteria) this;
        }

        public Criteria andCancelTypeNameNotLike(String value) {
            addCriterion("cancel_type_name not like", value, "cancelTypeName");
            return (Criteria) this;
        }

        public Criteria andCancelTypeNameIn(List<String> values) {
            addCriterion("cancel_type_name in", values, "cancelTypeName");
            return (Criteria) this;
        }

        public Criteria andCancelTypeNameNotIn(List<String> values) {
            addCriterion("cancel_type_name not in", values, "cancelTypeName");
            return (Criteria) this;
        }

        public Criteria andCancelTypeNameBetween(String value1, String value2) {
            addCriterion("cancel_type_name between", value1, value2, "cancelTypeName");
            return (Criteria) this;
        }

        public Criteria andCancelTypeNameNotBetween(String value1, String value2) {
            addCriterion("cancel_type_name not between", value1, value2, "cancelTypeName");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIsNull() {
            addCriterion("cancel_reason is null");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIsNotNull() {
            addCriterion("cancel_reason is not null");
            return (Criteria) this;
        }

        public Criteria andCancelReasonEqualTo(String value) {
            addCriterion("cancel_reason =", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotEqualTo(String value) {
            addCriterion("cancel_reason <>", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonGreaterThan(String value) {
            addCriterion("cancel_reason >", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_reason >=", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonLessThan(String value) {
            addCriterion("cancel_reason <", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonLessThanOrEqualTo(String value) {
            addCriterion("cancel_reason <=", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonLike(String value) {
            addCriterion("cancel_reason like", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotLike(String value) {
            addCriterion("cancel_reason not like", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIn(List<String> values) {
            addCriterion("cancel_reason in", values, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotIn(List<String> values) {
            addCriterion("cancel_reason not in", values, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonBetween(String value1, String value2) {
            addCriterion("cancel_reason between", value1, value2, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotBetween(String value1, String value2) {
            addCriterion("cancel_reason not between", value1, value2, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelTimeIsNull() {
            addCriterion("cancel_time is null");
            return (Criteria) this;
        }

        public Criteria andCancelTimeIsNotNull() {
            addCriterion("cancel_time is not null");
            return (Criteria) this;
        }

        public Criteria andCancelTimeEqualTo(Date value) {
            addCriterion("cancel_time =", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotEqualTo(Date value) {
            addCriterion("cancel_time <>", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeGreaterThan(Date value) {
            addCriterion("cancel_time >", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("cancel_time >=", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeLessThan(Date value) {
            addCriterion("cancel_time <", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeLessThanOrEqualTo(Date value) {
            addCriterion("cancel_time <=", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeIn(List<Date> values) {
            addCriterion("cancel_time in", values, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotIn(List<Date> values) {
            addCriterion("cancel_time not in", values, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeBetween(Date value1, Date value2) {
            addCriterion("cancel_time between", value1, value2, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotBetween(Date value1, Date value2) {
            addCriterion("cancel_time not between", value1, value2, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusIsNull() {
            addCriterion("order_return_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusIsNotNull() {
            addCriterion("order_return_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusEqualTo(Integer value) {
            addCriterion("order_return_status =", value, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusNotEqualTo(Integer value) {
            addCriterion("order_return_status <>", value, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusGreaterThan(Integer value) {
            addCriterion("order_return_status >", value, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_return_status >=", value, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusLessThan(Integer value) {
            addCriterion("order_return_status <", value, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusLessThanOrEqualTo(Integer value) {
            addCriterion("order_return_status <=", value, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusIn(List<Integer> values) {
            addCriterion("order_return_status in", values, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusNotIn(List<Integer> values) {
            addCriterion("order_return_status not in", values, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusBetween(Integer value1, Integer value2) {
            addCriterion("order_return_status between", value1, value2, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("order_return_status not between", value1, value2, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusNameIsNull() {
            addCriterion("order_return_status_name is null");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusNameIsNotNull() {
            addCriterion("order_return_status_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusNameEqualTo(String value) {
            addCriterion("order_return_status_name =", value, "orderReturnStatusName");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusNameNotEqualTo(String value) {
            addCriterion("order_return_status_name <>", value, "orderReturnStatusName");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusNameGreaterThan(String value) {
            addCriterion("order_return_status_name >", value, "orderReturnStatusName");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusNameGreaterThanOrEqualTo(String value) {
            addCriterion("order_return_status_name >=", value, "orderReturnStatusName");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusNameLessThan(String value) {
            addCriterion("order_return_status_name <", value, "orderReturnStatusName");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusNameLessThanOrEqualTo(String value) {
            addCriterion("order_return_status_name <=", value, "orderReturnStatusName");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusNameLike(String value) {
            addCriterion("order_return_status_name like", value, "orderReturnStatusName");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusNameNotLike(String value) {
            addCriterion("order_return_status_name not like", value, "orderReturnStatusName");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusNameIn(List<String> values) {
            addCriterion("order_return_status_name in", values, "orderReturnStatusName");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusNameNotIn(List<String> values) {
            addCriterion("order_return_status_name not in", values, "orderReturnStatusName");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusNameBetween(String value1, String value2) {
            addCriterion("order_return_status_name between", value1, value2, "orderReturnStatusName");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusNameNotBetween(String value1, String value2) {
            addCriterion("order_return_status_name not between", value1, value2, "orderReturnStatusName");
            return (Criteria) this;
        }

        public Criteria andRamakeIsNull() {
            addCriterion("ramake is null");
            return (Criteria) this;
        }

        public Criteria andRamakeIsNotNull() {
            addCriterion("ramake is not null");
            return (Criteria) this;
        }

        public Criteria andRamakeEqualTo(String value) {
            addCriterion("ramake =", value, "ramake");
            return (Criteria) this;
        }

        public Criteria andRamakeNotEqualTo(String value) {
            addCriterion("ramake <>", value, "ramake");
            return (Criteria) this;
        }

        public Criteria andRamakeGreaterThan(String value) {
            addCriterion("ramake >", value, "ramake");
            return (Criteria) this;
        }

        public Criteria andRamakeGreaterThanOrEqualTo(String value) {
            addCriterion("ramake >=", value, "ramake");
            return (Criteria) this;
        }

        public Criteria andRamakeLessThan(String value) {
            addCriterion("ramake <", value, "ramake");
            return (Criteria) this;
        }

        public Criteria andRamakeLessThanOrEqualTo(String value) {
            addCriterion("ramake <=", value, "ramake");
            return (Criteria) this;
        }

        public Criteria andRamakeLike(String value) {
            addCriterion("ramake like", value, "ramake");
            return (Criteria) this;
        }

        public Criteria andRamakeNotLike(String value) {
            addCriterion("ramake not like", value, "ramake");
            return (Criteria) this;
        }

        public Criteria andRamakeIn(List<String> values) {
            addCriterion("ramake in", values, "ramake");
            return (Criteria) this;
        }

        public Criteria andRamakeNotIn(List<String> values) {
            addCriterion("ramake not in", values, "ramake");
            return (Criteria) this;
        }

        public Criteria andRamakeBetween(String value1, String value2) {
            addCriterion("ramake between", value1, value2, "ramake");
            return (Criteria) this;
        }

        public Criteria andRamakeNotBetween(String value1, String value2) {
            addCriterion("ramake not between", value1, value2, "ramake");
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

        public Criteria andDeleteFlagIsNull() {
            addCriterion("delete_flag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("delete_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(Integer value) {
            addCriterion("delete_flag =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(Integer value) {
            addCriterion("delete_flag <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(Integer value) {
            addCriterion("delete_flag >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("delete_flag >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(Integer value) {
            addCriterion("delete_flag <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(Integer value) {
            addCriterion("delete_flag <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<Integer> values) {
            addCriterion("delete_flag in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<Integer> values) {
            addCriterion("delete_flag not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(Integer value1, Integer value2) {
            addCriterion("delete_flag between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("delete_flag not between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andFinshTimeIsNull() {
            addCriterion("finsh_time is null");
            return (Criteria) this;
        }

        public Criteria andFinshTimeIsNotNull() {
            addCriterion("finsh_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinshTimeEqualTo(Date value) {
            addCriterion("finsh_time =", value, "finshTime");
            return (Criteria) this;
        }

        public Criteria andFinshTimeNotEqualTo(Date value) {
            addCriterion("finsh_time <>", value, "finshTime");
            return (Criteria) this;
        }

        public Criteria andFinshTimeGreaterThan(Date value) {
            addCriterion("finsh_time >", value, "finshTime");
            return (Criteria) this;
        }

        public Criteria andFinshTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("finsh_time >=", value, "finshTime");
            return (Criteria) this;
        }

        public Criteria andFinshTimeLessThan(Date value) {
            addCriterion("finsh_time <", value, "finshTime");
            return (Criteria) this;
        }

        public Criteria andFinshTimeLessThanOrEqualTo(Date value) {
            addCriterion("finsh_time <=", value, "finshTime");
            return (Criteria) this;
        }

        public Criteria andFinshTimeIn(List<Date> values) {
            addCriterion("finsh_time in", values, "finshTime");
            return (Criteria) this;
        }

        public Criteria andFinshTimeNotIn(List<Date> values) {
            addCriterion("finsh_time not in", values, "finshTime");
            return (Criteria) this;
        }

        public Criteria andFinshTimeBetween(Date value1, Date value2) {
            addCriterion("finsh_time between", value1, value2, "finshTime");
            return (Criteria) this;
        }

        public Criteria andFinshTimeNotBetween(Date value1, Date value2) {
            addCriterion("finsh_time not between", value1, value2, "finshTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIsNull() {
            addCriterion("delivery_time is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIsNotNull() {
            addCriterion("delivery_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeEqualTo(Date value) {
            addCriterion("delivery_time =", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotEqualTo(Date value) {
            addCriterion("delivery_time <>", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThan(Date value) {
            addCriterion("delivery_time >", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("delivery_time >=", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThan(Date value) {
            addCriterion("delivery_time <", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThanOrEqualTo(Date value) {
            addCriterion("delivery_time <=", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIn(List<Date> values) {
            addCriterion("delivery_time in", values, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotIn(List<Date> values) {
            addCriterion("delivery_time not in", values, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeBetween(Date value1, Date value2) {
            addCriterion("delivery_time between", value1, value2, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotBetween(Date value1, Date value2) {
            addCriterion("delivery_time not between", value1, value2, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIsNull() {
            addCriterion("receive_time is null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIsNotNull() {
            addCriterion("receive_time is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeEqualTo(Date value) {
            addCriterion("receive_time =", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotEqualTo(Date value) {
            addCriterion("receive_time <>", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeGreaterThan(Date value) {
            addCriterion("receive_time >", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("receive_time >=", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeLessThan(Date value) {
            addCriterion("receive_time <", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeLessThanOrEqualTo(Date value) {
            addCriterion("receive_time <=", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIn(List<Date> values) {
            addCriterion("receive_time in", values, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotIn(List<Date> values) {
            addCriterion("receive_time not in", values, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeBetween(Date value1, Date value2) {
            addCriterion("receive_time between", value1, value2, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotBetween(Date value1, Date value2) {
            addCriterion("receive_time not between", value1, value2, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andOnCreditIsNull() {
            addCriterion("on_credit is null");
            return (Criteria) this;
        }

        public Criteria andOnCreditIsNotNull() {
            addCriterion("on_credit is not null");
            return (Criteria) this;
        }

        public Criteria andOnCreditEqualTo(Integer value) {
            addCriterion("on_credit =", value, "onCredit");
            return (Criteria) this;
        }

        public Criteria andOnCreditNotEqualTo(Integer value) {
            addCriterion("on_credit <>", value, "onCredit");
            return (Criteria) this;
        }

        public Criteria andOnCreditGreaterThan(Integer value) {
            addCriterion("on_credit >", value, "onCredit");
            return (Criteria) this;
        }

        public Criteria andOnCreditGreaterThanOrEqualTo(Integer value) {
            addCriterion("on_credit >=", value, "onCredit");
            return (Criteria) this;
        }

        public Criteria andOnCreditLessThan(Integer value) {
            addCriterion("on_credit <", value, "onCredit");
            return (Criteria) this;
        }

        public Criteria andOnCreditLessThanOrEqualTo(Integer value) {
            addCriterion("on_credit <=", value, "onCredit");
            return (Criteria) this;
        }

        public Criteria andOnCreditIn(List<Integer> values) {
            addCriterion("on_credit in", values, "onCredit");
            return (Criteria) this;
        }

        public Criteria andOnCreditNotIn(List<Integer> values) {
            addCriterion("on_credit not in", values, "onCredit");
            return (Criteria) this;
        }

        public Criteria andOnCreditBetween(Integer value1, Integer value2) {
            addCriterion("on_credit between", value1, value2, "onCredit");
            return (Criteria) this;
        }

        public Criteria andOnCreditNotBetween(Integer value1, Integer value2) {
            addCriterion("on_credit not between", value1, value2, "onCredit");
            return (Criteria) this;
        }

        public Criteria andChargeAmountIsNull() {
            addCriterion("charge_amount is null");
            return (Criteria) this;
        }

        public Criteria andChargeAmountIsNotNull() {
            addCriterion("charge_amount is not null");
            return (Criteria) this;
        }

        public Criteria andChargeAmountEqualTo(Double value) {
            addCriterion("charge_amount =", value, "chargeAmount");
            return (Criteria) this;
        }

        public Criteria andChargeAmountNotEqualTo(Double value) {
            addCriterion("charge_amount <>", value, "chargeAmount");
            return (Criteria) this;
        }

        public Criteria andChargeAmountGreaterThan(Double value) {
            addCriterion("charge_amount >", value, "chargeAmount");
            return (Criteria) this;
        }

        public Criteria andChargeAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("charge_amount >=", value, "chargeAmount");
            return (Criteria) this;
        }

        public Criteria andChargeAmountLessThan(Double value) {
            addCriterion("charge_amount <", value, "chargeAmount");
            return (Criteria) this;
        }

        public Criteria andChargeAmountLessThanOrEqualTo(Double value) {
            addCriterion("charge_amount <=", value, "chargeAmount");
            return (Criteria) this;
        }

        public Criteria andChargeAmountIn(List<Double> values) {
            addCriterion("charge_amount in", values, "chargeAmount");
            return (Criteria) this;
        }

        public Criteria andChargeAmountNotIn(List<Double> values) {
            addCriterion("charge_amount not in", values, "chargeAmount");
            return (Criteria) this;
        }

        public Criteria andChargeAmountBetween(Double value1, Double value2) {
            addCriterion("charge_amount between", value1, value2, "chargeAmount");
            return (Criteria) this;
        }

        public Criteria andChargeAmountNotBetween(Double value1, Double value2) {
            addCriterion("charge_amount not between", value1, value2, "chargeAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountIsNull() {
            addCriterion("refund_amount is null");
            return (Criteria) this;
        }

        public Criteria andRefundAmountIsNotNull() {
            addCriterion("refund_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRefundAmountEqualTo(Double value) {
            addCriterion("refund_amount =", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotEqualTo(Double value) {
            addCriterion("refund_amount <>", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountGreaterThan(Double value) {
            addCriterion("refund_amount >", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("refund_amount >=", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountLessThan(Double value) {
            addCriterion("refund_amount <", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountLessThanOrEqualTo(Double value) {
            addCriterion("refund_amount <=", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountIn(List<Double> values) {
            addCriterion("refund_amount in", values, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotIn(List<Double> values) {
            addCriterion("refund_amount not in", values, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountBetween(Double value1, Double value2) {
            addCriterion("refund_amount between", value1, value2, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotBetween(Double value1, Double value2) {
            addCriterion("refund_amount not between", value1, value2, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andSaleTypeIsNull() {
            addCriterion("sale_type is null");
            return (Criteria) this;
        }

        public Criteria andSaleTypeIsNotNull() {
            addCriterion("sale_type is not null");
            return (Criteria) this;
        }

        public Criteria andSaleTypeEqualTo(Integer value) {
            addCriterion("sale_type =", value, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeNotEqualTo(Integer value) {
            addCriterion("sale_type <>", value, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeGreaterThan(Integer value) {
            addCriterion("sale_type >", value, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sale_type >=", value, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeLessThan(Integer value) {
            addCriterion("sale_type <", value, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeLessThanOrEqualTo(Integer value) {
            addCriterion("sale_type <=", value, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeIn(List<Integer> values) {
            addCriterion("sale_type in", values, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeNotIn(List<Integer> values) {
            addCriterion("sale_type not in", values, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeBetween(Integer value1, Integer value2) {
            addCriterion("sale_type between", value1, value2, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("sale_type not between", value1, value2, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleNameIsNull() {
            addCriterion("sale_name is null");
            return (Criteria) this;
        }

        public Criteria andSaleNameIsNotNull() {
            addCriterion("sale_name is not null");
            return (Criteria) this;
        }

        public Criteria andSaleNameEqualTo(String value) {
            addCriterion("sale_name =", value, "saleName");
            return (Criteria) this;
        }

        public Criteria andSaleNameNotEqualTo(String value) {
            addCriterion("sale_name <>", value, "saleName");
            return (Criteria) this;
        }

        public Criteria andSaleNameGreaterThan(String value) {
            addCriterion("sale_name >", value, "saleName");
            return (Criteria) this;
        }

        public Criteria andSaleNameGreaterThanOrEqualTo(String value) {
            addCriterion("sale_name >=", value, "saleName");
            return (Criteria) this;
        }

        public Criteria andSaleNameLessThan(String value) {
            addCriterion("sale_name <", value, "saleName");
            return (Criteria) this;
        }

        public Criteria andSaleNameLessThanOrEqualTo(String value) {
            addCriterion("sale_name <=", value, "saleName");
            return (Criteria) this;
        }

        public Criteria andSaleNameLike(String value) {
            addCriterion("sale_name like", value, "saleName");
            return (Criteria) this;
        }

        public Criteria andSaleNameNotLike(String value) {
            addCriterion("sale_name not like", value, "saleName");
            return (Criteria) this;
        }

        public Criteria andSaleNameIn(List<String> values) {
            addCriterion("sale_name in", values, "saleName");
            return (Criteria) this;
        }

        public Criteria andSaleNameNotIn(List<String> values) {
            addCriterion("sale_name not in", values, "saleName");
            return (Criteria) this;
        }

        public Criteria andSaleNameBetween(String value1, String value2) {
            addCriterion("sale_name between", value1, value2, "saleName");
            return (Criteria) this;
        }

        public Criteria andSaleNameNotBetween(String value1, String value2) {
            addCriterion("sale_name not between", value1, value2, "saleName");
            return (Criteria) this;
        }

        public Criteria andInAmountIsNull() {
            addCriterion("in_amount is null");
            return (Criteria) this;
        }

        public Criteria andInAmountIsNotNull() {
            addCriterion("in_amount is not null");
            return (Criteria) this;
        }

        public Criteria andInAmountEqualTo(Integer value) {
            addCriterion("in_amount =", value, "inAmount");
            return (Criteria) this;
        }

        public Criteria andInAmountNotEqualTo(Integer value) {
            addCriterion("in_amount <>", value, "inAmount");
            return (Criteria) this;
        }

        public Criteria andInAmountGreaterThan(Integer value) {
            addCriterion("in_amount >", value, "inAmount");
            return (Criteria) this;
        }

        public Criteria andInAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("in_amount >=", value, "inAmount");
            return (Criteria) this;
        }

        public Criteria andInAmountLessThan(Integer value) {
            addCriterion("in_amount <", value, "inAmount");
            return (Criteria) this;
        }

        public Criteria andInAmountLessThanOrEqualTo(Integer value) {
            addCriterion("in_amount <=", value, "inAmount");
            return (Criteria) this;
        }

        public Criteria andInAmountIn(List<Integer> values) {
            addCriterion("in_amount in", values, "inAmount");
            return (Criteria) this;
        }

        public Criteria andInAmountNotIn(List<Integer> values) {
            addCriterion("in_amount not in", values, "inAmount");
            return (Criteria) this;
        }

        public Criteria andInAmountBetween(Integer value1, Integer value2) {
            addCriterion("in_amount between", value1, value2, "inAmount");
            return (Criteria) this;
        }

        public Criteria andInAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("in_amount not between", value1, value2, "inAmount");
            return (Criteria) this;
        }

        public Criteria andRemoveSmallAmountIsNull() {
            addCriterion("remove_small_amount is null");
            return (Criteria) this;
        }

        public Criteria andRemoveSmallAmountIsNotNull() {
            addCriterion("remove_small_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveSmallAmountEqualTo(Integer value) {
            addCriterion("remove_small_amount =", value, "removeSmallAmount");
            return (Criteria) this;
        }

        public Criteria andRemoveSmallAmountNotEqualTo(Integer value) {
            addCriterion("remove_small_amount <>", value, "removeSmallAmount");
            return (Criteria) this;
        }

        public Criteria andRemoveSmallAmountGreaterThan(Integer value) {
            addCriterion("remove_small_amount >", value, "removeSmallAmount");
            return (Criteria) this;
        }

        public Criteria andRemoveSmallAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("remove_small_amount >=", value, "removeSmallAmount");
            return (Criteria) this;
        }

        public Criteria andRemoveSmallAmountLessThan(Integer value) {
            addCriterion("remove_small_amount <", value, "removeSmallAmount");
            return (Criteria) this;
        }

        public Criteria andRemoveSmallAmountLessThanOrEqualTo(Integer value) {
            addCriterion("remove_small_amount <=", value, "removeSmallAmount");
            return (Criteria) this;
        }

        public Criteria andRemoveSmallAmountIn(List<Integer> values) {
            addCriterion("remove_small_amount in", values, "removeSmallAmount");
            return (Criteria) this;
        }

        public Criteria andRemoveSmallAmountNotIn(List<Integer> values) {
            addCriterion("remove_small_amount not in", values, "removeSmallAmount");
            return (Criteria) this;
        }

        public Criteria andRemoveSmallAmountBetween(Integer value1, Integer value2) {
            addCriterion("remove_small_amount between", value1, value2, "removeSmallAmount");
            return (Criteria) this;
        }

        public Criteria andRemoveSmallAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("remove_small_amount not between", value1, value2, "removeSmallAmount");
            return (Criteria) this;
        }

        public Criteria andServiceFeeIsNull() {
            addCriterion("service_fee is null");
            return (Criteria) this;
        }

        public Criteria andServiceFeeIsNotNull() {
            addCriterion("service_fee is not null");
            return (Criteria) this;
        }

        public Criteria andServiceFeeEqualTo(Double value) {
            addCriterion("service_fee =", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotEqualTo(Double value) {
            addCriterion("service_fee <>", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeGreaterThan(Double value) {
            addCriterion("service_fee >", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeGreaterThanOrEqualTo(Double value) {
            addCriterion("service_fee >=", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeLessThan(Double value) {
            addCriterion("service_fee <", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeLessThanOrEqualTo(Double value) {
            addCriterion("service_fee <=", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeIn(List<Double> values) {
            addCriterion("service_fee in", values, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotIn(List<Double> values) {
            addCriterion("service_fee not in", values, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeBetween(Double value1, Double value2) {
            addCriterion("service_fee between", value1, value2, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotBetween(Double value1, Double value2) {
            addCriterion("service_fee not between", value1, value2, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andRewardAmountIsNull() {
            addCriterion("reward_amount is null");
            return (Criteria) this;
        }

        public Criteria andRewardAmountIsNotNull() {
            addCriterion("reward_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRewardAmountEqualTo(Double value) {
            addCriterion("reward_amount =", value, "rewardAmount");
            return (Criteria) this;
        }

        public Criteria andRewardAmountNotEqualTo(Double value) {
            addCriterion("reward_amount <>", value, "rewardAmount");
            return (Criteria) this;
        }

        public Criteria andRewardAmountGreaterThan(Double value) {
            addCriterion("reward_amount >", value, "rewardAmount");
            return (Criteria) this;
        }

        public Criteria andRewardAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("reward_amount >=", value, "rewardAmount");
            return (Criteria) this;
        }

        public Criteria andRewardAmountLessThan(Double value) {
            addCriterion("reward_amount <", value, "rewardAmount");
            return (Criteria) this;
        }

        public Criteria andRewardAmountLessThanOrEqualTo(Double value) {
            addCriterion("reward_amount <=", value, "rewardAmount");
            return (Criteria) this;
        }

        public Criteria andRewardAmountIn(List<Double> values) {
            addCriterion("reward_amount in", values, "rewardAmount");
            return (Criteria) this;
        }

        public Criteria andRewardAmountNotIn(List<Double> values) {
            addCriterion("reward_amount not in", values, "rewardAmount");
            return (Criteria) this;
        }

        public Criteria andRewardAmountBetween(Double value1, Double value2) {
            addCriterion("reward_amount between", value1, value2, "rewardAmount");
            return (Criteria) this;
        }

        public Criteria andRewardAmountNotBetween(Double value1, Double value2) {
            addCriterion("reward_amount not between", value1, value2, "rewardAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionApmountIsNull() {
            addCriterion("promotion_apmount is null");
            return (Criteria) this;
        }

        public Criteria andPromotionApmountIsNotNull() {
            addCriterion("promotion_apmount is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionApmountEqualTo(Integer value) {
            addCriterion("promotion_apmount =", value, "promotionApmount");
            return (Criteria) this;
        }

        public Criteria andPromotionApmountNotEqualTo(Integer value) {
            addCriterion("promotion_apmount <>", value, "promotionApmount");
            return (Criteria) this;
        }

        public Criteria andPromotionApmountGreaterThan(Integer value) {
            addCriterion("promotion_apmount >", value, "promotionApmount");
            return (Criteria) this;
        }

        public Criteria andPromotionApmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("promotion_apmount >=", value, "promotionApmount");
            return (Criteria) this;
        }

        public Criteria andPromotionApmountLessThan(Integer value) {
            addCriterion("promotion_apmount <", value, "promotionApmount");
            return (Criteria) this;
        }

        public Criteria andPromotionApmountLessThanOrEqualTo(Integer value) {
            addCriterion("promotion_apmount <=", value, "promotionApmount");
            return (Criteria) this;
        }

        public Criteria andPromotionApmountIn(List<Integer> values) {
            addCriterion("promotion_apmount in", values, "promotionApmount");
            return (Criteria) this;
        }

        public Criteria andPromotionApmountNotIn(List<Integer> values) {
            addCriterion("promotion_apmount not in", values, "promotionApmount");
            return (Criteria) this;
        }

        public Criteria andPromotionApmountBetween(Integer value1, Integer value2) {
            addCriterion("promotion_apmount between", value1, value2, "promotionApmount");
            return (Criteria) this;
        }

        public Criteria andPromotionApmountNotBetween(Integer value1, Integer value2) {
            addCriterion("promotion_apmount not between", value1, value2, "promotionApmount");
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