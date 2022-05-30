package com.shop.view.goods;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.GoodsVO;
import com.shop.model.GoodsDAO;

@WebServlet("/GetGoodsUpdateCtrl")
public class GetGoodsUpdateCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetGoodsUpdateCtrl() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int gno = Integer.parseInt(request.getParameter("gno"));		//gno를 파라미터로 받아
		
		GoodsDAO dao = new GoodsDAO();
		GoodsVO goods = new GoodsVO();
		goods = dao.getGoods(gno);
		
		if(goods != null) {		//데이터가 있다면 상세정보 불러오기
			request.setAttribute("goods", goods); 		//데이터들을 담아서
			RequestDispatcher view = request.getRequestDispatcher("./goods/updateGoods.jsp"); 		//경로지정
			view.forward(request, response);		//전송
		}else {
			response.sendRedirect("GetGoodsListCtrl");
		}
	}

}
