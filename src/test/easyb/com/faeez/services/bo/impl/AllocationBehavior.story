package com.faeez.services.bo.impl

/**
 *  Run this behavior with the "-html <location>" argument to generate an html report.
 *  For eg: -html ./AllocationBehaviorReport.html to generate the report in the current dir.
 */
description "Behavior of Allocation Calculation Service."


scenario "Manager has managers and employees under him",{
	given "ManagerA",{
		managerA = new Manager()
	}
	
	when "there is a managerB under him and this managerB in turn has a developer and tester under him", {
		managerB = new Manager()
		developer1 = new Developer()
		tester1 = new QATester()
		managerB.add(developer1)
		managerB.add(tester1)
		
		managerA.add(managerB)
	}
	
	then "total allocation should be 2100", {
		service = new AllocationService(managerA)
		service.getAllocation().shouldBe  BigDecimal.valueOf(2100)
	}
}

scenario "Manager has no employees reporting to him",{
	given "ManagerA",{
		managerA = new Manager()
	}
	
	when "there are no employees reporting this manager", {
	}
	
	then "total allocation should be 300", {
		service = new AllocationService(managerA)
		service.getAllocation().shouldBe  BigDecimal.valueOf(300)
	}
}

scenario "Manager has one developer and one tester under him",{
	given "ManagerA",{
		managerA = new Manager()
	}
	
	when "there is developer1 and tester1 reporting to this manager", {
		developer1 = new Developer()
		tester1 = new QATester()
		managerA.add(developer1)
		managerA.add(tester1)
	}
	
	then "total allocation should be 1800", {
		service = new AllocationService(managerA)
		service.getAllocation().shouldBe  BigDecimal.valueOf(1800)
	}
}

scenario "Department is Empty",{
	given "A Department",{
		department = new Department()
	}
	
	when "no employees are in the Department", {
	}
	
	then "total allocation should be Zero", {
		service = new AllocationService(department)
		service.getAllocation().shouldBe  BigDecimal.ZERO
		
	}
}

scenario "Department has two Developers",{
	
	given "A Department",{
		department = new Department()
	}
	
	when "2 developers are in the Department", {
		department.add(new Developer());
		department.add(new Developer());
	}
	
	then "total allocation should be 2000", {
		service = new AllocationService(department);
		service.getAllocation().shouldBe  BigDecimal.valueOf(2000)
	}
}

scenario "Department has a manager with one Tester and two Developers",{
	
	given "A Department",{
		department = new Department()
	}
	
	when "2 developers are in the Department", {
		managerA = new Manager()
		managerA.add(new QATester())
		managerA.add(new Developer())
		managerA.add(new Developer())
		department.add(managerA)
	}
	
	then "total allocation should be 2800", {
		service = new AllocationService(department);
		service.getAllocation().shouldBe  BigDecimal.valueOf(2800)
	}
}

