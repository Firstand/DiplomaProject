package com.hlbrc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hlbrc.entity.Message;
/**
 * ������Ϣ �־ò�
 * @author ZY
 *
 */
public interface IMessageMapper {
	//��
	public void insertMessage(@Param("list")List<Message> list,@Param("table_name_sender")String table_name_sender);
	//ɾ
	public void deleteMessage(@Param("array")String[] array,@Param("table_name")String table_name);
	//��
	public List<Message> getMessage(Message message);
}
