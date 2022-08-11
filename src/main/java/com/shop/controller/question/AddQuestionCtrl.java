package com.shop.controller.question;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.QuestionVO;
import com.shop.model.QuestionDAO;

@WebServlet("/AddQuestionCtrl")
public class AddQuestionCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddQuestionCtrl() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8" );
		
		String qtitle = request.getParameter("qtitle");
		String qcontent = request.getParameter("qcontent");
		String u_id = request.getParameter("u_id");
		
		QuestionVO vo = new QuestionVO();
		vo.setQtitle(qtitle);
		vo.setQcontent(qcontent);
		vo.setU_id(u_id);
		
		QuestionDAO dao = new QuestionDAO();
		int cnt = dao.addQuestion(vo);
		if(cnt>0) {
			response.sendRedirect("GetQuestionListCtrl");
		} else {
			response.sendRedirect("./question/addQuestion.jsp");
		}
		
	}

}
