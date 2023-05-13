package com.gdu.app01.xml03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml03/app-context.xml");
		
		Board board = ctx.getBean("board", Board.class);
		System.out.println(board.getTitle());
		System.out.println(board.getContent());
		System.out.println(board.getWriter().getId());
		System.out.println(board.getWriter().getName());
		
		ctx.close();
		
	}

}
