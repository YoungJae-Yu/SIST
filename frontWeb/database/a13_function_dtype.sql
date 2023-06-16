/*
# 오라클의 데이터 타입 변환
1. 오라클에서 사용하는 데이터 유형을 함수에 의해 타입을 
	변환하기도 하고 자동형변환 처리가 되기도 한다.
			날짜(to_dae)
	
	숫자(to_number)	문자열(to_char)
2. 형변환 유형
	1) 묵시적 데이터 타입의 변환
		조건문에 정확하게 해당 type으로 변환을 함수로 처리하지 않더라도
		묵시적으로 활용할 수 있다.
		ex) select *
			from emp
			where sal>='2000';
		문자열로 '2000'을 입력하더라도 시스템에서 연산을 인식하여
		숫자로 자동형변환 시켜 처리된다.
			select *
			from emp
			where hierdate like '81%'
		hiredate가 날짜형이지만 묵시적으로 문자열로 변환되어
		키워드 검색되어진다. 
			''||hiredate묵시적
		# 묵시적 형변환을 오라클 서버내부에 맡기는 것보다는
		적절한 형변환 하는 함수를 적용하는 것이 더 효율적이다.
		ex) where sal>=to_number('2000');
		
		
	2) 명시적 데이터 타입의 변환
		일반적으로 데이터베이스는 변환함수를 이용하여 데이터 타입을
		변환하여 효과적으로 처리한다.
		ex) 현재 컬럼 데이터 유형을 변환해서 조건에 맞게 처리하는 경우
		where to_char(hiredate,'YYYY') = '2002'
		==> 날짜형인데 문자형 날짜 중 연도를 추출하여 비교하여 검색
		where hiredate = to_date('2022-02-12','YYYY-MM-DD')
		==> 해당 컬럼의 유형에 맞게 명시적으로 변경하여 검색하는 경우
		
		to_char(컬럼/데이터,'변환형식') 숫자/날짜 타입을 문자열로
			변환해주는 함수이다.
		to_number(컬럼/데이터) 날짜/문자 타입을 숫자로 변환해주는 함수
		to_date(컬럼/데이터) 문자/숫자 타입을 날짜로 변환해주는 함수
*/
SELECT *
FROM EMP e 
WHERE SAL >= '2000';
SELECT ''||HIREDATE , e.*
FROM EMP e 
WHERE HIREDATE LIKE '81%';
/*
# to_char
1. 날짜/숫자를 원하는 형태 문자열 형태로 변환하여 데이터를 처리하는 함수
2. 기본 형식
	to_char(데이터, 출력할 형식)
3. 출력할 형식1(날짜==>문자열)
	1) CC:세기 ex) to_char(sysdate, 'CC')
	2) YYYY/YYY/YY/Y 년도 표기
	3) AD/A.D BC/B.C 표기
		둘 중에 하나만 표기하면 해당 연도의 A.D/B.C 인지를
		구분하여 데이터 처리가 된다.
	4) Q 분기 1/4분기, 2/4분기..
	5) MM/MONTH/MON 월표기
	6) WW/W 연을 주기단위로 주차표기/월 주단위로 표기
		WW : 1년을 기준으로 52주차를 표시
		W : 월을 기준으로 1~5주차를 표시..
	7) DDD/DD/D 날짜표기
	8) DY/DAY 요일 표기
	위 날짜 표기 형식을 조합하여 원하는 날짜표기 형식으로 처리한다.
		YYYY/MM/DD
		특수문자를 추가해서 표기할 경우 ""사이에 사용한다.
		YYYY"년 "MM"월 "DD"일"
 * */
