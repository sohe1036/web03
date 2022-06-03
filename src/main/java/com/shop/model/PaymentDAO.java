package com.shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shop.common.GoodsVO;
import com.shop.common.JDBCConnection;
import com.shop.common.PaymentVO;

public class PaymentDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql = "";
	int cnt = 0;
	
	public GoodsVO callByPay(int gno, int bno) {
		GoodsVO goods = new GoodsVO();
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from goods where gno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				goods.setGno(rs.getInt("gno")); 	//rs에서 데이터 받아서 goods에 입력
				goods.setGtype(rs.getString("gtype"));
				goods.setGname(rs.getString("gname"));
				goods.setGsize(rs.getString("gsize"));
				goods.setGcolor(rs.getString("gcolor"));
				goods.setGinfo(rs.getString("ginfo"));
				goods.setGimg(rs.getString("gimg"));
				goods.setPrice(rs.getString("price"));
				goods.setPieces(rs.getInt("pieces"));
			}
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCConnection.close(rs, pstmt, conn);
		}
		return goods;
	}
	
	public int addPayment (PaymentVO vo) {
		
		try {
			conn = JDBCConnection.getConnection();		
			sql ="insert into payment values ((select nvl(max(gno), 0 )+1 from payment),?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPaytype());
			pstmt.setString(2, vo.getPayno());
			pstmt.setInt(3, vo.getMoney());
			pstmt.setInt(4, vo.getGno());
			pstmt.setInt(5, vo.getPieces());
			pstmt.setString(6, vo.getU_id());
			pstmt.setString(7, vo.getRname());
			pstmt.setString(8, vo.getTel());
			pstmt.setString(9, vo.getAddr1());
			pstmt.setString(10, vo.getAddr2());
			pstmt.setString(11, vo.getPostcode());
			pstmt.setString(12, vo.getTransno());
			pstmt.setString(13, vo.getTransco());
			pstmt.setString(14, vo.getRstatus());
			pstmt.setString(15, vo.getRdate());
			pstmt.setString(16, vo.getMemo());
			cnt = pstmt.executeUpdate();
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCConnection.close(pstmt, conn);
		}
		
		return cnt;
	}
}
