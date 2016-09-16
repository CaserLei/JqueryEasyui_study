package com.text03.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.text03.dao.IEmpDao;
import com.text03.entity.Emp;
import com.text03.util.JdbcUtil;

public class EmpDao implements IEmpDao {

	@Override
	public Integer getAllRecord() throws Exception {
		QueryRunner runner=new QueryRunner(JdbcUtil.getDataSource());
		String sql="SELECT COUNT(EMPNO) FROM EMP";
		BigDecimal begDecimal=(BigDecimal)runner.query(sql, new ScalarHandler());
		return begDecimal.intValue();
	}

	@Override
	public List<Emp> findAllRecord(int start, int end) throws Exception {
		QueryRunner runner=new QueryRunner(JdbcUtil.getDataSource());
		String sql="select xx.empno,xx.ename,xx.job,xx.mgr,xx.hiredate,xx.sal,xx.comm,xx.deptno from (select rownum id,emp.* from emp where rownum<?) xx where id >?";
		
		Object[] params={end,start};
		
		return runner.query(sql, new BeanListHandler<Emp>(Emp.class),params);
	}
	
	public static void main(String[] args) throws Exception {
		EmpDao dao=new EmpDao();
		
		System.out.println("共有:"+dao.getAllRecord()+"个员工");
		
		System.out.println("--------------第1页----------------------");
		for(Emp e:dao.findAllRecord(0, 4)){
			System.out.println(e);
		}
		
		System.out.println("--------------第2页----------------------");
		for(Emp e:dao.findAllRecord(3, 7)){
			System.out.println(e);
		}
		
		System.out.println("--------------第3页----------------------");
		for(Emp e:dao.findAllRecord(6, 10)){
			System.out.println(e);
		}
		
		System.out.println("--------------第4页----------------------");
		for(Emp e:dao.findAllRecord(9, 13)){
			System.out.println(e);
		}
		System.out.println("--------------第5页----------------------");
		for(Emp e:dao.findAllRecord(12, 16)){
			System.out.println(e);
		}
	}

}
