-- Занятие 18. Заключительная практика: задачки по SQL для игры Dwarf Fortress.

-- 1.
SELECT D.dwarf_id, D.name AS dwarf_name, D.age, D.profession, S.squad_id, S.name AS squad_name, S.mission AS squad_mission
FROM Dwarves D
JOIN Squads S ON D.squad_id = S.squad_id;

-- 2.
SELECT * FROM Dwarves
WHERE profession = 'miner' AND squad_id IS NULL;

-- 3.
SELECT * FROM Tasks
WHERE priority = (SELECT MAX(priority) FROM Tasks) AND status = 'pending';

-- 4.
SELECT D.dwarf_id, D.name AS dwarf_name, D.age, D.profession, COUNT(I.item_id) AS items_count
FROM Dwarves D
JOIN Items I ON D.dwarf_id = I.owner_id
GROUP BY D.dwarf_id, D.name, D.age, D.profession;

-- 5.
SELECT S.squad_id, S.name AS squad_name, COUNT(D.dwarf_id) AS dwarves_count
FROM Squads S
LEFT JOIN Dwarves D ON D.squad_id = S.squad_id
GROUP BY S.squad_id, S.name;

-- 6.
SELECT D.profession, COUNT(T.task_id) AS unfinished_tasks_count
FROM Dwarves D
JOIN Tasks T ON D.dwarf_id = T.assigned_to
WHERE T.status IN ('pending', 'in_progress')
GROUP BY D.profession
ORDER BY unfinished_tasks_count DESC;

-- 7.
SELECT I.type, AVG(D.age) AS average_age
FROM Items I
JOIN Dwarves D ON I.owner_id = D.dwarf_id
GROUP BY I.type;

-- 8.
SELECT D.name AS dwarf_name, D.age, D.profession
FROM Dwarves D
WHERE D.age > (SELECT AVG(age) FROM Dwarves)
      AND D.dwarf_id NOT IN (SELECT owner_id FROM Items);

