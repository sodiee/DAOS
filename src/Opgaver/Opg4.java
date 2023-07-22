package Opgaver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Opg4 {
    public static void main(String[] args) {
        try {
            Connection minConnection;
            minConnection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost;databaseName=Tidsregistreringsopgave;user=sa;password=reallyStrongPwd123");

            String sql = "execute medarbejdernavnogmobil";// preparedStatement
            PreparedStatement prestmt = minConnection.prepareStatement(sql);

            ResultSet res = prestmt.executeQuery();
            while (res.next()) {
                System.out.println(res.getString("navn") + " " + res.getString("mobil"));
            }
            if (prestmt != null)
                prestmt.close();
            if (minConnection != null)
                minConnection.close();
        } catch (Exception e) {
            System.out.println("fejl:  " + e.getMessage());
        }
    }
}
