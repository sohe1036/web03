create table question(
qno number(30) primary key,
qtitle varchar2(100) not null,
qcontent varchar2(800) not null,
qdate date,
u_id varchar2(40),
ano number(30),
acontent varchar2(800),
adate date);
CREATE SEQUENCE seq_question START WITH 1 INCREMENT BY 1;
insert into question(qno, qtitle, qcontent, qdate,u_id) values (seq_question.nextval,'질문제목1','첫번째 질문 내용입니다.',sysdate,'abc123');

desc question;
commit;
create table board (seq number(20) primary key,
title varchar2(100) not null,
content varchar2(1000) not null,
name varchar2(40) not null,
regdate date not null,
show number(20) default 0);

select * from board;
select * from board where seq=?;

insert into board values (1, '샘플용 title 1', '샘플 content 1', '관리자', sysdate, 0);
insert into board values ((select nvl(max(seq), 0)+1 from board), '샘플용 title 2', '샘플 content 2', '관리자', sysdate, 0);
insert into board values ((select nvl(max(seq), 0)+1 from board), '샘플용 title 3', '샘플 content 3', '관리자', sysdate, 0);
insert into board values ((select nvl(max(seq), 0)+1 from board), '샘플용 title 4', '샘플 content 4', '관리자', sysdate, 0);
insert into board values ((select nvl(max(seq), 0)+1 from board), '샘플용 title 5', '샘플 content 5', '관리자', sysdate, 0);

update board set title=?, content=?, name=? where seq=?;
delete from board where seq=?;

create table member (u_id varchar2(40) primary key,
u_pw varchar2(300) not null,
name varchar2(40) not null,
tell varchar2(20) not null,
email varchar2(100) not null,
birth date,
postcode varchar2(20),
addr1 varchar2(200) not null,
addr2 varchar2(200) not null,
regdate date not null,
point number(20) default 1000,
visited number(20) default 0);

select * from member;
select substr(u_id,1,length(u_id)-3)||lpad('*',3,'*')as id,u_pw from member;
select u_id, u_pw, to_date(birth,'YYYY-MM-DD')as b from member where u_id='abc123';
select * from member where u_id = ?;

insert into member values ('admin', 'MTIzNA==', '관리자', '010-1234-5678', 'admin@naver.com', 
'1988-01-01', '42709', '대구광역시 달서구 호산동로 112','1층', sysdate ,1000 ,0);

drop table member;
delete from member ;

create table goods ( gno number(20) primary key,       --상품번호
gtype varchar2(50) not null,        --상품분류
gname varchar2(100) not null,       --상품이름
gsize varchar2(50) not null,        --상품사이즈
gcolor varchar2(50) not null,       --상품컬러
gimg varchar2(300) ,            --상품이미지
ginfo varchar2(2000) not null,      --상품정보
price varchar2(100) not null,       --상품가격
pieces number(20) not null);        --상품수량
---------------------
alter table goods add gsize2 varchar2(50);
update goods set gsize='대형', gsize2='76CM' where gno=1; 
update goods set gsize='중형', gsize2='67CM' where gno=2; 
update goods set gsize='소형', gsize2='55CM' where gno=3; 
update goods set gsize='대형', gsize2='73CM' where gno=4; 
update goods set gsize='대형', gsize2='73CM' where gno=5;
update goods set gsize='대형', gsize2='75CM' where gno=6;
update goods set gsize='대형', gsize2='79CM' where gno=7;
update goods set gsize='중형', gsize2='69CM' where gno=8;
update goods set gsize='대형', gsize2='76CM' where gno=10;

