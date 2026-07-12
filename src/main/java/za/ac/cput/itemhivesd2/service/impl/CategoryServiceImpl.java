package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Category;
import za.ac.cput.repository.CategoryRepository;
import za.ac.cput.service.ICategoryService;

import java.util.List;
import java.util.Optional;

// CategoryServiceImpl.java
// Author: Abongile Phandle (230670849)
// Date: June 2026

@Service
public class CategoryServiceImpl implements ICategoryService {

    private final CategoryRepository repository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category create(Category category) {
        return repository.save(category);
    }

    @Override
    public Category read(String id) {
        Optional<Category> found = repository.findById(id);
        return found.orElse(null);
    }

    @Override
    public Category update(Category category) {
        if (repository.existsById(category.getCategoryId())) {
            return repository.save(category);
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Category> getAll() {
        return repository.findAll();
    }
}