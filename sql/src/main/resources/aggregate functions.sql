-- count
SELECT 
    COUNT(*) AS 'persons count'
FROM
    persons;

-- max
SELECT 
    MAX(first_name) AS 'alphabetically max first name'
FROM
    persons;

-- average
SELECT 
    AVG(birth_date) AS 'average birth date'
FROM
    persons;