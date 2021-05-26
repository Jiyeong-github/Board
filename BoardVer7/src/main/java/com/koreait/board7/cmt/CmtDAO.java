package com.koreait.board7.cmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board7.DBUtils;

public class CmtDAO {
	public static int insCmt(CmtEntity param) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;

		String sql = " INSERT INTO t_board_cmt(iboard,iuser,cmt) VALUES(?,?,?) ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			ps.setInt(2, param.getIuser());
			ps.setString(3, param.getCmt());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return result;
	}

	public static List<CmtDomain> selCmtList(CmtEntity param) {

		List<CmtDomain> list = new ArrayList();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " select A.icmt, A.cmt, A.regdt, " + " B.iuser, B.unm AS writerNm "
				+ "from t_board_cmt A INNER JOIN t_user B " 
				+ " ON A.iuser = B.iuser WHERE A.iboard = ?; "
				+ " ORDER BY icmt DESC ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			rs = ps.executeQuery();

			while (rs.next()) {
				CmtDomain vo = new CmtDomain();
				list.add(vo);

				vo.setIcmt(rs.getInt("icmt"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setCmt(rs.getString("cmt"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setWriterNm(rs.getString("writerNm"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}

		return list;

	}
}