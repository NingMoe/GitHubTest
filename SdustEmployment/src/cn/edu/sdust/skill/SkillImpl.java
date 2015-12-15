package cn.edu.sdust.skill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.sdust.tool.DbUtils;
import cn.edu.sdust.tool.StuQuery;

public class SkillImpl implements SkillInterface {
	
	private static int size = 13;
	
	public List<StuQuery> getAllConmmSkill(int currentPage) { // 就业技巧查询
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int currentPage_1 = (currentPage - 1) * size;
		List<StuQuery> stuQuerys = new ArrayList<StuQuery>();
		try {
			conn = DbUtils.getConnection();
			// System.out.println("ok");
			// 3.发送sequel语句，并执行
			if (currentPage_1 == 0)
				sql = "select top " + size + " * from ConmmSkill Order by CSTop,CSReleaseTime";
			else
				sql = "select top " + size
						+ " * from ConmmSkill where CSId not in(select top "
						+ currentPage_1 + " CSId from ConmmSkill) Order by CSTop,CSReleaseTime";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StuQuery stuQuery = new StuQuery();
				stuQuery.setiD(rs.getString("CSId"));
				stuQuery.setTitle(rs.getString("CSTitle"));
				stuQuery.setReleaseTime(rs.getString("CSReleaseTime"));
				stuQuery.setTop(rs.getString("CSTop"));
				stuQuerys.add(stuQuery);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeResult(rs);
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();

		}
		return stuQuerys;
	}
	
	public StuQuery getAllConmmSkillByID(String ID) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int PV = 0;
		StuQuery stuQuery = new StuQuery();
		try {
			conn = DbUtils.getConnection();
			// System.out.println("ok");
			// 3.发送sequel语句，并执行
			sql = "select CSPV from ConmmSkill where CSId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				PV = rs.getInt("CSPV") + 1;
			}
			sql = "update ConmmSkill set CSPV=? where CSId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, PV);
			pstmt.setString(2, ID);
			pstmt.executeUpdate();
			sql = "select * from ConmmSkill where CSId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				stuQuery.setTitle(rs.getString("CSTitle"));
				stuQuery.setAuthor(rs.getString("CSAuthor"));
				stuQuery.setOrigin(rs.getString("CSOrgin"));
				stuQuery.setReleaseTime(rs.getString("CSReleaseTime"));
				stuQuery.setContent(rs.getString("CSContent"));
				stuQuery.setPv(rs.getInt("CSPV"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.closeResult(rs);
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();

		}
		return stuQuery;
	}

}
