/*
# where 조건문 처리
1. 행단위 데이터로 검색할 때 주로 사용된다.
2. where 조건절에는 컬럼명을 기준으로 여러가지 연산자를
	이용하여 조건 처리를 한다.
	1) 형식
		where 컬럼명 연산자형식 비교할 데이터
		ex) where ename like '%홍%'
		ex) where sal >= 3000
3. where 절에서 사용하는 데이터 타입은 문자, 숫자, 날짜 타입을 사용가능하다.
4. where절에는
	1) 비교연산자
		>,<,>=,<=,=, !=, <>
	2) 논리 연산자
		and, or, not
		등으로 사용되고,
	3) 그외 키워드 비교 연산 처리	
		컬럼명 between 데이터1 and 데이터2 컬럼명 in(데이터1, 데이터2, ...)	
		
			
				
					
	
*/
-- 숫자형 데이터 비교
SELECT * 
FROM emp
WHERE empno = 7369; 
-- 문자형 데이터 비교
SELECT *
FROM emp
WHERE JOB = 'SALESMAN';
-- ex) MGR이 7839인 데이터와, DEPTNO가 10
-- JOB이 'CLERT'인 데이터를 각각 출력하세요.

SELECT * 
FROM EMP
WHERE mgr = 7839;
SELECT * 
FROM EMP
WHERE deptno = 10;
SELECT * 
FROM EMP
WHERE job = 'CLERT';
/*
	ex) 부서번호가(deptno) 10번이고, 직책(job)이 CLERK인 경우
	사원번호 출력
*/
SELECT *FROM emp;
SELECT *FROM EMP
WHERE DEPTNO =10
AND job= 'CLERK';
-- ex) 급여(sal)가 2000이상이고, 직책(job)이 MANAGER인 데이터를 조회
SELECT * FROM emp
WHERE SAL >= 2000
AND job = 'MANAGER';
-- 2. 비교or비교
--	두 비교 중에 하나만 해당되더라도 출력되는 데이터..
-- ex) 사원명이 JONES, BLAKE 데이터를 출력
--SELECT *FROM EMP e 
--WHERE ENAME = ''
--Ex) 부서번호(DEPTNO)가 30 이거나 급여(SAL)가 20000미만인 데이터 출력
SELECT *FROM EMP
WHERE DEPTNO = 30
OR SAL < 20000;

/*
# 기타 비교 연산 처리 구문
1. !=(<>) : 같지 않을 때 TRUE
	NOT(조건문) : 해당 조건이 아닐 때,
2. IS NOT NULL : NULL이 아닐 때
		주의) 컬럼 !=NULL(다름) ==> 컬럼 = 'NULL'
	IS NULL : NULL 일 때, 조건 처리
*/
SELECT ename, COMM
FROM EMP e 
WHERE COMM = NULL; -- 'null'
SELECT ename, COMM
FROM EMP e 
WHERE COMM IS NULL; -- NULL 없음 데이터를 검색
SELECT ename, COMM
FROM EMP e 
WHERE COMM IS NOT NULL; -- NULL이 아닌 데이터를 검색
SELECT ename, COMM
FROM EMP e 
WHERE COMM != NULL; -- X
-- eX) mgr이 null인 데이터와 null이 아닌데이터를 나누어서 검색
SELECT *
FROM emp
WHERE MGR IS NULL;
SELECT *
FROM emp
WHERE MGR IS NOT NULL;
-- 부서번호가 20번이 아닌데이터를 검색해보자..
SELECT DEPTNO, ename
FROM EMP e 
WHERE DEPTNO !=20;
SELECT DEPTNO, ename
FROM EMP e 
WHERE DEPTNO <> 20;
SELECT DEPTNO, ename
FROM EMP e 
WHERE NOT(DEPTNO=20);
-- ex) 부서번호가 10이거나 20번인 경우와
SELECT DEPTNO, ename
FROM EMP e 
WHERE DEPTNO = 10
OR DEPTNO = 20;
SELECT DEPTNO, ename
FROM EMP e 
WHERE NOT(DEPTNO = 10)
OR NOT(DEPTNO = 20);
/*
# between A and B
	컬럼데이터를 A이상이고 B이하(A와B사이에 있음)
*/
-- sal가 1000에서 2000사이 있는 사원명과 급여명
SELECT ename, sal
FROM emp
WHERE sal BETWEEN 1000 AND 2000;
-- ex) 사원번호가 7600에서 7900사이에 있는 경우와 그렇지 않는 경우를 출력하세요
SELECT *
FROM EMP e 
WHERE EMPNO BETWEEN 7600 AND 7900;
SELECT *
FROM EMP e 
WHERE NOT (EMPNO BETWEEN 7600 AND 
7900);
SELECT *
FROM EMP e 
WHERE EMPNO < 7600 OR EMPNO > 7900;






