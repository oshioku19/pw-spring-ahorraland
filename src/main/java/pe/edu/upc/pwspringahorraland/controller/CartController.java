package pe.edu.upc.pwspringahorraland.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.pwspringahorraland.business.crud.CartService;
import pe.edu.upc.pwspringahorraland.business.crud.ProductService;
import pe.edu.upc.pwspringahorraland.business.crud.SaleService;
import pe.edu.upc.pwspringahorraland.models.entity.Cart;
import pe.edu.upc.pwspringahorraland.models.entity.Product;
import pe.edu.upc.pwspringahorraland.models.entity.Sale;

@Controller
@RequestMapping("/cart")
@SessionAttributes("{cart}")
public class CartController {
	@Autowired
	private CartService cartService;

	@Autowired
	private ProductService productService;

	@Autowired
	private SaleService saleService;
	

	@GetMapping
	public String cart(Model model) {
		
		try {
			List<Sale>sales= saleService.getAll();
			List<Cart> carts= cartService.getAll();
			model.addAttribute("sales", sales);
			model.addAttribute("carts", carts);
		}catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "Cart";
	}

	
	@GetMapping("{id}/del")
	public String delete(Model model, @PathVariable("id")Integer id) {
		cartService.deleteBySaleIdAndProductId(1, id);	
		return "redirect:/cart";

	}
	
	
}
