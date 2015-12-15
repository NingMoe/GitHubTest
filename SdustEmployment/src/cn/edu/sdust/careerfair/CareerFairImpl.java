package cn.edu.sdust.careerfair;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.sdust.tool.DbUtils;

public class CareerFairImpl implements CareerFairInterface {
	
	
	private static int size = 13;
	
	public List<CareerFair> getAllCareerFair(int currentPage,CareerFair careerFair_c){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "";
		int currentPage_1 = (currentPage - 1) * size;
		List<CareerFair> careerFairs = new ArrayList<CareerFair>();
		try {
			conn = DbUtils.getConnection();
			if(careerFair_c.getcFClassfy()!=""){
				sql = sql+" and CFClassfy='"+careerFair_c.getcFClassfy()+"'";
			}
			if(careerFair_c.getcFStartTime()!=""){
				sql = sql+" and CFStartTime >= #"+careerFair_c.getcFStartTime()+"#";
			}
			if(careerFair_c.getcFStartTime1()!=""){
				sql = sql+" and CFStartTime <= #"+careerFair_c.getcFStartTime1()+"#";
			}
			if(careerFair_c.getCfStartPlace()!=""){
				sql = sql+" and CFStartPlace like'%"+careerFair_c.getCfStartPlace()+"%'";
			}
			if (currentPage_1 == 0)
				sql = "select top " + size + " * from CareerFair where CFPassed=true"+sql+" order by CFTop,CFReleaseTime DESC";
			else
				sql = "select top " + size
						+ " * from CareerFair where CFPassed=true and CFId not in(select top "
						+ currentPage_1 + " CFId from CareerFair)"+sql+" order by CFTop,CFReleaseTime DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CareerFair careerFair = new CareerFair();
				careerFair.setcfID(rs.getString("CFId"));
				careerFair.setcFTitle(rs.getString("CFTitle"));
				careerFair.setcFReleaseTime(rs.getString("CFReleaseTime"));
				careerFair.setcFClassfy(rs.getString("CFClassfy"));
				careerFair.setcFTop(rs.getString("CFTop"));
				careerFairs.add(careerFair);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.closeResult(rs);
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();

		}
		return careerFairs;
	}
	
	public CareerFair getAllCareerFairByID(String ID){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int PV = 0;
		CareerFair careerFair = new CareerFair();
		try {
			conn = DbUtils.getConnection();
			// System.out.println("ok");
			// 3.·¢ËÍsequelÓï¾ä£¬²¢Ö´ÐÐ
			sql = "select CFPV from CareerFair where CFId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				PV = rs.getInt("CFPV") + 1;
			}
			sql = "update CareerFair set CFPV=? where CFId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, PV);
			pstmt.setString(2, ID);
			pstmt.executeUpdate();
			sql = "select * from CareerFair where CFId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				careerFair.setcFTitle(rs.getString("CFTitle"));
				careerFair.setcFPublisher(rs.getString("CFPublisher"));
				careerFair.setcFReleaseTime(rs.getString("CFReleaseTime"));
				careerFair.setcFStartTime(rs.getString("CFStartTime"));
				careerFair.setcFClassfy(rs.getString("CFClassfy"));
				careerFair.setCfStartPlace(rs.getString("CFStartPlace"));
				careerFair.setcFEnterprises(rs.getString("CFEnterprises"));
				careerFair.setcFEligibility(rs.getString("CFEligibility"));
				careerFair.setcFThing(rs.getString("CFThing"));
				careerFair.setcFPassed(rs.getString("CFPassed"));
				//careerFair.setcFTop(rs.getString("CFTop"));
				careerFair.setcFPV(rs.getString("CFPV"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.closeResult(rs);
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();

		}
		return careerFair;
	}
	public static int getAllCFCountPage(CareerFair careerFair_c){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql ="";
		int countPage = 0;
		try {
			conn = DbUtils.getConnection();
			if(careerFair_c.getcFClassfy()!=""){
				sql = sql+" and CFClassfy='"+careerFair_c.getcFClassfy()+"'";
			}
			if(careerFair_c.getcFStartTime()!=""){
				sql = sql+" and CFStartTime >= #"+careerFair_c.getcFStartTime()+"#";
			}
			if(careerFair_c.getcFStartTime1()!=""){
				sql = sql+" and CFStartTime <= #"+careerFair_c.getcFStartTime1()+"#";
			}
			if(careerFair_c.getCfStartPlace()!=""){
				sql = sql+" and CFStartPlace like'%"+careerFair_c.getCfStartPlace()+"%'";
			}
			sql = "SELECT COUNT(*) as total FROM CareerFair where CFPassed=true"+sql;
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
	
	public static int getAllCFCountRecord(CareerFair careerFair_c){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql ="";
		int count = 0;
		try {
			conn = DbUtils.getConnection();
			if(careerFair_c.getcFClassfy()!=""){
				sql = sql+" and CFClassfy='"+careerFair_c.getcFClassfy()+"'";
			}
			if(careerFair_c.getcFStartTime()!=""){
				sql = sql+" and CFStartTime >= #"+careerFair_c.getcFStartTime()+"#";
			}
			if(careerFair_c.getcFStartTime1()!=""){
				sql = sql+" and CFStartTime <= #"+careerFair_c.getcFStartTime1()+"#";
			}
			if(careerFair_c.getCfStartPlace()!=""){
				sql = sql+" and CFStartPlace like'%"+careerFair_c.getCfStartPlace()+"%'";
			}
			sql = "SELECT COUNT(*) as total FROM CareerFair where CFPassed=true"+sql;
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
