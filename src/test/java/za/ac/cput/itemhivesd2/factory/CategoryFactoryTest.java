package za.ac.cput.factory;
// CategoryFactoryTest.java
// Author: Your Name (230670849)
// Date: 25 March 2026

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Category;
import za.ac.cput.factory.CategoryFactory;

import static org.junit.jupiter.api.Assertions.*;

// Each method tests a different scenario
class CategoryFactoryTest {

    @Test
    void testCreate_Success() {
        Category category = CategoryFactory.create("cat001", "Books", "Textbooks and novels");
        assertNotNull(category);
        assertEquals("cat001", category.getCategoryId()); // should not be null
        assertEquals("Books", category.getCategoryName()); // id must match
        assertEquals("Textbooks and novels", category.getDescription()); // descript must match
    }

    @Test
    void testCreate_NullName_ReturnsNull() {
        Category category = CategoryFactory.create("cat002", null, "Some description");
        assertNull(category); // factory should return null for invalid input
    }

    @Test
    void testCreate_EmptyId_ReturnsNull() {
        Category category = CategoryFactory.create("", "Electronics", "Phones and laptops");
        assertNull(category); // factory should return null for empty input
    }
}