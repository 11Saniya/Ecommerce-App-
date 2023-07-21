package com.project.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ecommerce.Model.Signup;

public interface signuprepo extends JpaRepository<Signup, Integer> {

}
