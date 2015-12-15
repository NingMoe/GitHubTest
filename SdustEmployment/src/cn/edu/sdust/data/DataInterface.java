package cn.edu.sdust.data;

import java.util.List;

import cn.edu.sdust.tool.StuQuery;

public interface DataInterface {
	List<StuQuery> getAllRDData(int currentPage);
	StuQuery getAllRDDataByID(String ID);
}
