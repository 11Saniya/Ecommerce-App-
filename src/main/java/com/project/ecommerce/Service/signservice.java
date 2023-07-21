package com.project.ecommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerce.Model.Signup;
import com.project.ecommerce.Repository.signuprepo;

@Service
public class signservice {

    @Autowired
    static
    signuprepo repo;

    public Signup Addsign(Signup users) {
        return repo.save(users);
    }

    public void Addsig(Signup sign) {
        repo.save(sign);
    }

    public void check(Signup val) {
        repo.existsById(val.getId());
    }

   
    // public void addSign(Signup sign) {
    // repo.save(sign);
    // }

    // public Signup checkexistence(Signup mail) {
    // Optional<Signup> existingUser = repo.findById(mail);
    // if (existingUser.isPresent()) {
    // return existingUser.get();
    // } else {
    // return null;
    // }
    // }

    // public boolean authenticateUser(String checkEmail, String checkPassword) {
    // Optional<Signup> checkingUser = repo.findById(checkPassword);
    // if (checkingUser.equals(repo.findById(checkEmail))) {
    // return true;
    // } else {
    // return false;
    // }
    // }

}
