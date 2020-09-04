package com.hlbrc.mapper;

import com.hlbrc.entity.Usercollect;
import com.hlbrc.entity.UsercollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IUsercollectMapper {
    long countByExample(UsercollectExample example);

    int deleteByExample(UsercollectExample example);

    int deleteByPrimaryKey(Integer userCollectId);

    int insert(Usercollect record);

    int insertSelective(Usercollect record);

    List<Usercollect> selectByExample(UsercollectExample example);

    Usercollect selectByPrimaryKey(Integer userCollectId);

    int updateByExampleSelective(@Param("record") Usercollect record, @Param("example") UsercollectExample example);

    int updateByExample(@Param("record") Usercollect record, @Param("example") UsercollectExample example);

    int updateByPrimaryKeySelective(Usercollect record);

    int updateByPrimaryKey(Usercollect record);
}