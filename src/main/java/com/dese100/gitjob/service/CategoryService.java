package com.dese100.gitjob.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dese100.gitjob.domain.Category;
import com.dese100.gitjob.repository.CategoryMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	CategoryMapper _categoryMapper;
	
	@Override
	public void DeleteCategory(Category category) {
		category.setDeleted(true);
		category.setUpdatedOnUtc(new Date());
		_categoryMapper.updateCategory(category);
	}

	@Override
	public PageInfo<Category> GetAllCategories(String categoryName, int pageIndex, int pageSize, Boolean published) {
		PageHelper.startPage(pageIndex, pageSize);
		List<Category> categorys = _categoryMapper.getAllCategories(categoryName, null, null, null);
		PageInfo<Category> categoryPageList = new PageInfo<>(categorys);
		return categoryPageList;
	}

	@Override
	public List<Category> GetAllCategoriesByParentCategoryId(long parentCategoryId, boolean published,
			boolean includeAllLevels) {
		return null;
	}
	
	@Override
	public List<Category> GetAllCategoriesDisplayedOnHomePage(boolean published) {
		return _categoryMapper.getAllCategories(null, published, true, null);
	}

	@Override
	public Category GetCategoryById(long categoryId) {
		return _categoryMapper.getCategoryById(categoryId);
	}

	@Override
	public void InsertCategory(Category category) {
		category.setDeleted(false);
		category.setCreatedOnUtc(new Date());
		category.setUpdatedOnUtc(new Date());
		_categoryMapper.insertCategory(category);
	}

	@Override
	public void UpdateCategory(Category category) {
		category.setUpdatedOnUtc(new Date());
		_categoryMapper.updateCategory(category);
	}

}
