package entry_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.utilities.Dbconnection;

import niit_Reposatory.niit_Dao1;
import niit_Reposatory.niit_Dao2;
import niit_utilities.Emp;

/**
 * Servlet implementation class SaveServlet2
 */
public class SaveServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		 response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        	          
	        String name=request.getParameter("name");  
	        String password=request.getParameter("pws");   
	        String email=request.getParameter("email");
	        //System.out.println(email);
	       int number=Integer.parseInt(request.getParameter("mobile"));
	        
	        //System.out.println(number);
	        out.print(password);
	        Emp e=new Emp();  
	         
	        e.setName(name);  
	        e.setPassword(password);  
	        e.setEmail(email); 
	        e.setMobile(number);
	         //System.out.println(e.getMobile());
	         //System.out.println(e.getEmail());
	          
	       
	        int status=niit_Dao2.save(e); 
	      
	       
	        if(status>0){  
	            out.print("<p>Record saved successfully!</p>"); 
	         
	            
	            request.getRequestDispatcher("Entry_registration.html").include(request, response);  
	        }else{  
	            out.println("Sorry! unable to save record");  
	        }  
	          
	        out.close(); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
