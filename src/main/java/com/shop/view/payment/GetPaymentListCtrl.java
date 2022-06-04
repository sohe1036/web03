package com.shop.view.payment;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.PaymentVO;
import com.shop.model.PaymentDAO;

@WebServlet("/GetPaymentListCtrl")
public class GetPaymentListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetPaymentListCtrl() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding(("UTF-8"));
		response.setContentType("text/html; charset=UTF-8");
		
		PaymentDAO dao = new PaymentDAO();
		ArrayList<PaymentVO> payList = dao.getPaymentList();
		
		if(payList!=null) {
			request.setAttribute("payList", payList);		
			RequestDispatcher view = request.getRequestDispatcher("./payment/getPaymentList.jsp");
			view.forward(request, response);
		}else {
			response.sendRedirect("index.jsp");
		}
	}

}
