CREATE VIEW emp_view AS
SELECT employee_id 사원번호, last_name 성, salary 연봉
FROM employees;

SELECT * FROM emp_view;
-- hr 스키마에 있는 테이블
SELECT * FROM countries;
SELECT * FROM country;
-- 나라
SELECT * FROM cnt;
SELECT * FROM departments;
-- 부서
SELECT * FROM dep;
SELECT * FROM employees;
-- 직원
SELECT * FROM emp;
SELECT * FROM locations;
-- 지역
SELECT * FROM loc;
SELECT * FROM jobs;
-- 업무
SELECT * FROM job;
SELECT * FROM job_history;
-- 연혁
SELECT * FROM job_his;
SELECT * FROM regions;
-- 위치
SELECT * FROM reg;

DROP VIEW cnt;
CREATE OR replace VIEW cnt AS
SELECT
country_id AS cid,
country_name AS cname,
region_id AS rid
FROM countries;

CREATE OR replace VIEW dep AS
SELECT
department_id AS did,
department_name AS dname,
manager_id AS mid,
location_id AS lid
FROM DEPARTMENTS;

CREATE OR replace VIEW emp AS
SELECT employee_id AS eid,
first_name ||' ' || last_name AS ename,
email,
phone_number AS phone_no,
hire_date AS hire_dt,
job_id AS jid,
salary AS sal,
commission_pct AS cms_pt,
manager_id AS mid,
department_id AS did
FROM EMPLOYEES;

CREATE OR replace VIEW job AS
SELECT
job_id AS jid,
job_title AS jname,
min_salary AS min_sal,
max_salary AS max_sal
FROM jobs;

CREATE OR replace VIEW job_his AS
SELECT employee_id AS eid,
start_date AS start_dt,
end_date AS end_dt,
job_id AS jid,
department_id AS did
FROM JOB_HISTORY;

CREATE OR replace VIEW loc AS
SELECT location_id AS lid,
street_address AS street,
postal_code AS zipcode,
city,
state_province AS state,
country_id AS cid
FROM LOCATIONS;

CREATE OR replace VIEW reg AS
SELECT region_id AS rid,
region_name AS rname
FROM REGIONS;