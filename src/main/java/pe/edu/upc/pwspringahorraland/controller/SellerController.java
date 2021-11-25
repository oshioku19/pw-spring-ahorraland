package pe.edu.upc.pwspringahorraland.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.pwspringahorraland.business.crud.ConsumerService;
import pe.edu.upc.pwspringahorraland.business.crud.SellerService;
import pe.edu.upc.pwspringahorraland.models.entity.Complaint;
import pe.edu.upc.pwspringahorraland.models.entity.Consumer;
import pe.edu.upc.pwspringahorraland.models.entity.Seller;
import pe.edu.upc.pwspringahorraland.models.entity.Status;

@Controller
@RequestMapping("/seller")
public class SellerController {
	@GetMapping
	public String cart() {
		return "seller/seller";
	}
	
	@GetMapping("/help")
	public String help() {
		return "seller/help";
	}
	
	@Autowired
	private SellerService sellerService;

	@GetMapping ("/seller/list")// GET: /apartments
	public String listar(Model model) {
		try {
			List<Seller> sellers = sellerService.getAll();
			model.addAttribute("sellers", sellers);			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "complaints/lista";
	}
}