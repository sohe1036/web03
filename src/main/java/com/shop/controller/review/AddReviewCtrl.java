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

@WebServlet("/AddReviewCtrl")
public class AddReviewCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddReviewCtrl() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		String u_id = (String) session.getAttribute("sid");
		
		String saveFolder = "D:/sohee/eclipse_jsp/web03/src/main/webapp/upload2";
		//String saveFolder = "D:/LIM/jsp1/web03/src/main/webapp/upload2";
		//업로드 된 파일 저장할 주소
		
		int maxSize = 10 * 1024 * 1024;		//최대용량
		
		MultipartRequest multi = new MultipartRequest(request, saveFolder, maxSize, "UTF-8");
		
		String retitle = multi.getParameter("retitle");
		int best = Integer.parseInt(multi.getParameter("best"));
		String recontent = multi.getParameter("recontent");
		String reimg ="";
		int gno = Integer.parseInt(multi.getParameter("gno"));
		
		
		try {
			if(multi.getFilesystemName("reimg")!=null) {
				String name = multi.getFilesystemName("reimg");
				reimg = name;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		ReviewVO vo = new ReviewVO();	//vo에 값 전달
		vo.setRetitle(retitle);
		vo.setBest(best);
		vo.setRecontent(recontent);
		vo.setGno(gno);
		vo.setU_id(u_id);
		vo.setReimg("/upload2/"+reimg);
		
		ReviewDAO dao = new ReviewDAO();
		int cnt = dao.addReview(vo);
		
		if (cnt>0) {
			response.sendRedirect("MyPaymentCtrl");
		}else {
			response.sendRedirect("MyPaymentCtrl");
		}
	}

}