CREATE TABLE member02(
	id varchar2(50),
	pass varchar2(50),
	name varchar2(50),
	point NUMBER,
	auth varchar2(20),
	regdate date
);
SELECT * FROM member02;
INSERT INTO member02 values('himan','7777','홍길동',1000,'관리자',sysdate);
SELECT * FROM member02
WHERE id='himan' AND pass = '7777'
;
/*
SELECT * FROM member02
WHERE id=? AND pass = ?

ShMember
private String id;
private String pass;
private String name;
private int point;
private String auth;
private Date regdate;
생성자 id, pass 추가..
 */
-- if, while
-- 행이 다수행의 데이터 나온다. : while() row(행)
-- 행이 한개 데이터 나온다. : if row(행)
--    - 컬럼1개 - 결과값이 1개의 column으로 표시되는 경우
--			기본데이터형, String	
--    - 컬럼여러개 SELECT *, SELECT EMPNO, ENAME...
--					객체(여러속성)
SELECT COUNT(*) 
FROM EMP e 
WHERE DEPTNO =10;
SELECT *
FROM EMP e 
WHERE DEPTNO =10;

SELECT *FROM EMP e ;

SELECT * FROM 회원정보;