alter table goods drop column price;
alter table goods add price number(20);
update goods set price='199000' where gno=1;
update goods set price='149000' where gno=2;
update goods set price='179000' where gno=3;
update goods set price='339000' where gno=4;
update goods set price='339000' where gno=5;
update goods set price='188000' where gno=6;
update goods set price='209000' where gno=7;
update goods set price='189000' where gno=8;
update goods set price='99000' where gno=9;
update goods set price='69000' where gno=10;
update goods set price='10000' where gno=11;
update goods set price='99000' where gno=13;
update goods set price='69000' where gno=14;
update goods set price='198000' where gno=15;
update goods set price='148000' where gno=16;
update goods set price='148000' where gno=17;
alter table goods modify price number(20) not null;
--------------------
desc goods;
select * from goods;
select * from goods where gtype='luggage' and gsize='대형';
insert into goods values((select nvl(max(gno), 0 )+1 from goods), '캐리어', 'UP TO THE SKY','76CM','TITANIUM','./img/carry1.jpg',
'제품소재: PC
용량: 89L
크기: 76.0 x 52.0 x 29.0cm','199,000원','50');
insert into goods values((select nvl(max(gno), 0 )+1 from goods), '캐리어', 'UP TO THE SKY','67CM','TITANIUM','./img/carry1.jpg',
'제품소재: PC
용량: 60L
크기: 67.0 x 46.0 x 26.0cm','149,000원','50');
insert into goods values((select nvl(max(gno), 0 )+1 from goods), '캐리어', 'UP TO THE SKY','55CM','TITANIUM','./img/carry1_1.jpg',
'제품소재: PC
용량: 32L
크기: 55.0 x 40.0 x 20.0cm','179,000원','50');
insert into goods values((select nvl(max(gno), 0 )+1 from goods), '캐리어', 'CURIO','73CM','BLACK','./img/carry2.jpg',
'제품소재: PC
용량: 76L
크기: 73.0 x 43.0 x 37.0cm
무게: 4.7kg','339,000원','50');
insert into goods values((select nvl(max(gno), 0 )+1 from goods), '캐리어', 'CURIO','73CM','CREAM','./img/carry2_1.jpg',
'제품소재: PC
용량: 76L
크기: 73.0 x 43.0 x 37.0cm
무게: 4.7kg', '339,000원','50');
insert into goods values((select nvl(max(gno), 0 )+1 from goods), '캐리어', 'HOUSTON CITY','75CM','BLACK','./img/carry3.jpg',
'제품소재: HS ABS (VACUUM)
용량: 91L
크기: 75.0 x 52.0 x 31.0cm
무게: 4.4kg','188,000원','50');
insert into goods values((select nvl(max(gno), 0 )+1 from goods), '캐리어', 'HYGGE','79CM','BROWN','./img/carry4.jpg',
'제품소재: PC
크기: 79.0 x 52.0 x 33.0cm
확장형: 37.0cm
무게: 4.6kg','209,000원','50');
insert into goods values((select nvl(max(gno), 0 )+1 from goods), '캐리어', 'HYGGE','69CM','BROWN','./img/carry4_1.jpg',
'제품소재: PC
크기: 69.0 x 47.0 x 28.0cm
확장형: 32.0cm
무게: 3.8kg','189,000원','50');

select * from goods;
select * from goods order by gno;



create table basket (bno number(20) primary key,       --장바구니 번호
gname varchar2(100) ,       --장바구니 상품명
gno number(20) ,            --상품번호
gsize varchar2(50),        --상품사이즈
gcolor varchar2(50) ,       --상품컬러
price varchar2(100) ,       --상품가격
pieces number(20) ,         --상품수량
u_id varchar2(300) );       --구매자아이디

alter table basket drop column price;
alter table basket add price number(20);
select * from basket;
drop table basket;

create table payment(ono number primary key, -- 결제번호
    paytype varchar2(20),   -- 결제방식
    payno varchar2(30),     -- 결제카드번호
    money number,           -- 결제금액
    sdate date,             -- 결제일
    gno number,             -- 상품코드
    pieces number,          -- 수량
    u_id varchar2(20),    -- 사용자아이디
	rname varchar2(30),     -- 수신자명
    tel varchar2(20),       -- 수신자전화번호
    addr1 varchar2(200),    -- 수신자 기본주소
    addr2 varchar2(100),    -- 수신자 상세주소
    postcode varchar2(10),  -- 수신자 우편번호
    transno varchar2(50),   -- 배송코드
    transco varchar2(50),   -- 배송회사
    rstatus varchar2(20),   -- 수신상태
    rdate date,             -- 도착일
	memo varchar2(100)     -- 메모
);
select * from payment;
drop table payment;
delete from payment;


CREATE TABLE db_access (
  no number primary key,
  request_uri varchar(100),
  query_string varchar(200),
  remote_address varchar(30),
  server_name varchar(60),
  server_port varchar(10),
  locale varchar(20),
  browser varchar(200),
  referer varchar(255),
  session_id varchar(80),
  user_id varchar(20),
  response_time number,
  reg_date date default sysdate
);

select * from db_access;

CREATE TABLE review(
reno number(20) primary key,
u_id varchar2(40) not null,
retitle varchar2(100) not null,
recontent varchar(1000) not null,
redate date default sysdate,
reimg varchar2(300),
best number,
gno number(20) not null
);
select * from review;
drop table review;
commit;

alter table review add ono number;
create sequence scott.pay_seq increment by 1 start with 1 minvalue 1 maxvalue 100000 nocycle nocache;
select* from mem;
drop table mem;
create table mem (u_id varchar2(40) primary key,
u_pw varchar2(300) not null,
name varchar2(40) not null,
tell varchar2(20) not null,
email varchar2(100) not null,
birth date,
regdate date not null,
point number(20) default 1000,
visited number(20) default 0);

create table databank (
    datano number primary key,
    dtitle varchar2(255) not null,
    dcontent varchar2(1000),
    dposter varchar2(255),
    dfilename varchar2(255),
    dview char(1) default 'Y',
    regdate date default sysdate
);
