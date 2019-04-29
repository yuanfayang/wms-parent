package com.deer.wms.bill.manage.model;

/*
 * 计算货位利用率，包含分子和分母
 */

public class MtAloneProductDetUtilVO {
	
	private double denominator;//分母

	private double numerator;//分子

	/**
	 * @return the denominator
	 */
	public double getDenominator() {
		return denominator;
	}

	/**
	 * @param denominator the denominator to set
	 */
	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	/**
	 * @return the numerator
	 */
	public double getNumerator() {
		return numerator;
	}

	/**
	 * @param numerator the numerator to set
	 */
	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	
}
