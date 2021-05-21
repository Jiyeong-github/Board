package com.koreait.board6;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board6.MyUtils;
import com.koreait.board6.user.UserVO;

public class MyUtils {
	
	public static UserVO getLoginUser(HttpServletRequest req) {
		if (req == null) {return null;}
		HttpSession hs = req.getSession();
		return (UserVO) hs.getAttribute("loginUser");
	}

	public static int getLoginUserPK(HttpServletRequest req) {
		return getLoginUser(req).getIuser();
	}

	public static int parseStringToInt(String val) {
		try {
			int result = Integer.parseInt(val);
			return result;
		} catch (Exception e) {
			return 0;
		}
	}

	public static int getParamInt(String key, HttpServletRequest req) {
		// String key는 매개변수
		String val = req.getParameter(key);
		int intVal = MyUtils.parseStringToInt(val);
		return intVal;

	}

	public static void openJSP(String title, String fileNM, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setAttribute(Const.TITLE, title);
		req.setAttribute(Const.PAGE, fileNM);
		String jsp = "/WEB-INF/view/template.jsp";
		req.getRequestDispatcher(jsp).forward(req, res);
		
	}
}
