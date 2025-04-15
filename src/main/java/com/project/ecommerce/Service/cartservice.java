package com.project.ecommerce.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerce.Model.Cartuser;
import com.project.ecommerce.Repository.cartrepo;

import jakarta.servlet.http.HttpSession;

@Service
public class cartservice {
    @Autowired
    cartrepo repo;

    public List<Cartuser> getCartItems(HttpSession session) {
        @SuppressWarnings("unchecked")
        List<Cartuser> cartItems = (List<Cartuser>) session.getAttribute("cartItems");

        if (cartItems == null) {
            cartItems = new ArrayList<>();
            session.setAttribute("cartItems", cartItems);
        }

        return cartItems;
    }

    // Add cart item to the user's session cart
    public void addToCart(Cartuser cartItem, HttpSession session) {
        List<Cartuser> cartItems = getCartItems(session);
        cartItems.add(cartItem);
        session.setAttribute("cartItems", cartItems);
    }

    public void removeFromCart(int id, HttpSession session) {
        List<Cartuser> cartItems = getCartItems(session);
        cartItems.removeIf(item -> item.getId() == id);
        session.setAttribute("cartItems", cartItems);
        
    }

    public Object add(Cartuser cart) {
        return repo.save(cart);
    }

    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

    public Cartuser getById(int id) {
    Optional<Cartuser> table = repo.findById(id);
    if (table.isPresent()) {
    return table.get();
    } else {
    return null;
    }
    }

    public void findById(int id) {
        repo.findById(id);
    }

    // public Cartuser getById(int id) {
    //     return repo.findById(id){
         
    // }

    public void deleteById(int id) {
        repo.deleteById(id);
    }
}
