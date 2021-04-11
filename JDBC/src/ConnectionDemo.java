import java.sql.*;

public class ConnectionDemo {
    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Bhaskar Madas\\Desktop\\Java MasterClass Course\\JDBC\\test.db");
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS contacts"
                    + "(name TEXT, phone INTEGER, email TEXT)");

//            statement.execute("INSERT INTO contacts values('Adithya' , '12345' , 'adithyamadas@gmail.com')");
//            statement.execute("INSERT INTO contacts values('Anjali' , '23456' , 'anju@gmail.com')");s
//            statement.execute("INSERT INTO contacts values('Bhaskar' , '456789' , 'bhaskar@gmail.com')");
//            System.out.println(statement.execute("INSERT INTO contacts values('Devika' , '45678' , 'devika@gmail.com')"));

/*            System.out.println(statement.execute("SELECT * FROM contacts"));
            ResultSet rs = statement.getResultSet();*/

            ResultSet rs = statement.executeQuery("SELECT * FROM contacts");
            while (rs.next()) {
                System.out.println(rs.getString("name") + " " + rs.getInt("phone") + " " + rs.getString("email"));
            }

            rs.close();
            statement.close();
            conn.close();

        } catch (SQLException throwables) {
            System.out.println("Error: " + throwables.getMessage());
        }
    }
}
