package UnUsedPacakge_ForPractice_com.CompName.SDET_Nov_2019;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dataBaseDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/automationtalks", "automationtalks", "automationtalks");
		Statement stmt = conn.createStatement();
		//ResultSet res = stmt.executeQuery("SELECT * FROM `Users` WHERE Name = 'Prakash'");
		ResultSet res = stmt.executeQuery("SELECT * FROM `Users`");

		while(res.next()) {
			System.out.println("Name from DB is: "+res.getString("Name"));
			System.out.println("Email from db is: "+res.getString("Email"));
		}
	}

}
