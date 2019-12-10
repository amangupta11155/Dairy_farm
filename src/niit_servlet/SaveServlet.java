package niit_servlet;

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

import niit_Reposatory.niit_Dao;
import niit_utilities.Emp;

/**
 * Servlet implementation class SaveServlet
 */
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SaveServlet() {
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
	       int milk=Integer.parseInt(request.getParameter("milk"));
	        
	        
	        out.print(password);
	        Emp e=new Emp();  
	         
	        e.setName(name);  
	        e.setPassword(password);  
	        e.setEmail(email); 
	        e.setMobile(number);
	        e.setMilk(milk);
	         //System.out.println(e.getMobile());
	         //System.out.println(e.getEmail());
	          
	       
	        int status=niit_Dao.save(e);  
	        int cust_id = 0;
	        try
	        {
	        	Connection con=Dbconnection.connect();
	            //System.out.println(con);
	            System.out.println(e.getName());
	            PreparedStatement ps=con.prepareStatement("select admin_id from customer_register where cust_email=?");
	            ps.setString(1,email);
	            ResultSet rs=ps.executeQuery();
	            while(rs.next())
	            {
	            	cust_id=rs.getInt(1);
	            }
	        }catch(Exception e1)
	        {
	        	
	        }
	        if(status>0){  
	            out.print("<p>Record saved successfully!</p>"); 
	            out.print("<p>customerId</p>"+cust_id);
	            request.getRequestDispatcher("customer_register.html").include(request, response);  
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
