/*
# SQL 함수
1. 컬럼의 값이나 데이터 타입의 변경하는 경우
2. 숫자 또는 날짜 데이터의 출력 형식을 변경하는 경우
3. 하나 이상의 행에 대한 집계를 하는 경우
# SQL 함수의 유형
1. 단일행 함수 : 테이블에 저장되어 있는 개별 행을 대상으로
함수를 적용하여 하나의 결과를 반환하는 함수
	- 데이터 값을 조작하는데 주로 사용
	- 행별로 함수를 적용하여 하나의 결과를 반환하는 함수
	1) 종류
	- 문자함수
	- 숫자함수
	- 날짜함수
	- 변환함수 : 목시적 데이터변환/명시적 데이터변환
	- 일반함수
	2) 사용방법
		함수명(컬럼명|표현식, 매개변수1, 매개변수2,...)
		
2. 복수행 함수 : 조건에 따라 여러 행을 그룹화하여 그룹별로
결과를 하나씩 반환하는 함수
	1) 사용방벙
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
SELECT ename, INITCAP(ename), 
job, INITCAP(job)
FROM emp;
-- ex) || 연결연산자, initcap()를 활용하여
-- 사원명 is a 직책명
-- Smith is a Clerk! 표현하세요
SELECT INITCAP(ename)||' is a '||INITCAP(job)||'!' intro
FROM emp;
/* 2. 대소문자 변환 함수
 *    주로 실무상 대소문자 구분없이 검색이 필요하거나,
 *    또는 입력시/수정시 입력된 내용이 대문자/소문자로
 *    변환해서 등록/수정되게 할 때, 주로 활용된다.
 *    1) lower() : 문자열 전체를 소문자로 변환처리 한다.
 *    	 ex) lower('Student') ==> student
 * 	  2) upper() : 문자열 전체를 대문자로 변환처리 한다.
 * 		 ex) upper('student') ==> STUDENT
 * 
 */
SELECT ename, lower(ename) "사원명(소문자)",
	job||upper('- Hi! Man!!') "조합(대문자)"
FROM emp;
SELECT FIRST_NAME ||' '||LAST_NAME "전체이름1",
	UPper(FIRST_NAME)||' '||LAST_NAME "전체이름2"
FROM EMPLOYEES e ;
SELECT *
FROM EMPLOYEES e ;
-- ex) job_id는 소문자, email은 소문자, first_name은 대문자로 변환하여
--     직책 @@@인 @@@의 이메일은 @@@ 입니다. 라고 출력
SELECT '직책'||lower(job_id)||'인 '||
upper(first_name)||'의 이메일은'||lower(email)||'입니다.' "예제"
FROM EMPLOYEES e ;
-- 검색시, 대소문자 입력 상관없이 검색을 처리해야 할 경우
-- ex) first_name이 대소문자 상관없이 키워드 검색 처리
-- 1) 컬럼의 데이터 대문자/소문자로 전환한다.
-- 2) 대문자변환 ==> 키워드로 대문자로 변경
-- 3) 소문자변환 ==> 키워드로 소문자로 변경
SELECT FIRST_NAME, LAST_NAME ,EMAIL ,JOB_ID ,
upper(FIRST_NAME) 이름1, lower(FIRST_NAME) 이름2
FROM EMPLOYEES e ;
-- first_name을 대소문자 관계없이 키워드 검색
SELECT LOWER(FIRST_NAME) 이름, e.* 
FROM EMPLOYEES e 
WHERE LOWER(FIRST_NAME) LIKE '%'||LOWER('steVen')||'%';
SELECT *
FROM EMPLOYEES e ;
-- email과 job_id이 대소문자 관계없이 검색되게 처리하세요.
SELECT lower(email), LOWER(job_id), e.* -- 추가컬럼, e.*
FROM EMPLOYEES e -- 테이블명 alias
WHERE LOWER(EMAIL) LIKE '%'||LOWER('a')||'%' AND 
LOWER(job_id) LIKE '%'||LOWER('a')||'%';





















