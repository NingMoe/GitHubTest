package cn.edu.sdust.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.sdust.tool.DbUtils;
import cn.edu.sdust.tool.StuQuery;

public class DataImpl implements DataInterface {
	
	private static int size = 13;
	
	public List<StuQuery> getAllRDData(int currentPage) { // 相关资料查询

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
				sql = "select top " + size + " * from RelatedData Order by RDTop,RDReleaseTime";
			else
				sql = "select top " + size
						+ " * from RelatedData where RDId not in(select top "
						+ currentPage_1 + " RDId from RelatedData) Order by RDTop,RDReleaseTime";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StuQuery stuQuery = new StuQuery();
				stuQuery.setiD(rs.getString("RDId"));
				stuQuery.setTitle(rs.getString("RDTitle"));
				// stuQuery.setAuthor(rs.getString("RDAuthor"));
				// stuQuery.setOrigin(rs.getString("RDOrgin"));
				stuQuery.setReleaseTime(rs.getString("RDReleaseTime"));
				// stuQuery.setContent(rs.getString("RDContent"));
				stuQuery.setTop(rs.getString("RDTop"));
				// stuQuery.setPv(rs.getInt("RDPV"));
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

	public StuQuery getAllRDDataByID(String ID) { // 相关资料查询

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int rdPV = 0;
		StuQuery stuQuery = new StuQuery();
		try {
			conn = DbUtils.getConnection();
			// System.out.println("ok");
			// 3.发送sequel语句，并执行
			sql = "select RDPV from RelatedData where RDId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rdPV = rs.getInt("RDPV") + 1;
			}
			sql = "update RelatedData set RDPV=? where RDId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rdPV);
			pstmt.setString(2, ID);
			pstmt.executeUpdate();
			sql = "select * from RelatedData where RDId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				stuQuery.setiD(rs.getString("RDId"));
				stuQuery.setTitle(rs.getString("RDTitle"));
				stuQuery.setAuthor(rs.getString("RDAuthor"));
				stuQuery.setOrigin(rs.getString("RDOrgin"));
				stuQuery.setReleaseTime(rs.getString("RDReleaseTime"));
				stuQuery.setContent(rs.getString("RDContent"));
				stuQuery.setTop(rs.getString("RDTop"));
				stuQuery.setPv(rs.getInt("RDPV"));
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
