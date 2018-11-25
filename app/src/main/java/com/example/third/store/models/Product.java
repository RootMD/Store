package com.example.third.store.models;

public class Product {

	private String name;
	private String desc;
	private Integer image;
	private boolean checked;

	public Product(String name, String desc, Integer image) {
		this.name = name;
		this.desc = desc;
		this.image = image;
		this.checked = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getImage() {
		return image;
	}

	public void setImage(Integer image) {
		this.image = image;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
