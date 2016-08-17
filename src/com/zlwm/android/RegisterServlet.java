package com.zlwm.android;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zlwm.data.Db;

public class RegisterServlet extends HttpServlet{
	/**
	 * serialVersionUID序列版本，兼容性
	 */
	private static final long serialVersionUID = 1L;
	
	// 这里get与POST代码完全一样，注释掉get,以免被简单利用
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Regist进入GET");
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");//写回之前调用
		PrintWriter out = resp.getWriter();
		out.write("注册GET指路为码");
		if( req == null){
			return;
		}
		
		String para[]=new String[3];
		boolean flag=false;
		
		req.setCharacterEncoding("utf-8");//读取之前调用
		
		para[0]=req.getParameter("email");
		para[1]=req.getParameter("tele");
		para[2]=req.getParameter("password");
		if( !( (para[0]!=null || para[1]!=null) && para[2]!=null) )
		{
			System.out.println("参数不对");
			return;
		}
		//这里3<4当查询的时候再设置id
		flag=Db.executeSql("insert into user(email,tele,password,id) values(?,?,?,?)", para , 21 );
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");//写回之前调用
		PrintWriter out = resp.getWriter();
		if(flag){
			out.write("1");
			System.out.println("注册成功");	
		}else{
			out.write("0");
			System.out.println("注册失败");
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("执行PostRegist");
		// TODO Auto-generated method stub
		if( req == null){
			return;
		}
		
		String para[]=new String[3];
		boolean flag=false;
		
		req.setCharacterEncoding("utf-8");//读取之前调用
		
		para[0]=req.getParameter("email");
		para[1]=req.getParameter("tele");
		para[2]=req.getParameter("password");
		if( !( (para[0]!=null || para[1]!=null) && para[2]!=null) )
		{
			System.out.println("参数不对");
			return;
		}
		//这里3<4当查询的时候再设置id
		flag=Db.executeSql("insert into user(email,tele,password,id) values(?,?,?,?)", para , 21 );
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");//写回之前调用
		PrintWriter out = resp.getWriter();
		if(flag){
			out.write("1");
			System.out.println("注册成功");	
		}else{
			out.write("0");
			System.out.println("注册失败");
		}
		
	}
}











