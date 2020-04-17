package com.naver.s5.notice;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.naver.s5.board.BoardVO;


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
	public ModelAndView boardWrite(NoticeVO noticeVO, ModelAndView mv) throws Exception{
		int result=noticeService.boardWrite(noticeVO);
		
		if(result>0) {//�꽦怨� ->list濡�
			mv.setViewName("redirect:./noticeList");
		}else {//�떎�뙣 ->alert �븯怨� list濡�..?
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
	public ModelAndView boardList(ModelAndView mv ,@RequestParam(defaultValue = "1") int curPage) throws Exception{		

		List<BoardVO> ar = noticeService.boardList(curPage);
		mv.addObject("list", ar);
		mv.setViewName("board/boardList");
		return mv;
		
	}
	
}
