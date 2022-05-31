package com.shop.view.basket;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.common.BasketVO;
import com.shop.model.BasketDAO;

@WebServlet("/GetBasketListCtrl")
public class GetBasketListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public GetBasketListCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
	
		String u_id = (String) session.getAttribute("sid");
		
		BasketDAO dao = new BasketDAO();		//DAO선언
		ArrayList<BasketVO> list = dao.getBasketList(u_id); //리턴되는 list에 메서드선언
		
		request.setAttribute("list", list);			//배열이라 Attribute
		RequestDispatcher view = request.getRequestDispatcher("./basket/getBasketList.jsp");		//경로지정
		view.forward(request, response);
	}

}
