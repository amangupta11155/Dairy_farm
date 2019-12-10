package niit_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.utilities.Dbconnection;

/**
 * Servlet implementation class approveServlet
 */
public class approveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public approveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");  
		 int sid=Integer.parseInt(request.getParameter("cust_id"));  
	       
	        int quantity=Integer.parseInt(request.getParameter("quantity"));
	        int status1=0;
	        int status2=0;
	        System.out.println(sid);
	        try {
	            Connection con=Dbconnection.connect();
	           // System.out.println(con);
	            //System.out.println(e.getName());
	         
	            
	            PreparedStatement ps=con.prepareStatement("update daily_milk set quantity=? where cust_id=?");  
	            ps.setInt(1,quantity);  
	            ps.setInt(2,sid);
	            
	            status1 = ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();} 
	        try {
	            Connection con=Dbconnection.connect();
	           // System.out.println(con);
	            //System.out.println(e.getName());
	         
	            
	            PreparedStatement ps=con.prepareStatement("insert into approve_milk values(?,'yes')");  
	            ps.setInt(1,sid);  
	            
	            
	            status2 = ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}
	        System.out.println(status1);
	        System.out.println(status2);
	        if(status2==1)
	        {
	        	try {
					Connection con=Dbconnection.connect();
					PreparedStatement ps=con.prepareStatement("delete from request_user where cust_id=?");
					 ps.setInt(1,sid);   
					
					status1 = ps.executeUpdate(); 
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	
	        }
	        if(status2==1)
	        {
	        	response.sendRedirect("notification.jsp");
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
