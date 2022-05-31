package com.shop.controller.basket;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.model.BasketDAO;

@WebServlet("/DelBasketCtrl")
public class DelBasketCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DelBasketCtrl() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int bno = Integer.parseInt(request.getParameter("bno"));		//bno를 파라미터로 받아
		
		BasketDAO dao = new BasketDAO();		//DAO선언
		
		int cnt = dao.delBasket(bno);		//리턴되는 cnt에 메서드(매개변수)
		if(cnt>0) {			//삭제성공
			response.sendRedirect("GetBasketListCtrl");
		}else {				//삭제실패
			response.sendRedirect("GetBasketCtrl");
		}
		
	}

}
