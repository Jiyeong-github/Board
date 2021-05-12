package com.koreait.board4.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.MyUtils;
import com.koreait.board4.user.UserVO;

@WebServlet("/board/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO) hs.getAttribute("loginUser");
		// 로그인 성공 시 board/list로 긔긔
		// 안 되면 로그인 화면으로 이동
		// set한 적 없는데 get하면 null로 나옴

		if (loginUser == null) {//로그아웃 상태면 로그인 페이지로 이동
			response.sendRedirect("/user/login");
			return;
		}
		
		List<BoardVO> list=BoardDAO.selBoardList();
		request.setAttribute("list", list);
		
		
		//로그인했으면 board/list.jsp 파일 응답
		MyUtils.openJSP("board/list", request, response);
		
//		Boolean loginSuccess = (Boolean) hs.getAttribute("loginSucces");
//		// 대문자로 시작하는 건 랩퍼 클래스 (기능이 좀 다른 Boolean)
//		if (loginSuccess == null) {
//			response.sendRedirect("/user/login");
//			return;
//		}

//		MyUtils.openJSP("board/list", request, response);
	}

//list는 post를 사용하지 않는다.

}
