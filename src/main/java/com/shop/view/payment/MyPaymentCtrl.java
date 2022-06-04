package com.shop.view.payment;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.common.PaymentVO;
import com.shop.model.PaymentDAO;

@WebServlet("/MyPaymentCtrl")
public class MyPaymentCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyPaymentCtrl() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding(("UTF-8"));
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		String u_id = (String) session.getAttribute("sid");
		
		PaymentDAO dao = new PaymentDAO();
		ArrayList<PaymentVO> payList = dao.getPaymentList(u_id);		
		if(payList!=null) {			//데이터가 있으면
			request.setAttribute("payList", payList);		//Attribute에 담아
			RequestDispatcher view = request.getRequestDispatcher("./payment/myPayment.jsp");		//경로
			view.forward(request, response);
		
		}else {
			response.sendRedirect("MypageCtrl");
		}
		
	}

}
