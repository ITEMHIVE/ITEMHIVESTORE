package za.ac.cput.itemhivesd2.factory;

import za.ac.cput.itemhivesd2.domain.Category;

// CategoryFactory.java
// Author: Abongile Phandle (230670849)
// Date: june 2026

public class CategoryFactory {

    public static Category create(String categoryId, String categoryName, String description) {
        if (categoryId == null || categoryName == null || description == null) {
            return null;
        }
        if (categoryId.isEmpty() || categoryName.isEmpty() || description.isEmpty()) {
            return null;
        }

        return new Category.Builder()
                .setCategoryId(categoryId)
                .setCategoryName(categoryName)
                .setDescription(description)
                .build();
    }
}