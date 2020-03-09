1. 회원가입한 정보를 저장할 수 있는 'web_member'테이블을 만드시오.
   컬럼명 : email / pw / tel / address 커맨드 alt+x

   create table web_member (
   email varchar2(100),
   pw varchar2(100),
   tell varchar2(100),
   address varchar2(200)
   )
   create table web_message(
	num number,
	send_name varchar2(100),
	receive_email varchar2(100),
	content varchar2(1000),
	day date
	);
create sequence num
	start with 1 increment by 1
insert into web_message values(num.nextval, '박병관', 'ehdtlr8612@gmail.com', '공유가 갇히면 공유폴더입니다.', sysdate);
insert into web_message values(num.nextval, '최소희', 'ehdtlr8612@gmail.com', '쓰으으으으오올올올올', sysdate);



insert into WEB_MEMBER values('1234','1234','1234','1234');

select * from web_member;







