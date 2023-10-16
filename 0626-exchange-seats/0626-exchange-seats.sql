# Write your MySQL query statement below
select row_number() over() id, student from Seat order by if(id%2=0,id-1,id+1);