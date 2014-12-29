package com.faeez.services.bo.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.faeez.services.bo.Employee;

public class Manager implements Employee{
	
	private final static BigDecimal allocation = new BigDecimal("300");
	private List<Employee> employees = new ArrayList<Employee>();
	
	public Manager() {
		super();
	}
	

	@Override
	public BigDecimal getAllocation() {
		BigDecimal totalAllocation = Manager.allocation;
		for(Employee e: employees) {
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
