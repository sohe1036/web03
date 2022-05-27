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

@WebServlet("/GetMemberCtrl")
public class GetMemberCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetMemberCtrl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String u_id = request.getParameter("u_id");		//아이디로 상세정보 불러올거라 보낸 u_id를 파라미터로 받아
		MemberDAO dao = new MemberDAO();		//DAO연결
		MemberVO member = new MemberVO();			//VO연결
		member = dao.getMember(u_id);		//리턴되는 member에 메서드(매개변수) 입력
		
		if(member != null) {		//데이터가 있다면
			request.setAttribute("member", member);		//데이터 담긴 member를 Attribute에 넣어(여러정보)
			RequestDispatcher view = request.getRequestDispatcher("./member/getMember.jsp");		//경로지정
			view.forward(request, response);		//보내
		}else {			//데이터가 null이면
			response.sendRedirect("GetMemberListCtrl");
		}
	}

}
