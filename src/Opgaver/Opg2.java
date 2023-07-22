package Opgaver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Opg2 {
    public static void main(String[] args) {
        try {
            Connection minConnection;
            minConnection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost;databaseName=Tidsregistreringsopgave;user=sa;password=reallyStrongPwd123");
            Statement stmt = minConnection.createStatement();
            ResultSet res = stmt.executeQuery("select navn, mobil from medarbejder");
            while (res.next()) {
                System.out.println(res.getString("navn") + " " + res.getString("mobil"));
            }
            if (res != null) {
                res.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (minConnection != null) {
                minConnection.close();
            }
        } catch(Exception e){
            System.out.println("fejl: " + e.getMessage());
        }
    }
}
