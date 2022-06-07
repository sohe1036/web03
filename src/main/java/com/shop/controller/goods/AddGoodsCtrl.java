package com.shop.controller.goods;

import java.io.IOException;

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
		response.setCharacterEncoding(("UTF-8"));
		response.setContentType("text/html; charset=UTF-8");
		//파일을 DB에 담지않고 특정 경로를 지정해 보관->cos.jar필요
		String saveFolder = "D:/sohee/eclipse_jsp/web03/src/main/webapp/upload";		//파일이 업로드 될 경로
		//String saveFolder = "D:/LIM/jsp1/web03/src/main/webapp/upload";

		int maxSize = 5 * 1024 * 1024;			//업로드 될 최대 사이즈 용량 5M
		
		MultipartRequest multi = new MultipartRequest(request, saveFolder, maxSize, "UTF-8");		//파일업로드
		
		String gname = multi.getParameter("gname");
		String gimg = "";
		String gtype = multi.getParameter("gtype");
		int price = Integer.parseInt(multi.getParameter("price"));
		String gcolor = multi.getParameter("gcolor");
		String gsize = multi.getParameter("gsize");
		String gsize2 = multi.getParameter("gsize2");
		String ginfo = multi.getParameter("ginfo");		
		int pieces = Integer.parseInt(multi.getParameter("pieces"));
		
		try {
			if(multi.getFilesystemName("gimg")!=null) {		
				String name = multi.getFilesystemName("gimg");		//파일 이름 받아올 때 사용하는 메서드 ->중복되는경우 1,2,3
				/* File f = multi.getFile(name); */		//실제 파일 담기 ->getFile() 메소드는 서버 상에 업로드된 파일에 대한 파일 객체를 반환
				gimg = name;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			GoodsVO vo = new GoodsVO(); // VO 선언
			vo.setGname(gname);
			vo.setGtype(gtype);
			vo.setPrice(price);
			vo.setGcolor(gcolor);
			vo.setGsize(gsize);
			vo.setGsize2(gsize2);
			vo.setGinfo(ginfo);
			vo.setPieces(pieces);
			vo.setGimg("/upload/"+gimg);

			GoodsDAO dao = new GoodsDAO(); // DAO 선언
			int cnt = dao.addGoods(vo); // 리턴된 cnt에 메서드(매개변수)입력

			if (cnt > 0) { // 투가된 데이터가 있을 때
				response.sendRedirect("GetGoodsListCtrl");
			} else {
				response.sendRedirect("./goods/addGoodsForm.jsp");
			}

		/*
		 * gimg = "./img/"+gimg; vo.setGname(gname); //vo에 데이터 입력 vo.setGimg(gimg);
		 * vo.setGtype(gtype); vo.setPrice(price); vo.setGcolor(gcolor);
		 * vo.setGsize(gsize); vo.setGinfo(ginfo); vo.setPieces(pieces);
		 */

	}

}