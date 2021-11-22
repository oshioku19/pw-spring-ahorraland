package pe.edu.upc.pwspringahorraland.controller;

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

import pe.edu.upc.pwspringahorraland.business.crud.CartService;
import pe.edu.upc.pwspringahorraland.business.crud.PaymentTypeService;
import pe.edu.upc.pwspringahorraland.business.crud.SaleService;
import pe.edu.upc.pwspringahorraland.models.entity.Cart;
import pe.edu.upc.pwspringahorraland.models.entity.PaymentType;
import pe.edu.upc.pwspringahorraland.models.entity.Sale;

@Controller
@RequestMapping("/cart")
@SessionAttributes("{cart}")
public class CartController {
	@Autowired
	private CartService cartService;

	@Autowired
	private SaleService saleService;
	
	@Autowired
	private PaymentTypeService paymentService;
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
	
	@GetMapping("/removeAll")
	public String remove(Model model) {
		cartService.deleteCart();
		return "redirect:/cart";
	}
	
	@GetMapping("{id}/sale")
	public String sale (Model model,@PathVariable("id") Integer id) {
			
		try {
			List<Cart> carts= cartService.getAll();
			if(saleService.existsById(id)) {
			Optional<Sale>optional= saleService.findById(id);
			List<PaymentType> payments= paymentService.getAll();
			model.addAttribute("sale", optional.get());
			model.addAttribute("carts", carts);
			model.addAttribute("payments", payments);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return "Cart2";
	}
	
	@PostMapping("savesale")
	public String saveSale(Model model, @ModelAttribute("sale") Sale sale ) {
		
		try {
			Sale saleSaved = saleService.update(sale);
			model.addAttribute("sale",saleSaved);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return"redirect:/";
	}
	
}
