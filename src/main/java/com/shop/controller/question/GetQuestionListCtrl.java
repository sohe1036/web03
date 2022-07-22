package com.shop.controller.question;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.QuestionVO;
import com.shop.model.QuestionDAO;

@WebServlet("/GetQuestionListCtrl")
public class GetQuestionListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetQuestionListCtrl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		QuestionDAO qna = new QuestionDAO();
		ArrayList<QuestionVO> qvo = qna.getQuestionList();
		request.setAttribute("qvo", qvo);
		RequestDispatcher view = request.getRequestDispatcher("./question/getQuestionList.jsp");
		view.forward(request, response);
	}

}
