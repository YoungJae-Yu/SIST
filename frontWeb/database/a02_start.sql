select * from emp;
select empno from emp;  -- ctrl + enter  ش           
select empno, ename from emp;
-- ex) empno, job, mgr, deptno   1, 2, 3, 4      ؼ    ȸ غ  ÿ 
select empno from emp;
select empno, job from emp;
select empno, job, mgr from emp;
select empno, job, mgr, deptno from emp;
select deptno, empno, ename from emp;
select ename, sal /*보게될 컬럼 지정*/
from emp
where sal >= 2000; /* 행단위로 비교연산자를 통한 검색*/
select *
from emp;
-- ex1) sal   2000 ̸              ˻  Ͻÿ 
-- ex2) sal   2000 ̻  4000 ̸              ˻  Ͻÿ 
--      and, or  ̿ 
select ename, sal 
from emp 
where sal<2000;
select ename, sal 
from emp 
where sal>=2000 and sal<4000;
select deptno, ename, sal
from emp
where sal < 2000 or sal >= 5000;
-- ex) empno          7500 ̸   ̰ų  7800 ̻          empno, ename, sal       Ͻÿ  
select empno, ename, sal
from emp
where empno < 7500 or empno >= 7800;
select *    -- colomn   ü      ( * )
from emp
where ename = 'SMITH';
-- = 비교연산자(sql에서는 대입연산자 없음.)
-- = :  񱳿     (   ϵ     )
-- '   ڿ ' :    ڿ         ǥ  
SELECT * FROM EMP;

-- ex1) sal   1250                 
select ename, sal
from emp
where sal = 1250;

-- ex2) job   CLERK             ߿  empno, ename, job
--             Ͻÿ 
select empno, ename, job
from emp
where job = 'CLERK';

/*
DB ==> ArrayList<Emp>
class Emp{
    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private Date hiredate;
    private double sal;
    private double comm;
    private int depno;
}
*/
select * from dept;
select * from emp; -- depno  ÷         

select *
from emp, dept
where emp.deptno = dept.deptno; --         𵨸        ȭ