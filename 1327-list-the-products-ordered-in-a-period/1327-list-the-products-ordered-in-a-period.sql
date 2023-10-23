# Write your MySQL query statement below
select p.product_name as 'product_name', sum(o.unit) as 'unit' 
from orders as o join Products as p
on o.product_id=p.product_id
where o.order_date between '2020-02-01' and '2020-02-29'
group by o.product_id
having sum(o.unit)>=100