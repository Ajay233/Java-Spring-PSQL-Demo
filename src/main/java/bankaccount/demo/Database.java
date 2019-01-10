package bankaccount.demo;

import java.sql.*;

public class Database {

    private final String url = "jdbc:postgresql://localhost/account";
    private final String user = "postgres";
    private final String password = "<add your password>";


    // Connect to the database and return a connection object
    public Connection conncet(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to account established");
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } return conn;
    }

    public void addToDb(String name, int accountNumber, int sortcode, int pin, double balance){
        Connection conn = this.conncet();
        String sql = "INSERT INTO details VALUES ('" + name + "', '" + accountNumber + "', '" + sortcode + "', '" + pin + "', '" + balance + "');";
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            conn.commit();
            conn.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Record successfully created");

    }

    public static void main(String[] args) {
        Database start = new Database();
        start.conncet();
        start.addToDb("Person", 22334455, 343434, 2345, 23.96);
    }


}
