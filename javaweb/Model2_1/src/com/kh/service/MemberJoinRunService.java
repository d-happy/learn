package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.dao.MemberDao;
import com.kh.domain.MemberVo;

public class MemberJoinRunService implements IService {
	
	MemberDao memberDao = MemberDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		String m_name = request.getParameter("m_name");
		
		MemberVo memberVo = new MemberVo();
		memberVo.setM_id(m_id);
		memberVo.setM_pw(m_pw);
		memberVo.setM_name(m_name);

		int count = memberDao.insertMember(memberVo);
		if (count > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("message", "join_success");
		}
		return "redirect:login_form.do";
	}

} //MemberJoinRunService
