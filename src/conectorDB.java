
import java.sql.*;

public class conectorDB {
    public static Connection con() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// digunakan untuk load driver
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");// Menghubungkan data
                                                                                              // base ke vs code
        }

        catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection Failed!\n" + e.getMessage());
        }
        return con;
    }
}