package com.shop.view.basket;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.BesketDetailVO;
import com.shop.model.BasketDAO;

@WebServlet("/GetBasketCtrl")
public class GetBasketCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetBasketCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int bno = Integer.parseInt(request.getParameter("bno"));			//bno값을 파라미터로 받아서 
		
		BasketDAO dao = new BasketDAO();
		BesketDetailVO basket = dao.getBasket(bno);		//리턴되는 BasketVO basket 에 메서드 선언 (매개변수 bno)
		
		if(basket!=null) {		//데이터가 있다면 여러건이므로 Attribute로
			request.setAttribute("basket", basket);		//데이터담아서
			RequestDispatcher view = request.getRequestDispatcher("./basket/getBasket.jsp");		//경로지정 후
			view.forward(request, response);		//전송
		}else {
			response.sendRedirect("GetBasketListCtrl");
		}
	}

}
