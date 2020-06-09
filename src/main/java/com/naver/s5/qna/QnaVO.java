package com.naver.s5.qna;

import java.util.List;

import com.naver.s5.board.BoardVO;
import com.naver.s5.board.file.BoardFileVO;

public class QnaVO extends BoardVO{
	private long ref; //원본글과 답글을 그룹으로 묶을 
	private long step; // 그룹 내에서 정렬
	private long depth; // 화면 출력시 들여쓰기 횟수
	
	private List<BoardFileVO> boardFileVOs;
	

	public List<BoardFileVO> getBoardFileVOs() {
		return boardFileVOs;
	}
	public void setBoardFileVOs(List<BoardFileVO> boardFileVOs) {
		this.boardFileVOs = boardFileVOs;
	}
	
	
	
	public long getRef() {
		return ref;
	}
	public void setRef(long ref) {
		this.ref = ref;
	}
	public long getStep() {
		return step;
	}
	public void setStep(long step) {
		this.step = step;
	}
	public long getDepth() {
		return depth;
	}
	public void setDepth(long depth) {
		this.depth = depth;
	}
	
	
}
