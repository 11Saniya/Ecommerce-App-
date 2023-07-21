package com.project.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ecommerce.Model.Feedback;

public interface Feedbackrepo extends JpaRepository<Feedback, Integer> {

}
