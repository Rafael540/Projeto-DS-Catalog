package com.dscatalog.dscommerce.services;

import com.dscatalog.dscommerce.entities.Category;
import com.dscatalog.dscommerce.repositories.CategoryRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

}
