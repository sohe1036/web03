package com.shop.controller.review;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.model.ReviewDAO;

@WebServlet("/ReviewCheckCtrl")
public class ReviewCheckCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ReviewCheckCtrl() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int ono = Integer.parseInt(request.getParameter("ono"));
		int gno = Integer.parseInt(request.getParameter("gno"));
		HttpSession session = request.getSession();
		String u_id = request.getParameter("sid");
		
		ServletContext application = getServletContext();
		ReviewDAO dao = new ReviewDAO();
		int cnt = dao.rewiewCheck(ono);
		if(cnt>0) {		//리뷰작성안되게
			response.getWriter().print("<script>alert('이미 작성한 리뷰입니다.'); history.back();</script>");
			return;
		}else {		//리뷰 페이지로 이동
			application.setAttribute("ono", ono);
			application.setAttribute("gno", gno);
			response.sendRedirect("./review/addReviewForm.jsp?");
		}
	}

}
