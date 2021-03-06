package com.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.common.MemberVO;
import com.shop.model.MemberDAO;

@WebServlet("/MypageCtrl")
public class MypageCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MypageCtrl() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String u_id = (String) session.getAttribute("sid");		//로그인한 상태로 마이페이지 확인-> 세션에 저장된 u_id의 변수:sid
		MemberDAO dao = new MemberDAO();
		MemberVO member = new MemberVO();
		member = dao.getMember(u_id);			//리턴퇴는 member에 받아온 u_id입력
		
		if(member!=null) {
			request.setAttribute("member", member);		
			RequestDispatcher view = request.getRequestDispatcher("./member/myPage.jsp");
			view.forward(request, response);
		}else {
			response.sendRedirect("index.jsp");
		}
		
	}

}
