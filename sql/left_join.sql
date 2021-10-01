# 175.组合两个表
# https://leetcode-cn.com/problems/combine-two-tables/

select person.firstName as FirstName,person.lastName as LastName,address.city as City,address.state as State
from Person as person left join Address as address on person.personId = address.personId;