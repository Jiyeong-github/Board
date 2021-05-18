package com.koreait.board5.cmt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;

@WebServlet("/board/regCmt")
public class CmtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 삭제 시 사용할 예정
		int iboard = MyUtils.getParamInt("iboard", request);
		int icmt = MyUtils.getParamInt("icmt", request);
		int iuser = MyUtils.getLoginUserPK(request);

		CmtVO param = new CmtVO();
		param.setIcmt(icmt);
		param.setIuser(iuser);

		CmtDAO.delCmt(param);
		CmtDAO.upCmt(param);

		response.sendRedirect("detail?iboard=" + iboard);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmt = request.getParameter("regCmt");
		int iboard = MyUtils.getParamInt("iboard", request);
		int iuser = MyUtils.getLoginUserPK(request);
		int icmt = MyUtils.getParamInt("icmt", request);

		CmtVO param = new CmtVO();
		param.setCmt(cmt);
		param.setIuser(iuser);
		
		if (icmt != 0) {
			param.setIcmt(icmt);
			CmtDAO.upCmt(param);
		} else {
			param.setIboard(iboard);
			CmtDAO.insCmt(param);
		}
		
		response.sendRedirect("detail?iboard=" + iboard);
	}

}
