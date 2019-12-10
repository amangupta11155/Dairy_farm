package niit_servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.utilities.Dbconnection;

/**
 * Servlet implementation class request
 */
public class request extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public request() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 int status1 = 0;
		// String quantity=request.getParameter("Quantity");
		int quantity=Integer.parseInt(request.getParameter("Quantity"));
		//int cust_id=1;
		HttpSession session=request.getSession();  
	        String n=(String)session.getAttribute("uname");
	        int cust_id=Integer.parseInt(n);
	        System.out.println(cust_id);
       
	        System.out.println(quantity);
		 try {
		            Connection con=Dbconnection.connect();
		           // System.out.println(con);
		            //System.out.println(e.getName());
		         
		            
		            PreparedStatement ps=con.prepareStatement("insert into request_user(cust_id,quantity) values(?,?)");  
		            ps.setInt(2,quantity);  
		            ps.setInt(1,cust_id);
		            
		            status1 = ps.executeUpdate();  
		              
		            con.close();  
		        }catch(Exception ex){ex.printStackTrace();}  
		        System.out.println(status1);
		        if(status1==1)
		        {
		        	response.sendRedirect("cart.jsp");
		        }
		        else
		        {
		        	response.sendRedirect("cart.jsp");
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
