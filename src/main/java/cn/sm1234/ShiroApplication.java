package cn.sm1234;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//springboot自带tomcat插件，所以启动springboot，只需要在启动类上加注解@SpringBootApplication。
@SpringBootApplication
@MapperScan("cn.sm1234.dao")//重点，只有扫描了dao，才能实例化mapper调用mapper.xml里面的方法！
public class ShiroApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShiroApplication.class, args);
	}
}
