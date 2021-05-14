package com.koreaitr.board5.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;

@WebServlet("/board/del")
public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			BoardVO vo=new BoardVO();
			int iuser = MyUtils.getLoginUserPK(request);
			
			vo.setIuser(iuser);
			vo.setIboard();
			
			MyUtils.openJSP("board/del", request, response);
		
	}

}
