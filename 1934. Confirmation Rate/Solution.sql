-- Write your PostgreSQL query statement below
-- with total_reqs as (
--     select s.user_id, count(c.user_id) as total from Signups s 
--     left join Confirmations c 
--     on c.user_id = s.user_id
--     group by s.user_id
-- ), total_cons as (
--     select s.user_id, count(c.user_id) as cons from Signups s 
--     left join Confirmations c 
--     on c.user_id = s.user_id
--     where c.action = 'confirmed'
--     group by s.user_id
-- )

-- select r.user_id as user_id, 
--     (case when c.cons is null then 0 else round((c.cons::numeric/r.total::numeric)::decimal,2) end) as confirmation_rate  from total_reqs r 
-- left join total_cons c 
-- on r.user_id = c.user_id

select s.user_id, 
    round(avg(case when c.action = 'confirmed' then 1 else 0 end),2) as confirmation_rate
from Signups s 
left join Confirmations c on s.user_id = c.user_id
group by s.user_id

