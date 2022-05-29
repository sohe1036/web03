package com.shop.controller.goods;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.GoodsVO;
import com.shop.model.GoodsDAO;

@WebServlet("/AddGoodsCtrl")
public class AddGoodsCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddGoodsCtrl() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String gname = request.getParameter("gname");			//입력된 값을 파라미터로 받아
		String gimg = request.getParameter("gimg");
		String gtype = request.getParameter("gtype");
		String price = request.getParameter("price");
		String gcolor = request.getParameter("gcolor");
		String gsize = request.getParameter("gsize");
		String ginfo = request.getParameter("ginfo");
		int pieces = Integer.parseInt(request.getParameter("pieces"));
		
		GoodsDAO dao = new GoodsDAO();		//DAO 선언
		GoodsVO vo = new GoodsVO();			//VO 선언
		
		gimg = "./img/"+gimg;
		vo.setGname(gname);			//vo에 데이터 입력
		vo.setGimg(gimg);
		vo.setGtype(gtype);
		vo.setPrice(price);
		vo.setGcolor(gcolor);
		vo.setGsize(gsize);
		vo.setGinfo(ginfo);
		vo.setPieces(pieces);
		
		int cnt = dao.addGoods(vo);		//리턴된 cnt에 메서드(매개변수)입력
		
		if(cnt>0) {		//투가된 데이터가 있을 때
			response.sendRedirect("GetGoodsListCtrl");
		}else {
			response.sendRedirect("./goods/addGoodsForm.jsp");
		}
		
		
	}

}
