package com.ga.todo.controller;


import com.ga.todo.model.Category;
import com.ga.todo.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ToDoController {
    private CategoryService categoryService;

    @PostMapping("/categories")
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories(){
        return categoryService.getCategories();
    }

    @GetMapping("/categories/{categoryId}")
    public Category getCategory(@PathVariable long categoryId){
        return categoryService.getCategory(categoryId);
    }

    @PutMapping("/categories/{categoryId}")
    public Category updateCategory(@PathVariable long categoryId, @RequestBody Category categoryObject){
        return categoryService.updateCategory(categoryId, categoryObject);
    }

    @DeleteMapping("/categories/{categoryId}")
    public Category deleteCategory(@PathVariable long categoryId){
        return  categoryService.deleteCategory(categoryId);
    }

}
