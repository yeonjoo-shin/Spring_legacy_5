package com.naver.s5.member;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.naver.s5.board.BoardVO;
import com.naver.s5.util.Pager;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "memberJoin" ,  method = RequestMethod.GET)
	public String memberAdd(MemberVO memberVO ,String remember) throws Exception{
		
		return "member/memberJoin";
	}
	
	@RequestMapping(value = "memberJoin" ,  method = RequestMethod.POST)
	public ModelAndView memberAdd2(MemberVO memberVO,ModelAndView mv ,String avatar) throws Exception{
		
		int result=memberService.memberAdd(memberVO);
		  
		 if(result>0) {
			 mv.setViewName("redirect:./memberList");
		 }else {
			 mv.addObject("result","add fail");
			 mv.addObject("path","./memberAdd");
			 
			 mv.setViewName("common/result");
		 }
		
		return mv;
	}
	
	
	@RequestMapping(value = "memberLogin",  method = RequestMethod.GET)
	public String memberLogin(@CookieValue(value = "cId", required = false) String cId , Model model)throws Exception{
		System.out.println(cId);
		//model.addAttribute("cId",cId);
		return "member/memberLogin";
	}
	@RequestMapping(value = "memberLogin",  method = RequestMethod.POST)
	public ModelAndView memberLogin2(MemberVO memberVO, HttpSession session ,ModelAndView mv ,String remember, HttpServletResponse response)throws Exception{
		Cookie cookie = new Cookie("cId", "");
		
		if(remember != null) {
			//cookie = new Cookie("cId", memberVO.getId());
			cookie.setValue(memberVO.getId());
		}
		
		//cookie.setMaxAge(0);//쿠키 유지 시간
		response.addCookie(cookie);
				
		System.out.println("remember : " + remember);
		memberVO = memberService.memberLogin(memberVO);				
		
		if(memberVO !=null) {
			session.setAttribute("member", memberVO);
			
			mv.setViewName("redirect:../");
		}else {
			mv.addObject("result","login fail");
			mv.addObject("path","./memberJoin");
			
			mv.setViewName("common/result");
		}
		
		
		return mv;
	}
	@RequestMapping(value = "memberLogout" )
	public String memberLogout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:../";
	}
	
	
	@RequestMapping(value ="memberDelete", method = RequestMethod.GET)
	public String memberDelete(MemberVO memberVO) throws Exception{
		memberService.memberDelete(memberVO);
		return "redirect:../";
	}	
	
	@RequestMapping(value = "memberPage", method = RequestMethod.GET )
	public String memberPage() throws Exception{
		return "member/memberPage";
	}
	
	@RequestMapping(value = "memberList", method = RequestMethod.GET )
	public ModelAndView memberList(ModelAndView mv, Pager pager) throws Exception{
		System.out.println("kind : " + pager.getKind());
		System.out.println("search : " + pager.getSearch());
		
		List<MemberVO> ar = memberService.memberList(pager);
		System.out.println(pager.getTotalPage());
		mv.addObject("list",ar);
		mv.addObject("pager",pager);
		mv.setViewName("member/memberList");
		
		return mv;
		
	}
	
	//update 진행중
//	@RequestMapping(value = "memberUpdate", method = RequestMethod.GET)
//	public String memberUpdate(MemberVO memberVO) throws Exception{
//		return "member/memberUpdate";
//	}
//	
//
//	@RequestMapping(value = "memberUpdate", method = RequestMethod.POST)
//	public String memberUpdate2(MemberVO memberVO) throws Exception{
//		return "redirect:../";
//	}
	
}
