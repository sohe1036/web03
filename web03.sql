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


desc goods;

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


create table basket (bno number(20) primary key,       --장바구니 번호
bname varchar2(100) not null,       --장바구니 상품명
bsize varchar2(50) not null,        --장바구니 상품사이즈
bcolor varchar2(50) not null,       --장바구니 상품컬러
bimg varchar2(300),                 --장바구니 상품이미지
price varchar2(100) not null,       --장바구니 상품가격
pieces number(20) not null,         --장바구니 상품수량
u_id varchar2(300) not null);       --장바구니 구매자아이디

commit;
