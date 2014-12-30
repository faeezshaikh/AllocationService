BDD-project
===========

Example of using EasyB as BDD framework. Implementation of a composite design pattern.

**Problem Statement**

The client needs a small application that can calculate a department and/or manager’s monthly expense allocation based on the number and types of employees reporting to the manager or contained within the department.

**Specific Requirements**

- Developers warrant an allocation of $1000 each.
- QA Testers warrant an allocation of $500 each.
- Managers warrant an allocation of $300 each.
- Managers can have QA Testers, Developers and other managers report to them.
- Departments consist of any kinds of employees.
- Users of this application should be able to:

   - 	Determine the monthly expense allocation warranted a manager who has various employee types reporting to him/her at least two levels deep (Manager -> Manager -> Developer). The level of depth of the hierarchy should be flexible ideally.
   - 	Determine the monthly expense allocation warranted a department with various employee types under it at multiple levels deep just as the Manager can.
   
   
**Example Scenario**
 - For the given hierarchy:
   - Manager A
      -	Manager B
           - 	Developer
           - 	QA Tester
 - Manager A’s allocation should be: $2100



