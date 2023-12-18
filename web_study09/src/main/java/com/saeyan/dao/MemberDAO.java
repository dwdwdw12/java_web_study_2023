package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.saeyan.dto.MemberVO;

//DB 접속, 연동
public class MemberDAO {
	
	public MemberDAO() {
	}

	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception {
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		Connection conn = ds.getConnection();
		return conn;
	}
	
	//로그인 성공 여부
	public int userCheck(String userId, String pwd) {
		
		String sql = "select pwd from member where userId = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = -1;
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("pwd").equals(pwd)) {
					return 1;
				} else {	//pwd x
					return 0;
				}
			} else {	//id x
				return -1;
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	//특정 userId 일치하느 모든 데이터 vo 읽기
	public MemberVO getMember(String userId) {
		
		String sql = "select * from member where userId = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberVO vo = null;
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				vo = new MemberVO();
				vo.setName(rs.getString("name"));
				vo.setUserId(rs.getString("userId"));
				vo.setEmail(rs.getString("email"));
				vo.setPwd(rs.getString("pwd"));
				vo.setPhone(rs.getString("phone"));
				vo.setAdmin(rs.getInt("admin"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return vo;
	}
	
	//userId 중복체크
	public int confirmID(String userId) {
		return 0;	
	}
	
	//데이터 insert
	public void insertMember(MemberVO vo) {
		
	}
	
	//데이터 update
	public void updateMember(MemberVO vo) {
		
	}
	
}
