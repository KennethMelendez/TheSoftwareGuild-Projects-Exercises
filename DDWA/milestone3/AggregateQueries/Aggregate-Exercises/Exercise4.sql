/*
	Get the count of how many employees work for the 
	company
*/

USE Northwind;

SELECT COUNT(FirstName) AS EmployeesInCompany 
FROM Employees
WHERE EmployeeID IS NOT NULL;