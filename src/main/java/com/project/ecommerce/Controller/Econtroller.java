package com.project.ecommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.ecommerce.Model.Cartuser;
import com.project.ecommerce.Model.Euser;
import com.project.ecommerce.Model.Feedback;
import com.project.ecommerce.Model.Signup;
import com.project.ecommerce.Service.Eservice;
import com.project.ecommerce.Service.Signservice;
import com.project.ecommerce.Service.cartservice;
import com.project.ecommerce.Service.feedservice;

import jakarta.servlet.http.HttpSession;

@Controller
public class Econtroller {

    @Autowired
    Eservice server;

    @Autowired
    feedservice feedback;

    @Autowired
    Signservice serving;

    @Autowired
    cartservice serv;

    @GetMapping("/admin")
    public String adminHome() {
        return "admin";
    }

    @GetMapping("/productcart")
    public String prod() {
        return "productcart";
    }

    @GetMapping("/categories")
    public String getCategories(Model model) {
        List<Euser> use = server.findAll();
        model.addAttribute("data", use);
        return "/categories";
    }

    @RequestMapping("")
    public String catog(Model mod) {
        return "categories";
    }

    @GetMapping("/add")
    public String getCatAdd(@ModelAttribute Euser user, Model model) {
        return "Addproduct";
    }

    @PostMapping("/add")
    public String postCatAdd(@ModelAttribute Euser user, Model mod) {
        server.Add(user);
        return "redirect:/categories";
    }

    @GetMapping("/controller/{id}")
    public String identity() {
        return "categories";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        server.deleteById(id);
        model.addAttribute("data", server.findAll());
        return "categories";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Euser user) {
        server.Add(user);
        return "redirect:/categories";
    }

    @GetMapping("/update/{id}")
    public String updateById(@PathVariable int id, Model model) {
        Euser u = server.getById(id);
        model.addAttribute("updatedata", u);
        return "updateproduct";
    }

    // for page linking
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/shop")
    public String shop() {
        return "shop";
    }

    @GetMapping("/blog")
    public String blog() {
        return "blog";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/sproduct")
    public String sproduct() {
        return "sproduct";
    }

    @GetMapping("/feedback")
    public String feed(@ModelAttribute Feedback feed, Model model) {
        model.addAttribute("data", feed.getName());
        model.addAttribute("data", feed.getEmail());
        model.addAttribute("data", feed.getSubject());
        model.addAttribute("data", feed.getFeedback());
        feedback.save(feed);
        return "redirect:/";
    }

    @PostMapping("/Addcart/{price}/{productname}/{quantity}")
    public String addToCart(
            @RequestParam("imgurl") String imgurl,
            @PathVariable String price,
            @PathVariable String productname,
            @PathVariable String quantity,
            @ModelAttribute Cartuser cart,
            Model model,
            HttpSession session) {
        Cartuser c = new Cartuser();
        c.setImgurl(imgurl);
        c.setPrice(price);
        c.setProductname(productname);
        c.setQuantity(quantity);
        model.addAttribute("data", serv.add(cart));
        serv.addToCart(c, session); // Add cart item to the user's session cart
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String showCart(@ModelAttribute Cartuser cartuse, HttpSession session,
            Model model) {
        List<Cartuser> cartData = serv.getCartItems(session); // Retrieve cart items
        // specific to the user's session
        model.addAttribute("data", cartData);

        return "cart";
    }

    @GetMapping("/del/{id}")
    public String deleteCartItem(@PathVariable int id, HttpSession session, Model model) {
        serv.removeFromCart(id, session); // Remove cart item from the user's session
        model.addAttribute("data", serv.findById(id));
        return "redirect:/cart";
    }

    @GetMapping("/deletedata/{id}")
    public String del(@PathVariable int id, Model model) {
        model.addAttribute("data", serv.findById(id));
        serv.deleteById(id);
        return "redirect:/cart";
    }

    @GetMapping("/signin")
    public String getusers(@ModelAttribute Signup user, Model model) {

        serving.Add(user);
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String getRegister(Model model) {
        List<Signup> use = serving.findAll();
        model.addAttribute("data", use);
        model.addAttribute("data", serving.Addd(use));
        return "signup";
    }

    @PostMapping("/registerUser")
    public String postCatAdd(@ModelAttribute Signup user, Model mod) {
        serving.Add(user);
        return "redirect:/";
    }

}
