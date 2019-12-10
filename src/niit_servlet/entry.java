package niit_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.utilities.Dbconnection;



/**
 * Servlet implementation class EntryForm
 */
public class entry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public entry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		String cust_id= request.getParameter("cust_id");
		int sid=Integer.parseInt(cust_id);
	//System.out.println(cust_id);
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		
			//System.out.println(cust_id+""+quantity);
		int ammount=0;
	
		if(quantity==1)
		{
			ammount=40;
		}
		else
		{
			ammount=40*quantity;
		}
		int status=0;
		int status1=0;
		try{  
            Connection con=Dbconnection.connect();
            System.out.println(con);
            //System.out.println(e.getName());
            PreparedStatement ps=con.prepareStatement("insert into entrytable values(?,?,?,curdate())");  
           ps.setInt(1,sid);  
            ps.setInt(3,ammount);  
            ps.setInt(2,quantity);  
            //System.out.println(e.getEmail());
            //System.out.println(e.getPassword());
            System.out.println(cust_id);
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
		try{  
            Connection con=Dbconnection.connect();
            System.out.println(con);
            //System.out.println(e.getName());
            PreparedStatement ps=con.prepareStatement("insert into monthybill values(?,?,curdate())");  
           ps.setInt(1,sid);  
            ps.setInt(2,ammount);  
             
            //System.out.println(e.getEmail());
            //System.out.println(e.getPassword());
            System.out.println(cust_id);
            status1=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();} 
		System.out.println(status);
		System.out.println(status1);
          
        if(status==1)
        {
        	out.print("Succesfully!!");
        	response.sendRedirect("EntryForm.html");
        }
        else
        {
        	out.print("Sorry!");
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
