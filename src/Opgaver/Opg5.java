package Opgaver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Opg5 {
    public static void main(String[] args) {

        try {
            System.out.println("Opret en tidsregistrering: ");
            BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Indtast starttid: HH:MM ");
            String startTid = inLine.readLine();
            System.out.println("Indtast sluttid: HH:MM ");
            String slutTid = inLine.readLine();
            System.out.println("Indtast beskrivelse af arbejdet: ");
            String beskrivelse = inLine.readLine();
            System.out.println("Indtast dato: YYYY/MM/DD");
            String dato = inLine.readLine();
            System.out.println("Indtast medarbejderNr: ");
            String medarbejderNr = inLine.readLine();
            System.out.println("Indtast opgaveNr");
            String opgaveNr = inLine.readLine();
            System.out.println("Medarbejder oprettet");


            Connection minConnection;
            minConnection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost;databaseName=Tidsregistreringsopgave;user=sa;password=reallyStrongPwd123");

            String sql = "insert into tidsregistrering values (?, ?, ?, ?, ?, ?)";// preparedStatement
            PreparedStatement prestmt = minConnection.prepareStatement(sql);
            prestmt.clearParameters();

            prestmt.setString(1, startTid);
            prestmt.setString(2, slutTid);
            prestmt.setString(3, beskrivelse);
            prestmt.setString(4, dato);
            prestmt.setString(5, medarbejderNr);
            prestmt.setString(6, opgaveNr);

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
