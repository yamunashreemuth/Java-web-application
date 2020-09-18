package LibraryMgmt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Register() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberID = request.getParameter("memberID");
		String membername = request.getParameter("membername");
		String memberaddress = request.getParameter("memberaddress");
		String membercontact = request.getParameter("membercontact");
		String memberUsername = request.getParameter("memberUsername");
		String memberpassword = request.getParameter("memberpassword");
		String memberEmail = request.getParameter("memberEmail");
		String createdEmpid = request.getParameter("createdEmpid");
		String createdEmpname = request.getParameter("createdEmpname");
		String RegisteredDate = request.getParameter("RegisteredDate");
		
		MemberCreation member = new MemberCreation(memberID, membername, memberaddress, membercontact, RegisteredDate, memberUsername, memberpassword, createdEmpid, createdEmpname, memberEmail);
		MemDBConnect memdb = new MemDBConnect();
		try {
			String result = memdb.memberReg(member);
			response.getWriter().println(result);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("Final.jsp");
		
	}

}
