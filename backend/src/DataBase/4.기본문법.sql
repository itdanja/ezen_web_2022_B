/*
	메모리
		주기억장치 :  RAM	휘발성	전기O저장O	- 현재 실행중인 명령어 저장
			- JVM , 게임중 , 
        보조기억장치 : ROM 비휘발성	전기X저장O	- 모든 명령어 저장
			- DB , 파일 , C드라이브 , CD , USB , 게임설치 등
            
	데이터베이스
		1. 데이터[자료] 베이스[모임 ] -> 표 -> 관계형[열/행] 데이터베이스 
		2. [워드,엑셀,한글] 마우스 표 제작 vs [데이터베이스] 대화식[명령어] 표 제작 
        3. SQL 질의어 
	
    표 제작 
    
*/

-- 1. DB 생성 / 선택 
drop database if exists 관계테이블연습;
create database 관계테이블연습;
use 관계테이블연습;

drop table if exists 회원;
create table 회원( 회원번호 int primary key , 아이디 varchar(20) , 비밀번호 varchar(10) );

drop table if exists 제품;
create table 제품( 제품번호 int primary key , 제품이름 varchar(20) , 제품가격 int );

drop table if exists 구매내역;
create table 구매내역( 
	구매번호 int primary key , 
	구매일자 datetime ,  
    회원번호_fk int ,
    제품번호_fk int ,
    foreign key( 회원번호_fk ) references 회원( 회원번호 ) ,
    foreign key( 제품번호_fk ) references 제품( 제품번호 )
);

-- 예1)
-- 저장 
	-- 제품명
    -- 제품설명 
	-- 카테고리
    -- 가격
    -- 주문번호
    -- 주문한 제품
	-- 주문 일시 
    -- 주문 상태 
    
-- 콜드브루라떼  , 부드러운 ~~ , 콜드브루 , 3000 , 1 , 콜드브루라떼 , 02/24 / 주문
-- 콜드브루라떼  , 부드러운 ~~ , 콜드브루 , 3000 , 2 , 콜드브루라떼 , 02/25 / 주문
-- 달고나콜드브루  , 부드러운 ~~ , 콜드브루 , 4500 , 3 , 달고나콜드브루 , 02/25 / 주문

-- 카테고리 테이블  -- 카테고리번호[pk] , 카테고리명
drop table if exists category;
create table category( cno int auto_increment primary key , cname varchar(10) not null unique );
-- 제품 테이블 -- 제품번호[pk] , 제품명 , 제품설명 , 가격 , 카테고리( 카테고리번호(FK) )
drop table if exists product;
create table product( 
	pno int auto_increment primary key , 
    pname varchar(10) not null unique , 
    pcomment text  not null  , 
    pprice smallint  not null  , 
	cno_fk int ,
    foreign key( cno_fk ) references category( cno  ) on delete cascade on update cascade -- pk 삭제/수성시 fk 같이 삭제 
);
-- 주문 테이블  	-- 주문번호[pk] , 주문한 제품(제품번호[fk]) , 주문 일시 , 주문 상태
drop table if exists porder;
create table porder(
	pono int auto_increment primary key ,
    podate datetime default now() , 
    postate tinyint default 1  ,
    pno_fk int ,
    foreign key( pno_fk ) references product( pno ) on delete set null on update set null -- pk 삭제/수정시 fk null 만들기 
);

	-- 1. 카테고리 등록 
	insert into category (cname ) values( '콜드브루');	-- cno pk -> 1 
    insert into category (cname ) values( '커피');	-- cno pk -> 2 
select * from category;
	-- 2. 제품 등록 
	insert into product ( pname , pcomment , pprice , cno_fk ) values( '콜드브루라떼' , '맛있는~~' , 3000 , 1 );-- pno pk -> 1 
    insert into product ( pname , pcomment , pprice , cno_fk ) values( '오곡콜드브루' , '맛있는~~' , 4500 , 1 );-- pno pk -> 2
    insert into product ( pname , pcomment , pprice , cno_fk ) values( '꿀커피' , '맛있는~~' , 2000 , 2 );-- pno pk -> 3 
select * from product;
	-- 3. 주문 등록 
    insert into porder ( pno_fk ) values( 2 );	-- 오곡콜드브루 주문	-- pono pk -> 1 
    insert into porder ( pno_fk ) values( 3 );	-- 꿀커피 주문 		-- pono pk -> 2 
    insert into porder ( pno_fk ) values( 2 );	-- 오곡콜드브루 주문	-- pono pk -> 3
select * from porder;




    



















    











