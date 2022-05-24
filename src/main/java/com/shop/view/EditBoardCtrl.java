package com.shop.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.BoardVO;
import com.shop.model.BoardDAO;

@WebServlet("/EditBoardCtrl")
public class EditBoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditBoardCtrl() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF*8");
		
		int num = Integer.parseInt(request.getParameter("num"));		//리턴받은 cnt를 num에저장
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String name = request.getParameter("name");
		
		BoardDAO dao = new BoardDAO();
		
		if()) {
			
		}
		
	}

}
