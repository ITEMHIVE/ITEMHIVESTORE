package za.ac.cput.service;

// CategoryServiceImplTest.java
// Author: Abongile Phandle (230670849)
// Date: June 2026

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Category;
import za.ac.cput.factory.CategoryFactory;
import za.ac.cput.service.ICategoryService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryServiceImplTest {

    @Autowired
    private ICategoryService service;

    private Category category;

    @BeforeEach
    void setUp() {
        category = CategoryFactory.create("cat001", "Books", "Textbooks and novels");
    }

    @Test
    void testCreate() {
        Category created = service.create(category);
        assertNotNull(created);
        assertEquals("cat001", created.getCategoryId());
        assertEquals("Books", created.getCategoryName());
        System.out.println("Created: " + created);
    }

    @Test
    void testRead() {
        service.create(category);
        Category found = service.read("cat001");
        assertNotNull(found);
        assertEquals("Books", found.getCategoryName());
        System.out.println("Found: " + found);
    }

    @Test
    void testUpdate() {
        service.create(category);
        Category updated = CategoryFactory.create("cat001", "Books", "Updated description");
        Category result = service.update(updated);
        assertNotNull(result);
        assertEquals("Updated description", result.getDescription());
        System.out.println("Updated: " + result);
    }

    @Test
    void testDelete() {
        service.create(category);
        boolean deleted = service.delete("cat001");
        assertTrue(deleted);
        assertNull(service.read("cat001"));
        System.out.println("Deleted: " + deleted);
    }

    @Test
    void testGetAll() {
        service.create(category);
        List<Category> all = service.getAll();
        assertFalse(all.isEmpty());
        System.out.println("All categories: " + all);
    }
}