package com.koreait.board5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board5.user.UserVO;

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

	public static void openJSP(String fileNM, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String jsp = "/WEB-INF/view/" + fileNM + ".jsp";
		// 단계로 들어갈 땐 앞의 / 빼면 에러남!
		req.getRequestDispatcher(jsp).forward(req, res);
	}
}
