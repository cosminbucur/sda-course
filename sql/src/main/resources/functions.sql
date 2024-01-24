-- function
DELIMITER $$
create FUNCTION add_two_ints(
a INT , -- parametr a of type int
b INT -- parametr b of type int
) RETURNS INT -- function returns an int
DETERMINISTIC -- https://dev.mysql.com/doc/refman/8.0/en/stored-programs-logging.html
READS SQL DATA
BEGIN -- body of the function
RETURN a + b;
END$$

-- use function:
SELECT add_two_ints(3, 5);

-- if else
DELIMITER $$
CREATE FUNCTION my_sign (a INT)
RETURNS INT
BEGIN
IF a > 0 THEN RETURN 1;
ELSEIF a = 0 THEN RETURN 0;
ELSE RETURN -1;
END IF;
END$$
SELECT my_sign(2);

-- loop
DELIMITER $$
CREATE FUNCTION my_power (a INT , b INT)
RETURNS INT
BEGIN
DECLARE result INT DEFAULT 1;
WHILE b > 0 DO -- while loop (with b > 0 condition)
SET result = result * a; -- set variable's value
SET b = b - 1;
END WHILE;
RETURN result;
END$$
SELECT my_power(2, 5);
