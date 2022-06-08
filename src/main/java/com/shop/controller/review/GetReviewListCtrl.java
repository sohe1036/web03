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
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/thml; charset=UTF-8");
		
		String u_id = request.getParameter("u_id");
		
		ReviewDAO dao = new ReviewDAO();
		ArrayList<ReviewVO> list = dao.getReviewList(u_id);
		
		request.setAttribute("list",list);
		RequestDispatcher view = request.getRequestDispatcher("./review/getReviewList.jsp");
		view.forward(request, response);
	}

}
