-- Занятие 10. JOIN.

-- 10.4.1. 
SELECT Products.ProductName, [Order Details].UnitPrice
FROM Products INNER JOIN [Order Details]
ON Products.ProductID = [Order Details].ProductID AND
   [Order Details].UnitPrice < 20

-- 10.4.2. 
SELECT Orders.Freight, Customers.CompanyName
FROM Orders FULL JOIN Customers
ON Orders.CustomerID = Customers.CustomerID
ORDER BY Freight;

-- За счёт чего выдача получилась объёмнее??
INNER JOIN возвращает только те записи, у которых есть совпадения в обеих таблицах
по условию Orders.CustomerID = Customers.CustomerID (830 записей).
А FULL JOIN возвращает все записи, в том числе записи с NULL (832 записи).

-- Почему значения NULL встречаются в обоих полях набора?
NULL в поле Freight - имеется покупатель, которому не соответствует заказ, в поле CompanyName - имеется заказ, 
которому не соответствует покупатель.
В примере, NULL встречается только в одном поле - Freight (есть покупатели, для которых нет заказов).

-- 10.4.3. 
Чтобы превратить CROSS JOIN в INNER JOIN, нужно добавить предложение WHERE с условием совпадения связанных
полей двух таблиц.

-- 10.4.4. 
SELECT Products.ProductName, [Order Details].UnitPrice
FROM Products INNER JOIN [Order Details]
ON Products.ProductID = [Order Details].ProductID;


/*
Рефлексия:
9.4.
Основное различие заключается в списке выводимых полей: я выводил все поля заказа (SELECT *),
а в эталонном решении выводится только ID заказа (SELECT OrderID).
*/

