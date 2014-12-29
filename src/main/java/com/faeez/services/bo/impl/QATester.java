package com.faeez.services.bo.impl;

import java.math.BigDecimal;

import com.faeez.services.bo.Employee;

public class QATester implements Employee{
	private final static BigDecimal allocation = new BigDecimal("500");
	public QATester() {
		super();
	}
	@Override
	public BigDecimal getAllocation() {
		return QATester.allocation;
	}
	@Override
	public void add(Employee employee)  {
		// N/A. In some business cases you could throw an exception
		
	}
	@Override
	public void remove(Employee employee) {
		// N/A. In some business cases you could throw an exception
		
	}
}
