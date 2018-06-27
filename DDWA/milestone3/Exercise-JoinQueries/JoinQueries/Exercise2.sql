/*
	Get the Company Name, Order Date, and each order details 
	Product name for USA customers only.
*/

USE Northwind;

SELECT c.CompanyName , o.OrderDate , o.ShipCountry
FROM customers c
INNER JOIN orders o ON c.CustomerID = o.CustomerID
WHERE ShipCountry = 'USA';