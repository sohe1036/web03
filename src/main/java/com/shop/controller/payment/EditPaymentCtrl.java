package com.shop.controller.payment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.common.PaymentVO;
import com.shop.model.PaymentDAO;

@WebServlet("/EditPaymentCtrl")
public class EditPaymentCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditPaymentCtrl() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		String sid = (String) session.getAttribute("sid");
		//입력받은 데이터를 파라미터로 받아
		int ono = Integer.parseInt(request.getParameter("ono"));	//결제번호
		String paytype = request.getParameter("paytype");	//결제방식
		String payname = request.getParameter("payname");	//카드사,은행명
		String payno = request.getParameter("payno");	//결제카드번호	
		int money = Integer.parseInt(request.getParameter("money"));
		int gno = Integer.parseInt(request.getParameter("gno"));
		int pieces = Integer.parseInt(request.getParameter("pieces"));		//수량
		String u_id = request.getParameter("u_id");
		String rname = request.getParameter("rname");	//수신자명
		String tel = request.getParameter("tel");		//수신자전화번호
		String addr1 = request.getParameter("addr1");	//수신자 기본주소
		String addr2 = request.getParameter("addr2");	//수신자 상세주소
		String postcode = request.getParameter("postcode");	//수신자 우편번호
		String transno = request.getParameter("transno");
		String transco = request.getParameter("transco");
		String rstatus = request.getParameter("rstatus");
		String rdate = request.getParameter("rdate");
		String memo = request.getParameter("memo");		//메모
		//vo에 입력
		PaymentVO vo = new PaymentVO(); 
		vo.setOno(ono);
		vo.setPaytype(paytype);
		vo.setPayno(payno);
		vo.setMoney(money);
		vo.setGno(gno);
		vo.setPieces(pieces);
		vo.setU_id(u_id);
		vo.setRname(rname);
		vo.setTel(tel);
		vo.setAddr1(addr1);
		vo.setAddr2(addr2);
		vo.setPostcode(postcode);
		vo.setTransno(transno);
		vo.setTransco(transco);
		vo.setRstatus(rstatus);
		vo.setRdate(rdate);
		vo.setMemo(memo);
	
		PaymentDAO dao = new PaymentDAO();
		int cnt =0 ;
		
		if(sid.equals("admin")) {		//관리자 수정
			cnt = dao.shoppingAssign(vo);
			if(cnt>0) {
				response.sendRedirect("GetPaymentListCtrl");
			} else {
				response.sendRedirect("GetPaymentCtrl?ono="+ono);
			}
		}
		if(!sid.equals("admin")) {		//회원수정
			cnt = dao.editPayment(vo);
			if(cnt>0) {		//수정o
				response.sendRedirect("MyPaymentCtrl");
			}else {		//수정x
				response.sendRedirect("EditShoppingCtrl?ono="+ono);
			}
		}
		
		
	}

}
