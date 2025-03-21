package com.springStudy1.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AppConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUsername("project");
		ds.setPassword("1234");
		ds.setUrl("jdbc:mysql://localhost:3306/project");
		return ds;
	}
	@Bean
	public JdbcTemplate jdbc(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
}

/*
  Configuration - 한마디로 스프링 설정 하기 위한 클래스다 라고 메모한것!!
    스프링 프레임워크에서 빈 등록, 의존성 주입, 환경설정을 관리하는 방법
    
    스프링 프레임워크 설정하는 방법은 xml, java기반, annotation 기반이 있다.
  

*/