/*
1. 조인은 기본 inner 형식이 있다.

2. 조인 형식
	1) no equi join
		조인하는 두개의 테이블의 컬럼 값이 동일하지 않을 때
		조인하는 형식
		- 범위로 조인하는 경우
	
	2) outer join
		equi join의 조인 조건에서 양측 컬럼 값중, 어느 하나라도
		null이면 '=' 비교 결과가 거짓이 되어 null값을 가진 행은
		출력이 되지 않는다.
	
	3) self join
		테이블 컬럼안에 내부적으로 연관관계가 있는 컬럼간의 조인을 말한다.
 */
SELECT *
FROM emp e, DEPT d ;

SELECT ename, sal FROM emp;
-- 등급, 최소급여, 최대급여 : 해당 등급에 최소 최대 범위를 설정
SELECT ename, sal, grade
FROM emp e, SALGRADE s 
WHERE sal BETWEEN losal AND hisal;
-- ex1) SMITH의 급여와 급여 등급을 출력하세요.
SELECT ename, sal, grade
FROM emp e, SALGRADE s 
WHERE sal BETWEEN losal AND hisal
AND ename = 'SMITH';
-- ex2) SALESMAN의 급여과 등급을 출력하세요.
SELECT ename, sal, grade
FROM emp e, SALGRADE s 
WHERE sal BETWEEN losal AND hisal
AND job = 'SALESMAN';
/*
# subquery, inline view을 통한 조인 구문 처리
1. 조인하기전에, 데이터를 로딩해서 가져오는 형식을 subquery라고 한다.
	1) subquery에서 컬럼에 대한 비교 연산식으로 subquery를 가져오는
		형태가 있는 경우도 있고,
		select *
		from 테이블
		where 컬럼 = (sql 결과)
	2) sql 실행 결과를 테이블 형태로 선언(inline view)하여 처리하는
		형태가 있다.
		select *
		from (
			sql 결과
		)
		where...
 * */
-- 사원 정보중 최고 급여자의 사원 정보를 출력하세요..
SELECT max(sal)
FROM emp e;
SELECT *
FROM emp e
WHERE sal = (
	SELECT max(sal)
	FROM emp e
);
-- ex1) 사원번호가 가장 낮은 사원의 정보를 출력하세요..
SELECT *
FROM emp e
WHERE empno = (
	SELECT min(empno)
	FROM emp e
);
-- ex2) 사원중에서 가장 최근에 입사한 사원의 정보를 출력하세요.
SELECT *
FROM emp e
WHERE HIREDATE = (
	SELECT max(HIREDATE)
	FROM emp e
);
-- view : 가상테이블, inline view(sql을 통해서 테이블 형태와 같이 바로 처리하는 것을 말한다.)
SELECT *
FROM emp e,
(
	SELECT max(sal) sal
	FROM emp
) me
WHERE e.SAL = me. sal;
-- 부서별 최고 급여자에 대한 정보를 출력하고자 한다.
SELECT deptno, max(sal)
FROM emp
GROUP BY DEPTNO ;

SELECT e.*
FROM EMP e ,
(
	SELECT deptno, max(sal) sal
	FROM emp
	GROUP BY DEPTNO
) me
WHERE e.DEPTNO = me.deptno
AND e.SAL = me.sal
ORDER BY e.deptno;

SELECT * FROM emp;
-- ex) 직책별(job)로 가장 최근에 입사한 사원 정보를 출력하세요.
-- 1단계
SELECT job, max(HIREDATE) HIREDATE
FROM emp
GROUP BY job;
-- 2단계
SELECT e.*
FROM emp e,
(
	SELECT job, max(HIREDATE) HIREDATE
	FROM emp
	GROUP BY job
) je
WHERE e.job = je.job
AND e.HIREDATE = je.HIREDATE;