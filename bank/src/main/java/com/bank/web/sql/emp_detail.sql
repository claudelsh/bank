-- 복합뷰
CREATE OR replace VIEW emp_detail AS
SELECT
e.eid AS eid,
e.ename AS ename,
e.email AS email,
e.phone_no AS phone,
e.sal AS sal,
e.hire_dt AS hire_dt,
e.did AS did,
d.dname AS dname, 
j.jname AS jname,
e.mid AS mid
FROM emp e, dep d, job j
WHERE e.did = d.did AND e.jid = j.jid AND e.mid = d.mid
ORDER BY eid DESC;