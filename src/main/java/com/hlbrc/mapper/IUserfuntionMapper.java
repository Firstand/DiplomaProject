package com.hlbrc.mapper;

import com.hlbrc.entity.Userfuntion;
import com.hlbrc.entity.UserfuntionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IUserfuntionMapper {
    long countByExample(UserfuntionExample example);

    int deleteByExample(UserfuntionExample example);

    int deleteByPrimaryKey(Integer userFuntionId);

    int insert(Userfuntion record);

    int insertSelective(Userfuntion record);

    List<Userfuntion> selectByExample(UserfuntionExample example);

    Userfuntion selectByPrimaryKey(Integer userFuntionId);

    int updateByExampleSelective(@Param("record") Userfuntion record, @Param("example") UserfuntionExample example);

    int updateByExample(@Param("record") Userfuntion record, @Param("example") UserfuntionExample example);

    int updateByPrimaryKeySelective(Userfuntion record);

    int updateByPrimaryKey(Userfuntion record);
}