package cn.edu.sdust.dynamic;

import java.util.List;

import cn.edu.sdust.tool.StuQuery;

public interface DynamicInterface {
	List<StuQuery> getAllEmpDynamic(int currentPage);
	StuQuery getAllEmpDynamicByID(String ID);
}
