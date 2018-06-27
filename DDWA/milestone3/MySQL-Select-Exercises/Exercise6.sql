/*
   Select the orders shipping to the USA whose freight is 
   between $10 and $20
*/

USE Northwind;

SELECT * FROM orders
WHERE ShipCountry = "USA"
AND Freight > 10
AND Freight < 20;