-- -- Write your PostgreSQL query statement below
-- with time_start as (
--     select * from Activity
--     where activity_type = 'start'
-- ), time_end as (
--     select * from Activity
--     where activity_type = 'end'
-- ), durations as (
--     select a.machine_id as "machine_id", a.process_id as "process_id", sum(b.timestamp - a.timestamp) as time_durations 
--     from time_end b, time_start a 
--     where a.machine_id = b.machine_id and a.process_id = b.process_id
--     group by a.machine_id, a.process_id
-- ), total_times as (
--     select machine_id, sum(time_durations) as total_time
--     from durations 
--     group by machine_id
-- )

-- select t.machine_id, round((t.total_time / count(distinct a.process_id))::decimal, 3) as "processing_time" from total_times as t
-- join Activity a on t.machine_id = a.machine_id
-- group by t.machine_id, t.total_time

select  machine_id,
    round(
        (sum(case when activity_type ='start' then -timestamp else timestamp end)
        / (select count(distinct process_id)))::decimal
    , 3) as processing_time
from 
    Activity
group by machine_id