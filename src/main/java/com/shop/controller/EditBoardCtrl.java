package com.shop.controller;

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
		request.setCharacterEncoding("UTF-8");
		int seq = Integer.parseInt(request.getParameter("seq"));		//조건에 필요
		String title = request.getParameter("title");				//폼에 입력한 정보 받아옴
		String content = request.getParameter("content");	
		int cnt = 0;
		
		BoardDAO dao = new BoardDAO();	 //DAO선언
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		vo.setTitle(title);
		vo.setContent(content);
		cnt = dao.editBoard(vo);			//리턴값 cnt에 메서드(매개변수)입력

		if(cnt>0) {
			response.sendRedirect("/web03/GetBoardListCtrl");	//수정성공	
		}else {
			response.sendRedirect("/web03/GetBoardCtrl?num="+seq);  //수정실패-GetBoardCtrl은 num필요
		}
		
	}

}
