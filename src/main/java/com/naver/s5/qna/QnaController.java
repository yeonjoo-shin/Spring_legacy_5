package com.naver.s5.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.naver.s5.board.BoardVO;
import com.naver.s5.notice.NoticeVO;
import com.naver.s5.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() throws Exception{
		return "qna";
	}
	
	@RequestMapping(value = "qnaDelete", method = RequestMethod.GET)
	public ModelAndView boardDelete(long num, ModelAndView mv) throws Exception{
		int result = qnaService.boardDelete(num);
		
		if(result>0) {
			mv.addObject("result","delete success");
		}else {
			mv.addObject("result","delete fail");
		}
		mv.addObject("path","./qnaList");
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@RequestMapping(value = "qnaUpdate", method = RequestMethod.GET)
	public String boardUpdate(long num, Model model) throws Exception{
		BoardVO boardVO = qnaService.boardSelect(num);
		model.addAttribute("vo",boardVO);
		return "board/boardUpdate";
	}
	
	@RequestMapping(value = "qnaUpdate", method = RequestMethod.POST)
	public String boardUpdate(QnaVO qnaVO) throws Exception{
		int result = qnaService.boardUpdate(qnaVO);
		String path="";
		
		if(result>0) {
			path="redirect:./qnaList";
		}else {
			path="redirect:./qnaSelect?num="+qnaVO.getNum();
		}
			return path;
	}
	
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.GET)
	public String boardWrite() throws Exception{
		return "board/boardWrite";
	}
	
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
	public ModelAndView boardWrite(QnaVO qnaVO,ModelAndView mv) throws Exception{
		int result = qnaService.boardWrite(qnaVO);
		
		if(result>0) {
			mv.setViewName("redirect:./qnaList");
		}else {
			mv.addObject("result","write fail");
			mv.addObject("path","./qnaList");
			
			mv.setViewName("common/result");
		}
		return mv;
	}
	
	@RequestMapping(value = "qnaSelect",method = RequestMethod.GET)
	public ModelAndView boardSelect(long num) throws Exception{
		 BoardVO boardVO = qnaService.boardSelect(num);
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("vo",boardVO);
		 
		 mv.setViewName("board/boardSelect");
		 
		 return mv;
	}
	
	@GetMapping("qnaList") 
	public ModelAndView boardList(ModelAndView mv, Pager pager) throws Exception{
		
		List<BoardVO> ar = qnaService.boardList(pager);
		mv.addObject("list",ar);
		mv.addObject("pager",pager);
		mv.setViewName("board/boardList");
		return mv;
	}
	@GetMapping("qnaReply")
	public ModelAndView boardReply(ModelAndView mv, long num) throws Exception{
		mv.addObject("num",num);//부모의 글번호
		mv.setViewName("board/boardReply");
		return mv;
	}
	@PostMapping("qnaReply")
	public ModelAndView boardReply(ModelAndView mv, QnaVO qnaVO) throws Exception{
		
		return mv;
	}

	
}
