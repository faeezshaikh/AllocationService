package com.faeez.services.bo.impl;

import java.math.BigDecimal;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class DeveloperUnitTest {
	
	public Developer classUnderTest;
	
	@Test
	public void testConstructor_shouldReturnNewObject() {
		classUnderTest = new Developer();
		Assert.assertNotNull(classUnderTest);
	}
	
	@Test
	public void getAllocation_shouldReturn_1000() {
		BigDecimal expenseAllocation = new BigDecimal("1000");
		classUnderTest = new Developer();
		BigDecimal response = classUnderTest.getAllocation();
		Assert.assertThat(response, Is.is(expenseAllocation));
	}
	
	

}
