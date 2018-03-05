package guru.springfamework.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import guru.springfamework.domain.Category;
import guru.springfamework.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	private CategoryRepository categoryRepository;
	
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategory(Long id) {
		Optional<Category> categoryOptional = categoryRepository.findById(id);
		return categoryOptional.isPresent() ? categoryOptional.get() : new Category();
	}

	@Override
	public Category getCategory(String name) {
		return categoryRepository.findByName(name);
	}
}
