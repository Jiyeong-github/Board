package com.koreait.board7.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board7.MyUtils;

@WebServlet("/user/login")

public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MyUtils.openJSP("로그인", "user/login", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");

		UserEntity param = new UserEntity();
		param.setUid(uid);

		UserEntity result = UserDAO.selUser(param); // 빼내서 쓸 거다

		if (result == null) {// 아이디 없음
			request.setAttribute("errMsg", "아이디를 확인해주세요");
		}else if(BCrypt.checkpw(upw, result.getUpw())) {
			//아이디 있음&비밀번호 체크 성공
			result.setUpw(null);
			HttpSession hs = request.getSession();
			hs.setAttribute("loginUser", result);
			response.sendRedirect("/board/list");
			return;
		} else {//비밀번호 틀림
			request.setAttribute("errMsg", "비밀번호를 확인해주세요");
	
		doGet(request, response); // 무조건 리퀘스트로 값 전달을 함
		// response.sendRedirect("login?err="+result); //호출하는 순간 주소값 이동

	}
	}

}
