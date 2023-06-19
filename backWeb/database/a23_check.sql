/*
# check
1. 특정 컬럼에 조건이나 범위를 지정해서,
	해당 범위에 데이터만 입력되도록 처리하는 것을 말한다.
2. 형식
	컬럼명 데이터유형 constraint 제약명 check(조건데이터-where문하위 sql)
	컬럼명 데이터유형 check(제약조건 내용)
*/
CREATE TABLE STUDENT06(
	gender varchar2(1) CONSTRAINT STUDENT06_gender_ck
		CHECK(gender IN('F','M'))
);
INSERT INTO STUDENT06 values('F');
INSERT INTO STUDENT06 values('M');
INSERT INTO STUDENT06 values('남');
INSERT INTO STUDENT06 values('여자');
INSERT INTO STUDENT06 values('B');
INSERT INTO STUDENT06 values(null);
SELECT * FROM STUDENT06;

-- student07 테이블을 생성해서
-- sno(프라이머리키), 이름,
-- 성별(남/여), 국어(0~100), 영어(0~100), 수학(0~100)
-- 한글- 3byte
CREATE TABLE student07(
	sno NUMBER PRIMARY KEY,
	gender varchar2(3) CONSTRAINT STUDENT07_gender_ck
		CHECK(gender IN('남','여')),
	kor NUMBER,
	eng NUMBER,
	math NUMBER
);
INSERT INTO student07 values(1,'남',50,60,70);
INSERT INTO student07 values(2,'여',60,60,80);
INSERT INTO student07 values(3,'남',70,60,90);
SELECT * FROM student07;
/*
# 외래키 설정 관계(foreign key)
1. 연관관계 있는 두 테이블에 대하여, 한쪽 테이블에 있는 데이터 기준으로 
	다른 테이블의 데이터를 입력할 수 있게 하는 것을 말한다.
	ex) dept 테이블의 deptno만 emp테이블에 입력가능하게 처리.
2. 기본 형식
	컬럼명 데이터유형 constraint 테이블명_컬럼명_fk
		references 대상테이블명(컬럼명)
 */
CREATE TABLE teacher01(
	tno NUMBER PRIMARY KEY
);
INSERT INTO teacher01 values(10);
INSERT INTO teacher01 values(20);
INSERT INTO teacher01 values(30);
INSERT INTO teacher01 values(40);
SELECT * FROM teacher01 ;
CREATE TABLE STUDENT08(
	nema varchar2(10),
	tno NUMBER CONSTRAINT student08_tno_fk
		references teacher01(tno)
);
INSERT INTO STUDENT08 VALUES('홍길동',10);
INSERT INTO STUDENT08 VALUES('김길동',20);
INSERT INTO STUDENT08 VALUES('박길동',30);
INSERT INTO STUDENT08 VALUES('최길동',40);
SELECT * FROM STUDENT08;
/*
ex) 물건테이블(물건번호, 물건명, 가격, 재고량)
	구매테이블(구매번호, 구매수량, 물건번호-외래키설정)
**/
CREATE TABLE pt01(
	pno NUMBER PRIMARY KEY,
	pname varchar2(50),
	price NUMBER,
	stock NUMBER
);
INSERT INTO pt01 VALUES(1001,'사과',3500,30);
INSERT INTO pt01 VALUES(1002,'바나나',4000,20);
INSERT INTO pt01 VALUES(1003,'딸기',5000,10);
SELECT *FROM pt01;
CREATE TABLE bt01(
	bno NUMBER PRIMARY KEY,
	bnum number,
	pno NUMBER CONSTRAINT bt01_pno_fk
		references pt01(pno)
);
INSERT INTO bt01 VALUES(1001,5,1001);
INSERT INTO bt01 VALUES(1002,10,1002);
INSERT INTO bt01 VALUES(1003,15,1003);
SELECT * FROM bt01;

--[1단계:코드] 4. Enrollments라는 테이블을 생성하고, 학생의 학번(student_id)과 수강한 강의의 고유번호(course_id)를 저장하는데, 
--              각각의 값은 Students 테이블과 Courses 테이블의 학번과 고유번호를 참조하는 외래키로 설정되도록 하세요.
-- Students 테이블 생성
CREATE TABLE Students(
	student_id NUMBER PRIMARY KEY,
	sname varchar2(50)
);
-- Students 테이블 데이터 추가
INSERT INTO Students VALUES(1001,'이은서');
INSERT INTO Students VALUES(1002,'서유림');
INSERT INTO Students VALUES(1003,'유영재');
INSERT INTO Students VALUES(1004,'정준혁');
-- Courses 테이블 생성
CREATE TABLE Courses(
	course_id NUMBER PRIMARY KEY,
	cname varchar2(50)
);
-- Courses 테이블 데이터 추가
INSERT INTO Courses VALUES(1001,'국어');
INSERT INTO Courses VALUES(1002,'영어');
INSERT INTO Courses VALUES(1003,'수학');
INSERT INTO Courses VALUES(1004,'과학');
-- Enrollments 테이블 생성(외래키)
CREATE TABLE Enrollments(
	student_id NUMBER CONSTRAINT Enrollments_student_id_fk
		references Students(student_id),
	course_id NUMBER CONSTRAINT Enrollments_course_id_fk
		references Courses(course_id)
);
-- Enrollments 테이블 데이터 추가
INSERT INTO Enrollments VALUES(1001,1001);
INSERT INTO Enrollments VALUES(1002,1002);
INSERT INTO Enrollments VALUES(1003,1003);
-- 종합 데이터 조회
SELECT s.student_id "학번",s.sname "이름",c.course_id "강의번호",c.cname "강의명"
FROM Enrollments e, Students s, Courses c
WHERE e.student_id = s.student_id
AND e.course_id = c.course_id;














