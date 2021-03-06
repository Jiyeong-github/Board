package com.koreait.board;

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

			return ps.executeUpdate(); //쿼리문 실행

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

				vo.setIboard(rs.getInt(iboard));
				vo.setCtnt(rs.getString("ctnt"));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString("redt"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return null;
	}

	public static List<BoardVO> SelBoardList() {
		List<BoardVO> list = new ArrayList();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT iboard, title, regdt FROM t_board ORDER BY iboard DESC ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO();
				list.add(vo);

				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString("regdt"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return list;
	}
	
	public static int updateBoard(BoardVO param) {
		
		Connection con=null;
		PreparedStatement ps=null;
		
		String sql= " UPDATE t_board SET title=? , ctnt =? WHERE iboard=? ";
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getIboard());
			
			return ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	
public static int delBoard(BoardVO param) {
		
		Connection con=null;
		PreparedStatement ps=null;
		
		String sql= " DELETE FROM t_board WHERE iboard=? ";
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, param.getIboard());
			
			return ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
}
