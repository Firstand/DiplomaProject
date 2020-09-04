package com.hlbrc.mapper;

import com.hlbrc.entity.Goodsproperty;
import com.hlbrc.entity.GoodspropertyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IGoodspropertyMapper {
    long countByExample(GoodspropertyExample example);

    int deleteByExample(GoodspropertyExample example);

    int deleteByPrimaryKey(Integer goodsPropertyId);

    int insert(Goodsproperty record);

    int insertSelective(Goodsproperty record);

    List<Goodsproperty> selectByExample(GoodspropertyExample example);

    Goodsproperty selectByPrimaryKey(Integer goodsPropertyId);

    int updateByExampleSelective(@Param("record") Goodsproperty record, @Param("example") GoodspropertyExample example);

    int updateByExample(@Param("record") Goodsproperty record, @Param("example") GoodspropertyExample example);

    int updateByPrimaryKeySelective(Goodsproperty record);

    int updateByPrimaryKey(Goodsproperty record);
}