/*
# 그룹함수란?
1. 테이블의 전체 행을 하나 이상의 컬럼을 기준으로 그룹화하여
그룹별로 결과를 출력하는 함수, 그룹함수는 통계적인 결과를 출력하는데
자주 사용한다.
2. 기본형식
	select 기준컬럼, 그룹함수(컬럼)
	from 테이블명
	where
	group by 그룹컬럼
	hacing 그룹 함수를 적용한 결과를 조건 처리
3. 그룹함수의 종류
	1) count() : null을 제외한 데이터의 건수, 행의 건수
	2) max() : null을 제외한 모든 행의 최대값
	3) min() : null을 제외한 모든 행의 최소값
	4) sum() : null을 제외한 모든 행의 합
	5) avg() : null을 제외한 모든 행의 평균값
	6) stddev() : null을 제외한 모든 행의 표준편차
	7) variance() : null을 제외한 모든 행의 분산값
	

*/
SELECT comm
FROM emp;

SELECT count(COMM) 
FROM emp;
-- emp 테이블에서 comm의 전체 컬럼의 null을 제외한 데이터 건수
SELECT max(COMM),min(COMM),avg(COMM)
FROM emp;

SELECT deptno, SAL 
FROM emp
ORDER BY DEPTNO, SAL ;
-- 부서별로, sal를 가진 데이터 건수가 얼마일까?
-- 부서별로, sal를 가진 데이터 최대값 얼마일까?
-- 부서별로, sal를 가진 데이터 최소값 얼마일까?
-- 부서별로, sal를 가진 데이터 평균 얼마일까?
SELECT deptno, COUNT(SAL) "건수", max(sal) "최대",
min(SAL)"최소"
FROM emp
GROUP BY DEPTNO 
ORDER BY DEPTNO ;
-- SELECT 그룹할 컬럼, 함수(통계처리할데이터)
-- FROM 테이블
-- group by 그룹할컬럼
-- 주의 : 그룹할 컬럼은 하나만 지정하면, GROUP by 하나만 지정.
-- 통계할 함수는 여러개를 선언해서 확인하는 것은 상관 없음.
-- ex) 사원 정보에서 부서별로 평균 급여를 확인해보자.
-- avg(sal) 평균급여, round(데이터,1) 소숫점한자리 반올림처리
SELECT DEPTNO, round(avg(SAL),1) 평균급여
FROM emp 
GROUP BY DEPTNO 
ORDER BY DEPTNO ; -- 정렬 처리
SELECT * FROM emp;
--ex) 직책별 가장 먼저 입사한 입사일을 직책A,B,C 순으로 정렬해서 출력
SELECT job 직책, MIN(HIREDATE) 가장먼저입사,
		max(HIREDATE) 가장최근입사
FROM EMP 
GROUP BY job
ORDER BY job;
SELECT * FROM EMPLOYEES e ;
-- ex) manager_id(관리자) 별로 최고급여(salary)를
-- 관리자 id별로 정렬해서 출력
SELECT MANAGER_ID 관리자, max(SALARY) 최고급여
FROM EMPLOYEES e 
GROUP BY MANAGER_ID 
ORDER BY MANAGER_ID ;
-- 그룹화된 데이터중에, 관리자를 기준으로 검색할 때와
-- 그룹된 최고급여를 기준으로 검색할 때 처리..
/*
주의 사항, where조건문, 테이블의 데이터를 기준으로 조건을 처리
FROM EMPLOYEES e 
where EMPLOYEES e(테이블안에 컬럼을 기준으로 비교/조건)
max(SALARY)의 경우는 EMPLOYEES에는 salary정보만 있기에
group by 밑에 having라는 키워드에 조건문으로 검색 처리하여야 한다.
 * */
SELECT MANAGER_ID 관리자, max(SALARY) 최고급여
FROM EMPLOYEES e 
WHERE MANAGER_ID >= 130
GROUP BY MANAGER_ID 
HAVING max(SALARY)>=11000
ORDER BY MANAGER_ID ;
SELECT * FROM emp;
-- ex) 부서번호별로 최고급여를 출력하되, 부서번호는 10, 20만,
-- 최고급여는 4000이상 데이터를 검색하세요.
SELECT DEPTNO 부서번호, max(sal) 최고급여
FROM emp 
--WHERE DEPTNO = 10 OR DEPTNO = 20
WHERE DEPTNO in(10,20)
GROUP BY DEPTNO 
HAVING max(sal)>=4000
ORDER BY DEPTNO ;