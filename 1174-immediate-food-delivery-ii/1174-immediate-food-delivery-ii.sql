# Write your MySQL query statement below
select 
round(avg(case when order_date=customer_pref_delivery_date then 1 else 0 end)*100,2) as immediate_percentage
from Delivery 
where (customer_id, order_date) in
(select customer_id, min(order_date) 
from Delivery
group by customer_id)
