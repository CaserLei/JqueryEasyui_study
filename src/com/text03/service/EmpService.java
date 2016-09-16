package com.text03.service;

import java.util.List;

import com.text03.dao.IEmpDao;
import com.text03.dao.impl.EmpDao;
import com.text03.entity.Emp;
import com.text03.entity.Page;

public class EmpService implements IEmpService{

	private IEmpDao empDao=new EmpDao();
	@Override
	public Page show(int currPageNO) throws Exception {
		Page page=new Page();
		//封装当前页
		page.setCurrPageNO(currPageNO);
		//封装总记录数
		Integer allRecordNO=empDao.getAllRecord();
		page.setAllRecordNO(allRecordNO);
		//封装当前页数
		Integer allPageNO;
		if(page.getAllRecordNO() % page.getPerPageSize() ==0){
			allPageNO=page.getAllRecordNO()/page.getPerPageSize();
		}else{
			allPageNO=page.getAllRecordNO()/page.getPerPageSize()+1;
		}
		page.setAllPageNO(allPageNO);
		
		//封装当前页的内容
		Integer start=(page.getCurrPageNO()-1) * page.getPerPageSize();
		Integer end=(page.getCurrPageNO() * page.getPerPageSize())+1;
		List<Emp> empList=empDao.findAllRecord(start, end);
		page.setEmpList(empList);
		
		return page;
	}
	
	
	public static void main(String[] args) throws Exception {
		EmpService empService=new EmpService();
		
		Page page1=empService.show(1);
		System.out.println("--------------第1页--------------------------");
		for(Emp e:page1.getEmpList()){
			System.out.println(e);
		}
		
		System.out.println("--------------第2页--------------------------");
		Page page2=empService.show(2);
		for(Emp e:page2.getEmpList()){
			System.out.println(e);
		}
		System.out.println("--------------第3页--------------------------");
		Page page3=empService.show(3);
		for(Emp e:page3.getEmpList()){
			System.out.println(e);
		}
		System.out.println("--------------第4页--------------------------");
		Page page4=empService.show(4);
		for(Emp e:page4.getEmpList()){
			System.out.println(e);
		}
		System.out.println("--------------第5页--------------------------");
		Page page5=empService.show(5);
		for(Emp e:page5.getEmpList()){
			System.out.println(e);
		}
	
	}

}
