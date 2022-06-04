package com.shop.controller.payment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.model.PaymentDAO;

@WebServlet("/DelPaymentCtrl")
public class DelPaymentCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DelPaymentCtrl() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; char=UTF-8");
		HttpSession session = request.getSession();
		String sid = (String) session.getAttribute("sid");
		
		int ono = Integer.parseInt(request.getParameter("ono"));
		
		PaymentDAO dao = new PaymentDAO();
		int cnt = dao.delPayment(ono);
		
		if(sid.equals("admin")) {		//관리자 수정
			if(cnt>0) {
				response.sendRedirect("GetPaymentListCtrl");
			} else {
				response.sendRedirect("GetPaymentCtrl?ono="+ono);
			}
		}else {		//회원수정
			if(cnt>0) {		//수정o
				response.sendRedirect("MyPaymentCtrl");
			}else {		//수정x
				response.sendRedirect("EditShoppingCtrl?ono="+ono);
			}
		}
		
	}

}
