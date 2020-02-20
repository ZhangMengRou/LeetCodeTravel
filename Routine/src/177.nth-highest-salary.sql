/*
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
 SET N = N-1;
 RETURNS(
    select Salary from Employee 
    group by Salary
    order by Salary desc limit 1 offset N
 );
 END
 */