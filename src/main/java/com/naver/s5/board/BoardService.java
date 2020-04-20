package com.naver.s5.board;

import java.util.List;

import com.naver.s5.board.page.Pager;

public interface BoardService {
	//List
	public List<BoardVO> boardList(Pager pager) throws Exception ;
	//select
	public BoardVO boardSelect(long num) throws Exception;
	//insert
	public int boardWrite(BoardVO boardVO) throws Exception;
	//update
	public int boardUpdate(BoardVO boardVO) throws Exception;
	//delete
	public int boardDelete(long num) throws Exception;
}
