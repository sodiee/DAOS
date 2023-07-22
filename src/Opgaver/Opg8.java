package Opgaver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Opg8 {
    public static void main(String[] args) {


        try {
            System.out.println("Opret en TESTTYPE: ");
            BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Indtast testtypenr: ");
            String nummerChar = inLine.readLine();
            System.out.println("Indtast dit fødselsår: ");
            String fødselsårVarchar = inLine.readLine();
            System.out.println("Indtast din alder: ");
            String alderInt = inLine.readLine();
            System.out.println("Indtast vægt: ");
            String vægtDecimal = inLine.readLine();
            System.out.println("Indtast fødselsdag: YYYY/MM/DD");
            String fødselsdagDate = inLine.readLine();
            System.out.println("Indtast køn: Dreng(1) Pige(0)");
            String kønBit = inLine.readLine();
            System.out.println("Testtype oprettet");


            Connection minConnection;
            minConnection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost;databaseName=Tidsregistreringsopgave;user=sa;password=reallyStrongPwd123");

            String sql = "insert into testtype values (?, ?, ?, ?, ?, ?)";// preparedStatement
            PreparedStatement prestmt = minConnection.prepareStatement(sql);
            prestmt.clearParameters();

            prestmt.setString(1, nummerChar);
            prestmt.setString(2, fødselsårVarchar);
            prestmt.setString(3, alderInt);
            prestmt.setString(4, vægtDecimal);
            prestmt.setString(5, fødselsdagDate);
            prestmt.setString(6, kønBit);

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
