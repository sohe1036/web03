package com.shop.controller.question;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.QuestionVO;
import com.shop.model.QuestionDAO;

@WebServlet("/GetQuestionCtrl")
public class GetQuestionCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetQuestionCtrl() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int qno = Integer.parseInt(request.getParameter("qno"));
		QuestionDAO dao = new QuestionDAO();
		QuestionVO question = new QuestionVO();
		question = dao.getQuestion(qno);
		
		if(question !=null) {
			request.setAttribute("question", question);
			RequestDispatcher view = request.getRequestDispatcher("./question/getQuestion.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("GetQuestionListCtrl");
		}
	}

}
