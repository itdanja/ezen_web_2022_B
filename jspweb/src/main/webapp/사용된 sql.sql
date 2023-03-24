-- create database jspweb;
use jspweb; -- 없으면 새로 생성하기 
-- 회원테이블
drop table if exists member;
create table member(
	mno		int 		auto_increment primary key , -- 식별번호 
    mid		varchar(30) not null  unique, -- 회원 아이디 [ 공백불가 , 중복불가 ] 	
    mpwd	varchar(20) not null , -- 회원 비밀번호 [ 공백불가 ]
    mimg	longtext , -- 웹서버에 저장된 사진 경로  [ 공백가능 ]
	memail	varchar(100) -- 회원 이메일 [ 공백불가 , 중복불가 ] 
);
-- 친추 테이블 
drop table if exists friend;
create table friend(
	fno int 	auto_increment primary key , -- 식별번호 
    ffrom int  	,	-- 친구 신청한 회원 fk 
    fto int 	,	-- 친구 신청 받은 회원 fk 
    foreign key ( ffrom ) 	references member ( mno ) on delete set null,	
    foreign key ( fto ) 	references member( mno ) on delete set null -- 친구가 탈퇴하면 null 
);
-- 포인트 테이블 
drop table if exists mpoint;
create table mpoint(
	mpno		int 			auto_increment primary key ,	-- 포인트내역 식별번호 
    mpcomment	varchar(1000) not null , 	-- 포인트내역 내용 
    mpamount	int default 0,				-- 포인트 수량 
    mpdate		datetime default now() ,	-- 포인트 내역 날짜 
    mno			int ,						-- 포인트 변경된 회원번호 
    foreign key ( mno ) 	references member ( mno ) on delete set null  -- 탈퇴하면 포인트 null
);
-- 카테고리 테이블[ 카테고리번호 , 카테고리 이름 ( 공지사항 , 커뮤니티 , QnA , 노하우 등등 ) ]
create table category(
	cno		int auto_increment primary key , 
    cname	varchar(100) not null 
);
-- 게시물 테이블 [ 번호 , 제목 , 내용 , 첨부파일 , 작성일 , 조회수 , 좋아요수 , 싫어요수 , 작성자 , 카테고리번호 ]
create table board(
	bno			int auto_increment primary key , 
    btitle 		varchar(1000) not null ,
    bcontent	longtext	not null ,
    bfile		longtext	,
    bdate 		datetime default now() ,
    bview		int default 0 ,
    bup			int default 0 ,
    bdown		int default 0 ,
    mno			int , -- 회원번호 fk
    cno			int , -- 카테고리번호 fk
    foreign key ( mno ) references member( mno ) on delete set null,  	-- [회원]pk가 삭제되면 게시물fk는 null 변경
	foreign key ( cno ) references category( cno ) on delete cascade	-- [카테고리]pk가 삭제되면 게시물 같이 삭제 
);
-- on delete cascade 	: pk가 삭제되면 fk 같이 삭제
-- on delete set null 	: pk가 삭제되면 fk는 null 로 변경 
-- 생략 					: fk에 존재하는 식별키[pk] 는 삭제 불가능 

-- 1. 
insert into category(cname) values( '공지사항');
insert into category(cname) values( '커뮤니티');
insert into category(cname) values( 'QnA');
insert into category(cname) values( '노하우');
select * from category;


-- 댓글 테이블 [ 댓글번호 , 내용 , 작성일 , 인덱스(계층구분) , 작성자 , 게시물번호 ]   
create table reply(
	rno			int auto_increment primary key , 
    rcontent	longtext , 
    rdate		datetime default now(),
    rindex		int default 0 , -- 0 이면 최상위계층 , 1~ 해당 댓글[부모] 의 하위 댓글
    mno			int ,
    bno			int ,
    foreign key( mno ) references member(mno) on delete set null ,
    foreign key( bno ) references board(bno) on delete cascade 
);
/*
	3번 게시물 
		1번 댓글			[ rno = 1 , rindex = 0 ]
			3번 댓글 		[ rno = 3 , rindex = 1 ]
			4번 댓글 		[ rno = 4 , rindex = 1 ]
				6번댓글	[ rno = 6 , rindex = 4 ]
        2번 댓글 			[ rno = 2 , rindex = 0 ]
        5번 댓글 			[ rno = 5 , rindex = 0 ]
*/

/* 제품 테이블 */
drop table if exists product;
create table product(
    pno int auto_increment primary key , -- 제품번호
    pname varchar(500) not null , -- 제품명 
    pcomment text not null ,  -- 제품설명
    pprice bigint not null , -- 제품가격
    pstate int default 1 , -- 상태[ 1:판매중 2:거래중 3:판매완료 등등 ]
    plat varchar(100) not null, -- 위도
    plng varchar(100) not null, -- 경도
    pview int default 0 , -- 조회수
    pdate datetime default now() -- 등록일
);
/* 제품 사진 테이블 */
/* 제품 찜하기 테이블 */
drop table if exists plike;
create table plike(
	plinkno bigint auto_increment primary key, /* 식별키 */
	mno int , /* 회원번호 = 누가 */
    pno int , /* 제품번호 = 어떤제품 찜했는지 */
    foreign key (mno) references member(mno) on delete cascade ,
    foreign key (pno) references product(pno) on delete cascade 
);
/* 제품 쪽지 테이블 */












