package Opgaver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class Opg3 {
    public static void main(String[] args) {

        try {
            System.out.println("Find medarbejders mobilnummer ");
            BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Indtast navn: ");
            String navn = inLine.readLine();

            Connection minConnection;
            minConnection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost;databaseName=Tidsregistreringsopgave;user=sa;password=reallyStrongPwd123");

            String sql = "select mobil from medarbejder where medarbejder.navn = ?";// preparedStatement
            PreparedStatement prestmt = minConnection.prepareStatement(sql);
            prestmt.clearParameters();

            prestmt.setString(1, navn);

            ResultSet res = prestmt.executeQuery();
            res.next();
            System.out.println(res.getString("mobil"));

            if (prestmt != null)
                prestmt.close();
            if (minConnection != null)
                minConnection.close();
        } catch (Exception e) {
            System.out.println("fejl:  " + e.getMessage());
        }
    }
}
