package com.hlbrc.mapper;

import org.apache.ibatis.annotations.Param;

import com.hlbrc.entity.Profileimg;

public interface IProfileimgMapper {
	//��
	public void insertImg(Profileimg profileimg)throws Exception;
	//��
	public Profileimg queryImg(@Param("user_id")int user_id);
}
