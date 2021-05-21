package com.koreait.board6.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.koreait.board6.MyUtils;
import com.koreait.board6.board.BoardDAO;
import com.koreait.board6.board.BoardVO;

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MyUtils.openJSP("디테일", "board/detail", request, response);
		BoardVO vo = new BoardVO();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// post는 AJAX로 보내는 용도
		int iboard = MyUtils.getParamInt("iboard", request);
		System.out.println("iboard:" + iboard);

		BoardVO param = new BoardVO();
		param.setIboard(iboard);

		BoardVO result = BoardDAO.selBoard(param);

		PrintWriter pw = response.getWriter();
		Gson gson = new Gson();
		String json = gson.toJson(result);
		System.out.println(json);
		
		pw.append(json);
		
		/*
		pw.append("{\"iboard\":");
		pw.append(String.valueOf(result.getIboard()));
		pw.append(",\"title\":")
		.append("\"")
		.append(result.getTitle())
		.append("\",\"ctnt\":\"")
		.append(result.getCtnt())
		.append("\"}");
		
		System.out.println(pw);
		*/
		// ={"iboard":28, "title:"안녕 어쩌고~}
	}

}
