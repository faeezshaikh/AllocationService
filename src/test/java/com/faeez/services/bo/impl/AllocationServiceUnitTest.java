package com.faeez.services.bo.impl;

import java.math.BigDecimal;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import com.faeez.services.bo.Employee;

public class AllocationServiceUnitTest {

	public AllocationService service;

	@Test
	public void testConstructor_shouldReturnNewObject() {
		service = new AllocationService(null);
		Assert.assertNotNull(service);
	}
	
	/***
	 * 			ManagerA
				   |
		---------------------------
	    |     |     |      |      |
	    T1	  T2    D1     D2    Mgr1
	    						  |
	    					-------------
	    					|			|
	    					T3			D3
	    
	    Total should be = $5100
	 * 
	 */
	
	@Test
	public void getAllocation_whenManagerHasTwoTestersTwoDevelopersOneManagerWithOneTesterAndOneDeveloper_shouldReturn_5100() {
		Employee managerA = new Manager();
		BigDecimal expectedallocation = new BigDecimal("5100");
	
		managerA.add(new QATester());
		managerA.add(new QATester());
		managerA.add(new Developer());
		managerA.add(new Developer());
		
		Manager mgr1 = new Manager();
		mgr1.add(new QATester());
		mgr1.add(new Developer());
		managerA.add(mgr1);
		
		service = new AllocationService(managerA);
		Assert.assertNotNull(service);
		Assert.assertThat(service.getAllocation(), Is.is(expectedallocation));
	}
	
	
	
	/**			ManagerA
		   			|
	---------------------------
	|     |     |      |      |
	T1	  T2    D1     D2    Mgr1
						  	  |
						-------------
						|			|
						T3		   Mgr2
									|
								--------
									|
									D3
	
		Total should be = $5400
	 * 
	 */
	@Test
	public void getAllocation_whenManagerHasTwoTestersTwoDevelopersOneManagerWithOneTesterAndOneMgrWithOneDev_shouldReturn_5400() {
		Employee managerA = new Manager();
		BigDecimal expectedallocation = new BigDecimal("5400");

		managerA.add(new QATester());
		managerA.add(new QATester());
		managerA.add(new Developer());
		managerA.add(new Developer());

		Manager mgr1 = new Manager();
		mgr1.add(new QATester());
		Manager mgr2 = new Manager();
		mgr2.add(new Developer());
		mgr1.add(mgr2);
		managerA.add(mgr1);

		service = new AllocationService(managerA);
		Assert.assertNotNull(service);
		Assert.assertThat(service.getAllocation(), Is.is(expectedallocation));
	}

	/**					Manager1
	*						|
			-----------------------------------
			|     |     |      |      |		  |
			T1	  T2    D1     D2    Mgr2    Mgr3
			
	
				Total should be = $3900
	 * 
	 */

	@Test
	public void getAllocation_whenManagerHasTwoTestersTwoDevelopersTwoManagers_shouldReturn_3900() {
		Employee managerA = new Manager();
		BigDecimal expectedallocation = new BigDecimal("3900");
		managerA = new Manager();
		managerA.add(new Manager());
		managerA.add(new Manager());
		managerA.add(new QATester());
		managerA.add(new QATester());
		managerA.add(new Developer());
		managerA.add(new Developer());
		service = new AllocationService(managerA);
		Assert.assertNotNull(service);
		Assert.assertThat(service.getAllocation(), Is.is(expectedallocation));
	}
	
	/**
	 * 			 Manger A
	 * 				|		
	 *   		 -------
	 *  		 	|
	 *  		 Manager B
	 *  			|
	 *  		---------
	 *  		|		|
	 *  		D1		T1
	 *  
	 * Total Should be $2100
	 * 
	 */
	@Test
	public void getAllocation_whenManagerHasOneManagerAndTwoEmployees_shouldReturn_2100() {
		Employee managerA = new Manager();
		Employee managerB = new Manager();
		Employee developer1 = new Developer();
		Employee tester1 = new QATester();
		managerB.add(developer1);
		managerB.add(tester1);
		managerA.add(managerB);

		service = new AllocationService(managerA);
		Assert.assertNotNull(service);
		Assert.assertThat(service.getAllocation(), Is.is(BigDecimal.valueOf(2100)));
	}
	
	@Test
	public void getAllocation_whenManagerHasNoSubordinates_shouldReturn_300() {
		Employee managerA = new Manager();
		service = new AllocationService(managerA);
		Assert.assertNotNull(service);
		Assert.assertThat(service.getAllocation(), Is.is(BigDecimal.valueOf(300)));
	}

	@Test
	public void getAllocation_whenManagerHasTwoDevelopers_shouldReturn_2300() {
		Employee managerA = new Manager();
		managerA.add(new Developer());
		managerA.add(new Developer());
		BigDecimal expectedallocation = new BigDecimal("2300");
		service = new AllocationService(managerA);
		Assert.assertNotNull(service);
		Assert.assertThat(service.getAllocation(), Is.is(expectedallocation));
	}
	
