package za.ac.cput.service;

import za.ac.cput.domain.Category;
import java.util.List;

// ICategoryService.java
// Author: Abongile Phandle (230670849)
// Date: June 2026

public interface ICategoryService {
    Category create(Category category);
    Category read(String id);
    Category update(Category category);
    boolean delete(String id);
    List<Category> getAll();
}