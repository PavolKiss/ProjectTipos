package sk.akademiasovy.tipos.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class MySQL {
    private final String url = "jdbc:mysql://localhost:3306/";
    private final String dbName = "tipos";
    private final String driver = "com.mysql.jdbc.Driver";
    private final String userName1 = "user1";
    private final String userName2 = "user2";
    private final String password = "secret";

    private Connection conn;

    public void testConnection() {
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName1, password);
            if (conn == null) {
                System.out.println("Connection failed");
            } else
                System.out.println("Connection success");
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: I cannot connect to the database");
        }

    }

    public boolean insertValuesIntoDrawHistory(int arr[]) {
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName1, password);
            String cmd = "INSERT into draw_history(boll1,boll2,boll3,boll4,boll5) ";
            cmd += "VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(cmd);
            preparedStatement.setInt(1, arr[0]);
            preparedStatement.setInt(2, arr[1]);
            preparedStatement.setInt(3, arr[2]);
            preparedStatement.setInt(4, arr[3]);
            preparedStatement.setInt(5, arr[4]);
            preparedStatement.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: I cannot connect to the database");
        }
        return true;
    }

    public void getNewBets(){
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName2, password);
            String cmd = "SELECT * FROM bets "+
                    "INNER JOIN bet_details ON bets.id=bet_details.idb"+
                    "WHERE bets.draw_id IS NULL";
            PreparedStatement preparedStatement=conn.prepareStatement(cmd);
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
