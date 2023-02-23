/*
	- SQL
		DDL
			create
				create database DB명;
                create table 테이블명( 필드명1 타입 제약조건 );
            drop
				drop database DB명;
                drop database if exists DB명;
                drop table 테이블명;
                drop table if exists 테이블명;
        DML
        DCL
	
    - 타입 [ DBMS 회사마다 다름 ]
		1. 정수형
			tinyint 
            smallint
            int 
            bigint
		2. 문자형 
			char(길이)		: 고정길이
            varchar(길이) 	: 가변길이
		3. 대용량[ 긴글 , 첨부파일]
			text			
            longtext
		4. 실수형
			float
            double
		5. 날짜형
			date
            time
            datetime
    - 제약조건 
    
*/
-- 1. DB 생성 
drop database if exists market;
create database market; 
use market;
-- 2. 테이블 생성 
drop table if exists member;
create table member(
	-- 필드 선언 
		-- 필드명은 테이블앞글자_필드명
	mid char(8) not null primary key ,
		-- char(길이) : 길이만큼 문자 저장 [최대 길이만큼 ]
        -- not null : 공백 저장 불가능 [ 만일 공백이면 저장 실패 ]
        -- primary key : (기본키)식별키 [ 필드내 중복불가능,공백불가능 ]
			-- 주민등록번호,학번,회원번호,사번,제품번호 등
	mname varchar(10) not null ,
		-- varchar(길이) : 가변길이 [ 데이터의 길이가 일정하지 않을때 ] 
		-- 가변길이 : 저장된 데이터 만큼 메모리 할당
			-- varchar(8) 에서 'ABC' 저장시 5칸 메모리 자동 제거 
        -- 고정길이 : 선언된 길이 만큼 메모리 할당 
			-- char(8) 에서 'ABC' 저장시 8칸 메모리 고정 [ 3칸:ABC , 5칸:빈공간 ]
	mnumber int not null ,
		-- int : 정수 +-20억 정도 저장가능
	maddr char(2) not null ,	-- 주소 최대 2글자 저장 [ 공백 불가능 ] 
    mphone1 char(3) ,	-- 국번 최대 3글자 저장 [ 공백 가능 ]
    mphone2 char(8) , 	-- 전화번호 최대 8글자 저장 [ 공백 가능 ]
    mheight smallint ,
		-- smallint : +-3만정도 저장가능 
	mdebut date
		-- date : 날짜
);
select * from member;
-- 예제 레코드 추가 
INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '061', '99999999', 165, '2014.06.19');
select * from member;


