package grokwich.springbootcore.groovyjoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean

import grokwich.springbootcore.groovyjoint.beans.GroovyBeanD


@SpringBootApplication
public class GroovyJointApplication {
		
	public static void main(String[] args) {
		def context = SpringApplication.run(GroovyJointApplication.class, args)
		
		def bean = context.getBean("beanX")
		
		println bean.msg()
	}
	
	
	@Bean 
	def beanX() {
		return new GroovyBeanD()
	} 
	
	
}
