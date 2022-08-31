# Write your MySQL query statement below
# select name,sum(distance) as travelled_distance where user_id in (select )
select name,IFNULL(sum(distance),0) as travelled_distance from Users as u Left Join Rides as r on u.id=r.user_id group by r.user_id order by travelled_distance desc,name;