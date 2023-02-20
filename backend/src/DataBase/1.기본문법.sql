#한줄 주석
-- 한줄 주석 
/* 여러줄 주석 */

/*
	데이터베이스 : 데이터[자료] , 베이스[모임]
		- 자료들의 모임 
	- 종류
		1. 계층형 데이터 베이스 		: 트리형태
        2. 네트워크형 데이터베이스 	: 양방향 형태
        3. *관계형 데이터베이스		: 열/행 로 구성된 테이블[표] 간의 관계
        4. NoSQL 데이터베이스 		: key-value
	- DBMS : 데이터베이스 관리 시스템 
		MYSQL , oracle , access , mssql 
	- DBA : 데이터베이스 관리자 
		DB개발자 
        
		DB[ DB server ] <-------- DBMS <------------- 	DBA
		- DB가 설치된 PC			- DB 관리 시스템			- SQL[ 질의어 ] 
        - 데이터를 저장				- DB 서버에 접속
        - 메모리[ 기계어/16진수]		- 표준 SQL 사용
        
	 예)
		DBA[ 표 만들어줘 ] -------> DBMS[ 표만들어줘 ---> 기계어] ---> DB [ 표 만들기 성공 ]
									메모리1 메모리2					메모리1
									메모리3 메모리4 				메모리2
																메모리3
																메모리4
                                                                
	- SQL 질의어 [ 대소문자 구분 X ] 
		1. DDL : 데이터베이스 정의 어 
			1. CREATE TABLE/DATABASE 이름;	: 테이블/데이터베이스 생성 
                create database 데이터베이스명; 
                use 데이터베이스명;
                create table 테이블명( 필드명 타입 제약조건 , 필드명 타입 제약조건  );
            2. DROP TABLE/DATABASE 이름;		: 테이블/데이터베이스 삭제
				drop database 테이터베이스명;
                
            3. ALTER						: 수정 
            4. TRUNCATE						: 테이블 데이터 영구 삭제 
        2. DML : 데이터베이스 조작 어 
			1. SELECT						: 데이터 검색  
            2. INSERT						: 데이터 추가 
            3. UPDATE 						: 데이터 수정 
            4. DELETE 						: 데이터 삭제 
        3. DCL : 데이터베이스 제어 어
			1. GRANT						: 사용자 계정 권한부여
            2. REVOKE						: 사용자 계정 권한취소
        4. TCL : 트랜잭션 제어 어 
			1. COMMIT						: 트랜잭션 완료
            2. ROLLBACK						: 트랜잭션 취소 
            
	- 테이블 [ 표 = 열[필드/속성] 행[레코드]  ]
		* 여러개의 자료들을 효율적으로 관리하기 위해서 관계형데이터베이스[표]
				
                -필드1[열1 - colum]	 -필드2[열1 - colum]
				아이디				비밀번호 
				qwe					qwe					- 레코드1[행1 - row]
                asd					asd					- 레코드2[행2]
                zxc					zcx					- 레코드3[행3]
	- 필드 타입 
		1. 정수형 : int				: 정수 
        2. 문자형 : varchar(길이) 		: 길이 만큼 문자열 저장가능 
        3. 실수형	: float , double 	: 실수 
        4. 날짜형 : data , time , datatime
        5. 대용량 : text
*/					

# 예1 : 데이터베이스 생성 [ 저장소 - 여러개 테이블 저장할수 있는 공간 ]
create database test;
# create : 생성한다.
	# database : 데이터베이스 생성한다.
		# test : 데이터베이스이름 [ 아무거나 ]
			# ; : 명령어 마침 
				# ctrl+엔터 : 커서 위치에 있는 ; 단위 명령어 실행
				# 새로고침
create database test2;
create database test3;
create database java;
# 예2 : 데이터베이스 목록 보기  
show databases;
# 예3 : 데이터베이스 사용[선택] 하기	[ * 데이터베이스가 여러개 이므로 선택 ]
use test;
use test2;
use test3;
use java;
# 예4 : 데이터베이스 삭제 
drop database test;
drop database test2;
drop database test3;
drop database java;

