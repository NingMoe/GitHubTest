package cn.edu.sdust.officebearer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.sdust.tool.DbUtils;
import cn.edu.sdust.tool.StuQuery;

public class OfficeBearerImpl implements OfficeBearerInterface {
	
	private static int size = 13;
	
	public List<StuQuery> getAllOfficeBearer(int currentPage) { // 公务员报考查询
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
				sql = "select top " + size + " * from OfficeBearer Order by OBETop,OBEReleaseTime";
			else
				sql = "select top " + size
						+ " * from OfficeBearer where OBEId not in(select top "
						+ currentPage_1 + " OBEId from OfficeBearer) Order by OBETop,OBEReleaseTime";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StuQuery stuQuery = new StuQuery();
				stuQuery.setiD(rs.getString("OBEId"));
				stuQuery.setTitle(rs.getString("OBETitle"));
				stuQuery.setReleaseTime(rs.getString("OBEReleaseTime"));
				stuQuery.setTop(rs.getString("OBETop"));
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

	public StuQuery getAllOfficeBearerByID(String ID) {
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
			sql = "select OBEPV from OfficeBearer where OBEId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				PV = rs.getInt("OBEPV") + 1;
			}
			sql = "update OfficeBearer set OBEPV=? where OBEId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, PV);
			pstmt.setString(2, ID);
			pstmt.executeUpdate();
			sql = "select * from OfficeBearer where OBEId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				stuQuery.setTitle(rs.getString("OBETitle"));
				stuQuery.setAuthor(rs.getString("OBEAuthor"));
				stuQuery.setOrigin(rs.getString("OBEOrgin"));
				stuQuery.setReleaseTime(rs.getString("OBEReleaseTime"));
				stuQuery.setContent(rs.getString("OBEContent"));
				stuQuery.setPv(rs.getInt("OBEPV"));
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
