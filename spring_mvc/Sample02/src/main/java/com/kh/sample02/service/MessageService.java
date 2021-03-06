package com.kh.sample02.service;

import java.util.List;

import com.kh.sample02.domain.MessageVo;

public interface MessageService {

	//쪽지 보내기
	public void sendMessage(MessageVo messageVo) throws Exception;
	//쪽지 읽기
	public MessageVo readMessage(String user_id, int msg_no) throws Exception;
	// 안 읽은 쪽지 갯수
	public int notReadCount(String msg_receiver) throws Exception;
	// 받은 쪽지 목록
	public List<MessageVo> receiveList(String msg_receiver) throws Exception;
	// 보낸 쪽지 목록
	public List<MessageVo> sendList(String msg_sender) throws Exception;
	// 쪽지 삭제
	public void delete(int[] arr_msg_no) throws Exception;
	// 쪽지 읽은 상태로
	public void stateChange(int[] arr_msg_no) throws Exception;
	
}
