import java.sql.*;

public class insertDatabase {
    public static String insertMethod() {
        String url = "jdbc:mysql://localhost:3306/db_javaapi?useSSL=false";
        String user = "root";
        String password = "";

        try {
            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                System.out.println("Connection Database Succes");
                String dbScriptInsert = "INSERT INTO java_table (idTransaksi, idPembayaran, status) VALUES ('PSN006','PMB0016','Success')";
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                statement.executeUpdate(dbScriptInsert);
                System.out.println("Insert to database is success");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }
}
