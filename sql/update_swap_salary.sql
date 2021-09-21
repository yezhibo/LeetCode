# 627.变更性别
# https://leetcode-cn.com/problems/swap-salary/

UPDATE salary
SET
    sex = CASE sex
        WHEN 'm' THEN 'f'
        ELSE 'm'
    END;
