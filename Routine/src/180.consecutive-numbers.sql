select Distinct Num as ConsecutiveNums
FROM (
    select 
    Num,
    lag(Num,1) over(order by id asc) as previous,
    Lead(Num,1) over(order by id asc) as Next
    from Logs
) a
WHERE a.Num = a.previous And a.Num = a.Next