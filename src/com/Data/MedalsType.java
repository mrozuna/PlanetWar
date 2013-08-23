package com.Data;

public class MedalsType {
	public static String table = "MedalsType";
	public static String colId = "id";
	public static String colName = "name";
	public static String colDescription = "description";

	private Long id;
	private String name;
	private String description;

	public MedalsType(Long id, String name, String description) {
		// TODO Auto-generated constructor stub
		this.setId(id);
		this.setName(name);
		this.setDescription(description);
	}

	public MedalsType() {

	}

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

}
