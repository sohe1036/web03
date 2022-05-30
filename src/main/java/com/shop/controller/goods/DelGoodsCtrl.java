package com.shop.controller.goods;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.model.GoodsDAO;

@WebServlet("/DelGoodsCtrl")
public class DelGoodsCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DelGoodsCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int gno = Integer.parseInt(request.getParameter("gno"));
		GoodsDAO dao = new GoodsDAO();		//DAO선언
		
		int cnt = dao.delGoods(gno);		//리턴되는 cnt에 메서드입력
		
		if(cnt>0) {		//상품삭제성공
			response.sendRedirect("GetGoodsListCtrl");
		}else {			//상푹삭제 실패
			response.sendRedirect("GetGoodsCtrl?gno="+gno);
		}
	}

}
