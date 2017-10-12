package grokwich.springboot.web.thymeleaf.validation.command;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

import lombok.Data;

@Data
public class FormCommand {
	
	// textField messages are configured/handled by ValidationMessages.
	@Size.List({
        @Size(min = 5, message = "{fooCommand.textField.min.message}"),
        @Size(max = 20, message = "{fooCommand.textField.max.message}")
    })	
	@Email(message = "{fooCommand.textField.email.message}")
	String textField;
	
	
	// textareaField messages are configured/handled by messages.properties.
	@Size(min=3, max=50)
	String textareaField;
	
}
