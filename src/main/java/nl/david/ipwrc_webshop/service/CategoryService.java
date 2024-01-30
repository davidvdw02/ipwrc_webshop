package nl.david.ipwrc_webshop.service;

import nl.david.ipwrc_webshop.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import nl.david.ipwrc_webshop.model.Category;

@Service
public class CategoryService {
        
        private final CategoryRepository categoryRepository;

        public CategoryService(CategoryRepository categoryRepository) {
            this.categoryRepository = categoryRepository;
        }

        public List<Category> getAllCategories() {
            return categoryRepository.findAll();
        }

        public Optional<Category> getCategoryById(Long id) {
            return categoryRepository.findById(id);
        }

        public Category createCategory(Category category) {
            return categoryRepository.save(category);
        }

        public void deleteCategory(Long id) {
            categoryRepository.deleteById(id);
        }
    }
