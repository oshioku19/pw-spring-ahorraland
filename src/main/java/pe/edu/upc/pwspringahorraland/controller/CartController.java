package pe.edu.upc.pwspringahorraland.controller;

import java.io.Console;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ch.qos.logback.core.ConsoleAppender;
import pe.edu.upc.pwspringahorraland.business.crud.CartService;
import pe.edu.upc.pwspringahorraland.business.crud.CategoryService;
import pe.edu.upc.pwspringahorraland.business.crud.ConsumerService;
import pe.edu.upc.pwspringahorraland.business.crud.PaymentTypeService;
import pe.edu.upc.pwspringahorraland.business.crud.SaleService;
import pe.edu.upc.pwspringahorraland.business.crud.ShippingService;
import pe.edu.upc.pwspringahorraland.models.entity.Cart;
import pe.edu.upc.pwspringahorraland.models.entity.Category;
import pe.edu.upc.pwspringahorraland.models.entity.Consumer;
import pe.edu.upc.pwspringahorraland.models.entity.PaymentType;
import pe.edu.upc.pwspringahorraland.models.entity.Sale;
import pe.edu.upc.pwspringahorraland.models.entity.Shipping;
import pe.edu.upc.pwspringahorraland.utils.ProductSearch;

@Controller
@RequestMapping("/cart")
@SessionAttributes("{cart,sale}")
public class CartController {
	@Autowired
	private CartService cartService;

	@Autowired
	private SaleService saleService;
	
	@Autowired
	private PaymentTypeService paymentService;
	
	@Autowired
	private ConsumerService consumerService;
	
	@Autowired
	private ShippingService shippingService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public String cart(Model model,@ModelAttribute("category") Category category,  @ModelAttribute("productSearch") ProductSearch productSearch) {
		
		try {				
			List<Sale>sales= saleService.getAll();
			List<Cart> carts= cartService.getAll();
			model.addAttribute("sales", sales);
			model.addAttribute("carts", carts);
			model.addAttribute("listCategories", categoryService.getAll());
			model.addAttribute("productSearch", productSearch);
			
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
	
	@GetMapping("/removeAll")
	public String remove(Model model) {
		cartService.deleteCart();
		return "redirect:/cart";
	}
	
	
	@GetMapping("{id}/sale")
	public String sale (Model model,@PathVariable("id") Integer id,
			@ModelAttribute("paymentType") PaymentType paymentType, @ModelAttribute("category") Category category,  @ModelAttribute("productSearch") ProductSearch productSearch) {
			
		try {			
			Optional<Sale>optional= saleService.findById(id);
			List<PaymentType> paymentTypes= paymentService.getAll();
			List<Consumer> consumers= consumerService.getAll();
			List<Shipping> shippings= shippingService.getAll();
			model.addAttribute("sale", optional.get());
			model.addAttribute("paymentTypes", paymentTypes);
			model.addAttribute("consumers", consumers);
			model.addAttribute("shippings", shippings);
			model.addAttribute("listCategories", categoryService.getAll());
			model.addAttribute("productSearch", productSearch);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}		
		return "Cart2";
	}
	
	@PostMapping("savesale")
	public String saveSale(Model model, @ModelAttribute("sale") Sale sale , @ModelAttribute("category") Category category,  @ModelAttribute("productSearch") ProductSearch productSearch) {
		
		try {
			Sale saleSaved = saleService.update(sale);
			model.addAttribute("sale",saleSaved);
			model.addAttribute("listCategories", categoryService.getAll());
			model.addAttribute("productSearch", productSearch);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return"redirect:/";
	}
	
}
