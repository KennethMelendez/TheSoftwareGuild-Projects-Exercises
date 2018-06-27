-- DROP DATABASE sgroster;

-- adding into the database
-- INSERT INTO Apprentice (FirstName, Lastname)
-- VALUES ('Bill','Smith');

-- SELECT * FROM Apprentice;
/*
INSERT INTO Apprentice (FirstName, LastName)
VALUES
('Bob','Jones'),
('Brenda','Walters'),
('Shauna', 'Mullins');
*/

-- SELECT * FROM Apprentice;
-- INSERT INTO Apprentice (ApprenticeID, FirstName,LastName)
-- VALUES (50,'Homer','Simpson');

-- SELECT * FROM cohort;

-- INSERT INTO Apprentice(ApprenticeID,CohortID)
-- Values(1,2);
-- Bill Smith Cohort 2

-- INSERT INTO Cohort (StartDate, Subject,Location)
-- VALUES ('2017/1/9','C#','Akron');

-- SELECT * FROM cohort;

-- INSERT INTO apprenticecohort
-- VALUES(1,1)
/*
INSERT INTO Cohort (StartDate, `Subject`, `Location`)
VALUES ('2017/1/9', 'Java', 'Akron');
 
INSERT INTO ApprenticeCohort(ApprenticeID, CohortID)
VALUES (2, 1), 
-- Bob, C# Akron
(3, 2), 
-- Brenda, Java Akron
(4, 2), 
-- Shauna, Java Akron
(50, 1); 
-- Bartholomew, C# Akron
*/
-- bob 2
-- SELECT * FROM apprenticecohort;

-- update example
-- UPDATE apprenticeCohort
-- set the new cohort id
-- SET CohortID = 2
-- where the apprentice id - 2
-- WHERE ApprenticeID = 2;

-- SELECT * FROM apprenticecohort;

-- can update multiple cohorts
/*
UPDATE ApprenticeCohort
SET CohortID = 1
WHERE ApprenticeID IN (3,4);
*/
-- SELECT * FROM apprenticecohort;

-- SQL HAS REFRENTIAL INTEGRITY cannot remove a refrenced data

-- SELECT * FROM COHORT;

-- DELETE FROM Cohort
-- WHERE CohortID = 2;

-- SELECT * FROM apprenticecohort;
-- UPDATE apprenticecohort
-- moving all cohorts to cohort 2
-- SET cohortID = 1 WHERE CohortID = 2;

-- SELECT * FROM apprenticecohort;

-- deleting
-- DELETE FROM Cohort WHERE CohortID = 2;
-- SELECT * FROM cohort;