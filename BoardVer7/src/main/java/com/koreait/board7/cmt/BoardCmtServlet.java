package com.koreait.board7.cmt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.koreait.board7.MyUtils;

@WebServlet("/board/cmt")
public class BoardCmtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 리스트
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int iboard = MyUtils.getParamInt("iboard", request);
		System.out.println("iboard:" + iboard);
		CmtEntity param = new CmtEntity();
		param.setIboard(iboard);

		List<CmtDomain> list = CmtDAO.selCmtList(param);
		Gson gson= new Gson();
		String json = gson.toJson(list);
		System.out.println("json:"+json);
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter()
		.append(json);
		
		/*
		String json = " [ ";
		for (int i = 0; i < list.size(); i++) {
			String item = "{";
			
			CmtDomain vo = list.get(i);
			
			item +="\"icmt\":";
			item += vo.getIcmt();
			
			item +="\"iboard\":";
			item += vo.getIboard();
			
			item += "},";
			json += item;
		}
		json +="]";
	*/
		
	}

	// 등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int iboard = MyUtils.getParamInt("iboard", request);
		int iuser = MyUtils.getLoginUserPK(request);
		String cmt = request.getParameter("cmt");

		CmtEntity param = new CmtEntity();
		param.setIboard(iboard);
		param.setIuser(iuser);
		param.setCmt(cmt);

		int result = CmtDAO.insCmt(param);
		response.getWriter()
		.append("{")
		.append("\"result\":")
		.append(String.valueOf(result))
		.append("}")
		.flush();
		//결과 : {"result":1}
	}

}
