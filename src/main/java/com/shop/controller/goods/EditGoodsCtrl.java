package com.shop.controller.goods;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
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
		response.setCharacterEncoding(("UTF-8"));
		response.setContentType("text/html; charset=UTF-8");
		
		String saveFolder = "D:/sohee/eclipse_jsp/web03/src/main/webapp/upload";		//파일이 업로드 될 경로
		//String saveFolder = "D:/LIM/jsp1/web03/src/main/webapp/upload";
		int maxSize = 5 * 1024 * 1024;			//업로드 될 최대 사이즈 용량 5M
		
		MultipartRequest multi	= new MultipartRequest(request, saveFolder, maxSize, "UTF-8");
		//MultipartRequest는 request로 받을 수 x
		int gno = Integer.parseInt(multi.getParameter("gno"));
		String gname = multi.getParameter("gname");			//입력된 값을 파라미터로 받아
		String gimg = "";
		String gtype = multi.getParameter("gtype");
		int price = Integer.parseInt(multi.getParameter("price"));
		String gcolor = multi.getParameter("gcolor");
		String gsize = multi.getParameter("gsize");
		String gsize2 = multi.getParameter("gsize2");
		String ginfo = multi.getParameter("ginfo");
		int pieces = Integer.parseInt(multi.getParameter("pieces"));
		
		try {
			if(multi.getFilesystemName("gimg")!=null) {		//파일명이 null이아니라면
				String name = multi.getFilesystemName("gimg");	//"gimg"의 이름 받아오기 중복일경우 1,2,3
				File f = multi.getFile(name);
				gimg = name;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		GoodsVO vo = new GoodsVO();			//VO 선언
		vo.setGno(gno);
		vo.setGname(gname);			//vo에 데이터 입력
		vo.setGimg("/upload/"+gimg);
		vo.setGtype(gtype);
		vo.setPrice(price);
		vo.setGcolor(gcolor);
		vo.setGsize(gsize);
		vo.setGsize2(gsize2);
		vo.setGinfo(ginfo);
		vo.setPieces(pieces);
		
		GoodsDAO dao = new GoodsDAO();		//DAO 선언
		int cnt = dao.editGoods(vo);		//리턴된 cnt에 메서드(매개변수)입력
		
		if(cnt>0) {		//추가된 데이터가 있을 때
			response.sendRedirect("GetGoodsCtrl?gno="+gno);
		}else {
			response.sendRedirect("./goods/updateGoods.jsp");
		}
	}

}
