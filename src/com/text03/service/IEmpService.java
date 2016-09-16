package com.text03.service;

import com.text03.entity.Page;

/**
 * 员工管理模块
 * 业务层接口
 * @author leifeng
 * 2016年9月16日
 */
public interface IEmpService {
	
	/**
	 * 根据页号获取该页需要显示的内容
	 * @param currPageNo 当前页号
	 * @return  封装内容
	 * @throws Exception
	 */
	public Page show(int currPageNO) throws Exception;

}
