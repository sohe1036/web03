package com.shop.controller.basket;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.common.BasketVO;
import com.shop.model.BasketDAO;

@WebServlet("/AddBasketCtrl")
public class AddBasketCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddBasketCtrl() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int pieces = 1;
		int gno = Integer.parseInt(request.getParameter("gno"));
		String gname = request.getParameter("gname");
		String gsize = request.getParameter("gsize");
		String gcolor = request.getParameter("gcolor");
		int price = Integer.parseInt(request.getParameter("price"));
		HttpSession session = request.getSession();			//세션 불러와
		String sid = (String) session.getAttribute("sid");		//세션에 저장된 u_id변수:sid
		
		BasketVO vo = new BasketVO();			//받아온 데이터를 VO에 set
		vo.setGno(gno);
		vo.setGname(gname);
		vo.setGsize(gsize);
		vo.setGcolor(gcolor);
		vo.setPrice(price);
		vo.setPieces(pieces);
		vo.setU_id(sid);
		
		BasketDAO dao = new BasketDAO();
		int cnt = dao.addBasket(vo);		//리턴되는 cnt에 메서드 선언
		
		if(cnt>0) {		//추가할 데이터가 있음
			response.sendRedirect("GetGoodsListCtrl");
		}else {
			response.sendRedirect("GetGoodsCtrl?gno="+gno);
		}
		
	}

}
