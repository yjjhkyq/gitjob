package com.dese100.gitjob.domain;

import java.util.Date;

public class Category {
	private Long id;
	 /// <summary>
    /// Gets or sets the name
    /// </summary>
    private String name ;

    /// <summary>
    /// Gets or sets the description
    /// </summary>
    private String description ;

    /// <summary>
    /// Gets or sets the parent category identifier
    /// </summary>
    private Long parentCategoryId ;

    /// <summary>
    /// Gets or sets a value indicating whether to show the category on home page
    /// </summary>
    private Boolean showOnHomePage ;

    /// <summary>
    /// Gets or sets a value indicating whether to include this category in the top menu
    /// </summary>
    private Boolean includeInTopMenu ;
    
    /// <summary>
    /// Gets or sets a value indicating whether the entity is published
    /// </summary>
    private Boolean published ;

    /// <summary>
    /// Gets or sets a value indicating whether the entity has been deleted
    /// </summary>
    private Boolean deleted ;

    /// <summary>
    /// Gets or sets the display order
    /// </summary>
    private Integer displayOrder ;

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

	public Long getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(Long parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	public Boolean getShowOnHomePage() {
		return showOnHomePage;
	}

	public void setShowOnHomePage(Boolean showOnHomePage) {
		this.showOnHomePage = showOnHomePage;
	}

	public Boolean getIncludeInTopMenu() {
		return includeInTopMenu;
	}

	public void setIncludeInTopMenu(Boolean includeInTopMenu) {
		this.includeInTopMenu = includeInTopMenu;
	}

	public Boolean getPublished() {
		return published;
	}

	public void setPublished(Boolean published) {
		this.published = published;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Integer getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
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
