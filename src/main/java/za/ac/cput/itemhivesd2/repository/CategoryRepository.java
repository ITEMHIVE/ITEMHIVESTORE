package za.ac.cput.itemhivesd2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.itemhivesd2.domain.Category;

// CategoryRepository.java
// Author: Abongile Phandle (230670849)

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
}
