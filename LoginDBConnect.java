package LibraryMgmt;

import LibraryMgmt.LoginCreation;
import java.sql.Statement;

import org.apache.catalina.valves.CrawlerSessionManagerValve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.*;
import java.sql.*;  

public class LoginDBConnect {
	
	public boolean validate(LoginCreation create)throws ClassNotFoundException{
		boolean status = false;
		String query = "(select * from MEMBERCREATE where Member_Username = ? and Member_Password = ? )";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "JDBC";
		String password = "admin";
		String output = "Login successfully";

		try { 			   
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 Connection connection = DriverManager.getConnection(url, user, password);
			 PreparedStatement ps = connection.prepareStatement(query);
			 ps.setString(1, create.getUsername());
			 ps.setString(2, create.getPassword());
			 System.out.println(ps);
			 ResultSet rs = ps.executeQuery();
			 status = rs.next();
		}
		catch(SQLException sql) {
			sql.printStackTrace();
			System.out.println(sql.getLocalizedMessage());
		}
		return status ;
	}

}
