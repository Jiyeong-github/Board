package com.koreait.board7.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board7.DBUtils;
import com.koreait.board7.board.BoardEntity;

public class BoardDAO {
	public List<BoardDomain> selBoardList() {

		List<BoardDomain> list = new ArrayList();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "  SELECT A.iboard, A.title, A.regdt, A.iuser, B.unm as writerNm" + " FROM t_board A "
				+ "	INNER JOIN t_user B " + " ON A.iuser = B.iuser " + " ORDER BY A.iboard DESC ";
		// SQL문은 안에 있등가 말등가 상관 없음

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
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
}
