package com.naver.s5.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.naver.s5.board.file.BoardFileVO;


@Component
public class FileDown extends AbstractView {
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		BoardFileVO boardFileVO = (BoardFileVO) model.get("file");
		String fileName =  boardFileVO.getFileName();//파일명
		String path="";
		if(boardFileVO.getBoard()==1) {
			path="/resources/uploadnotice";
		}else {
			path="/resources/uploadqna";
		}
		path = request.getSession().getServletContext().getRealPath(path);
		
		//1. HDD에서 파일을 읽을 준비(어느경로에 어느 파일명인가)
		File file = new File(path, fileName);//해당파일의 정보를 가지고 있는 객체

		//2. 파일의 크기(내보낼때 파일의 크기)
		response.setContentLength((int)file.length());

		//3. 다운로드 시 파일 이름 인코딩
		String downName =URLEncoder.encode(boardFileVO.getOriName(),"UTF-8");
		
		//4. header 설정
		response.setHeader("Content-disposition", "attachment;filename=\""+downName+"\"");
		response.setHeader("Content-transfer-Encoding", "binary");
		
		//5.stream 연결 후 전송
		FileInputStream fi = new FileInputStream(file); //외부파일을 서버로 끌어들이기
		OutputStream os = response.getOutputStream(); //클라이언트로 outputstream으로 보내주기
		
		FileCopyUtils.copy(fi, os);//카피해서 아웃풋하겠다.
		
		//자원해제
		os.close();
		fi.close();
		
		
		
		
		
		
		
		
		
	}
}
