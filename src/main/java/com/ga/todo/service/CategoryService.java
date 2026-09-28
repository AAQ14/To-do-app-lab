package com.ga.todo.service;

import com.ga.todo.exception.InformationExistException;
import com.ga.todo.exception.InformationNotFoundException;
import com.ga.todo.model.Category;
import com.ga.todo.model.User;
import com.ga.todo.repository.CategoryRepository;
import com.ga.todo.security.MyUserDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    public static User getCurrentLoggedInUser(){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUser();
    }

    //create category
    public Category createCategory(Category categoryObject){
        Category category = categoryRepository.findByUserIdAndName(getCurrentLoggedInUser().getId() ,categoryObject.getName());
        System.out.println("Category Updated Data BEFORE ====> " + category);

        if(category!=null){
            throw  new InformationExistException("category with name: " + category.getName() + "already exists");
        }else{

            Category newCategory = new Category();

            newCategory.setName(categoryObject.getName());
            newCategory.setDescription(categoryObject.getDescription());
            newCategory.setUser(getCurrentLoggedInUser());
            System.out.println("Category Updated Data ====> " + newCategory);

            return categoryRepository.save(newCategory);
        }
    }

    public List<Category> getCategories() {
        System.out.println("Service calling getCategories ==>");
        return categoryRepository.findByUserId(getCurrentLoggedInUser().getId());
    }

    public Category getCategory(Long categoryId) {
        System.out.println("service getCategory ==>");

        Category category = categoryRepository.findByUserIdAndId(getCurrentLoggedInUser().getId(), categoryId);
        if(category != null){
            return category;
        }else{
            throw  new InformationNotFoundException("category with this user id " + getCurrentLoggedInUser().getId() + " not found");
        }
    }

    public Category updateCategory(Long categoryId, Category categoryObject){
        System.out.println("service updateCategory ==>");

        Category category = categoryRepository.findByUserIdAndId(getCurrentLoggedInUser().getId(), categoryId);
        if(category != null){
            category.setName(categoryObject.getName());
            category.setDescription(categoryObject.getDescription());
            categoryRepository.save(category);
            return category;
        }else{
            throw  new InformationNotFoundException("category with this user id " + getCurrentLoggedInUser().getId() + " not found");
        }

    }


    public Category deleteCategory(Long categoryId) {
        System.out.println("service deleteCategory() ==> ");
        Category category = categoryRepository.findByUserIdAndId(getCurrentLoggedInUser().getId(), categoryId);
        if(category != null){
            categoryRepository.deleteById(categoryId);
            return category;
        }else{
            throw  new InformationNotFoundException("category with this user id " + getCurrentLoggedInUser().getId() + " not found");
        }
    }
}
