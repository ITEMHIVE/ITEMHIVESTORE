package za.ac.cput.repository;

// CategoryRepositoryTest.java
// Author: Abongile Phandle (230670849)
// Date: June 2026

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import za.ac.cput.domain.Category;
import za.ac.cput.factory.CategoryFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repo;

    @Test
    void testCreate() {
        Category category = CategoryFactory.create("cat001", "Books", "Textbooks and novels");
        Category saved = repo.save(category);
        assertNotNull(saved);
        System.out.println("Created: " + saved);
    }

    @Test
    void testRead() {
        Category category = CategoryFactory.create("cat001", "Books", "Textbooks and novels");
        repo.save(category);
        Optional<Category> found = repo.findById("cat001");
        assertTrue(found.isPresent());
        assertEquals("Books", found.get().getCategoryName());
        System.out.println("Found: " + found.get());
    }

    @Test
    void testUpdate() {
        Category category = CategoryFactory.create("cat001", "Books", "Textbooks and novels");
        repo.save(category);
        Category updated = CategoryFactory.create("cat001", "Books", "Updated description");
        Category result = repo.save(updated);
        assertEquals("Updated description", result.getDescription());
        System.out.println("Updated: " + result);
    }

    @Test
    void testDelete() {
        Category category = CategoryFactory.create("cat001", "Books", "Textbooks and novels");
        repo.save(category);
        repo.deleteById("cat001");
        assertFalse(repo.existsById("cat001"));
        System.out.println("Deleted successfully");
    }
}