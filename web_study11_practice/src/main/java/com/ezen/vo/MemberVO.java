package com.ezen.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*create table member_tbl_02(
    custno number(6) primary key,
    custname varchar2(20),
    phone varchar2(13),
    address varchar2(60),
    joindate date,
    grade char(1),
    city char(2)
);
 * */

@Getter @Setter @ToString
public class MemberVO {
	private int custno;
	private String custname;
	private String phone;
	private String address;
	private Date joindate;
	private String grade;
	private String city;
}