-- 2. 조인 테스트 

-- 1. 조건[where] 조인[합집합]
drop table ex4;
create table ex4(
	mno int 
);
insert into ex4 values( 1 ) , ( 2 ) , ( 3 ) , ( 4 ) , ( 5 );	-- 5레코드 추가 
select * from ex4;

drop table ex5;
create table ex5(
	mno	int
);
insert into ex5 values( 3 ) , ( 4 ) , ( 5 ) , ( 6 ) , ( 7 );	-- 5레코드 추가 
select * from ex5;
-- ------------------------------------
select * from ex4 , ex5	; -- 25레코드 검색 [ 합 집합 레코드개수 * 레코드개수 ]
select * from ex4 , ex5 where ex4.mno = ex5.mno; -- 3레코드[ 교 집합의  두 레코드의 일치값 [ pk-fk ] ]

select * from ex4 natural join ex5;	-- natural join 자연조인 [ 교집합 ( 암묵적으로 동일한 레코드의 일치값 ) ]
-- board 테이블에는 mno 있다. 원한건 mno[fk] ---> member테이블의 mno[pk] 외 다른 필드에 접근 
select * from member , board; 
	-- 1. where 이용한 조인 [ * 다른 조건과 가독성 떨어짐 ]
    select * from member , board where member.mno = board.mno;
    -- 2. 테이블명 별칭[별명]
    select * from member m , board b where m.mno = b.mno; 
	-- 3. A테이블 natural join B테이블 		:  자연조인 [ * pk와fk 필드가 1개씩 존재하는 테이블에서 자주 사용 ]
    select * from member natural join board;
    -- 4. A테이블 join B테이블 on 조인조건  	:  조인 [ * on 키워드를 사용해서 교집합조건 사용하면 다른 where 구분 ]
    select * from member m join board b on m.mno = b.mno;
-- 결론 
select board.* , member.mid from member natural join board;




------------------------------------ 3/16 페이징처리 / 검색처리 연습 sql ----------------------------------
-- 1. 출력 
select board.* , member.mid from member natural join board;

-- 2. 특정 개수 만 출력 [ 페이징 조건 ] limit 시작인덱스[0~] , 개수 
select b.* , m.mid from member m natural join board b limit 0 , 3; -- 1페이지
select b.* , m.mid from member m natural join board b limit 3 , 3; -- 2페이지
select b.* , m.mid from member m natural join board b limit 6 , 3; -- 3페이지

select b.* , m.mid from member m natural join board b limit ? , ? ;

-- 3. 레코드 수 구하기 count(*)
select count(*) from member m natural join board b;

-- 4. 조건식 [ = 같다 ]
select * from board where btitle = '123123';
-- 4. 조건식 [ like 포함된 패턴검색 ]	필드명 like %데이터%
select * from board where btitle = 'asd';		-- asd인 제목의 레코드 찾기 
select * from board where btitle like '%asd%';	-- asd가 포함된 제목의 레코드 찾기
select * from board where btitle like '_asd_';	-- asd가 2번째 글자에 있는 5글자 제목의 레코드 찾기 
	-- % : 모든 문자 대응 [ 문자개수 무시 ]	/	_ : _개수만큼 대응 [ 문자개수 중요 ]
/*
	1asd2		like '_asd_'	--> true	/	like '%asd%' --> true
    1asd23		like '_asd_'	--> false	/	liket '%asd%' --> true
*/

-- 결론 
	-- 1. 검색이 없을때 레코드수 구하기 
    select count(*) from member m natural join board b;
    -- 2. 검색이 있을때 레코드수 구하기 [ 검색[조건]된 레코드수 ]
    select count(*) from member m natural join board b where b.btitle like '%asd%';
    -- 3. 자바에서 사용할경우
	-- "select count(*) from member m natural join board b where "+key+" like '%"+keyword+"%'" ;

	-- 1. 검색이 없을때 레코드 출력 
		select b.* , m.mid from member m natural join board b order by b.bdate desc limit ? , ? ;
	-- 2. 검색이 있을때 레코드 출력 
		select b.* , m.mid from member m natural join board b where b.btitle like '%asd%' order by b.bdate desc limit 0 , 3 
	-- 3. 자바에서 사용할 경우 
	--	"select b.* , m.mid from member m natural join board b where "+key+" like '%"+keyword+"%' order by b.bdate desc limit ? , ?" 












