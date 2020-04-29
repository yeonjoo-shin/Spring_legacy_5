package com.naver.s5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.naver.s5.board.BoardVO;
import com.naver.s5.notice.NoticeService;

@Controller
@RequestMapping("json")
public class JsonController {
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("json1")
	public ModelAndView json1() throws Exception{
		ModelAndView mv = new ModelAndView();
		BoardVO boardVO = noticeService.boardSelect(13);
		String json = "{";
		json=json+"\"num\":\""+boardVO.getNum()+"\",";
		json=json+"\"title\":\""+boardVO.getTitle()+"\"}";
		
		//mv.addObject("result", "{\"name\":\"iu\"}");
		mv.addObject("result", json);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
}
