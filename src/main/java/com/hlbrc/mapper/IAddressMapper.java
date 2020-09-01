package com.hlbrc.mapper;

import com.hlbrc.entity.Address;
import com.hlbrc.entity.AddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IAddressMapper {
    long countByExample(AddressExample example);

    int deleteByExample(AddressExample example);

    int deleteByPrimaryKey(Integer addressid);

    int insert(Address record);

    int insertSelective(Address record);

    List<Address> selectByExample(AddressExample example);

    Address selectByPrimaryKey(Integer addressid);

    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}