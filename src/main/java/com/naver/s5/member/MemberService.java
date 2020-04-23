package com.naver.s5.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.naver.s5.member.memberFile.MemberFileDAO;
import com.naver.s5.member.memberFile.MemberFileVO;
import com.naver.s5.util.FileSaver;
import com.naver.s5.util.Pager;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private FileSaver fileSaver;
	@Autowired
	private MemberFileDAO memberFileDAO;
	
	//join
	public int memberAdd(MemberVO memberVO,MultipartFile avatar,HttpSession session) throws Exception{
		//HDD에 저장 resources/memberUpload/
		//1. 실제 경로 가지고오기
		String path = session.getServletContext().getRealPath("/resources/memberUpload");
		System.out.println(path);
		
		String fileName = fileSaver.saveByTransfer(avatar, path);
		
		MemberFileVO memberFileVO = new MemberFileVO();
		
		memberFileVO.setId(memberVO.getId());
		memberFileVO.setFileName(fileName);
		memberFileVO.setOriName(avatar.getOriginalFilename());
		
		//2. 파일명을 DB에 저장
		//참조하기 때문에 순서가 중요
		int result = memberDAO.memberAdd(memberVO);
			
		result=memberFileDAO.fileInsert(memberFileVO);
		 
		return result; //memberDAO.memberAdd(memberVO);
		
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
	
//	public MemberFileVO fileSelect(String id) throws Exception{
//		return memberFileDAO.fileSelect(id);
//	}
	
	public int fileDelete(String id, HttpSession session) throws Exception{
		MemberFileVO memberFileVO = memberFileDAO.fileSelect(id);
		
		int result=memberFileDAO.fileDelete(id);//db에서 지우기
		if(result>0) {
			String path=session.getServletContext().getRealPath("/resources/memberUpload");
			result=fileSaver.deleteFile(memberFileVO.getFileName(), path);
		}
		
		
		return result;
	}
	
}
