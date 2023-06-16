SELECT *FROM emp02;
SELECT *FROM DEPT;
CREATE TABLE DEPT01
AS SELECT * FROM dept;
SELECT * FROM DEPT01;
SELECT *FROM 회원정보;


CREATE TABLE 회원정보 (
    id INT NOT NULL,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL
);
INSERT INTO 회원정보 (id, username, email, password)
VALUES (1, '홍길동', 'hong@xxx.com', 'abc123');
INSERT INTO 회원정보 (id, username, email, password)
VALUES (2, '김길동', 'kim@xxx.com', 'abc124');
INSERT INTO 회원정보 (id, username, email, password)
VALUES (3, '박길동', 'park@xxx.com', 'abc125');
INSERT INTO 회원정보 (id, username, email, password)
VALUES (4, '이길동', 'lee@xxx.com', 'abc126');
INSERT INTO 회원정보 (id, username, email, password)
VALUES (5, '최길동', 'choi@xxx.com', 'abc127');
    
SELECT * FROM 회원정보;
    
   