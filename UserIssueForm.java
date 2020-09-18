package LibraryMgmt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserIssueForm
 */
@WebServlet("/UserIssueForm")
public class UserIssueForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserIssueForm() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Issue Book Form</title>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("adminissuebook.html").include(request, response);
		
		out.println("<div class='container'>");
		request.getRequestDispatcher("Issuebook.html").include(request, response);
		out.println("</div>");
		out.close();
	}



}
