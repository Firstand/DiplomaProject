package com.hlbrc.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hlbrc.entity.Message;
import com.hlbrc.mapper.IMessageMapper;

/**
 * ��Ϣ�߼���
 * @author ZY
 *
 */
@Service("MessageBiz")
@Transactional(readOnly = true)
public class MessageBiz {
	@Autowired
	private IMessageMapper message_mapper;
	
	/**
	 * ������������¼��ӵ����ݿ�
	 * @param list
	 * @param table_name_sender
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Throwable.class)
	public void insertMessage(List<Message> list,String table_name_sender) throws Exception {
		message_mapper.insertMessage(list,table_name_sender);
	}
	/**
	 * ɾ����Ϣ
	 * @param array
	 * @param table_name
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Throwable.class)
	public void deleteMessage(String[] array, String table_name) throws Exception {
		message_mapper.deleteMessage(array, table_name);
	}
	/**
	 * ��ȡ�����¼
	 * @param message
	 * @return ��Ϣ����
	 * @throws Exception
	 */
	public List<Message> getMessage(Message message) throws Exception{
		return message_mapper.getMessage(message);
	}
}
