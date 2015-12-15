package cn.edu.sdust.major;

import java.util.List;

public interface MajorInterface {
	
	List<MajorInfo> getAllMajorInfo(int currentPage);
	List<MajorInfo> getAllMajorInfoByCondition(String major);
	MajorInfo getAllMajorInfoByID(String ID);
}
