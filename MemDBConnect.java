package LibraryMgmt;

import LibraryMgmt.MemberCreation;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.*;
import java.sql.*;  


public class MemDBConnect {
	
/*	public void loadDriver(String dbdriver) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}*/
	public String memberReg(MemberCreation customer) throws ClassNotFoundException {
	
		String insertSQL = "INSERT INTO MEMBERCREATE\r\n" + 
				"(Member_ID, Member_Name, Member_Address, Member_Contact, Reg_Date, Member_Username, Member_Password, Created_Empid, Created_Empname, memberEmail) VALUES " 
				+ "(?,?,?,?,?,?,?,?,?,?)";
		//String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "JDBC";
		String password = "admin";
		String output = "Data entered successfully";
		
		try { 			   
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 Connection connection = DriverManager.getConnection(url, user, password);
			 PreparedStatement pst = connection.prepareStatement(insertSQL);
			 pst.setString(1, customer.getMemberID());
			 pst.setString(2, customer.getMembername());
			 pst.setString(3, customer.getMemberaddress());
			 pst.setString(4, customer.getMembercontact());
			 pst.setString(5, customer.getRegisteredDate());
			 pst.setString(6, customer.getMemberUsername());
			 pst.setString(7, customer.getMemberpassword());
			 pst.setString(8, customer.getCreatedEmpid());
			 pst.setString(9, customer.getCreatedEmpname());
			 pst.setString(10, customer.getmemberEmail());
			 
			 System.out.println(pst);
			 pst.executeUpdate();
			 		}
		catch (SQLException sqe) {
			sqe.printStackTrace();
			output= "Error occurred";
		}  
		
		return output;
	}
		
}
