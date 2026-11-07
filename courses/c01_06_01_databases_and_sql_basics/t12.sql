-- Занятие 12. Обновление записей.

-- 12.3.1. 
INSERT INTO Employees (LastName, FirstName, Title, TitleOfCourtesy, BirthDate, HireDate, Address, City,
    Region, PostalCode, Country, HomePhone, Extension, Notes, ReportsTo, PhotoPath)
VALUES ('Ivanov', 'Ivan', 'Sales Representative', 'Mr.', '1976-08-15', '2026-11-05', '85 Garrett Hill', 'Seattle',
    'WA', '98104', 'USA', '(206) 555-8596', '5126', 'New employee', NULL, NULL);

-- 12.3.2. 
INSERT INTO EmployeeTerritories (EmployeeID, TerritoryID)
VALUES (10, '98104');

-- 12.3.3. 
-- Конфликтов не возникло, запись успешно добавилась.
INSERT INTO Orders (CustomerID, EmployeeID, OrderDate, RequiredDate, ShippedDate, ShipVia, Freight,
    ShipName, ShipAddress, ShipCity, ShipRegion, ShipPostalCode, ShipCountry)
VALUES ('COMMI', 8, '1998-05-07', '1998-06-14', NULL, 1, 75.70,
    'Comércio Mineiro', 'Av. dos Lusíadas, 23', 'Sao Paulo', 'SP', '05432-043', 'Brazil');


/*
Рефлексия:
11.5.
Моё решение совпадает с эталонным.
*/

