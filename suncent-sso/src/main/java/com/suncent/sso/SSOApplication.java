package com.suncent.sso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.suncent.sso.mapper")
@SpringBootApplication
public class SSOApplication {
	public static void main(String[] args) {
		SpringApplication.run(SSOApplication.class, args);
	}
}
