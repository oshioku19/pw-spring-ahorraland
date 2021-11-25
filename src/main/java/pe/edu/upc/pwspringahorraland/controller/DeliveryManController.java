package pe.edu.upc.pwspringahorraland.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.pwspringahorraland.business.crud.CategoryService;
import pe.edu.upc.pwspringahorraland.business.crud.DeliveryManService;
import pe.edu.upc.pwspringahorraland.business.crud.ShippingService;
import pe.edu.upc.pwspringahorraland.models.entity.Category;
import pe.edu.upc.pwspringahorraland.models.entity.DeliveryMan;
import pe.edu.upc.pwspringahorraland.models.entity.Shipping;
import pe.edu.upc.pwspringahorraland.utils.DeliveryManSearch;
import pe.edu.upc.pwspringahorraland.utils.ProductSearch;

@Controller
@RequestMapping("/deliveryman")
public class DeliveryManController {
	
	@Autowired
	private DeliveryManService deliveryManService;
	
	@Autowired
	private ShippingService shippingService;
	
	@Autowired
	private CategoryService categoryService;
	
	
	@GetMapping
	public String list(Model model,  @ModelAttribute("category") Category category, @ModelAttribute("productSearch") ProductSearch productSearch) {
		try {
			List<DeliveryMan> deliveryMans = deliveryManService.getAll();
			model.addAttribute("deliveryMans",deliveryMans);
			model.addAttribute("listCategories", categoryService.getAll());
			model.addAttribute("productSearch", productSearch);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "deliveryman/DeliveryMan";
	}
	
	
	@GetMapping("/detail/{deliveryManId}")
	public String viewData(Model model, @ModelAttribute("deliveryManSearch") DeliveryManSearch deliveryManSearch,
			@PathVariable("deliveryManId") Integer deliveryManId, @ModelAttribute("category") Category category , @ModelAttribute("productSearch") ProductSearch productSearch) {
		
		try {
			if(deliveryManService.existsById(deliveryManId)) {
				Optional<DeliveryMan> optional = deliveryManService.findById(deliveryManId);
				model.addAttribute("deliveryMan", optional.get());
				model.addAttribute("listCategories", categoryService.getAll());
				model.addAttribute("productSearch", productSearch);
			} else {
				return "redirect:/";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("deliveryManSearch", deliveryManSearch);
		return "deliveryman/detail";
	}
	
	@GetMapping ("new")
	public String newShipping(Model model, @ModelAttribute("category") Category category, @ModelAttribute("productSearch") ProductSearch productSearch) {
		try {
				List<DeliveryMan> deliveryMans = deliveryManService.getAll();	
				model.addAttribute("deliveryMans",deliveryMans);
				model.addAttribute("shipping", new Shipping());
				model.addAttribute("listCategories", categoryService.getAll());
				model.addAttribute("productSearch", productSearch);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "shipping/shipping";
	}
	
	@RequestMapping("saveNew")
	public String saveShipping(Model model, @ModelAttribute("shipping") Shipping shipping, @ModelAttribute("category") Category category, @ModelAttribute("productSearch") ProductSearch productSearch) {
		System.out.println(shipping.getDirection());
		try {
			
			Shipping shippingSaved = shippingService.create(shipping);
			model.addAttribute("shipping", shippingSaved);
			model.addAttribute("listCategories", categoryService.getAll());
			model.addAttribute("productSearch", productSearch);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "shipping/view";
	}
	
	@RequestMapping("map")
	public String mapShipping(Model model, @ModelAttribute("category") Category category, @ModelAttribute("productSearch") ProductSearch productSearch) {
		try {
			List<DeliveryMan> deliveryMans = deliveryManService.getAll();
			model.addAttribute("deliveryMans",deliveryMans);
			model.addAttribute("listCategories", categoryService.getAll());
			model.addAttribute("productSearch", productSearch);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "shipping/status";
	}
}
