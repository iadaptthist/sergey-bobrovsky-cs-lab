-- Занятие 20. Заключительная практика: усложняем задание.

-- 1. 
SELECT
    squad_id,
    name
FROM
    Squads
WHERE
    leader_id IS NULL;

-- 2. 
SELECT
    dwarf_id,
    name,
    age
FROM
    Dwarves
WHERE
    age > 150 AND profession = 'Warrior';

-- 3.
SELECT DISTINCT
    D.dwarf_id,
    D.name,
    D.age,
    D.profession
FROM
    Dwarves D
JOIN
    Items I
ON
    D.dwarf_id = I.owner_id
WHERE
    I.type = 'weapon';

-- 4. 
SELECT
    assigned_to,
    status,
    COUNT(*) AS task_count
FROM
    Tasks
GROUP BY
    assigned_to, status;

-- 5. 
SELECT
    T.task_id,
    T.description,
    T.assigned_to,
    T.status
FROM
    Tasks T
JOIN
    Dwarves D
ON
    T.assigned_to = D.dwarf_id
JOIN
    Squads S
ON
    D.squad_id = S.squad_id
WHERE
    S.name = 'Guardians';

-- 6.
SELECT     
    D1.name AS dwarf_name,    
    D2.name AS relative_name,    
    R.relationship
FROM     
    Dwarves D1
LEFT JOIN     
    Relationships R 
ON 
    D1.dwarf_id = R.dwarf_id
LEFT JOIN     
    Dwarves D2 
ON 
    R.related_to = D2.dwarf_id;