	@Test
	public void getAllocation_whenManagerHasTwoTesters_shouldReturn_1300() {
		Employee managerA = new Manager();
		managerA.add(new QATester());
		managerA.add(new QATester());
		BigDecimal expectedallocation = new BigDecimal("1300");
		service = new AllocationService(managerA);
		Assert.assertNotNull(service);
		Assert.assertThat(service.getAllocation(), Is.is(expectedallocation));
	}
	
	@Test
	public void getAllocation_whenManagerHasTwoTestersTwoDevelopers_shouldReturn_3300() {
		Employee managerA = new Manager();
		BigDecimal expectedallocation = new BigDecimal("3300");
		managerA.add(new QATester());
		managerA.add(new QATester());
		managerA.add(new Developer());
		managerA.add(new Developer());
		service = new AllocationService(managerA);
		Assert.assertNotNull(service);
		Assert.assertThat(service.getAllocation(), Is.is(expectedallocation));
	}

	@Test
	public void getAllocation_whenDepartmentIsEmpty_shouldReturn_Zero() {
		Employee department = new Department();
		service = new AllocationService(department);
		Assert.assertNotNull(service);
		Assert.assertThat(service.getAllocation(), Is.is(BigDecimal.ZERO));
	}

	@Test
	public void getAllocation_whenDepartmentHasTwoDevelopers_shouldReturn_2000() {
		Employee department = new Department();
		department.add(new Developer());
		department.add(new Developer());
		service = new AllocationService(department);
		Assert.assertNotNull(service);
		Assert.assertThat(service.getAllocation(),Is.is(BigDecimal.valueOf(2000)));

	}

	@Test
	public void getAllocation_whenDepartmentHasTwoTesters_shouldReturn1000() {
		BigDecimal expectedAllocation = new BigDecimal("1000");
		Employee department = new Department();
		department.add(new QATester());
		department.add(new QATester());
		service = new AllocationService(department);
		Assert.assertNotNull(service);
		Assert.assertThat(service.getAllocation(), Is.is(expectedAllocation));
	}

	@Test
	public void getAllocation_whenDepartmentHasTwoTestersTwoDevelopers_shouldReturn_3000() {
		BigDecimal expectedAllocation = new BigDecimal("3000");
		Employee department = new Department();
		department.add(new QATester());
		department.add(new QATester());
		department.add(new Developer());
		department.add(new Developer());
		service = new AllocationService(department);
		Assert.assertNotNull(service);
		Assert.assertThat(service.getAllocation(), Is.is(expectedAllocation));
	}

	/*
	 * Department --> T1, T2, D1, D2, M1, M2
	 * Total Should be $3600
	 */
	@Test
	public void getAllocation_whenDepartmentHasTwoTestersTwoDevelopersTwoManagers_shouldReturn_3600() {
		BigDecimal expectedAllocation = new BigDecimal("3600");
		Employee department = new Department();
		department.add(new QATester());
		department.add(new QATester());
		department.add(new Developer());
		department.add(new Developer());
		department.add(new Manager());
		department.add(new Manager());
		service = new AllocationService(department);
		Assert.assertNotNull(service);
		Assert.assertThat(service.getAllocation(), Is.is(expectedAllocation));
	}

	/*
	 * 				Department
	 * 					|		
	 *   --------------------------------
	 *   |  	|		|		|		|
	 *  T1		T2		D1	    D2		Mgr1
	 *  								|
	 *  							---------
	 *  							|		|
	 *  							T3		D3
	 * Total Should be $4800
	 */
	
	@Test
	public void getAllocation_whenDepartmentHasTwoTestersTwoDevelopersOneManagerWithOneTesterAndOneDeveloper_shouldReturn_4800() {
		BigDecimal expectedAllocation = new BigDecimal("4800");
		Employee department = new Department();

		department.add(new QATester());
		department.add(new QATester());
		department.add(new Developer());
		department.add(new Developer());

		Manager m1 = new Manager();
		m1.add(new QATester());
		m1.add(new Developer());
		department.add(m1);

		service = new AllocationService(department);
		Assert.assertNotNull(service);
		Assert.assertThat(service.getAllocation(), Is.is(expectedAllocation));
	}

	/*
	 * 			Department
	 * 				|		
	 *   		---------
	 *  		 	|
	 *  		   Mgr1
	 *  			|
	 *  		---------
	 *  		|		|
	 *  		T1		D1
	 *  
	 * Total Should be $1800
	 * 
	 */
	
	@Test
	public void getAllocation_whenDepartmentHasOneManagerAndTwoEmployees_shouldReturn_1800() {
		Employee department = new Department();
		Employee managerB = new Manager();
		Employee developer1 = new Developer();
		Employee tester1 = new QATester();
		managerB.add(developer1);
		managerB.add(tester1);
		department.add(managerB);

		service = new AllocationService(department);
		Assert.assertNotNull(service);
		Assert.assertThat(service.getAllocation(),
				Is.is(BigDecimal.valueOf(1800)));
	}
	
	
}
