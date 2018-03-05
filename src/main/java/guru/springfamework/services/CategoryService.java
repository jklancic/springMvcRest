package guru.springfamework.services;

import java.util.List;

import guru.springfamework.domain.Category;

public interface CategoryService {
	
	List<Category> getAllCategories();
	
	Category getCategory(Long id);
	
	Category getCategory(String name);
}
