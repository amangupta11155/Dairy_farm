package niit_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.utilities.Dbconnection;

import niit_utilities.Emp;

/**
 * Servlet implementation class forgotpassword
 */
public class forgotpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forgotpassword() {
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
      String username=request.getParameter("username");
        int cust_id=Integer.parseInt(username);
        HttpSession session=request.getSession();  
        session.setAttribute("uname",username);  
       // String password=request.getParameter("pws");  
        //int status=0;  
//        int cust_id1=Integer.parseInt(request.getParameter("username"));  
        //String password=request.getParameter("pws"); 
        Emp e=new Emp();
        String s1="aman";
	          //e.setcust_id(cust_id);
	        try{  
	            Connection con=Dbconnection.connect();  
	            PreparedStatement ps=con.prepareStatement("select cust_id from customer_register where cust_id=?");
	            ps.setInt(1,cust_id);  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                 
	               e.setcust_id(rs.getInt(1));  
	               // e.setName(rs.getString(1));  
	                //e.setPassword(rs.getString(1));  
	                //e.setEmail(rs.getString(4));  
	                  
	              // e.setcust_id(cust_id);
	            }  
	             System.out.println("NIHIL: "+e.getcust_id());
	             
	        }catch(Exception e1){e1.printStackTrace();}  
	        if(cust_id==e.getcust_id())
	        {
	       
//	        	request.setAttribute("cust_id",s1 );
	        	//ut.print(e.getcust_id());
//	        	response.sendRedirect("forgot.html");

	        	//RequestDispatcher requestDispatcher=request.getRequestDispatcher("forgotpassword1?id="+e.getcust_id());
	             //requestDispatcher.forward(request, response);
	             //request.getRequestDispatcher("forgot.html").include(request, response); 
	        	response.sendRedirect("forgot.html");

	        }
	        else
	        {
	        	 request.getRequestDispatcher("Enterid.html").include(request, response);  
	        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
