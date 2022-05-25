package com.shop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogOutCtrl")
public class LogOutCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LogOutCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();			//세션을 불러와서
		session.invalidate();			//무효시키기
		response.sendRedirect("index.jsp"); 		//로그아웃 후 메인페이지 이동
		
	}

}
