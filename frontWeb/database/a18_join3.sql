/*
# outer join
1. equi join의 조인 조건에서 양측 컬럼 값중, 어느 하나라도
	null이면 '=' 비교 결과가 거짓이 되어 null값을 가진 행은
	출력이 되지 않는다.
2. 부서번호에 해당하는 사원이 없으면 inner join 시 해당 부서정보를
	표시못하는 경우가 발생한다.
3. 즉, 해당 부서에 사원이 없더라도, 부서정보를 표시할 필요성이 있을 때는
	equi join으로 불가능하게 된다.
4. out join 처리 형식
	1) ANSI 방식
		WHERE 절의 조인 조건에서 OUTER JOIN 연산자의 (+) 기호
		사용하면 조인 조건에 의해 NULL로 출력되는 테이블의 컬럼 처리
*/
SELECT d.*, e.*
FROM emp e, dept d
WHERE e.DEPTNO(+) = d.DEPTNO
ORDER BY d.deptno;
SELECT dname 부서명, nvl(ename, '사원없음') 사원명
FROM emp e, dept d
WHERE e.DEPTNO(+) = d.DEPTNO
ORDER BY dname;
SELECT DISTINCT DEPARTMENT_ID
FROM EMPLOYEES e ;
SELECT *
FROM DEPARTMENTS d ;
-- ex) EMPLOYEES 와 DEPARTMENTS 의 DEPARTMENT_ID 기준으로
-- 부서별, 사원명(first_name)을 출력하되, 사원이 없는 곳은
-- 미배정이라고 표시하세요.
SELECT DEPARTMENT_NAME 부서명, nvl(first_name, '미배정') 사원명
FROM EMPLOYEES e, DEPARTMENTS d
WHERE e.DEPARTMENT_ID(+) = d.DEPARTMENT_ID
ORDER BY DEPARTMENT_NAME;
SELECT DEPARTMENT_NAME 부서명, count(first_name) 인원수
FROM EMPLOYEES e, DEPARTMENTS d
WHERE e.DEPARTMENT_ID(+) = d.DEPARTMENT_ID
GROUP BY DEPARTMENT_name
ORDER BY DEPARTMENT_NAME;
SELECT * FROM DEPARTMENTS d ;
/*
# self join
1. 테이블 컬럼안에 내부적으로 연관관계가 있는 컬럼간의 조인을 말한다.
2. 하나의 테이블내에 있는 컬럼끼리 연결하는 조인이 필요한 경우에 사용된다.
	조인 대상 테이블이 자신 하나라는 것 외는 equi join가 동일하다.
3. where 절을 사용하는 self join
	하나의 테이블에서 두 개의 컬럼을 연결하여 equi join
	from 절에서 하나의 테이블에 테이블의 별명을 따로 지정해서 처리.
4. 형식
	select a.*, b.*
	from 테이블 a, 테이블 b
	where a.컬럼 = b.컬럼
5. 사용예
	emp 테이블에서 empno와 mgr은 연관관계의 계층형 join관계로
	내부 join을 유지하고 있다.
	empno : 모든 사원 고유번호
	mgr : 해당 사원의 관리자 번호..
 	SMITH의 관리자 번호는 7902이고 이 관리자 이름은 FORD
  **/
SELECT EMPNO , ENAME , MGR
FROM emp;
SELECT EMPNO , ENAME , MGR
FROM emp
WHERE EMPNO = 7902;
SELECT EMPNO , ENAME , MGR
FROM emp
WHERE EMPNO = 7566;
SELECT EMPNO , ENAME , MGR
FROM emp
WHERE EMPNO = 7839;
SELECT e.empno 사원번호, e.ename 사원명, e.mgr 관리자번호,m.ename 관리자이름
FROM emp e , emp m
WHERE e.MGR = m.EMPNO;
-- 하위테이블의 mgr 과 상위테이블 empno 연관관계로 self join
SELECT '사원명 '||e.ename||'의 관리자는'||
e.ename||'입니다.' show
FROM emp e , emp m
WHERE e.MGR = m.EMPNO;


SELECT DISTINCT DEPTNO
FROM EMP;
SELECT ENAME, DEPTNO
FROM EMP
ORDER BY DEPTNO;
SELECT *
FROM DEPT;

SELECT * FROM emp;
--1. Group 함수 연습 예제:
--   1.1 직업별로 평균 급여를 계산하시오.
SELECT JOB 직업, avg(SAL) 평균급여
FROM emp
GROUP BY JOB;
--   1.2 각 부서별로 가장 높은 급여를 받는 사람을 찾으시오.
SELECT DEPTNO 부서번호, max(SAL) 최고급여
FROM emp
GROUP BY DEPTNO;	
--2. Subquery 연습 예제:
--   2.1 급여가 평균 급여보다 많이 받는 사원들의 이름과 급여를 찾으시오.
SELECT ename, sal
FROM emp
WHERE sal > (
	SELECT AVG(SAL)
	FROM EMP e 
);
--   2.2 Smith의 급여보다 많은 급여를 받는 사원들의 이름과 급여를 찾으시오.
SELECT ename, sal
FROM emp
WHERE sal > (
	SELECT SAL
	FROM EMP e
	WHERE ename = 'SMITH'
);
--3. Outer Join 연습 예제:
--   3.1 사원들의 이름과 부서 이름을 가져오시오. (부서에 할당되지 않은 사원도 포함)
SELECT nvl(ename, '사원없음') 사원명,dname 부서명
FROM emp e, dept d
WHERE e.DEPTNO(+) = d.DEPTNO
ORDER BY dname;
--   3.2 각 부서별로 최대 급여를 받는 사원의 이름을 가져오시오. (부서에 할당되지 않은 사원도 포함)
SELECT e.DEPTNO 부서, e.sal, nvl(e.ename, '사원없음') 사원명
FROM emp e,(
	SELECT DEPTNO ,max(sal) sal 
	FROM emp
	GROUP BY DEPTNO
) me
WHERE e.DEPTNO = me.deptno
AND e.SAL = me.sal;
--4. Group 함수와 Subquery를 조합한 연습 예제:
--   4.1 각 직업별로 최대 급여를 받는 사원의 이름을 가져오시오.
SELECT ename, e.*
FROM emp e,
(
	SELECT job, max(sal) sal
	FROM EMP
	GROUP BY job
) se
WHERE e.JOB = se.job
AND e.SAL = se.sal;
--   4.2 각 부서별로 최소 급여를 받는 사원의 이름을 가져오시오.
SELECT ename,e.sal,e.DEPTNO 
FROM emp e,
(
	SELECT DEPTNO, min(sal) sal
	FROM EMP
	GROUP BY DEPTNO
) se
WHERE e.DEPTNO = se.DEPTNO
AND e.SAL = se.sal;

   
   
   
   
   