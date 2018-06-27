/*
	Find the gross total (sum of quantity * unit price) for 
	all orders placed by B's Beverages and Chop-suey Chinese.
*/

USE Northwind;

-- SELECT CompanyName
-- FROM Customers

-- SELECT * FROM order_details;

Select SUM(od.UnitPrice * od.Quantity) AS GrandTotal
From order_details od
INNER JOIN orders o ON o.OrderID = od.OrderID
INNER JOIN Customers c ON c.CustomerID = o.CustomerID
WHERE c.CompanyName = "Chop-suey Chinese" OR c.CompanyName = "B's Beverages";