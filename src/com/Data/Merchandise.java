package com.Data;

public class Merchandise {
	public static String table="Merchandise";
	public static String colId="id";
	public static String colName="name";
	public static String colDescriptionl="description";
	public static String colCost="cost";
	private long id;
	private String name;
	private String description;
	private double cost;

	public Merchandise() {
		// TODO Auto-generated constructor stub
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
