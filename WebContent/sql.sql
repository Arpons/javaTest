1. ȸ�������� ������ ������ �� �ִ� 'web_member'���̺��� ����ÿ�.
   �÷��� : email / pw / tel / address Ŀ�ǵ� alt+x

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
insert into web_message values(num.nextval, '�ں���', 'ehdtlr8612@gmail.com', '������ ������ ���������Դϴ�.', sysdate);
insert into web_message values(num.nextval, '�ּ���', 'ehdtlr8612@gmail.com', '�������������ÿÿÿ�', sysdate);



insert into WEB_MEMBER values('1234','1234','1234','1234');

select * from web_member;







