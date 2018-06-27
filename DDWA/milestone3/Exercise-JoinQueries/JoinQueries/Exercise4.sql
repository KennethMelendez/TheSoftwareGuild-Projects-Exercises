/*
	Write a query to show every combination of employee and location.
*/

USE SWCCorp;

SELECT e.LastName , e.FirstName , l.Street , l.City , l.STATE
FROM employee e
CROSS JOIN location l ON e.LocationID = l.LocationID;
