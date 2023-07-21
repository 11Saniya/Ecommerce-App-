package com.project.ecommerce.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.ecommerce.Model.Cartuser;
import com.project.ecommerce.Repository.cartrepo;

@Service
public class cartservice {
    @Autowired
    cartrepo repo;

    public Cartuser getById(int id) {
        Optional<Cartuser> table = repo.findById(id);
        if (table.isPresent()) {
            return table.get();
        } else {
            return null;
        }
    }

    public void findAll() {
         repo.findAll();
    }

    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

    public void cart(Cartuser use) {
        repo.save(use);
    }

    public ResponseEntity<List<Cartuser>> getCartItems() {
        return null;
    }

}
