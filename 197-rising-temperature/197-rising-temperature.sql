# Write your MySQL query statement below
select w.id as 'Id' from Weather as w join weather weather on DATEDIFF(w.recordDate,weather.recordDate)=1 and w.temperature>weather.temperature;