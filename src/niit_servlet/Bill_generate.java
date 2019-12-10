package niit_servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.utilities.Dbconnection;

import niit_utilities.Emp;

/**
 * Servlet implementation class Bill_generate
 */
public class Bill_generate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bill_generate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		 response.setContentType("text/html");  
		 //PrintWriter out1=response.getWriter();  
		 //System.out.println(date1);
		 //String start1 = request.getParameter("start");
		// String end1=request.getParameter("end");
		 //String start="2019-11-17";
		 //String end="2019-11-20";
		 //System.out.println(start1);
		 int cust_id=1;
		 String date = null;
		 Date date1 = null ;
		 List<Emp> list=new ArrayList<Emp>();  
		 try{  
		     Connection con1=Dbconnection.connect();  
		     PreparedStatement ps1=con1.prepareStatement("SELECT date from monthybill where cust_id=? limit 1 ");  
		  ps1.setInt(1,cust_id);
		  
		  ResultSet rs=ps1.executeQuery();
		  while(rs.next())
		  {
			  System.out.println(rs.getString(1));
			  date=(rs.getDate(1)).toString();
		  }
		 
		 }catch(Exception e)
		 {
			 
		 }
//System.out.println(date);
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			try{
			   //Setting the date to the given date
			   c.setTime(sdf.parse(date));
			}catch(Exception e){
				e.printStackTrace();
			 }
			   
			//Number of Days to add
			c.add(Calendar.DAY_OF_MONTH, 1);  
			//Date after adding the days to the given date
			String newDate = sdf.format(c.getTime());  
			//Displaying the new Date after addition of Days
			System.out.println("Date after Addition: "+newDate);





		// System.out.println(date1);
	       DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	      // Date dateobj = new Date();
	       //System.out.println(df.format(dateobj));

	       /*getting current date time using calendar class 
	        * An Alternative of above*/
	       Calendar calobj = Calendar.getInstance();
	      // System.out.println(df.format(calobj.getTime()));
	       String date11=(df.format(calobj.getTime()).toString());
	       System.out.println(date11);
	      
	       if(newDate.equals(date11))
	       {
	    	   System.out.println("inside");
	    	   try{  
	  		     Connection con1=Dbconnection.connect();  
	  		     PreparedStatement ps1=con1.prepareStatement("select sum(price) from entrytable where cust_id=?");
	  		     System.out.println(cust_id);
	  		     ps1.setInt(1,cust_id);
	  		     ResultSet rs1=ps1.executeQuery();
	  		     while(rs1.next())
	  		     {
	  		    	 System.out.println(rs1.getInt(1));
	  		     }
	  		   SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				Calendar c1 = Calendar.getInstance();
				try{
				   //Setting the date to the given date
				   c1.setTime(sdf1.parse(date));
				}catch(Exception e){
					e.printStackTrace();
				 }
				   
				//Number of Days to add
				c1.add(Calendar.MONTH, 1);  
				//Date after adding the days to the given date
				String newDate1 = sdf1.format(c1.getTime());  
				//Displaying the new Date after addition of Days
				System.out.println("Date after Addition: "+newDate1);
	  		    date=newDate1;
	  		    
	    	   }
	    	  
	    	   catch(Exception e)
	  		     {
	  		    	 
	  		     }
	    	   System.out.println(date);
	  		     
	  		      //e.setEmail(rs.getString(4));  
			       //System.out.println(rs1.getInt(1)+""+rs1.getInt(2)+""+rs1.getInt(3)+""+rs1.getDate(4));
			        
			         //list.add(e);
	    	   
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
