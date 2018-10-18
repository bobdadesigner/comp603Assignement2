/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp603assignment2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xuchang
 */
public class DataSeeder {

    public static void main(String[] args) {
        final String url = "jdbc:derby:QueDB;create=true";  //url of the DB host
        final String username = "pdc";  //your DB username
        final String password = "pdc";   //your DB password
        Statement statement;
        ResultSet rs;

        try {

            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException ex) {

            Logger.getLogger(DataSeeder.class.getName()).log(Level.SEVERE, null, ex);
        }
                      
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            
            statement = conn.createStatement();
            checkTableExisting(conn, "QUESTIONS");
            statement.executeUpdate("CREATE TABLE QUESTIONS (QUESTION_ID INT, Question VARCHAR(1023), A VARCHAR(50), B VARCHAR(50), C VARCHAR(50), D VARCHAR(50), ANSWER VARCHAR(50))");

            statement.executeUpdate("INSERT INTO QUESTIONS VALUES (1, 'Which animale is suitable as a pet?', 'Snake', 'elephant', 'Dog', 'Lion', 'Dog'), " // Insert Values into BOOK table
                    + "(2, 'Which disease devastated livestock across the UK during 2001?', 'Hand-and-foot', 'Foot-in-mouth', 'Hand-to-mouth', 'Foot-and-mouth', 'Foot-and-mouth'), "
                    + "(3, 'Which of these kills its victims by constriction?', 'Andalucia', 'Anaconda', 'Andypandy', 'Annerobinson', 'Anaconda'), "
                    + "(4, 'Which number is the greatest?', 'One', 'Zero', 'Half', 'Two', 'Two') ");
conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void checkTableExisting(Connection conn, String newTableName) {
        try {
            System.out.println("check existing tables.... ");
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);//types);
            Statement dropStatement = null;

            while (rsDBMeta.next()) {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                System.out.println("found: " + tableName);
                if (tableName.compareToIgnoreCase(newTableName) == 0) {
                    System.out.println(tableName + "  needs to be deleted");
                    String sqlDropTable = "DROP TABLE " + newTableName;
                    dropStatement = conn.createStatement();
                    dropStatement.executeUpdate(sqlDropTable);
                    System.out.println("table deleted");
                }
            }
            if (rsDBMeta != null) {
                rsDBMeta.close();
            }
            if (dropStatement != null) {
                dropStatement.close();
            }

        } catch (SQLException ex) {
        }

    }
}
