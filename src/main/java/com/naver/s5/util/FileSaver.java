package com.naver.s5.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {
	
	//1. 폴더 생성
	//2. 저장할 파일명 생성
	//3. 파일을 하드디스크에 저장
	

	//1.FileCopyUtils 클래스 사용
	public String saveFileByUtils(MultipartFile file, String path) throws Exception{//file에서 정보를 꺼내서  path에 저장
		//디렉토리가 없으면 만들어라
		File f = new File(path);
		if(!f.exists()) {
			f.mkdirs();
		}

		//a. 저장할 파일명 생성
		String filName=this.makeNameByUUID(file.getOriginalFilename());
		//객체 생성
		f= new File(f, filName);
		//b. HDD에 저장
		FileCopyUtils.copy(file.getBytes(), f);
		return filName;
	}
	
	//2. MultipartFile 자체 메서드
	public String saveByTransfer(MultipartFile file, String path) throws Exception{
		//디렉토리가 없으면 만들어라
		File f = new File(path);
		if(!f.exists()) {
			f.mkdirs();
		}
		//파일명 생성
		String fileName = this.makeNameByUUID(file.getOriginalFilename());
		//하드에 저장
		f= new File(f,fileName);
		
		file.transferTo(f);
		
		return fileName;
		
	}
	//3. Outputstream
	public String saveByStream(MultipartFile file, String path)throws Exception{
		//디렉토리가 없으면 만들어라
		File f = new File(path);
		if(!f.exists()) {
			f.mkdirs();
		}
		//파일명 생성
		String fileName = this.makeNameByUUID(file.getOriginalFilename());
		f=new File(f, fileName);
		FileOutputStream fs = new FileOutputStream(f);
		fs.write(file.getBytes());
		fs.close();
		
		return fileName;
	}
	
	
	private String makeNameByUUID(String name) {
		String result = UUID.randomUUID().toString();
		result = result+"_"+name;
		return result;
	}
	
	
	private String makeNameByTime(String name) {
		Calendar ca = Calendar.getInstance();
		Long l = ca.getTimeInMillis();
		
		String result = name.substring(0,name.indexOf("."));
		result = result+"_"+l;
		result = result+name.substring(name.lastIndexOf("."));		
		
		return result;
	}
	
	//file delete
	public int deleteFile(String fileName, String path) throws Exception{
		//파일 객체 생성
		File file = new File(path,fileName);
		boolean check=false;
		int result=0;
		if(file.exists()) {
			check = file.delete();
		}
		if(check) {
			result=1;
		}
		return result;
	}
	
	
	
	
}
