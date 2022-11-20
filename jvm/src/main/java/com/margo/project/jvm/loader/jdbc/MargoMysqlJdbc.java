package com.margo.project.jvm.loader.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MargoMysqlJdbc {
	
	private static final String URL="jdbc:mysql://127.0.0.1:3306/seata?rewriteBatchedStatements=true";
	
	public static void main(String[] args) throws Exception {
		//Class<?> driver=Class.forName("com.mysql.jdbc.Driver");
		
		//System.out.println("classLoader:"+driver.getClassLoader());
		
		Connection conn = DriverManager.getConnection(URL, "root", "1234"); //连接数据库
		
		PreparedStatement ps=conn.prepareStatement("SELECT * FROM t_account WHERE ID= ?");
		ps.setInt(1, 1);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			String id=rs.getString(1);
			String userId=rs.getString(2);
			String amount=rs.getString(3);
			System.out.println("id:"+id);
			System.out.println("userId:"+userId);
			System.out.println("amount:"+amount);
		}
		conn.close();
	}
}
