/*
	Get a list of each employee first name and lastname
	and the territory names they are associated with
*/

-- USE Northwind;

SELECT e.FirstName,e.LastName, t.TerritoryDescription
FROM employees e
INNER JOIN employeeterritories et ON e.EmployeeID = et.EmployeeID
INNER JOIN territories t ON t.TerritoryID = et.TerritoryID;
-- WHERE EmployeeID = TerritoryID;

/*
SELECT e.FirstName, e.LastName, t.TerritoryDescription
FROM Employees e
	INNER JOIN EmployeeTerritories et ON e.EmployeeID = et.EmployeeID
	INNER JOIN Territories t ON et.TerritoryID = t.TerritoryID;
    */