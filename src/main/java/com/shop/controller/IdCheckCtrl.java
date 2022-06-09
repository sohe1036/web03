package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.model.MemberDAO;

@WebServlet("/IdCheckCtrl")
public class IdCheckCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ServletContext application = null;		//어플리케이션 이용해서 msg를 join.jsp에전달
	
    public IdCheckCtrl() {
        super();

    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String uid = request.getParameter("uid");		//uid값을 파라미터로 받아와
		MemberDAO dao = new MemberDAO();		
		int cnt = dao.idCheck(uid);		//리턴되는 cnt에 메서드 입력
		
		application = getServletContext();
			
		if(cnt>0) {				//일치하는 아이디 있을 때 
			application.setAttribute("msg", "no");		//Attribute 전달
			response.sendRedirect("./member/join.jsp");
		}else {					//일치하는 아이디가 없을 때
			application.setAttribute("msg", "yes");		
			application.setAttribute("uid", uid);		//받았던 uid 다시전달하면 value에 uid넣어놨으니 화면에 아이디가 출력
			response.sendRedirect("./member/join.jsp");
		}
	}
}
