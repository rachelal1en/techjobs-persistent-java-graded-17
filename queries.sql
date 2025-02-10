--Part 1
--TODO Task 1 SQL - list the columns and their data types
select COLUMN_NAME, DATA_TYPE
from INFORMATION_SCHEMA.COLUMNS
where TABLE_NAME = 'job';
--Part 2
--TODO Task 2 SQL - list names of employers in STL city
SELECT name
FROM employer
WHERE location = "St. Louis City";
--Part 3
--TODO Task 3 SQL - remove the job table
DROP TABLE job;
--Part 4
--TODO Task 4 SQL - return the names of all skills attached to jobs alphabetically
SELECT *
FROM skill
INNER JOIN job_skills ON skill.id = job_skills.skills_id
WHERE job_skills.jobs_id IS NOT NULL
ORDER BY name ASC;