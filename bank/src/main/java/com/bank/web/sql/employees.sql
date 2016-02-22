select * from tab;
-- 1. 사원 테이블 전체 검색
SELECT * FROM employees;
-- employee_id, first_name, last_name, email, phone_number, hire_date, job_id
-- salary, commission_pct, manager_id, department_id
SELECT * FROM DEPARTMENTS;

-- 1. 사원번호, 패밀리네임, 연봉만 출력
SELECT employee_id 사원번호, last_name 성, salary 연봉 FROM employees;

-- 2. 연봉 3000 이상인 사원
SELECT employee_id 사원번호, last_name 성, salary 연봉
FROM employees
WHERE salary >= 3000;

-- 3. 부서번호(department_id)이 100번인 사원
SELECT employee_id 사원번호, last_name 성, salary 연봉
FROM employees
WHERE department_id = 100;

-- 4. 입사일이 2000년 1월 1일 이후인 사원
SELECT employee_id 사원번호, last_name 성, salary 연봉
FROM employees
where hire_date >= '00/01/01';

-- 5. 부서가 100번이 아닌 사원
SELECT employee_id 사원번호, last_name 성, salary 연봉
FROM employees
where department_id != 100;

SELECT employee_id 사원번호, last_name 성, salary 연봉
FROM employees
where department_id <> 100;

-- 6. 연봉이 2000 ~ 3000 (이상, 이하) 사이인 사원
SELECT employee_id 사원번호, last_name 성, salary 연봉
FROM employees
where salary >= 2000 and salary <= 3000;

SELECT employee_id 사원번호, last_name 성, salary 연봉
FROM employees
WHERE salary BETWEEN 2000 AND 3000;

-- 7. 연봉이 2000 ~ 3000 (이상, 이하) 범위에 속하지 않는 사원
SELECT employee_id 사원번호, last_name 성, salary 연봉
FROM employees
WHERE salary not between 2000 and 3000;

-- 8. 커미션이 0.2, 0.3, 0.4인 사원
SELECT employee_id 사원번호, last_name 성, commission_pct 커미션
FROM employees
where commission_pct IN(0.2, 0.3, 0.4);

-- 9. 커미션이 0.2, 0.3, 0.4이 아닌 사원
SELECT employee_id 사원번호, last_name 성, commission_pct 커미션
FROM employees
where commission_pct NOT IN(0.2, 0.3, 0.4);

-- 10. 패밀리네임의 시작 알파벳이 k인 사원
SELECT employee_id 사원번호, last_name 성
FROM employees
WHERE last_name LIKE 'k%';

-- 11. 패밀리네임 중에 알파벳이 k인 사원
SELECT employee_id 사원번호, last_name 성
FROM employees
WHERE last_name LIKE '%k%';

-- 12. 패밀리네임 중에 세번째 알파벳이 a인 사원
SELECT employee_id 사원번호, last_name 성
FROM employees
WHERE last_name LIKE '__a%';

-- 13. 구글 계정을 사용하는 직원
SELECT employee_id 사원번호, last_name 성, email 이메일
FROM employees
WHERE email LIKE '%\@gmail.com%';

-- 14. 커미션을 받지 않는 직원 = 영업직이 아닌 사무직 지원
SELECT employee_id 사원번호, last_name 성, email 이메일
FROM employees
WHERE commission_pct IS null;

-- 15. 커미션을 받는 직원 = 사무직 지원
SELECT employee_id 사원번호, last_name 성, email 이메일
FROM employees
WHERE commission_pct IS NOT null;

-- 16. 연봉을 적게 받는 순으로 오름차순 정렬
SELECT employee_id 사원번호, last_name 성, email 이메일
FROM employees
ORDER BY salary DESC;

-- 17. 고액연봉순 직원리스트 (만일, 동일한 연봉을 받으면 패밀리네임에 따라 오름차순)
SELECT employee_id 사원번호, last_name 성, salary 연봉
FROM employees
ORDER BY salary DESC, last_name ASC;

-- 18. exist 문법
SELECT
e.employee_id 사원번호,
e.last_name 이름,
e.salary 연봉,
e.department_id 부서번호
FROM employees e
WHERE EXISTS
(SELECT d.department_id FROM department d
WHERE d.department_id IN(30,60,90) AND e.department_id = d.department_id);