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

-- 1. 아이디 중복체크 [ 해당 아이디 검색 ] 
	-- 검색후 레코드가 존재하면 이미 존재하는 아이디 / 레코드가 없으면 존재하지 않는 아이디 
select * from member;	-- 모든 회원 검색 
select * from member where mid = 'qwe'; -- 특정 회원아이디가 일치하는 회원 검색 
-- 2. 회원가입 
insert into member( mid , mpw , mname , mphone ) 
values( 'qwe' , 'qwe' ,'유재석','010-4444-4444');
-- 3. 로그인 
	-- 검색한 결과의 레코드가 존재하면 로그인성공 / 결과 레코드가 존재하지 않으면 로그인 실패 
select * from member where mid = 'qwe' and mpw ='qwe'; -- 아이디와 비밀번호가 일치한 회원 레코드 찾기 

-- 4.  카테고리 등록 
insert into category( cname ) values( '국내야구');
-- 5. 모든 카테고리 출력 
select * from category;

-- 6. 게시물 등록 	[ 1번회원이 1번 카테고리에 글 쓰기 ]
insert into board( btitle , bcontent , mno_fk , cno_fk  ) values(  '제목' ,'내용', 1 , 1 );

-- 6. 최신 게시물 3개 출력 
select * from board; -- 모든 게시물 출력 
select * from board order by bdate desc; -- 작성일 기준 최근 날짜로 정렬 [ DESC : 현재->과거순  ASC:과거->현재 ]
select * from board order by bdate desc limit 3;	-- 위에서 3개  [ 최신글 3개 ]

	-- mno --> mid   / cno --> cname  [ join ]
    -- 1. 필요한 테이블 확인 board, member , category 
    -- 2. 필요한 테이블 모두 검색 
    select * from board , member , category;	
		-- 테이블[레코드수] * 테이블[레코드수] * 테이블[레코드수]
	-- 3. 연결 테이블간 pk-fk 가 일치한 레코드 검색 
		-- 테이블 2개 join 
		select * from board , member ;	-- 결과 : 레코드2개 
        select * from board , member where board.mno_fk = member.mno ; -- 결과 : 레코드1개 
        select * from board , member , category;
        -- 테이블 3개 join 
			-- 테이블에 별칭 미사용 
			select * from board , member , category 
			where board.mno_fk = member.mno and board.cno_fk = category.cno;
            
			-- 테이블에 별칭 사용 
			select * from board b , member m , category c 
			where b.mno_fk = m.mno and b.cno_fk = c.cno;
		
			-- 필요한 필드 추출 
            select b.bno , b.btitle , b.bcontent , b.bdate , b.bview , m.mid , c.cname
            from board b , member m , category c 
            where b.mno_fk = m.mno and b.cno_fk = c.cno;
            
            -- 
			select b.bno , b.btitle , b.bcontent , b.bdate , b.bview , m.mid , c.cname
			from board b , member m , category c 
			where b.mno_fk = m.mno and b.cno_fk = c.cno 
			order by b.bdate desc limit 3;
        
-- 6. 해당 카테고리의 모든 게시물 출력  [ 1번 카테고리[국내야구] 게시물 들 ]
select * from board where cno_fk = 1;
	--
    select b.bno , b.btitle , b.bcontent , b.bdate , b.bview , m.mid , c.cname
	from board b , member m , category c 
	where b.mno_fk = m.mno and b.cno_fk = c.cno 
    and b.cno_fk = 1;

-- 6. 게시물 조회	[ 1번 게시물 ]
select * from board where bno = 1;



