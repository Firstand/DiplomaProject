package com.hlbrc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hlbrc.entity.Message;
/**
 * 聊天消息 持久层
 * @author ZY
 *
 */
public interface IMessageMapper {
	//增
	public void insertMessage(@Param("list")List<Message> list,@Param("table_name_sender")String table_name_sender);
	//删
	public void deleteMessage(@Param("array")String[] array,@Param("table_name")String table_name);
	//查
	public List<Message> getMessage(Message message);
}
