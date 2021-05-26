package com.koreait.board7.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board7.DBUtils;

public class BoardDAO {

	public static int selPagingCnt(BoardDTO param) {

		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT CEIL(COUNT(iboard)/?) ")
		.append(" FROM t_board A ")
		.append(" INNER JOIN t_user B ")
		.append(" ON A.iuser = B.iuser ");

		if(param.getSearchType()>0) {
			sb.append(" WHERE ");
		}
		
		switch (param.getSearchType()) {
		case 1: //제목+내용
			sb.append("A.title LIKE '%")
			.append(param.getSearchText())
			.append("%' OR A.ctnt LIKE '%")
			.append(param.getSearchText())
			.append("%'");
			break;
		case 2: //제목
			sb.append("A.title LIKE '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
		case 3: //내용
			sb.append("A.ctnt LIKE '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
		case 4: //글쓴이
			sb.append("B.unm LIKE '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
		}
		
	//String sql = " SELECT CEIL(COUNT(iboard) / ?) FROM t_board ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sb.toString());
			ps.setInt(1, param.getRecordCnt());
			rs = ps.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}

		return 0;

	}

	public static List<BoardDomain> selBoardList(BoardDTO param) {

		List<BoardDomain> list = new ArrayList();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "  SELECT A.iboard, A.title, A.regdt, A.iuser, B.unm as writerNm" 
		+ " FROM t_board A " + " INNER JOIN t_user B " 
		+ " ON A.iuser = B.iuser ";
		// SQL문은 안에 있등가 말등가 상관 없음

		switch (param.getSearchType()) {
		case 1: //제목+내용
			sql += String.format(" WHERE A.title Like '%%%s%%' "
					+ " OR A.ctnt LIKE '%%%s%% ", param.getSearchText(),
					param.getSearchText());
			break;
		case 2: //제목
			sql += String.format(" WHERE A.title LIKE '%%%s%%'",
					param.getSearchText());
			break;
		case 3: //내용
			sql += String.format(" WEHRE A.ctnt LIKE '%%%s%%' ", param.getSearchText());
			break;
		case 4: //글쓴이
			sql += " WEHRE B.unm LIKE '% " + param.getSearchText() + " %' ";
			break;
		}
		
		sql += " ORDER BY iboard DESC " + " LIMIT ?,? ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getStartIdx());
			ps.setInt(2, param.getRecordCnt());

			rs = ps.executeQuery();

			while (rs.next()) {
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				String writerNm = rs.getString("writerNm");
				int iuser = rs.getInt("iuser");
				int iboard = rs.getInt("iboard");

				BoardDomain vo = new BoardDomain();
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
				vo.setWriterNm(writerNm);
				vo.setIuser(iuser);

				list.add(vo);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return null;
	}
	
	public static BoardDomain selBoard(BoardDTO param) {
		
		BoardDomain result = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "  SELECT A.iboard, A.title, A.regdt, A.iuser, A.ctnt, "
				+ " B.unm as writerNm " 
				+ " FROM t_board A " + " INNER JOIN t_user B " 
				+ " ON A.iuser = B.iuser WHERE A.iboard = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = new BoardDomain();
				result.setIboard(param.getIboard());
				result.setTitle(rs.getString("title"));
				result.setCtnt(rs.getString("ctnt"));
				result.setIuser(rs.getInt("iuser"));
				result.setWriterNm(rs.getString("writerNm"));
				result.setRegdt(rs.getString("regdt"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
