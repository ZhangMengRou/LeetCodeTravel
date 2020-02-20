select Score,DENSE_RANK() OVER(ORDER BY Score DESC) AS Rank

from Scores 
