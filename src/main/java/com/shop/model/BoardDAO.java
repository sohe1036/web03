package com.shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.common.BoardVO;
import com.shop.common.JDBCConnection;

public class BoardDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql = "";
	int cnt = 0;
	
	public ArrayList<BoardVO> getBoradList() {		//반환자 , 메소드명
		ArrayList<BoardVO> list = null;
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from board";
			pstmt = conn.prepareCall(sql);
			rs = pstmt.executeQuery();
			
			list = new ArrayList<BoardVO>();
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setName(rs.getString("name"));
				vo.setRegdate(rs.getDate("regdate"));
				vo.setShow(rs.getInt("show"));
				list.add(vo);
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
	
	public BoardVO getBoard(int seq) {
		BoardVO board = new BoardVO();
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from board where seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setName(rs.getString("name"));
				board.setRegdate(rs.getDate("regdate"));
				board.setShow(rs.getInt("show"));
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
		return board;
	}
		public ArrayList<BoardVO> getConditionSerach(String condition, String keyword) { //반환자, 메소드(매개변수 condition=선택요건 ,keyword=검색할 단어)
			ArrayList<BoardVO> list = null;
			try {
				conn = JDBCConnection.getConnection();
				if(condition.equals("title")) {			//condition의 값이 title이랑 같으면 (제목을 선택해 키워드 검색했을 때)
					sql = "select * from board where title like ?";
					pstmt = conn.prepareCall(sql);
					pstmt.setString(1, "%"+keyword+"%");
				}else {
					sql = "select * from board where content like ?";		//condition의 값이 title이랑 다르면 (내용을 선택해 키워드 검색했을 때)
					pstmt = conn.prepareCall(sql);
					pstmt.setString(1, "%"+keyword+"%");
				}
				
				rs = pstmt.executeQuery();
				
				list = new ArrayList<BoardVO>();
				while (rs.next()) {
					BoardVO board = new BoardVO();
					board.setSeq(rs.getInt("seq"));
					board.setTitle(rs.getString("title"));
					board.setContent(rs.getString("content"));
					board.setName(rs.getString("name"));
					board.setRegdate(rs.getDate("regdate"));
					board.setShow(rs.getInt("show"));
					list.add(board);
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
	

		public int addBoard(BoardVO vo) {
			try {
				conn = JDBCConnection.getConnection();
				sql = "insert into board values((select nvl(max(seq), 0)+1 from board), ?, ?, ?, sysdate, 0)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getContent());
				pstmt.setString(3, vo.getName());
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
		
		public int editBoard(BoardVO vo) {
			try {
				conn = JDBCConnection.getConnection();
				sql = "update board set title=?, content=?, regdate=sysdate where seq=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getContent());
				pstmt.setInt(3, vo.getSeq());
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
			
		public int delBoard(int num) {			//삭제는 VO객체안만들어도되니까 num만받아
			try {
				conn = JDBCConnection.getConnection();
				sql = "delete from board where seq=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, num);
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