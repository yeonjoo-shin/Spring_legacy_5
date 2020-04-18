package com.naver.s5.member;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE=	"com.naver.s5.member.MemberDAO.";
	
	//Join
	public  int memberAdd(MemberVO memberVO) throws Exception{
		return sqlSession.insert(NAMESPACE+"memberAdd",memberVO);
	}
	//Login
	public MemberVO memberLogin(MemberVO memberVO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"memberLogin",memberVO);
	}
	//delete
	public int memberDelete(MemberVO memberVO) throws Exception{
		return sqlSession.delete(NAMESPACE+"memberDelete",memberVO);
	}
	//update
	public int memberUpdate(MemberVO memberVO) throws Exception{
		return sqlSession.update(NAMESPACE+"memberUpdate",memberVO);
	}

}
