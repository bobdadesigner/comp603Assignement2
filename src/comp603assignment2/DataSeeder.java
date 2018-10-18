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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xuchang
 */
public class DataSeeder {

    public static void main(String[] args) {
        final String url = "jdbc:derby:QueDB;create=true";  //url of the DB host
        final String username = "pdc";  //DB username
        final String password = "pdc";   //\DB password
        Statement statement;
        ResultSet rs;

        try {

            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException ex) {

            Logger.getLogger(DataSeeder.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
        //get connection to DB

            statement = conn.createStatement();
            checkTableExisting(conn, "QUESTIONS");
            statement.executeUpdate("CREATE TABLE QUESTIONS (QUESTION_ID INT, Question VARCHAR(1023), A VARCHAR(50), B VARCHAR(50), C VARCHAR(50), D VARCHAR(50), ANSWER VARCHAR(50))");

            statement.executeUpdate("INSERT INTO QUESTIONS VALUES (1, 'The former punk singer John Lydon was known on stage as Johnny ...?', 'Horrid', 'Rotten', 'Nasty', 'Hateful', 'Rotten'), " // Insert Values into BOOK table
                    + "(2, 'Which disease devastated livestock across the UK during 2001?', 'Hand-and-foot', 'Foot-in-mouth', 'Hand-to-mouth', 'Foot-and-mouth', 'Foot-and-mouth'), "
                    + "(3, 'Which of these kills its victims by constriction?', 'Andalucia', 'Anaconda', 'Andypandy', 'Annerobinson', 'Anaconda'), "
                    + "(4, 'In the UK, VAT stands for value-added ...?', 'Transaction', 'Total', 'Tax', 'Trauma', 'Tax'), "
                    + "(5, 'What are you said to do to a habit when you break it?', 'Throw it', 'Punch it', 'Kick it', 'Eat it', 'Kick it'), "
                    + "(6, 'Where do you proverbially wear your heart, if you show your true feelings?', 'On your collar', 'On your lapel', 'On your cuff', 'On your sleeve', 'On your sleeve'), "
                    + "(7, 'What might an electrician lay?', 'Tables', 'Gables', 'Cables', 'Stables', 'Cables'), "
                    + "(8, 'What would a tattie picker harvest?', 'Raspberries', 'Corn', 'Potatoes', 'Apples', 'Potatoes'), "
                    + "(9, 'Which of these means adequate space for moving in?', 'Elbow room', 'Foot rest', 'Ear hole', 'Knee lounge', 'Elbow room'), "
                    + "(10, 'How is a play on words commonly described?', 'Pan', 'Pin', 'Pen', 'Pun', 'Pun'), "
                    + "(11, 'Which colour is used as a term to describe an illegal market in rare goods?', 'Blue', 'Red', 'Black', 'White', 'Black'), "
                    + "(12, 'Which character was first played by Arnold Schwarzenegger in a 1984 film?', 'The Demonstrator', 'The Instigator', 'The Investigator', 'The Terminator', 'The Terminator'), "
                    + "(13, 'Which of these would a film actor like to receive?', 'Oliver', 'Oscar', 'Oliphant', 'Osbert', 'Oscar'), "
                    + "(14, 'Which of these is a keyboard instrument?', 'Harpsichord', 'Ripcord', 'Pyjama cord', 'Sashcord', 'Harpsichord'), "
                    + "(15, 'What name is given to the person who traditionally attends the groom on his wedding day?', 'Best man', 'Top man', 'Old man', 'Poor man', 'Best man'), "
                    + "(16, 'Which word follows North and South to give the names of two continents?', 'Africa', 'America', 'Asia', 'Australia', 'America'), "
                    + "(17, 'Which country is not an island?', 'Madagascar', 'Cuba', 'Germany', 'Jamaica', 'Germany'), "
                    + "(18, 'Which is not the name of an English county?', 'Lancashire', 'Leicestershire', 'Liverpoolshire', 'Lincolnshire', 'Liverpoolshire'), "
                    + "(19, 'Which of these is a fashionable district of London?', 'Bulgaria', 'Belgravia', 'Belgrade', 'Belgium', 'Belgravia'), "
                    + "(20, 'What name is given to a playing card with a single symbol on it?', 'Whizz', 'Hotshot', 'Ace', 'Star', 'Ace'), "
                    + "(21, 'What would you normally do with a beret?', 'Eat it', 'Play it', 'Sit on it', 'Wear it', 'Wear it'), "
                    + "(22, 'Which of these is a tool for shaping and smoothing wood?', 'Train', 'Plane', 'Car', 'Bike', 'Plane'), "
                    + "(23, 'What do the Americans call what we call sweets?', 'Randy', 'Dandy', 'Sandy', 'Candy', 'Candy'), "
                    + "(24, 'Which of these is a spicy, Cajun chicken or seafood dish?', 'Gumbo', 'Dumbo', 'Bimbo', 'Rambo', 'Gumbo'), "
                    + "(25, 'What would you expect to see at the London Aquarium?', 'Flowers', 'Trees', 'Steam rollers', 'Fish', 'Fish'), "
                    + "(26, 'People who are in a similar unfavourable situation are said to be all in the same ...?', 'Car', 'Plane', 'Boat', 'Tube', 'Boat'), "
                    + "(27, 'According to the old adage, how many lives does a cat have?', 'Five', 'Seven', 'Nine', 'Ten', 'Nine'), "
                    + "(28, 'The Nativity is the story of whose birth?', 'Jesus Christ', 'Elvis Presley', 'Winston Churchill', 'John F Kennedy', 'Jesus Christ'), "
                    + "(29, 'How many moons orbit the Earth?', 'One', 'Two', 'Three', 'Four', 'One'), "
                    + "(30, 'In which country would you expect to be greeted with the word bonjour?', 'Italy', 'France', 'Spain', 'Wales', 'France') ");

            //create questions tables, and put question and answer in to table
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void checkTableExisting(Connection conn, String newTableName) {
        //check if the table is exsting, if not create table, if yes delete and create new
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
