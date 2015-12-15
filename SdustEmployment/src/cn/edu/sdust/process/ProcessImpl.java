package cn.edu.sdust.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.sdust.tool.DbUtils;
import cn.edu.sdust.tool.StuQuery;

public class ProcessImpl implements ProcessInterface {
	
	private static int size = 13;
	
	public List<StuQuery> getAllJSP(int currentPage) { 

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
				sql = "select top " + size + " * from JSP Order by JSPTop,JSPReleaseTime";
			else
				sql = "select top " + size
						+ " * from JSP where JSPId not in(select top "
						+ currentPage_1 + " JSPId from JSP) Order by JSPTop,JSPReleaseTime";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StuQuery stuQuery = new StuQuery();
				stuQuery.setiD(rs.getString("JSPId"));
				stuQuery.setTitle(rs.getString("JSPTitle"));
				// stuQuery.setAuthor(rs.getString("JSPAuthor"));
				// stuQuery.setOrigin(rs.getString("JSPOrgin"));
				stuQuery.setReleaseTime(rs.getString("JSPReleaseTime"));
				// stuQuery.setContent(rs.getString("JSPContent"));
				stuQuery.setTop(rs.getString("JSPTop"));
				// stuQuery.setPv(rs.getInt("JSPPV"));
				stuQuerys.add(stuQuery);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.closeResult(rs);
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();

		}
		return stuQuerys;
	}

	public StuQuery getAllJSPByID(String ID) { // 就业流程查询
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
			sql = "select JSPPV from JSP where JSPId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				PV = rs.getInt("JSPPV") + 1;
			}
			sql = "update JSP set JSPPV=? where JSPId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, PV);
			pstmt.setString(2, ID);
			pstmt.executeUpdate();
			sql = "select * from JSP where JSPId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				stuQuery.setiD(rs.getString("JSPId"));
				stuQuery.setTitle(rs.getString("JSPTitle"));
				stuQuery.setAuthor(rs.getString("JSPAuthor"));
				stuQuery.setOrigin(rs.getString("JSPOrgin"));
				stuQuery.setReleaseTime(rs.getString("JSPReleaseTime"));
				stuQuery.setContent(rs.getString("JSPContent"));
				stuQuery.setTop(rs.getString("JSPTop"));
				stuQuery.setPv(rs.getInt("JSPPV"));
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
