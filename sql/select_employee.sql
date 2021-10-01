# 181. 超过经理收入的员工
# https://leetcode-cn.com/problems/employees-earning-more-than-their-managers/

SELECT
    a.Name AS 'Employee'
FROM
    Employee AS a,
    Employee AS b
WHERE
    a.ManagerId = b.Id
        AND a.Salary > b.Salary