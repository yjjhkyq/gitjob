package com.dese100.gitjob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dese100.gitjob.domain.Category;
import com.dese100.gitjob.domain.Customer;
import com.dese100.gitjob.domain.result.Result;
import com.dese100.gitjob.exception.BizException;
import com.dese100.gitjob.exception.code.ExceptionCode;
import com.dese100.gitjob.mapper.ModelMapper;
import com.dese100.gitjob.models.CategoryListModel;
import com.dese100.gitjob.models.CategoryModel;
import com.dese100.gitjob.models.CustomerModel;
import com.dese100.gitjob.service.ICategoryService;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	ICategoryService _categoryService;
	
	@PostMapping("/list")
	public Result<?> list(@RequestBody CategoryListModel customerListModel) {
		PageInfo<Category> pageInfo = _categoryService.GetAllCategories(customerListModel.Name, customerListModel.getPage(), customerListModel.getPageSize(), null);
		return Result.success(ModelMapper.toCategoryPageModel(pageInfo));
	}
	
	@Transactional
	@PostMapping("/create")
	public Result<?> create(@RequestBody @Validated CategoryModel model, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return Result.bindingError(bindingResult);
		Category category = ModelMapper.toEntity(model);
		_categoryService.InsertCategory(category);
		return Result.success(category.getId());
	}
	
	@GetMapping("/detail")
	public Result<?> detail(long categoryId) {
		Category category = _categoryService.GetCategoryById(categoryId);
		if(null == category)
			throw BizException.wrap(ExceptionCode.NOT_FOUND_ENTITT_ERROR);
		CategoryModel model = ModelMapper.toModel(category);
		return Result.success(model);
	}
	
	@Transactional
	@PostMapping("/edit")
	public Result<?> edit(@RequestBody @Validated CategoryModel model, BindingResult bindingResult) {
		Category category = _categoryService.GetCategoryById(model.getId());
		if(null == category)
			throw BizException.wrap(ExceptionCode.NOT_FOUND_ENTITT_ERROR);
		Category categoryNew = ModelMapper.toEntity(model);
		_categoryService.UpdateCategory(categoryNew);
		return Result.success( model.getId());
	}
	
	@Transactional
	@PostMapping("/delete")
	public Result<?> delete(@RequestBody long categoryId) {
		Category category = _categoryService.GetCategoryById(categoryId);
		if(null == category)
			throw BizException.wrap(ExceptionCode.NOT_FOUND_ENTITT_ERROR);
		_categoryService.DeleteCategory(category);
		return Result.success(category.getId());
	}
}
