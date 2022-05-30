package com.shop.controller.goods;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.GoodsVO;
import com.shop.model.GoodsDAO;

@WebServlet("/EditGoodsCtrl")
public class EditGoodsCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditGoodsCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int gno = Integer.parseInt(request.getParameter("gno"));
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
		vo.setGno(gno);
		vo.setGname(gname);			//vo에 데이터 입력
		vo.setGimg(gimg);
		vo.setGtype(gtype);
		vo.setPrice(price);
		vo.setGcolor(gcolor);
		vo.setGsize(gsize);
		vo.setGinfo(ginfo);
		vo.setPieces(pieces);
		
		int cnt = dao.editGoods(vo);		//리턴된 cnt에 메서드(매개변수)입력
		
		if(cnt>0) {		//투가된 데이터가 있을 때
			response.sendRedirect("GetGoodsCtrl?gno="+gno);
		}else {
			response.sendRedirect("./goods/updateGoods.jsp");
		}
	}

}
