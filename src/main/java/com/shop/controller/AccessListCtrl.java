package com.shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.AccessVO;
import com.shop.model.AccessDAO;

@WebServlet("/AccessListCtrl")
public class AccessListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AccessListCtrl() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		AccessDAO dao = new AccessDAO();
		ArrayList<AccessVO> list = dao.getAccessList();
		request.setAttribute("list", list);
		RequestDispatcher view = request.getRequestDispatcher("getAccessList.jsp");
		view.forward(request, response);
	}
}