package admin_servlet;



import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class forgotpassword1
 */
public class forgotpassword_admin1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forgotpassword_admin1() {
        super();
        // TODO Auto-generated constructor stub
    }
    int id;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	   

		// TODO Auto-generated method stub
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        HttpSession session=request.getSession();  
        String n=(String)session.getAttribute("uname");
        System.out.println(n);
        
        //int cust_id=Integer.parseInt(request.getParameter("username")); 
        String password=request.getParameter("pws");
        //String password="Aman@123";
        int id1=Integer.parseInt(n);
        //int id=Integer.parseInt(request.getParameter("id"));
        System.out.println("N: "+id1);
       //out.print(e.getcust_id());
        //int status=0;  
        //int cust_id1=Integer.parseInt(request.getParameter("username"));  
        //String password=request.getParameter("pws"); 
        //String cust_id=null;
//         cust_id=(String)request.getAttribute(cust_id);
       //int cust_id1=Integer.parseInt(cust_id);
        //out.print(cust_id);
        int status=0;  
        try{  
            Connection con=Dbconnection.connect();  
            PreparedStatement ps=con.prepareStatement("update customer_register set password=?  where cust_id=?");  
              
            ps.setString(1,password);  
            ps.setInt(2,id1);
            // ps.setString(3,e.getEmail());  
        
            //ps.setInt(5,e.getcust_id());  
              
            status=ps.executeUpdate();  
                
        }catch(Exception ex){ex.printStackTrace();}
        
        if(status==0)
        {
        	out.print("not updated ");
        }
        else
        {
        	
        	response.sendRedirect("login.html");
        	//out.print(id1);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.getRequestDispatcher("forgot.html").include(request, response);
		//doGet(request, response);
		//id=Integer.parseInt(request.getParameter("id"));
	}

}
