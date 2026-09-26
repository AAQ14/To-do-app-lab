package com.ga.todo.service;

import com.ga.todo.exception.InformationNotFoundException;
import com.ga.todo.model.Category;
import com.ga.todo.model.Item;
import com.ga.todo.repository.CategoryRepository;
import com.ga.todo.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemService {
    private CategoryRepository categoryRepository;
    private ItemRepository itemRepository;

    public Item createItem(Long categoryId, Item item){
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new InformationNotFoundException(
                        "Category with id " + categoryId + " not found"
                ));
        item.setCategory(category);
        return itemRepository.save(item);
    }

    public List<Item> getItems(Long categoryId){
        List<Item> items = itemRepository.findByCategoryId(categoryId);
        if(items.isEmpty()){
            throw new InformationNotFoundException("items with this category id " + categoryId + " not found");
        }else{
            return items;
        }
    }

    public Item getItem(long categoryId, long itemId){
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                ()->new InformationNotFoundException("category with this id " + categoryId + "not found")
        );
        List<Item> items = itemRepository.findByCategoryId(categoryId);
        if(items.isEmpty()){
            throw new InformationNotFoundException("items with this category id " + categoryId + " not found");
        }else{
            Item item = itemRepository.findById(itemId).orElseThrow(
                    ()->new InformationNotFoundException("item with this is " + itemId + " not found")
            );
            return item;
        }
    }

    public Item updateItem(Long categoryId, Long itemId, Item itemObject){
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                ()->new InformationNotFoundException("category with this id " + categoryId + "not found")
        );
        List<Item> items = itemRepository.findByCategoryId(categoryId);
        if(items.isEmpty()){
            throw new InformationNotFoundException("items with this category id " + categoryId + " not found");
        }else{
            Item item = itemRepository.findById(itemId).orElseThrow(
                    ()->new InformationNotFoundException("item with this is " + itemId + " not found")
            );
            item.setName(itemObject.getName());
            item.setDescription(itemObject.getDescription());
            item.setDueDate(item.getDueDate());
            item.setCategory(item.getCategory());
            itemRepository.save(item);
            return item;
        }
    }

    public Item deleteItem(long categoryId, long itemId){
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                ()->new InformationNotFoundException("category with this id " + categoryId + "not found")
        );
        List<Item> items = itemRepository.findByCategoryId(categoryId);
        if(items.isEmpty()){
            throw new InformationNotFoundException("items with this category id " + categoryId + " not found");
        }else{
            Item item = itemRepository.findById(itemId).orElseThrow(
                    ()->new InformationNotFoundException("item with this is " + itemId + " not found")
            );
            itemRepository.delete(item);
            return item;
        }
    }
}
