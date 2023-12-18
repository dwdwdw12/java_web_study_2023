package com.magic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.magic.dto.EmployeesVO;

public class EmployeesDAO {
	
	private EmployeesDAO() {}
	
	public static EmployeesDAO eDao = new EmployeesDAO();
	
	public static EmployeesDAO getInstance() {
		return eDao;
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");		
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public int userCheck(String id, String pass, String lev) {
		int result = 0;
		String sql = "select pass, lev from employees where id = ?";
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("pass").equals(pass)&&rs.getString("lev").equals(lev)) {
					result = 1;
				} else {
					result = 0;
				}
			} else {
				result = -1;
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
	
	public EmployeesVO getMember(String id) {
		EmployeesVO vo = new EmployeesVO();
		String sql = "select * from employees where id = ?";
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {				
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setLev(rs.getString("lev"));
				vo.setEnter(rs.getString("enter"));
				vo.setGender(rs.getString("gender"));
				vo.setPhone(rs.getString("phone"));
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
	
	public int updateMember(EmployeesVO vo) {
		int result = 0;
		
		String sql = "update employees set pass=?, name=?, lev = ?, gender=?, phone=? where id = ?";
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getPass());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getLev());
			ps.setString(4, vo.getGender());
			ps.setString(5, vo.getPhone());
			ps.setString(6, vo.getId());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public int insertMember(EmployeesVO vo) {
		int result = 0;
		
		String sql = "insert into employees(id, pass, name, lev, gender, phone) values(?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPass());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getLev());
			ps.setString(5, vo.getGender());
			ps.setString(6, vo.getPhone());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { 
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}	
}
