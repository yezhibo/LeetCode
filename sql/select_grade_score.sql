# 178.分数排名
# https://leetcode-cn.com/problems/rank-scores/

select Score, dense_rank() over(order by Score desc) 'Rank'
from Scores