# views
create view employees_with_dept_name as
    select
        employees.*, departments.name as department_name
    from
        employees
            left join
        departments using (id_departments);

# select view
select
* from employees_with_dept_name;