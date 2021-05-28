package com.koreait.board7.user;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.MyFileUtils;
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
		// String uploadpath = request.getRealPath("/res/img/");
		/*
		 * ServletContext application = request.getServletContext(); - application도 set
		 * get attribute가 있다. 단 한 개만 만들어지고 공용임 application.getRealPath("");
		 */

		// 무식하지만 간단한 방법

		String uploadpath = request.getServletContext().getRealPath("/res/img");
		// getServletContext().getRealPath - > application 주소값 리턴
		int maxFileSize = 10_485_760; // 10*1024*1024(10mb)

		try {
			MultipartRequest multi = new MultipartRequest(request, uploadpath + "/temp", maxFileSize, "UTF-8",
					new DefaultFileRenamePolicy());
			String fileNm = multi.getFilesystemName("profileImg");
			System.out.println("fileNm:" + fileNm);

			if (fileNm == null) {
				doGet(request, response);
				return;
			}
			/*
			 * 어플리케이션 ServletContext context = request.getServletContext(); String path =
			 * context.getRealPath("/");
			 */

			// UserEntity loginUser = MyUtils.getLoginUser(request);
			int loginUserPk = MyUtils.getLoginUserPK(request);// = loginUser.getIuser();

			String targetFolder = uploadpath + "/user/" + loginUserPk;
			MyFileUtils.delFolder(targetFolder);
			File folder = new File(targetFolder);
			folder.mkdirs();
			

			/*
			 * File folder = new File(targetFolder); folder.delete(); //이거 하고 에러터지면 exists
			 * folder 해주기 - 안에 파일있으면 안 지워짐 folder.mkdirs(); if (!folder.exists()) {// false면
			 * true 있으면 지나친다...? 먼솔? folder.mkdirs(); // mkdir은 폴더 하나만 만들 수 있음 }
			 */

			int lastDotIdx = fileNm.lastIndexOf(".");
			String ext = fileNm.substring(lastDotIdx); // 확장자 구함
			// substring은 자르기. 1) 인자 하나 2) 인자 둘
			// String ex2 = fileNm.substring(fileNm.lastIndexOf(".")+1);

			String newFileNm = UUID.randomUUID().toString() + ext;

			System.out.println("from : "+targetFolder+ "/temp/" + fileNm);
			System.out.println("to : "+uploadpath  + "/" + newFileNm);
			
			File imgFile = new File(uploadpath+ "/temp/" + fileNm); // () 안의 값에 존재하는 파일을 가져옴
			imgFile.renameTo(new File(targetFolder  + "/" + newFileNm)); // "파일명"에 newFileNm 넣어줌

			UserEntity param = new UserEntity();
			MyUtils.getLoginUser(request).setProfileImg(newFileNm);
			param.setIuser(loginUserPk);
			param.setProfileImg(newFileNm);

			UserDAO.updUser(param);


		} catch (Exception e) {
			e.printStackTrace();
		}
		doGet(request, response);

	}

}
