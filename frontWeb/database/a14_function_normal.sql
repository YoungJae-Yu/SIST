/*
# 기타 함수들.
1. nvl(데이터, null값일 때 처리할 데이터)
	해당 데이터가 null값일 때, 처리할 데이터를 설정함으로
	null에 대한 여러가지 에러나 연산 처리등에 대하여
	효과적으로 처리할 수 있다.
*/
SELECT ename, SAL , COMM, SAL + COMM 합산,
		nvl(COMM,0) 보너스초기,
		SAL + nvl(COMM,0) 합산2
FROM emp;
/*
2. nvl2(데이터, null이 아닐때, null일때 처리)
	특정한 데이터(컬럼)가 null이 아닐때와 null일 때는 구분하여 처리가
	필요한 경우
	ex) comm이 null일 때는 100, null이 아닐 때는 comm에서
	10% 더 추가해서 결과값을 처리..
 */
SELECT ename, SAL , COMM, nvl2(COMM,COMM *1.1,100) "보너스"
FROM emp;
-- ex) comm이 null일 때는 sal의 15%로 설정하고, null이
-- 아닐 때는 comm에서 sal의 5%를 더하여 보너스 금액을 처리
-- 결과값을 10단위 절삭 처리
SELECT ename, SAL , COMM,
TRUNC(nvl2(COMM,comm+SAL *0.05,SAL *0.15),-1) "보너스"
FROM emp;
/*
# nullif(데이터1, 데이터2)
두 개의 매개변수로 받는 데이터를 비교하여 동일하면 null을 반환하고,
동일하지 않으면 첫번째 데이터1를 반환하는 함수를 말한다.

*/
SELECT NULLIF ('a','a') "동일할때",
		NULLIF ('a','b') "다를때1",
		NULLIF (15,20) "다를때2",
		nvl(NULLIF ('a','a'),'동일') "중첩1",
		nvl(NULLIF ('a','b'),'동일') "중첩2"
FROM dual;
-- nvl(nullif(데이터1, 데이터2),'null일때')
-- 중첩함수를 이용해서 동일 할때는 문자열처리, 다를 때, 데이터1처리
-- ex1) comm이 0인 경우에는 null을 반환하고, 그렇지 않으면
--		comm 그대로 출력해서, 사원명, 급여, comm을 출력하세요.
SELECT ENAME , SAL , NULLIF (comm, 0) "comm"
FROM emp;
-- ex2) hiredate와 현재 날짜를 비교하여 hiredate가 현재 날짜와
-- 		같은경우 null, 그렇지 않는 경우 hiredate 반환 sql
SELECT NULLIF (HIREDATE , SYSDATE) "날짜"
FROM emp;
/*
# 조건을 처리하는 1단계 decode 함수
1. 프로그래밍 언어의 if문이나 case문으로 표현되는 내용을 하나의
함수로 처리할 수 있게 해준다.
2. 기본형식
	decode(데이터, 케이스1, 처리1,
				케이스2, 처리2,
				...
				그외 처리할데이터)
 */
-- 부서정보가 10(인사), 20(총무), 그외는 부서없음
SELECT ENAME ,decode(DEPTNO,10,'인사',
					20,'총무',
					'부서없음') "부서"
FROM emp;
-- ex) 직책(job)을 기준으로 팀을 정하기로 했다.
-- CLERK인 경우 1팀, SALESMAN인 경우 2팀, 그외 3팀
SELECT ENAME "사원명" ,decode(job,'CLERK','1팀',
					'SALESMAN','2팀',
					'3팀') "팀"
FROM emp;
-- ex1) 사원번호를 기준으로 짝수인 경우 홍팀 홀수인 경우 청팀으로 처리해보자.
--      사원번호, 사원명, 팀..
SELECT EMPNO ,ENAME ,
decode(MOD(EMPNO,2) ,0),'홍팀','청팀') "팀"
--decode(MOD(EMPNO,2) ,
--NULLIF(MOD(EMPNO,2),1),'홍팀',
--NULLIF(MOD(EMPNO,2),0),'청팀') "팀"
FROM emp;
-- ex2) 사원의 직책(job)이 SALESMAN이면서 보너스(COMM)이 NULL이
-- 		아닌 경우에는 영업직, 그 외는 비영업직이라는 영업직여부를
-- 		사원번호, 사원명, 직책, 보너스, 영업직여부를 출력하세요
SELECT EMPNO, ename, JOB , comm,
DECODE(job,'SALESMAN',
DECODE(COMM,NULL,'비영업직','영업직'),'비영업직') "영업직여부"
FROM EMP e ;

