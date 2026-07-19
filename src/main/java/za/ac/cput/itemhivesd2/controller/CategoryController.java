package za.ac.cput.itemhivesd2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.itemhivesd2.domain.Category;
import za.ac.cput.itemhivesd2.service.ICategoryService;

import java.util.List;

// CategoryController.java
// Author: Abongile Phandle (230670849)
// Date: June 2026

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final ICategoryService service;

    @Autowired
    public CategoryController(ICategoryService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Category> create(@RequestBody Category category) {
        Category created = service.create(category);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Category> read(@PathVariable String id) {
        Category found = service.read(id);
        if (found == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(found);
    }

    @PutMapping("/update")
    public ResponseEntity<Category> update(@RequestBody Category category) {
        Category updated = service.update(category);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        boolean deleted = service.delete(id);
        return ResponseEntity.ok(deleted);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}