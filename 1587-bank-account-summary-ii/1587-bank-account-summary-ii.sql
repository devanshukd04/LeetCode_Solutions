# Write your MySQL query statement below
select name,balance from Users as u Inner Join
(select account,sum(amount) as balance from Transactions group by account having sum(amount)>10000) as t
where u.account=t.account;
