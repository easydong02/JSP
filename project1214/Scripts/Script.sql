select dname, count(e.deptno)
from dept d, emp e 
where d.deptno =e.deptno
group by dname;

-- 그룹화 된 컬럼만이 출력대상이 될 수 있다..

select n.title,writer ,regdate ,hit ,count(c.news_id)
from news n ,comments c 
where n.news_id = c.news_id 
group by n.title,n.writer ,regdate ,hit  ;


select * from dept;
select * from emp;


-- 이너조인: 공통된 것만 가져옴

select *
from dept d ,emp e 
where d.deptno =e.deptno ;

-- 아우터 조인: 지정한 테이블의 레코드는 공통되지 않더라도 무조건 가져옴

select dname, count(e.empno)
from dept d left outer join emp e 
on d.deptno =e.deptno 
group by dname;

select news_id ,title ,writer ,regdate ,hit ,count(c.news_id) as 댓글수
from news n left outer join comments c 
on n.news_id = c.news_id 
group  by news_id ,title,writer ,regdate ,hit ;