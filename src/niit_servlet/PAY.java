package niit_servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.utilities.Dbconnection;

/**
 * Servlet implementation class PAY
 */
public class PAY extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PAY() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		  HttpSession session1=request.getSession();  
          String username1=(String)session1.getAttribute("uname"); 
          int cust_id=Integer.parseInt(username1);
          System.out.println(cust_id);
 		
		int status=0;
		
		 try{  
   		     Connection con1=Dbconnection.connect();  
   		     PreparedStatement ps1=con1.prepareStatement("delete from monthybill where cust_id=? ");  
   		  ps1.setInt(1,cust_id);
   		 
   		 status=ps1.executeUpdate();
		 }catch(Exception e)
		 {
			 
		 }
		 System.out.println(status);
		 try{  
   		     Connection con1=Dbconnection.connect();  
   		     PreparedStatement ps1=con1.prepareStatement("insert into payment_success values(?,curdate()) ");  
   		  ps1.setInt(1,cust_id);
   		 
   		 status=ps1.executeUpdate();
		 }catch(Exception e)
		 {
			 
		 }
		 if(status==1)
		 {
			 response.sendRedirect("payment.jsp");
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
