package LibraryMgmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class AdminBookDB {

	//String query = "(select * from MEMBERCREATE where Member_Username = ? and Member_Password = ? )";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "JDBC";
	String password = "admin";
	Connection dbconnect;
	//String output = "Login successfully";
	public AdminBookDB() {
		
		
	}
	public void connect() throws SQLException {
		if(dbconnect == null || dbconnect.isClosed()) {
			try {
				 Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch(ClassNotFoundException ce) {
				ce.printStackTrace();
				throw new SQLException(ce);
			}
			dbconnect = DriverManager.getConnection(url, user,password);
		}
	}
	
	public void disconnect() throws SQLException{
		if(dbconnect != null && !dbconnect.isClosed()) {
			dbconnect.close();
		}
	}
	public boolean insertBook(AdminBook book) throws SQLException{
		System.out.println("test");
		String insertsql = "INSERT INTO book( booktile, bookauthor, bookedition, publicationyear, publisher, category, branch, status,ADDEDEMPID, ADDEDEMPNAME)\r\n" + 
				" VALUES (?,?,?,?,?,?,?,?,?,?)";
		connect();
		 PreparedStatement ps = dbconnect.prepareStatement(insertsql);
		// ps.setInt(1, book.getBookid());
		 ps.setString(1, book.getBooktile());
		 ps.setString(2, book.getBookauthor());
		 ps.setString(3, book.getBookedition());
		 ps.setString(4, book.getPublicationyear());
		 ps.setString(5, book.getPublisher());
		 ps.setString(6, book.getCategory());
		 ps.setString(7, book.getBranch());
		 ps.setString(8, book.getStatus());
		 ps.setString(9, book.getAddedempid());
		 ps.setString(10, book.getAddedempname());
		 System.out.println(ps);
		boolean checkrow = ps.execute();
		ps.close();
		disconnect();
		return checkrow;
	}
	public ArrayList<AdminBook> listBook() throws SQLException {
		ArrayList<AdminBook> booklist = new ArrayList<>();
		String insertsql = "select * from BOOK";
		connect();
		PreparedStatement st = dbconnect.prepareStatement(insertsql);
		System.out.println("prepare statement done"+ st);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			int bookid = rs.getInt("bookid");
			String booktile = rs.getString("booktile");
			String bookauthor = rs.getString("bookauthor");
			String bookedition = rs.getString("bookedition");
			String publicationyear = rs.getString("publicationyear");
			String publisher = rs.getString("publisher");
			String category = rs.getString("category");
			String branch = rs.getString("branch");
			String status = rs.getString("status");
			String addedempid = rs.getString("addedempid");
			String addedempname = rs.getString("addedempname");
			System.out.println("list of books");
			booklist.add(new AdminBook(bookid, booktile, bookauthor, bookedition, publicationyear, publisher, category, branch, status, addedempid, addedempname));
		}
	
		return booklist;
	}
	
	 public AdminBook searchBook(int id) throws SQLException {
	        AdminBook book = null;
	        String sql = "SELECT * FROM book WHERE book_id = ?";
	         
	        connect();
	         
	        PreparedStatement statement = dbconnect.prepareStatement(sql);
	        statement.setInt(1, id);
	         
	        ResultSet resultSet = statement.executeQuery();
	         
	        if (resultSet.next()) {
	        	String btitle = resultSet.getString("booktile");
				String bauthor = resultSet.getString("bookauthor");
				String bedition = resultSet.getString("bookedition");
				String bpubyrs = resultSet.getString("publicationyear");
				String bpublisher = resultSet.getString("publisher");
				String bcategory = resultSet.getString("category");
				String bbranch = resultSet.getString("branch");
				String bstatus = resultSet.getString("status");
				String baddempid = resultSet.getString("addempid");
				String baddempname = resultSet.getString("addempname");
	             
				book = new AdminBook(btitle,bauthor,bedition,bpubyrs,bpublisher,bcategory,bbranch,bstatus,baddempid,baddempname);
	        }
	         
	        resultSet.close();
	        statement.close();
	         
	        return book;
	    }
	 
	 public boolean updateBook(AdminBook book) throws SQLException {
	        String sql = "UPDATE book SET booktile =?, bookauthor=?, bookedition =?, publicationyear=?, publisher=?, category=?, branch=?, status=?,addempid=?, addempname=?";
	        sql += " WHERE Bookid = ?";
	        connect();
	         
	        PreparedStatement statement = dbconnect.prepareStatement(sql);
	        statement.setString(2, book.getBooktile());
	        statement.setString(3, book.getBookauthor());
			 statement.setString(4, book.getBookedition());
			 statement.setString(5, book.getPublicationyear());
			 statement.setString(6, book.getPublisher());
			 statement.setString(7, book.getCategory());
			 statement.setString(8, book.getBranch());
			 statement.setString(9, book.getStatus());
			 statement.setString(10, book.getAddedempid());
			 statement.setString(11, book.getAddedempname());
			 statement.setInt(1, book.getBookid());
	                 
	        boolean updaterow = statement.executeUpdate() > 0;
	        statement.close();
	        disconnect();
	        return updaterow;     
	    }
	 public boolean deleteBook(AdminBook book) throws SQLException {
	        String sql = "DELETE FROM book where bookid = ?";
	         
	        connect();
	         
	        PreparedStatement statement = dbconnect.prepareStatement(sql);
	        statement.setInt(1, book.getBookid());
	         
	        boolean rowDeleted = statement.executeUpdate() > 0;
	        statement.close();
	        disconnect();
	        return rowDeleted;     
	    }
}
