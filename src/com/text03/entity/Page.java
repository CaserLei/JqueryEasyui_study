package com.text03.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页类
 * @author leifeng
 * 2016年9月16日
 */
public class Page {
	private Integer currPageNO;//当前页号
	private Integer perPageSize=3;//每页显示的记录数，默认情况为3条记录
	private Integer allRecordNO;//总记录数
	private Integer allPageNO;//总页数
	private List<Emp> empList=new ArrayList<Emp>();//每页显示的内容
	public Integer getCurrPageNO() {
		return currPageNO;
	}
	public void setCurrPageNO(Integer currPageNO) {
		this.currPageNO = currPageNO;
	}
	public Integer getPerPageSize() {
		return perPageSize;
	}
	public void setPerPageSize(Integer perPageSize) {
		this.perPageSize = perPageSize;
	}
	public Integer getAllRecordNO() {
		return allRecordNO;
	}
	public void setAllRecordNO(Integer allRecordNO) {
		this.allRecordNO = allRecordNO;
	}
	public Integer getAllPageNO() {
		return allPageNO;
	}
	public void setAllPageNO(Integer allPageNO) {
		this.allPageNO = allPageNO;
	}
	public List<Emp> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}
	
	

}
