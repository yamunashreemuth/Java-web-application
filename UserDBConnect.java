package LibraryMgmt;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.*;
import java.sql.*;  
import LibraryMgmt.AdminBook;
import LibraryMgmt.UserPage;

public class UserDBConnect {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "JDBC";
	String password = "admin";
	
	public UserDBConnect() {
		super();
	}

	Connection dbconnect;
	
	public UserDBConnect(String url, String user, String password) {
		super();
		this.url = url;
		this.user = user;
		this.password = password;
		
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

	public AdminBook searchBook(int id) throws SQLException {
		AdminBook search = null;
        String sql = "SELECT * FROM book WHERE (bookid = ? OR booktile = ? OR bookauthor = ?)" ;
         
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
             
			search = new AdminBook(btitle,bauthor,bedition,bpubyrs,bpublisher,bcategory,bbranch,bstatus,baddempid,baddempname);
			
        }
         
        resultSet.close();
        statement.close();
         
        return search;
    }
	public ArrayList<AdminBook> booklist() throws SQLException{
		ArrayList<AdminBook> booklist = new ArrayList<>();
		String insertsql = "select * from book";
		connect();
		Statement st = dbconnect.createStatement();
		ResultSet rs = st.executeQuery(insertsql);
		while (rs.next()) {
			int bid = rs.getInt("bookid");
			String btitle = rs.getString("booktile");
			String bauthor = rs.getString("bookauthor");
			String bedition = rs.getString("bookedition");
			String bpubyrs = rs.getString("publicationyear");
			String bpublisher = rs.getString("publisher");
			String bcategory = rs.getString("category");
			String bbranch = rs.getString("branch");
			String bstatus = rs.getString("status");
			String baddempid = rs.getString("addempid");
			String baddempname = rs.getString("addempname");
			AdminBook book = new AdminBook(bid,btitle,bauthor,bedition,bpubyrs,bpublisher,bcategory,bbranch,bstatus,baddempid,baddempname);
			System.out.println(book);
		}
		rs.close();
		st.close();
		disconnect();
		return booklist;
	}
	public int delete(String issueno){
		int status=0;
		try{
			connect();
			PreparedStatement ps=dbconnect.prepareStatement("delete from BOOKISSUE where bookid=?");
			ps.setString(1,issueno);
			status=ps.executeUpdate();
			disconnect();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public int getIssued(String issueno){
		int issued=0;
		try{
			connect();
			PreparedStatement ps=dbconnect.prepareStatement("select * from BOOKISSUE where bookid=?");
			ps.setString(1,issueno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				issued=rs.getInt("issued");
			}
			disconnect();
			
		}catch(Exception e){System.out.println(e);}
		
		return issued;
	}
	
	public  boolean checkIssue(String issueno){
		boolean status=false;
		try{
			connect();
			PreparedStatement ps=dbconnect.prepareStatement("select * from BOOKISSUE where bookid=?");
			ps.setString(1,issueno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
			disconnect();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public int returnbook(String IssueID, String issuemembid) throws SQLException{
		int status=0;
		try{
			connect();
			PreparedStatement ps=dbconnect.prepareStatement("update bookissue set returnstatus='yes' where ISSUE_ID=? and ISSUE_MEMBID=?");
			ps.setString(1, IssueID);
			ps.setString(2,issuemembid);
			
			status=ps.executeUpdate();
			if(status>0){
				PreparedStatement ps2=dbconnect.prepareStatement("update bookissue set ISSUE_BookID=? where ISSUE_ID=?");
				ps2.setInt(1,getIssued(IssueID)-1);
				ps2.setString(2,IssueID);
				status=ps2.executeUpdate();
			}
			disconnect();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	
	public int issueBook(UserPage issue){
		String callno=issue.getIssueid();
		boolean checkstatus=checkIssue(callno);
		System.out.println("Check status: "+checkstatus);
		if(checkstatus){
			int status=0;
			try{
				 connect();
				PreparedStatement ps=dbconnect.prepareStatement("insert into BOOKISSUE values(?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1, issue.getIssueid());
				ps.setString(2, issue.getIssuebookid());
				ps.setString(3,issue.getIssuemembid());
				ps.setString(4,issue.getIsssuebooktitle());
				ps.setString(5,issue.getIssuebookauthor());				
				ps.setString(6,issue.getIssuecategory());
				java.sql.Date currentDate=new java.sql.Date(System.currentTimeMillis());
				ps.setDate(7,currentDate);
				ps.setString(8,issue.getNoofrenewal());
				ps.setString(9, issue.getIssueadminid());
				ps.setString(10, issue.getIssueadminname());
				ps.setString(11, issue.getReturnstatus());
				
				status=ps.executeUpdate();
				if(status>0){
					PreparedStatement ps2=dbconnect.prepareStatement("update BOOKISSUE set ISSUE_MEMBID=? where callno=?");
					ps2.setInt(1,getIssued(callno)+1);
					ps2.setString(2,callno);
					status=ps2.executeUpdate();
				}
				disconnect();
				
			}catch(Exception e){System.out.println(e);}
			
			return status;
		}else{
			return 0;
		}
	}

}
