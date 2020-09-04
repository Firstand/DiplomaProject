package com.hlbrc.mapper;

import com.hlbrc.entity.Goodspackaging;
import com.hlbrc.entity.GoodspackagingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IGoodspackagingMapper {
    long countByExample(GoodspackagingExample example);

    int deleteByExample(GoodspackagingExample example);

    int deleteByPrimaryKey(Integer goodsPackagingId);

    int insert(Goodspackaging record);

    int insertSelective(Goodspackaging record);

    List<Goodspackaging> selectByExample(GoodspackagingExample example);

    Goodspackaging selectByPrimaryKey(Integer goodsPackagingId);

    int updateByExampleSelective(@Param("record") Goodspackaging record, @Param("example") GoodspackagingExample example);

    int updateByExample(@Param("record") Goodspackaging record, @Param("example") GoodspackagingExample example);

    int updateByPrimaryKeySelective(Goodspackaging record);

    int updateByPrimaryKey(Goodspackaging record);
}