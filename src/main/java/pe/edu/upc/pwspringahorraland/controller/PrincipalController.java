package pe.edu.upc.pwspringahorraland.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.pwspringahorraland.business.crud.CategoryService;
import pe.edu.upc.pwspringahorraland.business.crud.ProductService;
import pe.edu.upc.pwspringahorraland.models.entity.Category;
import pe.edu.upc.pwspringahorraland.models.entity.Product;
import pe.edu.upc.pwspringahorraland.utils.ProductSearch;

@Controller
@RequestMapping("/")
public class PrincipalController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public String home(Model model) {
		ProductSearch productSearch = new ProductSearch();
		model.addAttribute("productSearch", productSearch);
		try {
			List<Product> products = productService.getAll();
			model.addAttribute("products", products);
			model.addAttribute("category", new Category());
			model.addAttribute("listCategories", categoryService.getAll());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "home";
	}

	@PostMapping("products")
	public String searchProducts(Model model, @ModelAttribute("productSearch") ProductSearch productSearch)
			throws Exception {

		List<Product> products = new ArrayList<>();

		try {
			products = productService.findByNameContaining(productSearch.getName());
			products = productService.findByPrice(productSearch.getPrice());
		} catch (Exception e) {
			// TODO: handle exception
		}

		model.addAttribute("productSearch", productSearch);
		model.addAttribute("category", new Category());
		model.addAttribute("products", products);
		model.addAttribute("listCategories", categoryService.getAll());
		return "Products";
	}

	@PostMapping("productsByCategory")
	public String searchProducts(Model model, @ModelAttribute("category") Category category) throws Exception {

		List<Product> products = new ArrayList<>();

		try {
			products = productService.findByCategory(category.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}

		model.addAttribute("productSearch", new ProductSearch());
		model.addAttribute("category", category);
		model.addAttribute("products", products);
		model.addAttribute("listCategories", categoryService.getAll());
		return "Products";
	}

	// --@GetMapping("shipping")
	// --public String shipping() {
	// --return "Shipping";
	// --}

	@GetMapping("status")
	public String status() {
		return "shipping/status";
	}

	@GetMapping("profile")
	public String profile() {
		return "Profile";
	}

}
