package com.koreait.board5.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board5.MyUtils;

@WebServlet("/user/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		MyUtils.openJSP("/user/join", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String unm = request.getParameter("unm");
		String upw = request.getParameter("upw");
		int gender = MyUtils.getParamInt("igender", request);

		String hashedUpw = BCrypt.hashpw(upw, BCrypt.gensalt());

		UserVO vo = new UserVO();
		vo.setUid(request.getParameter("uid"));
		vo.setUpw(hashedUpw);
		vo.setUnm(unm);
		vo.setGender(gender);

		UserDAO.joinUser(vo);
		response.sendRedirect("login");
	}

}
