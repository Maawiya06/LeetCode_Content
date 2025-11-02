# Write your MySQL query statement below
SELECT Employee.name, Bonus.bonus
from Employee
left Join Bonus ON Employee.empId = Bonus.empId
where Bonus.bonus < 1000 or Bonus.bonus IS NULL;