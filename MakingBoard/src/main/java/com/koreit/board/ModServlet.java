package com.koreit.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod")
public class ModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BoardVO vo = BoardDAO.selBoard(Integer.parseInt(request.getParameter("iboard"))); // 예전 값 가꼬옴
		request.setAttribute("data", vo);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String title=request.getParameter("title"); 
		String ctnt=request.getParameter("ctnt");
		//쿼리스트링 형식으로 받을 때는 무조건 이거
		int iboard=Integer.parseInt(request.getParameter("iboard"));
		
		BoardVO vo=new BoardVO();
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		vo.setIboard(iboard);
		
		BoardDAO.upBoard(vo);
		
		response.sendRedirect("/detail?iboard="+iboard);
		
	}

}
