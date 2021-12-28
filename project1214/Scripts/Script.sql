select dname, count(e.deptno)
from dept d, emp e 
where d.deptno =e.deptno
group by dname;

-- �׷�ȭ �� �÷����� ��´���� �� �� �ִ�..

select n.title,writer ,regdate ,hit ,count(c.news_id)
from news n ,comments c 
where n.news_id = c.news_id 
group by n.title,n.writer ,regdate ,hit  ;


select * from dept;
select * from emp;


-- �̳�����: ����� �͸� ������

select *
from dept d ,emp e 
where d.deptno =e.deptno ;

-- �ƿ��� ����: ������ ���̺��� ���ڵ�� ������� �ʴ��� ������ ������

select dname, count(e.empno)
from dept d left outer join emp e 
on d.deptno =e.deptno 
group by dname;

select news_id ,title ,writer ,regdate ,hit ,count(c.news_id) as ��ۼ�
from news n left outer join comments c 
on n.news_id = c.news_id 
group  by news_id ,title,writer ,regdate ,hit ;