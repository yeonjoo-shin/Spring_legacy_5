package com.naver.s5.board;

import java.util.List;
import java.util.Map;

import com.naver.s5.board.page.Pager;

public interface BoardDAO {
	//멤버변수로 상수를 가짐
	//추상메서드만을 멤버로 가짐
	//public abstract(생략가능, 자동으로 만들어짐)
	
	//count
	public abstract long boardCount(Pager pager) throws Exception;
	
	//List
	public abstract List<BoardVO> boardList(Pager pager) throws Exception;

	//select
	public abstract BoardVO boardSelect(long num) throws Exception;
	
	//insert
	public abstract int boardWrite(BoardVO boardVO) throws Exception;
	
	//delete
	public abstract int boardDelete(long num) throws Exception;
	
	//update
	public abstract int boardUpdate(BoardVO boardVO) throws Exception;
	
	//hit update
	public int hitUpdate(long num) throws Exception;
}
