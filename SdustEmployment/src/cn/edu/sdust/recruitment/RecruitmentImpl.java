package cn.edu.sdust.recruitment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.sdust.tool.DbUtils;

public class RecruitmentImpl implements RecruitmentInterface {
	
	private static int size = 13;
	
	public List<Recruitment> getAllRecruitment(int currentPage,Recruitment recruitment){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "";
		int currentPage_1 = (currentPage - 1) * size;
		List<Recruitment> recruitments = new ArrayList<Recruitment>();
		try {
			conn = DbUtils.getConnection();
			// System.out.println("ok");
			// 3.发送sequel语句，并执行
			if(recruitment.getRecruitEntName()!=""){
				sql = sql+" and RecruitEntName='"+recruitment.getRecruitEntName()+"'";
			}
			if(recruitment.getRecruitJob()!=""){
				sql = sql+" and RecruitJob='"+recruitment.getRecruitJob()+"'";
			}
			if(recruitment.getRecruitWorkplace()!=""){
				sql = sql+" and RecruitWorkplace like'%"+recruitment.getRecruitWorkplace()+"%'";
			}
			if(recruitment.getRecruitReleaseTime()!=""){
				sql = sql+" and RecruitReleaseTime >= #"+recruitment.getRecruitReleaseTime()+"#";
			}
			if(recruitment.getRecruitReleaseTime1()!=""){
				sql = sql+" and RecruitReleaseTime <= #"+recruitment.getRecruitReleaseTime1()+"#";
			}
			if (currentPage_1 == 0)
				sql = "select top " + size + " * from Recruitment where RecruitPassed=true"+sql+" order by RecruitTop,RecruitReleaseTime";
			else
				sql = "select top " + size
						+ " * from Recruitment where RecruitPassed=true and RecruitId not in(select top "
						+ currentPage_1 + " RecruitId from Recruitment) and"+sql+" order by RecruitTop,RecruitReleaseTime";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Recruitment recruitment1 = new Recruitment();
				recruitment1.setRecruitId(rs.getString("RecruitId"));
				recruitment1.setRecruitTitle(rs.getString("RecruitTitle"));
				recruitment1.setRecruitReleaseTime(rs.getString("RecruitReleaseTime"));
				recruitment1.setRecruitTop(rs.getString("RecruitTop"));
				recruitment1.setRecruitWorkplace(rs.getString("RecruitWorkplace"));
				recruitments.add(recruitment1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.closeResult(rs);
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();

		}
		return recruitments;
	}

	public Recruitment getAllRecruitmentByID(String ID){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int PV = 0;
		Recruitment recruitment = new Recruitment();
		try {
			conn = DbUtils.getConnection();
			// System.out.println("ok");
			// 3.发送sequel语句，并执行
			sql = "select RecruitPV from recruitment where RecruitId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				PV = rs.getInt("RecruitPV") + 1;
			}
			sql = "update recruitment set RecruitPV=? where RecruitId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, PV);
			pstmt.setString(2, ID);
			pstmt.executeUpdate();
			sql = "select * from recruitment where RecruitId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// stuQuery.setiD(rs.getString("EDId"));
				recruitment.setRecruitAuthor(rs.getString("RecruitAuthor"));
				recruitment.setRecruitOrgin(rs.getString("recruitOrgin"));
				recruitment.setRecruitReleaseTime(rs
						.getString("recruitReleaseTime"));
				recruitment.setRecruitContent(rs.getString("recruitContent"));
				recruitment.setRecruitTitle(rs.getString("recruitTitle"));
				recruitment.setRecruitPassed(rs.getString("recruitPassed"));
				recruitment.setRecruitTop(rs.getString("recruitTop"));
				recruitment.setRecruitPV(rs.getString("recruitPV"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.closeResult(rs);
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();

		}
		return recruitment;
	}
	
	public boolean addRecruitment(Recruitment recruitment){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			conn = DbUtils.getConnection();
			sql = "insert into Recruitment(RecruitTitle,RecruitAuthor,RecruitOrgin,RecruitContent,RecruitPublisherType,RecruitPublisherId,RecruitEntName,RecruitJob,RecruitWorkplace) values(?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, recruitment.getRecruitTitle());
			pstmt.setString(2, recruitment.getRecruitAuthor());
			pstmt.setString(3, recruitment.getRecruitOrgin());
			pstmt.setString(4, recruitment.getRecruitContent());
			pstmt.setString(5, "企业");
			pstmt.setInt(6, 1);
			pstmt.setString(7, recruitment.getRecruitEntName());
			pstmt.setString(8, recruitment.getRecruitJob());
			pstmt.setString(9, recruitment.getRecruitWorkplace());
			pstmt.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();
			}
		return false;
	}
	
	public static int getAllrecruitmentCountPage(Recruitment recruitment){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql ="";
		int countPage = 0;
		try {
			conn = DbUtils.getConnection();
			if(recruitment.getRecruitEntName()!=""){
				sql = sql+" and RecruitEntName='"+recruitment.getRecruitEntName()+"'";
			}
			if(recruitment.getRecruitJob()!=""){
				sql = sql+" and RecruitJob='"+recruitment.getRecruitJob()+"'";
			}
			if(recruitment.getRecruitWorkplace()!=""){
				sql = sql+" and RecruitWorkplace like'%"+recruitment.getRecruitWorkplace()+"%'";
			}
			if(recruitment.getRecruitReleaseTime()!=""){
				sql = sql+" and RecruitReleaseTime >= #"+recruitment.getRecruitReleaseTime()+"#";
			}
			if(recruitment.getRecruitReleaseTime1()!=""){
				sql = sql+" and RecruitReleaseTime <= #"+recruitment.getRecruitReleaseTime1()+"#";
			}
			sql = "SELECT COUNT(*) as total FROM Recruitment where RecruitPassed=true"+sql;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt("total");
				countPage = count % size == 0 ? count / size
							: count / size + 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.closeResult(rs);
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();

		}
		return countPage;
	}
	
	public static int getAllrecruitmentCountRecord(Recruitment recruitment){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql ="";
		int count = 0;
		try {
			conn = DbUtils.getConnection();
			if(recruitment.getRecruitEntName()!=""){
				sql = sql+" and RecruitEntName='"+recruitment.getRecruitEntName()+"'";
			}
			if(recruitment.getRecruitJob()!=""){
				sql = sql+" and RecruitJob='"+recruitment.getRecruitJob()+"'";
			}
			if(recruitment.getRecruitWorkplace()!=""){
				sql = sql+" and RecruitWorkplace like'%"+recruitment.getRecruitWorkplace()+"%'";
			}
			if(recruitment.getRecruitReleaseTime()!=""){
				sql = sql+" and RecruitReleaseTime >= #"+recruitment.getRecruitReleaseTime()+"#";
			}
			if(recruitment.getRecruitReleaseTime1()!=""){
				sql = sql+" and RecruitReleaseTime <= #"+recruitment.getRecruitReleaseTime1()+"#";
			}
			sql = "SELECT COUNT(*) as total FROM Recruitment where RecruitPassed=true"+sql;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.closeResult(rs);
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();

		}
		return count;
	}
	
}
