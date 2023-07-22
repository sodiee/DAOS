package Opgaver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Opg6 {
    public static String medarbejderNr = "1000";
    public static void main(String[] args) {


        try {
            System.out.println("Opret en tidsregistrering: ");
            BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Indtast navn: ");
            String Navn = inLine.readLine();
            System.out.println("Indtast stillingsbetegnelse: ");
            String stillingsbetegnelse = inLine.readLine();
            System.out.println("Indtast mobil nummer: ");
            String mobil = inLine.readLine();
            System.out.println("Medarbejder oprettet");


            Connection minConnection;
            minConnection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost;databaseName=Tidsregistreringsopgave;user=sa;password=reallyStrongPwd123");

            String sql = "insert into medarbejder values (?, ?, ?, ?)";// preparedStatement
            PreparedStatement prestmt = minConnection.prepareStatement(sql);
            prestmt.clearParameters();

            int temp = Integer.valueOf(medarbejderNr);
            temp++;
            medarbejderNr = String.valueOf(temp);
            prestmt.setString(1, medarbejderNr);
            prestmt.setString(2, Navn);
            prestmt.setString(3, stillingsbetegnelse);
            prestmt.setString(4, mobil);

            prestmt.executeUpdate();

            if (prestmt != null)
                prestmt.close();
            if (minConnection != null)
                minConnection.close();
        } catch (Exception e) {
            System.out.println("fejl:  " + e.getMessage());
        }
    }
}
