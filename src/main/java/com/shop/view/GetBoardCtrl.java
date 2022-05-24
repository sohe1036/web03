package com.shop.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.BoardVO;
import com.shop.model.BoardDAO;

@WebServlet("/GetBoardCtrl")
public class GetBoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetBoardCtrl() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int num = Integer.parseInt(request.getParameter("num")) ;		//보낸 seq를 변수num을 받아
		BoardDAO dao = new BoardDAO();		//DAO선언
		BoardVO board = new BoardVO();
		board = dao.getBoard(num);		//리턴된 board에 메서드(매개변수)입력
		
		if(board != null) {				//board에 값이 있다면
			request.setAttribute("board", board);		//값을 담아서
			RequestDispatcher view = request.getRequestDispatcher("./board/getBoard.jsp");		//보낼경로입력
			view.forward(request, response);			//전송
		}else {
			response.sendRedirect("GetBoardListCtrl");
		}
	}

}
