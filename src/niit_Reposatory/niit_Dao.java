package niit_Reposatory;
import java.util.*;

import com.niit.utilities.Dbconnection;
import com.sun.xml.internal.messaging.saaj.soap.ver1_1.Envelope1_1Impl;

import niit_utilities.Emp;

import java.sql.*;

public class niit_Dao {
	  
	      
	    public static int save(Emp e){  
	        int status=0;  
	        try{  
	            Connection con=Dbconnection.connect();
	            //System.out.println(con);
	            System.out.println(e.getName());
	            PreparedStatement ps=con.prepareStatement("insert into customer_register(user_name,password,cust_email,mobilenumber) values(?,?,?,?)");  
	            ps.setString(1,e.getName());  
	            ps.setString(2,e.getPassword());  
	            ps.setString(3,e.getEmail());  
	            ps.setInt(4,e.getMobile());
	            //System.out.println(e.getEmail());
	           // System.out.println(e.getPassword());
	            
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	       int status1 = 0;
	       Emp e1=new Emp();
	       try{  
	            Connection con=Dbconnection.connect();
		
				 PreparedStatement ps1=con.prepareStatement("select cust_id from customer_register where cust_email=?");
		          ps1.setString(1,e.getEmail());
		          ResultSet rs=ps1.executeQuery();  
		         
		            while(rs.next()){  
		            
		            
		                
		            
		               e1.setcust_id(rs.getInt(1)); 
		               System.out.println(rs.getInt(1));
		            }
			}catch(Exception ex){ex.printStackTrace();}
	       System.out.println(e1.getcust_id());
	       try {
	            Connection con=Dbconnection.connect();
	           // System.out.println(con);
	            //System.out.println(e.getName());
	         
	            
	            PreparedStatement ps=con.prepareStatement("insert into daily_milk(cust_id,quantity) values(?,?)");  
	            ps.setInt(2,e.getMilk());  
	            ps.setInt(1,e1.getcust_id());
	            
	            status1 = ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	        System.out.println(status1);
	        return status;  
	    }  
	   
	    
	    public static List<Emp> getAllEmployees(){  
	        List<Emp> list=new ArrayList<Emp>();  
	          
	        try{  
	            Connection con=Dbconnection.connect();  
	            PreparedStatement ps=con.prepareStatement("select * from customer_register");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                Emp e=new Emp();  
	               // e.setuser_id(rs.getInt(1));  
	                e.setName(rs.getString(1));  
	                e.setPassword(rs.getString(2));  
	                //e.setEmail(rs.getString(4));  
	                  
	                list.add(e);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    } 
	   
	}  

