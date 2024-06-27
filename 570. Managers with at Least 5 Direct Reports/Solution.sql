-- Write your PostgreSQL query statement below
select name from Employee a
join (
    select managerId, count(managerId) as reports 
    from Employee
    group by managerId
    having count(managerId) >= 5
) as b on a.id = b.managerId
