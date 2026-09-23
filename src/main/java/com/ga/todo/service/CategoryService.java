package com.ga.todo.service;

import com.ga.todo.exception.InformationExistException;
import com.ga.todo.exception.InformationNotFoundException;
import com.ga.todo.model.Category;
import com.ga.todo.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    //create category
    public Category createCategory(Category categoryObject){
        Category category = categoryRepository.findByName(categoryObject.getName());
        if(category!=null){
            throw  new InformationExistException("category with name: " + category.getName() + "already exists");
        }else{
            return categoryRepository.save(categoryObject);
        }
    }

    //get categories
    public List<Category> getCategories() {
        System.out.println("Service calling getCategories ==>");
        return categoryRepository.findAll();
    }

    //get category by its id
    public Category getCategory(Long categoryId) {
        System.out.println("service getCategory ==>");

        return categoryRepository.findById(categoryId).orElseThrow(()->
                new InformationNotFoundException(
                        "category with id " + categoryId + "not found"
                )
        );

    }

    //update category
    public Category updateCategory(Long categoryId, Category categoryObject){
        System.out.println("service updateCategory ==>");

        Category categoryExist = categoryRepository.findById(categoryId).orElseThrow(()->
                new InformationNotFoundException(
                        "category with id " + categoryId + "notfound"
                )
        );

        categoryExist.setName(categoryObject.getName());
        categoryExist.setDescription(categoryObject.getDescription());

        return categoryRepository.save(categoryExist);
    }


    //delete category
    public Category deleteCategory(Long categoryId) {
        System.out.println("service deleteCategory() ==> ");
        Category category = categoryRepository.findById(categoryId).orElseThrow(()->
                new InformationNotFoundException(
                        "category with id " + categoryId + "notfound"
                )
        );

        categoryRepository.deleteById(categoryId);
        return category;
    }
}
