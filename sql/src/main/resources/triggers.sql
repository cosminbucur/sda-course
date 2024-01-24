-- trigger
DELIMITER $$
create TRIGGER store_history BEFORE update ON employees
FOR EACH ROW
    BEGIN
        insert into employees_history
        values (new.id_employees , now(),
        old.first_name , old.last_name,
        new.first_name , new.last_name);
    END$$;

-- use trigger
update employees set first_name ='Lucy' where first_name='Kate';
