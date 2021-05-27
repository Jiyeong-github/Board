package com.koreait.board7.user;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.MyUtils;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/user/mypage")
public class UserMypage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * 로그인 성공 시 이미지 값이 null이라면 UserEntity loginUser = MyUtils.getLoginUser(request);
		 * //loginServlet에서 받았던 주소값을 다시 받아 옴. request.setAttribute("user",
		 * UserDAO.selUser(loginUser));
		 */

		MyUtils.openJSP("마이페이지", "user/mypage", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String uploadpath = request.getRealPath("/res/img/");
		String uploadpath = request.getServletContext().getRealPath("/res/img");
		int maxFileSize = 10_485_760; // 10*1024*1024
		MultipartRequest multi = new MultipartRequest(request, uploadpath + "/temp", maxFileSize, "UTF-8",
				new DefaultFileRenamePolicy());
		/*
		 * 어플리케이션 ServletContext context = request.getServletContext(); String path =
		 * context.getRealPath("/");
		 */

		int loginUserPk = MyUtils.getLoginUserPK(request);
		String targetFolder = uploadpath + " /user/ " + loginUserPk;
		File folder = new File(targetFolder);
		if (!folder.exists()) {// false면 true 있으면 지나친다...? 먼솔?
			folder.mkdirs(); // mkdir은 폴더 하나만 만들 수 있음
		}

		String fileNm = multi.getFilesystemName("profileImg");
		System.out.println("fileNm:" + fileNm);
		
		
		int lastDotIdx = fileNm.lastIndexOf(".");
		String ext = fileNm.substring(lastDotIdx+1); //확장자 구함
		//substring은 자르기. 1) 인자 하나 2) 인자 둘
		// String ex2 = fileNm.substring(fileNm.lastIndexOf(".")+1);
		
		String newFileNm = UUID.randomUUID().toString()+ext;
		
		File imgFile = new File(uploadpath + "/temp" + "/" + fileNm); //파일로 객체 생성
		imgFile.renameTo(new File(targetFolder + "/" + newFileNm +ext)); //"파일명"에 newFileNm 넣어줌
		
	}

}
