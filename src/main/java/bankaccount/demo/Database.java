package bankaccount.demo;

import java.sql.*;

public class Database {

    private final String url = "jdbc:postgresql://localhost/account";
//    private final String user = "postgres";
//    private final String password = "<add your password>";


    // Connect to the database and return a connection object
    public Connection conncet(){
        Connection conn = null;
        try{
            // Establishes the connection and lets the user know connection has been established
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to account established");
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } return conn;
    }

    public void addToDb(String name, int accountNumber, int sortCode, int pin, double balance){
        // Establishes the connection to the database
        Connection conn = this.conncet();
        // Creates the SQL query and save it to a string variable
        String sql = "INSERT INTO details VALUES ('" + name + "', '" + accountNumber + "', '" + sortCode + "', '" + pin + "', '" + balance + "');";
        try {
            // Created a new statement object to use in carrying out the query
            Statement stmt = conn.createStatement();
            // Execute the SQL insert statement
            stmt.executeUpdate(sql);
            //The code below closes the connection, (you wouldn't be able to run another query until this is done)
            stmt.close();
            conn.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Record successfully created");
    }

    public double readBalance(int accountNumber){
        //Establish the connection to the database
        Connection conn = this.conncet();
        //Create the SQL query
        String sql = "SELECT * FROM details WHERE account = " + accountNumber + ";";
        //Created a variable below to store the result I'm expecting
        double balance = 0.0;
        try {
            // Created a new statement object to use in carrying out the query
            Statement stmt = conn.createStatement();
            // Created a result object for handling the result of the query
            ResultSet rs = stmt.executeQuery(sql);
            //The .next() method needs to be called before you can access the result
            rs.next();
            balance = rs.getDouble("balance");
            //The code below closes the connection, (you wouldn't be able to run another query until this is done)
            stmt.close();
            conn.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Record successfully created");
        //Added just to test it's got the balance as the return doesn't print to the screen
        System.out.println(balance);
      return balance;

    }

    // Created a main method so I could run some commands and see the results
    public static void main(String[] args) {
        Database db = new Database();
        db.conncet();
        db.readBalance(654321);
    }


}
