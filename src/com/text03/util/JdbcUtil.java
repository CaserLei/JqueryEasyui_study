package com.text03.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 工具类
 * @author leifeng
 * 2016年9月16日
 */
public class JdbcUtil {
	/**
	 * 加载src目录下的c3p0-config.xml文件
	 */
	private static ComboPooledDataSource dataSource=new ComboPooledDataSource();
	
	/**
	 * 获取数据源
	 * @return  数据源
	 */
	public static ComboPooledDataSource getDataSource(){
		return dataSource;
	}

}
