package grokwich.springboot.web.thymeleaf.validation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import grokwich.springboot.web.thymeleaf.validation.command.FormCommand;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@RunWith(SpringRunner.class)
@WebMvcTest
public class WebThymeleafFormsApplicationTests {

	@Autowired
    private MockMvc mockMvc;

    @Test
    public void fooFormTest() throws Exception {
		mockMvc.perform(get("/fooform"))
			.andExpect(model().attribute("command", any(FormCommand.class)))
			.andExpect(view().name("fooForm"))
			.andExpect(status().isOk());
	}

	
	@Test
	public void happyPostTest() throws Exception {
		final String textFieldValue = "foo@bar.com";
		final String textareaFieldValue = "This is a couple of lines\nof content.";
		
		mockMvc
			.perform(post("/fooform")
				.param("textField", textFieldValue) 
				.param("textareaField", textareaFieldValue) 
				.contentType(MediaType.APPLICATION_FORM_URLENCODED))
			.andExpect(status().is3xxRedirection())
			.andExpect(flash().attribute("command", hasProperty("textField", equalTo(textFieldValue))))
			.andExpect(flash().attribute("command", hasProperty("textareaField", equalTo(textareaFieldValue))));
	}
	
	
	@Test
	public void emptyFieldsTest() throws Exception {
		final String textFieldValue = "";
		final String textareaFieldValue = "";
		
		mockMvc
			.perform(post("/fooform")
				.param("textField", textFieldValue) 
				.param("textareaField", textareaFieldValue) 
				.contentType(MediaType.APPLICATION_FORM_URLENCODED))
			.andExpect(status().isOk())
			.andExpect(content().string(
	                allOf(
	                        containsString("The Text Field is empty, but the length must be at least 5 characters"),
	                        containsString("The Textarea Field must have at least 3 characters, but no mare than 50")
	                    )
	                )
	            );
	}	
}
