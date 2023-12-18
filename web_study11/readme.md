#DB생성 및 기본 data 입력

create table board(
    num number(5) primary key,
    pass varchar2(30) not null,
    name varchar2(30) not null,
    email varchar2(30),
    title varchar2(50),
    content varchar2(1000),
    readcount number(4) default 0,
    writedate date default sysdate
);

create sequence board_seq start with 1 increment by 1;

insert into board(num, pass, name, email, title, content) 
    values(board_seq.nextval, '1234', '성윤정', 'pinksung@nate.com', '첫방문', '반갑습니다');

insert into board(num, pass, name, email, title, content) 
    values(board_seq.nextval, '1234', '성윤정', 'pinksung@nate.com', '김밥', '맛있어요');

insert into board(num, pass, name, email, title, content) 
    values(board_seq.nextval, '1234', '전수빈', 'raccon@nate.com', '고등애', '일식입니다');

insert into board(num, pass, name, email, title, content) 
    values(board_seq.nextval, '1234', '전원지', 'one@nate.com', '갯골마을', '돼지삼겹살이 맛있습니다');
     
insert into board(num, pass, name, email, title, content) 
    values(board_seq.nextval, '1234', '홍길동', 'gildong@nate.com', 'test', 'test');

commit;

#커넥션 풀 설정

-server 적용
<Resource name="jdbc/myoracle" auth="Container"
              type="javax.sql.DataSource" driverClassName="oracle.jdbc.OracleDriver"
              url="jdbc:oracle:thin:@127.0.0.1:1521:xe"
              username="scott" password="tiger" maxTotal="20" maxIdle="10"
              maxWaitMillis="-1"/>

factory="org.apache.tomcat.jdbc.pool.DataSourceFactory"
              
-01_dbcp.jsp 적용
	Context initContext = new InitialContext();
	Context envContext  = (Context)initContext.lookup("java:/comp/env");
	DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");		//server.xml에서 <resource>의 name 속성과 같은 값이어야 함
	Connection conn = ds.getConnection();
	System.out.println(conn);