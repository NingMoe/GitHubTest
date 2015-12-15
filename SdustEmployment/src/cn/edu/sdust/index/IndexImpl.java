package cn.edu.sdust.index;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.sdust.careerfair.CareerFair;
import cn.edu.sdust.recruitment.Recruitment;
import cn.edu.sdust.resume.StudentInfo;
import cn.edu.sdust.tool.DbUtils;
import cn.edu.sdust.tool.StuQuery;

public class IndexImpl implements IndexInterface {
	
	private static int indexSize_1 = 5;
	private static int indexSize = 8;

	public List<StudentInfo> getAllTopResume(){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<StudentInfo> studentInfos = new ArrayList<StudentInfo>();
		try {
			conn = DbUtils.getConnection();
			String sql = "select top "+indexSize_1+" * from StudentInfo where Resume=true";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				StudentInfo studentInfo = new StudentInfo();
				studentInfo.setStudentNum(rs.getString("studentNum"));
				studentInfo.setMajor(rs.getString("Major"));
				studentInfo.setStudentName(rs.getString("StudentName"));
				studentInfo.setNativePlace(rs.getString("NativePlace"));
				studentInfos.add(studentInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentInfos;
	}
	
	public List<CareerFair> getAllTopCareerFair() {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = null;
		List<CareerFair> careerFairs = new ArrayList<CareerFair>();
		try {
			conn = DbUtils.getConnection();
			sql = "select top "+indexSize+" * from CareerFair where CFPassed=true order by CFTop,CFReleaseTime DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CareerFair careerFair = new CareerFair();
				careerFair.setcFTitle(rs.getString("CFTitle"));
				careerFair.setcfID(rs.getString("CfID"));
				//careerFair.setcFPublisher(rs.getString("CFPublisher"));
				careerFair.setcFReleaseTime(rs.getString("CFReleaseTime"));
				//careerFair.setcFStartTime(rs.getString("CFStartTime"));
				careerFair.setcFClassfy(rs.getString("CFClassfy"));
				//careerFair.setCfStartPlace(rs.getString("CFStartPlace"));
				//careerFair.setcFEnterprises(rs.getString("CFEnterprises"));
				//careerFair.setcFEligibility(rs.getString("CFEligibility"));
				//careerFair.setCfStartPlace(rs.getString("CFThing"));
				//careerFair.setcFPassed(rs.getString("CFPassed"));
				careerFair.setcFTop(rs.getString("CFTop"));
				//careerFair.setcFPV(rs.getString("CFPV"));
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
	
	public List<Recruitment> getAllTopRecruitment() {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = null;
		List<Recruitment> recruitments = new ArrayList<Recruitment>();
		try {
			conn = DbUtils.getConnection();
			sql = "select top "+indexSize+" * from Recruitment where RecruitPassed=true order by RecruitTop,RecruitReleaseTime";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Recruitment recruitment = new Recruitment();
				recruitment.setRecruitId(rs.getString("RecruitId"));
				//recruitment.setRecruitAuthor(rs.getString("RecruitAuthor"));
				//recruitment.setRecruitOrgin(rs.getString("recruitOrgin"));
				recruitment.setRecruitReleaseTime(rs
						.getString("recruitReleaseTime"));
				//recruitment.setRecruitContent(rs.getString("recruitContent"));
				recruitment.setRecruitTitle(rs.getString("recruitTitle"));
				//recruitment.setRecruitPassed(rs.getString("recruitPassed"));
				recruitment.setRecruitTop(rs.getString("recruitTop"));
				//recruitment.setRecruitPV(rs.getString("recruitPV"));
				recruitment.setRecruitWorkplace(rs.getString("recruitWorkplace"));
				recruitments.add(recruitment);
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
	
	public List<StuQuery> getAllTopEmpPolicy(){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = null;
		List<StuQuery> stuQuerys = new ArrayList<StuQuery>();
		try {
			conn = DbUtils.getConnection();
			// System.out.println("ok");
			// 3.发送sequel语句，并执行
			sql = "select top " + indexSize_1 + " * from EmpPolicy";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StuQuery stuQuery = new StuQuery();
				stuQuery.setiD(rs.getString("EPId"));
				stuQuery.setTitle(rs.getString("EPTitle"));
				stuQuery.setAuthor(rs.getString("EPAuthor"));
				stuQuery.setOrigin(rs.getString("EPOrgin"));
				stuQuery.setReleaseTime(rs.getString("EPReleaseTime"));
				stuQuery.setContent(rs.getString("EPContent"));
				stuQuery.setTop(rs.getString("EPTop"));
				stuQuery.setPv(rs.getInt("EPPV"));
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
	
	public List<StuQuery> getAllTopJSP(){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = null;
		List<StuQuery> stuQuerys = new ArrayList<StuQuery>();
		try {
			conn = DbUtils.getConnection();
			// System.out.println("ok");
			// 3.发送sequel语句，并执行
			sql = "select top " + indexSize_1 + " * from JSP";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StuQuery stuQuery = new StuQuery();
				stuQuery.setiD(rs.getString("JSPId"));
				stuQuery.setTitle(rs.getString("JSPTitle"));
				stuQuery.setAuthor(rs.getString("JSPAuthor"));
				stuQuery.setOrigin(rs.getString("JSPOrgin"));
				stuQuery.setReleaseTime(rs.getString("JSPReleaseTime"));
				stuQuery.setContent(rs.getString("JSPContent"));
				stuQuery.setTop(rs.getString("JSPTop"));
				stuQuery.setPv(rs.getInt("JSPPV"));
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
	
	public List<StuQuery> getAllTopConmmSkill(){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = null;
		List<StuQuery> stuQuerys = new ArrayList<StuQuery>();
		try {
			conn = DbUtils.getConnection();
			// System.out.println("ok");
			// 3.发送sequel语句，并执行
			sql = "select top " + indexSize_1 + " * from ConmmSkill";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StuQuery stuQuery = new StuQuery();
				stuQuery.setiD(rs.getString("CSId"));
				stuQuery.setTitle(rs.getString("CSTitle"));
				stuQuery.setReleaseTime(rs.getString("CSReleaseTime"));
				stuQuery.setTop(rs.getString("CSTop"));
				stuQuerys.add(stuQuery);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeResult(rs);
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();

		}
		return stuQuerys;
	}
	
	public List<StuQuery> getAllTopOfficeBearer(){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = null;
		List<StuQuery> stuQuerys = new ArrayList<StuQuery>();
		try {
			conn = DbUtils.getConnection();
			// System.out.println("ok");
			// 3.发送sequel语句，并执行
			sql = "select top " + indexSize_1 + " * from OfficeBearer";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StuQuery stuQuery = new StuQuery();
				stuQuery.setiD(rs.getString("OBEId"));
				stuQuery.setTitle(rs.getString("OBETitle"));
				stuQuery.setReleaseTime(rs.getString("OBEReleaseTime"));
				stuQuery.setTop(rs.getString("OBETop"));
				stuQuerys.add(stuQuery);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeResult(rs);
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection();

		}
		return stuQuerys;
	}
	
	public List<StuQuery> getAllTopLocality(){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = null;
		List<StuQuery> stuQuerys = new ArrayList<StuQuery>();
		try {
			conn = DbUtils.getConnection();
			// System.out.println("ok");
			// 3.发送sequel语句，并执行
			sql = "select top " + indexSize_1 + " * from Locality Order By GREReleaseTime DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StuQuery stuQuery = new StuQuery();
				stuQuery.setiD(rs.getString("GREId"));
				stuQuery.setTitle(rs.getString("GRETitle"));
				stuQuery.setReleaseTime(rs.getString("GREReleaseTime"));
				stuQuery.setTop(rs.getString("GRETop"));
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
	
	public List<StuQuery> getAllTopNotice(){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = null;
		List<StuQuery> stuQuerys = new ArrayList<StuQuery>();
		try {
			conn = DbUtils.getConnection();
			// System.out.println("ok");
			// 3.发送sequel语句，并执行
			sql = "select top " + indexSize_1 + " * from Notice Order By NoticeReleaseTime DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StuQuery stuQuery = new StuQuery();
				stuQuery.setiD(rs.getString("NoticeId"));
				stuQuery.setTitle(rs.getString("NoticeTitle"));
				stuQuery.setReleaseTime(rs.getString("NoticeReleaseTime"));
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
	
	public Total getAllTotal(){
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = null;
		Total total = new Total();
		try {
			conn = DbUtils.getConnection();
			sql = "update Stats set Amount=Amount+1 where Content='Visitor'";
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			sql = "select * from Stats";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String content = rs.getString("Content");
				String amount = rs.getString("Amount");
				if(content.equals("Enterprise")){
					total.setEnterprise(amount);
				}
				if(content.equals("Essay")){
					total.setEssay(amount);
				}
				if(content.equals("Resume")){
					total.setResume(amount);
				}
				if(content.equals("Visitor")){
					total.setVisitor(amount);
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
		
	}


}
