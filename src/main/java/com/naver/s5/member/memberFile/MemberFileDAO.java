package com.naver.s5.member.memberFile;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberFileDAO {//테이블에 데이터 삽입 삭제 등등 자기 이미지
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.naver.s5.member.memberFile.MemberFileDAO.";
	
	//fileinsert
	public int fileInsert(MemberFileVO memberFileVO) throws Exception{
		return sqlSession.insert(NAMESPACE+"fileInsert",memberFileVO);
	}
	//fileupdate
	public int fileUpdate(MemberFileVO memberFileVO) throws Exception{
		return sqlSession.update(NAMESPACE+"fileUpdate",memberFileVO);
	}
	//filedelete
	public int fileDelete(String id) throws Exception{
		return sqlSession.delete(NAMESPACE+"fileDelete",id );
	}
	//fileselect
	public MemberFileVO fileSelect(String id) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"fileSelect",id);
	}
	
}
