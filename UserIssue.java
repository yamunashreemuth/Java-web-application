package LibraryMgmt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import LibraryMgmt.UserDBConnect;

/**
 * Servlet implementation class UserIssue
 */
@WebServlet("/UserIssue")
public class UserIssue extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserIssue() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Add Book Form</title>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("adminissuebook.html").include(request, response);
		
		out.println("<div class='container'>");
		String issueid=request.getParameter("issueid");
		String issuebookid=request.getParameter("issuebookid");
		String issuemembid=request.getParameter("issuemembid");
		String isssuebooktitle=request.getParameter("isssuebooktitle");
		String issuebookauthor = request.getParameter("issuebookauthor");
		String issuecategory = request.getParameter("issuecategory");
		String issuedate = request.getParameter("issuedate");
		String noofrenewal = request.getParameter("noofrenewal");
		String issueadminid = request.getParameter("issueadminid");
		String issueadminname = request.getParameter("issueadminname");
		String returnstatus = request.getParameter("returnstatus");
		
		UserPage bean=new UserPage(issueid, issuebookid, issuemembid, isssuebooktitle, issuebookauthor, issuecategory, issuedate, noofrenewal, issueadminid, issueadminname, returnstatus);
		UserDBConnect udb = new UserDBConnect();
		try {
			int result = udb.issueBook(bean);
			response.getWriter().println(result);
		
		if(result>0){
			out.println("<h3>Book issued successfully</h3>");
		}else{
			out.println("<h3>Sorry, unable to issue book.</h3><p>We may have sortage of books. Kindly visit later.</p>");
		}} catch(Exception se) {
			se.printStackTrace();
		}
		out.println("</div>");
		out.close();
	
		}

}
