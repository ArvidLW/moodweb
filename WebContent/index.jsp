<%@ page contentType="text/html;charset=utf-8"%> 
<%@ page import="java.sql.*"%> 
<html> 
<body> 
<%
Class.forName("com.mysql.jdbc.Driver"); // 加载数据库驱动，注册到驱动管理器
String url ="jdbc:mysql://localhost:3306/test";// 数据库连接字符串
//test为你的数据库名 
String username = "root";	// 数据库用户名
String password = "111";	// 数据库密码
Connection conn= DriverManager.getConnection(url,username,password); 

if(conn != null){
	out.println("数据库连接成功！");	// 输出连接信息
}
else{
	out.println("数据库连接失败！");	// 输出连接信息
}
//连接上了开始进行相关操作
Statement stmt=conn.createStatement(); 
ResultSet rs = stmt.executeQuery("SELECT * FROM user");
while(rs.next()) {%> 
您的第一个字段内容为：<%=rs.getString(1)%> 
您的第二个字段内容为：<%=rs.getString(2)%> 
<%	
}
conn.close();	// 关闭数据库连接
%> 
</body> 
</html>