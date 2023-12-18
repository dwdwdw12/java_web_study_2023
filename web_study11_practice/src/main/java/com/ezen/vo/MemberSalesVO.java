package com.ezen.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class MemberSalesVO {
	private int custno;
	private String custname;
	private String grade;
	private int sum;
}
