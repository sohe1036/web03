package com.shop.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.BoardVO;
import com.shop.model.BoardDAO;

@WebServlet("/GetBoardSearchCtrl")
public class GetBoardSearchCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetBoardSearchCtrl() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String condition = request.getParameter("searchCondition");		//searchCondition의 값을 파라미터로가져와
		String keyword = request.getParameter("searchKeyword");			//searchKeyword의 값을 파라미터로 가져와
		
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> list = dao.getConditionSerach(condition, keyword);			//리턴된 list에 DAO의 매개변수값 받아와
		
		request.setAttribute("list", list);
		RequestDispatcher view = request.getRequestDispatcher("./board/getBoardList.jsp");
		view.forward(request, response);
		
	}

}
