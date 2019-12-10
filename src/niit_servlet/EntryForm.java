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
public class EntryForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntryForm() {
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
		int cust_id=Integer.parseInt(request.getParameter("CustomerId"));
		int quantity=Integer.parseInt(request.getParameter("Quantity"));
	System.out.println(cust_id+""+quantity);
		int ammount=40;
	
		if(quantity>1)
		{
			ammount=ammount*quantity;
		}
		int status=0;
		try{  
            Connection con=Dbconnection.connect();
            System.out.println(con);
            //System.out.println(e.getName());
            PreparedStatement ps=con.prepareStatement("insert into entrytable values (?,?,?,curdate())");  
            ps.setInt(1,cust_id);  
            ps.setInt(2,ammount);  
            ps.setInt(3,quantity);  
            //System.out.println(e.getEmail());
            //System.out.println(e.getPassword());
            
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        if(status==1)
        {
        	out.print("Succesfully!!");
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
