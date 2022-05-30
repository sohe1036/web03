package com.shop.controller.goods;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.shop.common.GoodsVO;
import com.shop.model.GoodsDAO;

@WebServlet("/AddGoodsCtrl")
public class AddGoodsCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddGoodsCtrl() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		 /*String gname = request.getParameter("gname"); //입력된 값을 파라미터로 받아 
		 String gimg = request.getParameter("gimg"); 
		 String gtype = request.getParameter("gtype");
		 String price = request.getParameter("price"); 
		 String gcolor = request.getParameter("gcolor"); 
		 String gsize = request.getParameter("gsize");
		 String ginfo = request.getParameter("ginfo"); 
		 int pieces = Integer.parseInt(request.getParameter("pieces"));
		 */

		String saveFolder = "upload";
		String realFolder = "D:/LIM/jsp1/web03/src/main/webapp/upload";
		int maxSize = 5 * 1024 * 1024;
		String file;
		String filename = "";		//업로드한 파일이름

		try {
			ServletContext context = request.getServletContext();
			realFolder = context.getRealPath(saveFolder);
			
			MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, "UTF-8");

			GoodsDAO dao = new GoodsDAO(); // DAO 선언
			GoodsVO vo = new GoodsVO(); // VO 선언

			vo.setGname(multi.getParameter("gname"));
			//vo.setGimg(multi.getParameter("gimg"));
			vo.setGtype(multi.getParameter("gtype"));
			vo.setPrice(multi.getParameter("price"));
			vo.setGcolor(multi.getParameter("gcolor"));
			vo.setGsize(multi.getParameter("gsize"));
			vo.setGinfo(multi.getParameter("ginfo"));
			vo.setPieces(Integer.parseInt(multi.getParameter("pieces")));

			int cnt = dao.addGoods(vo); // 리턴된 cnt에 메서드(매개변수)입력

			Enumeration params = multi.getParameterNames();
			Enumeration files = multi.getFileNames();		//전송한 파일 이름 가져와

			file = (String) files.nextElement();		//파일명이 중복일 경우 뒤에 1,2,3
			filename = multi.getFilesystemName(file);		//실제 파일이름 가져와

			if (cnt > 0) { // 투가된 데이터가 있을 때
				response.sendRedirect("GetGoodsListCtrl");
			} else {
				response.sendRedirect("./goods/addGoodsForm.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * gimg = "./img/"+gimg; vo.setGname(gname); //vo에 데이터 입력 vo.setGimg(gimg);
		 * vo.setGtype(gtype); vo.setPrice(price); vo.setGcolor(gcolor);
		 * vo.setGsize(gsize); vo.setGinfo(ginfo); vo.setPieces(pieces);
		 */

	}

}