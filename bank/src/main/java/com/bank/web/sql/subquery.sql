select count(*)
from emp
where sal >= (select avg(sal) from emp);

select eid 직원번호, ename 직원명, jid 업무번호
from emp
where (eid, jid) in (select eid, jid from job_his);

--
select
j.eid 사원번호,
(select e.ename from emp e where e.eid = j.eid) 사원명, 
j.did 부서번호,
(select d.dname from dep d where j.did = d.did) 부서명
from job_his j;

update emp e
set e.sal = (
   select sal 
   from ( select d.did, avg(e2.sal) as sal 
         from dep d, emp e2 
         where d.did=90  and d.did = e2.did
         group by d.did) t
   where e.did = t.did
)
where e.did in (
	select did from dep d2 where d2.did=90
);

select e.eid 사원번호, e.ename 사원명, d.did 부서번호, d.dname 부서명
from emp e, dep d, (
	select avg(e.sal) as avg_sal
	from dep d, emp e
	where d.did = 90 and d.did = e.did
) t
where e.did = d.did and e.sal > t.avg_sal;