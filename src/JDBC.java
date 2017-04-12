import java.sql.*;

public class JDBC {
	
	public void addcustomer(String name,String username, String password)
	{
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/RestaurantReservation","root","");
		
		
		Statement statement=connection.createStatement();
		String query="INSERT INTO customers(name,username,password) VALUES('"+name+"','"+username+"','"+password+"')";
		int result=statement.executeUpdate(query);
		
		
		statement.close();
		connection.close();
		
		System.out.println("Sign Up Successful");
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	public boolean checkCustomer(String username,String password)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/RestaurantReservation","root","");
			
			Statement statement=connection.createStatement();
			String query="SELECT password FROM customers WHERE username='"+username+"'";
			ResultSet result=statement.executeQuery(query);
			String pass=null;
			while(result.next())
			{
				pass=result.getString(1);
				
			}
			
			if(pass.equals(password))
			{
					
					return true;
			}
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
		
	}
	
	public void addReservation()
	{
		
	}
}
