package initial;

import java.sql.Connection;
import java.sql.DriverManager;

public class FirstDemo {

	public static void main(String[] args) {
		String jdbcUrl="jdbc:mysql://localhost:3306/MyTables?useSSL=false&serverTimezone=UTC";
        String user="root";
        String pswd="password";
        try
        {
        	Connection myConn=DriverManager.getConnection(jdbcUrl,user,pswd);
        	System.out.println("connected..!");
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
	}

}
