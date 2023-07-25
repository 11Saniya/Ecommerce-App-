package com.project.ecommerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerce.Model.Signup;
import com.project.ecommerce.Repository.signuprepo;

@Service
public class Signservice {

    @Autowired
    signuprepo reposit;

    public void Add(Signup user) {
        reposit.save(user);
    }

    public List<Signup> findAll() {
        return reposit.findAll();
    }

    public List<Signup> Addd(List<Signup> use) {
        return reposit.findAll();
    }

}
