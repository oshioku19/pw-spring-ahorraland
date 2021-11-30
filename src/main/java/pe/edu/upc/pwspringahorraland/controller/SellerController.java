package pe.edu.upc.pwspringahorraland.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.pwspringahorraland.business.crud.CategoryService;
import pe.edu.upc.pwspringahorraland.business.crud.ConsumerService;
import pe.edu.upc.pwspringahorraland.business.crud.SellerService;
import pe.edu.upc.pwspringahorraland.models.entity.Category;
import pe.edu.upc.pwspringahorraland.models.entity.Complaint;
import pe.edu.upc.pwspringahorraland.models.entity.Consumer;
import pe.edu.upc.pwspringahorraland.models.entity.Seller;
import pe.edu.upc.pwspringahorraland.models.entity.Status;
import pe.edu.upc.pwspringahorraland.utils.ProductSearch;

@Controller
@RequestMapping("/seller")
public class SellerController {
    
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping
    public String cart(Model model, @ModelAttribute("category") Category category, @ModelAttribute("productSearch") ProductSearch productSearch) {
        return "seller/seller";
    }
    
    @GetMapping("/help")
    public String help(Model model, @ModelAttribute("category") Category category, @ModelAttribute("productSearch") ProductSearch productSearch) {
        return "seller/help";
    }
    
    @Autowired
    private SellerService sellerService;

    @GetMapping ("/seller/list")// GET: /apartments
    public String listar(Model model, @ModelAttribute("category") Category category, @ModelAttribute("productSearch") ProductSearch productSearch) {
        try {
            List<Seller> sellers = sellerService.getAll();
            model.addAttribute("sellers", sellers);    
            model.addAttribute("listCategories", categoryService.getAll());
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

        return "complaints/lista";
    }
}