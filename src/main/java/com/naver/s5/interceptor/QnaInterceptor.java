package com.naver.s5.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.naver.s5.board.BoardVO;
import com.naver.s5.member.MemberVO;

@Component
public class QnaInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean check = false;
		
		Object obj = request.getSession().getAttribute("member");
		
		if(obj != null) {
			check=true;
		}else {
			response.sendRedirect("../member/memberLogin");
		}
		
		return check;
	}
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		String method = request.getMethod();
		String path = request.getServletPath();
		path = path.substring(path.lastIndexOf("/"));
		System.out.println(path);
		
		if(method.equals("GET") && path.equals("/qnaUpdate")) {
		
			MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");//로그인 속성명
			BoardVO boardVO = (BoardVO)modelAndView.getModel().get("vo");
			String board = (String) modelAndView.getModel().get("board");
			board = "./"+board+"List";
			
			if(memberVO !=null) {
				if(!memberVO.getId().equals(boardVO.getName())) {//일치하지 않으면
					modelAndView.setViewName("redirect:"+board);
				}
					
				
			}else {//로그인 하지 않았을 때
				modelAndView.addObject("result","권한없음");
				modelAndView.addObject("path",board);
				modelAndView.setViewName("common/result");
			}
		}
		
	}
}
