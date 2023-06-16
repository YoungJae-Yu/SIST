/*
# 날짜 함수
1. oracle의 날짜 데이터 타입(Date)는 날짜 + 시간을 포함하고 있다.
2. oracle DB의 Date 타입의 시간과 날짜 처리 구조
	1/1000초 ==> 1초 ==> 1분 ==> 1시간 ==> 1일 ==> 월 ==> 년
	1일 ==> 월 단위부터 규칙적이지 않음 28,30,31
	주의) 연산처리시 소숫점 이하에 대한 처리
	==> 함수(반올림, 올림, 내림) 중첩해서 처리해야 되는 경우가 많다.
	
	
	
3.연산과 날짜 데이터
	1) 기본 연산
		날짜형 데이터 + 1 : 해당 날짜의 1일 이후(시간을 포함해서 24시간 이후)
		날짜형 데이터 - 1 : 해당 날짜의 -1일 이전
		날짜 + 1/24 : 해당 날짜의 1시간 이후
		날짜 + 200/60/24 : 해당 날짜의 200분 이후
		ex) 1일 기준으로 0.5 ==> 12시간 
	2) sysdate : 현재 날짜 + 시간
**/
SELECT 
SYSDATE,
SYSDATE+1 하루후,
SYSDATE-1 하루전,
SYSDATE+5/24 "5시간이후",
SYSDATE+200/60/24 "200분 이후"
FROM dual;
-- 1일이 24시간이기에 시간단위까지 계산하면 소숫점이하가 나타날 수 있다.
SELECT (SYSDATE + 5/24) - SYSDATE
FROM dual;
-- EMPLOYEES에서 현재일을 기준으로 근무일 수 계산한다면
SELECT FIRST_NAME ,HIRE_DATE,
	SYSDATE , SYSDATE - HIRE_DATE 근무일수,
	floor(SYSDATE - HIRE_DATE) "근무일수(절삭)",
	CEIL(SYSDATE - HIRE_DATE) "근무일차(올림)",
	floor((SYSDATE - HIRE_DATE)/365) "근무년수(절삭)"
FROM EMPLOYEES e ;
/*
ex) 사원명과 함께 인턴기간(입사후,120일), 입사 8일전,
	현재일 기준으로 근무일 수를 출력해보세요
	employees 테이블 기준
*/
SELECT FIRST_NAME 이름, HIRE_DATE+120 "인턴기간(입사후,120일)",
	   HIRE_DATE-8 "입사 8일전",
	   floor(sysdate - HIRE_DATE) 근무일수
FROM EMPLOYEES e ;
/*
# 월데이터 처리 함수
1. 날짜형 데이터는 월단위가 30/31/29등 유동적이어서,
	해당 월에 따라 함수로 이러한 월계산 처리를 하고 있다.
2. 기본 형식
	1) 기본적으로 월 처리함수의 1은 1달을 의미한다.
		그래서 1달의 반을 0.5가 된다.
	2) months_between(날짜1, 날짜2) : 날짜 사이의 개월
		수를 표시한다...
		월에 대한 증가 카운트 일단위가 가변적이기에 함수를
		이용하는 것이 효율적이다..
*/
SELECT ename, HIREDATE ,
MONTHs_between(SYSDATE, HIREDATE) "근무 개월수",
FLOOR(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "근무 개월수", 
CEIL(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "근무 개월차" 
FROM emp;
-- 12로 나누면 근무 연한과 근무 연차를 계산..
-- ceil, floor 중첩적으로 활용해서 처리할 수 있다.
-- ex1) dual을 이용해서 오늘로부터 1000일 이후, 개월 수를 출력하세요. 
SELECT MONTHS_BETWEEN(SYSDATE+1000,SYSDATE) 
FROM dual;
-- ex2) emp 테이블을 ename,hiredate과 위 월단위 함수를 이용해서
-- 		@@년 @@개월 근무라고 출력해보세요..
SELECT ename, HIREDATE,
floor(MONTHs_between(SYSDATE, HIREDATE)/12)||'년 '||
MOD(FLOOR(MONTHs_between(SYSDATE, HIREDATE)),12)||'개월 근무' "근무연한"
FROM emp;
-- ex) 오늘부터 근무하는 것을 기준으로 2000일이후의
--		근무연한과 개월수를 출력 @@년 @@개월 근무.
SELECT FLOOR(MONTHS_BETWEEN(SYSDATE+2000,SYSDATE)/12)||'년 '||
mod(FLOOR(MONTHS_BETWEEN(SYSDATE+2000,SYSDATE)),12)||'개월 근무' "근무연한"
FROM dual;
/*
# add_months를 통한 개월 수 추가
1. 특정한 날짜를 기준으로 개월 수를 추가하여, 해당 이후 날짜를 처리하는데 사용된다.
2. 형식
	add_months(날짜, 추가 개월수/이전개월수)
 */
SELECT SYSDATE 오늘, ADD_MONTHS(SYSDATE,4) "4개월후",
ADD_MONTHS(SYSDATE,-1) "1개월 전"
FROM dual;
-- ex) 사원 정보를 기준으로 사원명, 입사일, 인턴기간(3개월),
--	입사 10주년 기념일, 입사20주년 기념일을 출력하세요.
SELECT ename 사원명, HIREDATE 입사일,
ADD_MONTHS(HIREDATE,3)"인턴기간(3개월)",
ADD_MONTHS(HIREDATE,120)"입사 10주년 기념일",
ADD_MONTHS(HIREDATE,240)"입사 20주년 기념일"
FROM emp;
/*
# 다가올 가장 빠른 요일의 날짜 : next_day
1. 해당 기준일로 명시된 요일에 가장 빠른 날짜
2. 기본 형식
	next_day(날짜데이터, '요일')
 * */
-- 오늘 이후 가장 빠른 수요일
SELECT NEXT_DAY(SYSDATE,'수') "가장빠른 수요일"
FROM dual;
-- ex) 입사 후, 첫 주말(토요일) 날짜를 출력하세요.
SELECT ENAME ,NEXT_DAY(HIREDATE,'토')
FROM emp;
-- ex) 입사 후, 세번째 되는 일요일의 날짜를 출력하세요.
SELECT ENAME ,NEXT_DAY(HIREDATE+21,'일')
FROM emp;
/*
# 매월의 마지막날을 가져오거나 첫날을 가져올 때,
사용하는 함수 : last_day(날짜)
1. 형식
	last_day(기준일) : 해당 기준일에서의 월의 마지막 날짜
	add_months(last_day(기준일)+1,-1) : 해당 월의 첫째 날짜
 */
SELECT LAST_DAY(SYSDATE) "이번달 마지막 날짜",
LAST_DAY(SYSDATE)+1 "다음달의 첫날",
ADD_MONTHS(LAST_DAY(SYSDATE)+1,-1) "이번달의 첫날"
FROM dual;
-- ex) 사원명과 급여일(그달 종료일 -10일전), 
--    보너스일(다음달10)로 출력해보세요..
SELECT ename 사원명,
LAST_DAY(SYSDATE)-10 "급여일",
LAST_DAY(SYSDATE)+10 "보너스일"
FROM emp;














