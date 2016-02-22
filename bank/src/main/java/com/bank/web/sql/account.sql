SELECT * FROM account;

CREATE SEQUENCE seq 
-- INCREMENT BY 1 증감숫자이며 1씩 증가시킬 때는 생략이 가능하다.
START WITH 1;

DROP TABLE account;

CREATE TABLE account(
	seq NUMBER PRIMARY KEY,
	accountNo NUMBER,
	money NUMBER,
	password NUMBER,
	userid VARCHAR2(30),
	CONSTRAINT account_member_fk
	FOREIGN KEY(userid)
	REFERENCES member(userid)
);

INSERT INTO account VALUES(
	seq.NEXTVAL, 1000, 10000, 1, 'kim'
);
INSERT INTO account VALUES(
	seq.NEXTVAL, 1001, 20000, 1, 'lee'
);
INSERT INTO account VALUES(
	seq.NEXTVAL, 1002, 30000, 1, 'kang'
);