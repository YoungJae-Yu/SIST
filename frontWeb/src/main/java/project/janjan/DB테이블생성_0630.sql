CREATE TABLE MEMBER_INFO(
MEMID varchar2(30) PRIMARY KEY,
PASSWORD varchar2(50),
NAME VARCHAR2(20),
ADDRESS VARCHAR2(50),
CONTACT VARCHAR2(30),
EMAIL VARCHAR2(30),
AUTH NUMBER
);
 
DROP TABLE MEMBER_INFO;

INSERT INTO MEMBER_INFO values('vanana','7777','노현우','서울 강서구','010-1111-2345','ggg1234@naver.com',1);
INSERT INTO MEMBER_INFO values('dan1792','Dan1792@@','정다은','서울 구로구','010-5105-1792','dan1792@naver.com',NULL);

SELECT * FROM MEMBER_INFO;

CREATE TABLE ALCOHOL(
ALCOHOL_NAME VARCHAR2(50),
TYPE_NAME VARCHAR2(50),
ALCOHOL_DEG NUMBER,
ALCOHOL_PRICE NUMBER,
ALCOHOL_VOL NUMBER,
EXPDATE DATE,
STORAGE_WAY VARCHAR2(30),
ALCOHOL_IMG VARCHAR2(100),
ALCOHOL_DES VARCHAR2(50),
SALE_YN VARCHAR2(10),
CONSTRAINT alcohol_pk PRIMARY KEY (ALCOHOL_NAME),
CONSTRAINT alcohol_fk FOREIGN KEY (type_name) REFERENCES alcohol_type(type_name)
);

CREATE TABLE alcohol_type (
TYPE_NAME VARCHAR2(50) PRIMARY key
);

INSERT INTO alcohol_type values('탁주');
INSERT INTO alcohol_type values('청주');
INSERT INTO alcohol_type values('증류주');
INSERT INTO alcohol_type values('약주');
INSERT INTO alcohol_type values('과실주');
INSERT INTO alcohol_type values('와인');

