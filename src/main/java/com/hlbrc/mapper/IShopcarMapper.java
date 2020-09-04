package com.hlbrc.mapper;

import com.hlbrc.entity.Shopcar;
import com.hlbrc.entity.ShopcarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IShopcarMapper {
    long countByExample(ShopcarExample example);

    int deleteByExample(ShopcarExample example);

    int deleteByPrimaryKey(Integer shopCarId);

    int insert(Shopcar record);

    int insertSelective(Shopcar record);

    List<Shopcar> selectByExample(ShopcarExample example);

    Shopcar selectByPrimaryKey(Integer shopCarId);

    int updateByExampleSelective(@Param("record") Shopcar record, @Param("example") ShopcarExample example);

    int updateByExample(@Param("record") Shopcar record, @Param("example") ShopcarExample example);

    int updateByPrimaryKeySelective(Shopcar record);

    int updateByPrimaryKey(Shopcar record);
}