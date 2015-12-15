package cn.edu.sdust.enterprise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.sdust.register.Enterprise;
import cn.edu.sdust.tool.DbUtils;

public class EnterpriseSearchImpl implements EnterpriseSearchInterface {
	
	private static int size = 13;
	
	public List<Enterprise> EnterSearch(int currentPage,Enterprise enterprise){
		Connection conn = null;
		String sql = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Enterprise> enterprises = new ArrayList<Enterprise>();
		int currentPage_1 = (currentPage - 1) * size;
		try {
			conn = DbUtils.getConnection();
			if(enterprise.getEnterpriseAddress()!=""){
				sql = sql + " and EnterpriseAddress like'%"+enterprise.getEnterpriseAddress()+"%'";
			}
			if(enterprise.getEnterpriseEmpNum()!=""){
				sql = sql + " and EnterpriseEmpNum='"+enterprise.getEnterpriseEmpNum()+"'";
			}
			if(enterprise.getEnterpriseName()!=""){
				sql = sql + " and EnterpriseName like'%"+enterprise.getEnterpriseName()+"%'";
			}
			if(enterprise.getEnterpriseRegCap()!=""){
				sql = sql + " and EnterpriseRegCap='"+enterprise.getEnterpriseRegCap()+"'";
			}
			if(enterprise.getEnterpriseProp()!=""){
				sql = sql + " and EnterpriseProp='"+enterprise.getEnterpriseProp()+"'";
			}
			if(currentPage==1){
				sql = "select top "+size+" * from Enterprise where 1=1"+sql;
			}else{
				sql = "select top "
						+ size 
						+" * from Enterprise where EnterpriseId not in(select top "
						+ currentPage_1 +" EnterpriseId from Enterprise)"+sql;
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Enterprise enterprise_1 = new Enterprise();
				enterprise_1.setEnterpriseId(rs.getString("EnterpriseId"));
				enterprise_1.setEnterpriseName(rs.getString("EnterpriseName"));
				enterprise_1.setEnterpriseProp(rs.getString("EnterpriseProp"));
				enterprise_1.setEnterpriseAddress(rs.getString("EnterpriseAddress"));
				enterprise_1.setEnterpriseRegCap(rs.getString("EnterpriseRegCap"));
				enterprise_1.setEnterpriseEmpNum(rs.getString("EnterpriseEmpNum"));
				enterprises.add(enterprise_1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.closeResult(rs);
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();
		}
		return enterprises;
	}
	
	public Enterprise EnterSearchById(String enterpriseId){
		Connection conn = null;
		String sql = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Enterprise enterprise = new Enterprise();
		try {
			conn = DbUtils.getConnection();
			// System.out.println("ok");
			// 3.∑¢ÀÕsequel”Ôæ‰£¨≤¢÷¥––
			sql = "select * from Enterprise,EnContact where EnContact.EnterpriseId=Enterprise.EnterpriseId and Enterprise.EnterpriseId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, enterpriseId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				enterprise.setEnterpriseName(rs.getString("EnterpriseName"));
				enterprise.setEnterpriseRegtime(rs.getString("EnterpriseRegtime"));
				enterprise.setEnterpriseIndus(rs.getString("EnterpriseIndus"));
				enterprise.setEnterpriseProp(rs.getString("EnterpriseProp"));
				enterprise.setEnterpriseAddress(rs.getString("EnterpriseAddress"));
				enterprise.setEnterpriseRegCap(rs.getString("EnterpriseRegCap"));
				enterprise.setEnterpriseEmpNum(rs.getString("EnterpriseEmpNum"));
				enterprise.setEnterpriseBrief(rs.getString("EnterpriseBrief"));
				enterprise.setEnterpriseAttn(rs.getString("EnterpriseAttn"));
				enterprise.setEnterprisePhone(rs.getString("EnterprisePhone"));
				enterprise.setEnterpriseZip(rs.getString("EnterpriseZip"));
				enterprise.setEnterpriseEmail(rs.getString("EnterpriseEmail"));
				enterprise.setPostalAddress(rs.getString("PostalAddress"));
				enterprise.setEnterprisePost(rs.getString("EnterprisePost"));
				enterprise.setPhoneNum(rs.getString("PhoneNum"));
				enterprise.setEnterpriseIndex(rs.getString("EnterpriseIndex"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeResult(rs);
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();
		}
		return enterprise;
	}
	
	public static int getAllEnterCountPage(Enterprise enterprise){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql ="";
		int countPage = 0;
		try {
			conn = DbUtils.getConnection();
			if(enterprise.getEnterpriseAddress()!=""){
				sql = sql + " and EnterpriseAddress like'%"+enterprise.getEnterpriseAddress()+"%'";
			}
			if(enterprise.getEnterpriseEmpNum()!=""){
				sql = sql + " and EnterpriseEmpNum='"+enterprise.getEnterpriseEmpNum()+"'";
			}
			if(enterprise.getEnterpriseName()!=""){
				sql = sql + " and EnterpriseName like'%"+enterprise.getEnterpriseName()+"%'";
			}
			if(enterprise.getEnterpriseRegCap()!=""){
				sql = sql + " and EnterpriseRegCap='"+enterprise.getEnterpriseRegCap()+"'";
			}
			if(enterprise.getEnterpriseProp()!=""){
				sql = sql + " and EnterpriseProp='"+enterprise.getEnterpriseProp()+"'";
			}
			sql = "SELECT COUNT(*) as total FROM Enterprise where 1=1"+sql;
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
	
	public static int getAllEnterCountRecord(Enterprise enterprise){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql ="";
		int count = 0;
		try {
			conn = DbUtils.getConnection();
			if(enterprise.getEnterpriseAddress()!=""){
				sql = sql + " and EnterpriseAddress like'%"+enterprise.getEnterpriseAddress()+"%'";
			}
			if(enterprise.getEnterpriseEmpNum()!=""){
				sql = sql + " and EnterpriseEmpNum='"+enterprise.getEnterpriseEmpNum()+"'";
			}
			if(enterprise.getEnterpriseName()!=""){
				sql = sql + " and EnterpriseName like'%"+enterprise.getEnterpriseName()+"%'";
			}
			if(enterprise.getEnterpriseRegCap()!=""){
				sql = sql + " and EnterpriseRegCap='"+enterprise.getEnterpriseRegCap()+"'";
			}
			if(enterprise.getEnterpriseProp()!=""){
				sql = sql + " and EnterpriseProp='"+enterprise.getEnterpriseProp()+"'";
			}
			sql = "SELECT COUNT(*) as total FROM Enterprise where 1=1"+sql;
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
