/* db 생성 */ 
drop database if exists xe;
create database xe;
use xe;

/* 테이블1 */
drop table if exists member_tbl_02;
create table member_tbl_02(
	custno		int(6) not null auto_increment primary key ,
    custname	varchar(20) ,
    phone		varchar(20) ,
    address		varchar(20) ,
    joindate	date , 
    grade		char(1),
    city		char(2)
);
select * from member_tbl_02;
/* -- 샘플 데이터 */
insert into member_tbl_02 values(100001, '김행복', '010-1111-2222', '서울 동대문구 휘경1동', '20151202', 'A', '01');
insert into member_tbl_02 values(100002, '이축복', '010-1111-3333', '서울 동대문구 휘경2동', '20151206', 'B', '01');
insert into member_tbl_02 values(100003, '장믿음', '010-1111-4444', '울릉군 울릉읍 독도1리', '20151001', 'B', '30');
insert into member_tbl_02 values(100004, '최사랑', '010-1111-5555', '울릉군 울릉읍 독도2리', '20151113', 'A', '30');
insert into member_tbl_02 values(100005, '진평화', '010-1111-6666', '제주도 제주시 외나무골', '20151225', 'B', '60');
insert into member_tbl_02 values(100006, '차공단', '010-1111-7777', '제주도 제주시 감나무골', '20151211', 'C', '60');

/* 테이블2 */
drop table if exists money_tbl_02;
create table money_tbl_02(
	custno	int(6)  not null ,
    salenol	int(8)	not null ,
    pcost	int(8),
    amount	int(4),
    price	int(8),
    pcode	varchar(4),
    sdate	date ,
    primary key ( custno , salenol ) /* 2개 이상의 pk 정의 할떄 */
);
select * from money_tbl_02;
/* -- 샘플 데이터 */
insert into money_tbl_02 values(100001, 20160001, 500, 5, 2500, 'A001', '20160101');
insert into money_tbl_02 values(100001, 20160002, 1000, 4, 4000, 'A002', '20160101');
insert into money_tbl_02 values(100001, 20160003, 500, 3, 1500, 'A008', '20160101');
insert into money_tbl_02 values(100002, 20160005, 500, 1, 500, 'A001', '20160103');
insert into money_tbl_02 values(100003, 20160006, 1500, 2, 3000, 'A003', '20160103');
insert into money_tbl_02 values(100004, 20160007, 500, 2, 1000, 'A001', '20160104');
insert into money_tbl_02 values(100004, 20160008, 300, 1, 300, 'A005', '20160104');
insert into money_tbl_02 values(100004, 20160009, 600, 1, 600, 'A006', '20160104');
insert into money_tbl_02 values(100004, 20160010, 3000, 1, 3000, 'A007', '20160106');



/* ---------- 기능 구현 sql ---------- */
-- 1. 마지막 회원번호의 +1 ( max )
select max(custno)+1 from member_tbl_02;
-- 2. 회원등록 
insert into member_tbl_02(custname,phone,address,joindate,grade,city) values(?,?,?,?,?,?);
-- 3. 만약에 등급이 'A' 이면 'VIP ~~  [ IF ]
	-- IF( 조건 , 참 , 거짓 ) as 표시할필드명
    -- IF중첩 : IF(조건 , 참 , IF(조건2 , 참2 , IF(조건3 , 참3 , 거짓 ) ) ) as 표시할필드명 
select 
	custno , custname ,  phone , address ,  joindate ,
    if( grade = 'A' , 'VIP' , if( grade = 'B' , '일반' , '직원' ) ) as g ,
    city 
from member_tbl_02;
-- 3. 회원별 매출 통계
 
	-- 1. 테이블 출력 
	select * from member_tbl_02;	-- 회원번호pk
	select * from money_tbl_02;		-- 회원번호pk , 매출번호 pk
    
	-- 2. 두 테이블의 교집합 
		-- 1. where 이용한 조인하기 
    select * from member_tbl_02 , money_tbl_02 
    where member_tbl_02.custno = money_tbl_02.custno;
		-- 2. 자연조인( natural join) 이용한 조인하기 
    select * from member_tbl_02 natural join money_tbl_02;
		-- 3. 조인( join on ) 이용한 조인하기 
    select * from member_tbl_02 join money_tbl_02 
    on member_tbl_02.custno = money_tbl_02.custno;
		-- 4. 테이블의 별칭사용하기 
    select * from member_tbl_02 m natural join money_tbl_02 mo;
    
    -- 3. 특정 필드만 검색 [ * : 모든필드 ]
    select m.custno , m.custname , m.grade , mo.price 
    from member_tbl_02 m natural join money_tbl_02 mo;
    
    -- 4. 통계/집계	[ 전체집계=그룹 필수x vs 그룹별 집계 = 그룹 필수 ]
    select sum( mo.price ) from member_tbl_02 m natural join money_tbl_02 mo;
    
    -- 5. 중복된 레코드 합치기 [ 그룹하기 ] group by 필드명
    select m.custno , m.custname , m.grade , sum( mo.price ) as psum
    from member_tbl_02 m natural join money_tbl_02 mo
    group by m.custno;

	-- 6. 정렬하기 order by 필드명 asc/desc
    select m.custno , m.custname , m.grade , sum( mo.price ) as psum
    from member_tbl_02 m natural join money_tbl_02 mo
    group by m.custno
    order by psum desc;
    
    -- 7. 출력 조건 
    select 
		m.custno , 
        m.custname , 
        if( m.grade = 'A' , 'VIP' , if( m.grade='B' , '일반','직원') ) as g , 
        sum( mo.price ) as psum
    from member_tbl_02 m natural join money_tbl_02 mo
    group by m.custno
    order by sum( mo.price ) desc;
    














