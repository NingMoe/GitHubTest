package cn.edu.sdust.officebearer;

import java.util.List;

import cn.edu.sdust.tool.StuQuery;

public interface OfficeBearerInterface {
	
	List<StuQuery> getAllOfficeBearer(int currentPage);
	StuQuery getAllOfficeBearerByID(String ID);
}
