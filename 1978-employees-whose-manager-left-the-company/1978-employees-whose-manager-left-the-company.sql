# Write your MySQL query statement below

select employee_id from Employees where salary<30000 and manager_id in 
(select manager_id from Employees where manager_id not in (select employee_id from Employees))
order by employee_id
