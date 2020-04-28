package com.naver.s5.board.file;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.s5.util.FileSaver;

@Service
public class BoardFileService {
	@Autowired
	private BoardFileDAO boardFileDAO;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FileSaver fileSaver;
	
	public BoardFileVO fileSelect(BoardFileVO boardFileVO) throws Exception{
		return boardFileDAO.fileSelect(boardFileVO);
	}
	public int fileDelete(BoardFileVO boardFileVO) throws Exception{
		
		boardFileVO = boardFileDAO.fileSelect(boardFileVO);//셀랙트
		int result=boardFileDAO.fileDelete(boardFileVO); //지우기
		
		//1.hdd에 삭제
		String board = "uploadnotice";
		if(boardFileVO.getBoard()==2) {
			board="uploadQna";
		}
		
		//실제 경로
		String path = servletContext.getRealPath("/resources/"+board);
		fileSaver.deleteFile(boardFileVO.getFileName(), path);
		return result;
	}
	public int fileDeletes(Long num) throws Exception{
		return boardFileDAO.fileDeletes(num);
	}
}
