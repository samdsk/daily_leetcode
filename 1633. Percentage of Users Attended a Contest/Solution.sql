-- Write your PostgreSQL query statement below
select r.contest_id, round((count( distinct u.user_id) * 100)::numeric / (select count(user_id) from Users),2) as percentage
from Register r 
join Users u on r.user_id = u.user_id
group by r.contest_id
order by percentage DESC, contest_id ASC