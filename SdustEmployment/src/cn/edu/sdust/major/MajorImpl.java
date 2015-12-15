package cn.edu.sdust.major;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.sdust.tool.DbUtils;

public class MajorImpl implements MajorInterface {
	
	private static int majorSize = 20;
	
	public List<MajorInfo> getAllMajorInfo(int currentPage) { // 专业介绍
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int currentPage_1 = (currentPage - 1) * majorSize;
		List<MajorInfo> majorInfos = new ArrayList<MajorInfo>();
		try {
			conn = DbUtils.getConnection();
			// System.out.println("ok");
			// 3.发送sequel语句，并执行
			if (currentPage_1 == 0)
				sql = "select top " + majorSize + " * from MajorInfo";
			else
				sql = "select top " + majorSize
						+ " * from MajorInfo where MajorId not in(select top "
						+ currentPage_1 + " MajorId from MajorInfo)";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MajorInfo majorInfo = new MajorInfo();
				majorInfo.setMajorId(rs.getString("MajorId"));
				majorInfo.setMajorName(rs.getString("MajorName"));
				majorInfos.add(majorInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.closeResult(rs);
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();

		}
		return majorInfos;
	}
	
	public List<MajorInfo> getAllMajorInfoByCondition(String major){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = null;
		List<MajorInfo> majorInfos = new ArrayList<MajorInfo>();
		try {
			conn = DbUtils.getConnection();
			// System.out.println("ok");
			// 3.发送sequel语句，并执行
			sql = "select * from MajorInfo where MajorName like'%"+major+"%'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MajorInfo majorInfo = new MajorInfo();
				majorInfo.setMajorId(rs.getString("MajorId"));
				majorInfo.setMajorName(rs.getString("MajorName"));
				majorInfo.setMajorReleaseTime(rs.getString("MajorReleaseTime"));
				majorInfo.setMajorIntro(rs.getString("MajorIntro"));
				majorInfos.add(majorInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.closeResult(rs);
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();

		}
		return majorInfos;
	}

	public MajorInfo getAllMajorInfoByID(String ID) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = null;
		MajorInfo majorInfo = new MajorInfo();
		try {
			conn = DbUtils.getConnection();
			// System.out.println("ok");
			// 3.发送sequel语句，并执行
			sql = "select * from MajorInfo where MajorId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				majorInfo.setMajorName(rs.getString("MajorName"));
				majorInfo.setMajorReleaseTime(rs.getString("MajorReleaseTime"));
				majorInfo.setMajorIntro(rs.getString("MajorIntro"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.closeResult(rs);
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();

		}
		return majorInfo;
	}
}
