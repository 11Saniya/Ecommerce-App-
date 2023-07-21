package com.project.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ecommerce.Model.Euser;

public interface Erepository extends JpaRepository<Euser, Integer> {


}
