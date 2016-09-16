package com.test02.provincecityarea;

import java.util.ArrayList;
import java.util.List;

/**
 * 业务层
 * @author leifeng
 * 2016年9月15日
 */
public class ProvinceCityAreaService {
	/**
	 * 根据省份查询城市
	 */
	public List<String> findCityByProvice(String province) throws Exception{
		List<String> cityList=new ArrayList<String>();
		if("广东".equals(province)){
			cityList.add("广州");
			cityList.add("深圳");
			cityList.add("中山");
		}else if("湖南".equals(province)){
			cityList.add("长沙");
			cityList.add("株洲");
		}
		return cityList;
	}
	
	/**
	 * 根据城市查询区域
	 */
	public List<String> findAreaByCity(String city) throws Exception{
		List<String> areaList=new ArrayList<String>();
		if("广州".equals(city)){
			areaList.add("天河区");
			areaList.add("黄埔区");
			areaList.add("海珠区");
		}else if("深圳".equals(city)){
			areaList.add("宝安区");
			areaList.add("南山区");
		}else if("中山".equals(city)){
			areaList.add("AA");
			areaList.add("BB");
		}else if("长沙".equals(city)){
			areaList.add("CC");
			areaList.add("DD");
		}else if("株洲".equals(city)){
			areaList.add("EE");
			areaList.add("FF");
		}
		return areaList;
	}

}
