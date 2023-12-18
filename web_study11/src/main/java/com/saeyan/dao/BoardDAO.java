package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.BoardVO;
import com.saeyan.util.DBManager;

public class BoardDAO {
	
	private static BoardDAO instance = new BoardDAO();
	
	private BoardDAO(){};
	
	public static BoardDAO getInstance() {
		return instance;
	}

	public List<BoardVO> selectAllBoards() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo = null;
		String sql = "select * from board order by num desc";
		DBManager dbManager = new DBManager();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = dbManager.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				
				list.add(vo);
	 		}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.close(conn, ps, rs);
		}
		
		return list;
	}
	
	public BoardVO selectOneByNum(int num) {
		BoardVO vo = new BoardVO();
		
		String sql = "select * from board where num=?";
		DBManager dbManager = new DBManager();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = dbManager.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				vo.setNum(rs.getInt("num"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setWritedate(rs.getTimestamp("writedate"));
	 		}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.close(conn, ps, rs);
		}
		
		return vo;
	}
	
	//등록
	public int insertBoard(BoardVO vo) {
		int result = 0;
		
		String sql = "insert into board(num, pass, name, email, title, content) "
				+ "values(board_seq.nextval,?,?,?,?,?)";
		DBManager dbManager = new DBManager();
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = dbManager.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getPass());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getEmail());
			ps.setString(4, vo.getTitle());
			ps.setString(5, vo.getContent());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.close(conn, ps);
		}
		
		return result;
	}

	public int updateBoard(BoardVO vo) {
		int result = -1;
		
		String sql = "update board set pass=?, name=?, email=?, title=?, content=? where num=?";
		DBManager dbManager = new DBManager();
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = dbManager.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getPass());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getEmail());
			ps.setString(4, vo.getTitle());
			ps.setString(5, vo.getContent());
			ps.setInt(6, vo.getNum());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.close(conn, ps);
		}
		
		return result;
	}

	public int deleteBoard(int num) {
		int result = -1;
		
		String sql = "delete from board where num=?";
		DBManager dbManager = new DBManager();
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = dbManager.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.close(conn, ps);
		}
		
		return result;
	}

	public void updateReadcount(int num) {

		String sql = "update board set readcount = readcount+1 where num=?";
		DBManager dbManager = new DBManager();
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = dbManager.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.close(conn, ps);
		}
		
	}
	
	
}
