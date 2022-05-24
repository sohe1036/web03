package com.shop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.BoardVO;
import com.shop.model.BoardDAO;

@WebServlet("/AddBoardSearchCtrl")
public class AddBoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddBoardCtrl() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String name = request.getParameter("name");		//폼에 입력된 값

		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);		
		vo.setName(name);		//입력된 값을 vo에 set
		
		BoardDAO dao = new BoardDAO();	 //DAO선언
		int cnt = dao.addBoard(vo);			//리턴값 cnt에 메서드(매개변수)입력
		
		if(cnt==0) {
			response.sendRedirect("./board/addBoardForm.jsp");
		}else {
			response.sendRedirect("GetBoardListCtrl");
		}
		
	}

}
