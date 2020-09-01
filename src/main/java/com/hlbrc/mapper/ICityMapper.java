package com.hlbrc.mapper;

import com.hlbrc.entity.City;

public interface ICityMapper {
    int deleteByPrimaryKey(Integer citId);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(Integer citId);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}