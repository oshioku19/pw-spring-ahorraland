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

import pe.edu.upc.pwspringahorraland.business.crud.DeliveryManService;
import pe.edu.upc.pwspringahorraland.business.crud.ShippingService;
import pe.edu.upc.pwspringahorraland.models.entity.DeliveryMan;
import pe.edu.upc.pwspringahorraland.models.entity.Shipping;
import pe.edu.upc.pwspringahorraland.utils.DeliveryManSearch;

@Controller
@RequestMapping("/deliveryman")
public class DeliveryManController {
	
	@Autowired
	private DeliveryManService deliveryManService;
	
	@Autowired
	private ShippingService shippingService;
	
	
	@GetMapping
	public String list(Model model) {
		try {
			List<DeliveryMan> deliveryMans = deliveryManService.getAll();
			model.addAttribute("deliveryMans",deliveryMans);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "deliveryman/DeliveryMan";
	}
	
	
	@GetMapping("/detail/{deliveryManId}")
	public String viewData(Model model, @ModelAttribute("deliveryManSearch") DeliveryManSearch deliveryManSearch,
			@PathVariable("deliveryManId") Integer deliveryManId ) {
		
		try {
			if(deliveryManService.existsById(deliveryManId)) {
				Optional<DeliveryMan> optional = deliveryManService.findById(deliveryManId);
				model.addAttribute("deliveryMan", optional.get());
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
	public String newShipping(Model model) {
		try {
				List<DeliveryMan> deliveryMans = deliveryManService.getAll();	
				model.addAttribute("deliveryMans",deliveryMans);
				model.addAttribute("shipping", new Shipping());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "shipping/shipping";
	}
	
	@RequestMapping("saveNew")
	public String saveShipping(Model model, @ModelAttribute("shipping") Shipping shipping) {
		System.out.println(shipping.getDirection());
		try {
			
			Shipping shippingSaved = shippingService.create(shipping);
			model.addAttribute("shipping", shippingSaved);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "shipping/view";
	}
	
	@RequestMapping("map")
	public String mapShipping(Model model) {
		try {
			List<DeliveryMan> deliveryMans = deliveryManService.getAll();
			model.addAttribute("deliveryMans",deliveryMans);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "shipping/status";
	}
}
