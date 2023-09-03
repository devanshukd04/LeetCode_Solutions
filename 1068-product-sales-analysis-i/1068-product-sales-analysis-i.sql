# Write your MySQL query statement below
select product_name, year, price from Sales as s left join Product as p on s.product_id=p.product_id;