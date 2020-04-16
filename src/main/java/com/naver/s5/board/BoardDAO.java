package com.naver.s5.board;

import java.util.List;

public interface BoardDAO {
	//멤버변수로 상수를 가짐
	//추상메서드만을 멤버로 가짐
	//public abstract(생략가능, 자동으로 만들어짐)
	
	//List
	public abstract List<BoardVO> boardList() throws Exception;

	//select
	public abstract BoardVO boardSelect()	throws Exception;
	
	//insert
	public abstract int boardWrite(BoardVO boardVO) throws Exception;
	
	//delete
	public abstract int boardDelete(long num) throws Exception;
	
	//update
	public abstract int boardUpdate(BoardVO boardVO) throws Exception;
	
	//hit update
	public int hitUpdate(BoardVO boardVO) throws Exception;
}
