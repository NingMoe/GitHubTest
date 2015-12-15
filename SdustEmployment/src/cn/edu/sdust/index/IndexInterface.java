package cn.edu.sdust.index;

import java.util.List;

import cn.edu.sdust.careerfair.CareerFair;
import cn.edu.sdust.recruitment.Recruitment;
import cn.edu.sdust.resume.StudentInfo;
import cn.edu.sdust.tool.StuQuery;

public interface IndexInterface {
	List<StudentInfo> getAllTopResume();
	List<CareerFair> getAllTopCareerFair();
	List<Recruitment> getAllTopRecruitment();
	List<StuQuery> getAllTopEmpPolicy();
	List<StuQuery> getAllTopJSP();
	List<StuQuery> getAllTopConmmSkill();
	List<StuQuery> getAllTopOfficeBearer();
	List<StuQuery> getAllTopLocality();
	List<StuQuery> getAllTopNotice();
	Total getAllTotal();
}
