package niit_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.utilities.Dbconnection;

import niit_utilities.Emp;

/**
 * Servlet implementation class customertable
 */
public class customertable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public customertable() {
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
		//System.out.println(date1);
		String start1 = request.getParameter("start");
		String end1=request.getParameter("end");
		  //String start="2019-11-17";
		  //String end="2019-11-20";
		System.out.println(start1);
		
		 List<Emp> list=new ArrayList<Emp>();  
		 
		    try{  
		        Connection con=Dbconnection.connect();  
		        PreparedStatement ps=con.prepareStatement("select * from customer_table where date >=? and date <=?");  
		        ps.setString(1,start1);
		        ps.setString(2,end1);
		        System.out.println(start1);
		        ResultSet rs=ps.executeQuery();
		        //System.out.println(rs);
		        while(rs.next()){  
		            Emp e=new Emp();  
		           // e.setuser_id(rs.getInt(1));  
		            e.setDate(rs.getDate(1));  
		            e.setAmmount(rs.getInt(3));
		            e.setQuantity(rs.getInt(2));
		            //e.setEmail(rs.getString(4));  
		           System.out.println(rs.getDate(1)+""+rs.getInt(2)+""+rs.getString(3));
		           
		            list.add(e);  
		        }  
		        
		        
		        con.close();  
		    }catch(Exception e){e.printStackTrace();}  
		    out.print("<table border='1' width='100%'");  
	        out.print("<tr><th>date</th><th>quantity</th><th>ammount</th></tr>");  
	        for(Emp e:list){
	        	System.out.println(e.getAmmount());
	         out.print("<tr><td>"+e.getDate()+"</td><td>"+e.getQuantity()+"</td><td>"+e.getAmmount()+"</td> <td></tr>");  
	        }  
	        out.print("</table>");  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
