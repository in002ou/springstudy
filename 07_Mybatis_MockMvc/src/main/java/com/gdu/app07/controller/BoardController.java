package com.gdu.app07.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.app07.service.BoardService;
import com.gdu.app07.service.BoardServiceImpl;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	/*
	 	데이터(속성) 저장 방법
	 	1. forward  : Model에 attribute로 저장
	 	2. redirect : RedirectAttributes에 flashAttribute로 저장
	 */
	
	// getBoardList() 서비스가 반환한 List<BoardDTO>를 /WEB-INF/views/board/list.jsp로 전달
	@GetMapping("/list.do")
	public String list(Model model) {
		model.addAttribute("boardList", boardService.getBoardList());
		return "board/list";
	}
	
	// 이전의 ModelAndView 클래스
	/*
	@GetMapping("/list.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardService.getBoardList());
		mav.setViewName("board/list");
		return mav;
	}
	*/
	
	// getBoardByNo() 서비스가 반환한 BoardDTO를 /WEB-INF/views/board/detail.jsp로 전달
	@GetMapping("/detail.do")
	public String detail(HttpServletRequest request, Model model) {
		model.addAttribute("b", boardService.getBoardByNo(request));
		return "board/detail";
	}
	
	@GetMapping("/write.do")
	public String write() {
		return "board/write";
	}
	
	// addBoard() 서비스가 반환한 0 또는 1을 가지고 /board/list.do으로 이동(redirect)
	// addBoard() 서비스가 반환한 0 또는 1은 /WEB-INF/views/board/list.jsp에서 확인
	@PostMapping("/add.do")
	public String add(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		// addAttribute do까지 addFlashAttribute는 jsp까지 값을 보내준다
		redirectAttributes.addFlashAttribute("addResult", boardService.addBoard(request));
		return "redirect:/board/list.do";
	}
	
	// modifyBoard() 서비스가 반환한 0 또는 1을 가지고 /board/detail.do으로 이동(redirect)
	// modifyBoard() 서비스가 반환한 0 또는 1은 /WEB-INF/views/board/detail.jsp에서 확인
	@PostMapping("/modify.do")
	public String modify(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("modifyResult", boardService.modifyBoard(request));
		return "redirect:/board/detail.do?boardNo=" + request.getParameter("boardNo");
	}
	
	@PostMapping("/remove.do")
	public String remove(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("removeResult", boardService.removeBoard(request));
		return "redirect:/board/list.do";
	}
	
	// 트랜젝션 테스트
	@GetMapping("/tx.do")
	public void tx() {
		boardService.testTx();
	}
	
}
