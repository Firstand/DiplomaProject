package com.hlbrc.mapper;

import com.hlbrc.entity.District;

public interface IDistrictMapper {
    int deleteByPrimaryKey(Integer disId);

    int insert(District record);

    int insertSelective(District record);

    District selectByPrimaryKey(Integer disId);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);
}