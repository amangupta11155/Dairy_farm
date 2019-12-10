package niit_servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class addtocart
 */
public class addtocart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addtocart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String name=request.getParameter("prod1");
		int price=Integer.parseInt(request.getParameter("price1"));
		System.out.println(name);
		System.out.println(price);
		  //HttpSession session=request.getSession();  
	        //String n=(String)session.getAttribute("uname");
	        //int id=Integer.parseInt(n);
	       
	        
	        	//Connection con;
				//try {
					//con = Dbconnection.connect();
					//PreparedStatement ps=con.prepareStatement("insert into CartTable values(?,?)");
				//} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				//} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				//}
	        	
	        	
	        
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
