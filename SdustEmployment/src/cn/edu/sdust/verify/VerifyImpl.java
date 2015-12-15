package cn.edu.sdust.verify;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.sdust.resume.StudentInfo;
import cn.edu.sdust.tool.DbUtils;

public class VerifyImpl implements VerifyInterface {
	
	public boolean StuVerify(StudentInfo studentInfo){
		Connection conn = null;
		String sql = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DbUtils.getConnection();
			sql = sql+ " and StudentName='"+studentInfo.getStudentName()+"'";
			sql = sql+" and Gender='"+studentInfo.getGender()+"'";
			sql = sql+" and Major='"+studentInfo.getMajor()+"'";
			sql = sql+" and EduBg='"+studentInfo.getEduBg()+"'";
			sql = sql+" and Los='"+studentInfo.getLos()+"'";
			sql = sql+" and NativePlace like '%"+studentInfo.getNativePlace()+"%'";
			sql = "select * from StudentInfo where 1=1"+sql;
			pstmt = conn.prepareStatement(sql);
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
