package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.model.MemberDAO;


@WebServlet("/DelMemberCtrl")
public class DelMemberCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DelMemberCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String u_id = request.getParameter("u_id");		//보낸 U_id를 파라미터로 받아서
		MemberDAO dao = new MemberDAO();		//DAO 선언
		
		int cnt = dao.delMember(u_id);		//리턴되는 cnt에 메서드(매개변수)입력
		
		if(cnt>0) {		//회원탈퇴 성공
			session.invalidate(); 			//세션 날리고
			response.sendRedirect("index.jsp");
		}else {			//회원탈퇴 실패
			response.sendRedirect("MypageCtrl?u_id="+u_id);
		}
		
	}

}
