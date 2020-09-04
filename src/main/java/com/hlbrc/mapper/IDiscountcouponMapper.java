package com.hlbrc.mapper;

import com.hlbrc.entity.Discountcoupon;
import com.hlbrc.entity.DiscountcouponExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IDiscountcouponMapper {
    long countByExample(DiscountcouponExample example);

    int deleteByExample(DiscountcouponExample example);

    int deleteByPrimaryKey(Integer discountCouponId);

    int insert(Discountcoupon record);

    int insertSelective(Discountcoupon record);

    List<Discountcoupon> selectByExample(DiscountcouponExample example);

    Discountcoupon selectByPrimaryKey(Integer discountCouponId);

    int updateByExampleSelective(@Param("record") Discountcoupon record, @Param("example") DiscountcouponExample example);

    int updateByExample(@Param("record") Discountcoupon record, @Param("example") DiscountcouponExample example);

    int updateByPrimaryKeySelective(Discountcoupon record);

    int updateByPrimaryKey(Discountcoupon record);
}