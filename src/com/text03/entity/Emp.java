package com.text03.entity;

import java.util.Date;

/**
 * 员工
 * @author leifeng
 * 2016年9月16日
 */
public class Emp {
	private Integer empno; //编号                                                                                                                                                                                           
	private String ename; //姓名                                                                                                                                                                                                        
	private String job; //工作                                                                                                                                                                                                              
	private Integer mgr; //上级编号                                                                                                                                                                                                                        
	private Date hiredate;//入职时间                                                                                                                                                                                                                      
	private Integer sal;//月薪                                                                                                                                                                                                                       
	private Integer comm;//佣金                                                                                                                                                                                                                       
	private Integer deptno; //部门编号
	
	public Emp(){}

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getMgr() {
		return mgr;
	}

	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Integer getSal() {
		return sal;
	}

	public void setSal(Integer sal) {
		this.sal = sal;
	}

	public Integer getComm() {
		return comm;
	}

	public void setComm(Integer comm) {
		this.comm = comm;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "编号：" + empno + "姓名：" + ename + "工作：" + job + "上级编号：" + mgr + "入职日期：" + hiredate
				+ "月薪：" + sal + "佣金：" + comm + "部门编号：" + deptno;
	}
	
	
	

}
