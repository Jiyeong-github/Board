package com.koreait.board4.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.MyUtils;

@WebServlet("/board/mod")
public class ModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//
//		int iuser = MyUtils.getLoginUserPK();
//		int iboard = MyUtils.getParamInt("iboard", request);
//
//		if (iuser == 0) {
//			response.sendRedirect("/board/detail?iboard=" + request.getParameter("iboard"));
//			return;8
//		}

		BoardVO data = BoardDAO.selBoard(MyUtils.getParamInt("iboard", request));
		MyUtils.openJSP("board/mod", request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int iboard = MyUtils.getParamInt("iboard", request);
		
		BoardVO vo = new BoardVO();
		vo.setTitle(request.getParameter("title"));
		vo.setCtnt(request.getParameter("ctnt"));
		vo.setIboard(iboard);

		BoardDAO.upBoard(vo);
		response.sendRedirect("/board/list");
	}

}
