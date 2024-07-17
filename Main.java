import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // Replace the placeholders with your actual database credentials
        String hostname = "localhost";
        String port = "3306";
        String dbname = "id21869194_nikassignment2";
        String username = "id21869194_adammustafa04";
        String password = "AdamMustafa@04";

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create the connection URL
            String connectionUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbname;

            // Create the connection
            Connection connection = DriverManager.getConnection(connectionUrl, username, password);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a query
            ResultSet resultSet = statement.executeQuery("select * from student");

            // Print the results
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
            }
            // Close the connection
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Error: MySQL JDBC driver not found!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Error code: " + e.getErrorCode());
            System.out.println("SQL state: " + e.getSQLState());
    }
    }
}