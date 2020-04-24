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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.naver.s5.board.BoardVO;
import com.naver.s5.member.memberFile.MemberFileVO;
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
	public ModelAndView memberAdd(MemberVO memberVO, ModelAndView mv , MultipartFile avatar,HttpSession session) throws Exception{//jsp파라미터 이름과 동일한 이름의 avatar를 변수로 해야함.			
		
		int result=memberService.memberAdd(memberVO,avatar,session);
		String msg ="Member Join Fail";
		 if(result>0) {
			msg="Member join success";
		 }
			 mv.addObject("result",msg);
			 mv.addObject("path","../");
			 
			 mv.setViewName("common/result");
			 
			 return mv;
	
	}
	
	@PostMapping("memberIdCheck")
	public ModelAndView memberIdCheck(MemberVO memberVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		memberVO = memberService.memberIdCheck(memberVO);
		//null-> 가입 가능 1
		//null X -> 중복 0
		int result =0;
		if(memberVO==null) {
			result =1;
		}
		mv.addObject("result",result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	
	@RequestMapping(value = "memberLogin",  method = RequestMethod.GET)
	public String memberLogin(@CookieValue(value = "cId", required = false) String cId , Model model)throws Exception{
		//model.addAttribute("cId",cId);
		return "member/memberLogin";
	}
	@RequestMapping(value = "memberLogin",  method = RequestMethod.POST)
	public ModelAndView memberLogin(MemberVO memberVO, HttpSession session ,ModelAndView mv ,String remember, HttpServletResponse response)throws Exception{
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
	
	@GetMapping("fileDelete")
	public String fileDelete(HttpSession session) throws Exception{
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		
		memberService.fileDelete(memberVO.getId(),session);
		
		return "redirect:./memberPage";
	}
	
	
	@RequestMapping(value ="memberDelete", method = RequestMethod.GET)
	public String memberDelete(MemberVO memberVO) throws Exception{
		memberService.memberDelete(memberVO);
			
		return "redirect:../";
	}	
	
	@RequestMapping(value = "memberPage", method = RequestMethod.GET )
	public void memberPage(/*HttpSession session, Model model*/) throws Exception{
		
//		MemberVO memberVO = (MemberVO)session.getAttribute("member"); //membervo 로그인 정보 가지고 와서
//		MemberFileVO memberFileVO = memberService.fileSelect(memberVO.getId()); //select한 id를 가지고 와서 memberfilevo에 넣어서
//		model.addAttribute("file",memberFileVO); //file이란 이름으로 filevo를 전달
		
		
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