/*
# 조건을 처리하는 2단계 case
1. decode의 확장된 형태로 컬럼값의 '='비교를 통해
	조건의 일치하는 경우에만 다른 값을대치하지만,
	case함수는 산술연산, 관계연산, 논리 연산을 통해
	boolean으로 범위를 지정하여 다양한 비교가 가능하게 해준다.
2. 기본형식
	1) 조건문 형태로 사용
		조건문(논리,산술,관계,비교)
		case when 조건문1 then 처리할 데이터
			 whem 조건문2 then 처리할 데이터
			 ...
			 else 위 조건에 해당하지 않을 경우 처리할 데이터
		end alias명
	2) switch case문 형태로 사용
		case 컬럼|데이터
			when 케이스1 then 처리할데이터
			when 케이스2 then 처리할데이터
			when 케이스3 then 처리할데이터
 			..
 			else 그외
 		end alias명
 **/	
-- 부서번호에 따라서 보너스 적용
SELECT ENAME , DEPTNO , SAL ,
CASE WHEN DEPTNO =10 THEN SAL *0.2
WHEN DEPTNO =20 THEN SAL *0.5
WHEN DEPTNO =30 THEN SAL *0.7
ELSE SAL *1.2
END 보너스
FROM EMP e ;
-- JOB에 따른 보너스 적용
-- 급여의 %가 보너스
--CLERK 5%
--SALESMAN 10%
--PRESIDENT 15%
--MANAGER 17%
--ANALYST 20%
-- 그외는 0%
-- 를 적용해서 보너스와 급여, 합산을 출력
SELECT ENAME , DEPTNO , SAL ,JOB,
CASE WHEN JOB ='CLERK' THEN SAL *1.05
WHEN JOB ='SALESMAN' THEN SAL *1.1
WHEN JOB ='PRESIDENT' THEN SAL *1.15
WHEN JOB ='MANAGERTHEN' THEN SAL *1.17
WHEN JOB ='ANALYST' THEN SAL *1.2
ELSE SAL
END "보너스와 급여"
FROM EMP e ;
-- EX2) SAL 5000이상, 4000~4999, 3000~3999, 2000~2999
-- 2000미만 급여등급 출력
SELECT ENAME , DEPTNO , SAL,
CASE WHEN SAL >= 5000 THEN 'A'
     WHEN SAL <= 4999 AND SAL >= 4000 THEN 'B'
     WHEN SAL <= 3999 AND SAL >= 3000 THEN 'C'
     WHEN SAL <= 2999 AND SAL >= 2000 THEN 'D'
     ELSE 'E'
END "급여 등급"
FROM EMP e ;
-- EX3) 위 EX1 을 SWITCH CASE문 형태로 적용해보세요..
SELECT ENAME , DEPTNO , SAL ,JOB,
	CASE JOB
		WHEN 'CLERK' THEN SAL *1.05
		WHEN 'SALESMAN' THEN SAL *1.1
		WHEN 'PRESIDENT' THEN SAL *1.15
		WHEN 'MANAGERTHEN' THEN SAL *1.17
		WHEN 'ANALYST' THEN SAL *1.2
		ELSE SAL
	END "보너스와 급여"
FROM EMP e ;
-- 부서번호에 따른 보너스 처리
SELECT Ename, deptno, sal,
	CASE deptno
		WHEN 10 THEN sal*0.2
		WHEN 10 THEN sal*0.2
		WHEN 10 THEN sal*0.2
		ELSE sal*1.2
	END 보너스
FROM emp;
/*
# sign()
1. 비교시 주로 활용(범위설정)
	1) n<0 : -1리턴
	2) n = 0 : 0리턴
	3) n > 1 : 1리턴
 */
SELECT 
SIGN(-5),
SIGN(0),
SIGN(7)
FROM dual;
-- 급여가 3000 이상인 경우 그렇지 않은 경우
SELECT sal,
sign(sal - 3000) div
FROM emp;
-- decode 함수와 함께 혼합해서 원하는 데이터를 처리한다.
-- ex) decode와 sign을 활용해서 2000이상인 경우와
-- 		그렇지 않은 경우를 구분해서 2000미만인 경우 보너스 대상자
-- 		보너스대상자 아님을 표시
SELECT ename, sal,
DECODE(SIGN(SAL - 2000),-1,'보너스대상자','보너스대상자아님') "보너스여부"
FROM emp;
/*
# extract
1. 날짜에서 숫자형으로 연도, 월, 일을 추출할 때 활용한다.
2. 형식
	extract(옵션 from 날짜형데이터)
 */
SELECT 
EXTRACT (YEAR FROM sysdate) "오늘연도",
EXTRACT (MONTH FROM sysdate) "오늘월",
EXTRACT (DAY FROM sysdate) "오늘일"
FROM dual;
SELECT *
FROM EMPLOYEES e ;
-- ex) employees의 hire_date를 이용해서 숫자형으로
-- 년도, 월, 일을 뽑아내되, sign() decode()와 
-- 혼합해서 2000년 이후 입사자 여부를 출력하세요.
SELECT FIRST_name,HIre_date,
DECODE(sign(EXTRACT (YEAR FROM hire_date)-2005),
1,'2005년 이후 입사자',
0,'2005년 이후 입사자',
'2005년 이전') "입사 구분"
FROM EMPLOYEES e ;

















