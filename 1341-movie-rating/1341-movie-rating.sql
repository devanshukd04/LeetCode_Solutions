# Write your MySQL query statement below
(select u.name as results from MovieRating as mr join Users as u on mr.user_id=u.user_id group by mr.user_id order by count(*) desc, u.name limit 1)
union all
(select m.title as results from MovieRating as mr join Movies as m on mr.movie_id=m.movie_id where mr.created_at like '2020-02-%' group by mr.movie_id order by avg(rating) desc, m.title limit 1)