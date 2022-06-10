package com.shop.controller.review;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.ReviewVO;
import com.shop.model.ReviewDAO;

@WebServlet("/GetReviewListCtrl")
public class GetReviewListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetReviewListCtrl() {
        super();
      
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int gno = Integer.parseInt(request.getParameter("gno"));
		
		ReviewDAO dao = new ReviewDAO();
		ArrayList<ReviewVO> list = dao.getReviewList(gno);
		
		if(list != null) {
			request.setAttribute("list", list);
			RequestDispatcher view = request.getRequestDispatcher("GetGoodsCtrl?gno="+gno);
			view.forward(request, response);
		}else {
			response.sendRedirect("GetGoodsCtrl?gno="+gno);
		}
				
	}

}
