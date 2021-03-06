package com.koreait.board5.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board5.MyUtils;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MyUtils.openJSP("user/login", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");

		UserVO param = new UserVO();
		param.setUid(uid);

		UserVO result = UserDAO.selUser(param);
		
		if (result == null) { // 아이디 없음

			request.setAttribute("errMSG", "아이디를 확인해 주세요.");

		} else if (BCrypt.checkpw(upw, result.getUpw())) { // 아이디 O & 비밀번호 체크

			result.setUpw(null); // 비밀번호가 없으니까 NULL값 줌
			HttpSession hs = request.getSession(); //session에다 머 담으면 로그인땜시 ㅎ
			hs.setAttribute("loginUser", result);
			response.sendRedirect("/board/list");
			return;
		} else { // 비밀번호 틀림
			request.setAttribute("errMSG", "비밀번호를 확인해 주세요.");
		}
		doGet(request, response);
		
	}
}
