/*
# 테이블 생성
1. 데이터베이스에서 핵심 객체인 테이블 생성 물리적
	sql에 의해서 처리되는 것을 말한다.
2. 테이블 생성 기초
	1) 데이터 유형
		number : 숫자형
		varchar2(크기) : 가변형문자열
			한글 3byte(oracle)
			varchar2(10)
			==>	최대문자열 10byte
				영문은 글자 10, 한글3
				입력된 글자 크기만큼 메모리할
				himan ==> 5byte
		char(byte) : 고정형문자열
			char(10)
			==> 무조건 10byte
				'a' ==> a
				자리수가 정해진 코드성 데이터를
				사용할 때, 활용할 때 사용된다.
				주민번호, 학번, 사번, 제품시리얼
		Date : 날짜
		==> 테이블 생성시, 사용되는 가장 기초적인 데이터 유형를 분류한 것이다.
	2) 테이블 생성 기본형식
		create table(
			컬럼1명 데이터유형,
			컬럼2명 데이터유형
		);
		ps) 테이블 삭제 sql
		drop table 테이블명;
	3) 기본 데이터 입력 형식
		insert into 테이블 values(데이터1, 데이터2...);
# 복사테이블 만들기
1. 기본에 있는 테이블의 구조만 데이터 복사하고 다른 테이블명으로
설정하는 것을 말한다.
2. 데이터 + 테이블구조 모두 복사
	create table 만들어질 테이블명
	as select * from 기존테이블;
3. 테이블 구조만 복사
**/
CREATE TABLE emp02
AS SELECT * FROM EMP;
SELECT * FROM emp02;
-- 학생테이블1 학생명과 점수
CREATE TABLE student01(
	name varchar2(50),
	point number
);
INSERT INTO student01 VALUES('홍길동',70);
INSERT INTO student01 VALUES('김길동',80);
INSERT INTO student01 VALUES('신길동',90);
SELECT * FROM student01;
-- ex) 구매물건 정보 테이블(물건일련번호, 물건명, 판매가격)
CREATE TABLE product01(
	psid char(10),
	name varchar2(50),
	price number
);
INSERT INTO product01('PA1000001','사과',3000);
INSERT INTO product01('PA1000002','바나나',4000);
INSERT INTO product01('PA1000003','딸기',13000);
SELECT *FROM product01;
-- ex) 학원정보 테이블(회원아이디, 회원패스워드, 회원명, 포인트, 권한)
-- 		char() : 데이터의 크기가
--		ex) 학번, 주민번호, 사번..

-- ex) 학생정보2 테이블(학생번호, 학생명, 국어, 영어, 수학)
CREATE TABLE student02(
	sno NUMBER,
	name varchar2(50),
	kor number(3),
	eng number(3),
	math number(3)
);
INSERT INTO student02 VALUES(1, '홍길동', 70,90,80); 
INSERT INTO student02 VALUES(2, '김길동', 70,30,20); 
INSERT INTO student02 VALUES(3, '갈길동', 70,80,70);
SELECT * FROM student02;
/*
 * # 데이터의 수정
 * 1. 기본형식
 * 		update 테이블
 * 			set 컬럼 1명 = 수정데이터,
 * 				컬럼 2명 = 수정데이터
 *				...
 *				컬럼 3명 = 수정데이터
 *		where 비교/논리연산식 조건
 *
 */
SELECT * FROM STUDENT02;
-- sno 기준으로 1인 학생
-- 이름과 국어, 영어 수정
UPDATE STUDENT02 
	SET name = '유영재',
		kor = 95,
		eng = 85
	WHERE sno = 1;
/*
 * # 트랜잭션 관련 옵션
 * 1. 데이터 처리에서 안정성/보안성 확보를 위해서
 * 서버에 등록/수정/삭제시는 commit/rollback기능을 
 * 가지고 있다.
 * 2. DB서버에 접속한 사용자1는 데이터를 등록/수정/삭제 시,
 * 변경되는 데이터는 commit 하기 전까지는 이 접속자
 * 화면에서만 등록/수정/삭제명령후 처리된 데이터가 보이고,
 * 다른 사용자(접속자2)는 해당 처리된 내용으로 보이지 않는다.
 * 이 때, 접속자1이 commit하는 순간 다른 접속자2에서도
 * 데이터가 등록/수정/삭제된 데이터가 보인다.
 * 3. 접속자1은 commit하기전에서 rollback을 통해서,
 * 원래 데이터를 원복할 수 있고, commit하지 않고, 접속을
 * 끊으면 등록/수정/삭제된 데이터가 반영되지 않는다.
 * 4. 클라이언트 설정 옵션에 autocommit을 하면 위 내용이
 * 처리되지 않고, 바로 반영이 된다.
 * 
 */
SELECT * FROM STUDENT02;
UPDATE STUDENT02
	SET KOR = 90
	WHERE SNO = 1;
-- 위 툴에서 커밋/롤백 처리
-- commit; rollback;로 코드로 직접처리 가능하다.
COMMIT;
rollback;
-- ex) 이름 기준으로 김길동인 경우에 국어(80), 영어(80)
-- 수학(90) 변경하여 처리하되 변경후, 확인 ==>
-- rollback 후 확인 ==> 수정 후 commit ==> 데이터 확인
SELECT * FROM STUDENT02;
UPDATE STUDENT02
	SET KOR = 80,
		eng = 80,
		MATH = 90
	WHERE name = '김길동';
COMMIT;
rollback;
-- 수학점수를 5점씩 다 올리는 처리..
UPDATE STUDENT02 
	SET MATH = MATH + 5;
-- 현재 math에서 5점을 더하고 math에 할당처리..
-- ex) (국어또는)영어점수가 80점인 경우에 기존 점수에서
-- 	   5점을 더 추가해서 처리하세요.
UPDATE STUDENT02
SET ENG = CASE WHEN ENG = 80 THEN ENG + 5 ELSE ENG END,
    KOR = CASE WHEN KOR = 80 THEN KOR + 5 ELSE KOR END
WHERE ENG = 80 OR KOR = 80;

SELECT * FROM STUDENT02;
/*
 * 1. 데이터는 행단위로 선택해서 삭제를 처리할 수 있다.
 *    주의) 특정한 데이터를 null로 삭제하는 것을 삭제가
 *    아니라, 수정구문에 의해서 null로 수정처리하면 된다.
 * 2. 삭제 기본 형식 
 *    delete : 행 단위 삭제이기에 컬럼지정할 필요없음.
 *    from 테이블명
 *    where 조건구문(비교|논리연산자)
 */
SELECT * FROM EMP01;
-- 사원번호가 7369를 삭제 처리
DELETE 
FROM EMP01 
WHERE EMPNO = 7369;
-- ex1) 직책(job)이 SALESMAN인 데이터를 삭제
DELETE 
FROM EMP01
WHERE job = 'SALESMAN';
-- ex2) 급여(sal)가 2000~3000 사이 데이터 삭제
DELETE 
FROM EMP01
WHERE sal BETWEEN 2000 AND 3000;


















