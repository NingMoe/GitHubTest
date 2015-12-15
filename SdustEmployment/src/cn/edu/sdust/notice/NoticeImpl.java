package cn.edu.sdust.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.sdust.tool.DbUtils;
import cn.edu.sdust.tool.StuQuery;

public class NoticeImpl implements NoticeInterface {
	
	private static int size = 13;
	
	public List<StuQuery> getAllNotice(int currentPage) { // 公告信息
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
				sql = "select top " + size + " * from Notice";
			else
				sql = "select top " + size
						+ " * from Notice where NoticeId not in(select top "
						+ currentPage_1 + " NoticeId from Notice)";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StuQuery stuQuery = new StuQuery();
				stuQuery.setiD(rs.getString("NoticeId"));
				stuQuery.setTitle(rs.getString("NoticeTitle"));
				stuQuery.setReleaseTime(rs.getString("NoticeReleaseTime"));
				stuQuery.setAuthor(rs.getString("NoticeAuthor"));
				stuQuery.setOrigin(rs.getString("NoticeOrgin"));
				stuQuery.setContent(rs.getString("NoticeContent"));
				stuQuery.setTop(rs.getString("NoticeTop"));
				stuQuery.setPv(rs.getInt("NoticePV"));
			
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

	public StuQuery getAllNoticeByID(String ID) {
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
			sql = "select NoticePV from Notice where NoticeId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				PV = rs.getInt("NoticePV") + 1;
			}
			sql = "update Notice set NoticePV=? where NoticeId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, PV);
			pstmt.setString(2, ID);
			pstmt.executeUpdate();
			sql = "select * from Notice where NoticeId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				stuQuery.setTitle(rs.getString("NoticeTitle"));
				stuQuery.setAuthor(rs.getString("NoticeAuthor"));
				stuQuery.setOrigin(rs.getString("NoticeOrgin"));
				stuQuery.setReleaseTime(rs.getString("NoticeReleaseTime"));
				stuQuery.setContent(rs.getString("NoticeContent"));
				stuQuery.setPv(rs.getInt("NoticePV"));
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
