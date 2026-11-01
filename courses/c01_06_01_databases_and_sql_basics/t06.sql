-- Занятие 6. Группировка и фильтрация.

-- 6.3.1.
SELECT ContactType, COUNT(ContactType) as CONTACTS_COUNT
FROM Contacts
GROUP BY ContactType;

-- 6.3.2.
SELECT CategoryID, AVG(UnitPrice) as AVG_PRICE
FROM Products
GROUP BY CategoryID
ORDER BY AVG_PRICE;


/*
Рефлексия:
5.4.
Моё решение совпадает с эталонным.
 */

