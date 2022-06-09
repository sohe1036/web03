package com.shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.common.GoodsVO;
import com.shop.common.JDBCConnection;
import com.shop.common.PaymentVO;

public class PaymentDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql = "";
	int cnt = 0;
	
	public GoodsVO callByPay(int gno, int bno) {		//주문하기
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
	
	public int addPayment(PaymentVO vo, int bno) {  //주문정보입력 PamentVO와 bno불러서 결제 처리
		try {
			conn = JDBCConnection.getConnection();
			sql = "insert into payment values(pay_seq.nextval, ?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";		//주문번호는 삭제해도 같은번호 안되게 시퀀스 만들고 시퀀스로 insert
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
	
	public ArrayList<PaymentVO> getPaymentList(){		//관리자용 주문조회
		ArrayList<PaymentVO> list = new ArrayList<PaymentVO>();		//입력된 정보를 배열로 받아
		
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from payment order by ono";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {		//반복문
				PaymentVO payment = new PaymentVO();		//VO선언
				payment.setOno(rs.getInt("ono"));	//rs에서정보가져와 vo에 set
				payment.setPaytype(rs.getString("paytype"));
				payment.setPayno(rs.getString("payno"));
				payment.setMoney(rs.getInt("money"));
				payment.setSdate(rs.getString("sdate"));
				payment.setGno(rs.getInt("gno"));
				payment.setPieces(rs.getInt("pieces"));
				payment.setU_id(rs.getString("u_id"));
				payment.setRname(rs.getString("rname"));
				payment.setTel(rs.getString("tel"));
				payment.setAddr1(rs.getString("addr1"));
				payment.setAddr2(rs.getString("addr2"));
				payment.setPostcode(rs.getString("postcode"));
				payment.setTransno(rs.getString("transno"));
				payment.setTransco(rs.getString("transco"));
				payment.setRstatus(rs.getString("rstatus"));
				payment.setRdate(rs.getString("rdate"));
				payment.setMemo(rs.getString("memo"));
				list.add(payment);			//list에 정보담은 payment더해
			}
			
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs, pstmt, conn);
		}
		
		return list;
	}
	
	public ArrayList<PaymentVO> getPaymentList(String u_id){		//회원용주문조회(매개변수 아이디)
		ArrayList<PaymentVO> list = new ArrayList<PaymentVO>();		//입력된 정보를 배열로 받아
		
		try {
			conn = JDBCConnection.getConnection();
			sql = "select ono,paytype,payno,money,sdate,gno,pieces,u_id,rname,tel,addr1,addr2,postcode,transno,transco,rstatus,to_char(sdate,'RRRR-MM-DD')as r,memo from payment where u_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {		//반복문
				PaymentVO payment = new PaymentVO();		//VO선언
				payment.setOno(rs.getInt("ono"));	//rs에서정보가져와 vo에 set
				payment.setPaytype(rs.getString("paytype"));
				payment.setPayno(rs.getString("payno"));
				payment.setMoney(rs.getInt("money"));
				payment.setSdate(rs.getString("sdate"));
				payment.setGno(rs.getInt("gno"));
				payment.setPieces(rs.getInt("pieces"));
				payment.setU_id(rs.getString("u_id"));
				payment.setRname(rs.getString("rname"));
				payment.setTel(rs.getString("tel"));
				payment.setAddr1(rs.getString("addr1"));
				payment.setAddr2(rs.getString("addr2"));
				payment.setPostcode(rs.getString("postcode"));
				payment.setTransno(rs.getString("transno"));
				payment.setTransco(rs.getString("transco"));
				payment.setRstatus(rs.getString("rstatus"));
				payment.setRdate(rs.getString("r"));
				payment.setMemo(rs.getString("memo"));
				list.add(payment);			//list에 정보담은 payment더해
			}
			
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs, pstmt, conn);
		}
		
		return list;
	}
	
	public PaymentVO getPayment(int ono) {		//결제정보 불러오기(조건 ono)
		PaymentVO payment = new PaymentVO();
		try {
			conn = JDBCConnection.getConnection();
			sql = "select ono,paytype,payno,money,sdate,gno,pieces,u_id,rname,tel,addr1,addr2,postcode,transno,transco,rstatus,to_char(rdate,'RRRR-MM-DD')as r,memo from payment where ono=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ono);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				payment.setOno(rs.getInt("ono"));	//rs에서정보가져와 vo에 set
				payment.setPaytype(rs.getString("paytype"));
				payment.setPayno(rs.getString("payno"));
				payment.setMoney(rs.getInt("money"));
				payment.setSdate(rs.getString("sdate"));
				payment.setGno(rs.getInt("gno"));
				payment.setPieces(rs.getInt("pieces"));
				payment.setU_id(rs.getString("u_id"));
				payment.setRname(rs.getString("rname"));
				payment.setTel(rs.getString("tel"));
				payment.setAddr1(rs.getString("addr1"));
				payment.setAddr2(rs.getString("addr2"));
				payment.setPostcode(rs.getString("postcode"));
				payment.setTransno(rs.getString("transno"));
				payment.setTransco(rs.getString("transco"));
				payment.setRstatus(rs.getString("rstatus"));
				payment.setRdate(rs.getString("r"));
				payment.setMemo(rs.getString("memo"));
			}
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs, pstmt, conn);
		}
		
		return payment;
	}
	
	public int shoppingAssign(PaymentVO vo) {		//관리자 배송지 수정(송장입력) vo불러와서 수정
		try {
			conn = JDBCConnection.getConnection();
			sql="update payment set transno=?, transco=?, rstatus=?, rdate=? where ono=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTransno());
			pstmt.setString(2, vo.getTransco());
			pstmt.setString(3, vo.getRstatus());
			pstmt.setString(4, vo.getRdate());
			pstmt.setInt(5, vo.getOno());
			cnt = pstmt.executeUpdate();
			
		}catch(ClassNotFoundException e) {
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
	
	public int editPayment(PaymentVO vo) {		//회원 배송지 수정 vo불러와서 수정
		try {
			conn = JDBCConnection.getConnection();
			sql="update payment set rname=?, tel=?, addr1=?, addr2=?, postcode=?, memo=? where ono=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getRname());
			pstmt.setString(2, vo.getTel());
			pstmt.setString(3, vo.getAddr1());
			pstmt.setString(4, vo.getAddr2());
			pstmt.setString(5, vo.getPostcode());
			pstmt.setString(6, vo.getMemo());
			pstmt.setInt(7, vo.getOno());
			cnt = pstmt.executeUpdate();
			
		}catch(ClassNotFoundException e) {
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
		
	public int delPayment(int num) {		//ono받아서 삭제할꺼라 vo필요x
		try{
			conn = JDBCConnection.getConnection();
			sql ="delete from payment where ono=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			cnt = pstmt.executeUpdate();
			
		}catch(ClassNotFoundException e) {
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
