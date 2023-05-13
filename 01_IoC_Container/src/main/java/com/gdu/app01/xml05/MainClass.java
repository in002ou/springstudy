package com.gdu.app01.xml05;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml05/app-context.xml");
		
		Person person = ctx.getBean("p", Person.class);
		
		for(int i = 0; i < person.getHobbies().size(); i++) {
			System.out.println(person.getHobbies().get(i));
		}
		Set<String> contacts = person.getContacts();
		for(String contact : contacts) {
			System.out.println(contact);
		}
		Map<String, String> friends = person.getFriends();
		for(Entry<String, String> entry : friends.entrySet()) {
			System.out.println(entry.getKey() + ", " + entry.getValue());
		}
		ctx.close();
		
	}

}
