package com.koreait.board4.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.MyUtils;
import com.koreait.board4.user.UserVO;
import com.mysql.cj.Session;

@WebServlet("/board/write")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MyUtils.openJSP("board/write", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// 제목, 내용, 글쓴이 pk값을 BoardVO 객체에 담기

	
		HttpSession hs = request.getSession();
		UserVO loginUser=(UserVO)hs.getAttribute("loginUser");
		int iUser=loginUser.getIuser();
		
		BoardVO vo = new BoardVO();
		vo.setTitle(request.getParameter("title"));
		vo.setCtnt(request.getParameter("ctnt"));
		vo.setIuser(iUser);
		
		BoardDAO.insBoard(vo);
		
		response.sendRedirect("list");
	}

}
