package com.naver.s5.notice;

import org.springframework.web.multipart.MultipartFile;

import com.naver.s5.board.BoardVO;

public class NoticeVO  extends BoardVO{ //2) 상속
	//private BoardVO boardVO; 1)
	
	//vo를 통해서 받아올수 있는 방법 2 but write 매개변수로 multipartfile하는게 더 좋음
//	private MultipartFile multipartFile[];
//
//	public MultipartFile[] getMultipartFile() {
//		return multipartFile;
//	}
//
//	public void setMultipartFile(MultipartFile[] multipartFile) {
//		this.multipartFile = multipartFile;
//	}
	
}	
