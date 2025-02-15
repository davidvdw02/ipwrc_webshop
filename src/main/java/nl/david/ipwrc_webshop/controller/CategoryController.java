package nl.david.ipwrc_webshop.controller;

import nl.david.ipwrc_webshop.service.CategoryService;
import nl.david.ipwrc_webshop.model.Category;


import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // @GetMapping("/{id}")
    // public Category getCategoryById(@PathVariable Long id) {
    // return categoryService.getCategoryById(id);
    // }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    // @PutMapping("/{id}")
    // public Category updateCategory(@PathVariable Long id, @RequestBody Category
    // category) {
    // return categoryService.updateCategory(id, category);
    // }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

}
