package grokwich.springboot.web.thymeleaf.forms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import grokwich.springboot.web.thymeleaf.forms.command.FormCommand;

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
	public void fooFormPostTest() throws Exception {
		this.mockMvc
				.perform(post("/fooform")
					.param("textField", "foobar") 
					.contentType(MediaType.APPLICATION_FORM_URLENCODED))
				.andExpect(status().is3xxRedirection())
				.andExpect(flash().attribute("command", hasProperty("textField", equalTo("foobar"))));
	}
}
