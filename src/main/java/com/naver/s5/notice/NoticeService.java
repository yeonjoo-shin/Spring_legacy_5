package com.naver.s5.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.naver.s5.board.BoardService;
import com.naver.s5.board.BoardVO;
import com.naver.s5.board.file.BoardFileDAO;
import com.naver.s5.board.file.BoardFileVO;
import com.naver.s5.util.FileSaver;
import com.naver.s5.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private FileSaver fileSaver;
	@Autowired
	private HttpSession session;
	@Autowired
	private BoardFileDAO boardFileDAO;
	@Autowired
	private ServletContext servletContext;
	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {		
		pager.makeRow(); //startrow, lastrow 계산한 메서드
		
		long totalCount = noticeDAO.boardCount(pager);//전체글의 갯수 가지고오기
		pager.makePage(totalCount);//totalcount 넘겨주기
		
		//------------------------------
		
		return noticeDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(long num) throws Exception {
		noticeDAO.hitUpdate(num);
		return noticeDAO.boardSelect(num);
	}
	
	
	@Override
	@Transactional // rollback
	public int boardWrite(BoardVO boardVO,MultipartFile [] files) throws Exception {
		String path = session.getServletContext().getRealPath("/resources/uploadnotice");
		System.out.println(path);
		
		//sequence 번호 받기(글 번호받기)
		boardVO.setNum(noticeDAO.boardNum());
		
		//notice table insert
		int result = noticeDAO.boardWrite(boardVO);
		
		for(MultipartFile file : files) {
			if(file.getSize()>0) {
			BoardFileVO boardFileVO = new BoardFileVO();
			String fileName=fileSaver.saveByTransfer(file, path);
			boardFileVO.setNum(boardVO.getNum());//글번호
			boardFileVO.setFileName(fileName);
			boardFileVO.setOriName(file.getOriginalFilename());
			boardFileVO.setBoard(1);
			boardFileDAO.fileInsert(boardFileVO);//보드파일테이블 insert
				if(result<1) {
					throw new Exception();// 롤백을 위한 강제 예외처리
				}
			}
		}
		
		return result;
	}

	@Override
	public int boardUpdate(BoardVO boardVO, MultipartFile [] files) throws Exception {
		//HDD file save
				String path = servletContext.getRealPath("/resources/uploadnotice");
				System.out.println(path);
				int result = noticeDAO.boardUpdate(boardVO);
				for(MultipartFile multipartFile:files) {
					 
					if(multipartFile.getSize()>0) {
						BoardFileVO boardFileVO = new BoardFileVO();
						
						boardFileVO.setFileName(fileSaver.saveFileByUtils(multipartFile, path));
						boardFileVO.setOriName(multipartFile.getOriginalFilename());
						boardFileVO.setNum(boardVO.getNum());
						boardFileVO.setBoard(1);
						result = boardFileDAO.fileInsert(boardFileVO);
					}
				}
				
				return result;
	}

	@Override
	public int boardDelete(long num) throws Exception {
		List<BoardFileVO> list = boardFileDAO.fileList(num);
		//1. HDD에 해당 파일들을 삭제
		String path = servletContext.getRealPath("/resources/uploadnotice");
		System.out.println(path);
		
		for(BoardFileVO boardFileVO:list) {
			fileSaver.deleteFile(boardFileVO.getFileName(), path);
		}
		
		//2. DB에 삭제
		boardFileDAO.fileDeleteAll(num);
		
		return noticeDAO.boardDelete(num);
	}
		
	}
	
	


