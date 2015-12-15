package cn.edu.sdust.resume;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.sdust.tool.DbUtils;

public class ResumeImpl implements ResumeInterface {
	
	private static int size = 13;
	
	public StudentInfo getAllStudentInfoByStuNum(String StuNum){
		Connection conn = null;
		String sql = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		StudentInfo studentInfo = new StudentInfo();
		try {
			conn = DbUtils.getConnection();
			// System.out.println("ok");
			// 3.发送sequel语句，并执行
			sql = "select * from StudentInfo where StudentNum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, StuNum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				studentInfo.setStudentName(rs.getString("StudentName"));
				studentInfo.setGender(rs.getString("Gender"));
				studentInfo.setMajor(rs.getString("Major"));
				studentInfo.setEduBg(rs.getString("EduBg"));
				studentInfo.setLos(rs.getString("LOS"));
				studentInfo.setNativePlace(rs.getString("NativePlace"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeResult(rs);
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();
		}
		return studentInfo;
	}
	
	
	public StuResume getAllResumeByStuNum(String StuNum) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = null;
		StuResume stuResume = new StuResume();
		try {
			conn = DbUtils.getConnection();
			sql = "select * from Resume where StudentNum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, StuNum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				stuResume.setNation(rs.getString("Nation"));
				stuResume.setPoliticsStatus(rs.getString("PoliticsStatus"));
				stuResume.setBirthday(rs.getString("Birthday"));
				stuResume.setGraduateSchool(rs.getString("GraduateSchool"));
				stuResume.setHobby(rs.getString("Hobby"));
				stuResume.setLanguage(rs.getString("Language"));
				stuResume.setExpertise(rs.getString("Expertise"));
				stuResume.setAwards(rs.getString("Awards"));
				stuResume.setProjectAcademic(rs.getString("ProjectAcademic"));
				stuResume.setPracticeWork(rs.getString("PracticeWork"));
				stuResume.setJobIntension(rs.getString("JobIntension"));
				stuResume.setSelfAssessment(rs.getString("SelfAssessment"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.closeResult(rs);
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();

		}
		return stuResume;

	}
	
	public StuContact getAllStuContactByNum(String StuNum){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		StuContact stuContact = new StuContact();
		try{
			conn = DbUtils.getConnection();
			sql = "select * from StudentContact where StudentNum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, StuNum);
			rs = pstmt.executeQuery();
			while(rs.next()){
				stuContact.setStudentTel(rs.getString("StudentTel"));
				stuContact.setStudentEmail(rs.getString("StudentEmail"));
				stuContact.setStudentQQ(rs.getString("StudentQQ"));
				stuContact.setStudentZip(rs.getString("StudentZip"));
				stuContact.setStudentAddress(rs.getString("StudentAddress"));			
				}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtils.closeResult(rs);
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();
		}
		return stuContact;
	}
	
	public List<StudentInfo> getAllStudentInfoByCondition(int currentPage,StudentInfo studentInfo){
		Connection conn = null;
		String sql ="";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int currentPage_1 = (currentPage - 1) * size;
		List<StudentInfo> studentInfos = new ArrayList<StudentInfo>();
		try {
			conn = DbUtils.getConnection();
			// System.out.println("ok");
			// 3.发送sequel语句，并执行
			if(studentInfo.getStudentName()!=""){
				sql =sql+ " and StudentName='"+studentInfo.getStudentName()+"'";
			}
			if(studentInfo.getGender()!=""){
				sql = sql+" and Gender='"+studentInfo.getGender()+"'";
			}
			if(studentInfo.getMajor()!=""){
				sql = sql+" and Major='"+studentInfo.getMajor()+"'";
			}
			if(studentInfo.getEduBg()!=""){
				sql = sql+" and EduBg='"+studentInfo.getEduBg()+"'";
			}
			if(studentInfo.getLos()!=""){
				sql = sql+" and Los='"+studentInfo.getLos()+"'";
			}
			if(studentInfo.getNativePlace()!=""){
				sql = sql+" and NativePlace like'%"+studentInfo.getNativePlace()+"%'";
			}
			if (currentPage_1 == 0)
				sql = "select top " + size + " * from StudentInfo where Resume=true"+sql;
			else
				sql = "select top "
						+ size
						+ " * from StudentInfo where Resume=true StudentNum not in(select top "
						+ currentPage_1 + " StudentNum from StudentInfo)"+sql;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StudentInfo studentInfo_1 = new StudentInfo();
				studentInfo_1.setStudentName(rs.getString("StudentName"));
				studentInfo_1.setGender(rs.getString("Gender"));
				studentInfo_1.setStudentNum(rs.getString("StudentNum"));
				studentInfo_1.setMajor(rs.getString("Major"));
				studentInfo_1.setEduBg(rs.getString("EduBg"));
				studentInfo_1.setLos(rs.getString("LOS"));
				studentInfo_1.setNativePlace(rs.getString("NativePlace"));
				studentInfos.add(studentInfo_1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeResult(rs);
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();
		}
		return studentInfos;
	}
	
	public static int getAllResumeCountPage(StudentInfo studentInfo){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql ="";
		int countPage = 0;
		try {
			conn = DbUtils.getConnection();
			if(studentInfo.getStudentName()!=""){
				sql =sql+ " and StudentName='"+studentInfo.getStudentName()+"'";
			}
			if(studentInfo.getGender()!=""){
				sql = sql+" and Gender='"+studentInfo.getGender()+"'";
			}
			if(studentInfo.getMajor()!=""){
				sql = sql+" and Major='"+studentInfo.getMajor()+"'";
			}
			if(studentInfo.getEduBg()!=""){
				sql = sql+" and EduBg='"+studentInfo.getEduBg()+"'";
			}
			if(studentInfo.getLos()!=""){
				sql = sql+" and Los='"+studentInfo.getLos()+"'";
			}
			if(studentInfo.getNativePlace()!=""){
				sql = sql+" and NativePlace='"+studentInfo.getNativePlace()+"'";
			}
			sql = "SELECT COUNT(*) as total FROM StudentInfo where Resume=true"+sql;
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
	
	public static int getAllResumeCountRecord(StudentInfo studentInfo){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql ="";
		int count = 0;
		try {
			conn = DbUtils.getConnection();
			if(studentInfo.getStudentName()!=""){
				sql =sql+ " and StudentName='"+studentInfo.getStudentName()+"'";
			}
			if(studentInfo.getGender()!=""){
				sql = sql+" and Gender='"+studentInfo.getGender()+"'";
			}
			if(studentInfo.getMajor()!=""){
				sql = sql+" and Major='"+studentInfo.getMajor()+"'";
			}
			if(studentInfo.getEduBg()!=""){
				sql = sql+" and EduBg='"+studentInfo.getEduBg()+"'";
			}
			if(studentInfo.getLos()!=""){
				sql = sql+" and Los='"+studentInfo.getLos()+"'";
			}
			if(studentInfo.getNativePlace()!=""){
				sql = sql+" and NativePlace='"+studentInfo.getNativePlace()+"'";
			}
			sql = "SELECT COUNT(*) as total FROM StudentInfo where Resume=true"+sql;
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
	
	public boolean addStudentResume(String StuNum,StuResume stuResume,StuContact stuContact){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		String sql_1 = null;
		String sql_2 = null;
		String sql_3 = null;
		try{
			conn = DbUtils.getConnection();
			sql = "update StudentInfo set Resume=True where StudentNum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, StuNum);
			pstmt.executeUpdate();
			sql_1 = "insert into Resume values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql_1);
			pstmt.setString(1, StuNum);
			pstmt.setString(2, stuResume.getNation());
			pstmt.setString(3, stuResume.getBirthday());
			pstmt.setString(4, stuResume.getPoliticsStatus());
			pstmt.setString(5, stuResume.getGraduateSchool());
			pstmt.setString(6, stuResume.getHobby());
			pstmt.setString(7, stuResume.getLanguage());
			pstmt.setString(8, stuResume.getExpertise());
			pstmt.setString(9, stuResume.getAwards());
			pstmt.setString(10, stuResume.getProjectAcademic());
			pstmt.setString(11, stuResume.getPracticeWork());
			pstmt.setString(12, stuResume.getJobIntension());
			pstmt.setString(13, stuResume.getSelfAssessment());
			pstmt.executeUpdate();
			sql_2 = "insert into StudentContact values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql_2);
			pstmt.setString(1, StuNum);
			pstmt.setString(2, stuContact.getStudentTel());
			pstmt.setString(3, stuContact.getStudentEmail());
			pstmt.setString(4, stuContact.getStudentQQ());
			pstmt.setString(5, stuContact.getStudentZip());
			pstmt.setString(6, stuContact.getStudentAddress());
			pstmt.executeUpdate();
			sql_3 = "update Stats set Amount=Amount+1 where Content='Resume'";
			pstmt = conn.prepareStatement(sql_3);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e){
			
			e.printStackTrace();
		}finally{
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();
		}
		return false;
	}
	
	public String getStudentNumByStuName(String studentUserName){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String studentNum = null;
		try{
		conn = DbUtils.getConnection();
		sql = "select StudentNum from StudentUser where StudentName=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, studentUserName);
		rs = pstmt.executeQuery();
		if(rs.next()){
			studentNum = rs.getString("StudentNum");
		}
		} catch(SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtils.closeResult(rs);
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();
		}
		return studentNum;
		
	}
	
	public boolean updateResumeByStuNum(String userName,StuResume stuResume,StuContact stuContact){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql_1 = null;
		String sql_2 = null;
		try{
			conn = DbUtils.getConnection();
			sql_1 = "update Resume,StudentUser set Nation=?,Birthday=?,PoliticsStatus=?,GraduateSchool=?,Hobby=?,Language=?,Expertise=?," +
					"Awards=?,ProjectAcademic=?,PracticeWork=?,JobIntension=?,SelfAssessment=? where Resume.StudentNum=StudentUser.StudentNum and StudentUser.StudentName=?";
			pstmt = conn.prepareStatement(sql_1);
			pstmt.setString(1, stuResume.getNation());
			pstmt.setString(2, stuResume.getBirthday());
			pstmt.setString(3, stuResume.getPoliticsStatus());
			pstmt.setString(4, stuResume.getGraduateSchool());
			pstmt.setString(5, stuResume.getHobby());
			pstmt.setString(6, stuResume.getLanguage());
			pstmt.setString(7, stuResume.getExpertise());
			pstmt.setString(8, stuResume.getAwards());
			pstmt.setString(9, stuResume.getProjectAcademic());
			pstmt.setString(10, stuResume.getPracticeWork());
			pstmt.setString(11, stuResume.getJobIntension());
			pstmt.setString(12, stuResume.getSelfAssessment());
			pstmt.setString(13, userName);
			pstmt.executeUpdate();
			sql_2 = "update StudentContact,StudentUser set StudentTel=?,StudentEmail=?,StudentQQ=?,StudentZip=?,StudentAddress=? where StudentContact.StudentNum=StudentUser.StudentNum and StudentUser.StudentName=?";
			pstmt = conn.prepareStatement(sql_2);
			pstmt.setString(1, stuContact.getStudentTel());
			pstmt.setString(2, stuContact.getStudentEmail());
			pstmt.setString(3, stuContact.getStudentQQ());
			pstmt.setString(4, stuContact.getStudentZip());
			pstmt.setString(5, stuContact.getStudentAddress());
			pstmt.setString(6, userName);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e){
			
			e.printStackTrace();
		}finally{
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();
		}
		return false;
	}

}
