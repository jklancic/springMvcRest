package guru.springfamework.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springfamework.domain.Category;
import guru.springfamework.services.CategoryService;

@Controller
@RequestMapping("api/v1/categories")
public class CategoryController {
	
	private CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping
	public ResponseEntity<List<Category>> getAllCategories() {
		return new ResponseEntity<List<Category>>(categoryService.getAllCategories(), HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
		return new ResponseEntity<Category>(categoryService.getCategory(id), HttpStatus.OK);
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<Category> getCategoryByName(@PathVariable String name) {
		return new ResponseEntity<Category>(categoryService.getCategory(name), HttpStatus.OK);
	}
}
