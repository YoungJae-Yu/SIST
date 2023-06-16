SELECT * FROM EMPLOYEES;
SELECT * FROM EMP e;
-- 사원번호(empno), 사원명(ename), 직책(job)
SELECT empno, ename, job FROM emp;
-- 관리자번호(mgr), 입사일(hiredate), 급여(sal)
--보너스(comm), 부서번호(deptno)
-- 급여가 (3000이상 이거나 2000미만) 이고 부서명이 30이 아닌 데이터 검색
SELECT * FROM emp 
WHERE (SAL >= 3000 OR SAL < 2000) AND DEPTNO <> 30;
-- 사원명과 관리자번호(mgr)-null인 경우 출력
SELECT ename,mgr FROM EMP e
WHERE mgr IS NULL;
-- null이 아닌 경우만 중복되지 않는 관리자번호 출력
SELECT DISTINCT * FROM EMP e 
WHERE MGR IS NOT NULL 
-- 급여가2000이상이고 보너스가 null이 아닌 경우를 출력하세요
-- 직책이 SALEMAN이거나 부서번호가 20인 경우 사원명, 직책, 부서번호 출력















