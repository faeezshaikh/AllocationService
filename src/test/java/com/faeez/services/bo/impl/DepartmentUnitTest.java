package com.faeez.services.bo.impl;

import java.math.BigDecimal;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class DepartmentUnitTest {
	
	public Department classUnderTest;
	
	@Test
	public void testConstructor_shouldReturnNewObject() {
		classUnderTest = new Department();
		Assert.assertNotNull(classUnderTest);
	}
	
	@Test
	public void getAllocation_whenDepartmentHasOneManager_shouldReturn_300() {
		classUnderTest = new Department();
		classUnderTest.add(new Manager());
		Assert.assertThat(classUnderTest.getAllocation(), Is.is(BigDecimal.valueOf(300)));
	}
	
	@Test
	public void getAllocation_whenDepartmentSizeChanges_shouldReturn_CorrectAllocation() {
		classUnderTest = new Department();
		Manager m1 = new Manager();
		Developer d1 = new Developer();
		QATester t1 = new QATester();
		classUnderTest.add(m1);
		Assert.assertThat(classUnderTest.getAllocation(), Is.is(BigDecimal.valueOf(300)));
		classUnderTest.add(d1);
		Assert.assertThat(classUnderTest.getAllocation(), Is.is(BigDecimal.valueOf(1300)));
		classUnderTest.add(t1);
		Assert.assertThat(classUnderTest.getAllocation(), Is.is(BigDecimal.valueOf(1800)));
		classUnderTest.remove(d1);
		Assert.assertThat(classUnderTest.getAllocation(), Is.is(BigDecimal.valueOf(800)));
		
		
	}
	
	

}
