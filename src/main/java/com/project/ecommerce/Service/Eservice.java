package com.project.ecommerce.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerce.Model.Cartuser;
import com.project.ecommerce.Model.Euser;
import com.project.ecommerce.Repository.Erepository;

@Service
public class Eservice {

    @Autowired
    Erepository repository;

    public void Add(Euser use) {
        repository.save(use);
    }

    public List<Euser> findAll() {
        return repository.findAll();
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public Euser getById(int id) {
        Optional<Euser> table = repository.findById(id);
        if (table.isPresent()) {
            return table.get();
        } else {
            return null;
        }
    }

    public List<Cartuser> findAlll() {
        return null;
    }

}
