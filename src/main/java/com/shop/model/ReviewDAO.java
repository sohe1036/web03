package com.shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shop.common.JDBCConnection;
import com.shop.common.ReviewVO;

public class ReviewDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql = "";
	int cnt = 0;
	
	public int addReview(ReviewVO vo) {
		
		try {
			conn = JDBCConnection.getConnection();
			sql = "insert into values ((select nvl(max(reno), 0)+1 from review) ,?,?,?,sysdate,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getU_id());
			pstmt.setString(2, vo.getRetitle());
			pstmt.setString(3, vo.getRecontent());
			pstmt.setString(4, vo.getReimg());
			pstmt.setInt(5, vo.getBest());
			pstmt.setInt(6, vo.getGno());
			cnt = pstmt.executeUpdate();
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return cnt;
	}

}