SELECT TO_CHAR(SYSDATE,'CC') "세기" FROM dual;
SELECT TO_CHAR(SYSDATE,'YYYY') "연도1" FROM dual;
SELECT TO_CHAR(SYSDATE,'YYY') "연도2" FROM dual;
SELECT TO_CHAR(SYSDATE,'YY') "연도3" FROM dual;
SELECT TO_CHAR(SYSDATE,'Q') "분기" FROM dual;
SELECT TO_CHAR(SYSDATE,'MM') "월" FROM dual;
SELECT TO_CHAR(SYSDATE,'DD') "일" FROM dual;
SELECT TO_CHAR(SYSDATE,'YYYY/MM/DD') "날짜" FROM dual;
SELECT TO_CHAR(SYSDATE,'YYYY"년 "MM"월 "DD"일"') "날짜" FROM dual;
-- ex1) 사원명과 입사일, 입사분기를 표시해서 출력하되 
--      1/4, 2/4분기 입사한 사원만 조회하세요
SELECT ename 사원명, HIREDATE 입사일,
TO_CHAR(HIREDATE ,'Q')||'/4분기' "입사분기"
FROM emp
WHERE TO_CHAR(HIREDATE ,'Q') in('1','2');
--WHERE TO_CHAR(HIREDATE ,'Q') = 1
--OR TO_CHAR(HIREDATE ,'Q') = 2;
-- ex2) 사원명은 @@년 @@월 @@일에 @@/4분기에 입사했습니다. 출력
SELECT ENAME||'은 '||
TO_CHAR(HIREDATE,'YYYY"년 "MM"월 "DD"일"')||' '||
TO_CHAR(HIREDATE,'Q')||'분기에 입사했습니다.' "입사일"
FROM emp;
/*
3. 출력할 형식2(시간==>문자열)
	1) AM/PM 오전/오후 표시
	2) A.M/P.M
	3) HH/HH12 : 시간표시
	4) HH24 : 24시 표시
	5) MI : 분
	6) SS : 초

 **/
SELECT SYSDATE, TO_CHAR(SYSDATE, 'AM HH:MI:SS') FROM dual;
SELECT SYSDATE, TO_CHAR(SYSDATE, 'A.M. HH24"시 "MI"분 "SS"초"') FROM dual;
-- ex) dual 이용해서 현재 연도/날짜 24시:분:초를 다 출력해보세요.
SELECT SYSDATE, TO_CHAR(SYSDATE,
'YYYY/MM/DD" "A.M. HH24":"MI":"SS') 
FROM dual;

--1. `EMP` 테이블에서 `SAL`이 2000 이상인 직원의 `ENAME`와 `SAL`을 출력하세요.
SELECT ename, SAL 
FROM emp
WHERE sal >= 2000;
--2. `EMP` 테이블에서 `HIREDATE`가 1981년에 해당하는 직원의 `ENAME`와 `HIREDATE`를 출력하세요.
SELECT ename, HIREDATE 
FROM EMP e 
WHERE HIREDATE LIKE '81%';
--3. 현재일짜 날짜로부터 100일 후의 날짜를 'YYYY-MM-DD' 형식으로 출력하세요.
SELECT TO_CHAR(SYSDATE+100,'YYYY-MM-DD') "100일후"
FROM dual;
--4. `EMP` 테이블에서 `ENAME`이 'SMITH'인 직원의 입사일(`HIREDATE`)을 'YYYY년 MM월 DD일' 형식으로 출력하세요.
SELECT ename ,TO_CHAR(HIREDATE,'YYYY"년 "MM"월 "DD"일"') "입사일"
FROM EMP e 
WHERE ename = 'SMITH';
--5. `EMP` 테이블에서 `SAL`이 3000 이상인 직원의 `ENAME`, `SAL`, `HIREDATE`를 출력하되, `HIREDATE`는 'YYYY년 Q분기' 형식으로 출력하세요.
SELECT ename, SAL ,
to_char(HIREDATE,'YYYY"년 "Q"분기"')
FROM emp
WHERE sal >= 3000;
--6. `EMP` 테이블에서 모든 직원의 `ENAME`, `SAL`, `HIREDATE`를 출력하되, `HIREDATE`는 'YY년 MM월 DD일에 Q/4분기' 형식으로 출력하세요.
--7. `EMP` 테이블에서 `ENAME`이 'ALLEN'인 직원의 `ENAME`, `SAL`, `HIREDATE`를 출력하되, `HIREDATE`는 'HH24시 MI분 SS초' 형식으로 출력하세요.
--8. `EMP` 테이블에서 `ENAME`이 'KING'인 직원의 `ENAME`, `SAL`, `HIREDATE`를 출력하되, `HIREDATE`는 'DD일 DAY YYYY년 Q/4분기' 형식으로 출력하세요.
--9. 현재 시간을 'HH24시 MI분 SS초' 형식으로 출력하세요.
--10. `EMP` 테이블에서 모든 직원의 `ENAME`, `SAL`, `HIREDATE`를 출력하되, `HIREDATE`는 'YYYY년 MM월 DD일 A.M./P.M.' 형식으로 출력하세요.





