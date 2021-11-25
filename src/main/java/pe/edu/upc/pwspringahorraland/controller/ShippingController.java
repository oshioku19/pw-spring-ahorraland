package pe.edu.upc.pwspringahorraland.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.pwspringahorraland.business.crud.DeliveryManService;
import pe.edu.upc.pwspringahorraland.business.crud.ShippingService;
import pe.edu.upc.pwspringahorraland.models.entity.DeliveryMan;
import pe.edu.upc.pwspringahorraland.models.entity.Shipping;

@Controller
@RequestMapping("/shipping")
public class ShippingController {
	
	@Autowired 
	private ShippingService shippingService;
	
	@Autowired
	private DeliveryManService deliveryManService;
	
	
	@GetMapping
	public String listShipping(Model model) {
		try {
			List<Shipping> shippings = shippingService.getAll();
			model.addAttribute("deliveryMans",shippings);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "shipping/shipping";
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
	
	@PostMapping("saveNew")
	public String saveShipping(Model model, @ModelAttribute("shipping") Shipping shipping) {
		System.out.println(shipping.getDirection());
		try {
			model.addAttribute("shipping", new Shipping());
			Shipping shippingSaved = shippingService.create(shipping);
			model.addAttribute("shipping", shippingSaved);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "deliveryman/DeliveryMan";
	}
}
