/*
	Find the average freight paid for orders 
	placed by companies in the USA
*/

USE Northwind;

SELECT CompanyName , AVG(orders.Freight) AS AverageFright
FROM orders
INNER JOIN Customers ON Orders.CustomerID = Customers.CustomerID
WHERE Customers.Country = 'USA';