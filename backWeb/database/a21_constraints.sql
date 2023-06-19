/*
# 데이터 무결성 제약조건
1. 데이터의 정확성과 일관성을 보장
2. 데이터의 정확성을 유지하여 다양한 종류의 업무규칙을 고려함
	1) student테이블에서 학년 데이터는 1,2,3,4 중의 하나만 입력
	2) 모든 학번은 유일하게 처리
	3) student테이블의 지도 교수 번호는 professor 테이블의
		교수번호 중의 하나와 반드시 일치
3. 데이터 무결성 제약조건의 장점
	1) 테이블 생성시 무결성 제약조건을 정의 가능
		- 생성 후 제약조건 변경이나 설정도 가능
	2) 테이블에 대해 정의, 데이터 딕션너리에 저장되므로
		응용프로그램에서 입력되는 모든 데이터에 대하여 동일하게 적용
	3) 제약조건을 확성화, 비활성화 할 수 있어 융통성 있게 사용 가능
4. 무결성 제약조건의 종류
	1) not null : 데이터에 null을 포함할 수 없음..
				행단위로 입력시 해당 열은 반드시 입력되어야 처리가 된다
	2) unique key : 테이블의 모든 행에서 고유한 값을 갖는 열 또는
				열 조합을 지정해야 한다. ex) 학번, 주민번호, 사원번호를
				중복되지 않아야 한다.
				ps) null은 입력이 가능하고, 여러가지 null은 중복이 가능..
					무조건 primary key를 통해서 not null + 구분자로
					처리하는 것이 아니라 구분을 하되 데이터가 확정되지 않은
					경우는 null로 할당하게 할 때, 사용된다.
	3) primary key : 해당 컬럼 값은 반드시 존재하며 유일해야 한다.
		not null과 nuique가 결합된 형태
		주로 테이블에서 식별해야할 컬럼 즉, key를 설정할 때, 사용된다.
		ex) emp테이블의 empno, dept테이블의 deptno
	4) foreign key : 한 열과 참조된 테이블의 열간의 외래 키 관계를 설정하고 시행
		ex) 사원 테이블의 부서번호는 반드시 부서테이블에 있는 부서번호이어야 한다.
	5) check : 해당 컬럼에 저장 가능한 데이터 범위나 조건을 지정처리
		ex) student 테이블의 학년은 1,2,3,4만 데이터로 넣을 수 있다.
5. 설정 형식
	1) 컬럼명 데이터타입 constraints 제약조건명 제약조건
		제약조건명 : 테이블명_컬럼명_제약조건종류
	2) primary key 지정	
	ex) create table student(
		stuno number constraint student_stuno_pk primary key,
		name varchar2 not null, -- 제약명을 자동으로 설정
		grade number(1),
		constraint student_grade_ck check (grade in (1,2,3,4))
		-- 테이블 생성 마지막 라인에서 제약조건 선언 형태.
	);
	제약조건 이름 : 테이블명_컬럼명_제약조건종류
		제약조건 종류 : pk, uq, nn, fk
*/
-- 사원 정보의 제약 조건 테이블에서 확인해보기
SELECT *
FROM sys.ALL_constraints
WHERE table_name LIKE 'EMP';
-- # not null 제약 조건 설정
CREATE TABLE student03(
	name varchar(30) CONSTRAINT student03_name_nn NOT NULL
);
SELECT *
FROM sys.all_constraints
WHERE TABLE_name = 'STUDENT03';
INSERT INTO STUDENT03 values('홍길동');
INSERT INTO STUDENT03 values('김길동');
INSERT INTO STUDENT03 values('홍길동');
--INSERT INTO STUDENT03 values(null); nn제약조건
SELECT * FROM STUDENT03;
-- ex) student04 테이블로 학생번호(숫자), 이름, 국어, 영어, 수학
-- 테이블을 만들면서, 학생번호와 이름을 not null로
-- 제약조건을 만들고, 조회/확인해보자.
CREATE TABLE student04(
	stuno varchar(30) CONSTRAINT student04_stuno_nn NOT NULL,
	sname varchar(30) CONSTRAINT student04_sname_nn NOT NULL,
	kor NUMBER ,
	eng NUMBER,
	math NUMBER 
);
INSERT INTO STUDENT04 values('1','홍길동',50,60,70);
INSERT INTO STUDENT04 values('2','김길동',60,70,60);
INSERT INTO STUDENT04 values('3','박길동',70,80,50);
SELECT * FROM student04;
SELECT *
FROM sys.all_constraints
WHERE TABLE_name = 'STUDENT04';
-- # unique : 중복되지 않는 유일키만 입력가능, 단 null을 중복 허용
CREATE TABLE EMPLOYEES01(
	empno NUMBER(5) CONSTRAINT employee01_empno_uq UNIQUE,
	ename varchar2(30) CONSTRAINT employee01_ename_nn NOT NULL,
	sal number(5)
);
SELECT *
FROM sys.all_constraints
WHERE TABLE_name = 'EMPLOYEES01';
INSERT INTO EMPLOYEES01 VALUES(1,'홍길동', 1000);
INSERT INTO EMPLOYEES01 VALUES(2,'김길동', 2000);
INSERT INTO EMPLOYEES01(empno,ename) VALUES(3,'마길동');
--INSERT INTO EMPLOYEES01 VALUES(3,'오길동', 4000);
-- 동일한 사원 정보 입력시 에러
INSERT INTO EMPLOYEES01 VALUES(NULL,'하길동', 4000);
INSERT INTO EMPLOYEES01(ename, sal) VALUES('신길동', 5000);
-- null은 동일하여도 에러발생하지 않음..
SELECT * FROM EMPLOYEES01;
-- # primary key : not, unique를 동시에 처리할 수 있는 제약으로
-- 일반적으로 행단위 식별 컬럼을 지정할 때, 사용된다.
CREATE TABLE EMPLOYEES02(
	empno NUMBER(4) PRIMARY KEY -- 제약조건을 자동 설정
);
CREATE TABLE employees03(
	empno number(4) CONSTRAINT employees03_empno_pk PRIMARY KEY
);
SELECT *
FROM sys.all_constraints
WHERE TABLE_name IN ('EMPLOYEES02','EMPLOYEES03');
INSERT INTO EMPLOYEES02 VALUES(1000);
INSERT INTO EMPLOYEES02 VALUES(1001);
INSERT INTO EMPLOYEES02 VALUES(1001);
INSERT INTO EMPLOYEES02 VALUES(1002);
INSERT INTO EMPLOYEES02 VALUES(NULL);
SELECT * FROM EMPLOYEES02;
-- ex) product02 테이블에 pid(물건 식별자-),
-- 물건명(not null), 가격 설정하여 sys.all_constraints
-- 테이블 확인, 입력 처리하세요.
CREATE TABLE product02(
	pid varchar2(50) PRIMARY KEY,
	pname varchar2(50) CONSTRAINT product02_pname_nn NOT NULL,
	price NUMBER
);
INSERT INTO PRODUCT02 VALUES('1001','사과',5000);
INSERT INTO PRODUCT02 VALUES('1002','바나나',3000);
INSERT INTO PRODUCT02 VALUES('1003','키위',6000);
INSERT INTO PRODUCT02 VALUES(null,'키위',6000);

SELECT * FROM product02;

SELECT *
FROM sys.all_constraints
WHERE TABLE_name IN ('PRODUCT02');

-- ex) sequence 예제 1100으로 시작하는 sequence 를 만들어서
-- product02 테이블에 10개 데이터를 입력 처리하세요..
CREATE SEQUENCE seq02
	START WITH 1100;

INSERT INTO product02 values(seq02.nextval,'사과',5000);


