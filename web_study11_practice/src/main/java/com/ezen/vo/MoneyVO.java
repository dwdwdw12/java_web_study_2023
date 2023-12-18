package com.ezen.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*create table money_tbl_02(
    custno number(6),
    saleno number(8),
    pcost number(8),
    amount number(4),
    price number(8),
    pcode varchar2(4),
    sdate date,
    primary key(custno, saleno)
);
*/

@Getter @Setter @ToString
public class MoneyVO {
	private int custno;
	private int saleno;
	private int pcost;
	private int amount;
	private int price;
	private String pcode;
	private Date sdate;
}
