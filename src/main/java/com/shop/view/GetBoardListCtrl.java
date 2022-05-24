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

@WebServlet("/GetBoardListCtrl")
public class GetBoardListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetBoardListCtrl() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDAO dao = new BoardDAO();		//DAO새로운 객체 생성
		ArrayList<BoardVO> list =  dao.getBoradList();		//리턴된 리스트객체에 BoardDAO 메서드입력
		request.setAttribute("list", list);					// 변수명, 객체명
		RequestDispatcher view = request.getRequestDispatcher("./board/getBoardList.jsp");		//리스트 보낼 곳 지정
		view.forward(request, response);				//보냄
				
	}

}
