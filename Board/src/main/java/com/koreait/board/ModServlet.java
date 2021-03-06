package com.koreait.board;

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

		BoardVO vo = BoardDAO.selBoard(Integer.parseInt(request.getParameter("iboard")));
		request.setAttribute("data", vo);
		request.getRequestDispatcher("WEB-INF/jsp/mod.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");

		BoardVO vo = new BoardVO();
		vo.setCtnt(ctnt);
		vo.setTitle(title);
		vo.setIboard(Integer.parseInt(request.getParameter("iboard")));
	
		BoardDAO.updateBoard(vo);
		response.sendRedirect("/detail?iboard="+request.getParameter("iboard"));
	}

}
