package com.project.ecommerce.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.ecommerce.Model.Cartuser;
import com.project.ecommerce.Model.Euser;
import com.project.ecommerce.Model.Feedback;
import com.project.ecommerce.Service.Eservice;
import com.project.ecommerce.Service.cartservice;
import com.project.ecommerce.Service.feedservice;
import com.project.ecommerce.Service.signservice;

// import jakarta.servlet.http.HttpSession;

@Controller
public class Econtroller {

    @Autowired
    Eservice server;

    @Autowired
    feedservice feedback;

    @Autowired
    signservice signup;

    @Autowired
    cartservice serv;

    @GetMapping("/admin")
    public String adminHome() {
        return "admin";
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

    @GetMapping("/addtocart")
    public String addtocart(boolean existingUser) {
        if (existingUser == true) {
            return "addtocart";
        } else {
            return "login";
        }
    }

    @GetMapping("/sproduct")
    public String sproduct() {
        return "sproduct";
    }

    // @GetMapping("/Addcart/{price}/{productname}/{quantity}")
    // public String cartadd(@PathVariable String price, @PathVariable String productname,
    //         @PathVariable String quantity, @ModelAttribute Cartuser cart, Model model) {

    //     Cartuser cat = new Cartuser();
    //     cat.setPrice(price);
    //     cat.setProductname(productname);
    //     cat.setQuantity(quantity);
    //     serv.cart(cat);
       
    // ResponseEntity<List<Cartuser>> cartResponse = serv.getCartItems(); 

    // if (cartResponse != null && cartResponse.getBody() != null) {
    //     List<Cartuser> cartItems = cartResponse.getBody();

    //     // If the cartItems list is null, initialize it
    //     if (cartItems == null) {
    //         cartItems = new ArrayList<>();
    //     }

    //     // Add the new item to the list
    //     cartItems.add(cat);

    //     // Add the updated list back to the model
    //     model.addAttribute("data", cartItems);
    // } else {
    //     // If the response is null or the body is null, initialize an empty list and add the new item
    //     List<Cartuser> cartItems = new ArrayList<>();
    //     cartItems.add(cat);
    //     model.addAttribute("data", cartItems);
    // }
    // return "cart";
    // }

    

    @GetMapping("/Addcart/{price}/{productname}/{quantity}")
    public String cartadd(@PathVariable String price, @PathVariable String productname,
                          @PathVariable String quantity, @ModelAttribute Cartuser cat, Model model) {
    
        // You don't need to create a new Cartuser instance (cat) here since you are already getting it as a model attribute.
    
        // Save the new item to the cart using the service method
        serv.cart(cat);
    
        // Get the existing cart items from the service method
        ResponseEntity<List<Cartuser>> cartResponse = serv.getCartItems();
    
        List<Cartuser> cartItems;
    
        // If the cartItems list is null, initialize it
        if (cartResponse != null && cartResponse.getBody() != null) {
            cartItems = cartResponse.getBody();
            if (cartItems == null) {
                cartItems = new ArrayList<>();
            }
        } else {
            // If the response is null or the body is null, initialize an empty list
            cartItems = new ArrayList<>();
        }
    
        // Add the new item to the list
        cartItems.add(cat);
    
        // Add the updated list back to the model
        model.addAttribute("data", cartItems);
    
        return "cart";
    }


    @GetMapping("/control/{id}")
    public String del() {
        return "cart";
    }

    // @GetMapping("/del/{id}")
    // public String delet(@PathVariable Integer id, Model model) {
    // serv.deleteById(id);
    // model.addAttribute("data", serv.findAll());
    // return "cart";
    // }

    @GetMapping("/feedback")
    public String feed(@ModelAttribute Feedback feed, Model model) {
        model.addAttribute("data", feed.getName());
        model.addAttribute("data", feed.getEmail());
        model.addAttribute("data", feed.getSubject());
        model.addAttribute("data", feed.getFeedback());
        feedback.save(feed);
        return "redirect:/";
    }

    // @PostMapping("/registerUser")
    // public String sign(@ModelAttribute Signup mod, HttpSession session) {
    // // System.out.println(mod);
    // // signup.save(mod);
    // signup.Addsign(mod);
    // session.setAttribute("message", "User Register Sucessfully..");
    // return "redirect:/";
    // }

    // @PostMapping("/registerUser")
    // public String sign(@ModelAttribute Signup mod) {
    // signup.Addsign(mod);
    // return "redirect:/";
    // }

    // @GetMapping("/signup")
    // public String signUP(Signup mod) {
    // return "signup";
    // }

    // @PostMapping("/signin")
    // public String signin(@ModelAttribute Signup user, Model model) {
    // System.out.println(user);
    // // if (user != model.addAttribute("data", user.getEmail())) {
    // return "redirect:/";
    // // } else {
    // // return "redirect:/signup";
    // }
    // }
}
// =============================================

// @GetMapping("/signup")
// public String showSignupForm(Model model) {
// model.addAttribute("user", new User());
// return "signup";
// }
// @PostMapping("/signup")
// public String signup(User user) {
// // Check if the username is already taken
// if (userRepository.findByUsername(user.getUsername()) != null) {
// return "redirect:/signup?error=Username already exists";
// }
// userRepository.save(user);
// return "redirect:/login?success=Signup successful";
// }
/*
 * @GetMapping("/signin")
 * public String showLoginForm() {
 * return "login";
 * }
 * 
 * // @PostMapping("/signin")
 * // public String login(Signup user, Model model) {
 * // // Retrieve the user from the database by username
 * // Signup existingUser = signuprepo.findByUsername(user.getEmail());
 * 
 * // // Check if the user exists and if the password matches
 * // if (existingUser != null &&
 * existingUser.getPassword().equals(user.getPassword())) {
 * // return "redirect:/"; // Redirect to the user dashboard after successful
 * login
 * // } else {
 * // model.addAttribute("error", "Invalid credentials");
 * // return "login";
 * // }
 */
// }
