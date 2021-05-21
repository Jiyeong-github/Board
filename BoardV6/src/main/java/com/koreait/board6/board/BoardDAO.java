package com.koreait.board6.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board6.DBUtils;

public class BoardDAO {
	
	public static int getAllPage(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT ceil(COUNT(*) / ?) as cnt FROM t_board WHERE title LIKE ? ";
		
		int result = 0;
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getPage());
			ps.setString(2, "%"+param.getSearch()+"%");
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return result;
	}

	public static int insBoard(BoardVO param) {

		Connection con = null;
		PreparedStatement ps = null;

		String sql = " INSERT INTO t_board(title, ctnt, iuser) VALUES (?,?,?) ";

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

	public static BoardVO selBoard(BoardVO param) {  //(int iboard)
		//BoardVO result = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT B.unm, A.iboard, A.title, A.ctnt, A.iuser, A.regdt "
				+" ,if(C.iboard IS NULL, 0, 1) AS isFav "
				+" FROM t_board A  INNER JOIN t_user B "
				+" ON A.iuser = B.iuser LEFT JOIN t_board_fav C "
				+" ON A.iboard = C.iboard AND C.iuser = ? WHERE A.iboard = ? LIMIT ?,? ";
				

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setString(1,"%"+param.getSearch()+"%");
			ps.setInt(2,param.getIuser());
			ps.setInt(3, param.getIboard());
			
			//parameter로 받았단 뜻은 set이나 get을 했단 말
			rs = ps.executeQuery();
			
			
			if (rs.next()) {
				
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				String unm = rs.getString("unm");
				String ctnt = rs.getString("ctnt");
				int iuser = rs.getInt("iuser");
				int iboard = rs.getInt("iboard");
				int isfav = rs.getInt("isFav");
				
				BoardVO vo = new BoardVO();
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
				vo.setCtnt(ctnt);
				vo.setUnm(unm);
				vo.setIuser(iuser);
				vo.setIsFav(isfav);
				
				return vo;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}

		return null;

	}

	public static List<BoardVO> selBoardList(BoardVO param) {

		List<BoardVO> list = new ArrayList();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "  SELECT A.iboard, A.title, A.regdt, A.iuser, B.unm " + " FROM t_board A "
				+ "	INNER JOIN t_user B " + " ON A.iuser = B.iuser " + " WHERE A.title LIKE ? ORDER BY A.iboard DESC LIMIT ?,? ";
		// SQL문은 안에 있등가 말등가 상관 없음

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, "%"+param.getSearch()+"%");
			ps.setInt(2, param.getsIdx());
			ps.setInt(3, param.getPage());
			rs = ps.executeQuery();

			while (rs.next()) {
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				String unm = rs.getString("unm");
				int iuser = rs.getInt("iuser");
				int iboard = rs.getInt("iboard");

				BoardVO vo = new BoardVO();
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
				vo.setUnm(unm);
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

	public static int delBoard(BoardVO param) {

		Connection con = null;
		PreparedStatement ps = null;

		String sql = " DELETE FROM t_board WHERE iboard = ? AND iuser = ? ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.setInt(1, param.getIboard());
			ps.setInt(2, param.getIuser());

			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}

		return 0;
	}

	public static int upBoard(BoardVO param) {

		Connection con = null;
		PreparedStatement ps = null;

		String sql = " UPDATE t_board SET title=? , ctnt = ? WHERE iboard = ? ";

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
		}

		return 0;
	}
	
}
