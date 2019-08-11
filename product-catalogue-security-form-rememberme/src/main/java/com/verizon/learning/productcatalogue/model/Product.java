package com.verizon.learning.productcatalogue.model;

public class Product {

	private String id;
	private String name;
	private String price;
	private String mfgDate;
	private String expDate;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return the mfgDate
	 */
	public String getMfgDate() {
		return mfgDate;
	}

	/**
	 * @param mfgDate
	 *            the mfgDate to set
	 */
	public void setMfgDate(String mfgDate) {
		this.mfgDate = mfgDate;
	}

	/**
	 * @return the expDate
	 */
	public String getExpDate() {
		return expDate;
	}

	/**
	 * @param expDate
	 *            the expDate to set
	 */
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", mfgDate=" + mfgDate + ", expDate=" + expDate + "]";
	}

}
