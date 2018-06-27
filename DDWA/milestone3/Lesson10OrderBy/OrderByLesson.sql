USE northwind;

# The order keyword runs before the select statement
# so it has access to all the table columns

-- Let's start rather simple.
-- lets have a query that joins the products table with the categories table by the alter
-- categoryID foreign key value:
/*
SELECT CategoryName, ProductName,UnitPrice,UnitsInStock
FROM Categories
INNER JOIN Products ON Categories.CategoryID = Products.CategoryID;
-- we use order by to order our data
*/

-- alphebetical order
/*
SELECT CategoryName, ProductName, UnitPrice,UnitsInStock
FROM Categories
INNER JOIN Products ON Categories.CategoryID = Products.CategoryID
ORDER BY CategoryNAME;
*/

-- order by multiple columns
/*
SELECT CategoryName, ProductName, unitPrice, UnitsInStock
FROM Categories
INNER JOIN products ON Categories.CategoryID = Products.CategoryID
ORDER BY CategoryName, productNAME;
*/

-- reverse ascending order
/*
SELECT CategoryName, ProductName, UnitPrice, UnitsInStock
FROM Categories
INNER JOIN Products ON Categories.CategoryID = Products.CategoryID
ORDER BY CategoryName, UnitPrice DESC;
*/
/*
SELECT CategoryName, ProductName, UnitPrice, UnitsInStock
FROM Categories        
INNER JOIN Products ON Categories.CategoryID = Products.CategoryID
WHERE CategoryName = 'Confections'
ORDER BY UnitPrice DESC        
LIMIT 0,5;
*/


