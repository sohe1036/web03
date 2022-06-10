package com.shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.common.JDBCConnection;
import com.shop.common.ReviewVO;

public class ReviewDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql = "";
	int cnt = 0;
	
	public int rewiewCheck(int ono) {		//리뷰작성여부체크
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from review where ono=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ono);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {		//주문번호가 같은게 있다면 리뷰작성 안되게
				cnt = 1;
			}else {
				cnt = 0;
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
			return cnt;
	}
	
	public int addReview(ReviewVO vo) {		//리뷰쓰기
		
		try {
			conn = JDBCConnection.getConnection();
			sql = "insert into review values ((select nvl(max(reno), 0)+1 from review) ,?,?,?,sysdate,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getU_id());
			pstmt.setString(2, vo.getRetitle());
			pstmt.setString(3, vo.getRecontent());
			pstmt.setString(4, vo.getReimg());
			pstmt.setInt(5, vo.getBest());
			pstmt.setInt(6, vo.getGno());
			pstmt.setInt(7, vo.getOno());
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
	
	public ArrayList<ReviewVO> getReviewList(String u_id){
		ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();		//아이디별 리뷰리스트
		
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from review where u_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReviewVO vo = new ReviewVO();
				vo.setReno(rs.getInt("reno"));
				vo.setU_id(rs.getString("u_id"));
				vo.setRetitle(rs.getString("retitle"));
				vo.setRecontent(rs.getString("recontent"));
				vo.setRedate(rs.getString("redate"));
				vo.setReimg(rs.getString("reimg"));
				vo.setBest(rs.getInt("best"));
				vo.setGno(rs.getInt("gno"));
				vo.setOno(rs.getInt("ono"));
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
	
	public ArrayList<ReviewVO> getReviewList(int gno){		//상품별 리뷰목록
		ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();
		
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from review where gno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReviewVO vo = new ReviewVO();
				vo.setReno(rs.getInt("reno"));
				vo.setU_id(rs.getString("u_id"));
				vo.setRetitle(rs.getString("retitle"));
				vo.setRecontent(rs.getString("recontent"));
				vo.setRedate(rs.getString("redate"));
				vo.setReimg(rs.getString("reimg"));
				vo.setBest(rs.getInt("best"));
				vo.setGno(rs.getInt("gno"));
				vo.setOno(rs.getInt("ono"));
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

	public ReviewVO getReview(int gno) {
		ReviewVO review = new ReviewVO();
		
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from review where gno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				review.setReno(rs.getInt("reno"));
				review.setU_id(rs.getString("u_id"));
				review.setRetitle(rs.getString("retitle"));
				review.setRecontent(rs.getString("recontent"));
				review.setRedate(rs.getString("redate"));
				review.setReimg(rs.getString("reimg"));
				review.setBest(rs.getInt("best"));
				review.setGno(rs.getInt("gno"));
				review.setOno(rs.getInt("ono"));
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
		
		return review;
	}
	
	public ReviewVO getReview(String u_id, int reno) {		//아이디별 리뷰상세보기
		ReviewVO review = new ReviewVO();
		
		try {
			conn = JDBCConnection.getConnection();
			sql = "select reno, u_id, retitle, recontent, to_char(redate,'yyyy-MM-dd')as r, reimg, best, gno ,ono from review where reno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				review.setReno(rs.getInt("reno"));
				review.setU_id(rs.getString("u_id"));
				review.setRetitle(rs.getString("retitle"));
				review.setRecontent(rs.getString("recontent"));
				review.setRedate(rs.getString("r"));
				review.setReimg(rs.getString("reimg"));
				review.setBest(rs.getInt("best"));
				review.setGno(rs.getInt("gno"));
				review.setGno(rs.getInt("ono"));
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
		
		return review;
	}
	
	public int editReview(ReviewVO vo) {
		
		try {
			conn = JDBCConnection.getConnection();
			sql = "update review set retitle=?, recontent=?, reimg=?, best=? where reno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getRetitle());
			pstmt.setString(2, vo.getRecontent());
			pstmt.setString(3, vo.getReimg());
			pstmt.setInt(4, vo.getBest());
			pstmt.setInt(5, vo.getReno());
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
