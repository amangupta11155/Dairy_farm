package admin_servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.utilities.Dbconnection;

import niit_utilities.Emp;

/**
 * Servlet implementation class changepass_admin
 */
public class changepass_admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changepass_admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pass=request.getParameter("pws");
		 int status=0;
		 HttpSession session=request.getSession();  
	       String user_id= (String)session.getAttribute("uname"); 
	       int cust_id=Integer.parseInt(user_id);
		 
		 Emp e=new Emp();
	        try{  
	            Connection con=Dbconnection.connect();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "update admin_register set password=? where admin_id=?");  
	            ps.setInt(2,cust_id);
	            ps.setString(1,pass);
	          
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          if(status==1)
	          {
	        	  response.sendRedirect("Profile1.jsp");
	          }
	          
	        
	    }  
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
