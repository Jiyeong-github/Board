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


@WebServlet("/board/del")
public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO vo=new BoardVO();
		
		int iuser = MyUtils.getLoginUserPK(request);
		
		vo.setIuser(iuser);
		vo.setIboard(MyUtils.getParamInt("iboard", request));
		
		int result = BoardDAO.delBoard(vo);
		
		if (result == 0) {
			response.sendRedirect("/board/detail?iboard=" + request.getParameter("iboard"));
			return;
		}
		
		response.sendRedirect("/board/list");
	}
}
