# 177.第n高的薪水
# https://leetcode-cn.com/problems/nth-highest-salary/

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  SET N := N-1;
  RETURN (
      # Write your MySQL query statement below.
      SELECT
                  salary
            FROM
                  employee
            GROUP BY
                  salary
            ORDER BY
                  salary DESC
            LIMIT N, 1
  );
END