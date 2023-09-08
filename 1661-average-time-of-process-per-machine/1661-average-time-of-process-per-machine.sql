# Write your MySQL query statement below
select distinct a.machine_id, round(
    (select avg(a1.timestamp) from Activity as a1 where a1.machine_id=a.machine_id and a1.activity_type='end') -
    (select avg(a2.timestamp) from Activity as a2 where a2.machine_id=a.machine_id and a2.activity_type='start'),3
) as 'processing_time' from Activity as a
