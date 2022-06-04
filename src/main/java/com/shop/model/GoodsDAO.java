package com.shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.common.GoodsVO;
import com.shop.common.JDBCConnection;

public class GoodsDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql = "";
	int cnt = 0;
	
	public ArrayList<GoodsVO> getGoodsList() {			//상품 리스트보기
		ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();		//상품이 여러개니 배열에 담아
		
		try {
			conn = JDBCConnection.getConnection();		//getConnection() 메서드 호출
			sql = "select * from goods order by gno";				//DB에서 상품리스트 select 
			pstmt = conn.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {				//rs있을 떄
				GoodsVO goods = new GoodsVO();		//VO연결
				
				goods.setGno(rs.getInt("gno"));		//rs에서 gno받아와서 goods에 set
				goods.setGtype(rs.getString("gtype"));
				goods.setGname(rs.getString("gname"));
				goods.setGsize(rs.getString("gsize"));
				goods.setGsize2(rs.getString("gsize2"));
				goods.setGcolor(rs.getString("gcolor"));
				goods.setGinfo(rs.getString("ginfo"));
				goods.setGimg(rs.getString("gimg"));
				goods.setPrice(rs.getInt("price"));
				goods.setPieces(rs.getInt("pieces"));
				list.add(goods);		//값을 담아서 list에 더해
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
	
	
	public ArrayList<GoodsVO> getGoodsList(String gtype) {			//상품 gtype를 매개변수로 리스트보기
		ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();		
		
		try {
			conn = JDBCConnection.getConnection();		//getConnection() 메서드 호출
			sql = "select * from goods where gtype=? order by gno";				//DB에서 상품리스트 select 
			pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1, gtype);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {				//rs있을 떄
				GoodsVO goods = new GoodsVO();		//VO연결
				
				goods.setGno(rs.getInt("gno"));		//rs에서 gno받아와서 goods에 set
				goods.setGtype(rs.getString("gtype"));
				goods.setGname(rs.getString("gname"));
				goods.setGsize(rs.getString("gsize"));
				goods.setGsize2(rs.getString("gsize2"));
				goods.setGcolor(rs.getString("gcolor"));
				goods.setGinfo(rs.getString("ginfo"));
				goods.setGimg(rs.getString("gimg"));
				goods.setPrice(rs.getInt("price"));
				goods.setPieces(rs.getInt("pieces"));
				list.add(goods);		//값을 담아서 list에 더해
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
	
	public ArrayList<GoodsVO> getGoodsList(String gtype, String gsize) {			//상품 gtype,gsize를 매개변수로 리스트보기
		ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();		
		
		try {
			conn = JDBCConnection.getConnection();		//getConnection() 메서드 호출
			sql = "select * from goods where gtype=? and gsize=? ";				//DB에서 상품리스트 select 
			pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1, gtype);
			pstmt.setString(2, gsize);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {				//rs있을 떄
				GoodsVO goods = new GoodsVO();		//VO연결
				
				goods.setGno(rs.getInt("gno"));		//rs에서 gno받아와서 goods에 set
				goods.setGtype(rs.getString("gtype"));
				goods.setGname(rs.getString("gname"));
				goods.setGsize(rs.getString("gsize"));
				goods.setGsize2(rs.getString("gsize2"));
				goods.setGcolor(rs.getString("gcolor"));
				goods.setGinfo(rs.getString("ginfo"));
				goods.setGimg(rs.getString("gimg"));
				goods.setPrice(rs.getInt("price"));
				goods.setPieces(rs.getInt("pieces"));
				list.add(goods);		//값을 담아서 list에 더해
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
	
	public GoodsVO getGoods(int gno) {		//상품 상세보기 상품번호로 조회할거라 매개변수는 gno
		GoodsVO goods = new GoodsVO();		//VO객체생성 
		
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from goods where gno=?";		//조건:상품번호로 조회
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {		//rs에 데이터있다면 goods에 데이터 넣어줘
				goods.setGno(rs.getInt("gno")); 	//rs에서 데이터 받아서 goods에 입력
				goods.setGtype(rs.getString("gtype"));
				goods.setGname(rs.getString("gname"));
				goods.setGsize(rs.getString("gsize"));
				goods.setGsize2(rs.getString("gsize2"));
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
	
	public int countGoods(int gno) {		//상품 구매후 남은 수량 조회 다른정보없이 gno만 필요
		int num = 0;
		
		try {
			conn = JDBCConnection.getConnection();
			sql = "select pieces from goods where gno=?";		//상품번호로 수량만 조회
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt("pieces");		//num에 rs의 수량 데이터를 가져와
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
		
		return num;
	}
	
	public int addGoods(GoodsVO vo) {		//상품추가  리턴값이 cnt라 int, GoodsVO에서 정보 가져올거라 매개변수 vo
		
		try {
			conn = JDBCConnection.getConnection();
			sql = "insert into goods values ((select nvl(max(gno), 0 )+1 from goods) ,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1, vo.getGtype());	
			pstmt.setString(2, vo.getGname());
			pstmt.setString(3, vo.getGsize());
			pstmt.setString(4, vo.getGcolor());
			pstmt.setString(5, vo.getGimg());
			pstmt.setString(6, vo.getGinfo());
			pstmt.setInt(7, vo.getPieces());
			pstmt.setString(8, vo.getGsize2());
			pstmt.setInt(9, vo.getPrice());
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
	
	public int editGoods(GoodsVO vo) {			//상품 수정하기 vo에서 정보 받을거라 매개변수 vo
		
		try {
			conn = JDBCConnection.getConnection();
			if(vo.getGimg()!=null) {		//이미지 수정할 값이 있으면
				sql = "update goods set gtype=?, gname=?, gsize=?, gcolor=?, gimg=?, ginfo=?, price=?, pieces=?, gsize2=? where gno=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getGtype());
				pstmt.setString(2, vo.getGname());
				pstmt.setString(3, vo.getGsize());
				pstmt.setString(4, vo.getGcolor());
				pstmt.setString(5, vo.getGimg());
				pstmt.setString(6, vo.getGinfo());
				pstmt.setInt(7, vo.getPrice());
				pstmt.setInt(8, vo.getPieces());
				pstmt.setString(9, vo.getGsize2());
				pstmt.setInt(10, vo.getGno());
			} else {		//이미지 수정할 값이 없으면
				sql = "update goods set gtype=?, gname=?, gsize=?, gcolor=?, ginfo=?, price=?, pieces=?, gsize2=? where gno=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getGtype());
				pstmt.setString(2, vo.getGname());
				pstmt.setString(3, vo.getGsize());
				pstmt.setString(4, vo.getGcolor());
				pstmt.setString(5, vo.getGinfo());
				pstmt.setInt(6, vo.getPrice());
				pstmt.setInt(7, vo.getPieces());
				pstmt.setString(8, vo.getGsize2());
				pstmt.setInt(9, vo.getGno());
			}
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
	
public int editGoods(int gno, int num) {			//구매 후 상품수량 업데이트 (매개변수 상품번호,수량)
		
		try {
			conn = JDBCConnection.getConnection();
			sql = "update goods set pieces=? where gno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);		//수량을 변수 num에 저장했음
			pstmt.setInt(2, gno);
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
	
	public int delGoods(int gno) {		//상품 삭제하기 vo에서 가져올 필요없음
		
		try {
			conn = JDBCConnection.getConnection();
			sql = "delete from goods where gno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gno);
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
