package com.project.ecommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerce.Model.Feedback;
import com.project.ecommerce.Repository.Feedbackrepo;

@Service
public class feedservice {
    @Autowired
    Feedbackrepo repository;

    public void save(Feedback feed) {
   repository.save(feed);
    }
}
