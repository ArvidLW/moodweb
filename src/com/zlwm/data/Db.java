package com.zlwm.data;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Db {
	private static String nameDriver = "com.mysql.jdbc.Driver";;
	private static String url = "jdbc:mysql://localhost/mooddb";
	private static String user = "root";
	private static String password = "111";
	
	private static Connection conn=null;
	
	// 静态块，加载驱动
	static {
		try {
			Class.forName(nameDriver);
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动出错");
			e.printStackTrace();
		}
	}
	
	 public static void getConn()
	 {
		 
		 try {
			conn = (Connection) DriverManager.getConnection(url,user,password);
			System.out.println("getConn连接");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	 }
	 public static void closeConn()
	 {
		 try{
			 conn.close(); 
		 }catch(SQLException e)
		 {
			 System.out.println("conn关闭异常");
		 }
		
	 }
	 
	 //Object，传入对象数组,paraNum用于实际参数个数，因为可能数组中有些值为空
	 //type：0--query; 1--update
	 public static  boolean executeSql(String sql,String[] args,int type)
	 {
		  boolean flag=false;
		  PreparedStatement state=null;
		  int id,i;
		  
		  try {
			   getConn();
			   state=(PreparedStatement) conn.prepareStatement(sql);
			   if(args!=null && args.length>0)
			   {
				   //setObject(a,b),a表示SQL中第几个参数，b表示该参数的值
				    for (i = 0; i < args.length; i++) {
				    	System.out.println("参数:"+i+"-"+args[i]);
				    	state.setString(i+1, args[i]);
				    }
				    //execute用于看是否查到，返回boolean值
				    //flag=state.execute();
				    //System.out.println(flag);
				    //登录用户
				    if(type==1)
				    {	
				    	 ResultSet rs=state.executeQuery(); 
						 flag=rs.next();//参看java_ee_api,移动游标到第一行first,next，如果为有效行则返回真，若结果集为空则为false;	    
				    }
				    //普通--update
				    else if(type==2)
				    {
				    	 int rs=state.executeUpdate();
				    	 if(rs==1)
				    	 {
				    		 flag=true;
				    	 }
				    }
				    //特殊-update-用户注册
				    else if(type==21)
				    {
				    	String sqlForId="select id from user order by id desc limit 1" ;
				    	Statement stateForId=(Statement) conn.createStatement();
				    	ResultSet rsForId= stateForId.executeQuery(sqlForId);
				    	if(rsForId.next()==true)
				    	{
				    		id=rsForId.getInt("id");
				    		++id;
				    		System.out.println("id为："+id);
				    	}
				    	else{
				    		id=1000000;
				    	}
				    	state.setString(i+1, String.valueOf(id));
				    	int rs=state.executeUpdate();
				    	if(rs==1)
				    	 {
				    		 flag=true;
				    	 }
				    	System.out.println("注册ID为："+id);
				    }
				   
				    /*
				    rs.next();//第一次调用定位到第一行
				    if(rs.getRow()!=0)
				    {
				    	flag=true;
				    	System.out.println("登录成功");
				    }*/
				    //System.out.println(rs.getRow());
				    //String ss=rs.getString("password");
				    //System.out.println(ss);
				    //System.out.println(rs.getRow());
			   }
		  }catch(SQLException e){
			  System.out.println("executeSql异常");
			  e.printStackTrace();
		  }
		  finally{
			  closeConn();
		  }
	  
		  return flag;
	 }
	 
}
