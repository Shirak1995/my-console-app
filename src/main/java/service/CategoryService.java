package service;


import dao.CategoryDAO;
import model.Category;

import java.util.List;

public class CategoryService {
    private CategoryDAO categoryDAO;

    public CategoryService(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public void createCategory(String name) {
        int newId = categoryDAO.getAllCategories().size() + 1;
        Category category = new Category(newId, name);
        categoryDAO.addCategory(category);
        System.out.println("Категория \"" + name + "\" создана.");
    }

    public List<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }
}
