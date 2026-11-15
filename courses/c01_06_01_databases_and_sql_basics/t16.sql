-- Занятие 16. Ключи и индексы.

-- Без изменения таблицы, созданной в предыдущем занятии.
CREATE CLUSTERED INDEX idxRegionRegionID ON Region (RegionID);

CREATE CLUSTERED INDEX idxTerritoriesTerritoryID ON Territories (TerritoryID);

CREATE INDEX idxTerritoriesRegionID ON Territories (RegionID);

-- С изменением таблицы.
CREATE DATABASE MyTest;

USE MyTest;

CREATE TABLE Region (
	RegionID int PRIMARY KEY, -- добавил PRIMARY KEY
	RegionDescription nchar(50) NOT NULL);

CREATE TABLE Territories (
	TerritoryID nchar(5) PRIMARY KEY, -- добавил PRIMARY KEY
	TerritoryDescription nchar(50) NOT NULL,
	RegionID int NOT NULL);

INSERT INTO Region (RegionID, RegionDescription)
VALUES (1, 'Eastern'), (2, 'Western'), (3, 'Northern'), (4, 'Southern');

INSERT INTO Territories (TerritoryID, TerritoryDescription, RegionID)
VALUES ('90004', 'Los Angeles', 3), ('77001', 'Houston', 2), ('78201', 'San Antonio', 1);

-- Решение задания занятие 16.
CREATE INDEX idxTerritoriesRegionID ON Territories (RegionID);

