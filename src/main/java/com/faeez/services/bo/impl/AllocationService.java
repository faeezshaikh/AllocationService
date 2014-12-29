package com.faeez.services.bo.impl;

import java.math.BigDecimal;

import com.faeez.services.bo.Employee;

public class AllocationService {
	private Employee employee;

	public AllocationService(Employee employee) {
		super();
		this.employee = employee;
	}

	public BigDecimal getAllocation() {
		return employee.getAllocation();
	}

}
