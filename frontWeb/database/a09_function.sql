/*
# SQL 함수
1. 컬럼의 값이나 데이터 타입의 변경하는 경우
2. 숫자 또는 날짜 데이터의 출력 형식이 변경하는 경우
3. 하나 이상의 행에 대한 집계를 하는 경우
   ex) select 함수(컬럼)
       from 테이블
       where 함수(컬럼) = 데이터
       and 컬럼 = 함수(데이터)
# SQL 함수의 유형
1. 단일행 함수 : 테이블에 저장되어 있는 개별 행을 대상으로
함수를 적용하여 하나의 결과를 반환하는 함수
	- 데이터 값을 조작하는데 주로 사용
	- 행별로 함수를 적용하여 하나의 결과를 반환하는 함수
	1) 종류
	- 문자함수
	- 숫자함수
	- 날짜함수
	- 변환함수 : 묵시적 데이터변환/명시적 데이터변환
	- 일반함수
	2) 사용방법
		함수명(컬럼명|표현식, 매개변수1, 매개변수2,....)		
2. 복수행 함수 : 조건에 따라 여러 행을 그룹화하여 그룹별로
결과를 하나씩 반환하는 함수
	1) 사용방법
		select 그룹대상컬럼, 그룹함수(그룹데이터)
		from 테이블
		group by 그룹대상컬럼
		ex) 부서번호별 최고 급여
		select deptno, max(sal)
		from emp
		group by deptno;


*/
-- 문자함수 : 문자 데이터를 입력하여 문자나 숫자를 결과로
-- 반환하는 함수
-- 1. initcap() : 문자의 첫 번째 문자만 대문자로 변환
SELECT ename, INITCAP(ename), job, INITCAP(job)
FROM emp;
-- ex) || 연결연산자, initcap()를 활용하여
--   사원명 is a 직책명   
--ex)Smith is a Clerk! 표현하세요
SELECT INITCAP(ename)||' is a '||initcap(job)|| '!'
	   intro
FROM emp;
/*  2. 대소문자 변환 함수 
 * 	   주로 실무상 대소문자 구분없이 검색이 필요하거나,
 *     또는 입력시/수정시 입력된 내용이 대문자/소문자로
 *     변환해서 등록/수정되게 할 때, 주로 활용된다.
 * 	   1) lower() : 문자열 전체를 소문자로 변환처리 한다.
 *        ex) lower('Student') ==> student
 *     2) upper() : 문자열 전체를 대문자로 변환처리 한다.
 *        ex) upper('student') ==> STUDENT
 * */
 SELECT ename, lower(ename) "사원명(소문자)",
        job||upper('- Hi! Man!!') "조합(대문자)"
 FROM emp;
SELECT first_name||' '||last_name "전체이름1",
       upper(first_name||' '||last_name) "전체이름2"
FROM EMPLOYEES e;
SELECT *
FROM EMPLOYEES;
--  ex)job_id는 소문자, email은 소문자, first_name은 
--   대문자로 변환하여 직책 @@@인  @@@의 이메일은 @@@ 입니다.
--   라고 출력되게 하세요
SELECT '직책 '||LOWER(job_id) ||'인  '||
upper(first_name) 
||'의 이메일은 '|| lower(email) ||' 입니다.' msg
FROM EMPLOYEES e;
--  검색시, 대소문자 입력 상관없이 검색을 처리해야 할 경우
--  ex) first_name이 대소문자 상관없이 키워드 검색 처리
--  1) 대상 컬럼의 데이터 대문자/소문자로 전환한다.
--  2) 대문자변환 ==> 키워드로 대문자로 변경
--  3) 소문자변환 ==> 키워드로 소문자로 변경
--
SELECT FIRST_NAME,LAST_NAME,email,JOB_ID,
  upper(FIRST_NAME) 이름1, LOWER(FIRST_NAME) 이름2 
FROM EMPLOYEES e;
-- first_name을 대소문자 관계없이 키워드 검색
SELECT lower(FIRST_NAME) 이름, e.*
FROM EMPLOYEES e
WHERE lower(FIRST_NAME) LIKE '%'||lower('j') ||'%';
/*
WHERE lower(First_name) LIKE lower(?)
# 실제 Dao단 처리시, pstmt에는
pstmt.setString(1, "%"+emp.getFirst_name()+"%")
 */
