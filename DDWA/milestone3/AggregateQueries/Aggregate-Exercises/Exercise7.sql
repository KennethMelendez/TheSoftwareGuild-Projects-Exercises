/*
	Find the total sales by supplier 
	ordered from most to least.
*/

USE Northwind;

SELECT SUM(od.Quantity * od.UnitPrice) AS TotalSales, s.CompanyName
FROM Suppliers s
	INNER JOIN Products p ON s.SupplierID = p.ProductID
	INNER JOIN order_details od ON od.ProductID = p.ProductID
GROUP BY CompanyName
ORDER BY TotalSales DESC;	

