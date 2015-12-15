package cn.edu.sdust.tool;

import java.sql.*;

public class DbUtils {
	
	private static Connection conn;
	private static int size = 13;
	private static int majorSize = 20;
	
	private DbUtils(){
	}
	
	public static Connection getConnection(){
	
		try{
			
			String dbpath = "D:/Workspaces/MyEclipse 10/SdustEmployment/Database/careerDB.mdb";//Access ���ݿ�·��
			String url="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+dbpath;
			//String dbName = ""; //Access ���ݿ��û�����û����Ϊ��
			//String dbPassword = "careerdb"; //Access ���ݿ����룬û����Ϊ��
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn = DriverManager.getConnection(url);
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	public static void closeConnection() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void closeStatement(PreparedStatement pstmt) {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void closeResult(ResultSet rs) {
		// 4.�ر����ݿ�
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int getCountPage(String ListName) { // ��ȡ��ҳ��

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int countPage = 0;
		try {
			conn = DbUtils.getConnection();
			// System.out.println("ok");
			// 3.����sequel��䣬��ִ��
			sql = "SELECT COUNT(*) as total FROM " + ListName;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt("total");
				if (ListName.equals("MajorInfo")) {
					countPage = count % majorSize == 0 ? count
							/ majorSize : count / majorSize + 1;
				} else {
					countPage = count % size == 0 ? count / size
							: count / size + 1;
				}
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

	public static int getCountRecord(String ListName) { // ��ȡ������

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int count = 0;
		try {
			conn = DbUtils.getConnection();
			// System.out.println("ok");
			// 3.����sequel��䣬��ִ��
			sql = "SELECT COUNT(*) as total FROM " + ListName;
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
