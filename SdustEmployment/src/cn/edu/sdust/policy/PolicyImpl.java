package cn.edu.sdust.policy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.sdust.tool.DbUtils;
import cn.edu.sdust.tool.StuQuery;

public class PolicyImpl implements PolicyInterface {
	
	private static int size = 13;
	
	public List<StuQuery> getAllEmpPolicy(int currentPage) { // 就业政策查询
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
				sql = "select top " + size + " * from EmpPolicy Order by EPTop,EPReleaseTime";
			else
				sql = "select top " + size
						+ " * from EmpPolicy where EPId not in(select top "
						+ currentPage_1 + " EPId from EmpPolicy) Order by EPTop,EPReleaseTime";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StuQuery stuQuery = new StuQuery();
				stuQuery.setiD(rs.getString("EPId"));
				stuQuery.setTitle(rs.getString("EPTitle"));
				//stuQuery.setAuthor(rs.getString("EPAuthor"));
				//stuQuery.setOrigin(rs.getString("EPOrgin"));
				stuQuery.setReleaseTime(rs.getString("EPReleaseTime"));
				//stuQuery.setContent(rs.getString("EPContent"));
				stuQuery.setTop(rs.getString("EPTop"));
				//stuQuery.setPv(rs.getInt("EPPV"));
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
	
	public StuQuery getAllEmpPolicyByID(String ID) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int epPV = 0;
		StuQuery stuQuery = new StuQuery();
		try {
			conn = DbUtils.getConnection();
			// System.out.println("ok");
			// 3.发送sequel语句，并执行
			sql = "select EPPV from EmpPolicy where EPId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				epPV = rs.getInt("EPPV") + 1;
			}
			sql = "update EmpPolicy set EPPV=? where EPId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, epPV);
			pstmt.setString(2, ID);
			pstmt.executeUpdate();
			sql = "select * from EmpPolicy where EPId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				stuQuery.setiD(rs.getString("EPId"));
				stuQuery.setTitle(rs.getString("EPTitle"));
				stuQuery.setAuthor(rs.getString("EPAuthor"));
				stuQuery.setOrigin(rs.getString("EPOrgin"));
				stuQuery.setReleaseTime(rs.getString("EPReleaseTime"));
				stuQuery.setContent(rs.getString("EPContent"));
				//stuQuery.setTop(rs.getString("EPTop"));
				stuQuery.setPv(rs.getInt("EPPV"));
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
