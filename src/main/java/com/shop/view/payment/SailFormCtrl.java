package com.shop.view.payment;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.BasketVO;
import com.shop.common.GoodsVO;
import com.shop.model.PaymentDAO;

@WebServlet("/SailFormCtrl")
public class SailFormCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SailFormCtrl() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int gno = Integer.parseInt(request.getParameter("gno"));
		int bno = 0;

		if(request.getParameter("bno")!=null) {		//메뉴에서 바로구매시
			bno = Integer.parseInt(request.getParameter("bno"));
		}
		
		PaymentDAO dao = new PaymentDAO();
		GoodsVO goods = new GoodsVO();
		
		
		goods = dao.callByPay(gno , bno);
		if(goods!=null) {
			request.setAttribute("goods", goods);
			request.setAttribute("bno", bno);
			RequestDispatcher view = request.getRequestDispatcher("./payment/sailForm.jsp");		//RequestDispatcher는gno를 보낼 수 없어서 Attribute로보냄
			view.forward(request, response);		//전송
		}else {
			response.sendRedirect("GetGoodsListCtrl");
		}
	}

}
