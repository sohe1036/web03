package com.shop.view.goods;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.GoodsVO;
import com.shop.model.GoodsDAO;

@WebServlet("/GetGoodsListCtrl")
public class GetGoodsListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetGoodsListCtrl() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String gtype = request.getParameter("gtype");		//타입에 따라 메뉴 불러오려면 타입 데이터를 파라미터로 받아와야함
		String gsize = request.getParameter("gsize");
		
		GoodsDAO dao = new GoodsDAO();			//DAO선언
		ArrayList<GoodsVO> list;
		if(gtype!=null && gsize!=null){
			list = dao.getGoodsList(gtype, gsize);
		}else if(gtype!=null) {
			list = dao.getGoodsList(gtype);		//리턴된 list에 dao메서드호출
		}else {
			list = dao.getGoodsList();
		}
		request.setAttribute("list", list);			//list에 담긴 데이터를넣어서 보내
		RequestDispatcher view = request.getRequestDispatcher("./goods/getGoodsList.jsp");		//보낼곳 지정
		view.forward(request, response);		//전송
		
		
	}

}
