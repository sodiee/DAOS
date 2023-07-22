package EksJDBC22T;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectMedlemmer {
	
	public static void main(String[] args) {

		try {
			Connection minConnection; // opretter forbindelse til DB
			minConnection = DriverManager
					.getConnection("jdbc:sqlserver://localhost;databaseName=Klub_Eksempel;user=sa;password=reallyStrongPwd123");

			Statement stmt = minConnection.createStatement();

			ResultSet res = stmt.executeQuery("select * from Medlem"); //returnerer et resultSet og gemmer det i res
			while (res.next()) {
				System.out.println(res.getString(1)+ "\t"  + res.getString(2) + " \t "  + res.getString(3) ); //kolonne index starter ved et, der kan også skrives navnet i stedet
			}

			if (res != null)
				res.close();
			if (stmt != null)
				stmt.close();
			if (minConnection != null)
				minConnection.close();
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}
}
