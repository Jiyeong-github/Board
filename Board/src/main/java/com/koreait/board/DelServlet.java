package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/del")
public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		
		BoardVO param=new BoardVO();
		param.setIboard(Integer.parseInt(iboard));
		
		BoardDAO.delBoard(param);
		
		response.sendRedirect("/list");
		
	}
}