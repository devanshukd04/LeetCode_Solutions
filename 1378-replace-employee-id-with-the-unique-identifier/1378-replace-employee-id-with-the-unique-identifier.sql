# Write your MySQL query statement below
select unique_id, name from Employees as t1 left join EmployeeUNI as t2 on t1.id=t2.id;