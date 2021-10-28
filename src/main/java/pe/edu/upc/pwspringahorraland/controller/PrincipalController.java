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

	
	@GetMapping("deliveryman")
	public String deliveryman() {
		return "DeliveryMan";
	}
	
	@GetMapping("profile")
	public String profile() {
		return "Profile";
	}
	
	
	@GetMapping("a1")
	public String Abarrotes() {
		return "categorias/abarrotes";
	}
	@GetMapping("Enlatados")
	public String Enlatados() {
		return "categorias/Enlatados";
	}
	@GetMapping("lacteos")
	public String lacteos() {
		return "categorias/lacteos";
	}
	
	
}
