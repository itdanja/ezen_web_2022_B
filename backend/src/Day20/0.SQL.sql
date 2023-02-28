-- 1. DB 데이터베이스[*여러개의 테이블 저장하는 공간 ] 
drop database if exists boardDb;
create database boardDb;
use boardDb;

-- 2. 테이블 
	-- 1. 회원 
drop table if exists member;
create table member(
	mno		int 		auto_increment primary key ,
    mid		varchar(20) not null unique ,
    mpw		varchar(10) not null ,
    mname	varchar(30) not null ,
    mphone 	varchar(13) not null 
);
	-- 2. 카테고리 
drop table if exists category;
create table category(
	cno		int			auto_increment primary key ,
    cname 	varchar(20)	not null
);
	-- 3. 게시물 
drop table if exists board;
create table board(
	bno			int		auto_increment primary key ,
    btitle		varchar(1000) not null , 
    bcontent	longtext	not null ,		-- 긴글 텍스트 
    bdate		datetime default now() ,	-- insert 시 자동 날짜/시간 대입 
    bview		int default 0 ,				-- 조회수 기본값 0 
    mno_fk 		int , -- 작성자 [ fk ]
    cno_fk		int , -- 카테고리 [ fk ] 
    foreign key( mno_fk ) references member( mno ) on delete set null,	-- fk --> pk	[ pk 삭제시 fk필드는 null ]
    foreign key( cno_fk ) references category( cno ) on delete cascade -- fk --> pk		[ pk 삭제시 fk 필드도 같이 삭제 ]
);
	-- 4. 댓글 
drop table if exists reply;
create table reply(
	rno			int		auto_increment primary key ,
    rcontent	text	not null , 
    rdate		datetime	default now() ,
    rindex		int	,		-- 상위 댓글 [ 0:최상위    1~: 해당 댓글 하위 댓글 ]
    mno_fk		int, 
    bno_fk		int ,
    foreign key( mno_fk ) references member( mno ) on delete set null ,
    foreign key( bno_fk ) references board( bno ) on delete cascade 
);
