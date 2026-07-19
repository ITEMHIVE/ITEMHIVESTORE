package za.ac.cput.itemhivesd2.controller;

// CategoryControllerTest.java
// Author: Abongile Phandle (230670849)
// Date: June 2026

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.itemhivesd2.domain.Category;
import za.ac.cput.itemhivesd2.factory.CategoryFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CategoryControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseUrl;
    private Category category;

    @BeforeEach
    void setUp() {
        baseUrl = "http://localhost:" + port + "/categories";
        category = CategoryFactory.create("cat001", "Books", "Textbooks and novels");
    }

    @Test
    void testCreate() {
        ResponseEntity<Category> response = restTemplate.postForEntity(
                baseUrl + "/create", category, Category.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("cat001", response.getBody().getCategoryId());
        System.out.println("Created: " + response.getBody());
    }

    @Test
    void testRead() {
        restTemplate.postForEntity(baseUrl + "/create", category, Category.class);
        ResponseEntity<Category> response = restTemplate.getForEntity(
                baseUrl + "/read/cat001", Category.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void testUpdate() {
        restTemplate.postForEntity(baseUrl + "/create", category, Category.class);
        Category updated = CategoryFactory.create("cat001", "Books", "Updated description");
        ResponseEntity<Category> response = restTemplate.exchange(
                baseUrl + "/update", HttpMethod.PUT,
                new HttpEntity<>(updated), Category.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Updated description", response.getBody().getDescription());
        System.out.println("Updated: " + response.getBody());
    }

    @Test
    void testDelete() {
        restTemplate.postForEntity(baseUrl + "/create", category, Category.class);
        ResponseEntity<Boolean> response = restTemplate.exchange(
                baseUrl + "/delete/cat001", HttpMethod.DELETE,
                null, Boolean.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody());
        System.out.println("Deleted: " + response.getBody());
    }

    @Test
    void testGetAll() {
        restTemplate.postForEntity(baseUrl + "/create", category, Category.class);
        ResponseEntity<List> response = restTemplate.getForEntity(
                baseUrl + "/all", List.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
        System.out.println("All: " + response.getBody());
    }
}