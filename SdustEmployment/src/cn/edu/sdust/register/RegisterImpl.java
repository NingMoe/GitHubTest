package cn.edu.sdust.register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.sdust.tool.DbUtils;

public class RegisterImpl implements RegisterInterface {
	
	public boolean StuRegister(Student student) { // 学生注册
		Connection conn = null;
		String sql = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbUtils.getConnection();
			// 3.发送sql语句，并执行
			sql = "select StudentNum from StudentInfo where StudentNum=? and StudentName=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student.getStudentNum());
			pstmt.setString(2, student.gettName());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String StudentNum = rs.getString("StudentNum");
				sql = "insert into StudentUser values(?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, StudentNum);
				pstmt.setString(2, student.getUserName());
				pstmt.setString(3, student.getPassWord());
				pstmt.executeUpdate();
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

	public boolean EnRegister(Enterprise enterReg) { // 企业注册
		Connection conn = null;
		String sql = null;
		String sql_0 =null;
		String sql_1 = null;
		String sql_2 = null;
		String sql_3 = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String EnterpriseId=null;
		try {
			conn = DbUtils.getConnection();
			// 3.发送sql语句，并执行
			sql = "insert into EnUser(EnterUserName,EnterprisePW) values(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, enterReg.getEnUserName());
			pstmt.setString(2, enterReg.getEnPassWord());
			pstmt.executeUpdate();
			sql_0 = "select EnterpriseId from EnUser where EnterUserName=?";
			pstmt = conn.prepareStatement(sql_0);
			pstmt.setString(1, enterReg.getEnUserName());
			rs = pstmt.executeQuery();
			if(rs.next()){
				EnterpriseId = rs.getString("EnterpriseId");
			}
			sql_1 = "insert into Enterprise(EnterpriseName,EnterpriseRegtime,EnterpriseIndus,EnterpriseProp,EnterpriseEmpNum,EnterpriseRegCap,EnterpriseAddress,EnterpriseBrief,EnterpriseId) " +
					"values(?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql_1);
			pstmt.setString(1, enterReg.getEnterpriseName());
			pstmt.setString(2, enterReg.getEnterpriseRegtime());
			pstmt.setString(3, enterReg.getEnterpriseIndus());
			pstmt.setString(4, enterReg.getEnterpriseProp());
			pstmt.setString(5, enterReg.getEnterpriseEmpNum());
			pstmt.setString(6, enterReg.getEnterpriseRegCap());
			pstmt.setString(7, enterReg.getEnterpriseAddress());
			pstmt.setString(8, enterReg.getEnterpriseBrief());
			pstmt.setString(9, EnterpriseId);
			pstmt.executeUpdate();
			sql_2 = "insert into EnContact(EnterpriseAttn,FaxNumber,EnterprisePhone,EnterpriseZip,EnterpriseEmail,PostalAddress,EnterprisePost,PhoneNum,EnterpriseIndex,EnterpriseId) " +
					"values(?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql_2);
			pstmt.setString(1, enterReg.getEnterpriseAttn());
			pstmt.setString(2, enterReg.getFaxNum());
			pstmt.setString(3, enterReg.getEnterprisePhone());
			pstmt.setString(4, enterReg.getEnterpriseZip());
			pstmt.setString(5, enterReg.getEnterpriseEmail());
			pstmt.setString(6, enterReg.getPostalAddress());
			pstmt.setString(7, enterReg.getEnterprisePost());
			pstmt.setString(8, enterReg.getPhoneNum());
			pstmt.setString(9, enterReg.getEnterpriseIndex());
			pstmt.setString(10, EnterpriseId);
			pstmt.executeUpdate();
			sql_3 = "update Stats set Amount=Amount+1 where Content='Enterprise'";
			pstmt = conn.prepareStatement(sql_3);
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
	
	public boolean CheckStudentUserName(String studentUserName){
		Connection conn = null;
		String sql = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbUtils.getConnection();
			sql = "select * from StudentUser where StudentName=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, studentUserName);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.closeResult(rs);
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();
		}
		return false;
	}
	
	public boolean CheckEnUserName(String enUserName){
		Connection conn = null;
		String sql = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbUtils.getConnection();
			sql = "select * from EnUser where EnterUserName=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, enUserName);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.closeResult(rs);
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();
		}
		return false;
	}
}
