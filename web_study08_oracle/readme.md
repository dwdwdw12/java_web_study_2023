create table member(
    name varchar2(20),
    userid varchar2(10),
    pwd varchar2(10),
    email varchar2(20),
    phone char(13),
    admin number(1) default 0,   --0: 사용자, 1: 관리자
    primary key(userid)
);

insert into member values('testName1','test1','test1','test1@test.com','010-111-2222',0);

insert into member values('testName2','test2','test2','test2@test.com','010-222-2222',1);

insert into member values('testName3','test3','test3','test3@test.com','010-333-2222',0);