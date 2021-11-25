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

import pe.edu.upc.pwspringahorraland.business.crud.CategoryService;
import pe.edu.upc.pwspringahorraland.business.crud.ConsumerService;
import pe.edu.upc.pwspringahorraland.business.crud.SellerService;
import pe.edu.upc.pwspringahorraland.business.crud.UserService;
import pe.edu.upc.pwspringahorraland.models.entity.Category;
import pe.edu.upc.pwspringahorraland.models.entity.Consumer;
import pe.edu.upc.pwspringahorraland.models.entity.Seller;
import pe.edu.upc.pwspringahorraland.models.entity.Users;
import pe.edu.upc.pwspringahorraland.utils.ProductSearch;

@Controller
@RequestMapping
public class LoginController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private ConsumerService consumerService;
	
	@Autowired
	private CategoryService categoryService;

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
	
	
	
	@GetMapping("/login/newconsumer")
	public String newUserConsumer(Model model) {
		model.addAttribute("usuario", new Users());
		model.addAttribute("userconsumer", new Consumer());
		return "RegistroConsumer";
	}
	
	@GetMapping("/login/newseller")
	public String newUserSeller(Model model) {
		model.addAttribute("usuario", new Users());
		model.addAttribute("userseller", new Seller());
		return "RegistroSeller";
	}
	
	
	@PostMapping("/login/saveconsumer")
	public String saveUserConsumer(@ModelAttribute("userconsumer") @Valid Consumer consumer, BindingResult result, Model model, @ModelAttribute("category") Category category,  @ModelAttribute("productSearch") ProductSearch productSearch)
			throws Exception {
		if (result.hasErrors()) {
			return "/RegistroConsumer";
		} else {
			String bcryptPassword = passwordEncoder.encode(consumer.getUsers().getPassword());
			consumer.getUsers().setPassword(bcryptPassword);
			int rpta = consumerService.insert(consumer);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				model.addAttribute("userconsumer", new Consumer());
				model.addAttribute("listCategories", categoryService.getAll());
				model.addAttribute("productSearch", productSearch);
				return "/RegistroConsumer";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
			}
		}
		return "redirect:/login";
	}
	
	@PostMapping("/login/saveseller")
	public String saveUserSeller(@ModelAttribute("userseller") @Valid Seller seller, BindingResult result, Model model, @ModelAttribute("category") Category category,  @ModelAttribute("productSearch") ProductSearch productSearch)
			throws Exception {
		if (result.hasErrors()) {
			return "/RegistroSeller";
		} else {
			String bcryptPassword = passwordEncoder.encode(seller.getUsers().getPassword());
			seller.getUsers().setPassword(bcryptPassword);
			int rpta = sellerService.insert(seller);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				model.addAttribute("userseller", new Seller());
				model.addAttribute("listCategories", categoryService.getAll());
				model.addAttribute("productSearch", productSearch);
				return "RegistroSeller";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
			}
		}
		return "redirect:/login";
	}
	
	
	
	
}

