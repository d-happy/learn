package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.dao.BoardDao;
import com.kh.domain.BoardVo;

public class ReplyFormService implements IService {
	
	private BoardDao boardDao = BoardDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		BoardVo boardVo = boardDao.selectByBno(b_no, false);
		request.setAttribute("boardVo", boardVo);
		
		return "reply_form";
	} //execute

} //ReplyFormService
