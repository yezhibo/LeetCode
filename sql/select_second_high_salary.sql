# 176.第二高薪水
# https://leetcode-cn.com/problems/second-highest-salary/

# 需要考虑不存在第二高薪水的场景

select (select distinct Salary from employee order by salary desc limit 1 offset 1) as SecondHighestSalary;