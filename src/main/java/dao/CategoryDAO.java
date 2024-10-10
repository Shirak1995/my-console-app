package dao;


import model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private List<Category> categories = new ArrayList<>();

    public void addCategory(Category category) {
        categories.add(category);
    }

    public List<Category> getAllCategories() {
        return categories;
    }
}
