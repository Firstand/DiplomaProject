package com.hlbrc.mapper;

import com.hlbrc.entity.Privince;

public interface IPrivinceMapper {
    int deleteByPrimaryKey(Integer proId);

    int insert(Privince record);

    int insertSelective(Privince record);

    Privince selectByPrimaryKey(Integer proId);

    int updateByPrimaryKeySelective(Privince record);

    int updateByPrimaryKey(Privince record);
}