package com.shop.controller.payment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.PaymentVO;
import com.shop.model.PaymentDAO;

@WebServlet("/AddPatmentCtrl")
public class AddPatmentCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddPatmentCtrl() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		/* int ono = Integer.parseInt(request.getParameter("ono")); */
		String paytype = request.getParameter("paytype");	//결제방식
		String payno = request.getParameter("payno");	//결제카드번호
		int money = Integer.parseInt(request.getParameter("money"));		//결제금액
		String sdate = request.getParameter("sdate");	//결제일
		int gno = Integer.parseInt(request.getParameter("gno"));		//상품코드
		int pieces = Integer.parseInt(request.getParameter("pieces"));		//수량
		String u_id = request.getParameter("u_id");	//사용자아이디
		String rname = request.getParameter("rname");	//수신자명
		String tel = request.getParameter("tel");		//수신자전화번호
		String addr1 = request.getParameter("addr1");	//수신자 기본주소
		String addr2 = request.getParameter("addr2");	//수신자 상세주소
		String postcode = request.getParameter("postcode");	//수신자 우편번호
		String transno = request.getParameter("transno");		//배송코드
		String transco = request.getParameter("transco");		//배송회사
		String rstatus = request.getParameter("rstatus");		//수신상태
		String rdate = request.getParameter("rdate");		//도착일
		String memo = request.getParameter("memo");		//메모
		
		PaymentVO vo = new PaymentVO();
		/* vo.setOno(ono); */
		vo.setPaytype(paytype);
		vo.setPayno(payno);
		vo.setMoney(money);
		vo.setSdate(sdate);
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
		int cnt = dao.addPayment(vo);
		
		if(cnt>1) {
			response.sendRedirect("index.jsp");
		}else {
			response.sendRedirect("SailFormCtrl");
		}
	
	}

}
