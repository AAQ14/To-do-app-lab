package com.ga.todo.repository;


import com.ga.todo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String categoryName);
    Category findByNameAndDescription(String name, String description);
    Category findByUserIdAndName(Long userId, String categoryName);
    List<Category> findByUserId(Long userId);
    Category findByUserIdAndId(Long userId, Long id);
}
