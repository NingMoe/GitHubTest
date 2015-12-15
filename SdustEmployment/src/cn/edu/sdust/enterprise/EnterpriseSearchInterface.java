package cn.edu.sdust.enterprise;

import java.util.List;

import cn.edu.sdust.register.Enterprise;

public interface EnterpriseSearchInterface {
	
	List<Enterprise> EnterSearch(int currentPage,Enterprise enterprise);
	Enterprise EnterSearchById(String enterpriseId);
}
