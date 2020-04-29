package com.naver.s5.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private FileSaver fileSaver;
	@Autowired
	private HttpSession session;
	@Autowired
	private BoardFileDAO boardFileDAO;
	
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
			boardFileDAO.fileInsert(boardFileVO);
			}
		}
		
		return result;
	}

	@Override
	public int boardUpdate(BoardVO boardVO,MultipartFile [] files) throws Exception {
		//hdd file save
		
		String path= session.getServletContext().getRealPath("/resources/uploadnotice");//어느경로에 저장 할 것인가
		System.out.println(path);
		
		//시퀀스 받기
		//boardVO.setNum(noticeDAO.boardNum());
		
		//notice table insert
		int result=noticeDAO.boardUpdate(boardVO);
		
		//저장
		for(MultipartFile file:files) {
			if(file.getSize()>0) { //data가 있을 경우만
				BoardFileVO boardFileVO = new BoardFileVO();
				String fileName = fileSaver.saveByTransfer(file, path);//파일과 경로 저장, 리턴으로 이름이 온다
//				System.out.println(fileName);//오는지 확인
				
				//db에 저장
				
				boardFileVO.setNum(boardVO.getNum());//글번호 받아오기
				boardFileVO.setFileName(fileName);
				boardFileVO.setOriName(file.getOriginalFilename());
				boardFileVO.setBoard(1);//notice 
				result=boardFileDAO.fileInsert(boardFileVO);
			}
		}
		
		
		return result;
	}

	@Override
	public int boardDelete(long num) throws Exception {
		List<BoardFileVO> list = boardFileDAO.fileList(num);//list 가져오기			
		
		//1.HDD 에 해당 파일들을 삭제
		String path = session.getServletContext().getRealPath("/resources/uploadnotice");//저장된 경로명
		System.out.println(path);
		
		for(BoardFileVO boardFileVO : list) {
			fileSaver.deleteFile(boardFileVO.getFileName(), path);//삭제할 파일 이름과 경로명
		}
		
		//2. db에서 삭제
		boardFileDAO.fileDeletes(num);
	
		
		return noticeDAO.boardDelete(num);
	}
	
	

}
