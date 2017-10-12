package grokwich.springboot.web.thymeleaf.validation.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import grokwich.springboot.web.thymeleaf.validation.command.FormCommand;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class FormController {
	
	@GetMapping("/fooform")
	public String fooForm(Model model) {
		model.addAttribute( "command", new FormCommand());
		
		return "fooForm";
	}
		
	
	@PostMapping("/fooform")
	public String foobarPost(
			@Valid @ModelAttribute("command") FormCommand command,
			// WARN: BindingResult *must* immediately follow the Command (otherwise silent non-validation).
			// https://stackoverflow.com/a/29883178/1626026
			BindingResult bindingResult,   
			Model model,
			RedirectAttributes ra ) {
		
		log.debug("form submission.");
		
		if ( bindingResult.hasErrors() ) {
			return "fooForm";
		}

		ra.addFlashAttribute("command", command);
		
		return "redirect:/fooresult";
	}

	
	@GetMapping("/fooresult")
	public String fooresult(
			@ModelAttribute("command") FormCommand command,
			Model model) {
		
		log.debug( "!!!" + command.toString());
		
		return "fooResult";
	}
	
}

