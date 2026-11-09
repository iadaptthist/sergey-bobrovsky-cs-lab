-- Занятие 13. Обновление записей (2).

-- 13.3.1.
UPDATE [Order Details]
SET Discount = 0.20
WHERE ProductID IN (
  SELECT ProductID FROM Products
  WHERE UnitsInStock > 50);

-- 13.3.2.
UPDATE Contacts
SET City = 'Piter', Country = 'Russia'
WHERE City = 'Berlin' OR Country = 'Germany';

-- 13.3.3. 
-- Критерий удаления — значение ShipperID больше 3.
INSERT INTO Shippers(CompanyName, Phone)
VALUES ('DHL', '(503) 158-7851'),
	     ('Pony Express', '(503) 859-2365');

DELETE FROM Shippers
WHERE ShipperID > 3;
 

/*
Рефлексия:
12.3.
12.3.3.
Основной вывод:
Работая с модификацией таблицы напрямую, нужно думать о связанных таблицах. Заказ — это Orders + Order Details.
*/

