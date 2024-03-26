show tables;

CREATE TABLE insa2 (
	idx INT NOT NULL auto_increment PRIMARY KEY, /* 고유번호 */
	name VARCHAR(20) NOT NULL, /* 이름 */
	age INT DEFAULT 20, /* 나이 */
	gender CHAR(2) DEFAULT '여자', /* 성별 */
	ipsail datetime DEFAULT now() /* 입사일 */
);

DESC insa2;
DROP TABLE insa2;

SELECT * FROM insa2;

INSERT INTO insa2 VALUES (DEFAULT, '김말숙', DEFAULT, DEFAULT, DEFAULT);
INSERT INTO insa2 VALUES (DEFAULT, '홍길동', DEFAULT, '남자', DEFAULT);
INSERT INTO insa2 (name) VALUES ('오하늘'); /* 디폴트가 많으면 들어갈 값만 필드를 써놓고 그 값만 써서 사용하기 */
