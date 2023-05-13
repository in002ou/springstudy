package com.gdu.app03.service;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdu.app03.domain.Person;

public class FirstServiceImpl implements IFirstService {

	@Override
	public Person execute1(HttpServletRequest request, HttpServletResponse response) {
		
		// 예외 발생 시 예외 메시지를 화면으로 전달하기
		try {
			String name = request.getParameter("name");
			name = name.isEmpty() ? "홍길동" : name; // 사용자가 입력한 name이 없으면 빈 문자열이 전달
			
			String strAge = request.getParameter("age");
			strAge = strAge.isEmpty() ? "0" : strAge;
			int age = Integer.parseInt(strAge);
			// 0~100 범위를 벗어난 경우 예외 발생 시키기
			if(age < 0 || age > 100) {
				throw new RuntimeException("나이는 0보다 작거나 100보다 클 수 없습니다.");
			}
			return new Person(name, age);		// $.ajax의 success로 넘기는 데이터
			
		} catch(Exception e) {
			try {
				response.setContentType("text/plain; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println(e.getMessage());	// $.ajax의 error로 넘기는 예외 메시지
				out.flush();
				out.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
			return null;
		}
	}

	@Override
	public Map<String, Object> execute2(String name, int age) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("age", age);
		return map;
	}
	
	@Override
	public Map<String, Object> execute3(Person person) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", person.getName());
		map.put("age", person.getAge());
		return map;
	}
	
}
