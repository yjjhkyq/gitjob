package com.dese100.gitjob.service;

import java.util.List;

import com.dese100.gitjob.domain.Category;
import com.github.pagehelper.PageInfo;

public interface ICategoryService {
	 /// <summary>
    /// Delete category
    /// </summary>
    /// <param name="category">Category</param>
    void DeleteCategory(Category category);

    /// <summary>
    /// Gets all categories
    /// </summary>
    /// <param name="categoryName">Category name</param>
    /// <param name="storeId">Store identifier; 0 if you want to get all records</param>
    /// <param name="pageIndex">Page index</param>
    /// <param name="pageSize">Page size</param>
    /// <param name="showHidden">A value indicating whether to show hidden records</param>
    /// <returns>Categories</returns>
    PageInfo<Category> GetAllCategories(String categoryName, int pageIndex, int pageSize, Boolean published);

    /// <summary>
    /// Gets all categories filtered by parent category identifier
    /// </summary>
    /// <param name="parentCategoryId">Parent category identifier</param>
    /// <param name="showHidden">A value indicating whether to show hidden records</param>
    /// <param name="includeAllLevels">A value indicating whether we should load all child levels</param>
    /// <returns>Categories</returns>
    List<Category> GetAllCategoriesByParentCategoryId(long parentCategoryId,
        boolean published , boolean includeAllLevels);

    /// <summary>
    /// Gets all categories displayed on the home page
    /// </summary>
    /// <param name="showHidden">A value indicating whether to show hidden records</param>
    /// <returns>Categories</returns>
    List<Category> GetAllCategoriesDisplayedOnHomePage(boolean published);

    /// <summary>
    /// Gets a category
    /// </summary>
    /// <param name="categoryId">Category identifier</param>
    /// <returns>Category</returns>
    Category GetCategoryById(long categoryId);

    /// <summary>
    /// Inserts category
    /// </summary>
    /// <param name="category">Category</param>
    void InsertCategory(Category category);

    /// <summary>
    /// Updates the category
    /// </summary>
    /// <param name="category">Category</param>
    void UpdateCategory(Category category);
}
