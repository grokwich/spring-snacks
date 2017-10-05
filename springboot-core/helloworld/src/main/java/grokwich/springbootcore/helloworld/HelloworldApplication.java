package grokwich.springbootcore.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelloworldApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HelloworldApplication.class, args);
		
		TestBean bean = context.getBean(TestBean.class);
		
		System.out.println( bean.getMessage() );
	}
	
	static class TestBean {
		String getMessage() {
			return "Hello World!";
		}
	}
	
	@Bean
	TestBean getBean() {
		return new TestBean();
	}
}
