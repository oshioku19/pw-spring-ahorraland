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

import pe.edu.upc.pwspringahorraland.business.crud.CategoryService;
import pe.edu.upc.pwspringahorraland.business.crud.ComplaintService;
import pe.edu.upc.pwspringahorraland.business.crud.ConsumerService;
import pe.edu.upc.pwspringahorraland.business.crud.SellerService;
import pe.edu.upc.pwspringahorraland.business.crud.StatusService;
import pe.edu.upc.pwspringahorraland.models.entity.Category;
import pe.edu.upc.pwspringahorraland.models.entity.Complaint;
import pe.edu.upc.pwspringahorraland.models.entity.Consumer;
import pe.edu.upc.pwspringahorraland.models.entity.PaymentType;
import pe.edu.upc.pwspringahorraland.models.entity.Seller;
import pe.edu.upc.pwspringahorraland.models.entity.Status;
import pe.edu.upc.pwspringahorraland.utils.ProductSearch;


@Controller
@RequestMapping()
@SessionAttributes("complaintEdit") 
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @Autowired
    private SellerService sellerService;
    
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/seller/{sellerId}/complaint-replies")
    public String findByIdComplaintListar(Model model, @PathVariable("sellerId") Integer id, @ModelAttribute("category") Category category, @ModelAttribute("productSearch") ProductSearch productSearch) {
        try {
            List<Complaint> complaints = complaintService.listComplaintBySellerId(id);
            model.addAttribute("complaints", complaints);

            Optional<Seller> optional = sellerService.findById(id);
            if (optional.isPresent()) {
                model.addAttribute("seller", optional.get());
                model.addAttribute("listCategories", categoryService.getAll());
                return "/seller/complaint-replies";
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return "redirect:/seller/" + id + "/complaint-replies";
    }

    @GetMapping("/seller/complaint-replies/{complaintRepliesId}")
    public String findById(Model model, @PathVariable("complaintRepliesId") Integer complaintRepliesId,  @ModelAttribute("category") Category category, @ModelAttribute("productSearch") ProductSearch productSearch) {
        try {
            Optional<Complaint> optional = complaintService.findById(complaintRepliesId);
            if (optional.isPresent()) {
                model.addAttribute("complaint", optional.get());
                model.addAttribute("listCategories", categoryService.getAll());
                return "seller/complaint-replies-view";
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return "redirect:/seller/" + complaintRepliesId + "/complaint-replies";
    }
    
}