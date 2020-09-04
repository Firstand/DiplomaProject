package com.hlbrc.mapper;

import com.hlbrc.entity.Goodsdetail;
import com.hlbrc.entity.GoodsdetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IGoodsdetailMapper {
    long countByExample(GoodsdetailExample example);

    int deleteByExample(GoodsdetailExample example);

    int deleteByPrimaryKey(Integer goodsDetailId);

    int insert(Goodsdetail record);

    int insertSelective(Goodsdetail record);

    List<Goodsdetail> selectByExample(GoodsdetailExample example);

    Goodsdetail selectByPrimaryKey(Integer goodsDetailId);

    int updateByExampleSelective(@Param("record") Goodsdetail record, @Param("example") GoodsdetailExample example);

    int updateByExample(@Param("record") Goodsdetail record, @Param("example") GoodsdetailExample example);

    int updateByPrimaryKeySelective(Goodsdetail record);

    int updateByPrimaryKey(Goodsdetail record);
}