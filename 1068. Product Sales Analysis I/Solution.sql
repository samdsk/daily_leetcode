-- Write your PostgreSQL query statement below
select p.product_name, s.year, s.price 
from Sales as s 
inner join Product as p on s.product_id = p.product_id; 