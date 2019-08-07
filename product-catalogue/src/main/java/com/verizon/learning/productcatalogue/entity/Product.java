package com.verizon.learning.productcatalogue.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "PRODUCTS")
@Entity
public class Product {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PRICE")
	private Double price;

	@Column(name = "MFG_DATE")
	private Date mfgDate;

	@Column(name = "EXP_DATE")
	private Date expDate;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
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
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the mfgDate
	 */
	public Date getMfgDate() {
		return mfgDate;
	}

	/**
	 * @param mfgDate
	 *            the mfgDate to set
	 */
	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
	}

	/**
	 * @return the expDate
	 */
	public Date getExpDate() {
		return expDate;
	}

	/**
	 * @param expDate
	 *            the expDate to set
	 */
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

}
