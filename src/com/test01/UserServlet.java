package com.test01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

/**
 * 用Servlet
 * @author leifeng
 * 2016年9月13日
 */
public class UserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//收集DataGrid向服务器发送的参数--page(当前页号）
		String page=request.getParameter("page");
		System.out.println(page);
		
		//收集DataGrid向服务器端发送的参数--rows(当前要显示的记录数）
		String rows=request.getParameter("rows");
		System.out.println(rows);
		
	
		List<User> userList=new ArrayList<User>();
		userList.add(new User(1,"1哈哈",1000,"男"));
		userList.add(new User(2,"2哈哈",2000,"男"));
		userList.add(new User(3,"3哈哈",3000,"男"));
		userList.add(new User(4,"4哈哈",4000,"男"));
		userList.add(new User(5,"5哈哈",5000,"男"));
		userList.add(new User(6,"6哈哈",6000,"男"));
		userList.add(new User(7,"7哈哈",7000,"男"));
		
		Map<String,Object> map=new LinkedHashMap<String,Object>();
		map.put("total", userList.size());
		map.put("rows", userList);
		
		JSONArray jsonArray=new JSONArray().fromObject(map);
		String jsonJava=jsonArray.toString();
		
		jsonJava=jsonJava.substring(1, jsonJava.length()-1);
		
		//以流的方式将JSON文本输出到DateGrid组件中
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.write(jsonJava);
		pw.flush();
		pw.close();
	
	}

}
