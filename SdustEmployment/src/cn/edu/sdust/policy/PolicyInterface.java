package cn.edu.sdust.policy;

import java.util.List;

import cn.edu.sdust.tool.StuQuery;

public interface PolicyInterface {
	
	List<StuQuery> getAllEmpPolicy(int currentPage);
	StuQuery getAllEmpPolicyByID(String ID);
}
