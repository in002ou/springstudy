package com.gdu.app02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gdu.app02.domain.Bbs;

@Configuration
public class AppContext {
	
	@Bean
	public Bbs bbs2() {
		return new Bbs(2, "살랴죠", "2023-04-13");
	}
	
}
