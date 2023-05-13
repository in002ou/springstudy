package com.gdu.app01.xml01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		/*
	 	<bean> 태그로 생성한 Bean을 가져올 때 사용하는 스프링 클래스
	 	1. GenericXmlApplicationContext 클래스
	 	2. ClassPathXmlApplicationContext 클래스
	 	위 클래스 중 아무거나 사용하면 된다.
	 */
	
	// src/main/resources/xml01 디렉터리에 있는 app-context.xml 파일에 정의된 Bean을 쓸께요!
	AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml01/app-context.xml");		// src/main/resources/ 는 명시하지 않는다.
	
	// Bean 중에서 student란 id를 가진 Bean을 주세요!
	Student haksang = ctx.getBean("student", Student.class);	// (Student)ctx.getBean("student")
	
	// haksnag의 calculator를 이용한 메소드를 호출합니다!
	haksang.getCalculator().add(5, 2);
	haksang.getCalculator().sub(5, 2);
	haksang.getCalculator().mul(5, 2);
	haksang.getCalculator().div(5, 2);
	
	// 사용한 자원 반납 (생략 가능)
	ctx.close();
		
	}

}
