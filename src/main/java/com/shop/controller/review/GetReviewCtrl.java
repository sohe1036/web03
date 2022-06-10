package com.shop.controller.review;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.ReviewVO;
import com.shop.model.ReviewDAO;

@WebServlet("/GetReviewCtrl")
public class GetReviewCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetReviewCtrl() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int gno = Integer.parseInt(request.getParameter("gno"));
		int reno = Integer.parseInt(request.getParameter("reno"));
		
		ReviewDAO dao = new ReviewDAO();
		ReviewVO review = dao.getReview(gno, reno);
		
		if(review!=null) {
			request.setAttribute("review", review);
			RequestDispatcher view = request.getRequestDispatcher("./review/getReview.jsp");
			view.forward(request, response);
		}else {
			response.sendRedirect("GetReviewListCtrl?gno="+gno);
		}
		
	}

}
