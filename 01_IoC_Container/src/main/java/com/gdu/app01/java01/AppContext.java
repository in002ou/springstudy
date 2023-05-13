package com.gdu.app01.java01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

	// Bean을 만들고 싶으면 메소드를 만들면 됩니다. (Bean 하나 = 메소드 하나)
	
	/*
		@Bean
		안녕. 난 Bean을 만드느 메소드야.
		반환타입이 Bean의 타입(<bean> 태그의 class 속성)이고,
		메소드명이 Bean의 이름(<bean> 태그의 id 속성)이다.
		java, xml 둘 다 공부하래-.-
	*/
	@Bean
	public Contact contact1() {		// <bean id="contact1" class="Contact">
		Contact c = new Contact();	// default constructor
		c.setTel("02-0022-2200");	// setter -> <property name="tel" value="02-0022-2200" />
		c.setFax("20-2200-0022");	// setter -> <property name="fax" value="20-2200-0022" />
		return c;					// 반환한 객체 c가 Spring Container에 저장된다.
	}
	
	@Bean
	public User user1() {			// <bean id="user1" class="User">
		User u = new User();		// default constructor
		u.setId("spider");			// setter <property name="id" value="spider" />
		u.setContact(contact1());	// setter <property name="contact" ref="contact1" />
		return u;					// 반환한 객체 u가 Spring Container에 저장된다.
	}
	
	// contact2, user2 빈을 constructor를 이용해서 만들어 보세요. 그리고 MainClass에서 확인하세요.
	@Bean(name="contact2")		// name 속성이 추가되면 Bean의 id로 사용된다.
	public Contact num() {	// name 속성이 사용되었으므로 메소드명은 더 이상 Bean의 id가 아니다.
		return new Contact("02-333-3333", "02-444-4444");
	}
	@Bean(name="user2")		// name 속성이 추가되면 Bean의 id로 사용된다.
	public User looser() {	// name 속성이 사용되었으므로 메소드명은 더 이상 Bean의 id가 아니다.
		return new User("superman", num());
	}
	
}
