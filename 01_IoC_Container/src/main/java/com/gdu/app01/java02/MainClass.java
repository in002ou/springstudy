package com.gdu.app01.java02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		
		Student student = ctx.getBean("stu", Student.class);
		
		System.out.println(student.getScores());
		System.out.println(student.getAwards());
		System.out.println(student.getContact());
		
		ctx.close();
		
	}

}
