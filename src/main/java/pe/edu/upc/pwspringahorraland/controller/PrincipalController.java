package pe.edu.upc.pwspringahorraland.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PrincipalController {

	@GetMapping
	public String home() {
		return "home";
	}
	
	@GetMapping("file")
	public String file() {
		return "NewFile";
	}
	
}
