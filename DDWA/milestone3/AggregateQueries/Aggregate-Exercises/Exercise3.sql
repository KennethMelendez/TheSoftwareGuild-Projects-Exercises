/*
	Find the gross total of all orders (sum of quantity * unit price) 
	for each customer, order it in descending order by the total.
*/

USE Northwind;


-- SELECT * FROM products;
-- SELECT * FROM order_Details;


 SELECT c.CompanyName, SUM(Quantity * UnitPrice) AS GrossTotal
 FROM order_details od
 INNER JOIN orders o ON o.orderID = od.orderID
 INNER JOIN customers c ON c.CustomerID = o.CustomerID
 GROUP BY CompanyName
 ORDER BY GrossTotal DESC;
 
