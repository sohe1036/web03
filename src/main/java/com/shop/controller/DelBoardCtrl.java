package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.model.BoardDAO;

@WebServlet("/DelBoardCtrl")
public class DelBoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DelBoardCtrl() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int num = Integer.parseInt(request.getParameter("num"));		//getBoard의 num값을 받아서 
			
		BoardDAO dao = new BoardDAO();
		int cnt = dao.delBoard(num);			//리턴되는 cnt에 매개변수 입력
		
		if(cnt>0) {
			response.sendRedirect("GetBoardListCtrl");
		}else {
			response.sendRedirect("GetBoardCtrl?num"+num);
		}
	}

}
