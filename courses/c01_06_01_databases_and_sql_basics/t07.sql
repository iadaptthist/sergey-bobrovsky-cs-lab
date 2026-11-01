-- Занятие 7. SQL: дополнительные возможности.

-- 7.3.1. 
SELECT OrderID, ProductID, Discount * 100 as Discount_percent
FROM [Order Details];

-- 7.3.2. 
SELECT * FROM [Order Details]
WHERE ProductID IN
 (SELECT ProductID FROM Products
  WHERE UnitsInStock > 40);

-- 7.3.3. 
SELECT * FROM [Order Details]
WHERE ProductID IN
 (SELECT ProductID FROM Products
  WHERE UnitsInStock > 40)
 AND OrderID IN
  (SELECT OrderID FROM Orders
   WHERE Freight >= 50);


/*
Рефлексия:
6.3.
Моё решение совпадает с эталонным.
*/
