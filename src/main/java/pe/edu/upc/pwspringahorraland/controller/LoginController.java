package pe.edu.upc.pwspringahorraland.controller;


import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.pwspringahorraland.business.crud.ConsumerService;
import pe.edu.upc.pwspringahorraland.business.crud.UserService;
import pe.edu.upc.pwspringahorraland.models.entity.Consumer;
import pe.edu.upc.pwspringahorraland.models.entity.Seller;
import pe.edu.upc.pwspringahorraland.models.entity.Users;

@Controller
@RequestMapping
public class LoginController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ConsumerService consumerService;

	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model, Principal principal,
			RedirectAttributes flash) {

		if (principal != null) {
			return "home";
		}

		if (error != null) {
			model.addAttribute("error",
					"Error en el login: Nombre de usuario o contraseña incorrecta, por favor vuelva a intentarlo!!!!!!");
		}

		if (logout != null) {
			model.addAttribute("success", "Ha cerrado sesión con éxito!");
			return "login";
		}
		return "login";
		
	}
	
	@GetMapping("/login/new")
	public String newUser(Model model) {
		model.addAttribute("users", new Users());
		model.addAttribute("userconsumer", new Consumer());
		return "RegistroConsumer";
	}
	
	@PostMapping("/login/save")
	public String saveUser(@ModelAttribute("users") @Valid Users user, BindingResult result, Model model)
			throws Exception {
		if (result.hasErrors()) {
			return "usuarios/user";
		} else {
			String bcryptPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(bcryptPassword);
			int rpta = userService.insert_seller(user);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				model.addAttribute("newUser", new Users());
				return "RegistroSeller";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
			}
		}
		return "redirect:/seller/new";
	}
	
	@GetMapping("/login/newconsumer")
	public String newUserFreelancer(Model model) {
		model.addAttribute("usuario", new Users());
		model.addAttribute("newConsumidor", new Consumer());
		return "RegistroConsumer";
	}
	
	@PostMapping("/login/saveconsumer")
	public String saveUserFreelancer(@ModelAttribute("userconsumer") @Valid Consumer consumer, BindingResult result, Model model)
			throws Exception {
		if (result.hasErrors()) {
			return "usuarios/user";
		} else {
			String bcryptPassword = passwordEncoder.encode(consumer.getUsers().getPassword());
			consumer.getUsers().setPassword(bcryptPassword);
			int rpta = consumerService.insert(consumer);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				model.addAttribute("userconsumer", new Consumer());
				return "RegistroConsumer";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
			}
		}
		return "redirect:/login";
	}
	
}

