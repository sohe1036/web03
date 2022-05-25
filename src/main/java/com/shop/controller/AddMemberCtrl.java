package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.MemberVO;
import com.shop.model.MemberDAO;

@WebServlet("/AddMemberCtrl")
public class AddMemberCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddMemberCtrl() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String u_id = request.getParameter("u_id");
		String u_pw = request.getParameter("u_pw");
		String name = request.getParameter("name");
		String tell = request.getParameter("tell");
		String email = request.getParameter("email");
		String birth = request.getParameter("birth");
		String postcode = request.getParameter("postcode");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		vo.setU_id(u_id);
		vo.setU_pw(u_pw);
		vo.setName(name);
		vo.setTell(tell);
		vo.setEmail(email);
		vo.setBirth(birth);
		vo.setPostcode(postcode);
		vo.setAddr1(addr1);
		vo.setAddr2(addr2);
		
		int cnt = dao.addMember(vo);
		
		if(cnt>0) {				//회원가입 성공
			response.sendRedirect("./member/login.jsp");	
		} else {				//회원가입 실패
			response.sendRedirect("./member/join.jsp");
		}
	}
}
