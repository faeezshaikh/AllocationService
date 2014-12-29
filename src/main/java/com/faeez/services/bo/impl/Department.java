package com.faeez.services.bo.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.faeez.services.bo.Employee;

public class Department implements Employee {

	private List<Employee> employees = new ArrayList<Employee>();

	public Department() {
		super();
	}

	@Override
	public BigDecimal getAllocation() {
		BigDecimal totalAllocation = BigDecimal.ZERO;
		for (Employee e : employees) {
			totalAllocation = totalAllocation.add(e.getAllocation());
		}
		return totalAllocation;
	}

	@Override
	public void add(Employee employee) {
		employees.add(employee);
	}

	@Override
	public void remove(Employee employee) {
		employees.remove(employee);
	}

}
