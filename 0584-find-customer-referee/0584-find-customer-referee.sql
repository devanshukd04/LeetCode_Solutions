# Write your MySQL query statement below
select name from Customer where isnull(referee_id) or referee_id!=2;