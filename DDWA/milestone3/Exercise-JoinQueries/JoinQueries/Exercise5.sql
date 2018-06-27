/*
	Find a list of all the Employees who have never found a Grant
*/

USE SWCCorp;
SELECT e.FirstName, e.LastName
FROM Employee e
	LEFT JOIN `Grant` g ON e.EmpID = g.EmpID
WHERE g.GrantID IS NULL;

/*
SELECT e.FirstName, e.LastName , g.GrantName , g.Amount , g.GrantID
FROM employee e
INNER JOIN `grant` g ON e.EmpID = g.EmpID
WHERE g.GrantID IS NULL;