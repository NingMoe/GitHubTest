package cn.edu.sdust.locality;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.sdust.tool.DbUtils;
import cn.edu.sdust.tool.StuQuery;

public class LocalityImpl implements LocalityInterface {
	
	private static int size = 13;
	
	public List<StuQuery> getAllLocality(int currentPage) { // 基层就业查询
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
				sql = "select top " + size + " * from Locality Order by GRETop,GREReleaseTime";
			else
				sql = "select top " + size
						+ " * from Locality where GREId not in(select top "
						+ currentPage_1 + " GREId from Locality) Order by GRETop,GREReleaseTime";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StuQuery stuQuery = new StuQuery();
				stuQuery.setiD(rs.getString("GREId"));
				stuQuery.setTitle(rs.getString("GRETitle"));
				stuQuery.setReleaseTime(rs.getString("GREReleaseTime"));
				stuQuery.setTop(rs.getString("GRETop"));
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

	public StuQuery getAllLocalityByID(String ID) {
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
			sql = "select GREPV from Locality where GREId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				PV = rs.getInt("GREPV") + 1;
			}
			sql = "update Locality set GREPV=? where GREId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, PV);
			pstmt.setString(2, ID);
			pstmt.executeUpdate();
			sql = "select * from Locality where GREId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				stuQuery.setTitle(rs.getString("GRETitle"));
				stuQuery.setAuthor(rs.getString("GREAuthor"));
				stuQuery.setOrigin(rs.getString("GREOrgin"));
				stuQuery.setReleaseTime(rs.getString("GREReleaseTime"));
				stuQuery.setContent(rs.getString("GREContent"));
				stuQuery.setPv(rs.getInt("GREPV"));
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
