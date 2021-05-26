package com.koreait.board7.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.MyUtils;
import com.koreait.board7.board.BoardDAO;


@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int iboard = MyUtils.getParamInt("iboard", request);
		
		BoardDTO param = new BoardDTO();
		param.setIboard(iboard);
		
		request.setAttribute("data", BoardDAO.selBoard(param)); //글의 정보
		MyUtils.openJSP( "리스트","board/detail" , request, response);
	}
}
