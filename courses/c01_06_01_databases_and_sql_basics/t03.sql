-- Занятие 3. Принципы работы с базами данных.

-- 3.9.1. 
SELECT ProductName, UnitsInStock FROM Products;

-- 3.9.2. 
SELECT ProductName, UnitPrice FROM Products
WHERE UnitPrice < 20;

-- 3.9.3. 
SELECT * FROM Orders
WHERE (Freight >= 11.7) AND (Freight <= 98.1);

-- 3.9.4. 
SELECT * FROM Employees
WHERE (TitleOfCourtesy = 'Mr.') OR (TitleOfCourtesy = 'Dr.');

-- 3.9.5. 
SELECT * FROM Suppliers
WHERE Country = 'Japan';

-- 3.9.6. 
SELECT * FROM Orders
WHERE (EmployeeID = 2) OR (EmployeeID = 4) OR (EmployeeID = 8);

-- 3.9.7. 
SELECT OrderID, ProductID FROM [Order Details]
WHERE (UnitPrice > 40) AND (Quantity < 10);

/*
Рефлексия:
Задание 2.5.
Все связи, указанные в эталонном решении, я определил правильно.
Основное различие: я описал вообще все связи между таблицами, а в эталонном - только основные.
*/
