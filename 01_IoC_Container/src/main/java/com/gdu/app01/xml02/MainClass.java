package com.gdu.app01.xml02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml02/app-context.xml");
		
		Academy academy = ctx.getBean("academy", Academy.class);
		
		System.out.println("이름 : " + academy.getName());
		System.out.println("도로명 : " + academy.getAddress().getRoad());
		System.out.println("지번 : " + academy.getAddress().getRand());
		System.out.println("전화 : " + academy.getAddress().getContact().getPhone());
		System.out.println("팩스 : " + academy.getAddress().getContact().getFax());
		
		ctx.close();
		
	}

}
