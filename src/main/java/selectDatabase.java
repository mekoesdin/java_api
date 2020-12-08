import java.sql.*;

public class selectDatabase {
    public static void main(String[] args){

//        insertDatabase.insertMethod();

        String url = "jdbc:mysql://localhost:3306/db_javaapi?useSSL=false";
        String user = "root";
        String password = "";

        try{
            try (Connection connection = DriverManager.getConnection(url, user, password)){
                System.out.println("Connection Database Succes");
                String dbScriptSelect="select * from java_table where notif_status=''";
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                ResultSet hasilData=statement.executeQuery(dbScriptSelect);
                while (hasilData.next()){
                    System.out.println(hasilData.getString("idTransaksi"));
                    System.out.println(hasilData.getString("idPembayaran"));

                    //condition
                    if (hasilData.getString("status").equals("Success")){
                        System.out.println("Whatsapp notification send to Customer with transaction status is Success");
                    }else{
                        System.out.println("Whatsapp notification send to Customer with transaction status is Failed");
                    }

                }

                String dbScriptUpdate="UPDATE java_table SET notif_status='sent'";
                Statement statement2 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                statement2.executeUpdate(dbScriptUpdate);
            }
        }catch (SQLException e){
            System.out.println("Connection Database Failed");
            e.printStackTrace();
        }
    }
}
