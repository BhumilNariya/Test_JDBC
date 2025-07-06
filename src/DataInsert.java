import java.sql.*;

public class DataInsert {
    public static void main(String args[]){
        String URL="jdbc:mysql://localhost:3306/bhumil";
        String user="root";
        String password="Admin@123";
        String query="insert into employess(id , name, job_title, salary) values(3,'jaydip' , 'C.E', 56666)";
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
                System.out.println("data inserted successfully");
            } else{
                System.out.println("date instertion failed");
            }


            statement.close();
            connection.close();
            System.out.println("Connection Closed Succesfully!!");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
