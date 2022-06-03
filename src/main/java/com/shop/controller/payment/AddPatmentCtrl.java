package com.shop.controller.payment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.common.PaymentVO;
import com.shop.model.BasketDAO;
import com.shop.model.GoodsDAO;
import com.shop.model.PaymentDAO;

@WebServlet("/AddPatmentCtrl")
public class AddPatmentCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddPatmentCtrl() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		String u_id = (String) session.getAttribute("sid");
		int gno = Integer.parseInt(request.getParameter("gno"));		//상품코드
		int bno = 0;
		if(request.getParameter("bno")!=null){
			bno = Integer.parseInt(request.getParameter("bno"));}
		String gname = request.getParameter("gname");
		int price = Integer.parseInt(request.getParameter("price"));
		int pieces = Integer.parseInt(request.getParameter("pieces"));		//수량
		int money = price * pieces;		
		String rname = request.getParameter("rname");	//수신자명
		String tel = request.getParameter("tel");		//수신자전화번호
		String addr1 = request.getParameter("addr1");	//수신자 기본주소
		String addr2 = request.getParameter("addr2");	//수신자 상세주소
		String postcode = request.getParameter("postcode");	//수신자 우편번호
		String memo = request.getParameter("memo");		//메모
		String paytype = request.getParameter("paytype");	//결제방식
		String payname = request.getParameter("payname");	//카드사,은행명
		String payno = request.getParameter("payno");	//결제카드번호	
		payno = payname + " : " +payno;
		
		PaymentVO vo = new PaymentVO();
		vo.setU_id(u_id);
		vo.setGno(gno);
		vo.setPieces(pieces);
		vo.setMoney(money);
		vo.setRname(rname);
		vo.setTel(tel);
		vo.setAddr1(addr1);
		vo.setAddr2(addr2);
		vo.setPostcode(postcode);
		vo.setMemo(memo);	
		vo.setPaytype(paytype);
		vo.setPayno(payno);
		
		PaymentDAO dao = new PaymentDAO();
		int cnt = dao.addPayment(vo, bno);
		//PrintWriter out = response.getWriter();
		
		GoodsDAO gdao = new GoodsDAO();		//구매하면 상품재고량 수정
		BasketDAO bdao =  new BasketDAO();	//구매하면 장바구니에서 상품삭제
		int num = 0;		//num = rs.getInt("pieces")
		int amount = 0; 	//남은수량
		int gcnt = 0;		//수정 후 editGoods(int gno, int num) 리턴값 cnt
		int bcnt = 0;		//수정 후 delBasket(int bno) 리턴값	cnt
		if(cnt>0) {	//결제성공
			response.sendRedirect("index.jsp");
			num = gdao.countGoods(gno);  //리턴되는 num에 메서드(매개변수)->수량만 select
			amount = num - pieces;		//상품수량에서 주문수량 빼면 남은수량	
			
			gcnt = gdao.editGoods(gno, num);
			if(gcnt>0) {		
				System.out.println("제품수령변경");
			}else {
				System.out.println("제품수량변경 안됨");
			}
			if(bno!=0) {		//장바구니에 물건이 있을 때
				bcnt = bdao.delBasket(bno);	
				if(bcnt>0) {
					System.out.println("장바구니 삭제");
				}else {
					System.out.println("장바구니 삭제안됨");
				}
			}
			
		}else {		//결제실패
			response.sendRedirect("SailFormCtrl");
		}
	
	}

}
