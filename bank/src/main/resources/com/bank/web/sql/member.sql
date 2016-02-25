select * from test;
-- 실행 단축키 : ALT + X
SELECT * FROM member;
drop table member;

CREATE TABLE member(
	userid VARCHAR2(30) PRIMARY KEY, 
	name VARCHAR2(30),
	password VARCHAR2(30),
	addr VARCHAR2(30),
	birth NUMBER
);

INSERT INTO member(userid,name,password,addr,birth)
VALUES ('kim', '김유신','1','서울',2000);
INSERT INTO member(userid,name,password,addr,birth)
VALUES ('lee', '이순신','1','안양',1995);
INSERT INTO member(userid,name,password,addr,birth)
VALUES ('kang', '강감찬','1','인천',2005);

delete from member where userid = 'kim';