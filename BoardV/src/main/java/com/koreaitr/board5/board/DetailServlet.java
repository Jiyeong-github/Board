package com.koreaitr.board5.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;
import com.koreait.board5.cmt.CmtDAO;

@WebServlet("/board/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BoardVO vo = new BoardVO();
		
		int iboard = MyUtils.getParamInt("iboard", request);
		vo.setIboard(iboard);
		
		int iuser = MyUtils.getLoginUserPK(request);
		vo.setIuser(iuser);
		
		BoardVO data = BoardDAO.selBoard(vo); 
		request.setAttribute("data", data); //글의 정보

		request.setAttribute("cmtList", CmtDAO.selCmtList(iboard)); //댓글 리스트 정보
		MyUtils.openJSP("board/detail", request, response);
	}

}
