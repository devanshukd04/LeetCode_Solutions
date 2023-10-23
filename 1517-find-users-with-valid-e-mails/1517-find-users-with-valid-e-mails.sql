# Write your MySQL query statement below
select * from Users 
where mail regexp '^[A-Za-z][A-Za-z0-9_\.\-]*@leetcode(\\?com)?\\.com$';