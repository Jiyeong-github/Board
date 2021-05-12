package com.koreait.board4.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board4.DBUtils;

public class BoardDAO {
	public static int insBoard(BoardVO param) {

		Connection con = null;
		PreparedStatement ps = null;

		String sql = " INSERT INTO t_board(title,ctnt,iuser) VALUES(?,?,?) ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getIuser());

			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}

		return 0;
	}

	public static List<BoardVO> selBoardList() {

		List<BoardVO> list = new ArrayList();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT A.iboard, A.title, A.iuser, A.regdt, B.unm " + " FROM t_board A " + " LEFT JOIN t_user B "
				+ " ON A.iuser = B.iuser " + " ORDER BY A.iboard DESC ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); // return type이 result set임

			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setTitle(rs.getString("title"));
				vo.setIboard(rs.getInt("iboard"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setUnm(rs.getString("unm"));

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

	public static BoardVO selBoard(int iboard) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO vo = null;

		String sql = " SELECT A.title, A.iuser, A.regdt, A.ctnt, B.unm " + " FROM t_board A " + " LEFT JOIN t_user B "
				+ " ON A.iuser = B.iuser " + " WHERE iboard = ? ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs = ps.executeQuery();

			if (rs.next()) {

				String title = rs.getString("title");
				String ctnt = rs.getString("ctnt");
				String regdt = rs.getString("regdt");
				int iuser = rs.getInt("iuser");
				String unm = rs.getString("unm");
				// () 안에 컬럼명 집어넣기

				vo = new BoardVO();
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setCtnt(ctnt);
				vo.setRegdt(regdt);
				vo.setUnm(unm);
				vo.setIuser(iuser);

				return vo;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return vo;
		} finally {
			DBUtils.close(con, ps, rs);
		}

		return null;
	}

	public static int upBoard(BoardVO vo) {

		Connection con = null;
		PreparedStatement ps = null;

		String sql = " UPDATE t_board SET title =?, ctnt = ? WHERE iboard=? ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIboard());

			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, null);
		}
		return 0;
	}

	public static int delBoard(BoardVO vo) {

		Connection con = null;
		PreparedStatement ps = null;

		String sql = " DELETE FROM t_board WHERE iboard = ? AND iuser = ? ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.setInt(1, vo.getIboard());
			ps.setInt(2, vo.getIuser());

			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}

		return 0;
	}
}
