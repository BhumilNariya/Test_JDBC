import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataUpdata {
    public static void main(String args[]){
        String URL="jdbc:mysql://localhost:3306/bhumil";
        String user="root";
        String password="Admin@123";
        String query="UPDATE employess SET job_title='Full stack developer' , salary=6000000 WHERE id=2";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded Succesfully");
        } catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection connection= DriverManager.getConnection(URL,user,password);
            System.out.println("Connectiion Established Succesfully");
            Statement statement= connection.createStatement();
            int rowsaffected = statement.executeUpdate(query);

            if(rowsaffected>0){
                System.out.println("data update successfully");
            } else{
                System.out.println("date updation failed");
            }


            statement.close();
            connection.close();
            System.out.println("Connection Closed Succesfully!!");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
