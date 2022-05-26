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

create table Goods ( gno number(20) primary key,       --상품번호
gtype varchar2(50) not null,        --상품분류
gname varchar2(100) not null,       --상품이름
gsize varchar2(50) not null,        --상품사이즈
gcolor varchar2(50) not null,       --상품컬러
gimg varchar2(300) ,            --상품이미지
ginfo varchar2(2000) not null,      --상품정보
price varchar2(100) not null,       --상품가격
pieces number(20) not null);        --상품수량


commit;
