package com.gdu.app02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.app02.domain.Bbs;

@Controller
public class DiController {
	
	/*
	 	Spring Container에 저장되어 있는 Bean을 가져올 수 있는 Annotation
	 	
	 	1. @Inject
	 		1) Bean의 타입(class)이 일치하는 Bean을 가져온다.
	 		2) 동일 타입의 Bean이 2개 이상이면 오류 발생가 발생한다.
	 		3) 동일 타입의 Bean을 구별하기 위해서 @Qualifier를 사용할 수 있다.
	 	2. @Resource
	 		1) Bean의 이름(id)이 일치하는 Bean을 가져온다.
	 		2) 동일한 이름의 Bean이 없으면 오류가 발생한다.
	 	3. @AutoWired
	 		1) Bean의 타입(class)이 일치하는 Bean을 가져온다. 
	 		2) 동일한 타입의 Bean이 2개 이상이면 Bean의 이름(id)이 일치하는 Bean을 가져온다.
	 		3) 이걸 쓴댜
	 */
	
	/*
	 	@Autowired 사용 방법 3가지
	 	1. 필드에 @Autowired 선언하기
	 		1) 필드에 자동으로 Bean을 주입한다.
	 		2) 각 필드마다 @Autowired를 선언한다.
	 		3) 필드가 10개이면 @Autowired도 10번 선언해야한다.
	 		
	 	2. 생성자에 @Autowired 선언하기
	 		1) 생성자의 매개변수(괄호 안에 있는 변수)에 있는 객체들에 자동으로 Bean을 주입한다.
	 		2) 생성자에는 @Autowired 선언을 생략할 수 있다. (일반적으로 생략)
	 		
	 	3. 메소드에 @Autowired 선언하기
	 		1) 메소드의 매개변수(괄호 안에 있는 변수)에 있는 객체들에 자동으로 Bean을 주입한다.
	 		2) 매소드에는 @Autowired 선언을 생략할 수 없다.
	 */
	
	// 필드
//	@Autowired
//	private Bbs bbs1;
//	
//	@Autowired
//	private Bbs bbs2;
	
	private Bbs bbs1;
	private Bbs bbs2;
	
	// 메소드
	@Autowired
	public void method(Bbs bbs1, Bbs bbs2) {
		this.bbs1 = bbs1;
		this.bbs2 = bbs2;
	}
	
	// 생성자
//	public DiController(Bbs bbs1, Bbs bbs2) {
//		super();
//		this.bbs1 = bbs1;
//		this.bbs2 = bbs2;
//	}

	@GetMapping("/bbs/detail.do")
	public String detail(Model model) {
		model.addAttribute("bbs1", bbs1);
		model.addAttribute("bbs2", bbs2);
		return "bbs/detail";	// 실체 처리 경로 : /WEB-INF/views/bbs/detail.jsp
	}
	
}