# 예5 : 테이블 생성 [ * 데이터베이스 선택 ]
create database java;		-- 1. 데이터베이스 생성 
use java;					-- 2. 데이터베이스 선택
create table member(		-- 3. 선택된 데이터베이스의 표 만들기 
	아이디 text ,
    비밀번호 text 
);
# create : 생성하다	table : 테이블 	member : 테이블명[아무거나] 
#  create table 테이블명( 필드명 타입 제약조건 , 필드명2 타입 제약조건 );
create table member2( 아이디 text , 비밀번호 text );
create table member3( 아이디 text , 비밀번호 text );

# 예6 : 해당 테이블 검색 
select * from member;
# select : 검색[선택] 	* : 와일드카드[모든필드]	 	from 테이블명
# select 필드명 from 테이블명;
select * from member2;
select * from member3;

# 예7 : 해당 테이블 삭제 
drop table member;
drop table member2;
drop table member3;
drop database java;

/* 
	문제1 : 웹개발 하는데 DB저장소[스키마] 'JSP' 이름으로 생성 
		1. 테이블 2개 [ 'member' , 'board' ] 생성
        2. member 테이블의 필드 구성 
			id(문자열) , password(문자열) 
		2. board 테이블의 필드 구성 
			title(문자열) , content(문자열)
*/ 
create database jsp;
use jsp;
create table member( id varchar(100) , password varchar(100) );
create table board( title varchar(100) , content varchar(100) );
select * from member;
select * from board;
drop database jsp;	-- 데이터베이스 삭제시 안에 있던 테이블도 같이 삭제 

/*
	문제2 : 
		1. 'spring' 데이터베이스 생성 / 선택 
        2. 'member' 테이블 생성 
			 회원번호[정수] , id[최대 20글자 ] , passowrd[최대 20글자] 
        3. 'product' 테이블 생성 
			 제품번호[정수] , name[최대 30글자] , price[정수] 
		4. 생성한 테이블 2개 검색[확인]
        5. 데이터베이스 삭제 
*/
create database spring;
use spring;
create table member( mno int , id varchar(20) , password varchar(20) );
create table product( pno int , name varchar(20) , price int );
select * from member;
select * from product;
drop database spring;

# DML
create database java;
use java;
create table 게시판( 제목 varchar(20) , 내용 varchar(20 ) );

# 예1) insert # insert into 테이블명 values( 데이터1 , 데이터2 );
	# 필드명이 명시되어 있지 않기 때문에 선언된 필드 순서대로 데이터가 삽입 
insert into 게시판 values( '제목구역' , '내용구역' );
	# 확인
select * from 게시판;

# 예2) insert # insert into 테이블명 ( 필드명1 , 필드명2 ) values( 데이터1 , 데이터2 );
	# 필드명이 명시되어 있기 때문에 명시된 필드순으로 데이터를 삽입 
insert into 게시판 (  내용 , 제목 ) values(  '내용구역2' , '제목내용2' );
	# 확인
select * from 게시판;

# 예3) insert 에 매개변수 형식 [ JDBC 사용할 예정 ]
	# ? : 변수가 들어가는 자리를 뜻 함 
insert into 게시판( 제목 , 내용 ) value( ? , ? ); -- 여기서는 실행 안됨.. JAVA에서 추후에 하자 

drop database java;
/*
	문제3 : 
		1. 'jsp' 라는 이름으로 데이터베이스 생성/선택  
        2. 'member' 라는 이름으로 테이블 생성 
			회원번호[정수] , 아이디 [20] , 비밀번호[20] 
		3. 회원가입 2명 하기 
			1	,	이젠 	,	1234
            2	,	삼성		, 	4567
		4. 테이블 확인 
        5. 데이터베이스 삭제 
*/
create database jsp;
use jsp;
create table member( mno int , mid varchar(20) , mpw varchar(20) );
insert into member( mno , mid , mpw ) values( 1 , '이젠' , '1234');
insert into member values( 2 , '삼성' , '4567');
insert into member( mid ) values( 'LG');
select * from member;	-- 레코드 생성시 해당 필드의 데이터 생략시 null 대입 
drop database jsp;
/*
	문제4
		1. 'spring' 이라는 이름으로 데이터베이스 생성 
        2. 'product' 이라는 이름으로 테이블 생성 
			제품번호[정수] , 제품명[20글자내]	, 가격[정수] 
		3. 제품 등록 3개 [ 레코드 3개 ] 추가 
			1 , '냉장고' , 200000
            2 , '선풍기' , 300000
			null , '컴퓨터' , null 
		4. 테이블 확인 
        5. 데이터베이스 삭제 
    
*/







