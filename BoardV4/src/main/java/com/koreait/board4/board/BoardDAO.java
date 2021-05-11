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
			ps.setInt(3, param.getIboard());

			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
			;
		}

		return 0;
	}

	public static List<BoardVO> selBoardList() {

		List<BoardVO> list = new ArrayList();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT A.iboard, A.title, A.iuser, A.regdt " + " FROM t_board A " + " LEFT JOIN t_user B "
				+ " ON A.iuser = B.iuser ";
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}

		return null;
	}
}
