package cn.edu.sdust.filequery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.sdust.resume.StudentInfo;
import cn.edu.sdust.tool.DbUtils;

public class FileQueryImpl implements FileQueryInterface {
	public StudentInfo getAllFileInfo(String userName){
		Connection conn = null;
		String sql = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		StudentInfo studentInfo = new StudentInfo();
		try {
			conn = DbUtils.getConnection();
			sql = "select StudentInfo.StudentName,StudentInfo.FileAddress,StudentInfo.FileArchive from StudentInfo,StudentUser where StudentInfo.StudentNum=StudentUser.StudentNum and StudentUser.StudentName=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			if(rs.next()){
				studentInfo.setStudentName(rs.getString("StudentName"));
				studentInfo.setFileAddress(rs.getString("FileAddress"));
				studentInfo.setFileArchive(rs.getString("FileArchive"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.closeResult(rs);
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();
		}
		return studentInfo;
		}
}
