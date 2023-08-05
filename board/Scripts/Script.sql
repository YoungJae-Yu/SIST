SELECT * FROM MEMBEr01;
CREATE TABLE board(
	NO NUMBER PRIMARY KEY,
	refno NUMBER,
	subject varchar2(200),
	content varchar2(2000),
	writer varchar2(100),
	readcnt NUMBER,
	regdte DATE,
	uptdte date
);
CREATE TABLE boardfile(
	NO NUMBER,
	fname varchar2(200),
	directory varchar2(500),
	info varchar2(300),
	regdte DATE,
	uptdte DATE,
	auth varchar2(100)
);
CREATE SEQUENCE board_seq;

--		페이징 처리를 위한 전체 데이터 건수 가져오기
SELECT count(*)
FROM board


WHERE subject LIKE '%'||''||'%'
AND writer LIKE '%'||''||'%';
--		기본 계층적 조회
SELECT *
FROM (
	SELECT rownum cnt, LEVEL, b.*
	FROM board b
	WHERE subject LIKE '%'||''||'%'
	AND writer LIKE '%'||''||'%'
	start with refno = 0
	CONNECT BY PRIOR NO = refno
	ORDER siblings BY NO DESC )
WHERE cnt BETWEEN 1 AND 10;
--		고유 시퀀스번호 가져오기
SELECT board_seq.nextval FROM dual;
--		각 고유번호에 따른 게시물과 첨부파일
SELECT *
FROM board
WHERE NO = 1;
SELECT *
FROM boardfile
WHERE NO = 1;
--		멤버의 로그인
SELECT *
FROM MEMBER01
WHERE id = 'himan'
AND pass = '7777';
--		게시물 등록
SELECT * FROM board;
INSERT INTO board VALUES(1,0,'첫번째글','내용',
'himan',0, sysdate, sysdate);
--		게시물 첨부파일 정보 등록
SELECT * FROM BOARDFILE;
INSERT INTO BOARDFILE values(1,'a01.txt','','첫번째글',
	sysdate,sysdate,'관리자');


--		게시물 조회수 수정
UPDATE board
	SET readcnt = readcnt+1
WHERE NO = 1;
--		게시물 수정
UPDATE board
	SET subject = '첫번째글수정',
		content = '내용수정',
		uptdte = sysdate
WHERE NO = 1;
--		게시물 첨부파일 정보 수정
UPDATE boardfile
	SET fname='a01.txt',
	    info = '첫번째글',
	    uptdte = sysdate
WHERE NO = 1;	
SELECT * FROM boardfile;
--		게시물 삭제
DELETE FROM board
WHERE NO = 0;
--		게시물 첨부파일 정보삭제
DELETE FROM boardfile
WHERE NO = 0;
/*
private int no;
private int refno;
private String subject;
private String content;
private String writer;
private int readcnt;
private Date regdte; 
private Date uptdte; 
 **/

   	   select *
   	   from board
   	   where subject like '%'||''||'%'
   	   and writer  like '%'||''||'%';

SELECT * FROM board;

	select rownum cnt, level, b.*
	from board b
	where 1=1
	and subject like '%'||''||'%'
	and writer like '%'||''||'%'
	start with refno = 0
	connect by prior no = refno
	order siblings by no DESC
;
SELECT * FROM boardfile;
INSERT INTO BOARDFILE values(1,'a01.txt','','첫번째글',
	sysdate,sysdate,'관리자');
INSERT INTO BOARDFILE values(#{no},#{fname},'',#{info}
	sysdate,sysdate,'');
/*
private int no;
private String fname;
private String directory;
private String info;
private Date regdte;
private Date uptdte;
private String auth;
 */
SELECT * FROM dept;