INSERT ALL
INTO alcohol values('매실원주','과실주',13,6200,375,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/매실원주.jpg','#달콤한 매실주','Y')
INTO alcohol values('고흥유자주','과실주',8,13000,500,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/고흥유자주.jpg','#달콤한 유자향','N')
INTO alcohol values('신애유자','과실주',5,5900,330,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/신애유자.jpg','#레모네이드에 사과 한 조각','N')
INTO alcohol values('요새로제','과실주',6,17900,750,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/요새로제.jpg','#달콤한 사과향','Y')
INTO alcohol values('댄싱파파','과실주',7,5900,330,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/댄싱파파.jpg','#달지 않고 깔금','Y')
INTO alcohol values('겨울소주','증류주',25,10000,360,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/겨울소주.jpg','#부드러운 곡물향','N')
INTO alcohol values('경복궁소주','증류주',40,29900,350,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/경복궁소주.jpg','#부드러운 곡물향','N')
INTO alcohol values('고운달오크','증류주',52,180000,350,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/고운달오크.jpg','#부드러운 고도수 술','N')
INTO alcohol values('고운달백자','증류주',52,180000,500,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/고운달백자.jpg','#부드러운 고도수 술','N')
INTO alcohol values('아리아리','증류주',40,53000,500,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/아리아리.jpg','#입안 가득 퍼지는 화사함','N')
INTO alcohol values('박재서 명인 안동소주','증류주',35,7500,360,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/박재서명인안동소주.jpg','#식품명인의 술','N')
INTO alcohol values('두레앙','증류주',35,30000,375,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/두레앙.jpg','#달콤하고 진해요','N')
INTO alcohol values('성산포소주','증류주',25,8500,360,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/성산포소주.jpg','#해산물과 잘 어울려요','N')
INTO alcohol values('미르','증류주',54,35000,360,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/미르.jpg','#쌀 소주 끝판왕','N')
INTO alcohol values('허니문와인','와인',10,35000,375,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/허니문와인.jpg','#산뜻한 단맛','N')
INTO alcohol values('허니비와인','와인',10,35000,375,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/허니비와인.jpg','#싱그러운 향','N')
INTO alcohol values('금이산 복숭아 와인','와인',12,16000,375,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/금이산복숭아와인.jpg','#복숭아로 만든 와인','N')
INTO alcohol values('추사 애플 와인','와인',12,22000,375,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/추사애플와인.jpg','#사과로 만든 와인','N')
INTO alcohol values('오미로제 결 스파클링 와인 선물 세트','와인',12,200000,500,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/오미로제 결 스파클링 와인 선물 세트.jpg','#한국 와인의 자존심','N')
INTO alcohol values('오미로제 결 스파클링 와인','와인',12,160000,500,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/오미로제 결 스파클링 와인.jpg','#세계최초 오미자 스파클링','N')
INTO alcohol values('길벗 아펠바인 사과와인','와인',7,16000,750,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/길벗아펠바인사과와인.jpg','#레몬주스 마시듯','N')
INTO alcohol values('샤토미소 퀸 아이스 와인','와인',9,22000,750,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/샤토미소 퀸 아이스 와인.jpg','#갓 딴 사과의 싱그러움','N')
INTO alcohol values('고도리 화이트 와인','와인',10,20000,750,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/고도리 화이트 와인.jpg','#거봉으로 만든 와인','N')
INTO alcohol values('배꽃 필 무렵','탁주',9,50000,140,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/배꽃필무렵.jpg','#떠먹는 막걸리','N')
INTO alcohol values('담은','탁주',6,33000,750,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/담은.jpg','#카페라떼처럼 부드러운','N')
INTO alcohol values('나루 생 막걸리','탁주',6,21000,550,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/나루 생 막걸리.jpg','#시원한 참외향','N')
INTO alcohol values('복순도가 손 막걸리','탁주',10,36000,550,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/복순도가 손 막걸리.jpg','#샴페인 막걸리','N')
INTO alcohol values('백련 미스티 막걸리','탁주',7,4500,375,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/백련 미스티.jpg','#하얀 연꽃이 들어갔어요','N')INTO alcohol values('부자 막걸리','탁주',8,4900,350,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/부자 막걸리.jpg','#구수한 누룩 풍미','N')
INTO alcohol values('벗이랑 버찌','탁주',10,12000,350,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/벗이랑 버찌.jpg','#카레맛 안나요','N')
INTO alcohol values('벗이랑 강황','탁주',10,12000,350,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/벗이랑 강황.jpg','#홍국쌀 버찌 크로스','N')
INTO alcohol values('문삼이공 잣','탁주',9,22000,750,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/문삼이공 잣.jpg','#잣 향 가득','N')
INTO alcohol values('진양주','약주',16,15000,500,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/진양주.jpg','#아몬드의 고소한 풍미','N')
INTO alcohol values('술아 국화주','약주',13,20000,500,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/술아국화주.jpg','#가을에 어울리는 술','N')
INTO alcohol values('면천 두견주','약주',18,52000,700,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/면천두견주.jpg','#고려시대 약주','Y')
INTO alcohol values('천비향 약주','약주',15,32000,700,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/천비향약주.jpg','#연예인도 반한 술','N')
INTO alcohol values('하심당 석탄주','약주',11,20000,375,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/석탄주.jpg','#삼키기 아쉬운 술','N')
INTO alcohol values('니모메','약주',11,11000,375,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/니모메.jpg','#귤피가 들어간 술','N')
INTO alcohol values('우포','약주',12,7000,500,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/우포.png','#깔끔한 단맛','N')
INTO alcohol values('하타','청주',16,20000,500,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/하타.jpg','#백제에서 일본으로','Y')
INTO alcohol values('우렁이쌀 청주','청주',14,16000,500,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/우렁이쌀 청주.jpg','#100년 역사 양조장','N')
INTO alcohol values('삼양춘 청주','청주',15,17500,500,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/삼양춘 청주.jpg','#3번 빚은 술','N')
INTO alcohol values('한청','청주',15,20000,700,sysdate + (INTERVAL'2'YEAR),'상온보관','./img/alcohol/한청.jpg','#새콤달콤한 청주','Y')
SELECT * FROM DUAL;

SELECT * FROM alcohol;

SELECT LEVEL, a.*
FROM alcohol a
START WITH type_name = '과실주'
CONNECT BY type_name = alcohol_name;

SELECT * 
FROM ALCOHOL
WHERE ALCOHOL_PRICE BETWEEN 10000 AND 20000;

CREATE SEQUENCE ALCOHOL_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE SNACK (
SNACK_NAME VARCHAR2(50) PRIMARY KEY,
CATEGORY_NAME VARCHAR2(50),
SNACK_PRICE NUMBER,
SNACK_IMG VARCHAR2(100),
SNACK_DES VARCHAR2(100),
SALE_YN VARCHAR2(10),
EXPDATE DATE,
FOREIGN KEY (CATEGORY_NAME) REFERENCES SNACK_CATEGORY(CATEGORY_NAME)
);

CREATE TABLE SNACK_CATEGORY (
CATEGORY_NAME VARCHAR2(50) PRIMARY KEY
);

INSERT INTO SNACK_CATEGORY VALUES ('국/탕/찌개');
INSERT INTO SNACK_CATEGORY VALUES ('구이/볶음');
INSERT INTO SNACK_CATEGORY VALUES ('마른 안주');
INSERT INTO SNACK_CATEGORY VALUES ('튀김');

SELECT * FROM snack;

DROP TABLE snack;
DROP TABLE SNACK_CATEGORY ;

SELECT * FROM SNACK_CATEGORY;

INSERT ALL
INTO SNACK VALUES('갈비탕','국/탕/찌개',11900,'./img/snack/갈비탕.jpg','#든든하고 푸짐한 한 그릇','Y',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('찹쌀 진순대국','국/탕/찌개',6000,'./img/snack/찹쌀 진순대국.jpg','#얼큰한 국물에 담긴 진한 풍미','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('강릉식 짬뽕 순두부찌개','국/탕/찌개',8900,'./img/snack/강릉식 짬뽕 순두부찌개.jpg','#칼칼한 국물 속 풍성한 해물','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('부산 조방낙지 낙곱새','국/탕/찌개',18300,'./img/snack/부산 조방낙지 낙곱새.jpeg','#집에서 만나는 부산의 별미','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('우거지 갈비탕','국/탕/찌개',9900,'./img/snack/우거지 갈비탕.jpg','#얼큰하게 즐기는 사미헌 갈비탕','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('수제 김치찌개','국/탕/찌개',6500,'./img/snack/수제 김치찌개.jpg','#맛있는 김치찌개를 위한 베이스','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('차돌 된장찌개','국/탕/찌개',7500,'./img/snack/차돌 된장찌개.jpg','#차돌양지가 돋보이는 된장찌개','Y',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('샤브샤브 밀키트','국/탕/찌개',15900,'./img/snack/샤브샤브 밀키트.jpg','#매장의 노하우로 완성','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('송탄식 부대찌개','국/탕/찌개',12900,'./img/snack/송탄식 부대찌개.jpg','#건더기가 푸짐한 부대찌개','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('밀푀유나베','국/탕/찌개',16900,'./img/snack/밀푀유나베.jpg','#꽃처럼 피어나는 전골 요리','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('주꾸미 볶음','구이/볶음',7200,'./img/snack/주꾸미 볶음.jpeg','#입안 가득 톡 쏘는 매콤함','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('민물 양념장어','구이/볶음',28600,'./img/snack/민물 양념장어.jpeg','#집에서 즐기는 든든한 장어구이','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('스테이크 키트','구이/볶음',19800,'./img/snack/스테이크 키트.jpg','#묵직함과 산뜻함의 공존','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('찹스테이크','구이/볶음',15900,'./img/snack/찹스테이크.jpeg','#파인애플이 들어가 달큰한 맛','Y',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('마라샹궈','구이/볶음',7900,'./img/snack/마라샹궈.jpg','#자꾸 당기는 그 매력 그대로','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('치즈 춘천 닭갈비 떡볶이','구이/볶음',13200,'./img/snack/눈꽃치즈 춘천 닭갈비 떡볶이.jpg','#눈꽃치즈를 솔솔 얹어 먹는','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('우삼겹 숙주 볶음','구이/볶음',9900,'./img/snack/우삼겹 숙주 볶음.jpg','#우삼겹과 숙주의 콜라보','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('병천식 순대곱창볶음','구이/볶음',16800,'./img/snack/병천식 순대곱창볶음.jpg','#간편하게 만나는 충천도의 맛','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('스키야키','구이/볶음',17900,'./img/snack/스키야키.jpg','#수란에 찍어 먹는 일품 요리','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('전가복','구이/볶음',19900,'./img/snack/전가복.jpg','#전복과 새우가 들어간','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('매콤한 황태','마른 안주',8900,'./img/snack/매콤한 황태.jpg','#감칠맛을 입은 고소한 황태','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('속살 담은 손질 황태채','마른 안주',12900,'./img/snack/속살 담은 손질 황태채.jpg','#가늘게 찢어 담은 황태','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('바나나칩','마른 안주',8900,'./img/snack/바나나칩.jpg','#바삭바삭 달콤한 과일칩','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('인생 노가리 (마른대구)','마른 안주',5990,'./img/snack/인생 노가리.jpg','#고소하고 담백한 안주','Y',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('칼 맞은 오징어','마른 안주',9800,'./img/snack/칼 맞은 오징어.jpg','#간편히 즐기는 건오징어 몸통','Y',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('반건조 한치','마른 안주',9900,'./img/snack/반건조 한치.jpg','#촉촉하고 쫄깃한 식감','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('리얼 먹태랑 땅콩','마른 안주',4990,'./img/snack/리얼 먹태랑 땅콩.jpg','#부담없이 즐기는 간편 안주','Y',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('삼천포 전통 명엽채','마른 안주',6900,'./img/snack/삼천포 전통 명엽채.jpg','#삼천포에서 갓 잡아온 명엽채','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('오동통 담백한 쥐포','마른 안주',15900,'./img/snack/오동통 담백한 쥐포.jpg','#매실 분말로 맛을 더한','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('동해바다 반건조 오징어','마른 안주',7900,'./img/snack/동해바다 반건조 오징어.jpg','#찬 바람에 쫄깃하게 말린','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('통등심 돈까스','튀김',6100,'./img/snack/간편하게 바삭, 통등심 돈까스.jpg','#씹는 맛이 살아있는 돈까스','Y',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('김말이','튀김',6600,'./img/snack/김말이.jpg','#깻잎의 향긋함이 더해진','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('슈스트링 포테이토 프라이','튀김',4700,'./img/snack/슈스트링 포테이토 프라이.jpg','#바삭하고 짭짤한 감자튀김','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('베이징풍 찹쌀 탕수육','튀김',8900,'./img/snack/베이징풍 찹쌀 탕수육.jpeg','#타피오카 가루의 쫀득한 튀김옷','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('석관동 모듬 튀김','튀김',4000,'./img/snack/석관동 모듬 튀김.jpg','#소용량 모둠 튀김','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('멘보샤','튀김',12500,'./img/snack/멘보샤.jpeg','#바삭한 식빵과 새우의 풍미','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('닭강정','튀김',14500,'./img/snack/닭강정.jpg','#속초에서 만났던 명물 닭강정','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('에어프라이어 순살 치킨','튀김',16600,'./img/snack/에어프라이어 순살 치킨.jpg','#라이스볼의 크런치식감을 더한','N',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('용가리치킨','튀김',13800,'./img/snack/용가리치킨.jpeg','#다섯 가지 공룡 모양 너겟','Y',sysdate + (INTERVAL'2'MONTH))
INTO SNACK VALUES('치킨너겟','튀김',10700,'./img/snack/치킨너겟.jpeg','#보고 먹는 재미를 한 번에','Y',sysdate + (INTERVAL'2'MONTH))
SELECT * FROM dual;

SELECT * FROM SNACK
WHERE snack_name = ?
;

INSERT INTO snack values('어묵탕','탕/국/찌개','비비고',10000,'/source','어묵탕입니다.');

CREATE TABLE CART (
CART_NUM VARCHAR2(50) PRIMARY KEY,
CNT NUMBER,
TOTAL_PRICE NUMBER,
PRODUCT_NAME VARCHAR2(50),
MEMID varchar2(30),
FOREIGN KEY (MEMID) REFERENCES MEMBER_INFO(MEMID)
);

INSERT INTO cart VALUES ('C-'||cart_seq.nextval, 1, 13000, '갈비탕', 'vanana');
INSERT INTO cart VALUES ('C-'||cart_seq.nextval, 1, 16000, '고흥유자주', 'vanana');

CREATE SEQUENCE cart_seq 
START WITH 1;

DROP SEQUENCE cart_seq;

SELECT * FROM cart1;

INSERT INTO cart2 VALUES ('C-'||cart_seq.nextval, 1, 13000, '갈비탕', 'vanana');
INSERT INTO cart1 VALUES ('C-'||cart_seq.nextval, 1, 13000, '매실원주', 'vanana');
-- INSERT INTO cart1 VALUES ('C-'||cart_seq.nextval, ?,?,?,?)

DROP SEQUENCE cart_seq;


CREATE TABLE PRD_CODE (
PRDNO NUMBER PRIMARY KEY,
TITLE VARCHAR2(50),
VAL VARCHAR2(50),
REFNO NUMBER,
ORDNO NUMBER
);

SELECT * FROM PRD_CODE ;
DROP TABLE PRD_CODE;
CREATE SEQUENCE prdno_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE prdno_seqS START WITH 1000 INCREMENT BY 1;

INSERT ALL
INTO PRD_CODE VALUES(1,'술','술',0,1)
INTO PRD_CODE VALUES(2,'탁주','탁주',1,2)
INTO PRD_CODE VALUES(3,'청주','청주',1,3)
INTO PRD_CODE VALUES(4,'증류주','증류주',1,4)
INTO PRD_CODE VALUES(5,'약주','약주',1,5)
INTO PRD_CODE VALUES(6,'과실주','과실주',1,6)
INTO PRD_CODE VALUES(7,'와인','와인',1,7)
INTO PRD_CODE VALUES(1000,'안주','안주',0,1)
INTO PRD_CODE VALUES(1001,'국/탕/찌개','국/탕/찌개',1000,2)
INTO PRD_CODE VALUES(1002,'구이/볶음','구이/볶음',1000,3)
INTO PRD_CODE VALUES(1003,'마른 안주','마른 안주',1000,4)
INTO PRD_CODE VALUES(1004,'튀김','튀김',1000,5)
SELECT * FROM DUAL;



CREATE TABLE SUB_PRODUCT (
SUB_PRODNUM VARCHAR2(50) PRIMARY KEY,
SNACK_NAME VARCHAR2(50),
ALCOHOL_NAME VARCHAR2(50),
FOREIGN KEY (SNACK_NAME) REFERENCES SNACK(SNACK_NAME),
FOREIGN KEY (ALCOHOL_NAME) REFERENCES ALCOHOL(ALCOHOL_NAME)
);

CREATE TABLE SUB_PAY (
SUB_PAYNUM VARCHAR2(50) PRIMARY KEY,
SUB_PAYDATE DATE,
SUB_PAYARRIVE DATE,
SUB_PAYMETHOD VARCHAR2(30),
MEMID varchar2(30),
SUB_PRODNUM VARCHAR2(50),
FOREIGN KEY (MEMID) REFERENCES MEMBER_INFO(MEMID),
FOREIGN KEY (SUB_PRODNUM) REFERENCES SUB_PRODUCT(SUB_PRODNUM)
);

CREATE TABLE SUB_MEM (
SUB_PAYNUM VARCHAR2(50) PRIMARY KEY,
FOREIGN KEY (SUB_PAYNUM) REFERENCES SUB_PAY(SUB_PAYNUM)
);

CREATE TABLE SUB_DELIVERY (
SUB_DEVNUM VARCHAR2(50) PRIMARY KEY,
SUB_PAYNUM VARCHAR2(50),
FOREIGN KEY (SUB_PAYNUM) REFERENCES SUB_PAY(SUB_PAYNUM)
);


CREATE TABLE ORDERS (
ORDERS_NUM VARCHAR2(50) PRIMARY KEY,
CART_NUM VARCHAR2(50),
ORDERS_DATE DATE,
FOREIGN KEY (CART_NUM) REFERENCES CART(CART_NUM)
);

CREATE TABLE STORE_PAY (
ORDERS_NUM VARCHAR2(50) PRIMARY KEY,
PAY_METHOD VARCHAR2(20),
FOREIGN KEY (ORDERS_NUM) REFERENCES ORDERS(ORDERS_NUM)
);

CREATE TABLE STORE_DELIVERY (
DELIVERY_NUM VARCHAR2(50) PRIMARY KEY,
ORDERS_NUM VARCHAR2(50),
FOREIGN KEY (ORDERS_NUM) REFERENCES ORDERS(ORDERS_NUM)
);



DROP TABLE ALCOHOL; 
DROP TABLE ALCOHOL_TYPE; 
DROP TABLE MEMBER_INFO; 
DROP TABLE SNACK ; 
DROP TABLE SNACK_CATEGORY ;
DROP TABLE CART ; 
DROP TABLE SUB_PRODUCT ; 
DROP TABLE SUB_PAY ; 
DROP TABLE SUB_MEM ; 
DROP TABLE SUB_DELIVERY ; 
DROP TABLE ORDERS ; 
DROP TABLE STORE_PAY ; 
DROP TABLE STORE_DELIVERY ; 
DROP TABLE PRICEFILTER ;
DROP TABLE DEGREEFILTER ;


