/*
# 조인
1. 하나의 sql명령문에 의해 여러 테이블에 저장된 데이터를 한번에
	조회할 수 있는 기능을 말한다.
2. 관계형 데이터베이스 분야의 표준으로 자리 잡고 있다.
3. 두개 이상의 테이블을 결합한다는 의미이다.
4. 단계별 학습 내용
	1) 기본 조인 구문 형식 이해 및 활용
	2) 여러가지 조인 구문 형식 활용
	3) subquery, inline view을 통한 조인 구문 처리
		그룹함수 처리 후, 조인 처리 등
	4) 여러가지 복합 형식의 조인 구문 처리
# 기본 조인 구문 형식
1. 테이블과 테이블의 연관관계를 아래와 같이 설정한다.
	select 선택할 컬럼
	from 테이블1 별칭1, 테이블2 별칭2
	where 별칭1.공통컬럼 = 별칭2.공통컬럼
2. 위 기본 조인 구문 형식은 두개의 테이블을 공통 컬럼을
	기준으로 inner 조인하는 것을 말한다.
*/
SELECT DEPTNO , e. *
FROM emp e
ORDER BY e.DEPTNO ;
SELECT *
FROM dept;
-- emp테이블과 dept 테이블을 deptno를 기준으로 연관관계가 설정되어 있다.
-- 이때, 이 연관관계에 있는 컬럼을 조건으로 조인하는 것을
-- 기본 조인 구문인 inner 조인이라고 한다.
SELECT e.*, d.*
FROM emp e, dept d
WHERE e.DEPTNO = d.DEPTNO ;
-- e.* : emp 테이블의 alias명 e를 테이블명으로 하위에 있는
-- 컬럼을 접근할 때, 사용하고,
-- d.* : dept테이블의 alias명 d를 테이블명으로 하위에 있는
-- 컬럼을 접근할 때, 사용한다.
-- 일반적으로, 위 e.컬럼명, d.컬럼명을 두개의 테이블에서 
-- 공통되는 컬럼을 구분할 때, 사용된다. 공통된 컬럼이 아니면
-- 생략해도 무방하다.
SELECT empno, ename, e.deptno, dname, loc
FROM emp e, dept d
WHERE e.DEPTNO = d.DEPTNO;  
-- 두개의 공통을 구분해주어야 한다.
-- 두개의 테이블이 조인을 통해서 연관관계에 있는 컬럼의 내용을
-- 출력할 수 있다.
-- ex) 조인 구문을 이용하여 부서명, 사원명, 부서위치, 급여를 출력
SELECT dname, ENAME, loc, sal
FROM emp e, dept d
WHERE e.DEPTNO = d.DEPTNO ;
-- ex1) 조인을 이용하여 부서위치와 사원명을 검색하세요
SELECT * FROM emp;
SELECT loc, ename, dname
FROM emp e, dept d
WHERE e.DEPTNo = d.DEPTNO ;
-- 조인을 하면, 이 기준으로 지금까지 했던 조건, group, 함수처리
-- 내용을 연관하여 처리할 수 있다.
-- 부서위치를 기준으로 최고 급여 처리. 
SELECT loc, max(sal) 최고급여
FROM emp e, dept d
WHERE e.DEPTNO = d.DEPTNO 
GROUP BY loc;
-- 급여가 3000 이상인 부서명, 급여를 출력하세요
SELECT dname, sal 급여
FROM emp e, dept d
WHERE e.DEPTNO = d.DEPTNO
AND sal >= 3000;
SELECT * 
FROM EMPLOYEES e ;
SELECT *
FROM DEPARTMENTS d ;
-- ex) EMPLOYEES, DEPARTMENTS 두 테이블의 공통 컬럼을 확인하여,
-- inner 조인으로 처리하되
-- 조건으로 salary는 5000이상,
-- DEPARTMENT_ID은 Marketing이거나 Purchasing 데이터를 검색하여
-- 사원명, 급여, 부서명 출력
SELECT FIRST_NAME 사원명, SALARY 급여, DEPARTMENT_name 부서명
FROM EMPLOYEES e, DEPARTMENTS d
WHERE e.MANAGER_ID = d.MANAGER_ID
AND e.SALARY >= 5000
--AND (d.DEPARTMENT_NAME ='Marketing' OR d.DEPARTMENT_name='Purchasing');
AND DEPARTMENT_name IN('Marketing','Purchasing');














