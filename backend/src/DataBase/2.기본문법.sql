/*

	사람[개발자]:DBA					DBMS						컴퓨터[ DB ] 
		언어 : 영어,한글(문자)											기계어 : 0 , 1 

		표 만들어줘					create table 회원();
        create table 회원();			  위 문법을 기계어 번역 ------->  메모리 할당
        
	- SQL 질의어 
		1. DDL
			- create
				create database DB명;		// DB생성
                
                create table 테이블명( 		// 테이블 생성 
					필드명 타입 제약조건 , 
                    필드명 타입 제약조건 
				);
                
            - drop
				drop database db명;			// DB 삭제 
                drop table 테이블명;			// 테이블 삭제 
                
            alter
            truncate
        2. DML
			- insert
				모든 필드에 데이터 추가할경우 : insert into 테이블명 values( 데이터1 , 데이터2 ) ;
                특정 필드에 데이터 추가할경우 : insert into 테이블명( 필드명1, 필드명2 ) values( 데이터1 , 데이터2 );
            - select
				테이블의 모든 필드 검색 : select * from 테이블명;
                테이블의 특정 필드 검색 : select 필드명 , 필드명 from 테이블명;
                테이블의 조건 검색 : select * from 테이블명 where 조건 
            - update
				모든 레코드에 대한 수정 : update 테이블명 set 필드명1 = 새로운값 , 필드명2 = 새로운값
                특정 레코드에 대한 수정 : update 테이블명 set 필드명1 = 새로운값 , 필드명2 = 새로운값 where 조건 
            - delete
				모든 레코드 삭제 : delete from 테이블명
				특정 레코드 삭제 : delete from 테이블명 where 조건 
			* 절 
				where 절 
                
        3. DCL
			grant
			revoke
        4. TCL 
			commit
            rollback
		+ 그외
			use DB명;		// 해당 DB 선택/사용 
            
	- 데이터 타입 
		정수형 : TINYINT , SMALLINT , INT , BIGINT
        실수형 : FLOAT , DOUBLE
        문자형 : CHAR(길이) : 고정길이 , VARCHAR(길이) : 가변길이
        날짜형 : DATE , TIME , DATETIME
		대용량 : TEXT , LONGTEXT , BLOB , LONGBLOB

*/
drop database java; /* 컨트롤+엔터 : 해당 커서의 명령어 실행 */
-- 1. db 생성 
create database java;
-- 2. db 사용/선택
use java;
-- 3. 테이블 생성 
create table member( 
	mno int auto_increment primary key  , 
		-- auto_increment : 자동번호 부여 [ * pk 같이 사용  ]
        -- primary key : 식별용도 [ * 중복x , 공백null x ]
    mid varchar(20)  , 
    mpw varchar(20) ,
    mname varchar(10) ,
    mphone varchar(13)	-- 마지막은 , 안함 
);
-- 4. 회원가입 1명 [ 'qwe' , 'qwe' , '유재석' , '010-4444-4444' ]
insert into member( mid , mpw , mname , mphone ) values( 'qwe' ,'qwe','유재석' ,'010-4444-4444'); 
									-- JAVA에서는 values( ? , ? , ? , ? ); 로 작성 
-- 5. 테이블 확인  [ 모든 필드 검색 ]
select * from member;
-- 6. 회원가입 1명추가 [ 'asd' , 'asd' ,'강호동' , '010-5555-5555' ]
insert into member( mid , mpw , mname , mphone ) values( 'asd' , 'asd' , '강호동' , '010-5555-5555');

-- 7. 로그인 하기 , 아이디와 비밀번호가 일치한지  [ 'asd' , 'zxc' ]
select * from member where mid = 'asd' and mpw ='zxc';
				-- 조건 where절 필드명 = 찾을값		: 해당 필드의 값이 찾을값과 같으면 true 
                -- 조건 and 조건  , 조건 or 조건 	: 
                -- 검색된 결과[레코드-행] 가 존재하면 로그인성공 , 없으면 실패  
-- 8. 로그인 하기 , 아이디와 비밀번호가 일치한지  [ 'qwe' , 'qwe' ]
select * from member where mid = 'qwe' and mpw ='qwe';
-- 9. 특정 회원의 모든 정보 호출 [ 회원번호 : 3 , 2  ]
select * from member where mno = 3;	-- 3번 회원의 레코드[행] 확인 -> 없다 
select * from member where mno = 2;	-- 2번 회원의 레코드[행] 확인 
-- 10. 특정 회원의 비밀번호 변경 [ 2번회원의 비밀번호 'zxc' 변경 ]
update member set mpw = 'zxc';	-- 모든 회원의 비밀번호를 'zxc'
update member set mpw = 'zxc' where mno = 2;	-- mno 2번인 레코드의 비밀번호를 'zxc' 변경 
-- 11. 특정 회원의 탈퇴
delete from member;	-- 모든 회원 탈퇴
delete from member where mno = 2;	-- mno 2번인 레코드의 삭제 



















