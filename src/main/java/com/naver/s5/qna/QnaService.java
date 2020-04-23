package com.naver.s5.qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.naver.s5.board.BoardService;
import com.naver.s5.board.BoardVO;
import com.naver.s5.board.file.BoardFileDAO;
import com.naver.s5.board.file.BoardFileVO;
import com.naver.s5.util.FileSaver;
import com.naver.s5.util.Pager;


@Service
public class QnaService implements BoardService {
	@Autowired
	private QnaDAO qnaDAO;
	@Autowired
	private FileSaver fileSaver;
	@Autowired
	private HttpSession session;
	@Autowired
	private BoardFileDAO boardFileDAO; 

	
	public int boardReply(BoardVO boardVO) throws Exception{
		int result =  qnaDAO.boardReplyUpdate(boardVO);
		result = qnaDAO.boardReply(boardVO);
		
		return result;
	}
	
	
	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		
		pager.makeRow();
		long totalCount = qnaDAO.boardCount(pager);//전체글의 갯수 가지고오기
		pager.makePage(totalCount);//totalcount 넘겨주기
		
		
		return qnaDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(long num) throws Exception {
		qnaDAO.hitUpdate(num);
		return qnaDAO.boardSelect(num);
	}

	@Override
	public int boardWrite(BoardVO boardVO, MultipartFile[] files) throws Exception {
		String path = session.getServletContext().getRealPath("/resources/uploadQna");
		System.out.println(path);
		
		//시퀀스 번호 받기 / qna table insert
		int result = qnaDAO.boardWrite(boardVO);
		
	
		for(MultipartFile file: files) {
			BoardFileVO boardFileVO = new BoardFileVO();
			String fileName = fileSaver.saveByTransfer(file, path);
			boardFileVO.setNum(boardVO.getNum());
			boardFileVO.setFileName(fileName);
			boardFileVO.setOriName(file.getOriginalFilename());
			boardFileVO.setBoard(2);
			boardFileDAO.fileInsert(boardFileVO);
		}		
		return result;
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		return qnaDAO.boardUpdate(boardVO);
	}

	@Override
	public int boardDelete(long num) throws Exception {
		return qnaDAO.boardDelete(num);
	}

}
