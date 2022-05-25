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
select * from member where u_id = ?;

insert into member values ('admin', 'MTIzNA==', '관리자', '010-1234-5678', 'admin@naver.com', 
'1988-01-01', '42709', '대구광역시 달서구 호산동로 112','1층', sysdate ,1000 ,0);
--insert into member values('sohee', '7f861bcee185de001377d79e08af62e94b1e7718e2470e08520c917f8d953602', '임소희', '010-1111-2222', 'sohe@gmail.com',
--'1992-12-31', '인천광역시 서구 신현동 157', sysdate, 1000, 0);
--insert into member values('abc123', '6ca13d52ca70c883e0f0bb101e425a89e8624de51db2d2392593af6a84118090', '김건영', '010-2222-3333', 'abc123@naver.com',
--'2002-05-21', '서울 영등포구 여의도동3', sysdate, 1000, 0);
--insert into member values('tpgud33','f0086e971c46f8ededcb7f56fd1c367d76f3397b3083d80d8c653ba0646dffc8', '조세형' ,'010-3333-4444', 'tp2001@naver.com',
--'2001-06-06', '경기도 광주시 오포읍 176', sysdate, 1000, 0);
--insert into member values('ch8787','732e8b56c59fa260467d647abe91743549f265479ec52ca2439fbccd9e9214fb', '서진이', '010-4444-5555', 'jin8787@naver.com',
--'1997-11-05', '부천시 원미구 소사동 1', sysdate, 1000 ,0);

drop table member;
delete from member ;

commit;
