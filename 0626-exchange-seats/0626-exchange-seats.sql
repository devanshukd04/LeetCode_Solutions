# Write your MySQL query statement below
select case 
    when id%2=0 then id-1
    when id%2<>0 AND id=(select count(*) from seat) then id
    else id+1
end as id, student  
from seat
order by id 