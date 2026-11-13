-- Занятие 15. Работа с базами данных.

-- 15.7. 
CREATE DATABASE MyTest;

USE MyTest;

CREATE TABLE Region (
	RegionID int NOT NULL,
	RegionDescription nchar(50) NOT NULL);

CREATE TABLE Territories (
	TerritoryID nchar(5) NOT NULL,
	TerritoryDescription nchar(50) NOT NULL,
	RegionID int NOT NULL);

INSERT INTO Region (RegionID, RegionDescription)
VALUES (1, 'Eastern'), (2, 'Western'), (3, 'Northern'), (4, 'Southern');

INSERT INTO Territories (TerritoryID, TerritoryDescription, RegionID)
VALUES ('90004', 'Los Angeles', 3), ('77001', 'Houston', 2), ('78201', 'San Antonio', 1);


/*
Рефлексия:
14.1.
Я перечислил изменения в списке выводимых полей (какие поля были добавлены, переименованы или исключены),
а в эталонном решении описано, что делает представление и его назначение.
14.2., 14.3., 14.4., 14.5.
В моем решении описана логика работы представления, а в эталонном - его практическое назначение.
*/

