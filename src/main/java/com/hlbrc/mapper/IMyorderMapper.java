package com.hlbrc.mapper;

import com.hlbrc.entity.Myorder;
import com.hlbrc.entity.MyorderExample;
import com.hlbrc.entity.MyorderKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IMyorderMapper {
    long countByExample(MyorderExample example);

    int deleteByExample(MyorderExample example);

    int deleteByPrimaryKey(MyorderKey key);

    int insert(Myorder record);

    int insertSelective(Myorder record);

    List<Myorder> selectByExample(MyorderExample example);

    Myorder selectByPrimaryKey(MyorderKey key);

    int updateByExampleSelective(@Param("record") Myorder record, @Param("example") MyorderExample example);

    int updateByExample(@Param("record") Myorder record, @Param("example") MyorderExample example);

    int updateByPrimaryKeySelective(Myorder record);

    int updateByPrimaryKey(Myorder record);
}