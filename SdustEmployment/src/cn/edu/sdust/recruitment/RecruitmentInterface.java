package cn.edu.sdust.recruitment;

import java.util.List;

public interface RecruitmentInterface {
	
	List<Recruitment> getAllRecruitment(int currentPage,Recruitment recruitment);
	Recruitment getAllRecruitmentByID(String ID);
	boolean addRecruitment(Recruitment recruitment);
}
