package com.faeez.services.bo.impl;

import java.math.BigDecimal;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class ManagerUnitTest {
	
	public Manager classUnderTest;
	
	@Test
	public void testConstructor_shouldReturnNewObject() {
		classUnderTest = new Manager();
		Assert.assertNotNull(classUnderTest);
	}
	@Test
	public void getAllocation_whenManagerHasNoEmployeeUnderHim_shouldReturn_300() {
		classUnderTest = new Manager();
		Assert.assertThat(classUnderTest.getAllocation(), Is.is(BigDecimal.valueOf(300)));
	}
	
	@Test
	public void getAllocation_whenManagersTeamSizeChanges_shouldReturn_CorrectAllocation() {
		classUnderTest = new Manager();
		Manager m1 = new Manager();
		Developer d1 = new Developer();
		QATester t1 = new QATester();
		classUnderTest.add(m1);
		Assert.assertThat(classUnderTest.getAllocation(), Is.is(BigDecimal.valueOf(600)));
		classUnderTest.add(d1);
		Assert.assertThat(classUnderTest.getAllocation(), Is.is(BigDecimal.valueOf(1600)));
		classUnderTest.add(t1);
		Assert.assertThat(classUnderTest.getAllocation(), Is.is(BigDecimal.valueOf(2100)));
		classUnderTest.remove(d1);
		Assert.assertThat(classUnderTest.getAllocation(), Is.is(BigDecimal.valueOf(1100)));
		
		
	}

}
