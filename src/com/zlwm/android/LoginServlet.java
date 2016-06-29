package com.zlwm.android;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zlwm.data.Db;


public class LoginServlet extends HttpServlet {
	/**
	 * study
	 */
	
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 这里get与POST代码完全一样，注释掉get,以免被简单利用
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("进入GET登录");
		
		if( req == null){
			return;
		}
		String para[]=new String[3];
		boolean flag=false;
		
		req.setCharacterEncoding("utf-8");//读取之前调用
		para[0]=req.getParameter("email");
		para[1]=req.getParameter("tele");
		para[2]=req.getParameter("password");
		
		flag=Db.executeSql("select * from user where (email= ? or tele= ?) and password= ?", para , 1 );
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");//写回之前调用
		PrintWriter out = resp.getWriter();
		if(flag)
		{
			//out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>");
			//写回客户端显示
			out.write("1");
			System.out.println("登录成功");
		}else{
			out.write("0");
			System.out.println("登录失败");
		}
		
		
	}*/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("进入POST登录");
		
		if( req == null){
			return;
		}
		String para[]=new String[3];
		boolean flag=false;
		
		req.setCharacterEncoding("utf-8");//读取之前调用
		para[0]=req.getParameter("email");
		para[1]=req.getParameter("tele");
		para[2]=req.getParameter("password");
		
		flag=Db.executeSql("select * from user where (email= ? or tele= ?) and password= ?", para , 1 );
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");//写回之前调用
		PrintWriter out = resp.getWriter();
		if(flag)
		{
			//out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>");
			//写回客户端显示
			out.write("1");
			System.out.println("登录成功");
		}else{
			out.write("0");
			System.out.println("登录失败");
		}
	}
	

}
