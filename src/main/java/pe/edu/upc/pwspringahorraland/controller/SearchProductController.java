package pe.edu.upc.pwspringahorraland.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.pwspringahorraland.business.crud.CategoryService;
import pe.edu.upc.pwspringahorraland.business.crud.ProductService;
import pe.edu.upc.pwspringahorraland.models.entity.Category;
import pe.edu.upc.pwspringahorraland.models.entity.Product;
import pe.edu.upc.pwspringahorraland.utils.ProductSearch;

@Controller
@RequestMapping("/Search")
public class SearchProductController {
	
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@PostMapping("products")
	public String searchProducts(Model model, @ModelAttribute("productSearch") ProductSearch productSearch ) throws Exception {
		
		List<Product> products = new ArrayList<>();
		
		try {
			products= productService.findByNameContaining(productSearch.getName());
			products=productService.findByPrice(productSearch.getPrice());
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
		
	

}

