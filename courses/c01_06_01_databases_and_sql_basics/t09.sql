-- Занятие 9. SQL -- дополнительные возможности.

-- 9.4.1. 
SELECT t1.ContactName, t2.ContactName, t2.Region
FROM Customers t1, Customers t2
WHERE (t1.Region IS NULL) AND (t2.Region IS NULL) AND
      (t1.CustomerID <> t2.CustomerID);

-- 9.4.2. 
SELECT * FROM Orders t1
WHERE EXISTS
(SELECT * FROM Customers t2
WHERE (t1.CustomerID = t2.CustomerID) AND 
      (t2.Region IS NOT NULL);

-- 9.4.3. 
SELECT * FROM Orders
WHERE Freight > ALL
(SELECT UnitPrice FROM Products);


/*
Рефлексия:
8.3.
Моё решение совпадает с эталонным.
*/
