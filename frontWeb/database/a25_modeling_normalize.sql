/*
# 정규화 
1. 정규화와 이상 현상
	1) 이상 현상
		불필요한 데이터의 중복으로 인해 릴레이션(테이블간의 연관관계)에
		대한 데이터의 삽입, 수정, 삭제 연산을 수행할 때, 발생하는
		부작용을 말한다.
	2) 정규화 과정
		이러한 이상 현상을 제거하면서 데이터베이스를 무결성 있게 설계해
		나가는 과정을 말한다.
2. 이상현상의 종류
	1) 삽입 이상 : 새 데이터를 삽입하기 위해 불필요한 데이터도 함께
		삽입해야 하는 문제
		ex) empdept(통합테이블)의 경우
			부서나 사원정보 중 하나만 입력하더라도 다른 정보를
			null로 남겨두거나 임의로 입렵해야 하는 상황 발생
	2) 갱신 이상 : 중복 튜플 중 일부만 변경하여 데이터가 불일치하게
		되는 모습의 문제
		ex) empdept(통합테이블) 에서 부서명을 하나의 사원 정보
		단위로 수정할 때, 오타로 공백이나 다른 부서명으로 수정시
		부서명이 통일화 되지 않는 상황이 발생한다.
	3) 삭제 이상 : 튜플을 삭제하면 꼭 필요한 데이터까지 삭제되는
		데이터 손실의 문제
		ex) empdept(통합테이블)에서 10부서는 삭제하는데, 연관되어
		있는 사원정보가 모두 삭제되는 현상 발생..
3. 정규화를 위한 단계적 학습 내용
	1) 정규화 과정은 이러한 이상 현상을 효과적으로 처리하기 위해
		단계별 과정을 가진다.
	2) 이 과정을 각 단계별로 정규화를 효과적으로 처리하기 위한 내용이고,
		이전 과정을 거쳐야 다음과정을 처리하게 하고있다.
	3) 개괄적으로
		제1정규화
		제2정규화
		제3정규화
		BCNF정규화
		제4정규화
		제5정규화
		로 구분 되는데, 실무적으로는 1~3정규화까지 많이 활용되고,
		데이터의 용량과 복잡성에 따라 정규화과정에 의해서 무결성은
		보장되지만 속도이슈때문에 역정규화 과정을 거치는 경우도 많다.
	4) 정규화의 핵심을 1~3정규화에서 사용되는 함수 개념부터 확인하여야 한다.
		- 데이터의 원자성
		- 완전함수 종속성
		- 이행적 함수 종속성
		
# 제1정규화 처리
1. 릴레이션의 모든 속성이 더는 분해되지 않는 원자값만 가지면 
	제1정규형을 만족한다.
2. 제1정규형 만족해야 관계 데이터베이스의 릴레이션이 될 자격이 있다.
*/
-- 제1정규화 전 테이블
CREATE TABLE normalForm00(
	cuid varchar2(50),-- 고객 아이디
	eventno varchar2(100), -- 이벤트 번호
	ck_yn varchar2(50), -- 당첨여부
	grade varchar2(10), -- 등급
	discount number(4,2)--할인율
);
INSERT INTO normalForm00 values(
	'apple','E001,E005,E010',
	'Y,N,Y', 'gold', 0.1
);
INSERT INTO normalForm00 values(
	'banana','E002,E005',
	'Y,N', 'vip', 0.1
);
INSERT INTO normalForm00 values(
	'carrot','E003,E007',
	'Y,Y', 'gold', 0.1
);
INSERT INTO normalForm00 values(
	'orange','E004',
	'N', 'silver', 0.05
);
SELECT * FROM normalForm00;
-- ex) 제1정규화 테이블로 normalForm01로 해서 테이블을
-- 만들고 데이터를 입력하세요
CREATE TABLE normalForm01
AS SELECT * FROM normalForm00 WHERE 1=0;
INSERT INTO normalForm01 values(
	'apple','E001','Y', 'gold', 0.1
);
INSERT INTO normalForm01 values(
	'apple','E005','N', 'gold', 0.1
);
INSERT INTO normalForm01 values(
	'apple','E0010','Y', 'gold', 0.1
);
INSERT INTO normalForm01 values(
	'banana','E002','N', 'vip', 0.2
);
INSERT INTO normalForm01 values(
	'banana','E005','Y', 'vip', 0.2
);
INSERT INTO normalForm01 values(
	'carrot','E003','Y', 'gold', 0.1
);
INSERT INTO normalForm01 values(
	'carrot','E007','Y', 'gold', 0.1
);
INSERT INTO normalForm01 values(
	'orange','E004','N', 'silver', 0.05
);
SELECT * FROM NORMALFORM01 ;
-- 제1정규화가 일어나지 않는 테이블 script예시
CREATE TABLE NORMALFORM001(
	student_id int PRIMARY KEY,
	student_name varchar(100),
	course1 varchar(100),
	course2 varchar(100),
	course3 varchar(100)
);
-- 위 내용을 course1을 course2..등으로 한 학생이
-- 여러개의 과목을 수강하는 경우, 해당 학생의 정보가 중복되어 저장
-- 될 수 있다.
-- 제1정규화를 거친 테이블 구종
CREATE TABLE NORMALFORM011(
	student_id int PRIMARY KEY,
	student_name varchar2(100)
);
CREATE TABLE NORMALFORM021(
	course_id int PRIMARY KEY,
	course_name varchar2(100)
);
CREATE TABLE NORMALFORM032(
	student_id int,
	course_id int,
	FOREIGN KEY (student_id) REFERENCES NORMALFORM011(student_id),
	FOREIGN KEY (course_id) REFERENCES NORMALFORM021(course_id)
);
-- 위 테이블의 경우에 phone_numbers에 여러 개의 전화번호를
-- 입력하는 경우에 제1정규화에 위배될 수 있다. 이 경우도
-- 특정 데이터의 일부분을 추출하거나 특정 값을 검색하기가 어려워지는
-- 경우가 발생한다.
CREATE TABLE NORMALFORM012(
	EMPLOYEES_id INt PRIMARY KEY,
	EMPLOYEES_name varchar2(100)
);
-- 사원 : 010-5422-3342, 010-7592-3432
-- ==>
-- 1 himan 010-5422-3342
-- 2 himan 010-7592-3432
CREATE TABLE NORMALFORM022(
	phone_id INt PRIMARY KEY,
	EMPLOYEES_id INt,
	phone_number varchar2(100),
	FOREIGN KEY (EMPLOYEES_id) REFERENCES NORMALFORM012(EMPLOYEES_id)
);
/*
ex) 아래 구조의 내용을 테이블로 만들어보고(정규화전 테이블)
	정규화가 정리된 테이블도 만들어보세요..
	
	주문정보
		주문번호  고객이름  	주문날짜 		상품목록
		1		홍길동	2023-05-18	사과, 바나나, 딸기
		2		마길동	2023-05-19	사과, 오렌지, 수박
		3		오길동	2023-05-20 	바나나, 딸기, 키위
		
	==> 제1정규화가 적용된 주문상품 테이블
	주문정보
		주문번호  고객이름  	주문날짜 		상품목록
		1		홍길동	2023-05-18	사과
		1		홍길동	2023-05-18	바나나
		1		홍길동	2023-05-18	딸기
		2		마길동	2023-05-19	사과
		2		마길동	2023-05-19	오렌지
		2		마길동	2023-05-19	수박
		3		오길동	2023-05-20 	바나나
		3		오길동	2023-05-20 	딸기
		3		오길동	2023-05-20 	키위
	
	학생정보테이블
		학생id	학생이름	과목1		과목2		과목3
		1		홍길동	수학		영어		과학
		2		마길동	역사		지리		음악
		3		하길동	체육		미술		수학
		
	==> 제1정규화가 적용된 주문상품 테이블
	학생테이블
		학생id	학생이름
		1		홍길동
		2		마길동
		3		하길동
	
	과목테이블
		과목id	과목이름
		1		수학
		2		영어
		3		과학
		4		역사
		5		지리
		6		음악
		7		체육
		8		미술
	
	학생-과목 연결 테이블
		1		1
		1		2
		1		3
		2		4
		2		5
		2		6
		3		7
		3		8
		3		1
		
ex) 아래테이블을 정규화과정을 처리하세요
	주문정보테이블
	주문번호	고객명		주문일자		상품명
	1		홍길동,김철수	2022-01-01	노트북,키보드,마우스
	2		이영희		2022-02-15	스마트폰
	3		박지성		2022-03-10	모니터
	
	==> 테이블 분리, 컬럼지정.
	고객분리
	고객번호	이름
	1		홍길동
	2		김철수
	3		이영희
	4		박지성
	
	주문정보(주문-고객)
	주문번호  고객번호  	주문일자
	1		1		2022-01-01
	1		2		2022-01-01
	2		3		2022-02-15
	3		4		2022-03-10
	
	주문상품정보(주문-상품)
	주문번호	상품명
	1		노트북
	1		키보드
	1		마우스
	2		스마트폰
	3		모니터
	
	
		
	
	주문정보테이블
	주문번호	고객명		주문일자		상품명
	1		홍길동		2022-01-01	노트북
	1		홍길동		2022-01-01	키보드
	1		홍길동		2022-01-01	마우스
	1		김철수		2022-01-01	노트북
	1		김철수		2022-01-01	키보드
	1		김철수		2022-01-01	마우스
	2		이영희		2022-02-15	스마트폰
	3		박지성		2022-03-10	모니터
	
	
 */
CREATE TABLE ORDERinfo01(
	ORDER_num int PRIMARY KEY,
	Customer_name varchar2(50),
	Order_Date DATE,
	Product_list varchar2(50)
);













































