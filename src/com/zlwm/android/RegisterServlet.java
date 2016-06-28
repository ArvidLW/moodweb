package com.zlwm.android;

import java.io.IOException;

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
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("进入GET注册");
		// TODO Auto-generated method stub
		if( req == null){
			return;
		}
		
		String para[]=new String[4];
		boolean flag=false;
		
		req.setCharacterEncoding("utf-8");//读取之前调用
		para[0]=req.getParameter("id");
		para[1]=req.getParameter("email");
		para[2]=req.getParameter("tele");
		para[3]=req.getParameter("password");
		
		flag=Db.executeSql("insert into user('id','email','tele','password') values(?,?,?,?)", para , 1 );
		//super.doGet(req, resp);
		System.out.println("注册成功");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		if( req == null){
			return;
		}
	}
}











