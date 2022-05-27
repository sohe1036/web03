package com.shop.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.MemberVO;
import com.shop.model.MemberDAO;

@WebServlet("/GetMemberListCtrl")
public class GetMemberListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetMemberListCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		MemberDAO dao = new MemberDAO();		//DAO 연결-
		ArrayList<MemberVO> list = dao.getMemberList();		//리턴되는 list에 DAO 메서드 입력
		request.setAttribute("list", list); 		//배열이니 attribute 
		RequestDispatcher view = request.getRequestDispatcher("./member/getMemberList.jsp");		//list에 담은 데이터 보낼 곳 지정
		view.forward(request, response);		//전송
	}
}
