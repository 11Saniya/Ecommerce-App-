package com.project.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ecommerce.Model.Cartuser;

public interface cartrepo extends JpaRepository<Cartuser, Integer> {

}
