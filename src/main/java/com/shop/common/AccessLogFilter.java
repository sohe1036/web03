package com.shop.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AccessLogFilter implements Filter {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql = "";
	int cnt = 0;
	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
	        HttpServletRequest request = (HttpServletRequest) req;
	        HttpServletResponse response = (HttpServletResponse) res;
	        long start_time = System.currentTimeMillis();

	        //request에서 각정보를 구함.
	        String request_uri = request.getRequestURI()==null?"":request.getRequestURI();
	        String query_string = request.getQueryString()==null?"":request.getQueryString();
	        String remote_address = request.getRemoteAddr()==null?"":request.getRemoteAddr();
	        String server_name = request.getServerName()==null?"":request.getServerName();
	        int server_port = request.getServerPort();
	        Locale locale = request.getLocale();
	        String browser = request.getHeader("User-Agent")==null?"":request.getHeader("User-Agent");
	        String referer = (request.getHeader("referer")==null)? "":request.getHeader("referer");
	        //세션을 구한다.
	        HttpSession session = request.getSession();
	        String session_id = session.getId();
	        //사용자 아이디를 구한다.
	        String user_id = (session.getAttribute("sid")==null)?"":(String)session.getAttribute("sid");

	        //응답을 보낸다.
	        chain.doFilter(request, response);

	        long stop_time = System.currentTimeMillis();
	        long response_time = stop_time-start_time;

			try {
				conn = JDBCConnection.getConnection();
				sql = "insert into db_access values((select nvl(max(no), 0)+1 from db_access), ?, ?, ?, ?, ?, '', ?, ?, ?, ?, ?, sysdate)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, request_uri);
				pstmt.setString(2, query_string);
				pstmt.setString(3, remote_address);
				pstmt.setString(4, server_name);
				pstmt.setInt(5, server_port);
				pstmt.setString(6, browser);
				pstmt.setString(7, referer);
				pstmt.setString(8, session_id);
				pstmt.setString(9, user_id);
				pstmt.setLong(10, response_time);
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
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
