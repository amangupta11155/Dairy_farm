package niit_utilities;

import java.sql.Date;

public class Emp {  
	 
		private String name,password,email;
		private Date date;
		private int Mobile;
		private long m;		
	public long getM() {
			return m;
		}
		public void setM(long m) {
			this.m = m;
		}
	private	int cust_id,Quantity,milk,ammount;
	
 
		
	public void setDate(Date date)
	{
		this.date=date;
	}
	public Date getDate()
	{
		return date;
	}
	public void setQuantity(int Quantity)
	{
		this.Quantity=Quantity;
	}
	public int getQuantity()
	{
		return Quantity;
	}
	public void setAmmount(int string)
	{
		this.ammount=string;
	}
	public int getAmmount()
	{
		return ammount;
		
	}
	
	
		public void setcust_id( int cust_id) {  
		    this.cust_id= cust_id;  
		}  
		public String getName() {  
		    return name;  
		}  
		public void setName(String name) {  
		    this.name = name;  
		}  
		public String getPassword() {  
		    return password;  
		}  
		public void setPassword(String password)
		{
			this.password=password;
		}
		
		public String getEmail() {  
		    return email;  
		}  
		public void setEmail(String email) {  
		    this.email = email;  
		}  
		  
		
		public int getcust_id() {
			
			return cust_id;
		}
		public int getMobile() {
			// TODO Auto-generated method stub
			return Mobile;
		}
		public void setMobile(int number) {
			// TODO Auto-generated method stub
			this.Mobile = number;
		}
		public void setMilk(int milk) {
			// TODO Auto-generated method stub
			this.milk=milk;
		}  
		public int getMilk()
		{
			return milk;
			
		}
		  
		} 


