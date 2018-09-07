package com.dese100.gitjob.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dese100.gitjob.domain.Category;

@Mapper
@Repository
public interface CategoryMapper {
	void updateCategory(Category category);
	void insertCategory(Category category);
	Category getCategoryById(Long id);
    List<Category> getAllCategories(String name, Boolean published, Boolean showOnHomePage,  Boolean includeInTopMenu);
    List<Category> getAllCategoriesByParentCategoryId(Long parentCategoryId, Boolean published);
}
