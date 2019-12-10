package niit_Reposatory;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.niit.utilities.Dbconnection;

import niit_utilities.Emp;

public class niit_Dao1 {
	 public static int save(Emp e){  
	        int status=0;  
	        try{  
	            Connection con=Dbconnection.connect();
	            System.out.println(con);
	            System.out.println(e.getName());
	            PreparedStatement ps=con.prepareStatement("insert into admin_register(user_name,password,admin_email,mobilenumber) values(?,?,?,?)");  
	            ps.setString(1,e.getName());  
	            ps.setString(2,e.getPassword());  
	            ps.setString(3,e.getEmail());  
	            ps.setInt(4,e.getMobile());
	           // System.out.println(e.getEmail());
	            //System.out.println(e.getPassword());
	            
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
}
