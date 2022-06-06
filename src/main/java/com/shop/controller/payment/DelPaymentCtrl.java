package com.shop.controller.payment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.model.GoodsDAO;
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
		int gno = Integer.parseInt(request.getParameter("gno"));
		int pieces = Integer.parseInt(request.getParameter("pieces"));
		
		PaymentDAO dao = new PaymentDAO();
		int cnt = dao.delPayment(ono);
		
		GoodsDAO gdao = new GoodsDAO();		//구매취소하면 상품재고량 수정
		int num = 0;		//num = rs.getInt("pieces")
		int amount = 0; 	//남은수량
		int gcnt = 0;		//수정 후 editGoods(int gno, int num) 리턴값 cnt
		
		if(sid.equals("admin")) {		//관리자 삭제
			if(cnt>0) {		//삭제성공
				response.sendRedirect("GetPaymentListCtrl");
				num = gdao.countGoods(gno);  //리턴되는 num에 메서드(매개변수)->수량만 select
				amount = num + pieces;			//상품수량+취소수량
				
				gcnt = gdao.editGoods(gno, amount);
				if(gcnt>0) {	//상품수량 update	
					System.out.println("제품수량변경");
				}else {
					System.out.println("제품수량변경 안됨");
				}
			} else {		//삭제실패
				response.sendRedirect("GetPaymentCtrl?ono="+ono);
			}
		}else {		//회원 삭제
			if(cnt>0) {		//삭제성공
				response.sendRedirect("MyPaymentCtrl");
				num = gdao.countGoods(gno);  //리턴되는 num에 메서드(매개변수)->수량만 select
				amount = num + pieces;			//상품수량+취소수량
				
				gcnt = gdao.editGoods(gno, amount);
				if(gcnt>0) {		
					System.out.println("제품수량변경");
				}else {
					System.out.println("제품수량변경 안됨");
				}
			}else {		//삭제실패
				response.sendRedirect("EditShoppingCtrl?ono="+ono);
			}
		}
		
	}

}
