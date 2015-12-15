package cn.edu.sdust.process;

import java.util.List;

import cn.edu.sdust.tool.StuQuery;

public interface ProcessInterface {
	List<StuQuery> getAllJSP(int currentPage);
	StuQuery getAllJSPByID(String ID);
}
