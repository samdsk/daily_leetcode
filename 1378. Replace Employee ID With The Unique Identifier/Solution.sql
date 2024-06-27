-- Write your PostgreSQL query statement below
SELECT EmployeeUNI.unique_id as unique_id, Employees.name as name 
FROM Employees 
LEFT JOIN EmployeeUNI ON Employees.id = EmployeeUNI.id;
