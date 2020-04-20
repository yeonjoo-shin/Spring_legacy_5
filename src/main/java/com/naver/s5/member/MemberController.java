package com.naver.s5.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.naver.s5.board.BoardVO;
import com.naver.s5.board.page.Pager;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "memberJoin" ,  method = RequestMethod.GET)
	public String memberAdd(MemberVO memberVO ) throws Exception{		
		return "member/memberJoin";
	}
	
	@RequestMapping(value = "memberJoin" ,  method = RequestMethod.POST)
	public ModelAndView memberAdd2(MemberVO memberVO,ModelAndView mv ) throws Exception{
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
	public String memberLogin(MemberVO memberVO)throws Exception{

		return "member/memberLogin";
	}
	@RequestMapping(value = "memberLogin",  method = RequestMethod.POST)
	public String memberLogin2(MemberVO memberVO)throws Exception{
		memberService.memberLogin(memberVO);
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
