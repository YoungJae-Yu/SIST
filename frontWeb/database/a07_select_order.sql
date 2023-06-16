/*
# keyword 검색(계속)
1. 자릿수에 맞추어서 검색하기
	ex) 앞에서 3번째 자리에 A를 포함하는 검색
		컬럼명 like '__A%'
	ex) 뒤에서 2번째 자리에 A를 포함하는 직책을 검색
		컬럼명 like '%A_'
	ex) 글자수가 6자리이고, 앞에서 3번째 자리에 R이 있는 데이터 검색	
		컬럼명 like '__R___'
*/
SELECT * FROM emp
WHERE ename LIKE '__A%';

SELECT * FROM emp
WHERE JOB LIKE '%A_';

SELECT * FROM emp
WHERE ENAME LIKE '__R___';

-- ex) 앞에서 4번째5번째 자리에 ES를 포함한 직책 검색
SELECT * FROM emp
WHERE JOB LIKE '___ES%';
SELECT ename, ''||HIREDATE "문자열로"
FROM emp;
SELECT ENAME , HIREDATE
FROM EMP e 
WHERE HIREDATE LIKE '___02%';
-- ex) 뒤에서 세번째 자리에 M이 포함된 직책 검색
SELECT * FROM emp
WHERE JOB LIKE '%M__';
-- ex) 자리수가 5자리이고 중간에 I자가 표함된 사원명 검색
SELECT * FROM emp
WHERE ENAME LIKE '__I__';

/*
# 정렬 처리
1. sql 명령문에서 검색된 결과는 테이블에 데이터가 입력된 순서로
	일반적으로 출력된다.
2. 데이터의 출력 순서를 특정 컬럼을 기준으로 오름차순/내림차순으로
	정렬하는 경우가 발생한다.
3. 여러 개의 컬럼에 대해 정렬 순서를 지정해서 처리해야 할 경우가 발생하는데,
	입사일을 오름차순으로, 급여 기준으로 내림차순 등이라고 할 수 있다.
4. 기본적인 정렬 방벙
	1) 문자값을 알파벳순으로 출력되고, 한글은 가나다라 순으로 출력된다.
	2) 숫자값을 가장 작은 값으로부터 출력
	3) 날짜는 최신 날짜 순으로 출력할 수 있다.
5. 기본 형식
	select * from 테이블 where 조건 다음에..
	order by 컬럼1명 [asc|desc], 컬럼2명 [asc/desc]
	asc : default로 오름차순 정렬(생략가능)
	desc : 역순/내림차순 정렬
*/
-- 사원 번호를 기준으로 오름차순/내림차순 정렬
SELECT empno, ename
FROM emp;
SELECT empno, ename
FROM emp
ORDER BY empno DESC;
SELECT * FROM emp
ORDER BY empno DESC;
-- ex1) 연봉이 가장 높은 사람부터 낮은 사람으로 급여와 이름을 출력
SELECT sal, ename
FROM emp
ORDER BY sal DESC;
-- ex2) 입사일 기준으로 최근에 입사한 사람으로부터 입사가 먼저된 사람 출력
SELECT hiredate, ename
from emp
ORDER BY HIREDATE DESC;
-- ex3) 부서번호는 오름차순, 연봉은 내림차순으로 이중 정렬 기준으로
-- 		부서번호 급여 사원명으로 출력하세요.
SELECT DEPTNO, SAL, ENAME
from emp
ORDER BY DEPTNO, SAL DESC;