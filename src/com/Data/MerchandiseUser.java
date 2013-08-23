package com.Data;

public class MerchandiseUser {
	public static String table = "MerchandiseUser";
	public static String colId = "id";
	public static String colIdUser = "idUser";
	public static String colIdMerchandise = "idMerchandise";
	public static String colAmout = "amount";
	public static String colNameMerchandise = "nameMerchandise";

	private long id;
	private long idUser;
	private long idMerchandise;
	private long amout;
	private String nomeMerchandise;

	public MerchandiseUser() {
		// TODO Auto-generated constructor stub
	}

	public long getAmout() {
		return amout;
	}

	public void setAmout(long amout) {
		this.amout = amout;
	}

	public long getIdMerchandise() {
		return idMerchandise;
	}

	public void setIdMerchandise(long idMerchandise) {
		this.idMerchandise = idMerchandise;
	}

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeMerchandise() {
		return nomeMerchandise;
	}

	public void setNomeMerchandise(String nomeMerchandise) {
		this.nomeMerchandise = nomeMerchandise;
	}

}
