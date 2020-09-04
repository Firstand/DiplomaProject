package com.hlbrc.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductExample() {
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

        public Criteria andBrandIdIsNull() {
            addCriterion("brand_id is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNotNull() {
            addCriterion("brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdEqualTo(Integer value) {
            addCriterion("brand_id =", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotEqualTo(Integer value) {
            addCriterion("brand_id <>", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThan(Integer value) {
            addCriterion("brand_id >", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("brand_id >=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThan(Integer value) {
            addCriterion("brand_id <", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThanOrEqualTo(Integer value) {
            addCriterion("brand_id <=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIn(List<Integer> values) {
            addCriterion("brand_id in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotIn(List<Integer> values) {
            addCriterion("brand_id not in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdBetween(Integer value1, Integer value2) {
            addCriterion("brand_id between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotBetween(Integer value1, Integer value2) {
            addCriterion("brand_id not between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdIsNull() {
            addCriterion("goods_class_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdIsNotNull() {
            addCriterion("goods_class_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdEqualTo(Integer value) {
            addCriterion("goods_class_id =", value, "goodsClassId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdNotEqualTo(Integer value) {
            addCriterion("goods_class_id <>", value, "goodsClassId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdGreaterThan(Integer value) {
            addCriterion("goods_class_id >", value, "goodsClassId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_class_id >=", value, "goodsClassId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdLessThan(Integer value) {
            addCriterion("goods_class_id <", value, "goodsClassId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdLessThanOrEqualTo(Integer value) {
            addCriterion("goods_class_id <=", value, "goodsClassId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdIn(List<Integer> values) {
            addCriterion("goods_class_id in", values, "goodsClassId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdNotIn(List<Integer> values) {
            addCriterion("goods_class_id not in", values, "goodsClassId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdBetween(Integer value1, Integer value2) {
            addCriterion("goods_class_id between", value1, value2, "goodsClassId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_class_id not between", value1, value2, "goodsClassId");
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

        public Criteria andGoodmodelIsNull() {
            addCriterion("goodmodel is null");
            return (Criteria) this;
        }

        public Criteria andGoodmodelIsNotNull() {
            addCriterion("goodmodel is not null");
            return (Criteria) this;
        }

        public Criteria andGoodmodelEqualTo(String value) {
            addCriterion("goodmodel =", value, "goodmodel");
            return (Criteria) this;
        }

        public Criteria andGoodmodelNotEqualTo(String value) {
            addCriterion("goodmodel <>", value, "goodmodel");
            return (Criteria) this;
        }

        public Criteria andGoodmodelGreaterThan(String value) {
            addCriterion("goodmodel >", value, "goodmodel");
            return (Criteria) this;
        }

        public Criteria andGoodmodelGreaterThanOrEqualTo(String value) {
            addCriterion("goodmodel >=", value, "goodmodel");
            return (Criteria) this;
        }

        public Criteria andGoodmodelLessThan(String value) {
            addCriterion("goodmodel <", value, "goodmodel");
            return (Criteria) this;
        }

        public Criteria andGoodmodelLessThanOrEqualTo(String value) {
            addCriterion("goodmodel <=", value, "goodmodel");
            return (Criteria) this;
        }

        public Criteria andGoodmodelLike(String value) {
            addCriterion("goodmodel like", value, "goodmodel");
            return (Criteria) this;
        }

        public Criteria andGoodmodelNotLike(String value) {
            addCriterion("goodmodel not like", value, "goodmodel");
            return (Criteria) this;
        }

        public Criteria andGoodmodelIn(List<String> values) {
            addCriterion("goodmodel in", values, "goodmodel");
            return (Criteria) this;
        }

        public Criteria andGoodmodelNotIn(List<String> values) {
            addCriterion("goodmodel not in", values, "goodmodel");
            return (Criteria) this;
        }

        public Criteria andGoodmodelBetween(String value1, String value2) {
            addCriterion("goodmodel between", value1, value2, "goodmodel");
            return (Criteria) this;
        }

        public Criteria andGoodmodelNotBetween(String value1, String value2) {
            addCriterion("goodmodel not between", value1, value2, "goodmodel");
            return (Criteria) this;
        }

        public Criteria andSalepointIsNull() {
            addCriterion("salepoint is null");
            return (Criteria) this;
        }

        public Criteria andSalepointIsNotNull() {
            addCriterion("salepoint is not null");
            return (Criteria) this;
        }

        public Criteria andSalepointEqualTo(String value) {
            addCriterion("salepoint =", value, "salepoint");
            return (Criteria) this;
        }

        public Criteria andSalepointNotEqualTo(String value) {
            addCriterion("salepoint <>", value, "salepoint");
            return (Criteria) this;
        }

        public Criteria andSalepointGreaterThan(String value) {
            addCriterion("salepoint >", value, "salepoint");
            return (Criteria) this;
        }

        public Criteria andSalepointGreaterThanOrEqualTo(String value) {
            addCriterion("salepoint >=", value, "salepoint");
            return (Criteria) this;
        }

        public Criteria andSalepointLessThan(String value) {
            addCriterion("salepoint <", value, "salepoint");
            return (Criteria) this;
        }

        public Criteria andSalepointLessThanOrEqualTo(String value) {
            addCriterion("salepoint <=", value, "salepoint");
            return (Criteria) this;
        }

        public Criteria andSalepointLike(String value) {
            addCriterion("salepoint like", value, "salepoint");
            return (Criteria) this;
        }

        public Criteria andSalepointNotLike(String value) {
            addCriterion("salepoint not like", value, "salepoint");
            return (Criteria) this;
        }

        public Criteria andSalepointIn(List<String> values) {
            addCriterion("salepoint in", values, "salepoint");
            return (Criteria) this;
        }

        public Criteria andSalepointNotIn(List<String> values) {
            addCriterion("salepoint not in", values, "salepoint");
            return (Criteria) this;
        }

        public Criteria andSalepointBetween(String value1, String value2) {
            addCriterion("salepoint between", value1, value2, "salepoint");
            return (Criteria) this;
        }

        public Criteria andSalepointNotBetween(String value1, String value2) {
            addCriterion("salepoint not between", value1, value2, "salepoint");
            return (Criteria) this;
        }

        public Criteria andReductionstrIsNull() {
            addCriterion("reductionstr is null");
            return (Criteria) this;
        }

        public Criteria andReductionstrIsNotNull() {
            addCriterion("reductionstr is not null");
            return (Criteria) this;
        }

        public Criteria andReductionstrEqualTo(String value) {
            addCriterion("reductionstr =", value, "reductionstr");
            return (Criteria) this;
        }

        public Criteria andReductionstrNotEqualTo(String value) {
            addCriterion("reductionstr <>", value, "reductionstr");
            return (Criteria) this;
        }

        public Criteria andReductionstrGreaterThan(String value) {
            addCriterion("reductionstr >", value, "reductionstr");
            return (Criteria) this;
        }

        public Criteria andReductionstrGreaterThanOrEqualTo(String value) {
            addCriterion("reductionstr >=", value, "reductionstr");
            return (Criteria) this;
        }

        public Criteria andReductionstrLessThan(String value) {
            addCriterion("reductionstr <", value, "reductionstr");
            return (Criteria) this;
        }

        public Criteria andReductionstrLessThanOrEqualTo(String value) {
            addCriterion("reductionstr <=", value, "reductionstr");
            return (Criteria) this;
        }

        public Criteria andReductionstrLike(String value) {
            addCriterion("reductionstr like", value, "reductionstr");
            return (Criteria) this;
        }

        public Criteria andReductionstrNotLike(String value) {
            addCriterion("reductionstr not like", value, "reductionstr");
            return (Criteria) this;
        }

        public Criteria andReductionstrIn(List<String> values) {
            addCriterion("reductionstr in", values, "reductionstr");
            return (Criteria) this;
        }

        public Criteria andReductionstrNotIn(List<String> values) {
            addCriterion("reductionstr not in", values, "reductionstr");
            return (Criteria) this;
        }

        public Criteria andReductionstrBetween(String value1, String value2) {
            addCriterion("reductionstr between", value1, value2, "reductionstr");
            return (Criteria) this;
        }

        public Criteria andReductionstrNotBetween(String value1, String value2) {
            addCriterion("reductionstr not between", value1, value2, "reductionstr");
            return (Criteria) this;
        }

        public Criteria andUnittemplatedesIsNull() {
            addCriterion("unittemplatedes is null");
            return (Criteria) this;
        }

        public Criteria andUnittemplatedesIsNotNull() {
            addCriterion("unittemplatedes is not null");
            return (Criteria) this;
        }

        public Criteria andUnittemplatedesEqualTo(String value) {
            addCriterion("unittemplatedes =", value, "unittemplatedes");
            return (Criteria) this;
        }

        public Criteria andUnittemplatedesNotEqualTo(String value) {
            addCriterion("unittemplatedes <>", value, "unittemplatedes");
            return (Criteria) this;
        }

        public Criteria andUnittemplatedesGreaterThan(String value) {
            addCriterion("unittemplatedes >", value, "unittemplatedes");
            return (Criteria) this;
        }

        public Criteria andUnittemplatedesGreaterThanOrEqualTo(String value) {
            addCriterion("unittemplatedes >=", value, "unittemplatedes");
            return (Criteria) this;
        }

        public Criteria andUnittemplatedesLessThan(String value) {
            addCriterion("unittemplatedes <", value, "unittemplatedes");
            return (Criteria) this;
        }

        public Criteria andUnittemplatedesLessThanOrEqualTo(String value) {
            addCriterion("unittemplatedes <=", value, "unittemplatedes");
            return (Criteria) this;
        }

        public Criteria andUnittemplatedesLike(String value) {
            addCriterion("unittemplatedes like", value, "unittemplatedes");
            return (Criteria) this;
        }

        public Criteria andUnittemplatedesNotLike(String value) {
            addCriterion("unittemplatedes not like", value, "unittemplatedes");
            return (Criteria) this;
        }

        public Criteria andUnittemplatedesIn(List<String> values) {
            addCriterion("unittemplatedes in", values, "unittemplatedes");
            return (Criteria) this;
        }

        public Criteria andUnittemplatedesNotIn(List<String> values) {
            addCriterion("unittemplatedes not in", values, "unittemplatedes");
            return (Criteria) this;
        }

        public Criteria andUnittemplatedesBetween(String value1, String value2) {
            addCriterion("unittemplatedes between", value1, value2, "unittemplatedes");
            return (Criteria) this;
        }

        public Criteria andUnittemplatedesNotBetween(String value1, String value2) {
            addCriterion("unittemplatedes not between", value1, value2, "unittemplatedes");
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

        public Criteria andMinBuyIsNull() {
            addCriterion("min_buy is null");
            return (Criteria) this;
        }

        public Criteria andMinBuyIsNotNull() {
            addCriterion("min_buy is not null");
            return (Criteria) this;
        }

        public Criteria andMinBuyEqualTo(Integer value) {
            addCriterion("min_buy =", value, "minBuy");
            return (Criteria) this;
        }

        public Criteria andMinBuyNotEqualTo(Integer value) {
            addCriterion("min_buy <>", value, "minBuy");
            return (Criteria) this;
        }

        public Criteria andMinBuyGreaterThan(Integer value) {
            addCriterion("min_buy >", value, "minBuy");
            return (Criteria) this;
        }

        public Criteria andMinBuyGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_buy >=", value, "minBuy");
            return (Criteria) this;
        }

        public Criteria andMinBuyLessThan(Integer value) {
            addCriterion("min_buy <", value, "minBuy");
            return (Criteria) this;
        }

        public Criteria andMinBuyLessThanOrEqualTo(Integer value) {
            addCriterion("min_buy <=", value, "minBuy");
            return (Criteria) this;
        }

        public Criteria andMinBuyIn(List<Integer> values) {
            addCriterion("min_buy in", values, "minBuy");
            return (Criteria) this;
        }

        public Criteria andMinBuyNotIn(List<Integer> values) {
            addCriterion("min_buy not in", values, "minBuy");
            return (Criteria) this;
        }

        public Criteria andMinBuyBetween(Integer value1, Integer value2) {
            addCriterion("min_buy between", value1, value2, "minBuy");
            return (Criteria) this;
        }

        public Criteria andMinBuyNotBetween(Integer value1, Integer value2) {
            addCriterion("min_buy not between", value1, value2, "minBuy");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Double value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Double value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Double value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Double value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Double value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Double> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Double> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Double value1, Double value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Double value1, Double value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(Double value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(Double value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(Double value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(Double value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(Double value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(Double value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<Double> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<Double> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(Double value1, Double value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(Double value1, Double value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andIntendedPopulationIsNull() {
            addCriterion("intended_population is null");
            return (Criteria) this;
        }

        public Criteria andIntendedPopulationIsNotNull() {
            addCriterion("intended_population is not null");
            return (Criteria) this;
        }

        public Criteria andIntendedPopulationEqualTo(Integer value) {
            addCriterion("intended_population =", value, "intendedPopulation");
            return (Criteria) this;
        }

        public Criteria andIntendedPopulationNotEqualTo(Integer value) {
            addCriterion("intended_population <>", value, "intendedPopulation");
            return (Criteria) this;
        }

        public Criteria andIntendedPopulationGreaterThan(Integer value) {
            addCriterion("intended_population >", value, "intendedPopulation");
            return (Criteria) this;
        }

        public Criteria andIntendedPopulationGreaterThanOrEqualTo(Integer value) {
            addCriterion("intended_population >=", value, "intendedPopulation");
            return (Criteria) this;
        }

        public Criteria andIntendedPopulationLessThan(Integer value) {
            addCriterion("intended_population <", value, "intendedPopulation");
            return (Criteria) this;
        }

        public Criteria andIntendedPopulationLessThanOrEqualTo(Integer value) {
            addCriterion("intended_population <=", value, "intendedPopulation");
            return (Criteria) this;
        }

        public Criteria andIntendedPopulationIn(List<Integer> values) {
            addCriterion("intended_population in", values, "intendedPopulation");
            return (Criteria) this;
        }

        public Criteria andIntendedPopulationNotIn(List<Integer> values) {
            addCriterion("intended_population not in", values, "intendedPopulation");
            return (Criteria) this;
        }

        public Criteria andIntendedPopulationBetween(Integer value1, Integer value2) {
            addCriterion("intended_population between", value1, value2, "intendedPopulation");
            return (Criteria) this;
        }

        public Criteria andIntendedPopulationNotBetween(Integer value1, Integer value2) {
            addCriterion("intended_population not between", value1, value2, "intendedPopulation");
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