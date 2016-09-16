package com.test02.provincecityarea.action;


import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.test02.provincecityarea.ProvinceCityAreaService;
import com.test02.provincecityarea.entity.Bean;

/**
 * 后台控制器
 * @author leifeng
 * 2016年9月15日
 */
public class ProvinceCityAreaAction extends ActionSupport{
	//业务层
	private ProvinceCityAreaService provinceAreaService=new ProvinceCityAreaService();
	
	//Bean 是实体，封装省份和城市
	private Bean bean;
	public Bean getBean() {
		return bean;
	}
	public void setBean(Bean bean) {
		this.bean = bean;
	}
	
    private List<String> cityList;//需要转换成JSON集合，且为其设置值
	public List<String> getCityList() {
		return cityList;
	}
	
	private List<String> areaList;    
	public List<String> getAreaList() {
		return areaList;
	}
	
	/**
	 * 根据省份查询城市
	 */
	public String findCtiyByProvince() throws Exception{
		cityList=provinceAreaService.findCityByProvice(bean.getProvince());
		//将List集合转换成JSON文本
		return SUCCESS;
	}
	
	/**
	 * 根据城市查询区域
	 */
    public String findAreaByCtiy() throws Exception{
        areaList=provinceAreaService.findAreaByCity(bean.getCity());
    	//将List集合转换成JSON文本
		return SUCCESS;
	}
    
  

}
