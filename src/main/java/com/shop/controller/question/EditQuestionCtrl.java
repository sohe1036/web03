package com.shop.controller.question;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.QuestionVO;
import com.shop.model.QuestionDAO;

@WebServlet("/EditQuestionCtrl")
public class EditQuestionCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditQuestionCtrl() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8" );
		
		int qno = Integer.parseInt(request.getParameter("qno"));
		String acontent = request.getParameter("acontent");
		int ano = Integer.parseInt(request.getParameter("qno"));
		String adate = request.getParameter("adate");
		
		QuestionVO vo = new QuestionVO();
		vo.setQno(qno);
		vo.setAcontent(acontent);
		vo.setAno(ano);
		vo.setAdate(adate);
		
		QuestionDAO dao = new QuestionDAO();
		int cnt = dao.answerAdd(vo);
		
		if(cnt>0) {
			response.sendRedirect("GetQuestionListCtrl");
		}else {
			response.sendRedirect("UpdateQuestionCtrl?qno="+qno);
		}
	}

}
