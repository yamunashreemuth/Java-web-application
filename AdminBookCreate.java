package LibraryMgmt;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import LibraryMgmt.AdminBookDB;
import LibraryMgmt.AdminBook;
import java.util.*;

/**
 * Servlet implementation class AdminBookCreate
 */
//@WebServlet("/AdminBookCreate")
public class AdminBookCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminBookDB admindb;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBookCreate() {
     admindb = new AdminBookDB();
       
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);
		System.out.println("inside dopost");
		String action = request.getServletPath();
		System.out.println("choosen case: "+action);
		try {
			switch(action) {
            case "/new":
                showForm(request, response);
                break;
            case "/insert":
            	insertBook(request, response);
            	
                break;
            case "/delete":
                deleteBook(request, response);
                break; 
            case "/edit":
                showUpdateForm(request, response);
                break;
            case "/update":
                updateBook(request, response);
                break; 
            default:
                booklist(request, response);
                break; 
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		try {
			switch(action) {
            case "/new":
                showForm(request, response);
                break;
            case "/insert":
            	insertBook(request, response);
                break;
            case "/delete":
                deleteBook(request, response);
                break; 
            case "/edit":
                showUpdateForm(request, response);
                break;
            case "/update":
                updateBook(request, response);
                break; 
            case "/list":
            	booklist(request, response);
                break; 
            default:
                booklist(request, response);
                break; 
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	
	}
	protected void dispatch(HttpServletRequest request, HttpServletResponse response, String page)
		        throws ServletException, IOException {
		    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
		    dispatcher.forward(request, response);
		    }
	
	private void insertBook(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException {
        String booktile = request.getParameter("title");
        String bookauthor = request.getParameter("author");
        String bookedition = request.getParameter("edition");
        String publicationyear = request.getParameter("publicationyear");
        String publisher =  request.getParameter("publisher");
        String category = request.getParameter("category");
        String branch = request.getParameter("branch");
        String status = request.getParameter("status");
        String addempid = request.getParameter("addedempid");
        String addempname = request.getParameter("addedempname");
        System.out.println("inside insert book");
        AdminBook newBook = new AdminBook(booktile, bookauthor, bookedition, publicationyear, publisher, category, branch, status, addempid, addempname);
        admindb.insertBook(newBook);
        response.sendRedirect("list");
    }
	private void booklist(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException {
        ArrayList<AdminBook> blist = admindb.listBook();
        request.setAttribute("listBook", blist);
        System.out.println("servlet booklist"+ blist.size());
        RequestDispatcher dispatcher = request.getRequestDispatcher("Bookdetails.jsp");
        dispatcher.forward(request, response);
    }
 
	private void showForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Addbook.jsp");
        dispatcher.forward(request, response);
    }
 
	private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        AdminBook existingBook = admindb.searchBook(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Addbook.jsp");
        request.setAttribute("book", existingBook);
        dispatcher.forward(request, response);
 
    }

	 private void updateBook(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int bookid = Integer.parseInt(request.getParameter("id"));
	        String booktile = request.getParameter("title");
	        String bookauthor = request.getParameter("author");
	        String bookedition = request.getParameter("edition");
	        String publicationyear = request.getParameter("publicationyear");
	        String publisher =  request.getParameter("publisher");
	        String category = request.getParameter("category");
	        String branch = request.getParameter("branch");
	        String status = request.getParameter("status");
	        String addempid = request.getParameter("addedempid");
	        String addempname = request.getParameter("addedempname");
	 
	        AdminBook book = new AdminBook(bookid, booktile, bookauthor, bookedition, publicationyear, publisher, category, branch, status, addempid, addempname);
	        admindb.updateBook(book);
	        response.sendRedirect("list");
	    }
	 private void deleteBook(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int bookid = Integer.parseInt(request.getParameter("id"));
	 
	        AdminBook book = new AdminBook(bookid);
	        admindb.deleteBook(book);
	        response.sendRedirect("list");
	 
	    }
}
