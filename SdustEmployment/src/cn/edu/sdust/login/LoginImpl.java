package cn.edu.sdust.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.sdust.register.Enterprise;
import cn.edu.sdust.tool.DbUtils;

public class LoginImpl implements LoginInterface {
	
	public boolean Login(Login login){
		Connection conn = null;
		String sql = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbUtils.getConnection();
			// 3.发送sql语句，并执行
			if (login.getLoginbtn().equals("student")) {
				sql = "select * from StudentUser where StudentName=? and StudentPW=?";
			}else{
				sql = "select * from EnUser where EnterUserName=? and EnterprisePW=?";
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, login.getUserName());
			pstmt.setString(2, login.getPassWord());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();
		}
		return false;
	}
	
	public boolean Update(Login login,String newPass){
		Connection conn = null;
		String sql = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbUtils.getConnection();
			// 3.发送sql语句，并执行
			if (login.getLoginbtn().equals("student")) {
				sql = "select * from StudentUser where StudentName=? and StudentPW=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, login.getUserName());
				pstmt.setString(2, login.getPassWord());
				rs = pstmt.executeQuery();
				if (rs.next()) {
					sql = "Update StudentUser set StudentPW=? where StudentName=? ";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, newPass);
					pstmt.setString(2, login.getUserName());
					pstmt.executeUpdate();
					return true;
				}else{
					return false;
				}
			}else{
				sql = "select * from EnUser where EnterUserName=? and EnterprisePW=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, login.getUserName());
				pstmt.setString(2, login.getPassWord());
				rs = pstmt.executeQuery();
				if (rs.next()) {
					sql = "Update EnUser set EnterprisePW=? where EnterUserName=? ";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, newPass);
					pstmt.setString(2, login.getUserName());
					pstmt.executeUpdate();
					return true;
				}else{
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();
		}
		return false;
	}
	
	public boolean ifResume(String studentNum){
		Connection conn = null;
		String sql = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbUtils.getConnection();
			// 3.发送sql语句，并执行
			sql = "select Resume from StudentInfo where StudentNum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, studentNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getBoolean("Resume");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();
		}
		return false;
	}
	
	public Enterprise getAllEncontactByUserName(String userName){
		Connection conn = null;
		String sql = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Enterprise enterprise = new Enterprise();
		try {
			conn = DbUtils.getConnection();
			// 3.发送sql语句，并执行
			sql = "select * from EnContact,EnUser where EnContact.EnterpriseId=EnUser.EnterpriseId and EnUser.EnterUserName='"+userName+"'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				
				enterprise.setEnterpriseAttn(rs.getString("EnterpriseAttn"));
				enterprise.setEnterprisePhone(rs.getString("EnterprisePhone"));
				enterprise.setFaxNum(rs.getString("FaxNumber"));
				enterprise.setEnterpriseZip(rs.getString("EnterpriseZip"));
				enterprise.setEnterpriseEmail(rs.getString("EnterpriseEmail"));
				enterprise.setPostalAddress(rs.getString("PostalAddress"));
				enterprise.setEnterprisePost(rs.getString("EnterprisePost"));
				enterprise.setPhoneNum(rs.getString("PhoneNum"));
				enterprise.setEnterpriseIndex(rs.getString("EnterpriseIndex"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();
		}
		return enterprise;
	}
	
	public boolean UpdateRegister(Enterprise enterprise,String userName){
		Connection conn = null;
		String sql = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbUtils.getConnection();
			// 3.发送sql语句，并执行
			sql = "Update EnContact,EnUser set EnterpriseAttn=?,EnterprisePhone=?,FaxNumber=?,EnterpriseZip=?,EnterpriseEmail=?,PostalAddress=?,EnterprisePost=?," +
					"PhoneNum=?,EnterpriseIndex=? where EnContact.EnterpriseId=EnUser.EnterpriseId and EnUser.EnterUserName='"+userName+"'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, enterprise.getEnterpriseAttn());
			pstmt.setString(2, enterprise.getEnterprisePhone());
			pstmt.setString(3, enterprise.getFaxNum());
			pstmt.setString(4, enterprise.getEnterpriseZip());
			pstmt.setString(5, enterprise.getEnterpriseEmail());
			pstmt.setString(6, enterprise.getPostalAddress());
			pstmt.setString(7, enterprise.getEnterprisePost());
			pstmt.setString(8, enterprise.getPhoneNum());
			pstmt.setString(9, enterprise.getEnterpriseIndex());
			pstmt.executeUpdate();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();
		}
		return false;
	}
}
