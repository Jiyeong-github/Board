package com.koreit.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	public static int insertBoard(BoardVO vo) {

		Connection con = null;
		PreparedStatement ps = null;

		String sql = " INSERT INTO t_board(title,ctnt) VALUES(?,?) ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());

			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}

	public static BoardVO selBoard(int iboard) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT*FROM t_board WHERE iboard=? ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, iboard);
			rs = ps.executeQuery();

			if (rs.next()) {
				BoardVO vo = new BoardVO();

				int Iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String ctnt = rs.getString("ctnt");
				String regdt = rs.getString("regdt");

				vo.setCtnt(ctnt);
				vo.setIboard(Iboard);
				vo.setRegdt(regdt);
				vo.setTitle(title);
				
				return vo;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return null;
	}

	public static List<BoardVO> selBoardList() {

		List<BoardVO> list = new ArrayList();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT title, ctnt, regdt FROM t_board ORDER BY iboard DESC ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				BoardVO data = new BoardVO();

				data.setTitle(rs.getString("title"));
				data.setCtnt(rs.getString("ctnt"));
				data.setRegdt(rs.getString("regdt"));

				list.add(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return list;
	}
	
	public static int delBoard(BoardVO vo) {

		Connection con = null;
		PreparedStatement ps = null;

		String sql = " DELETE FROM t_board WHERE iboard=? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);

			
			ps.setInt(1, vo.getIboard());
			
			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	
	public static int upBoard(BoardVO vo) {

		Connection con = null;
		PreparedStatement ps = null;

		String sql = " UPDATE t_board SET title=? , ctnt=? WHERE iboard=? ";
		
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
			DBUtils.close(con, ps);
		}
		return 0;
	}
}
