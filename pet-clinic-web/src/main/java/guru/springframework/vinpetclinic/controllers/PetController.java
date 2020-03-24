package guru.springframework.vinpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PetController {
	
	@RequestMapping({"/pets","/pets/index","/pets/index.html"})
	public String index() {
		return "pets/index";
	}
}
