package cn.edu.sdust.locality;

import java.util.List;

import cn.edu.sdust.tool.StuQuery;

public interface LocalityInterface {
	
	List<StuQuery> getAllLocality(int currentPage);
	StuQuery getAllLocalityByID(String ID);
}
