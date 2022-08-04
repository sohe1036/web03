package com.shop.controller.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.shop.common.ReviewVO;
import com.shop.model.ReviewDAO;

@WebServlet("/EditReviewCtrl")
public class EditReviewCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditReviewCtrl() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		String u_id = (String) session.getAttribute("sid");
		
		//String saveFolder = "D:/sohee/eclipse_jsp/web03/src/main/webapp/upload2";
		String saveFolder = "D:/LIM/jsp1/web03/src/main/webapp/upload2";
		//업로드 된 파일 저장할 주소
				
		int maxSize = 10 * 1024 * 1024;		//최대용량
		
		MultipartRequest multi = new MultipartRequest(request, saveFolder, maxSize, "UTF-8");
		
		int reno = Integer.parseInt(multi.getParameter("reno"));
		int best = Integer.parseInt(multi.getParameter("best"));
		String retitle = multi.getParameter("retitle");
		String recontent = multi.getParameter("recontent");
		String redate = multi.getParameter("redate");
		String reimg=null;
		int gno = Integer.parseInt(multi.getParameter("gno"));
		int ono = Integer.parseInt(multi.getParameter("ono"));
		
		try{
			if(multi.getFilesystemName("reimg")!=null) {			//파일명이 널이 아니면
				String name = multi.getFilesystemName("reimg");
				reimg = name;
			}
		
		}catch(Exception e) {
		e.printStackTrace();
		}

		ReviewVO vo = new ReviewVO();
		vo.setReno(reno);
		vo.setRetitle(retitle);
		vo.setBest(best);
		vo.setRecontent(recontent);
		vo.setRedate(redate);
		vo.setGno(gno);
		vo.setU_id(u_id);
		if(reimg!=null) {
		vo.setReimg("/upload2/"+reimg);
		}
		vo.setOno(ono);
		
		ReviewDAO dao = new ReviewDAO();
		int cnt = dao.editReview(vo);
		
		if(cnt>0) {
			response.sendRedirect("MyReviewListCtrl?u_id="+u_id);
		}else {
			response.sendRedirect("UpdateReviewCtrl?reno="+reno);
		}
		
	}
}
