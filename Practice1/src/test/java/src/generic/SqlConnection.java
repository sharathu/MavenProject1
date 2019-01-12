/**
 * 
 */
package src.generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//import org.apache.log4j.Logger;

/**
 * *@param args
* @throws InterruptedException
 * This is a generic class which accept the DB name and the query to be run and perform the execution and returns the result.
 */
public class SqlConnection {
	
	
	public static ArrayList<String> sql(String DBName,String DBServer, String Un, String Pwd, String Query, String QueryType) throws SQLException,ClassNotFoundException
	{
		//Register JDBC driver and the server url
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		//Open a connection
		Connection con=DriverManager.getConnection("jdbc:sqlserver://"+DBServer+":1433;databaseName="+DBName, Un, Pwd);
		
		if(QueryType.toLowerCase().equals("select"))
		{
		try{
		//Register JDBC driver and the server url
		//Class.forName("com.mysql.jdbc.Driver");
		//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//Open a connection
		//jdbc:mysql://localhost:3036/emp
		//Connection con=DriverManager.getConnection("jdbc:mysql://10.130.13.123:8886/"+DBName, "sa", "N3xtG3n2014");
		//Connection con=DriverManager.getConnection("jdbc:sqlserver://"+DBServer+":1433;databaseName="+DBName, Un, Pwd);
		
		//To create the statement and get the JVM ready for the query execution
		Statement stmt= con.createStatement();
		
		//Running the query and storing the result in ResultSet
		ResultSet result= stmt.executeQuery(Query);
		
		//Getting the meta data list out of the result stored in ResultSet
		ResultSetMetaData metadata= result.getMetaData();
		
		// Queried data retrieval out of the ResultSet
		int columncount= metadata.getColumnCount();
		ArrayList<String> exeResult= new ArrayList<String>();
		//System.out.println(result);
		//System.out.println(columncount);
		
		while(result.next())
		{
			for(int i=1;i<=columncount;i++)
			{
				
				//System.out.println(metadata.getColumnName(i)+"  "+result.getString(i));
				 exeResult.add(result.getString(i));		
				
			}
			
		}
		
		stmt.close();
		con.close();
		return exeResult;
		//return null;
	}
	catch (Exception e)
	{
		e.printStackTrace();
		System.out.println("this is the catch block");
	}
		
	}
	
	else if (QueryType.toLowerCase().equals("update")^QueryType.toLowerCase().equals("delete")^QueryType.toLowerCase().equals("insert"))
	{
		//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//Connection con=DriverManager.getConnection("jdbc:sqlserver://"+DBServer+":1433;databaseName="+DBName, Un, Pwd);
		PreparedStatement statement= con.prepareStatement(Query);
		statement.executeUpdate();
		  //System.out.println("Query has been suceessfully executed");
		   ArrayList<String> s= new ArrayList<String>();
				  s.add("Query has been suceessfully executed") ;
		   return s;
	}
		return null;
	}
	
	public static void main(String[]sharath) throws ClassNotFoundException, SQLException
	{
		Date date = new Date();
		SimpleDateFormat format= new SimpleDateFormat("ddMMyy");
		String today= format.format(date);
		System.out.println(today);
		
		sql("pp27fallint","10.130.13.123","sa","N3xtG3n2014","update ngweb_account_email set email_address='skenrollment"+today+"@nextgen.com' where email_address='sharathu@nextgen.com'","update");
		
	}
	

}
