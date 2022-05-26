package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.MemberVO;
import com.shop.model.MemberDAO;

@WebServlet("/EditMemberCtrl")
public class EditMemberCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditMemberCtrl() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String u_id = request.getParameter("u_id");
		String u_pw = request.getParameter("u_pw");
		String tell = request.getParameter("tell");
		String email = request.getParameter("email");
		String birth = request.getParameter("birth");
		String postcode = request.getParameter("postcode");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");			//입력된 정보를 가져와서
		
		MemberDAO dao = new MemberDAO();		//DAO연결
		MemberVO vo = new MemberVO();			//VO연결
		vo.setU_id(u_id);
		vo.setU_pw(u_pw);
		vo.setTell(tell);
		vo.setEmail(email);
		vo.setBirth(birth);
		vo.setPostcode(postcode);
		vo.setAddr1(addr1);
		vo.setAddr2(addr2);				//vo에 값 set
		
		int cnt = dao.editMember(vo);		// 리턴되는 cnt에 데이터 담아
		
		if(cnt>0) {			//수정성공
			response.sendRedirect("MypageCtrl?u_id="+u_id);
		}else {				//수정실패
			response.sendRedirect("GetUserCtrl?u_id="+u_id);
		}
	
	}

}
