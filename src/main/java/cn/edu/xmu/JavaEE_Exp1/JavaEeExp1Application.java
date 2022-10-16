package cn.edu.xmu.JavaEE_Exp1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.edu.xmu.JavaEE_Exp1.mapper")
public class JavaEeExp1Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaEeExp1Application.class, args);
	}

}
