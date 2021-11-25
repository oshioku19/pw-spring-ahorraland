package pe.edu.upc.pwspringahorraland.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.pwspringahorraland.business.crud.CartService;
import pe.edu.upc.pwspringahorraland.business.crud.CategoryService;
import pe.edu.upc.pwspringahorraland.business.crud.ProductService;
import pe.edu.upc.pwspringahorraland.models.entity.Cart;
import pe.edu.upc.pwspringahorraland.models.entity.Category;
import pe.edu.upc.pwspringahorraland.models.entity.Product;
import pe.edu.upc.pwspringahorraland.models.entity.Sale;
import pe.edu.upc.pwspringahorraland.utils.ProductSearch;
import pe.edu.upc.pwspringahorraland.utils.RequestCart;

@Controller
@RequestMapping("/")
public class PrincipalController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CartService cartService;
	
	
	
	@GetMapping
	public String home() {
		return "Landing";
	}
	@GetMapping("/home")
	public String home2(Model model) {
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
	
	@GetMapping("{id}/Add")
    public String setCart(Model model, @PathVariable("id") Integer id) {
        try {

            Cart objCart = new Cart();
            Product objProduct = new Product();
            Sale objtSale = new Sale();
            objCart.setQuantity(1);
            objProduct.setId(id);
            objCart.setProduct(objProduct);
            objtSale.setId(1);
            objCart.setSale(objtSale);
            cartService.create(objCart);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

        return "redirect:/home";
    }
    @PostMapping("products/confirm")
    public String confirmSale(Model model, @RequestBody RequestCart body,  @ModelAttribute("category") Category category, @ModelAttribute("productSearch") ProductSearch productSearch) {
        try {
            Cart objCart = new Cart();
            Product objProduct = new Product();
            Sale objtSale = new Sale();

            int quantity =Integer.parseInt(body.getQuantity());
            int price = Integer.parseInt(body.getPartialPrice());
            objCart.setQuantity(quantity);
            objCart.setPartialPrice(price);
            objProduct.setId(Integer.parseInt(body.getProductID()));
            objCart.setProduct(objProduct);
            objtSale.setId(1);
            objCart.setSale(objtSale);
            cartService.create(objCart);
            model.addAttribute("listCategories", categoryService.getAll());
			model.addAttribute("productSearch", productSearch);

        }catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return "redirect:/Cart";
    }

	@GetMapping("/iniciar")
	public String login() {
	    return "login";
	}
	
	@GetMapping("/home1")
	public String Bienvenida() {
	    return "home";
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

	@GetMapping("elegir")
	public String eleccion() {
		return "Eleccion";
	}
}
