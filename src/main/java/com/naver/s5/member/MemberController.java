package com.naver.s5.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naver.s5.board.BoardVO;

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
	public String memberAdd2(MemberVO memberVO ) throws Exception{
		 memberService.memberAdd(memberVO);
		
		return "redirect:../";
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
