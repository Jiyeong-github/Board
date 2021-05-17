package com.koreait.board5.cmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board5.DBUtils;

public class CmtDAO {
	public static void insCmt(CmtVO param) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = " INSERT INTO t_board_cmt(iboard, iuser, cmt) VALUES(?,?,?) ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.setInt(1, param.getIboard());
			ps.setInt(2, param.getIuser());
			ps.setString(3, param.getCmt());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}

	public static List<CmtVO> selCmtList(int iboard) {

		List<CmtVO> list = new ArrayList();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT A.icmt, A.cmt, A.regdt, B.unm, B.iuser " + " FROM t_board_cmt A "
				+ " INNER JOIN t_user B " + " ON A.iuser = B.iuser " + " WHERE iboard = ? ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs = ps.executeQuery();

			while (rs.next()) {

				CmtVO vo = new CmtVO();

				vo.setIcmt(rs.getInt("icmt"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setCmt(rs.getString("cmt"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setUnm(rs.getString("unm"));
				vo.setIuser(rs.getInt("iuser"));

				list.add(vo);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}

		return list;
	}

	public static int delCmt(CmtVO vo) {

		Connection con = null;
		PreparedStatement ps = null;

		String sql = " DELETE FROM t_board_cmt WHERE icmt=? AND iuser=? ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getIcmt());
			ps.setInt(2, vo.getIuser());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.close(con, ps);
		}

		return 0;
	}

	public static int upCmt(CmtVO vo) {
		return 0;

	}
}
