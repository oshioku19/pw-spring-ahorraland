package pe.edu.upc.pwspringahorraland.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.pwspringahorraland.business.crud.CategoryService;
import pe.edu.upc.pwspringahorraland.business.crud.ProductService;
import pe.edu.upc.pwspringahorraland.business.crud.UserService;
import pe.edu.upc.pwspringahorraland.models.entity.Category;
import pe.edu.upc.pwspringahorraland.models.entity.Users;
import pe.edu.upc.pwspringahorraland.utils.ProductSearch;



@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    private UserService userService;
    

    @Autowired
    private CategoryService categoryService;
    

    @GetMapping("/new")
    public String newAccount(Model model, @ModelAttribute("category") Category category,  @ModelAttribute("productSearch") ProductSearch productSearch) {
        model.addAttribute("users", new Users());
        try {
            model.addAttribute("listCategories", categoryService.getAll());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        model.addAttribute("productSearch", productSearch);
        return "usuarios/user";
    }
    
    @GetMapping("/list")
    public String listUser(Model model, @ModelAttribute("category") Category category,  @ModelAttribute("productSearch") ProductSearch productSearch) {
        try {
            model.addAttribute("user", new Users());
            model.addAttribute("listUser", userService.list());
            model.addAttribute("listCategories", categoryService.getAll());
            model.addAttribute("productSearch", productSearch);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "usuarios/listUser";
    }
    

    @PostMapping("/save")
    public String saveAccount(@ModelAttribute("users") @Validated Users user, BindingResult result, Model model, SessionStatus status) throws Exception {
        if (result.hasErrors()) {
            // return "usuarios/user";
            
        } else {
            String bcryptPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(bcryptPassword);
            int rpta = userService.insert_consumer(user);
            if (rpta > 0) {
                model.addAttribute("mensaje", "Ya existe");
                return "usuarios/user";
            } else {
                model.addAttribute("mensaje", "Se guardó correctamente");
                status.setComplete();
            }
        }
        model.addAttribute("listaUsuarios", userService.list());

        return "redirect:/users/list";
    }
    
    
    @PostMapping("/saveseller")
    public String saveAccountseller(@ModelAttribute("users") @Validated Users user, BindingResult result, Model model, SessionStatus status) throws Exception {
        if (result.hasErrors()) {
            // return "usuarios/user";
            
        } else {
            String bcryptPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(bcryptPassword);
            int rpta = userService.insert_seller(user);
            if (rpta > 0) {
                model.addAttribute("mensaje", "Ya existe");
                return "usuarios/user";
            } else {
                model.addAttribute("mensaje", "Se guardó correctamente");
                status.setComplete();
            }
        }
        model.addAttribute("listaUsuarios", userService.list());

        return "redirect:/users/list";
    }
    
}