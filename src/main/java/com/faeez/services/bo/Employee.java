package com.faeez.services.bo;

import java.math.BigDecimal;

public interface Employee {
	public void add(Employee employee);
	public void remove(Employee employee);
	public BigDecimal getAllocation();
}
