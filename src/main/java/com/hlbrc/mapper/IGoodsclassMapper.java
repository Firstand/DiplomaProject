package com.hlbrc.mapper;

import com.hlbrc.entity.Goodsclass;
import com.hlbrc.entity.GoodsclassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IGoodsclassMapper {
    long countByExample(GoodsclassExample example);

    int deleteByExample(GoodsclassExample example);

    int deleteByPrimaryKey(Integer goodsClassId);

    int insert(Goodsclass record);

    int insertSelective(Goodsclass record);

    List<Goodsclass> selectByExample(GoodsclassExample example);

    Goodsclass selectByPrimaryKey(Integer goodsClassId);

    int updateByExampleSelective(@Param("record") Goodsclass record, @Param("example") GoodsclassExample example);

    int updateByExample(@Param("record") Goodsclass record, @Param("example") GoodsclassExample example);

    int updateByPrimaryKeySelective(Goodsclass record);

    int updateByPrimaryKey(Goodsclass record);
}