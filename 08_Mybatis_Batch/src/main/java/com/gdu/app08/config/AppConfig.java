package com.gdu.app08.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.gdu.app08.batch.BoardCountAlertScheduler;

@EnableScheduling
@Configuration
public class AppConfig {

//	@Bean
//	public BoardCountAlertScheduler	boardCountAlertScheduler() {
//		return new BoardCountAlertScheduler();
//	}
	
}
