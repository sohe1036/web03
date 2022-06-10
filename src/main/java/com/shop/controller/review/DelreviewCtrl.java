package com.shop.controller.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.model.ReviewDAO;

@WebServlet("/DelreviewCtrl")
public class DelreviewCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DelreviewCtrl() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		String u_id = (String)session.getAttribute("sid");
		int reno = Integer.parseInt(request.getParameter("reno"));
		
		ReviewDAO dao = new ReviewDAO();
		int cnt = dao.delReview(reno);
		
		if(cnt>0) {
			response.sendRedirect("MyReviewListCtrl?u_id="+u_id);
		}else {
			response.sendRedirect("MyReviewCtrl?reno="+reno);
		}
		
	}

}
