package com.hlbrc.mapper;

import com.hlbrc.entity.Goodsphoto;
import com.hlbrc.entity.GoodsphotoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IGoodsphotoMapper {
    long countByExample(GoodsphotoExample example);

    int deleteByExample(GoodsphotoExample example);

    int deleteByPrimaryKey(Integer goodsPhotoId);

    int insert(Goodsphoto record);

    int insertSelective(Goodsphoto record);

    List<Goodsphoto> selectByExample(GoodsphotoExample example);

    Goodsphoto selectByPrimaryKey(Integer goodsPhotoId);

    int updateByExampleSelective(@Param("record") Goodsphoto record, @Param("example") GoodsphotoExample example);

    int updateByExample(@Param("record") Goodsphoto record, @Param("example") GoodsphotoExample example);

    int updateByPrimaryKeySelective(Goodsphoto record);

    int updateByPrimaryKey(Goodsphoto record);
}