SELECT * 
FROM EMPLOYEES e;
--ex) email과 job_id이 대소문자 관계없이 키워드 검색되게 처리하세요.
SELECT email, job_id, e.*  -- 추가컬럼, e.*
FROM EMPLOYEES e -- 테이블명 alias
WHERE email LIKE upper('%o%')
AND lower(job_id) LIKE lower('%A%');
/*
# 문자열 길이 반환
1. length(데이터/컬럼) : 해당 데이터나 컬럼의 문자열 길이를 반환하는 함수
2. lengthb(데이터/컬럼) : 입력되는 문자열의 바이트를 변환하는 함수
	1) 영문은 1자와 byte는 같다.
	2) 한글을 1자가 3byte 이다.
cf) dual : 오라클에서 지원되는 임시가상 테이블로 데이터를
	간단하게 확인할 때 사용한다.
	

 */
SELECT '홍길동' name, LENGTHb('홍길동')"이름(byte)",
		LENGTH('홍길동') "이름(글자수)"
FROM dual;

SELECT ename, LENGTH(ename) "글자수", 
		lengthb(ename) "byte크기",
		job, LENGTH(job) "글자수",
		lengthb(job) "byte크기"	
FROM emp02;
-- ex) 사원 테이블에서 사원명과 직책의 글자 수를 표현하되,
-- 직책의 글자갯수가 6이상인 데이터만 출력하세요..
SELECT ename, LENGTH(ename) "글자수", 
		job, LENGTH(job) "글자수"
FROM emp02
WHERE LENGTH(JOB)>=6;
/*
# 기타 문자열 조작함수
1. concat(문자열1, 문자열2) : 두 문자열을 결합처리한다.
	문자열1 || 문자열2 동일
	문자열1 || 문자열2 || 문자열3 ==> concat(concat(문자열1,문자열2),문자열3)
2. substr(문자열데이터, 시작위치(0부터), 시작위치에서부터 갯수)
	문자열 데이터를 시작위치와 마지막위치를 기준으로 절삭처리하여
	사용하는 것을 말한다.
	ex) substr('sql*plus',5,4) ==> plus
		다섯번째로 부터 4개를 추출하여 가져온다.
 */
SELECT empno, ename, job, concat(ename, job) "이름과 직책"
FROM emp02;
SELECT substr('sql*plus',5,4) "데이터" FROM DUAL;
--ex)사원명과 사원번호를 이어서 표현하고, 직책은 2번째부터 3글자를 추출해서 출력하세요.
SELECT concat(ename, EMPNO) "이름과 사원번호",
substr(job,2,3) "직책의 중간3글자"
FROM emp02;
--1. emp 테이블에서 사원명과 직무를 이어서 표현하고, 직무는 대문자로 변환하여 출력하세요.
SELECT CONCAT(LOWER(ename),UPPER(job)) "이름/직무"
FROM emp;
--2. emp 테이블에서 사원명의 글자 수와 직무의 글자 수를 출력하세요.
SELECT ename,LENGTH(ename) "이름 글자수", job,LENGTH(JOB) "직무 글자수"
FROM emp;
--3. emp 테이블에서 직무가 'SALESMAN'인 사원들의 사원명과 직무를 이어서 표현하세요.
SELECT CONCAT(ename,job) "이름/직무"
FROM emp
WHERE job='SALESMAN';
--4. emp 테이블에서 급여가 3000 이상인 사원들의 사원명과 급여를 이어서 표현하세요.
SELECT CONCAT(ename,SAL) "이름/급여"
FROM emp
WHERE sal>=3000;
--5. emp 테이블에서 사원명에서 첫 글자만 대문자로 변환하여 출력하세요.
SELECT initcap(ename)"이름(첫글자대문자)"
FROM emp;
--6. emp 테이블에서 사원명과 직무를 이어서 표현하고, 사원명을 소문자로 변환하여 출력하세요.
SELECT CONCAT(LOWER(ename),job) "이름(소문자)/직무"
FROM emp;
--7. emp 테이블에서 직무가 'ANALYST'인 사원들의 사원명과 직무를 이어서 표현하고, 직무를 소문자로 변환하여 출력하세요.
SELECT CONCAT(ename,LOWER(job)) "이름/직무(소문자)"
FROM emp
WHERE JOB ='ANALYST';
--8. emp 테이블에서 직무가 'MANAGER'이거나 'SALESMAN'인 사원들의 사원명과 직무를 이어서 표현하고, 직무를 대문자로 변환하여 출력하세요.
SELECT CONCAT(ename,UPPER(job)) "이름/직무(대문자)"
FROM emp
WHERE JOB ='MANAGER' OR JOB ='SALESMAN';
--9. emp 테이블에서 급여가 2000 이상이고 3000 이하인 사원들의 사원명과 급여를 이어서 표현하세요.
SELECT CONCAT(ename,SAL) "이름/급여"
FROM emp
WHERE sal BETWEEN 2000 AND 3000;
--10. emp 테이블에서 사원명에서 첫 3글자를 추출하여 출력하세요.
SELECT substr(ename,1,3) "이름(첫3글자)"
FROM emp;
--11. emp 테이블에서 사원명에서 뒤에서 3글자를 추출하여 출력하세요.
SELECT substr(ename,-3) "이름(뒤3글자)"
FROM emp;
--12. emp 테이블에서 사원명에서 2번째부터 4번째까지의 글자를 추출하여 출력하세요.
SELECT substr(ename,2,3) "이름(2~4)"
FROM emp;
--13. emp 테이블에서 사원명에서 뒤에서 5번째부터 뒤에서 2번째까지의 글자를 추출하여 출력하세요.
SELECT substr(ename,-5,4) "이름(2~4)"
FROM emp;
--14. emp 테이블에서 사원명에서 첫 번째와 두 번째 글자를 추출하여 이어서 출력하세요.
SELECT CONCAT(substr(ename,1,1),substr(ename,2,1)) "이름"
FROM emp;
--15. emp 테이블에서 직무가 'CLERK'인 사원들의 사원명과 직무를 이어서 표현하고, 사원명을 소문자로 변환하여 출력하세요.
SELECT CONCAT(LOWER(ename),job) "이름(소문자)/직무"
FROM emp
WHERE JOB ='CLERK';
--16. emp 테이블에서 직무가 'CLERK'가 아닌 사원들의 사원명과 직무를 이어서 표현하고, 직무를 대문자로 변환하여 출력하세요.
SELECT CONCAT(ename,UPPER(job)) "이름(소문자)/직무"
FROM emp
WHERE JOB != 'CLERK';
--WHERE JOB <> 'CLERK';
--17. emp 테이블에서 사원명과 직무를 이어서 표현하고,직무를 대문자로 변환하여 출력하세요. 단, 사원명과 직무 사이에 '/'를 추가하세요.
SELECT ename||'/'||UPPER(job) "이름(소문자)/직무"
FROM emp;
--18. emp 테이블에서 급여가 1000 이하인 사원들의 사원명과 급여를 이어서 표현하세요.
SELECT CONCAT(ename,SAL) "이름/급여"
FROM emp
WHERE sal <= 1000;

