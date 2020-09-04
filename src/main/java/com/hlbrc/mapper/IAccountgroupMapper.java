package com.hlbrc.mapper;

import com.hlbrc.entity.Accountgroup;
import com.hlbrc.entity.AccountgroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IAccountgroupMapper {
    long countByExample(AccountgroupExample example);

    int deleteByExample(AccountgroupExample example);

    int deleteByPrimaryKey(Integer accountGroupId);

    int insert(Accountgroup record);

    int insertSelective(Accountgroup record);

    List<Accountgroup> selectByExample(AccountgroupExample example);

    Accountgroup selectByPrimaryKey(Integer accountGroupId);

    int updateByExampleSelective(@Param("record") Accountgroup record, @Param("example") AccountgroupExample example);

    int updateByExample(@Param("record") Accountgroup record, @Param("example") AccountgroupExample example);

    int updateByPrimaryKeySelective(Accountgroup record);

    int updateByPrimaryKey(Accountgroup record);
}