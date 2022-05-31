package com.shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.common.BasketVO;
import com.shop.common.BesketDetailVO;
import com.shop.common.JDBCConnection;

public class BasketDAO {
	
	private Connection conn = null;			//지역변수 선언
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql = "";
	int cnt = 0;
	
	public ArrayList<BasketVO> getBasketList(String u_id) {		//장바구니 목록보기 ->본인 아이디장바구니만 볼 수 있으므로 매개변수 u_id
		ArrayList<BasketVO> list = new ArrayList<BasketVO>();	//여러 데이터를 배열에 담아 리턴할 것이므로 배열객체 생성
		
		try {
			conn = JDBCConnection.getConnection();		//JDBCConnection 메서드 호출
			sql = "select * from basket where u_id=?";	//sql문 조건:u_id
			pstmt = conn.prepareStatement(sql);		
			pstmt.setString(1, u_id);
			rs = pstmt.executeQuery();			//select문
			
			while (rs.next()) {		//반복문으로 rs의 데이터를 호출해 vo에 담은 후  배열에 더할 것
				BasketVO vo = new BasketVO();		//VO 객체생성
				
				vo.setBno(rs.getInt("bno"));
				vo.setGname(rs.getString("gname"));
				vo.setGsize(rs.getString("gsize"));
				vo.setGcolor(rs.getString("gcolor"));
				vo.setGno(rs.getInt("gno"));
				vo.setPrice(rs.getString("price"));
				vo.setPieces(rs.getInt("pieces"));
				vo.setU_id(rs.getString("u_id"));
				list.add(vo);
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
		
		return list;
	}

	public BesketDetailVO getBasket(int bno) {		//장바구니 상세목록 ->장바구니 번호를 받아와 열기(매개변수 bno),VO의 정보 받아서 리턴할것
		
		BesketDetailVO basket = new BesketDetailVO();			//VO객체 생성해서 정보 입력해줄 것
		try {
			conn = JDBCConnection.getConnection();		//메서드 호출
			sql = "select a.bno, a.gname, a.gsize, a.gcolor, a.gno, a.price, a.pieces, a.u_id, b.gtype, b.gimg, b.ginfo from basket a inner join goods b on a.gno=b.gno where bno=?";			//조건:bno ,이너조인,알리어스 사용
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {				//rs값이 있다면 파라미터로 값 받아와서 basket에 정보입력
			basket.setBno(rs.getInt("bno"));	//rs에서 bno값 받아와서 basket에 입력
			basket.setGname(rs.getString("gname"));
			basket.setGsize(rs.getString("gsize"));
			basket.setGcolor(rs.getString("gcolor"));
			basket.setGno(rs.getInt("gno"));
			basket.setPrice(rs.getString("price"));
			basket.setPieces(rs.getInt("pieces"));
			basket.setU_id(rs.getString("u_id"));
			basket.setGtype(rs.getString("gtype"));
			basket.setGimg(rs.getString("gimg"));
			basket.setGinfo(rs.getString("ginfo"));
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
	
		return basket;
	}
	
	public int editBasket(BasketVO vo) {		//장바구니 수정하기 -> vo 값 받아와서 수정할것 (매개변수 vo)
		try {
			conn = JDBCConnection.getConnection();
			sql = "update basket get pieces=? gsize=?, gcolor=? where bno=?";			//조건:bno
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPieces());
			pstmt.setString(2, vo.getGsize());		//vo에서 gsize 값 받아와서 수정
			pstmt.setString(3, vo.getGcolor());
			pstmt.setInt(4, vo.getBno());
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
	
	public int delBasket(int bno) {		//장바구니 삭제 -> bno값 받아와서 삭제, 삭제할거라 vo값 받아올 필요 없음
		
		try {
			conn = JDBCConnection.getConnection();
			sql = "delete from basket where bno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
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
	
	public int addBasket(BasketVO vo) {		//장바구니 넣기 -> vo정보를 불러와 추가할 것(매개변수 vo)
		
		try {
			conn = JDBCConnection.getConnection();
			sql = "insert into basket values((select nvl(max(bno), 0)+1 from basket),?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getGname());
			pstmt.setInt(2, vo.getGno());
			pstmt.setString(3, vo.getGsize());
			pstmt.setString(4, vo.getGcolor());
			pstmt.setString(5, vo.getPrice());
			pstmt.setInt(6, vo.getPieces());
			pstmt.setString(7, vo.getU_id());
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

