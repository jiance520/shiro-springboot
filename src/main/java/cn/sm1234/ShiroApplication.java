package cn.sm1234;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//springboot自带tomcat插件，所以启动springboot，只需要在启动类上加注解@SpringBootApplication。
@SpringBootApplication
public class ShiroApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShiroApplication.class, args);
	}
}
