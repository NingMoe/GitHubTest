package cn.edu.sdust.notice;

import java.util.List;

import cn.edu.sdust.tool.StuQuery;

public interface NoticeInterface {
	List<StuQuery> getAllNotice(int currentPage);
	StuQuery getAllNoticeByID(String ID);
}
