/*
# 테이블 구조 변경
1. 테이블을 사용하다보면 여러가지 상황에 의해 테이블의 구조를 변경하는
	경우가 발행한다. 테이블의 구조를 변경하는데 필요한 명령어를 파악하고,
	테이블 구조의 변경시 발생하는 데이터 처리에 대한 내용을 파악해보자.
	1) 유형
	컬럼의 추가, 컬럼의 삭제, 컬럼의 속성 변경, 제약조건 변경 등등.
2. 컬럼의 추가
	alter table 테이블명
	add 컬럼명 데이터유형 [default 디폴트데이터, 제약조건]
3. 컬럼명의 변경
	alter table 테이블명
	rename column 기존컬럼명 to 새로운 컬럼명;
4. 컬럼의 삭제
	alter table 테이블명
	drop column 삭제할 컬럼명
5. 컬럼의 수정..
	alter table 테이블명
	modify 컬럼명 변경할속성
6. 테이블 관련
	1) 테이블 삭제
		drop table 테이블명
	2) 테이블 이름 변경
		alter table 테이블명 rename to 새로운테이블명;
# 주의
1) 오라클에서는 안타깝게도 컬럼명이 위치는 변경이 불가능
2) 복사테이블 만들시, constraint는 복사가 되지 않으니
	constraint는 위, alter 명령에 의해
		제약조건을 처리하여야 한다.

**/
DROP TABLE STUDENT06;
DROP SEQUENCE seq02;
SELECT * FROM STUDENT01;
ALTER TABLE STUDENT01
ADD sno NUMBER;

CREATE TABLE emp10
AS SELECT empno, ename, job, sal FROM emp;
SELECT * FROM emp10;
ALTER TABLE emp10
ADD address varchar2(50) DEFAULT '주소없음';
SELECT * FROM emp10;
-- ex) emp11로 부서명, 사원명, 직책, 급여로
-- 복사테이블을 만들때, bonus 컬럼을 추가하고,
-- default 데이터로 0을 입력처리하세요.
CREATE TABLE emp11
AS SELECT deptno, ename, job, sal FROM emp;
ALTER TABLE emp11
ADD bonus NUMBER DEFAULT 0;
SELECT * FROM emp11;
UPDATE emp11
SET bonus = -1
WHERE bonus = 0;
-- 컬럼삭제
ALTER TABLE emp11 DROP COLUMN job;
ALTER TABLE emp12 DROP COLUMN adderss;
SELECT * FROM emp11;
-- 컬럼수정
ALTER TABLE emp11
MODIFY ename varchar2(1000);
-- 주의 컬럼 수정시, 저장된 데이터보다 작은 데이터 유형으로 수정이 불가능
-- 유형 변경도 불가능하다.
ALTER TABLE emp11
MODIFY ename varchar2(100);
ALTER TABLE emp11
MODIFY ename number;
-- 테이블 이름 변경
ALTER TABLE emp11 RENAME TO emp12;
SELECT * FROM emp12;
/*
ex) emp13을 emp테이블 기준을 복사하여
1. dname 추가, ename => empname으로 변경
	job ==> varchar(100) 변경,
	deptno 를 dept테이블의 foreign key 제약조건 설정
	comm 컬럼을 삭제 처리하세요
**/
CREATE TABLE emp13
AS SELECT dname, ename, job, sal 
FROM emp e, dept d
WHERE e.DEPTNO = d.DEPTNO;
SELECT *FROM emp13;
alter table emp13
rename column ename to empname;
ALTER TABLE emp13
MODIFY job varchar2(100);



