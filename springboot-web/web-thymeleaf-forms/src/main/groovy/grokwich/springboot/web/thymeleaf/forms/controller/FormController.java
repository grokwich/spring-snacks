package grokwich.springboot.web.thymeleaf.forms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import grokwich.springboot.web.thymeleaf.forms.command.FormCommand;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class FormController {
	
	@GetMapping("/fooform")
	public String fooForm(Model model) {
		model.addAttribute( "command", new FormCommand());
		
		return "fooForm";
	}
	
	@ModelAttribute("multiCheckboxAllValues")
    public String[] getMultiCheckboxAllValues() {
        return new String[] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    }
	
	
	// set of values applied to a single-select radio button set, and drop-down list.
	@ModelAttribute("singleSelectAllValues")
    public String[] getSingleSelectAllValues() {
        return new String[] {"YES", "NO", "MAYBE"};
    }
	
	
	@PostMapping("/fooform")
	public String foobarPost(
			@ModelAttribute("command") FormCommand command,
			// WARN: BindingResult *must* immediately follow the Command.
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

