package com.koreait.board5.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/user/logout")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession hs = request.getSession();
		hs.invalidate(); // 전체 삭제
		// hs.setAttribute("loginUser", null); 부분 삭제
		// hs.removeAttribute(""); 이것도 전체삭제
		response.sendRedirect("login");
	}

}
