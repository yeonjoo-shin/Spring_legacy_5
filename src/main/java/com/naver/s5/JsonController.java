package com.naver.s5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.naver.s5.board.BoardVO;
import com.naver.s5.notice.NoticeService;
import com.naver.s5.util.Pager;

@RestController
@RequestMapping("json")
public class JsonController {
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("json1")
	//@ResponseBody->@RestController//리턴하는 vo를 view로 보내지말고 바로 클라ㅣ언트로 때려넣어라/ajax일때만 사용가능//json형태로 넘어옴
	public List<BoardVO> json1(Pager pager) throws Exception{

		//ModelAndView mv = new ModelAndView();
		BoardVO boardVO = noticeService.boardSelect(13);
		List<BoardVO> ar = noticeService.boardList(pager);
		
		//mv.addObject("result", "{\"name\":\"iu\"}");
		//mv.addObject("result", json);
		//mv.setViewName("common/ajaxResult");
		return ar;
	}
}
