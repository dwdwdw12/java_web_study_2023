package com.saeyan.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
//DB 입력 데이터와 정보
public class MemberVO {

	private String name;	
	private String userId;	
	private String pwd;	
	private String email;	
	private String phone;	
	private int admin;	
	
}
