package com.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	private static MemberDAO dao;
	private MemberDAO() {
		
	}
	public static MemberDAO getDAO() {
		if (dao == null) {
			dao = new MemberDAO();
		}
		return dao;
	}
	private void getConnection() {
		
		try {
			InputStream in = this.getClass().getResourceAsStream("db.properties");
			Properties p = new Properties();
			p.load(in);
			
			Class.forName(p.getProperty("driver"));
			String db_url = p.getProperty("db_url");
			String db_id = p.getProperty("db_id");
			String db_pw = p.getProperty("db_pw");
			conn = DriverManager.getConnection(db_url, db_id, db_pw);
			System.out.println("연결성공");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	public MemberDTO login(MemberDTO dto) {
		MemberDTO info = null;
		getConnection();
		String sql = "select email, tell, address from web_member where email =? and pw = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getEmail());
			psmt.setString(2, dto.getPw());
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				String email = rs.getString(1);
				String tel = rs.getString(2);
				String address = rs.getString(3);
				info = new MemberDTO(email, tel, address);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return info;
	}
	public void join(MemberDTO dto) {
		try {
			getConnection();
			String sql = "insert into web_member values(?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getEmail());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getTel());
			psmt.setString(4, dto.getAddress());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	public int update(MemberDTO dto) {
		int result = 0;
		getConnection();
		String sql = "update web_member set pw = ?, tell = ?, address = ? where email = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getPw());
			psmt.setString(2, dto.getTel());
			psmt.setString(3, dto.getAddress());
			psmt.setString(4, dto.getEmail());
			
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		return result;
	}


}
