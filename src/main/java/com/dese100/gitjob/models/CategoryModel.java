package com.dese100.gitjob.models;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

public class CategoryModel {
	private long id;
	 /// <summary>
   /// Gets or sets the name
   /// </summary>
   @Length(min=1,max=30,message="user name lenght max between 1 to 30")
	private String name ;

   /// <summary>
   /// Gets or sets the description
   /// </summary>
   @Length(min=0,max=100,message="user name lenght max between 1 to 100")
   private String description ;

   /// <summary>
   /// Gets or sets the parent category identifier
   /// </summary>
   private long parentCategoryId ;

   /// <summary>
   /// Gets or sets a value indicating whether to show the category on home page
   /// </summary>
   private boolean showOnHomePage ;

   /// <summary>
   /// Gets or sets a value indicating whether to include this category in the top menu
   /// </summary>
   private boolean includeInTopMenu ;
   
   /// <summary>
   /// Gets or sets a value indicating whether the entity is published
   /// </summary>
   private boolean published ;

   /// <summary>
   /// Gets or sets a value indicating whether the entity has been deleted
   /// </summary>
   private boolean deleted ;

   /// <summary>
   /// Gets or sets the display order
   /// </summary>
   private int displayOrder ;

   /// <summary>
   /// Gets or sets the date and time of instance creation
   /// </summary>
   private Date createdOnUtc ;

   /// <summary>
   /// Gets or sets the date and time of instance update
   /// </summary>
   private Date updatedOnUtc ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(long parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	public boolean getShowOnHomePage() {
		return showOnHomePage;
	}

	public void setShowOnHomePage(boolean showOnHomePage) {
		this.showOnHomePage = showOnHomePage;
	}

	public boolean getIncludeInTopMenu() {
		return includeInTopMenu;
	}

	public void setIncludeInTopMenu(boolean includeInTopMenu) {
		this.includeInTopMenu = includeInTopMenu;
	}

	public boolean getPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public int getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	public Date getCreatedOnUtc() {
		return createdOnUtc;
	}

	public void setCreatedOnUtc(Date createdOnUtc) {
		this.createdOnUtc = createdOnUtc;
	}

	public Date getUpdatedOnUtc() {
		return updatedOnUtc;
	}

	public void setUpdatedOnUtc(Date updatedOnUtc) {
		this.updatedOnUtc = updatedOnUtc;
	}
}
