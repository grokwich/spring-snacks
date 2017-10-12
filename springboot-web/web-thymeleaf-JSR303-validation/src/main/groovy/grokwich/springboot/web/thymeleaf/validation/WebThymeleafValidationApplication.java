package grokwich.springboot.web.thymeleaf.validation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import grokwich.springboot.web.thymeleaf.validation.WebThymeleafValidationApplication;


@SpringBootApplication
public class WebThymeleafValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run( WebThymeleafValidationApplication.class, args );
	}
	
	
/* 
	If it was really important to you that JSR-303 validation messages be stored in messages.properties
	(rather that the default ValidationMessages.properties), 
	then you could do the following...
		
    @Autowired
    private MessageSource messageSource;
    
	@Override
    public Validator getValidator() {
        LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
        factory.setValidationMessageSource(messageSource);
        return factory;
    }		 
 */
	
}
