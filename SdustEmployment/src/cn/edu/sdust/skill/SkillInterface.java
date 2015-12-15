package cn.edu.sdust.skill;

import java.util.List;

import cn.edu.sdust.tool.StuQuery;

public interface SkillInterface {
	
	List<StuQuery> getAllConmmSkill(int currentPage);
	StuQuery getAllConmmSkillByID(String ID);
}
