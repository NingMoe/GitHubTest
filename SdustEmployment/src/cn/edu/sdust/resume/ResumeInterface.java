package cn.edu.sdust.resume;

import java.util.List;

public interface ResumeInterface {
	
	StuResume getAllResumeByStuNum(String StuNum);
	StuContact getAllStuContactByNum(String StuNum);
	StudentInfo getAllStudentInfoByStuNum(String StuNum);
	List<StudentInfo> getAllStudentInfoByCondition(int currentPage,StudentInfo studentInfo);
	boolean addStudentResume(String StuNum,StuResume stuResume,StuContact stuContact);
	String getStudentNumByStuName(String studentUserName);
	boolean updateResumeByStuNum(String userName,StuResume stuResume,StuContact stuContact);
}