--실습 문제:
--1. EMP 테이블에서 사원명(ename)을 대문자로 출력하세요.
SELECT upper(ename) FROM emp; 
--2. EMPLOYEES 테이블에서 사원번호(empno)가 100인 데이터의 이메일(email)을 소문자로 출력하세요.
SELECT lower(email) "이메일(소문자)", EMPLOYEE_ID "사원번호" FROM EMPLOYEES
WHERE EMPLOYEE_ID = 100;
--3. EMP 테이블에서 사원명(ename)과 부서명(deptno)을 연결한 결과를 출력하세요. 결과 컬럼 이름은 "이름/부서번호"로 지정하세요.
SELECT CONCAT(ename, deptno) "이름/부서번호"
FROM emp;
--4. EMP 테이블에서 직원명(ename)과 입사일(hiredate)을 연결한 결과를 출력하세요. 결과 컬럼 이름은 "이름/입사일"로 지정하세요.
SELECT CONCAT(ename, hiredate) "이름/입사일"
FROM emp;
SELECT * FROM emp;
--5. EMP 테이블에서 입사일(hire_date)이 1981년인 데이터의 사원명(ename)과 입사일(hire_date)을 출력하세요.
SELECT ename "사원명",hiredate "입사일"
FROM EMP
WHERE SUBSTR(HIREDATE,1,2) = 81;
--6. EMPLOYEES 테이블에서 사원번호(empno)가 200이상 300이하인 데이터의 이메일(email)과 직무(job_id)를 출력하세요.
SELECT EMPLOYEE_ID "사원번호", email "이메일", job_id "직무"
FROM EMPLOYEES e 
WHERE EMPLOYEE_ID BETWEEN 200 AND 300;
--7. EMP 테이블에서 직원명(ename)을 출력하되, 이름의 앞뒤에 있는 공백을 제거한 결과를 출력하세요.
SELECT LTRIM(ename,' ') "직원명(공백제거)"
FROM emp;
--8. EMPLOYEES 테이블에서 이메일(email)에 "J"가 포함된 데이터의 사원명(ename)과 이메일(email)을 출력하세요.
SELECT CONCAT(FIRST_NAME,LAST_NAME) "사원명", EMAIL "이메일" 
FROM EMPLOYEES e
WHERE EMAIL LIKE '%J%';

SELECT instr('AABBBBAA','A',2,3)
FROM dual;


























