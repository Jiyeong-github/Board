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
		//detail.jsp에서 0이 넘어오면 등록, 아니면 ?

		CmtVO param = new CmtVO();
		param.setCmt(cmt);
		param.setIuser(iuser);
		//iuser는 등록(값 넣기위해) 수정(해당 사용자가 맞는지) 시 반드시 넣기
		
		if (icmt != 0) { //수정
			param.setIcmt(icmt);
			CmtDAO.upCmt(param);
		} else { //등록
			param.setIboard(iboard);
			CmtDAO.insCmt(param);
		}
		
		response.sendRedirect("detail?iboard=" + iboard);
	}

}
