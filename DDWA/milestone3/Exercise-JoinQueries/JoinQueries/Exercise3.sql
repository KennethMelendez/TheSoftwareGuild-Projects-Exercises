/*
	Get all the order information for any order where Chai was sold.
*/

USE Northwind;

SELECT o.*
FROM Products p
	INNER JOIN order_details od ON od.ProductID = p.ProductID
	INNER JOIN Orders o ON o.OrderID = od.OrderID
WHERE p.ProductName = 'Chai';
