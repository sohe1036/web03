package com.shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.common.AccessVO;
import com.shop.common.JDBCConnection;

public class AccessDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql = "";
	int cnt = 0;
	public ArrayList<AccessVO> getAccessList() {
		ArrayList<AccessVO> list = null;
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from db_access";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<AccessVO>();
			while(rs.next()) {
				AccessVO vo = new AccessVO();
				vo.setNo(rs.getInt("no"));
				vo.setRequest_uri(rs.getString("request_uri"));
				vo.setQuery_string (rs.getString("query_string"));
				vo.setRemote_address(rs.getString("remote_address"));
				vo.setServer_name(rs.getString("server_name"));
				vo.setServer_port(rs.getString("server_port"));
				vo.setBrowser(rs.getString("locale"));
				vo.setBrowser(rs.getString("browser"));
				vo.setReferer(rs.getString("referer"));
				vo.setSession_id(rs.getString("session_id"));
				vo.setUser_id(rs.getString("user_id"));
				vo.setResponse_time(rs.getInt("response_time"));
				vo.setReg_date(rs.getString("reg_date"));
				list.add(vo);
			}
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
			JDBCConnection.close(rs, pstmt, conn);
		}
		return list;
	}
}
