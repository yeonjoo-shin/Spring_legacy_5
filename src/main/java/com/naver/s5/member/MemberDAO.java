package com.naver.s5.member;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.s5.util.Pager;

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
	//memberList
	public List<MemberVO> memberList(Pager pager) throws Exception{
		return sqlSession.selectList(NAMESPACE+"memberList",pager);
	}
	//membercount
	public long memberCount(Pager pager) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"memberCount",pager);
	}

}
