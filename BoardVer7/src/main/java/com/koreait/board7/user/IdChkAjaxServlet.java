package com.koreait.board7.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/idChk")
public class IdChkAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid = request.getParameter("uid");
		System.out.println("uid:"+uid);
		int result = UserDAO.selIdChk(uid);
	
		//문자 길면 이거쓰셈 StringBuilder sb = new StringBuilder(); 
		//sb.append("a").append("b").append("c");
		//for문에서는 stringbuilder가 작동 안 한다?
		//퍼포먼스 향상됨
		
	//응답하는 친구	PrintWriter pw = response.getWriter(); 
		response.getWriter()
		.append("{\"result\":")
		.append(String.valueOf(result))
		.append("}")
		.close();
		//append 문자열 합치기
		//{}문자열 안에 \를 주면 된다
		//이렇게 써주면 객체화 가능
		//자기 자신의 주소값 리턴
	}

}
