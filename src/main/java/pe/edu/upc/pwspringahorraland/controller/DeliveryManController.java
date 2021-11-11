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
import pe.edu.upc.pwspringahorraland.models.entity.DeliveryMan;
import pe.edu.upc.pwspringahorraland.utils.DeliveryManSearch;

@Controller
@RequestMapping("/deliveryman")
public class DeliveryManController {
	
	@Autowired 
	private DeliveryManService deliveryManService;
	
	
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
		
}
