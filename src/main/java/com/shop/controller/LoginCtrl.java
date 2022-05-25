package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.common.MemberVO;
import com.shop.model.MemberDAO;

@WebServlet("/LoginCtrl")
public class LoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginCtrl() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String u_id = request.getParameter("u_id");		//form에 입력된 값 파라미터로 받아
		String u_pw = request.getParameter("u_pw");
		
		MemberDAO dao = new MemberDAO();		//DAO 연결
		MemberVO vo = new MemberVO();		//MemㅠerVO 연결
		vo.setU_id(u_id);
		vo.setU_pw(u_pw);			//입력된 값 vo에 set
		int cnt = dao.login(vo);	//리턴되는 cnt에 메서드(매개변수) 입력
		
		HttpSession session = request.getSession();		//입력한 값을 세션에 넣기
		
		if(cnt>0) {
			session.setAttribute("sid", u_id);
			session.setAttribute("name", vo.getName());
			response.sendRedirect("index.jsp");
		}else {
			response.sendRedirect("./member/login.jsp");
		}
		
		
	}

}
