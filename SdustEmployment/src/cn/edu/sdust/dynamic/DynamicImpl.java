package cn.edu.sdust.dynamic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.sdust.tool.DbUtils;
import cn.edu.sdust.tool.StuQuery;

public class DynamicImpl implements DynamicInterface {
	
	private static int size = 13;
	
	public List<StuQuery> getAllEmpDynamic(int currentPage) { // 就业动态查询
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
				sql = "select top " + size + " * from EmpDynamic Order by EDTop,EDReleaseTime";
			else
				sql = "select top " + size
						+ " * from EmpDynamic where EDId not in(select top "
						+ currentPage_1 + " EDId from EmpDynamic) Order by EDTop,EDReleaseTime";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StuQuery stuQuery = new StuQuery();
				stuQuery.setiD(rs.getString("EDId"));
				stuQuery.setTitle(rs.getString("EDTitle"));
				// stuQuery.setAuthor(rs.getString("EDAuthor"));
				stuQuery.setOrigin(rs.getString("EDOrgin"));
				stuQuery.setReleaseTime(rs.getString("EDReleaseTime"));
				// stuQuery.setContent(rs.getString("EDContent"));
				stuQuery.setTop(rs.getString("EDTop"));
				// stuQuery.setPv(rs.getInt("EDPV"));
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

	public StuQuery getAllEmpDynamicByID(String ID) {
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
			sql = "select EDPV from EmpDynamic where EDId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				PV = rs.getInt("EDPV") + 1;
			}
			sql = "update EmpDynamic set EDPV=? where EDId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, PV);
			pstmt.setString(2, ID);
			pstmt.executeUpdate();
			sql = "select * from EmpDynamic where EDId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// stuQuery.setiD(rs.getString("EDId"));
				stuQuery.setTitle(rs.getString("EDTitle"));
				stuQuery.setAuthor(rs.getString("EDAuthor"));
				stuQuery.setOrigin(rs.getString("EDOrgin"));
				stuQuery.setReleaseTime(rs.getString("EDReleaseTime"));
				stuQuery.setContent(rs.getString("EDContent"));
				//stuQuery.setTop(rs.getString("EDTop"));
				stuQuery.setPv(rs.getInt("EDPV"));
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
