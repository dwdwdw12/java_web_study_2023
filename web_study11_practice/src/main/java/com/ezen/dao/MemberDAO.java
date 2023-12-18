package com.ezen.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ezen.util.DBManager;
import com.ezen.vo.MemberSalesVO;
import com.ezen.vo.MemberVO;
import com.ezen.vo.MoneyVO;


public class MemberDAO {
	
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO(){};
	
	public static MemberDAO getInstance() {
		return instance;
	}

	public List<MemberVO> selectAllMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO vo = null;
		String sql = "select * from member_tbl_02";
		DBManager dbManager = new DBManager();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = dbManager.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				vo = new MemberVO();
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setJoindate(rs.getDate("joindate"));
				vo.setGrade(rs.getString("grade"));
				vo.setCity(rs.getString("city"));
				
				list.add(vo);
	 		}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.close(conn, ps, rs);
		}
		
		return list;
	}
	
	public MemberVO selectOneByCustno(int custno) {
		MemberVO vo = null;
		
		String sql = "select * from member_tbl_02 where custno=?";
		DBManager dbManager = new DBManager();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = dbManager.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, custno);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				vo = new MemberVO();
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setJoindate(rs.getDate("joindate"));
				vo.setGrade(rs.getString("grade"));
				vo.setCity(rs.getString("city"));
	 		}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.close(conn, ps, rs);
		}
		
		return vo;
	}
	
	public int updateMember(MemberVO vo) {
		int result = -1;
		
		String sql = "update member_tbl_02 set custname=?, phone=?, address=?, grade=?, city=? where custno=?";
		DBManager dbManager = new DBManager();
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = dbManager.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getCustname());
			ps.setString(2, vo.getPhone());
			ps.setString(3, vo.getAddress());
			ps.setString(4, vo.getGrade());
			ps.setString(5, vo.getCity());
			ps.setInt(6, vo.getCustno());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.close(conn, ps);
		}
		
		return result;
	}
	
	public int insertMember(MemberVO vo) {
		int result = 0;
		
		String sql = "insert into member_tbl_02(custno, custname, phone, address, joindate, grade, city) "
				+ "values(?,?,?,?,?,?,?)";
		DBManager dbManager = new DBManager();
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = dbManager.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, vo.getCustno());
			ps.setString(2, vo.getCustname());
			ps.setString(3, vo.getPhone());
			ps.setString(4, vo.getAddress());
			ps.setDate(5, vo.getJoindate());
			ps.setString(6, vo.getGrade());
			ps.setString(7, vo.getCity());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.close(conn, ps);
		}
		
		return result;
	}
	
	public int GetNewCustno() {
		int newCustno=0;
		String sql = "select max(custno) from member_tbl_02";
		
		DBManager dbManager = new DBManager();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = dbManager.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				newCustno = Integer.parseInt(rs.getString(1))+1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.close(conn, ps, rs);
		}
		
		return newCustno;
	}
	
	public Date GetNewJoindate() {
		Date newJoindate = null;
		String sql = "select sysdate from dual";
		
		DBManager dbManager = new DBManager();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = dbManager.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				newJoindate = rs.getDate(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.close(conn, ps, rs);
		}
		
		return newJoindate;
	}

	public List<MemberSalesVO> memberSales() {
		List<MemberSalesVO> list = new ArrayList<MemberSalesVO>();
		MemberSalesVO vo = null;
		String sql = "select a.custno, max(b.custname), max(b.grade), sum(a.price) from money_tbl_02 a inner join member_tbl_02 b on a.custno = b.custno group by a.custno order by sum(price) desc";
		/*sql  = "SELECT mb.custno, mb.custname, mb.grade, sum(mn.price) as total ";
         sql += "FROM member_tbl_02 mb,  money_tbl_02 mn ";
         sql += "where mb.custno = mn.custno ";
         sql += "group by (mb.custno, mb.custname, mb.grade) ";
         sql += "order by total desc"
		 * */
		DBManager dbManager = new DBManager();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = dbManager.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				vo = new MemberSalesVO();
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString(2));
				vo.setGrade(rs.getString(3));
				vo.setSum(rs.getInt(4));
				
				list.add(vo);
	 		}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.close(conn, ps, rs);
		}
		
		return list;
	}
	
	
}
