package com.lovo.cq.shopping10_1.po;

import java.util.Map;

public class NotePager {

	private Map noteMap; // 公告集合

	private int totalNum; // 分页的总条数

	private int pageSize; // 每页显示的条数

	private int pagecurrentPageNo; // 当前第几页

	private int pageNum; // 总页数

	private int pageOffset; // 数据库limit语句中的索引值

	public Map getNoteMap() {
		return noteMap;
	}

	public void setNoteMap(Map noteMap) {
		this.noteMap = noteMap;
	}

	public int getPagecurrentPageNo() {
		return pagecurrentPageNo;
	}

	public void setPagecurrentPageNo(int pagecurrentPageNo) {
		this.pagecurrentPageNo = pagecurrentPageNo;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageOffset() {
		return pageOffset;
	}

	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
}
