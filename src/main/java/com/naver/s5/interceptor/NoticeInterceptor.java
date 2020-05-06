package com.naver.s5.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.naver.s5.member.MemberVO;

@Component
public class NoticeInterceptor  extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean check = false;
		
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		if(memberVO != null && memberVO.getId().equals("admin")) {
			check= true;
			System.out.println("관리자");
		}else {
			System.out.println("관리자가 아니야이야이야");
			//response.sendRedirect("../member/memberLogin");
			
			request.setAttribute("result", "권한이 없습니다.");
			request.setAttribute("path", "../");
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			//경로를 다 적어줘야함.
			view.forward(request, response);
		}
		
		return check;
	}
}
