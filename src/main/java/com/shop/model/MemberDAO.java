package com.shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import com.shop.common.JDBCConnection;
import com.shop.common.MemberVO;

public class MemberDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql = "";
	int cnt = 0;			//초기화
	
	public ArrayList<MemberVO> getMemberList() {		//반환자, 메서드- 고객목록
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();		//MemberVO를 배열에 담아 
		
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();		//vo변수에 rs안의 정보 가져와서 set
				vo.setU_id(rs.getString("u_id"));
				vo.setU_pw(rs.getString("u_pw"));
				vo.setName(rs.getString("name"));
				vo.setTell(rs.getString("tell"));
				vo.setEmail(rs.getString("email"));
				vo.setBirth(rs.getString("birth"));
				vo.setPostcode(rs.getString("postcode"));
				vo.setAddr1(rs.getString("addr1"));
				vo.setAddr2(rs.getString("addr2"));
				vo.setRegdate(rs.getDate("regdate"));
				vo.setPoint(rs.getInt("point"));
				vo.setVisited(rs.getInt("visited"));
				list.add(vo);		//list에 vo를 더해
			}
			
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("SQL 처리 실패");
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("잘못된 요청입니다.");
			e.printStackTrace();
		}finally {
			JDBCConnection.close(rs, pstmt, conn);
		}
		return list;
	}
	
	public MemberVO getMember(String uid) {	//반환자, 메서드(매개변수) - 고객정보 상세보기(로그인 되어있는 상태)
		byte[] pwc;			//데이터가 바이트배열
		MemberVO member = new MemberVO();		//상세정보 담을 곳
		
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from member where u_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member.setU_id(rs.getString("u_id"));
				pwc = Base64.getDecoder().decode(rs.getString("u_pw")); //rs에저장된 비밀번호를 디코팅(바이트배열)
				String upw = new String(pwc); //디코딩된 데이터배열데이터 pwc를 String으로 
				member.setU_pw(upw);		//member에 디코딩된 String타입의 비밀번호 set
				member.setName(rs.getString("name"));
				member.setTell(rs.getString("tell"));
				member.setEmail(rs.getString("email"));
				member.setBirth(rs.getString("birth"));
				member.setPostcode(rs.getString("postcode"));
				member.setAddr1(rs.getString("addr1"));
				member.setAddr2(rs.getString("addr2"));
				member.setRegdate(rs.getDate("regdate"));
				member.setPoint(rs.getInt("point"));
				member.setVisited(rs.getInt("visited"));
				
			}
			
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("SQL 처리 실패");
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("잘못된 요청입니다.");
			e.printStackTrace();
		}finally {
			JDBCConnection.close(rs, pstmt, conn);
		}
		
		return member;
	}
	
	public int addMember(MemberVO vo) {		//메서드 (매개변수) -회원가입
		String upw = Base64.getEncoder().encodeToString(vo.getU_pw().getBytes());		//암호화 byte[]->String
		try {
			conn = JDBCConnection.getConnection();
			sql = "insert into member values(?,?,?,?,?,?,?,?,?,sysdate,1000,0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getU_id());	//vo에 저장된 u_id를 불러와 저장
			pstmt.setString(2, upw);
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getTell());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getBirth());
			pstmt.setString(7, vo.getPostcode());
			pstmt.setString(8, vo.getAddr1());
			pstmt.setString(9, vo.getAddr2());
			cnt = pstmt.executeUpdate();
			
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("SQL 처리 실패");
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("잘못된 요청입니다.");
			e.printStackTrace();
		}finally {
			JDBCConnection.close(pstmt, conn);
		}
		
		return cnt;
	}
	
	public int editMember(MemberVO vo) {		//회원정보수정
		String upw = Base64.getEncoder().encodeToString(vo.getU_pw().getBytes());		//암호화 byte[]->String
		try {
			conn = JDBCConnection.getConnection();
			sql = "update member set u_pw=?, tell=?, email=?, birth=?, postcode=?, addr1=?, addr2=?, where u_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, upw);
			pstmt.setString(2, vo.getTell());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getBirth());
			pstmt.setString(5, vo.getPostcode());
			pstmt.setString(6, vo.getAddr1());
			pstmt.setString(7, vo.getAddr2());
			pstmt.setString(8, vo.getU_id());
			cnt = pstmt.executeUpdate();
			
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("SQL 처리 실패");
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("잘못된 요청입니다.");
			e.printStackTrace();
		}finally {
			JDBCConnection.close(pstmt, conn);
		}
		
		return cnt;
	}
	
	public int login(MemberVO vo) {		//로그인
		byte[] pwc; 		//바이트배열 데이터
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from member where u_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getU_id());		//vo에있는 아이디값
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pwc = Base64.getDecoder().decode(rs.getString("u_pw"));		//rs에있는 암호화된 비밀번호를 디코딩해 복호화
				String upw = new String(pwc);		//복호화된 비밀번호를 string으로 바꿔
				if(vo.getU_pw().equals(upw)) { //바꾼 값과 vo에 저장되어있는 비밀번호 비교
					cnt = 1;		//로그인
				} else {
					cnt = 0;		//로그인불가
				}
			} else {
				cnt = 0;
			}
			
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("SQL 처리 실패");
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("잘못된 요청입니다.");
			e.printStackTrace();
		}finally {
			JDBCConnection.close(pstmt, conn);
		}
		
		return cnt;
	}
	
	public int idCheck(String uid) {		//아이디 중복확인
		
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from member where u_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);		//vo에있는 아이디값
			rs  = pstmt.executeQuery();
			
			if(rs.next()) {		//uid와 데이터베이스에 u_id가 일치하는게 있다면 사용불가 아이디
				cnt = 1;
			} else {			//사용가능한아이디
				cnt = 0;
			}
			
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("SQL 처리 실패");
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("잘못된 요청입니다.");
			e.printStackTrace();
		}finally {
			JDBCConnection.close(pstmt, conn);
		}
		
		return cnt;
	}
	
	public int delMember(String uid) {		//탈퇴
		
		try {
			conn = JDBCConnection.getConnection();
			sql = "delete from member where u_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "u_id");
			cnt = pstmt.executeUpdate();
			
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("SQL 처리 실패");
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("잘못된 요청입니다.");
			e.printStackTrace();
		}finally {
			JDBCConnection.close(pstmt, conn);
		}
		
		return cnt;
	}
}
