package com.koreait.board7;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board7.MyUtils;
import com.koreait.board7.user. UserEntity;

public class MyUtils {
	public static  UserEntity getLoginUser(HttpServletRequest req) {
		if (req == null) {return null;}
		HttpSession hs = req.getSession();
		return (UserEntity) hs.getAttribute("loginUser");
	}

	public static int getLoginUserPK(HttpServletRequest req) {
		if(req == null) {return 0;}
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

	public static void openJSP(String title, String jsp, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setAttribute("title", title);
		req.setAttribute("jsp", jsp);
		String temp = "/WEB-INF/view/template.jsp";
		req.getRequestDispatcher(temp).forward(req, res);

	}
}
