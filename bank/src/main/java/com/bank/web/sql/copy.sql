CREATE TABLE emp_copy AS
SELECT employee_id 사원번호, last_name 성, salary 연봉
FROM employees;

SELECT * FROM emp_copy;