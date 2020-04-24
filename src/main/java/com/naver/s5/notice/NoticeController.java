package com.naver.s5.notice;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.naver.s5.board.BoardVO;
import com.naver.s5.util.Pager;


@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() throws Exception {
		return "notice";
	}
	
	@RequestMapping(value = "noticeDelete", method = RequestMethod.GET)
	public ModelAndView boardDelete(long num, ModelAndView mv) throws Exception{
		int result =noticeService.boardDelete(num);
		
		if(result>0) {
			mv.addObject("result","delete success");
		}else {
			mv.addObject("result","delete fail");
		}
		mv.addObject("path", "./noticeList");
		mv.setViewName("common/result");
		
		
		return mv;
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.GET)
	public String boardUpdate(long num,Model model) throws Exception{
			BoardVO boardVO=noticeService.boardSelect(num);
			model.addAttribute("vo",boardVO);
		return "board/boardUpdate";
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public String boardUpdate(NoticeVO noticeVO) throws Exception{
			int result = noticeService.boardUpdate(noticeVO);
			String path="";
			
			if(result>0) {
				path="redirect:./noticeList";
			}else {
				path="redirect:./noticeSelect?num="+noticeVO.getNum();
			}
			
		return path;
	}
	
	

	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public String boardWrite() throws Exception{
		
		return "board/boardWrite";
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public ModelAndView boardWrite(NoticeVO noticeVO, ModelAndView mv, MultipartFile [] files/*HttpServletRequest request*/) throws Exception{
		//컨텐츠가 안넘오면 넘어오는 파라미터가 있는지 없느지 확인하는 방법
		//		Enumeration<String> er = request.getParameterNames();//넘어오는 파라미터 이름들
		
//		
//		while(er.hasMoreElements()) {
//			System.out.println(er.nextElement());//다음요소를  꺼내와
//		}
		
		for(MultipartFile file : files) {
			System.out.println(file.getOriginalFilename());
		}
		
		int result=noticeService.boardWrite(noticeVO,files);
		
		if(result>0) {//
			mv.setViewName("redirect:./noticeList");
		}else {//
			mv.addObject("result","write fail");
			mv.addObject("path","./noticeList");
			
			mv.setViewName("common/result");
		}
		return mv;
	}


	
	@RequestMapping(value = "noticeSelect", method = RequestMethod.GET)
	public ModelAndView boardSelect(long num) throws Exception{
		
		BoardVO boardVO = noticeService.boardSelect(num);
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", boardVO);
	
		mv.setViewName("board/boardSelect");
		
		return mv;
		
	}
	
	
	@RequestMapping(value = "noticeList", method = RequestMethod.GET)
	public ModelAndView boardList(ModelAndView mv ,Pager pager) throws Exception{		
		System.out.println("kind : "+pager.getKind());
		System.out.println("search : " +pager.getSearch());
		
		
		List<BoardVO> ar = noticeService.boardList(pager);
		System.out.println(pager.getTotalPage());
		mv.addObject("list", ar);
		mv.addObject("pager",pager);
		mv.setViewName("board/boardList");
		return mv;
		
	}
	
}
