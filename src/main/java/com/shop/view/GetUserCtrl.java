package com.shop.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.MemberVO;
import com.shop.model.MemberDAO;

@WebServlet("/GetUserCtrl")
public class GetUserCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetUserCtrl() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String u_id = request.getParameter("u_id");
		MemberDAO dao = new MemberDAO();
		MemberVO member = new MemberVO();
		member = dao.getMember(u_id);			//리턴퇴는 member에 받아온 u_id입력
		
		if(member!=null) {
			request.setAttribute("member", member);		
			RequestDispatcher view = request.getRequestDispatcher("./member/userInfo.jsp");
			view.forward(request, response);
		}else {
			response.sendRedirect("index.jsp");
		}
		
	}

}
