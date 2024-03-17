package com.lcwsankalp.recilance4j;

public class MenuDto {
	private int id;
	private String dishName;
	private String category;
	private double prize;
	public MenuDto() {
		super();
	}
	public MenuDto(int id, String dishName, String category, double prize) {
		super();
		this.id = id;
		this.dishName = dishName;
		this.category = category;
		this.prize = prize;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrize() {
		return prize;
	}
	public void setPrize(double prize) {
		this.prize = prize;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", dishName=" + dishName + ", category=" + category + ", prize=" + prize + "]";
	}
	
	

}
