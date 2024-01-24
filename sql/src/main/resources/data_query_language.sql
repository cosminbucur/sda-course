-- DQL (data query language)

-- select particular columns
SELECT
    first_name, last_name
FROM
    persons;

-- select distinct
SELECT DISTINCT
    first_name
FROM
    persons;

-- where clause
SELECT
    first_name, last_name, birth_date
FROM
    persons
WHERE
    first_name = 'Michael';

-- select as
SELECT
    first_name AS name,
    last_name AS surname
FROM
    persons;

-- select not null
SELECT
    COUNT(birth_date) AS 'persons that have date of birthed filled'
FROM
    persons;

-- group by
SELECT
    first_name,
    COUNT(*) AS 'occurrences count'
FROM
    persons
GROUP BY first_name;

-- having
SELECT
    first_name AS 'we have two or more people with such name!'
FROM
    persons
GROUP BY first_name
HAVING COUNT(*) > 1;

-- inner join
SELECT
    *
FROM
    employees
INNER JOIN
    departments ON
    employees.id_departments = departments.id_departments;

-- inner join (multiple tables)
SELECT
    employees.first_name,
    employees.last_name,
    departments.name AS 'department name'
FROM
    employees
INNER JOIN
    departments ON
    employees.id_departments = departments.id_departments;

-- inner join aliases
SELECT
    e.first_name, e.last_name, d.name AS 'department name'
FROM
    employees AS e
INNER JOIN
    departments AS d ON
    e.id_departments = d.id_departments;

-- inner join using
SELECT
    employees.first_name,
    employees.last_name,
    departments.name AS 'department name'
FROM
    employees
INNER JOIN
    departments USING (id_departments);

-- inner join (using equivalent)
SELECT
    *
FROM
    employees,
    departments
WHERE
    employees.id_departments = departments.id_departments;

-- left join
SELECT
    employees.first_name,
    employees.last_name,
    departments.name AS 'department name'
FROM
    employees
LEFT JOIN
    departments USING (id_departments);

-- cross join
SELECT
    *
FROM
    employees
        CROSS JOIN
    departments;

-- cross join 2
SELECT
    *
FROM
    employees, departments;

-- order by asc
SELECT
    *
FROM
    employees
ORDER BY last_name , first_name;

-- order by desc
SELECT
    *
FROM
    employees
ORDER BY last_name DESC;

-- limit
SELECT
    *
FROM
    employees
LIMIT 3;

-- limit 2
SELECT
    *
FROM
    employees
LIMIT 3 , 2;

-- union
SELECT
    first_name
FROM
    employees
UNION SELECT
    last_name
FROM
    employees;

-- case
SELECT
    CASE
        WHEN first_name LIKE 'M%' THEN 'name starts with M'
        WHEN first_name LIKE 'J%' THEN 'name starts with J'
        ELSE 'name does not start with M or J'
    END AS some_column_name
FROM
    employees;

-- exists
SELECT
    *
FROM
    employees
WHERE
    EXISTS(
		SELECT
            *
        FROM
            departments
        WHERE
            departments.id_departments = employees.id_departments
	);