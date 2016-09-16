package com.text03.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.text03.entity.Page;
import com.text03.service.EmpService;
import com.text03.service.IEmpService;

import net.sf.json.JSONArray;


public class EmpServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("utf-8");
			
			
			//获取客户端传入的参数
			String strPage=request.getParameter("page");
			if(strPage == null || strPage.trim().length()==0 ){
				strPage="1";
			}
			
			
			Integer currPageNO=Integer.parseInt(strPage);
			
			//调用业务层
			IEmpService empService=new EmpService();
			Page page=empService.show(currPageNO);
			
			/*
			String pagesize=request.getParameter("pageSize");
			page.setPerPageSize(Integer.parseInt(pagesize));*/
			
			//创建map集合
			Map<String,Object> map=new LinkedHashMap<String,Object>();
			map.put("total", page.getAllRecordNO());
			map.put("rows", page.getEmpList());
			
			//使用第三方工具将map 转换成json文本
			JSONArray jsonArray=new JSONArray().fromObject(map);
			String jsonJAVA=jsonArray.toString();
			
			//去掉两边空格
			jsonJAVA=jsonJAVA.substring(1, jsonJAVA.length()-1);
			System.out.println("jsonJAVA="+jsonJAVA);
			
			//以字符流的方式，将json字符串输出到客户端
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw=response.getWriter();
			pw.write(jsonJAVA);
			pw.flush();
			pw.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
