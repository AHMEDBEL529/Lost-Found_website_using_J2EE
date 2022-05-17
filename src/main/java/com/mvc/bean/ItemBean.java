package com.mvc.bean;


public class ItemBean {
	private Integer foundItemId;
    private String category;
    private String description;
     
    private String base64Image;
 
 
    public String getBase64Image() {
        return base64Image;
    }
 
    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

	public Integer getFoundItemId() {
		return foundItemId;
	}

	public void setFoundItemId(Integer foundItemId) {
		this.foundItemId = foundItemId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
 
}