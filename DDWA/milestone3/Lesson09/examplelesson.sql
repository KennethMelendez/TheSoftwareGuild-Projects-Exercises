DROP DATABASE northwind;

# SELECT CategoryID,CategoryName
# FROM categories
# WHERE categoryName IN ('condiments','dairy products');

#SELECT ProductID, CategoryID,ProductName, UnitsInStock
#FROM PRODUCTS
#WHERE CategoryID IN (2,4) AND UnitsInStock > 0;

#SELECT ProductID, CategoryID, CategoryName, ProductName, UnitsInStock
#FROM Products        
#INNER JOIN Categories                
#ON Products.CategoryID = Categories.CategoryID
#WHERE CategoryID IN (2, 4) AND UnitsInStock > 0;

#SELECT ProductID, Products.CategoryID, CategoryName, ProductName, UnitsInStock
#FROM Products
#INNER JOIN Categories ON Products.CategoryID = Categories.CategoryID
#WHERE Products.CategoryID IN (2, 4) AND UnitsInStock > 0;

#SELECT * FROM products;

#SELECT ProductID, Products.CategoryID, CategoryName, ProductName, UnitsInStock
#FROM Products
#INNER JOIN Categories ON Products.CategoryID = Categories.CategoryID
#WHERE Products.CategoryID IN (2, 4) AND UnitsInStock > 0;

#SELECT OrderDate, ProductName, Order_Details.UnitPrice, Quantity
#FROM Orders
#INNER JOIN Order_Details ON Orders.OrderID = Order_Details.OrderID
#INNER JOIN Products ON Products.ProductID = Order_Details.ProductID
#WHERE CustomerID = 'AROUT';

#SELECT OrderDate, productName, Order_details.UnitPrice, Quantity, CategoryName
#FROM Orders
#INNER JOIN Order_details
#ON Orders.OrderID = Order_Details.OrderID
#INNER JOIN Products
#ON Products.ProductID = Order_Details.ProductID
#INNER JOIN Categories 
#ON Products.CategoryID = Categories.CategoryID
#WHERE CustomerID = 'AROUT';


#SELECT CustomerID, OrderDate, LastName
#FROM Orders
#INNER JOIN Employees ON Orders.EmployeeID = Employees.EmployeeID
#WHERE OrderID BETWEEN 10248 AND 10255;

#SELECT CustomerID, OrderDate, IFNULL(LastName, 'Online') AS LastName
#FROM Orders
#LEFT JOIN Employees ON Orders.EmployeeID = Employees.EmployeeID
#WHERE OrderID BETWEEN 10248 AND 10255;