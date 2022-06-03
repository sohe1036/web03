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
				goods.setPrice(rs.getInt("price"));
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
	
	public int addPayment(PaymentVO vo, int bno) {  //PamentVO와 bno불러서 결제 처리
		try {
			conn = JDBCConnection.getConnection();
			sql = "insert into payment values((select nvl(max(ono), 0)+1 from payment), ?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPaytype()); //o
			pstmt.setString(2, vo.getPayno());	//o
			pstmt.setInt(3, vo.getMoney());	//o
			pstmt.setInt(4, vo.getGno()); //o
			pstmt.setInt(5, vo.getPieces()); //o
			pstmt.setString(6, vo.getU_id()); //o
			pstmt.setString(7, vo.getRname()); //o
			pstmt.setString(8, vo.getTel()); //o
			pstmt.setString(9, vo.getAddr1()); //o
			pstmt.setString(10, vo.getAddr2()); //o
			pstmt.setString(11, vo.getPostcode()); //o
			pstmt.setString(12, vo.getTransno()); // null
			pstmt.setString(13, vo.getTransco()); // null
			pstmt.setString(14, vo.getRstatus()); // null
			pstmt.setString(15, vo.getRdate()); // null
			pstmt.setString(16, vo.getMemo()); //o
			cnt = pstmt.executeUpdate();
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(pstmt, conn);
		}
		return cnt;
	}
}
