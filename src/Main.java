import java.sql.*;
public class Main {
    public static void main(String args[]) throws  ClassNotFoundException {
        String URL="jdbc:mysql://localhost:3306/bhumil";
        String user="root";
        String password="Admin@123";
        String query="select * from employess";
         try{
             Class.forName("com.mysql.jdbc.Driver");
             System.out.println("Driver Loaded Succesfully");
         } catch (ClassNotFoundException e){
             System.out.println(e.getMessage());
         }
         try{
             Connection connection= DriverManager.getConnection(URL,user,password);
             System.out.println("Connectiion Established Succesfully");
             Statement statement= connection.createStatement();;
             ResultSet rs=statement.executeQuery(query);

             while(rs.next()){
                 int id =rs.getInt("id");
                 String name= rs.getString("name");
                 String job_title=rs.getString("job_title");
                 double salary=rs.getDouble("salary");
                 System.out.println(" ");
                 System.out.println("=======");
                 System.out.println("Id :" + id);
                 System.out.println("Name : " +name);
                 System.out.println("Job_Title :"+ job_title);
                 System.out.println("Salary:"+ salary);
             }
             rs.close();
             statement.close();
             connection.close();
             System.out.println("Connection Closed Succesfully!!");
         }catch (SQLException e){
             System.out.println(e.getMessage());
         }
    }
}