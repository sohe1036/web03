package com.shop.controller.payment;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.PaymentVO;
import com.shop.model.PaymentDAO;

@WebServlet("/EditShoppingCtrl")
public class EditShoppingCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditShoppingCtrl() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; char=UTF-8");
		int ono = Integer.parseInt(request.getParameter("ono"));
		
		PaymentDAO dao = new PaymentDAO();
		PaymentVO payment = dao.getPayment(ono);
		
		if(payment!=null) {
			request.setAttribute("payment", payment);
			RequestDispatcher view = request.getRequestDispatcher("./payment/editShopping.jsp");
			view.forward(request, response);
		}else {
			response.sendRedirect("MyPaymentCtrl");
		}
	}

}
