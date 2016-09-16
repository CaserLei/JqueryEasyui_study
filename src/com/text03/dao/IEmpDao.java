package com.text03.dao;

import java.util.List;

import com.text03.entity.Emp;

/**
 * 员工管理模块
 * 持久层接口
 * @author leifeng
 * 2016年9月16日
 */
public interface IEmpDao {
	/**
	 * 获取总记录数
	 * @return 总记录数
	 */
	public Integer getAllRecord() throws Exception;
	
	/**
	 * 分批查询所有记录数
	 * @param start 表示 从第几条记录开始
	 * @param end   表示 到第几条记录结束
	 * @return      表示 start到end之间的记录集合
	 */
	public List<Emp> findAllRecord(int start,int end) throws Exception;
	
}
