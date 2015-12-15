package cn.edu.sdust.careerfair;

import java.util.List;

public interface CareerFairInterface {
	
	List<CareerFair> getAllCareerFair(int currentPage,CareerFair careerFair_c);
	CareerFair getAllCareerFairByID(String ID);
}
