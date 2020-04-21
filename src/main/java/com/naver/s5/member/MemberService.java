package com.naver.s5.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.s5.util.Pager;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	public int memberAdd(MemberVO memberVO) throws Exception{
		return memberDAO.memberAdd(memberVO);
	}
	public MemberVO memberLogin(MemberVO memberVO) throws Exception{
		return memberDAO.memberLogin(memberVO);
	}
	public int memberDelete(MemberVO memberVO) throws Exception{
		return memberDAO.memberDelete(memberVO);
	}
	public int memberUpdate(MemberVO memberVO) throws Exception{
		return memberDAO.memberUpdate(memberVO);
	}
	public List<MemberVO> memberList(Pager pager) throws Exception{
		pager.makeRow();
		
		long totalCount =  memberDAO.memberCount(pager);
		pager.makePage(totalCount);

		return memberDAO.memberList(pager);
	}
	
}
