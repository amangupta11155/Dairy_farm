package entry_servlet;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import niit_utilities.Emp;

/**
 * Servlet implementation class loginServlet
 */
public class login1Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login1Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          String username=request.getParameter("username");
         
        String password=request.getParameter("pws"); 
        Emp e=new Emp();    
        Cookie ck=new Cookie("name",username);  
        response.addCookie(ck);  
	          
	        try{  
	            Connection con=com.niit.utilities.Dbconnection.connect();  
	            PreparedStatement ps=con.prepareStatement("select password from entry_register where email_id=?");
	            ps.setString(1,username);  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                 
	               // e.setcust_id(rs.getInt(1));  
	               // e.setName(rs.getString(1));  
	                e.setPassword(rs.getString(1));  
	                //e.setEmail(rs.getString(4));  
	                  
	              
	            }  
	             
	        }catch(Exception e1){e1.printStackTrace();}  
	          
         if(password.equals(e.getPassword()))
         {
        	 response.sendRedirect("EntryForm.html");
         }
         else
         {
        	 request.getRequestDispatcher("adminlogin1.html").include(request, response);  
        	
         }
		doGet(request, response);
	}

}

