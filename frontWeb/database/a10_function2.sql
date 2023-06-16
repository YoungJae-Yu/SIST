/*
# 중첩함수
1. 함수1(함수2(컬럼))
   해당 컬럼의 데이터를 함수2를 적용하고, 함수1이
   적용되어 중첩적으로 적용되는 것을 말한다.
   - 기본 함수 기능 출분히 연습할 떄, 가능
   - 이전에 했던 함수를 통해 처리할 수 있는 데이터를 상기
   - 다양한 문제를 통해서 필요로 하는 중첩함수 처리.. 
*/
/*
# instr(지정한문자열데이터|컬럼, '검색문자')
1. 특정한 문자열 검색해서 해당 문자열의 위치를 index로
   반환처리하는 함수
   ex) 주로 대용량의 문자열 데이터를 검색해서 해당 문자열의
   첫번째 위치를 index(1)로 표현해준다.
2. 추가 옵션
   instr(데이터|컬럼, '검색문자', 시작위치, 검색된 횟수) 
*/
SELECT instr('sql*plus','*') sch1,
		instr('sql*plus*s','*',3,1) sch2,
		instr('sql*plus*s','*',3,2) sch3,
		instr('sql*plus*s','#',3,2) sch4
FROM dual;
-- ex) 직책을 검색하되 MAN이 있는 데이터를 검색하되 해당 위치와
--	 함께, 사원명, 직책명, 검색된 위치를 출력하세요.
SELECT Ename, job, INStr(job,'MAN') POS
FROM emp
WHERE instr(job,'MAN')>0;
/*
# 문자열에 대한 데이터를 크기와 형식을 만들어서 처리할 때
가변형(varchar2), 고정형(char)
1. 고정형 데이터를 만들어서 처리할 때
	10자를 만들어서 데이터 부족할 때 특정 문자열로 채움.
	홍길동#######
	길동########
	lpad : left padding, rpad : right paddin
	형식
	lpad(데이터, 크기, 왼쪽에 덧붙일 문자열)
	rpad(데이터, 크기, 오른쪽에 덧붙일 문자열)
*/
SELECT lpad('sql',5,'*') show1,
	   RPAD('sql',10,'#') show2
FROM dual;
-- 사원명의 최대크기 확인 후, 고정형으로 모자르는 데이터는 *로 추가하여
-- 데이터를 출력
-- length() 문자의 갯수 ==> max() 최대크기 ==> 문자의 최대 크기
SELECT MAX(LENGTH(ename))
FROM emp;
SELECT LENGTH(ename), ename
FROM emp;
SELECT rpad(ename,6,'*') "이름"
FROM emp;
/*
2. 양옆에 공백을 포함한 특정 문자를 삭제해서 처리할 때.
	##안녕@@@@
	옆에 @는 다 지워서 처리 ##안녕
	옆에 #은 지워서 처리 안녕@@@@
# ltrim, rtrim
1. trim은 절삭이라는 말로, 오른쪽 또는 왼쪽에 이쓴 특정한 문자열을
삭제 처리할 때 , 사용된다.
	1) ltrim(데이터, '제거할 문자') 왼쪽에서 제거할 문자를 없애주는데
		반복적으로 처리된다.
	2) rtrim(데이터, '제거할 문자') 오른쪽에 제거할 문자를 없애주는데
		반복적으로 처리된다.
	3) trim('양쪽에 삭제할 문자' from 데이터)
		오른쪽/왼쪽 끝에 제어할 문자가 있을 때 하한번에 제거 처리한다.
**/
SELECT ltrim('****sql****','*') str1,
	   RTRIM('****sql****','*') str2,
	   TRIM('*' FROM '****sql****') str3
FROM dual;
SELECT job, LTRIM(job,'S') job1
FROM emp;
-- ex) 직책을 기준으로 왼쪽에 'S', 오른쪽에 'N'을 삭제하고 출력하세요.
SELECT job, LTRIM(job, 'S') job1, RTRIM(job,'N') job2
FROM emp;

--1. 'MANAGER' 직책을 검색하되, 해당 직책이 포함된 사원의 이름, 직책, 검색 위치를 출력하세요.
SELECT ename, job, INStr(job,'MANAGER') POS
FROM emp
WHERE  INStr(job,'MANAGER')>0;
--2. 'SALESMAN' 직책을 검색하되, 해당 직책이 포함된 사원의 이름, 직책, 검색 위치를 출력하세요.
SELECT ename, job, INStr(job,'SALESMAN') POS
FROM emp
WHERE  INStr(job,'SALESMAN')>0;
--3. 사원명을 10자리로 맞추고, 왼쪽에 '#'를 추가하여 출력하세요.
SELECT lpad(ename,10,'#') "사원명"
FROM emp;
--4. 직책을 10자리로 맞추고, 오른쪽에 '@'를 추가하여 출력하세요.
SELECT rpad(job,10,'@') "직책"
FROM emp;
--5. ' Hello' 문자열에서 왼쪽에 있는 공백을 제거하여 출력하세요.
SELECT LTRIM(' Hello',' ') "공백제거"
FROM dual;
--6. 'Java Programming ' 문자열에서 오른쪽에 있는 공백을 제거하여 출력하세요.
SELECT RTRIM('Java Programming ',' ') "공백제거"
FROM dual;
--7. ' Hello World ' 문자열에서 양쪽에 있는 공백을 제거하여 출력하세요.
SELECT TRIM(' ' FROM ' Hello World ') "공백제거"
FROM dual;
--8. 'SALESMAN' 직책에서 'ALE'을 추출하여 출력하세요.
SELECT subSTR('SALESMAN',2,3) "문자 추출"
FROM dual;