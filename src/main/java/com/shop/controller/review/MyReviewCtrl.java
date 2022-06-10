package com.shop.controller.review;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.common.ReviewVO;
import com.shop.model.ReviewDAO;

@WebServlet("/MyReviewCtrl")
public class MyReviewCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyReviewCtrl() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8" );
		HttpSession session = request.getSession();
		String u_id = (String) session.getAttribute("sid");
		int reno = Integer.parseInt(request.getParameter("reno"));
		
		ReviewDAO dao = new ReviewDAO();
		ReviewVO review = dao.getReview(u_id, reno);
		
		if(review!=null) {
			request.setAttribute("review", review);
			RequestDispatcher view = request.getRequestDispatcher("./review/MyReview.jsp");
			view.forward(request, response);
		}else {
			response.sendRedirect("MyReviewListCtrl");
		}
		
	}

}
